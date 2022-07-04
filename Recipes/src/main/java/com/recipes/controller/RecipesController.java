package com.recipes.controller;
import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entities.Recipes;
import com.recipes.exceptions.RecipeNotFoundException;
import com.recipes.repository.IRecipesRepository;
import com.recipes.service.IRecipesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("controller which is range")
public class RecipesController {
	
	
	@Autowired
	IRecipesService recipeService;
	
	@Autowired
	IRecipesRepository recipeRepository;

	Logger logger = LoggerFactory.getLogger(RecipesController.class);
	
	public RecipesController() {
		logger.info("-----> Inside Recipe Service Controller Working!");
	}
	
	
	/*@PostMapping : It is used for mapping HTTP POST requests onto specific handler methods.*/
	@ApiOperation("Add recipe details")
	@PostMapping("/addRecipe")
	public ResponseEntity<?> createRecipe(@RequestBody Recipes recipe) throws RecipeNotFoundException {
	Optional<Recipes> opt = recipeRepository.findByName(recipe.getName());
	if (opt.isPresent()) {
		logger.info("Recipe with ID {} is already EXISTS", recipe.getRecipeId());
		throw new RecipeNotFoundException("Recipe already exists");
	} 
	else {
	recipeService.addRecipes(recipe);
	logger.info("Recipe with ID {} is created SUCCESSFULLY", recipe.getRecipeId());
	return new ResponseEntity<>(" Recipe is SUCCESSFULLY added ", HttpStatus.CREATED);
	}
	}

	
	
    /*@GetMapping : It is used for mapping HTTP GET requests onto specific handler methods.*/
	@ApiOperation("Getting all recipe details")
	@GetMapping("/allRecipes")
	public ResponseEntity<?> getAllRecipes() throws RecipeNotFoundException {
	logger.info("Calling Recipe List");
	if (!recipeRepository.findAll().isEmpty()) {
	return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
	} else {
	throw new RecipeNotFoundException("No recipes found in the list ");
	}
	}
	
	

	
	/*@GetMapping : It is used for mapping HTTP GET requests onto specific handler methods.*/
	@ApiOperation("get recipe details by id")
	@GetMapping("/{rid}")
	public ResponseEntity<?> getRecipe(@PathVariable("rid") int rid) throws RecipeNotFoundException {
	Optional<Recipes> opt = recipeRepository.findById(rid);
	if (opt.isPresent()) {
	return new ResponseEntity<>( recipeService.getRecipes(rid), HttpStatus.OK);
	}
	else {
	throw new RecipeNotFoundException(" Recipe with " + rid + " is not found from the list ");
	}
	}
		
	
	

	
	/*@DeleteMapping : This annotation maps HTTP DELETE requests onto specific handler methods*/
	@ApiOperation("delete recipe by its id")
	@DeleteMapping("/recipes/{recipes_id}")
	public ResponseEntity<String> removeRecipes(@PathVariable("recipes_id") int recipeId) throws RecipeNotFoundException {
	 
		Optional<Recipes> opt= recipeRepository.findById(recipeId);
	
		if(opt.isPresent()) {
			recipeService.removeRecipes(recipeId);
			return new ResponseEntity<>("Recipe with id  " +recipeId+ " is deleted",HttpStatus.OK);
		}
		
		else {
			throw new RecipeNotFoundException(" Recipe with id  " +recipeId+ " is not found");
		}
	}
	
	
	
	/*@PutMapping : PUT HTTP method is used to update/modify the resource so @PutMapping 
	annotation is used for mapping HTTP PUT requests onto specific handler methods.*/
	
	@ApiOperation("update recipe by its id")
	@PutMapping("/recipes/{recipes_id}")
	public ResponseEntity<?> updateRecipes(@PathVariable("recipes_id") int recipeId,@RequestBody Recipes recipe) throws RecipeNotFoundException{
		Optional<Recipes> optional = recipeRepository.findById(recipeId);
		logger.info("Updating the recipe with ID {}");
		if(optional.isPresent()) {
		Recipes temp = optional.get();
		temp.setName(recipe.getName());
		temp.setDate(recipe.getDate());
		temp.setInstructions(recipe.getInstructions());
		temp.setRecipeType(recipe.getRecipeType());
		temp.setIngredients(recipe.getIngredients());
		temp.setVeg(recipe.isVeg());
		logger.info(" ID : {} is UPDATED SUCCESSFULLY", recipe.getRecipeId());
		return new ResponseEntity<Recipes>(recipeRepository.save(temp),HttpStatus.OK);
		}
		else {
			logger.info("Recipe with ID {} is NOT FOUND", recipe.getRecipeId());
			throw new RecipeNotFoundException("Recipe id- "+ recipeId +" is not fount in list");
		}	
	}
	


}

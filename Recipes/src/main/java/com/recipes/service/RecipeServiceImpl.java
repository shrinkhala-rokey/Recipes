package com.recipes.service;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipes.entities.Recipes;
import com.recipes.exceptions.RecipeNotFoundException;
import com.recipes.repository.IRecipesRepository;

@Service
@Transactional
public class RecipeServiceImpl implements IRecipesService {

	
	@Autowired
	private IRecipesRepository recipeRepository;
	
	
	@Override
	public List<Recipes> getAllRecipes() {
		List<Recipes> m = new ArrayList<Recipes>();  
		recipeRepository.findAll().forEach(obj -> m.add(obj));  
		return m;
	}
	
	
	@Override
	public Recipes addRecipes(Recipes recipe) {
		return recipeRepository.save(recipe);
	}

	
	@Override
	public void removeRecipes(int recipeId) {
			recipeRepository.deleteById(recipeId);
			
		}
		
		
	@Override
	public Recipes getRecipes(int recipeId) {
		Optional<Recipes> m= recipeRepository.findById(recipeId); 
		if(m.isPresent()) {
			return m.get();
		}
		else {
			throw new RecipeNotFoundException("Recipe not present!!");
		}	
	}


	@Override
	public void updateRecipes(Recipes recipe,int id) {
		recipeRepository.save(recipe);
		
	}

}
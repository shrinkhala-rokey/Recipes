package com.recipes.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.recipes.dto.RecipesDto;
import com.recipes.entities.Recipes;
import com.recipes.service.IRecipesService;



@RestController
public class RecipesController {

	
	@Autowired
	IRecipesService ms;
	
	
	@GetMapping("/recipes")
	public List<Recipes> getAllRecipes() 
	{
		return ms.getAllRecipes();
	}
	
	@PostMapping("/recipes")
	public Recipes addRecipes(@RequestBody RecipesDto c){
		return ms.addRecipes(c); 
		}
	
	
	
	
}

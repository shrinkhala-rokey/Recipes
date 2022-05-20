package com.recipes.service;

import java.util.List;

import com.recipes.dto.RecipesDto;
import com.recipes.entities.Recipes;

public interface IRecipesService {

	
	Recipes addRecipes(RecipesDto res);
	String removeRecipes(int recipeId);
	Recipes updateRecipes(Recipes res);
	Recipes getRecipes(int recipeId);
	List<Recipes> getAllRecipes();
	
}

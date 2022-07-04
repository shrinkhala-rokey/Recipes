package com.recipes.service;

import java.util.List;
import com.recipes.entities.Recipes;
public interface IRecipesService {

	
	Recipes addRecipes(Recipes res);
	void removeRecipes(int recipeId);
	void updateRecipes(Recipes recipe,int id);
	Recipes getRecipes(int recipeId);
	List<Recipes> getAllRecipes();
	
}

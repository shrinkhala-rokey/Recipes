package com.recipes.mapper;

import com.recipes.dto.RecipesDto;
import com.recipes.entities.Recipes;

public class RecipesMapper {

	
	
	public static Recipes toRecipes(RecipesDto recipesdto) {
		Recipes recipes=new Recipes();
		recipes.setRecipeId(recipesdto.getRecipeId());
		recipes.setRecipeName(recipesdto.getRecipeName());
		recipes.setDate(recipesdto.getDate());
		recipes.setInstruction(recipesdto.getInstruction());
		recipes.setVegetarian(recipesdto.getVegetarian());
		recipes.setNoOfPeople(recipesdto.getNoOfPeople());
		return recipes;
	}
	
	
	
	public static RecipesDto toRecipesDto(Recipes recipes) {
		RecipesDto recipesdto=new RecipesDto();
		recipesdto.setRecipeId(recipes.getRecipeId());
		recipesdto.setRecipeName(recipes.getRecipeName());
		recipesdto.setDate(recipes.getDate());
		recipesdto.setInstruction(recipes.getInstruction());
		recipesdto.setVegetarian(recipes.getVegetarian());
		recipesdto.setNoOfPeople(recipes.getNoOfPeople());
		return recipesdto;
	}
	
	
}

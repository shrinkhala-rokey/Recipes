package com.recipes.testcases;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.recipes.entities.Recipes;
import com.recipes.repository.IRecipesRepository;
import com.recipes.service.IRecipesService;

@SpringBootTest
public class TestCases {
	
	@Autowired
	IRecipesService recipeService;

	@MockBean
	IRecipesRepository recipeRepository;
	@Mock
	public static Recipes recipe,recipe1,recipe2;

	@BeforeAll
	public static void setUp() {
		recipe=new Recipes();
		recipe1=new Recipes();
		recipe2=new Recipes();
				
		recipe.setRecipeId(1);
		recipe.setName("Chicken fry");
		recipe.setDate(LocalDate.of(2022,12,10));;
		recipe.setVeg(true);
		
		recipe1.setRecipeId(1);
		recipe1.setName("Chicken fry");
		recipe1.setDate(LocalDate.of(2022,12,10));;
		recipe1.setVeg(true);
		
	}
	
	@Test
	@DisplayName("Test case of create Recipe")
	void createRecipeTest() {
		
		recipeRepository.save(recipe);
		assertNotNull(recipe);

	}
	@Test
	@DisplayName("Positive Test case of create Recipe")
	void createRecipeTest1() {
		
	when(recipeRepository.save(recipe)).thenReturn(recipe);
	assertEquals(recipe, recipeService.addRecipes(recipe));
		
	}
	
	@Test
	@DisplayName("Negative Test case of create Recipe")
	void createRecipeTest2() {
		
	when(recipeRepository.save(recipe)).thenReturn(recipe);
	assertNotEquals(recipe1, recipeService.addRecipes(recipe));
		
	}
	
	@Test
	@DisplayName("positive test case of get all Recipes")
	void getAllRecipesTest() {
		
		List<Recipes> listRecipe = new ArrayList<>();
		
		listRecipe.add(recipe);
		listRecipe.add(recipe1);
		listRecipe.add(recipe2);
		
		when(recipeRepository.findAll()).thenReturn(listRecipe);
		assertEquals(listRecipe.size(), recipeService.getAllRecipes().size());
	}
	
	@Test
	@DisplayName("Negative test case of get all Recipes")
	void getAllRecipesTest1() {
		
		List<Recipes> listRecipe = new ArrayList<>();
		
		listRecipe.add(recipe);
		listRecipe.add(recipe1);
		listRecipe.add(recipe2);
		
		when(recipeRepository.findAll()).thenReturn(listRecipe);
		assertNotEquals(4, recipeService.getAllRecipes().size());
	}
	
	@Test
	@DisplayName("Positive test case for get Recipe")
	void getRecipeTest() {
		
		when(recipeRepository.findById(1)).thenReturn(Optional.of(recipe1));
		
		recipe=recipeService.getRecipes(1);
		
		assertEquals(recipe1.toString(), recipe.toString());

	}
	
	@Test
	@DisplayName("Negative test case for get Recipe")
	void getRecipeTest1() {
		
		when(recipeRepository.findById(2)).thenReturn(Optional.of(recipe1));
		
		recipe=recipeService.getRecipes(2);
		
		assertNotEquals(recipe2.toString(), recipe.toString());

	}

}

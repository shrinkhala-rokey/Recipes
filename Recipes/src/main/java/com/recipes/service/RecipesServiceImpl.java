package com.recipes.service;
import java.util.ArrayList;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipes.dto.RecipesDto;
import com.recipes.entities.Recipes;
import com.recipes.mapper.RecipesMapper;
import com.recipes.repository.IRecipesRepository;

@Transactional
@Service
public class RecipesServiceImpl implements IRecipesService{
	@Autowired
	IRecipesRepository cr;
	Recipes recipes;
	
	
	
	@Override
	public Recipes addRecipes(RecipesDto recipesdto) {
		Recipes customerobj=RecipesMapper.toRecipes(recipesdto);
		return cr.save(customerobj);
	}
	
	
	
	
	@Override
	public String removeRecipes(int recipeId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Recipes updateRecipes(Recipes res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Recipes getRecipes(int recipeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Recipes> getAllRecipes() {
		// TODO Auto-generated method stub
			List<Recipes> m = new ArrayList<Recipes>();  
			cr.findAll().forEach(obj -> m.add(obj));  
			return m;
		
	}
}

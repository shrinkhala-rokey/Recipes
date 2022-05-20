package com.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recipes.entities.Recipes;
@Transactional
@Repository("cr")
public interface IRecipesRepository  extends JpaRepository<Recipes, Integer>{

}

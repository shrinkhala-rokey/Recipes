package com.recipes.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recipes.entities.Recipes;
@Repository
public interface IRecipesRepository  extends JpaRepository<Recipes, Integer>{
	@Query("SELECT r from Recipes r WHERE r.name=:name ")
	public Optional<Recipes> findByName(@Param("name") String name);
}

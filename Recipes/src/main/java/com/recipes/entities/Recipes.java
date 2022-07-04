package com.recipes.entities;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Recipe")
public class Recipes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	int recipeId;
	String name;
	boolean isVeg;
	String recipeType;
	String instructions;
	LocalDate date;

	@OneToMany(targetEntity = Ingrediant.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "recipeId")
	private List<Ingrediant> ingredients;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Ingrediant> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingrediant> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipes [recipeId=" + recipeId + ", name=" + name + ", isVeg=" + isVeg + ", recipeType="
				+ recipeType + ", instructions=" + instructions + ", date=" + date + ", ingredients=" + ingredients
				+ "]";
	}

	public Recipes(int recipeId, String recipeName, boolean isVeg, String recipeType, String instructions,
			LocalDate date, List<Ingrediant> ingredients) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.isVeg = isVeg;
		this.recipeType = recipeType;
		this.instructions = instructions;
		this.date = date;
		this.ingredients = ingredients;
	}

	public Recipes() {
		super();
	}
}

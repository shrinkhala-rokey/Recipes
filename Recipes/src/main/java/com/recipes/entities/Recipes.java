package com.recipes.entities;
import java.io.Serializable;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Recipes implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipeId;
	private String recipeName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	LocalDate date;
	String vegetarian;
	int noOfPeople;
	String instruction;
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "ingId")
	private Ingrendiants ingrendiants;
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}
	public int getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Ingrendiants getIngrendiants() {
		return ingrendiants;
	}
	public void setIngrendiants(Ingrendiants ingrendiants) {
		this.ingrendiants = ingrendiants;
	}

	
}

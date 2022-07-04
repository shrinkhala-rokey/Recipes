package com.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingrediant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int ingredientsid;

	@Column(name="ingredients")
	private String ingredientsnames;
	private String quantity;
	public int getIngredientsid() {
		return ingredientsid;
	}
	public void setIngredientsid(int ingredientsid) {
		this.ingredientsid = ingredientsid;
	}
	public String getIngredientsnames() {
		return ingredientsnames;
	}
	public void setIngredientsnames(String ingredientsnames) {
		this.ingredientsnames = ingredientsnames;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Ingrediant [ingredientsid=" + ingredientsid + ", ingredientsnames=" + ingredientsnames + ", quantity="
				+ quantity + "]";
	}
	public Ingrediant(int ingredientsid, String ingredientsnames, String quantity) {
		super();
		this.ingredientsid = ingredientsid;
		this.ingredientsnames = ingredientsnames;
		this.quantity = quantity;
	}
	public Ingrediant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

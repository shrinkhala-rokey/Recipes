package com.recipes.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrendiants implements Serializable{

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int ingId;
	private HashMap<String,String> ingrendiants=new HashMap<String,String>();
	
	
	public HashMap<String, String> getIng() {
		return ingrendiants;
	}

	public void setIng(HashMap<String, String> ing) {
		this.ingrendiants = ing;
	}

	public int getIngId() {
		return ingId;
	}

	public void setIngId(int ingId) {
		this.ingId = ingId;
	}
	
}

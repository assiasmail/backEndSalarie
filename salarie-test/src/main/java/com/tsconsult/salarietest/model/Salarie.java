package com.tsconsult.salarietest.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Salarie {

	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateNaissance;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateEntree;
	
	

	public Salarie() {
		
	}
	
	

	public Salarie(String nom, String prenom, String adresse, LocalDate dateNaissance, LocalDate dateEntree) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;;
		this.dateEntree = dateEntree;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	
	
	
}

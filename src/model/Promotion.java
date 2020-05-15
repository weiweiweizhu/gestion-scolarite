package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Promotion implements Comparable<Promotion>{

	private int id;
	private static int compteur;
	private String nom;

	public Promotion(String nom) {
//		comptid + compteur;
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Promotion : " + this.nom;
	}

	@Override
	public int compareTo(Promotion o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

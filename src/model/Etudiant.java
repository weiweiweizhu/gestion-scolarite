package model;

import java.util.ArrayList;

public class Etudiant implements Comparable<Etudiant> {
	private String nom;
	private String prenom;
	private static int compteur;
	private int id;
	private ArrayList<Etudiant> etu = new ArrayList<Etudiant>();

	public Etudiant(String nom, String prenom) {
		compteur++;
		id = id + compteur;
		this.nom = nom;
		this.prenom = prenom;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Nom : " + this.nom + " Prenom : " + this.prenom + " ID : " + this.id;
	}

	@Override
	public int compareTo(Etudiant o) {
		int a = this.getNom().compareTo(o.getNom());
		if (a == 0) {
			a = this.getPrenom().compareTo(o.getPrenom());
		}
		return a;
	}

}

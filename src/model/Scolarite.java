package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Scolarite {

	private static HashMap<Promotion, ArrayList<Etudiant>> scola = new HashMap<Promotion, ArrayList<Etudiant>>();
	private static ArrayList<Promotion> promo = new ArrayList<Promotion>();
	private static ArrayList<Etudiant> etu = new ArrayList<Etudiant>();
	private static HashMap<Integer, ArrayList<Integer>> note = new HashMap<Integer, ArrayList<Integer>>();

	private Scolarite() {
	}

	public static void init() {
		System.out.println("----------------------");
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("0 - Quit le program");
		System.out.println("1 - Ajouter / supprimer / lister les promotions");
		System.out.println("2 - Ajouter / supprimer un étudiant à une promotion existante");
		System.out.println("3 - Retrouver un étudiants par son nom et prenom / ID");
		System.out.println("4 - Lister les étudiants d'une promotion dans l'ordre des noms puis prénoms puis id");
		System.out.println("5 - Ajouter des notes à un étudiant");
		System.out.println("6 - Afficher la moyenne des notes d'un étudiant / d'une promotion");
	}

	public static void bye() {
		System.out.println("Au revoir");
	}

	public static void menu1() {
		System.out.println("----------------------");
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("0 - Retour");
		System.out.println("1 - Ajouter une promotion");
		System.out.println("2 - Supprimer une promotion");
		System.out.println("3 - Lister toutes les promotion");
	}

	public static void menu2() {
		System.out.println("----------------------");
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("0 - Retour");
		System.out.println("1 - Ajouter un étudiant à une promotion existante");
		System.out.println("2 - Supprimer un étudiant à une promotion existante");
	}

	public static void menu3() {
		System.out.println("----------------------");
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("0 - Retour");
		System.out.println("1 - Retrouver un étudiants par son nom et prenom");
		System.out.println("2 - Retrouver un étudiant par son id");
	}

	public static void menu6() {
		System.out.println("----------------------");
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("0 - Retour");
		System.out.println("1 - Afficher la moyenne des notes d'un étudiant");
		System.out.println("2 - Afficher la moyenne des notes d'une promotion");
	}

	public static void ajouterPromo() {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez le nom de promotion");
		String nom = in.nextLine();

		Promotion p = new Promotion(nom);
		if (promo.isEmpty()) {
			promo.add(p);
			System.out.println("La promotion " + nom + " est ajoute");

		} else {
			for (int i = 0; i < promo.size(); i++) {
				if (p.getNom().equals(promo.get(i).getNom())) {
					System.out.println("La promotion exsite deja");
					return;
				}
			}
			promo.add(p);
			System.out.println("La promotion " + nom + " est ajoute");
		}
	}

	public static void supprimer() {
		Scanner in = new Scanner(System.in);
		boolean contains = false;
		if (promo.isEmpty()) {
			System.out.println("La liste de promotion est vide");
			return;
		}

		System.out.println("Saisissez le nom de promotion que vous voulez supprimer");
		String nom = in.nextLine();

		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getNom().equals(nom)) {
				promo.remove(i);
				contains = true;
				System.out.println("La promotion " + nom + " est supprime");
			}
		}
		if (!contains) {
			System.out.println("La promotion " + nom + " n'existe pas");
		}
	}

	public static void lister() {
		if (promo.isEmpty()) {
			System.out.println("La liste de promotion est vide");
			return;
		}
		System.out.println("----- Liste de promotion -----");
		for (Promotion pro : promo) {
			System.out.println(pro);
		}
	}

	public static void err() {
		System.out.println("Votre saisie n'est pas correct. Veuillez reessayer");
	}

	public static void ajouterEtudiant() {
		if (promo.isEmpty()) {
			System.out.println("La liste de promotion est vide");
			return;
		}

		Scanner in = new Scanner(System.in);

		System.out.println("Saisissez le nom d'etudiant");
		String nom = in.nextLine();
		System.out.println("Saisissez le prenom d'etudiant");
		String prenom = in.nextLine();

		System.out.println("Saisissez le nom de promotion");
		String pro = in.nextLine();

		for (Promotion promotion : promo) {
			if (pro.equals(promotion.getNom())) {
				if (etu.isEmpty()) {
					Etudiant e = new Etudiant(nom, prenom);
					etu.add(e);
					ArrayList<Integer> notes = new ArrayList<>();
					note.put(e.getId(), notes);
					ArrayList<Etudiant> al = new ArrayList<>();
					al.add(e);
					scola.put(promotion, al);
					System.out.println(e + " est ajoute a " + promotion);
					return;
				} else {
					for (int i = 0; i < etu.size(); i++) {
						if (nom.equals(etu.get(i).getNom()) && prenom.equals(etu.get(i).getPrenom())) {
							System.out.println(nom + " " + prenom + " est deja dans une promotion");
							return;
						}
					}
					ArrayList<Etudiant> value = scola.get(promotion);
					if (value == null) {
						Etudiant e = new Etudiant(nom, prenom);
						etu.add(e);
						ArrayList<Integer> notes = new ArrayList<>();
						note.put(e.getId(), notes);
						ArrayList<Etudiant> al = new ArrayList<>();
						al.add(e);
						scola.put(promotion, al);
						System.out.println(e + " est ajoute a " + promotion);
						return;
					} else {
						Etudiant e = new Etudiant(nom, prenom);
						ArrayList<Integer> notes = new ArrayList<>();
						note.put(e.getId(), notes);
						scola.get(promotion).add(e);
						System.out.println(e + " est ajoute a " + promotion);
						return;
					}
				}

			}
		}
		System.out.println("La promotion " + pro + " n'existe pas");

	}

	public static void listerEtudiantParOrdre() {
		if (etu.isEmpty()) {
			System.out.println("La liste d'etudiant est vide");
			return;
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez le nom de promotion");
		String nom = in.nextLine();

		boolean bool = false;
		Promotion p = new Promotion(nom);
		for (Promotion promotion : promo) {
			if (promotion.getNom().equals(nom)) {
				p = promotion;
				bool = true;
			}
		}

		if (bool) {
			ArrayList<Etudiant> al = scola.get(p);
			Etudiant[] tab = new Etudiant[al.size()];
			for (int i = 0; i < al.size(); i++) {
				tab[i] = al.get(i);
			}
			for (int i = 0; i < al.size(); i++) {
				for (int j = i + 1; j < al.size(); j++) {
					if (tab[i].compareTo(tab[j]) > 0) {
						Etudiant temp = tab[i];
						tab[i] = tab[j];
						tab[j] = temp;
					}
				}
			}

			for (Etudiant etudiant : tab) {
				System.out.println(etudiant);
			}
		} else {
			System.out.println("Cette promo n'exsite pas");
		}

	}

	public static void listerEtudiant() {
		if (etu.isEmpty()) {
			System.out.println("La liste d'etudiant est vide");
			return;
		}

		for (Entry<Promotion, ArrayList<Etudiant>> entry : scola.entrySet()) {
			System.out.println("----- " + entry.getKey() + " -----");

			for (Etudiant etudiant : entry.getValue()) {
				System.out.println("Nom : " + etudiant.getNom());
				System.out.println("Prenom : " + etudiant.getPrenom());
				System.out.println("ID : " + etudiant.getId());

			}
		}

	}

	public static void supprimerEtudiant() {
		listerEtudiant();
		Scanner in = new Scanner(System.in);

		System.out.println("Saisissez le nom de promotion");
		String nom = in.nextLine();

		for (Promotion promotion : promo) {
			if (nom.equals(promotion.getNom())) {
				for (Etudiant etudiant : scola.get(promotion)) {
					System.out.println(etudiant.getNom());
					System.out.println(etudiant.getPrenom());
					System.out.println(etudiant.getId());
				}
				System.out.println("Entrer le nom d'etudiant que vous voulez supprimer");
				String nomEtu = in.nextLine();
				System.out.println("Entrer le prenom d'etudiant que vous voulez supprimer");
				String prenom = in.nextLine();

				for (int i = 0; i < scola.get(promotion).size(); i++) {
					if (scola.get(promotion).get(i).getNom().equals(nomEtu)
							&& scola.get(promotion).get(i).getNom().equals(prenom)) {
						scola.get(promotion).remove(i);

					}
				}
			}
		}

	}

	public static void retrouverEtudiant() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le nom d'eutdiant que vous cherchez");
		String nom = in.nextLine();
		System.out.println("Entrer le prenom d'etudiant que vous cherchez");
		String prenom = in.nextLine();

		for (Entry<Promotion, ArrayList<Etudiant>> entry : scola.entrySet()) {
			for (Etudiant etudiant : entry.getValue()) {
				if (etudiant.getNom().equals(nom) && etudiant.getNom().equals(prenom)) {
					System.out.println(entry.getKey());
					System.out.println("Nom : " + etudiant.getNom());
					System.out.println("Prenom : " + etudiant.getPrenom());
					System.out.println("ID : " + etudiant.getId());
				}
			}
		}

	}

	public static void retrouverEtudiantParId() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez l'ID d'eutdiant que vous cherchez");
		int id = in.nextInt();
		String vide = in.nextLine();

		for (Entry<Promotion, ArrayList<Etudiant>> entry : scola.entrySet()) {
			for (Etudiant etudiant : entry.getValue()) {
				if (etudiant.getId() == id) {
					System.out.println(entry.getKey());
					System.out.println("Nom : " + etudiant.getNom());
					System.out.println("Prenom : " + etudiant.getPrenom());
					System.out.println("ID : " + etudiant.getId());
					return;
				}
			}
		}
		System.out.println("L'etudiant que vous cherchez n'existe pas");
	}

	public static boolean etuExiste(int nb) {
		for (Entry<Promotion, ArrayList<Etudiant>> entry : scola.entrySet()) {
			for (Etudiant etudiant : entry.getValue()) {
				if (etudiant.getId() == nb) {
					return true;
				}
			}
		}
		return false;
	}

	public static void ajouterNotes() {
		listerEtudiant();
		Scanner in = new Scanner(System.in);
		System.out.println("Entrer l'ID d'etudiant que vous cherchez");
		int nb = in.nextInt();
		String vide = in.nextLine();

		if (etuExiste(nb)) {
			if (note.containsKey(nb)) {
				System.out.println("Entrer le note pour cette presonne");
				int n = in.nextInt();
				ArrayList<Integer> al = note.get(nb);
				al.add(n);
				System.out.println("Le note est ajoute");
				return;
			} else {
				System.out.println("Entrer le note pour cette presonne");
				int n = in.nextInt();
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(n);
				note.put(nb, al);
				System.out.println("Le note est ajoute");
				return;
			}
		}
		System.out.println("Cette personne n'exsite pas");
	}

	public static void moyenEtu() {
		listerEtudiant();
		Scanner in = new Scanner(System.in);
		System.out.println("Entrer l'ID d'etudiant que vous cherchez");
		int nb = in.nextInt();
		String vide = in.nextLine();

		if (etuExiste(nb)) {
			if (note.containsKey(nb)) {
				ArrayList<Integer> al = note.get(nb);
				double sum = 0;
				int counter = 0;
				for (Integer leNote : al) {
					sum = sum + leNote;
					counter++;
				}
				double moyen = sum / counter;
				System.out.println("Le note moyen est " + moyen);
				return;
			} else {
				System.out.println("La liste de note est vide pour cette presonne");
				return;
			}
		}
		System.out.println("Cette personne n'exsite pas");
	}

	public static double avgEtu(int nb) {
		ArrayList<Integer> al = note.get(nb);
		double sum = 0;
		int counter = 0;
		double moyen = 0;
		for (Integer leNote : al) {
			if (al.isEmpty()) {
				sum += 0;
			} else {
				sum = sum + leNote;
				counter++;
			}
			moyen = sum / counter;

		}

		return moyen;
	}

	public static void moyenPromo() {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez le nom de promotion");
		String nom = in.nextLine();

		boolean bool = false;
		Promotion p = new Promotion(nom);
		for (Promotion promotion : promo) {
			if (promotion.getNom().equals(nom)) {
				p = promotion;
				bool = true;
			}
		}

		if (bool) {
			double avg = 0;
			ArrayList<Etudiant> al = scola.get(p);
			for (Etudiant etudiant : al) {
				avg += avgEtu(etudiant.getId());
			}
			avg = avg / al.size();
			System.out.println("Le note moyen de la promotion " + nom + " est " + avg);
		} else {
			System.out.println("Cette promo n'exsite pas");
		}

	}

}

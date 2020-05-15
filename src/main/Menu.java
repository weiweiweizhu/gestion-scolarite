package main;

import java.util.Scanner;

import model.Promotion;
import model.Scolarite;

public class Menu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choix;
		boolean continuer = true;

		while (continuer) {
			boolean bool = true;
			Scolarite.init();
			choix = in.nextInt();

			switch (choix) {

			case 0:
				Scolarite.bye();
				continuer = false;
				break;

			case 1:
				while (bool) {
					Scolarite.menu1();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Scolarite.ajouterPromo();
						break;
					case 2:
						Scolarite.supprimer();
						break;
					case 3:
						Scolarite.lister();
						break;
					default:
						Scolarite.err();
						break;
					}
				}
				break;

			case 2:
				while (bool) {
					Scolarite.menu2();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Scolarite.ajouterEtudiant();
						break;
					case 2:
						Scolarite.supprimerEtudiant();
						break;
					default:
						Scolarite.err();
						break;
					}
				}
				break;

			case 3:
				while (bool) {
					Scolarite.menu3();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Scolarite.retrouverEtudiant();
						break;
					case 2:
						Scolarite.retrouverEtudiantParId();
						break;
					default:
						Scolarite.err();
						break;
					}
				}
				break;
			case 4:
				Scolarite.listerEtudiantParOrdre();
				break;
			case 5:
				Scolarite.ajouterNotes();
				break;
			case 6:
				while (bool) {
					Scolarite.menu6();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Scolarite.moyenEtu();
						break;
					case 2:
						Scolarite.moyenPromo();
						break;
					default:
						Scolarite.err();
						break;
					}
				}
				break;

			default:
				Scolarite.err();
				break;
			}

		}

	}

}
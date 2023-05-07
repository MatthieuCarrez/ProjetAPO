// CARREZ Matthieu - TD F et RABY DELPHINEY YALA ARA UDJO TD ? 
// Par soucis de communication, je n'ai pas pu composé avec mon binôme car je n'avais pas ses contacts, de plus j'ai attraper le covid vendredi 2 décembre et ai donc eu des soucis pour travailler sur le projet. J'ai quand même fais au mieux.
public class F2_Carrez_Rabi
{
	// Type agrégé qui réuni les spécificités des bateaux
	static class Flotte
	{
		int taille;
		int colonne;
		int ligne;
		boolean orientation;
		
	}
	
	// Type agrégé qui réuni les spécificités du joueur
	static class Player
	{
		int colonne;
		int ligne;
		int points;
	}
	
	// Saisie de la case que l'on veut choisir pour le placement des navires mais aussi lancer les attaques
	static Player saisirDansIntervalle(Player lo, Flotte bateau1, Flotte bateau2, Flotte bateau3, Flotte bateau4, Flotte bateau5)
	{
		// On applique -64 à la lettre que le joueur choisi étant donner que c'est une lettre majuscule du code ASCII qui est attendu et que la valeur décimale de la lettre 'A' est égale à 65 et que la valeur du 1 est de 1 dans le code ASCII.
		int convAscii = -64;
		Ecran.afficher("Saisissez la colonne : ");
		lo.colonne = Clavier.saisirChar() + convAscii;
		
		// Choix de la colonne de 'A' à 'J'
		while(lo.colonne < 1 || lo.colonne > 10)
		{
			Ecran.afficherln("Erreur de saisie, veuillez choisir une lettre entre A et J");
			lo.colonne = Clavier.saisirChar() + convAscii;
		}
		// Choix de la ligne de 1 à 10
		Ecran.afficher("Saisissez la ligne : ");
		lo.ligne = Clavier.saisirInt();
		
		// Message d'erreur si plus petit que 1 ou plus grand que 10
		while(lo.ligne < 1 || lo.ligne > 10)
		{
			Ecran.afficherln("Erreur de saisie, veuillez choisir un nombre entre 1 et 10");
			lo.ligne = Clavier.saisirInt();
		}
		if(verifTir(lo, bateau1) || verifTir(lo, bateau2) || verifTir(lo, bateau3) || verifTir(lo, bateau4) || verifTir(lo, bateau5))
		{
			Ecran.afficherln("Touché !");
			lo.points = lo.points + 1;
		}
		return lo;
	}
	
	// Saisie de la case que l'on veut choisir pour le placement des navires mais aussi lancer les attaques
	static Player saisirDansIntervalleIa(Player lo, Flotte bateau1, Flotte bateau2, Flotte bateau3, Flotte bateau4, Flotte bateau5)
	{
		// Choix de la colonne de 'A' à 'J' par l'IA
			lo.colonne = (int)(Math.random() * 10 + 1);
		
		// Choix de la ligne de 1 à 10 par l'IA
		lo.ligne = (int)(Math.random() * 10 + 1);
		
		if(verifTir(lo, bateau1) || verifTir(lo, bateau2) || verifTir(lo, bateau3) || verifTir(lo, bateau4) || verifTir(lo, bateau5))
		{
			Ecran.afficherln("L'ennemi vous a touché !");
			lo.points = lo.points + 1;
		}
		return lo;
	}
	
	static boolean verifTir(Player lo, Flotte bateau)
	{
		for (int i = 0; i < bateau.taille; i++)
		{
			if(lo.ligne == bateau.ligne + i && lo.colonne == bateau.colonne + i)
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	static void afficherLo(Player l)
	{
		Ecran.afficherln(l.colonne, l.ligne);
	}
	
	// Placement des bateaux du joueur
	static Flotte placementBateauJoueur(Flotte bateauPlace, Flotte bateau1, Flotte bateau2, Flotte bateau3, Flotte bateau4)
	{
		// On applique -64 à la lettre que le joueur choisi étant donner que c'est une lettre majuscule du code ASCII qui est attendu et que la valeur décimale de la lettre 'A' est égale à 65 et que la valeur du 1 est de 1 dans le code ASCII.
		int convAscii = -64;
		int sens;
		
		Ecran.afficher("Saisissez la colonne : ");
		bateauPlace.colonne = Clavier.saisirChar() + convAscii;
		
		// Choix de la colonne de 'A' à 'J'
		while(bateauPlace.colonne < 1 || bateauPlace.colonne > 10)
		{
			Ecran.afficherln("Erreur de saisie, veuillez choisir une lettre entre A et J");
			bateauPlace.colonne = Clavier.saisirInt() + convAscii;
		}
		// Choix de la ligne de 1 à 10
		Ecran.afficher("Saisissez la ligne : ");
		bateauPlace.ligne = Clavier.saisirInt();
		
		// Choix de l'orientation du bateau
		Ecran.afficherln("Choisissez l'orientation du bateau, saisissez 1 pour Verticale ou 0 pour Horizontale");
		sens = Clavier.saisirInt();
		
		while(sens > 1 || sens < 0)
		{
			Ecran.afficher("Erreur de saisie, veuillez choisir entre 1 et 0");
			sens = Clavier.saisirInt();
		}
		if(sens == 1)
		{
			bateauPlace.orientation = true;
		}
		else
		{
			bateauPlace.orientation = false;
		}
		
		// Message d'erreur si plus petit que 1 ou plus grand que 10
		while(bateauPlace.ligne < 1 || bateauPlace.ligne > 10)
		{
			Ecran.afficherln("Erreur de saisie, veuillez choisir un nombre entre 1 et 10");
			bateauPlace.ligne = Clavier.saisirInt();
		}
		
		// Vérifie que les 'cases' des bateaux déjà placés ne sont pas là où le bateau que l'on place veut se mettre, sinon il change d'endroit
		while(verifColision(bateauPlace, bateau1) == false || verifColision(bateauPlace, bateau2) == false || verifColision(bateauPlace, bateau3) == false || verifColision(bateauPlace, bateau4) == false || verifBordure(bateauPlace) == false)
		{
			Ecran.afficherln("Erreur de saisie, la case choisie est occupée ou le bateau dépasse du plateau de jeu");
			Ecran.afficher("Saisissez la colonne : ");
			bateauPlace.colonne = Clavier.saisirChar() + convAscii;
			
			// Choix de la colonne de 'A' à 'J'
			while(bateauPlace.colonne < 1 || bateauPlace.colonne > 10)
			{
				Ecran.afficherln("Erreur de saisie, veuillez choisir une lettre entre A et J");
				bateauPlace.colonne = Clavier.saisirChar() + convAscii;
			}
			// Choix de la ligne de 1 à 10
			Ecran.afficher("Saisissez la ligne : ");
			bateauPlace.ligne = Clavier.saisirInt();
		
			// Message d'erreur si plus petit que 1 ou plus grand que 10
			while(bateauPlace.ligne < 1 || bateauPlace.ligne > 10)
			{
				Ecran.afficherln("Erreur de saisie, veuillez choisir un nombre entre 1 et 10");
				bateauPlace.ligne = Clavier.saisirInt();
			}
		}
		
		// Affiche à l'écran les coordonnées choisies
		/*Ecran.afficherln(bateauPlace.colonne + "|" + bateauPlace.ligne);*/
		return bateauPlace;
	}
	
	// Placement des bateaux IA
	static Flotte placementBateauIa(Flotte bateauPlace, Flotte bateau1, Flotte bateau2, Flotte bateau3, Flotte bateau4)
	{
		int sens = 0;
		
		bateauPlace.colonne = (int)(Math.random() * 10 + 1);
		bateauPlace.ligne = (int)(Math.random() * 10 + 1);
		sens = (int)(Math.random() * 10 + 1);
		// Défini le sens
		if(sens <= 5)
		{
			bateauPlace.orientation = false;
		}
		else
		{
			bateauPlace.orientation = true;
		}
		
		// Vérifie que les 'cases' des bateaux déjà placés ne sont pas là où le bateau que l'on place veut se mettre, sinon il change d'endroit
		while(verifColision(bateauPlace, bateau1) == false || verifColision(bateauPlace, bateau2) == false || verifColision(bateauPlace, bateau3) == false || verifColision(bateauPlace, bateau4) == false || verifBordure(bateauPlace) == false)
		{
			bateauPlace.colonne = (int)(Math.random() * 10 + 1);
			bateauPlace.ligne = (int)(Math.random() * 10 + 1);
			sens = (int)(Math.random()* 10 + 1);
			
			// Défini le sens
			if(sens <= 5)
			{
				bateauPlace.orientation = false;
			}
			else
			{
				bateauPlace.orientation = true;
			}
		}
		/*Ecran.afficherln(bateauPlace.colonne + "|" + bateauPlace.ligne);*/
		return bateauPlace;
	}
	
	// Vérifie si il y a déjà un bateau sur une des cases
	static boolean verifColision(Flotte bateauPlace, Flotte bateau)
	{
		for (int i = 0; i < bateau.taille; i++)
		{
			for (int j = 0; j < bateauPlace.taille; j++)
			{
				/*Ecran.afficherln(i + "-" + j);*/
				// Bateau horizontal
				if (bateauPlace.colonne + j == bateau.colonne + i && bateauPlace.orientation == false && bateauPlace.ligne == bateau.ligne)
				{
					/*Ecran.afficherln(bateauPlace.ligne + "-" + bateauPlace.colonne);*/
					return false;
				}
				// Bateau vertical
				if (bateauPlace.ligne + j == bateau.colonne + i && bateauPlace.orientation == true && bateauPlace.colonne == bateau.colonne)
				{
					/*Ecran.afficherln(bateauPlace.ligne + "-" + bateauPlace.colonne);*/
					return false;
				}
			}
		}
		return true;
	}
	
	// Vérifie que le bateau ne soit pas en dehors du plateau (partiellement ou complètement)
	static boolean verifBordure(Flotte bateauPlace)
	{
		if(bateauPlace.ligne > 11 || bateauPlace.colonne > 11 || bateauPlace.ligne + bateauPlace.taille > 11 && bateauPlace.orientation == true || bateauPlace.colonne + bateauPlace.taille > 11 && bateauPlace.orientation == false)
		{
			return false;
		}
		return true;
	}
	
	// Affiche simplement les règles au début du programme
	static void afficherRegles()
	{
		Ecran.afficherln("Bataille navale");
		Ecran.sautDeLigne();
		Ecran.afficherln("Les règles sont simples, vous devez faire couler les navires de votre adversaire en premier");
		Ecran.afficherln("Au début de votre tour, vous devrez placer vos navires sur le plateau de jeu");
		Ecran.sautDeLigne();
	}
	
	
	// Affiche le plateau au joueur
	static void afficherPlateau(Player lo)
	{
		Ecran.afficherln("    A  B  C  D  E  F  G  H  I  J");
		for (int i = 1; i <= 10; i++)
		{
			// Evite le décalage de la dixième ligne avec le numéro 10
			if(i < 10)
			{
				Ecran.afficher(" " + i + " ");
			}
			else
			{
				Ecran.afficher(i + " ");
			}
			
			for (int j = 1; j <= 10; j++)
			{
				
				if(j == lo.colonne && i == lo.ligne)
				{
					Ecran.afficher("[x]");
				}
				else
				{
					Ecran.afficher("[ ]");
				}
			}
			Ecran.sautDeLigne();
		}
	}
	// Affiche le plateau avec les bateaux
	static void afficherPlateauBateau(Player lo, Flotte bateau1, Flotte bateau2, Flotte bateau3, Flotte bateau4, Flotte bateau5)
	{
		// Si le le le bateau a été trouvé, ça ne pose pas de case vide, c'est a ça que sert cette variable
		boolean trouve = false;
		Ecran.afficherln("    A  B  C  D  E  F  G  H  I  J");
		for (int i = 1; i <= 10; i++)
		{
			// Evite le decalage de la dixième ligne avec le numero 10
			if(i < 10)
			{
				Ecran.afficher(" " + i + " ");
			}
			else
			{
				Ecran.afficher(i + " ");
			}
            
			for (int j = 1; j <= 10; j++)
			{
				trouve = false;
				trouve = afficherBateau(lo, bateau1, i, j, false, trouve);
				
				trouve = afficherBateau(lo, bateau2, i, j, false, trouve);
				
				trouve = afficherBateau(lo, bateau3, i, j, false, trouve);
				
				trouve = afficherBateau(lo, bateau4, i, j, false, trouve);
				
				trouve = afficherBateau(lo, bateau5, i, j, true, trouve);
				
			}
			Ecran.sautDeLigne();
		}
	}
	
	// Affiche les bateaux et leur longueur sur le plateau
	static boolean afficherBateau(Player lo, Flotte bateau, int ligne, int colonne, boolean afficherVide, boolean trouve)
	{
		if(colonne == bateau.colonne && ligne == bateau.ligne && colonne == lo.colonne && ligne == lo.ligne && trouve == false)
		{
			Ecran.afficher("[o]");
			return true;
		}
		else
		{    
			if(bateau.ligne  <= ligne && ligne <= bateau.ligne + bateau.taille - 1 &&  colonne == bateau.colonne && bateau.orientation == true)
			{
				Ecran.afficher("[e]");
				return true;
			}
			else
			{
				if(colonne == lo.colonne && ligne == lo.ligne && afficherVide == true)
				{
					Ecran.afficher("[x]");
					return true;
				}
				else
				{
					if(bateau.colonne <= colonne && colonne <= bateau.colonne + bateau.taille - 1 && ligne == bateau.ligne && bateau.orientation == false)
					{
						Ecran.afficher("[e]");
						return true;
					}
					else
					{
						if(afficherVide == true && trouve == false)
						{
							Ecran.afficher("[ ]");
						}
					}
				}
				
			}
		}
		return trouve;
	}
	
	
	// MAIN
	public static void main (String [] args)
	{
		// Déclaration des données
		Player lo = new Player();
		Player ia = new Player();
		
		Flotte torpilleurLo = new Flotte();
		Flotte torpilleurIa = new Flotte();
		Flotte sousmarinLo1 = new Flotte();
		Flotte sousmarinIa1 = new Flotte();
		Flotte sousmarinLo2 = new Flotte();
		Flotte sousmarinIa2 = new Flotte();
		Flotte croiseurLo = new Flotte();
		Flotte croiseurIa = new Flotte();
		Flotte porteavionLo = new Flotte();
		Flotte porteavionIa = new Flotte();
		
		// Défini la taille de base des navires
		torpilleurLo.taille = 2;
		torpilleurIa.taille = 2;
		sousmarinLo1.taille = 3;
		sousmarinIa1.taille = 3;
		sousmarinLo2.taille = 3;
		sousmarinIa2.taille = 3;
		croiseurLo.taille = 4;
		croiseurIa.taille = 4;
		porteavionLo.taille = 5;
		porteavionIa.taille = 5;
		
		// Défini la valeur de base de la ligne des bateaux
		torpilleurLo.ligne = -10;
		torpilleurIa.ligne = -10;
		sousmarinLo1.ligne = -10;
		sousmarinIa1.ligne = -10;
		sousmarinLo2.ligne = -10;
		sousmarinIa2.ligne = -10;
		croiseurLo.ligne = -10;
		croiseurIa.ligne = -10;
		porteavionLo.ligne = -10;
		porteavionIa.ligne = -10;
		
		// Défini la valeur de base de la colonne des bateaux
		torpilleurLo.colonne = -10;
		torpilleurIa.colonne = -10;
		sousmarinLo1.colonne = -10;
		sousmarinIa1.colonne = -10;
		sousmarinLo2.colonne = -10;
		sousmarinIa2.colonne = -10;
		croiseurLo.colonne = -10;
		croiseurIa.colonne = -10;
		porteavionLo.colonne = -10;
		porteavionIa.colonne = -10;
		
		// Défini l'orientation de base (false = horizontale, true = verticale)
		torpilleurLo.orientation = false;
		torpilleurIa.orientation = false;
		sousmarinLo1.orientation = false;
		sousmarinIa1.orientation = false;
		sousmarinLo2.orientation = false;
		sousmarinIa2.orientation = false;
		croiseurLo.orientation = false;
		croiseurIa.orientation = false;
		porteavionLo.orientation = false;
		porteavionIa.orientation = true;
		
		// Nombre de points du joueur et de l'IA de base
		ia.points = 0;
		lo.points = 0;
		
		// Calcul
		afficherRegles();
		afficherPlateau(lo);
		Ecran.sautDeLigne();
		
		Ecran.afficherln("L'ordinateur choisi la position de sa flotte");
		
		// Placement de la flotte par l'IA
		// Enlever le commentaire pour laisser l'IA choisir elle même la position des bateaux
		
		torpilleurIa = placementBateauIa(torpilleurIa, sousmarinIa1, sousmarinIa2, croiseurIa, porteavionIa);
		sousmarinIa1 = placementBateauIa(sousmarinIa1, torpilleurIa, sousmarinIa2, croiseurIa, porteavionIa);
		sousmarinIa2 = placementBateauIa(sousmarinIa2, sousmarinIa1, torpilleurIa, croiseurIa, porteavionIa);
		croiseurIa = placementBateauIa(croiseurIa, sousmarinIa1, sousmarinIa2, torpilleurIa, porteavionIa);
		porteavionIa = placementBateauIa(porteavionIa, sousmarinIa1, sousmarinIa2, croiseurIa, torpilleurIa);
		
		afficherPlateauBateau(lo, torpilleurIa, sousmarinIa1, sousmarinIa2, croiseurIa, porteavionIa);
		Ecran.afficherln("Placez vos navires !");
		
		// Placement de chaque bateau par le joueur
		torpilleurLo = placementBateauJoueur(torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		
		sousmarinLo1 = placementBateauJoueur(sousmarinLo1, torpilleurLo, sousmarinLo2, croiseurLo, porteavionLo);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		
		sousmarinLo2 = placementBateauJoueur(sousmarinLo2, sousmarinLo1, torpilleurLo, croiseurLo, porteavionLo);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		
		croiseurLo = placementBateauJoueur(croiseurLo, sousmarinLo1, sousmarinLo2, torpilleurLo, porteavionLo);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		
		porteavionLo = placementBateauJoueur(porteavionLo, sousmarinLo1, sousmarinLo2, croiseurLo, torpilleurLo);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		
		// Partie pour le touché-coulé
		// Pour définir si la partie est encore en cours, il y avait un système de points sur 17 ( le nombre de cases de tous les bateaux combinés) qui définissait la condition de victoire.
		// Modifier la valeur pour raccourcir la partie
		while(lo.points < 17 && ia.points < 17)
		{
			Ecran.afficherln("Choisissez la case où tirer !");
			lo = saisirDansIntervalle(lo, torpilleurIa, sousmarinIa1, sousmarinIa2, croiseurIa, porteavionIa);
			afficherPlateau(lo);
			Ecran.afficherln("L'IA tir !");
			saisirDansIntervalleIa(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
		}
		if(lo.points == 17)
		{
			Ecran.afficherln("Vous avez vaincu votre adversaire !");
		}
		else
		{
			Ecran.afficherln("L'ordinateur à eu raison de vous.");
		}
		afficherPlateauBateau(lo, torpilleurIa, sousmarinIa1, sousmarinIa2, croiseurIa, porteavionIa);
		afficherPlateauBateau(ia, torpilleurLo, sousmarinLo1, sousmarinLo2, croiseurLo, porteavionLo);
	}
}
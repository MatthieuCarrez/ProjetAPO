public class caOuCa
{
    static class Joueur
    {
        String nom;
        char pion;
    }
    static class Plateau
    {
        int hauteur = 6;
        int longueur  = 7;
    }
    static class Choix
    {
        int colonne;
    }

    static Plateau affichageReglesPlateau(Plateau p)
    {   // Affichage des règles
        Ecran.afficherln("PUISSANCE 4");
        Ecran.sautDeLigne();
        Ecran.afficherln("Le but est d'aligner verticalement, horizontalement ou diagonalement quatres pions");
        Ecran.sautDeLigne();
        Ecran.afficherln("Chaque joueur joue a tour de rôle. Il suffit de choisir la colonne dans laquelle vous souhaitez jouer votre pion");
        Ecran.sautDeLigne();
        Ecran.afficherln("Voici le plateau de jeu");
        // Affichage du plateau
        Ecran.afficherln("   1  2  3  4  5  6  7");
        for( int i = 0 ; i < p.hauteur ; i++)
        {
            Ecran.afficher(" |");
            for( int j = 0 ; j < p.longueur ; j++)
            {
                Ecran.afficher("(", " ", ")");
            }
            Ecran.afficherln("| ");
            
        }
        Ecran.afficher("  ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        Ecran.sautDeLigne();
        return p;
    }
    static void identifiantsJoueur(Joueur idJ1, Joueur idJ2)
    {   // Identification de chaque joueur
        Ecran.afficherln("Quel est le nom du joueur 1 ? ");
        idJ1.nom = Clavier.saisirString();
        Ecran.afficherln("Quel est le nom du joueur 2 ? ");
        idJ2.nom = Clavier.saisirString();
        // Choix des pions par le joueur 1 // Pourrait inclure un moyen de tier aléatoirement le joueur qui choisi
        Ecran.afficherln(idJ1.nom, " doit choisir ses pions entre les pions X et O ");
        idJ1.pion = Clavier.saisirChar();
        while( idJ1.pion != 'X' && idJ1.pion != 'O')
        {
            Ecran.afficherln("Erreur de saisie, veuillez choisir entre X et les pions O");
            idJ1.pion = Clavier.saisirChar();
        }
        // Attributions des pions restants au joueur 2
        if( idJ1.pion == 'X' )
        {
            idJ2.pion = 'O';
        }
        else
        {
            idJ2.pion = 'X';
        }
        Ecran.afficherln(idJ1.nom, " a choisi les ", idJ1.pion);
        Ecran.afficherln(idJ2.nom, " a donc les ", idJ2.pion);
    }

    static void choixPlacement(Choix choixJou)
    {
        int res;
        
        Ecran.afficherln("Quelle colonne choisissez-vous ? ");
        choixJou.colonne = Clavier.saisirInt();
        while (choixJou.colonne < 1 || choixJou.colonne > 7)
        {
            Ecran.afficher("Erreur de saisie veuiller choisir une colonne entre 1 et 7 ");
            choixJou.colonne = Clavier.saisirInt();    
        }
        
        

    }
    public static void main(String [] args)
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Plateau pos = new Plateau();
        Choix choix = new Choix();

        affichageReglesPlateau(pos);
        identifiantsJoueur(j1, j2);
        choixPlacement(choix);
    }    
}

public class JeuBlocage
{
	/*class Grille
	{
        int i, j;
		Cellule [][] grille = new Cellule();
        String afficherGrille()
        {
			Ecran.afficher("+------------+");
		    
            for( i = 1 ; i <= grille.length ; i++ )
            {
                for( j = 1 ; j < grille[0].length ; j++ )
                {
                    Ecran.afficher(cVi);
                }
            } return 0;
	    }
    } */

	static class Cellule
	{
		private String cellVide, cellJou, cellIA; // Caractère symbolisant une cellule vide, une cellule Joueur ou une celluleIA
		
		Cellule(String cVi, String cJo, String cIA)
		{
			this.cellVide = cVi;
			this.cellJou = cJo;
			this.cellIA = cIA;
		}
		
		/*Cellule()
		{
			this(".", "O", "#");
		}*/

		String getcellVide()
		{
			return cellVide;
		}
		void setcellVide(String cellVide) {
			this.cellVide = cellVide;
		}
		String getcellJou()
		{
			return cellJou;
		}
		void setcellJou(String cellJou) {
			this.cellJou = cellJou;
		}
		String getcellIA()
		{
			return cellIA;
		}
		void setcellIA(String cellIA) {
			this.cellIA = cellIA;
		}
	}
	
	public static void main(String [] args)
	{
		Cellule cellule = new Cellule(" ", "0", "&");
		String celluleJoueur = cellule.getcellJou();
		String celluleVide = cellule.getcellVide();
		String celluleIA = cellule.getcellIA();

		Ecran.afficherln("Cellule joueur" + " " + celluleJoueur);
		Ecran.afficherln("Cellule vide" + " " + celluleVide);
		Ecran.afficherln("Cellule IA" + " " + celluleIA);
	}
}
public class JeuBlocageTest
{
	/*class Grille
	{
        int i, j;
		
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

		void setCellule(String cVi, String cJo, String cIA)
		{
			this.cellVide = cVi;
			this.cellJou = cJo;
			this.cellIA = cIA;
		}
		
		String getcellIA() {
			return cellIA;
		}
		String getcellJou() {
			return cellJou;
		}
		String getcellVide() {
			return cellVide;
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
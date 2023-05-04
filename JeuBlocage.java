public class JeuBlocage
{
	class Grille
	{
		
	}
	
	class Cellule
	{
		private String cellVide, cellJou, cellIA;
		
		Cellule(String cVi, String cJo, String cIA)
		{
			this.cellVide = cVi;
			this.cellJou = cJo;
			this.cellIA = cIA;
		}
		
		Cellule()
		{
			this(".", "O", "#");
		}
	}
	
	public static void main(String [] args)
	{
		Ecran.afficher("Hello World !");
	}
}
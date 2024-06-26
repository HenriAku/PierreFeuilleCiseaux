/********************************
 * @author HenriAku             *
 * description : Jeu du morpion *
 *******************************/
package metier;
import metier.Objet;

public class Plateau 
{
	private Objet objetJ;
	private Objet objetB;

	private int   ptJ;
	private int	  ptB;

	public Plateau()
	{
		this.objetJ = new Objet();
		this.objetB = new Objet();

		this.ptJ	= 0;
		this.ptB	= 0;
	}

	//Getteur
	public String getObjetJ(){return this.objetJ.getType();}
	public String getObjetB(){return this.objetB.getType();}
	public int	  getPtJ   (){return this.ptJ;}
	public int	  getPtB   (){return this.ptB;}


	public String lancerPartie()
	{
		String sRet = "";

		sRet =  "Le bot a fait sont choix. \n";
		sRet += "Fait ton choix : ";

		return sRet;
	}

	public void jouer(String type)
	{
		this.objetJ.setType(type);

		int tmp = (int) ((Math.random() * 6) + 1);

		switch (tmp) 
		{
			case 1 -> this.objetB.setType("ciseaux");
			case 2 -> this.objetB.setType("feuille");
			case 3 -> this.objetB.setType("pierre" );
		}
	}

	public String win()
	{
		if (this.objetJ.getType().equals("ciseaux") && this.objetB.getType().equals("feuille" )|| 
			this.objetJ.getType().equals("pierre" ) && this.objetB.getType().equals("ciseaux" )||
			this.objetJ.getType().equals("feuille") && this.objetB.getType().equals("pierre"  ) )
		{
			this.ptJ++;
			return "vous avez gagnez";
		}else
		{
			this.ptB++;
			return "vous avez perdus";
		}
	}

	public String affiche()
	{
		String sRet = "";

		sRet = "Bot : \t vs \t Joueur : \n";
		sRet += this.objetB.getType() +"\t\t "+ this.objetJ.getType();

		return sRet;
	}

}
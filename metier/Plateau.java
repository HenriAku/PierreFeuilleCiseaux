

public class Plateau 
{
	private Objet objetJ;
	private Objet objetB;

	public Plateau()
	{
		this.objetJ = new Objet();
		this.objetB = new Objet();
		System.out.println("---->");
	}

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
			case 3 -> this.objetB.setType("piere");
		}
	}

	public String win()
	{
		if (this.objetJ.getType().equals("ciseaux") && this.objetB.getType().equals("feuille" )|| 
			this.objetJ.getType().equals("pierre" ) && this.objetB.getType().equals("ciseaux" )||
			this.objetJ.getType().equals("feuille") && this.objetB.getType().equals("pierre"  ) )
		{
			return "vous avez gagnez";
		}else
		{
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
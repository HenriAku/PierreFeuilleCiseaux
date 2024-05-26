package metier;
import metier.Plateau;

public class Test 
{
	public static void main(String[] args) 
	{
		Plateau plt = new Plateau();

		System.out.println(plt.lancerPartie());
		plt.jouer("pierre");
		System.out.println(plt.affiche());
		System.out.println(plt.win());
	}	
}

/********************************
 * @author HenriAku             *
 * description : Jeu du morpion *
 *******************************/
package metier;

public class Objet 
{
	private String type;
	
	public Objet()
	{
		this.type = "";
	}

	public String getType()           {return this.type;}
	public void   setType(String type){this.type = type;}
}

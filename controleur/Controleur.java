package controleur;

import ihm.PanelBtn;
import ihm.FrameJeu;
import metier.Plateau;
import metier.Objet;

public class Controleur 
{
	private PanelBtn panel  ;
	private Plateau  plateau;
	private FrameJeu frame  ;	

	public Controleur()
	{
		this.frame   = new FrameJeu(this);
		this.panel   = new PanelBtn(this,frame);
		this.plateau = new Plateau ();
	}

	public Plateau getPlateau(){return this.plateau;}


	public void jouer(String type)
	{
		this.plateau.jouer(type);
	}

	public static void main(String[] args) 
    {
        new Controleur();
    }
}

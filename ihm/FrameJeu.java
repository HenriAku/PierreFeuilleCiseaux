package ihm;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

import controleur.Controleur;

public class FrameJeu extends JFrame
{
	private PanelBtn   panel;
	private Controleur ctrl ;

	

	public FrameJeu(Controleur ctrl)
	{
		this.setTitle("Pierre Feuille Ciseaux");
		this.setSize(880, 487);

		
		this.ctrl = ctrl;
		this.panel = new PanelBtn(ctrl, this);

		this.add(panel);
		

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void majIhm(){this.repaint();}

	public static void main(String[] args) 
	{
		Controleur ctrl = new Controleur();
		new FrameJeu(ctrl);
	}
}


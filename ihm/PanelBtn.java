package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import controleur.Controleur;

public class PanelBtn extends JPanel implements ActionListener
{	
	private Controleur	ctrl;
	private FrameJeu 	frame;
	private Image 		imgFond;

	private JButton[]	btnObjet;

	private JLabel		lblJoueur;
	private JLabel		lblBot;
	private JLabel		lblRes;

	public PanelBtn(Controleur ctrl,FrameJeu frame)
	{
		this.imgFond = getToolkit().getImage("./images/fond.png");

		this.setLayout(null);


		//Tableau pour les Bouton
		String[] tabimg = {"ciseaux","feuille","pierre"};
		int   [] posX   = {300,420,548};


		//Creation des composant
		this.ctrl  = ctrl;
		this.frame = frame; 

		this.btnObjet   = new JButton [3];

		//Creation positionnement et Activation des JButton
		for(int cpt = 0; cpt < this.btnObjet.length; cpt++)
		{
			this.btnObjet[cpt] = new JButton(new ImageIcon("./images/" + tabimg[cpt] + ".png"));
			this.btnObjet[cpt].setBounds(posX[cpt], 375, 50, 50);
			this.btnObjet[cpt].setOpaque(false);
			this.btnObjet[cpt].setContentAreaFilled(false);
			this.btnObjet[cpt].setBorderPainted(false);

			this.add(this.btnObjet[cpt]);
			this.btnObjet[cpt].addActionListener(this);
		}

		this.lblJoueur 	= new JLabel();
		this.lblJoueur	.setBounds(65 , 180, 50 , 50 );

		this.lblBot	   	= new JLabel();
		this.lblBot		.setBounds(755, 180, 50 , 50 );

		this.lblRes 	= new JLabel();
		this.lblRes		.setBounds(350, 20, 205, 50);
		this.lblRes		.setForeground(Color.RED  );
		this.lblRes		.setBackground(Color.WHITE);

		this.add(lblJoueur	);
		this.add(lblBot		);
		this.add(lblRes		);
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(this.imgFond, 0, 0, this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnObjet[0]) 
			this.ctrl.jouer("ciseaux");

		if (e.getSource() == this.btnObjet[1]) 
			this.ctrl.jouer("feuille");

		if (e.getSource() == this.btnObjet[2]) 
			this.ctrl.jouer("pierre");
		

		this.lblJoueur	.setIcon(new ImageIcon("./images/" + this.ctrl.getPlateau().getObjetJ() + ".png"));
		this.lblBot	  	.setIcon(new ImageIcon("./images/" + this.ctrl.getPlateau().getObjetB() + ".png"));
		this.lblRes		.setText("Vous : "+ this.ctrl.getPlateau().getPtJ() +"\t  " + this.ctrl.getPlateau().win() + "\t  Bot : " + this.ctrl.getPlateau().getPtJ());
		this.lblRes		.setOpaque(true);

		this.frame.majIhm();
	}

}

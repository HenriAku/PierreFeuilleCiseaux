package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import controleur.Controleur;

public class PanelBtn extends JPanel implements ActionListener
{	
	private Controleur ctrl    ;
	private JButton[]  btnObjet;

	private Image imgFond;

	public PanelBtn(Controleur ctrl)
	{
		this.imgFond = getToolkit().getImage("./images/fond.png");

		this.setLayout(null);

		this.ctrl = ctrl;

		this.btnObjet   = new JButton [3];
		String[] tabimg = {"ciseaux","feuille","pierre"};
		int[] posX = {300,420,548};

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
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(this.imgFond, 0, 0, this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnObjet[0]) 
		{
			this.ctrl.jouer("ciseaux");
		}

		if (e.getSource() == this.btnObjet[1]) 
		{
			this.ctrl.jouer("feuille");
		}

		if (e.getSource() == this.btnObjet[2]) 
		{
			this.ctrl.jouer("pierre");
		}
	}

}

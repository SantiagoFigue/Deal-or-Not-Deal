package Diseño;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JFrame{
	private JPanel pnlDisplay;
	private JPanel pnlFondo;
	private JPanel pnlJuego;
	
	
	private JButton btnJugar;
	
	public Principal() {
		super("Deal or Not Deal");
		super.setLayout(new BorderLayout());
		super.setSize(350,400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		
		pnlDisplay=new JPanel();
		pnlDisplay.setBackground(Color.BLACK);
		
		pnlJuego= new JPanel();
		
		Juego juego=new Juego();
		
		
		pnlJuego.setBackground(Color.BLACK);
		
		btnJugar=new JButton("PLAY");
		btnJugar.setFont(new Font("Copperplate Gothic Bold", 2,25));
		btnJugar.setForeground(Color.WHITE);
		btnJugar.setBackground(Color.BLACK);
		btnJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				juego.setlistener();
			}
		});
		
		
		//pnlDisplay.add(btnJugar, BorderLayout.SOUTH);
		pnlJuego.setVisible(false);
		super.add(pnlDisplay, BorderLayout.CENTER);
		super.add(btnJugar,BorderLayout.SOUTH);
		//super.add(pnlJuego,BorderLayout.CENTER);
		super.setVisible(true);
		
		
		
		
		
	}
}

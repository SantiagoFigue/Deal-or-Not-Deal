package Banco;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banco extends JDialog{
	private JDialog dlgBanco;
	private JDialog dlgGanador;
	
	
	private JLabel lbPropuesta;
	private JLabel lbGanador;
	
	
	private JPanel pnlLabel;
	private JPanel pnlBotones;
	private JPanel pnlSec;
	private JPanel pnlPri;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnSalir;
	
	public Banco() {
		
	}
	public void banco(Integer valor) {
		dlgBanco = new JDialog();
		lbPropuesta = new JLabel();
		pnlBotones=new JPanel();
		pnlLabel= new JPanel();
		pnlSec= new JPanel();
		pnlPri=new JPanel();
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		btnSalir=new JButton("Aceptar");
		
		lbGanador=new JLabel();
		
		lbGanador.setText(String.format(("Felicidades, haz ganado %d"),valor));
		
		dlgBanco.setTitle("Banco");
		dlgBanco.setSize(400, 200);
		dlgBanco.setLocationRelativeTo(null);
		
		dlgGanador= new JDialog();
		dlgGanador.setSize(300, 200);
		dlgGanador.setLocationRelativeTo(null);
		
		pnlPri.add(lbGanador,BorderLayout.CENTER);
		pnlSec.add(btnSalir,BorderLayout.CENTER);
		
		dlgGanador.add(pnlPri,BorderLayout.CENTER);
		dlgGanador.add(pnlSec,BorderLayout.SOUTH);
		
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dlgGanador.setVisible(true);
				dlgBanco.setVisible(false);
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgGanador.setVisible(false);
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		lbPropuesta.setText(String.format("El banco te ofrece %d por el maletin que tienes",valor));
		
		pnlLabel.add(lbPropuesta, BorderLayout.CENTER);
		
		pnlBotones.add(btnAceptar);
		pnlBotones.add(btnCancelar);
		
		dlgBanco.add(pnlLabel,BorderLayout.CENTER);
		dlgBanco.add(pnlBotones,BorderLayout.SOUTH);
		dlgBanco.setVisible(true);
		
	}
}

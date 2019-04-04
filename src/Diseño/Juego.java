package Diseño;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

import Banco.Banco;
import Datos.Datos;
import Labels.Labels;
import Maletines.Maletas;

public class Juego extends JFrame{
	private JPanel pnlIzquierda;
	private JPanel pnlDerecha;
	private JPanel pnlCentro;
	
	private Datos dt;
	private Labels lb;
	
	private Integer contador=0;
	private Integer guardar=0;
	private Integer suma=0;
	private Banco dlgbanco;
	private Integer banco=0;
	
	private JPanel pnlCentroArriba;
	private JPanel pnlCentroCentro;
	private JPanel pnlCentroAbajo;
	
	
	
	
	public Juego() {
	}
	public void setlistener() {
		dt = new Datos();
		dt.desordenar();
		ImageIcon imlabel= new ImageIcon(getClass().getResource("../Imagenes/dorado.jpg"));
		ImageIcon imredimension = new ImageIcon(imlabel.getImage().getScaledInstance(250, 80, Image.SCALE_DEFAULT));
		
		ImageIcon imMale = new ImageIcon(getClass().getResource("../Imagenes/maletas.jpg"));
		ImageIcon maleredimension = new ImageIcon(imMale.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
		
		ImageIcon maletalabel = new ImageIcon(imMale.getImage().getScaledInstance(150, 120, Image.SCALE_DEFAULT));
		
		ImageIcon imCentro = new ImageIcon(getClass().getResource("../Imagenes/FondoHit.jpg"));
		ImageIcon redimensionCentro= new ImageIcon(imCentro.getImage().getScaledInstance(150,120,Image.SCALE_DEFAULT));
		
		TitledBorder tlb= new TitledBorder(new BorderUIResource.EtchedBorderUIResource(20,Color.BLACK,Color.BLACK));
		
		pnlIzquierda = new JPanel(new GridLayout(13,0));
		pnlIzquierda.setBackground(Color.BLUE);
		pnlIzquierda.setPreferredSize(new Dimension(250,0));
		
		Maletas mlt= new Maletas();
		dlgbanco = new Banco();
		lb= new Labels(); 
		
		for (int i = 0; i <= 12; i++) {
			lb.agregarVals(new JLabel());
			lb.getLabels().get(i).setIcon(imredimension);
			lb.getLabels().get(i).setBorder(tlb);
			lb.getLabels().get(i).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
			lb.getLabels().get(i).setText(String.valueOf(dt.getValores().get(i)));
			lb.getLabels().get(i).setFont(new Font("Times New Roman", 5, 28));
			pnlIzquierda.add(lb.getLabels().get(i));
		}
		
		
		pnlDerecha = new JPanel(new GridLayout(13,0));
		pnlDerecha.setBackground(Color.BLUE);;
		pnlDerecha.setPreferredSize(new Dimension(250,0));
		
		for (int i = 13; i <= 25; i++) {
			lb.agregarVals(new JLabel());
			lb.getLabels().get(i).setIcon(imredimension);
			lb.getLabels().get(i).setBorder(tlb);
			lb.getLabels().get(i).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
			lb.getLabels().get(i).setText(String.valueOf(dt.getValores().get(i)));
			lb.getLabels().get(i).setFont(new Font("Times New Roman", 5, 28));
			
			pnlDerecha.add(lb.getLabels().get(i));
		}
		
		pnlCentro = new JPanel(new BorderLayout());
		pnlCentro.setBackground(Color.BLACK);
		
		pnlCentroCentro = new JPanel(new FlowLayout((int) RIGHT_ALIGNMENT,70,100)) {

			@Override
			public void paint(Graphics g) {
				Image ima=null;
				try {
					ima=ImageIO.read(new File("C:\\Users\\safij\\OneDrive\\Imágenes\\FondoHit.jpg"));
				} catch (IOException e) {
					System.out.println("Nada");
				}
				g.drawImage(ima, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paint(g);
				
			}
			
		};

		
		pnlCentro.add(pnlCentroCentro,BorderLayout.CENTER);
		
		pnlCentroAbajo = new JPanel();
		pnlCentroAbajo.setBackground(Color.BLACK);
		pnlCentroAbajo.setPreferredSize(new Dimension(70,150));
		
		
		pnlCentroArriba= new JPanel();
		pnlCentroArriba.setBackground(Color.BLACK);
		pnlCentroArriba.setPreferredSize(new Dimension(70,150));
		
		
		pnlCentro.add(pnlCentroArriba,BorderLayout.NORTH);
		pnlCentro.add(pnlCentroAbajo,BorderLayout.SOUTH);
		
		
		
		for (int i = 0; i <= 25; i++) {
			mlt.agregarMal(new JButton(imMale));
			mlt.getMaletines().get(i).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
			mlt.getMaletines().get(i).setText(String.valueOf(i+1));
			mlt.getMaletines().get(i).setPreferredSize(new Dimension(100, 70));
			mlt.getMaletines().get(i).setFont(new Font("Times New Roman", 5, 28));
			pnlCentroCentro.add(mlt.getMaletines().get(i));
		}
		
		
		
		
		mlt.getMaletines().get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(0);
					mlt.getMaletines().get(0).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("1");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				} else {
					abrir(dt.getValores().get(0));
					mlt.getMaletines().get(0).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(0);
				
				
			}
		});
		
		mlt.getMaletines().get(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(1);
					mlt.getMaletines().get(1).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("2");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(1));
					mlt.getMaletines().get(1).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(1);
			}
		});
		
		mlt.getMaletines().get(2).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(2);
					mlt.getMaletines().get(2).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("3");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(2));
					mlt.getMaletines().get(2).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(2);
			}
		});
		
		mlt.getMaletines().get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(3);
					mlt.getMaletines().get(3).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("4");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(3));
					mlt.getMaletines().get(3).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(3);
			}
		});
		
		mlt.getMaletines().get(4).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(4);
					mlt.getMaletines().get(4).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("5");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(4));
					mlt.getMaletines().get(4).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(4);
			}
			
		});
		
		mlt.getMaletines().get(5).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(5);
					mlt.getMaletines().get(5).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("6");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(5));
					mlt.getMaletines().get(5).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(5);
			}
		});
		
		mlt.getMaletines().get(6).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(6);
					mlt.getMaletines().get(6).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("7");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(6));
					mlt.getMaletines().get(6).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(6);
			}
		});
		
		mlt.getMaletines().get(7).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(7);
					mlt.getMaletines().get(7).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("8");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(7));
					mlt.getMaletines().get(7).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(7);
			}
		});
		
		mlt.getMaletines().get(8).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(8);
					mlt.getMaletines().get(8).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("9");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(8));
					mlt.getMaletines().get(8).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(8);
			}
		});
		
		mlt.getMaletines().get(9).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(9);
					mlt.getMaletines().get(9).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("10");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(9));
					mlt.getMaletines().get(9).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(9);
			}
		});
		
		mlt.getMaletines().get(10).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(10);
					mlt.getMaletines().get(10).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("11");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(10));
					mlt.getMaletines().get(10).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(10);
			}
		});
		
		mlt.getMaletines().get(11).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(11);
					mlt.getMaletines().get(11).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("12");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(11));
					mlt.getMaletines().get(11).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(11);
			}
		});
		
		mlt.getMaletines().get(12).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(12);
					mlt.getMaletines().get(12).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("13");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(12));
					mlt.getMaletines().get(12).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(12);
			}
		});
		
		mlt.getMaletines().get(13).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(13);
					mlt.getMaletines().get(13).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("14");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(13));
					mlt.getMaletines().get(13).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(13);
			}
		});
		
		mlt.getMaletines().get(14).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(14);
					mlt.getMaletines().get(14).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("15");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(14));
					mlt.getMaletines().get(13).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(14);
			}
		});
		
		mlt.getMaletines().get(15).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(15);
					mlt.getMaletines().get(15).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("16");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(15));
					mlt.getMaletines().get(15).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(15);
			}
		});
		
		mlt.getMaletines().get(16).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(16);
					mlt.getMaletines().get(16).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("17");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(16));
					mlt.getMaletines().get(16).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(16);
			}
		});
		
		mlt.getMaletines().get(17).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(17);
					mlt.getMaletines().get(17).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("18");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(17));
					mlt.getMaletines().get(17).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(17);
			}
		});
		
		mlt.getMaletines().get(18).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(18);
					mlt.getMaletines().get(18).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("19");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(18));
					mlt.getMaletines().get(18).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(18);
			}
		});
		
		mlt.getMaletines().get(19).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(19);
					mlt.getMaletines().get(19).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("20");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(19));
					mlt.getMaletines().get(19).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(19);
			}
		});
		
		mlt.getMaletines().get(20).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(20);
					mlt.getMaletines().get(20).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("21");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(20));
					mlt.getMaletines().get(20).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(20);
			}
		});
		
		mlt.getMaletines().get(21).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(21);
					mlt.getMaletines().get(21).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("22");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(21));
					mlt.getMaletines().get(21).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(21);
			}
		});
		
		mlt.getMaletines().get(22).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(22);
					mlt.getMaletines().get(22).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("23");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(22));
					mlt.getMaletines().get(22).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(22);
			}
		});
		
		mlt.getMaletines().get(23).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(23);
					mlt.getMaletines().get(23).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("24");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(23));
					mlt.getMaletines().get(23).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(23);
			}
		});
		
		mlt.getMaletines().get(24).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(24);
					mlt.getMaletines().get(24).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("25");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(24));
					mlt.getMaletines().get(24).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(24);
			}
		});

		mlt.getMaletines().get(25).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador==0) {
					guardar=dt.getValores().get(25);
					mlt.getMaletines().get(25).setVisible(false);
					JLabel nombre = new JLabel(maletalabel);
					nombre.setText("26");
					nombre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
					pnlCentroAbajo.add(nombre);
					contador++;
				}else {
					abrir(dt.getValores().get(25));
					mlt.getMaletines().get(25).setVisible(false);
					banco++;
					dlgbanco.banco(2743431-suma);
				}
				suma+=dt.getValores().get(25);
			}
		});
		
		add(pnlIzquierda,BorderLayout.WEST);
		add(pnlCentro,BorderLayout.CENTER);
		add(pnlDerecha,BorderLayout.EAST);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	
	public void abrir(Integer valor) {
		JOptionPane.showMessageDialog(this,String.valueOf(valor),"Maletin Abierto", JOptionPane.QUESTION_MESSAGE);
		
		for (int i = 0; i <= 25; i++) {
			if (valor==dt.getValores().get(i)) {
				lb.getLabels().get(i).setVisible(false);
			}
		}
	}
	
}

package es.thesinsprods.juegozagas.gestorpartidas;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.diceroll.DiceRoll;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GestorMain {

	private JFrame frmHistoriasDeZagas;

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	MorpheusFont mf = new MorpheusFont();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorMain window = new GestorMain();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestorMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(GestorMain.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 439, 466);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		final JButton btnTiradaDeCombate = new JButton("Tiradas Enfrentadas");
		btnTiradaDeCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TiradaDeCombate window=new TiradaDeCombate();
				window.getFrame().setVisible(true);
			}
		});
		btnTiradaDeCombate.setBorderPainted(false);
		btnTiradaDeCombate.setContentAreaFilled(false);
		btnTiradaDeCombate.setFocusPainted(false);
		btnTiradaDeCombate.setOpaque(false);
		btnTiradaDeCombate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnTiradaDeCombate.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
				
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnTiradaDeCombate.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
				
				
			}
		});
		btnTiradaDeCombate.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnTiradaDeCombate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTiradaDeCombate.setFont(mf.MyFont(0, 17));
		btnTiradaDeCombate.setForeground(Color.WHITE);
		btnTiradaDeCombate.setBounds(10, 73, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnTiradaDeCombate);
		
		final JButton btnTiradasEnfrentadas = new JButton("Informaci\u00F3n Tiradas Enfrentadas");
		btnTiradasEnfrentadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File habilidades= new File("./htmls/Tiradas Enfrentada.html");
				try {
					Desktop.getDesktop().open(habilidades);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
		btnTiradasEnfrentadas.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnTiradasEnfrentadas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTiradasEnfrentadas.setFont(mf.MyFont(0, 17));
		btnTiradasEnfrentadas.setBorderPainted(false);
		btnTiradasEnfrentadas.setContentAreaFilled(false);
		btnTiradasEnfrentadas.setFocusPainted(false);
		btnTiradasEnfrentadas.setOpaque(false);
		btnTiradasEnfrentadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnTiradasEnfrentadas.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
				
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnTiradasEnfrentadas.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
				
				
			}
		});
		btnTiradasEnfrentadas.setForeground(Color.WHITE);
		btnTiradasEnfrentadas.setBounds(10, 298, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnTiradasEnfrentadas);
		
		final JButton btnTiradasAleatorias = new JButton("Tiradas Aleatorias");
		btnTiradasAleatorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object seleccion = JOptionPane.showInputDialog(
						   null,
						   "Tirada Aleatoria",
						   "Seleccione el tipo de dado que quiere lanzar",
						   JOptionPane.PLAIN_MESSAGE,
						   null,  // null para icono defecto
						   new Object[] { "d20", "d12", "d10","d8","d6","d4" }, 
						   "opcion 1");
				seleccion=seleccion+"";
				
			
				
				if(seleccion.equals("d20")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio20(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				}
				if(seleccion.equals("d12")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio12(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				}
				if(seleccion.equals("d10")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio10(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				}
				if(seleccion.equals("d8")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio8(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				}
				if(seleccion.equals("d6")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio6(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				}
				if(seleccion.equals("d4")){
					JOptionPane.showOptionDialog(
							   null,
							   ""+DiceRoll.LanzaDadoAleatorio4(), 
							   "Tirada Aleatoria",
							   JOptionPane.PLAIN_MESSAGE,
							   JOptionPane.PLAIN_MESSAGE,
							   null,    
							   new Object[] { "OK" },   
							   "opcion 1");
				
				}
			}
		});
		btnTiradasAleatorias.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnTiradasAleatorias.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTiradasAleatorias.setBorderPainted(false);
		btnTiradasAleatorias.setContentAreaFilled(false);
		btnTiradasAleatorias.setFocusPainted(false);
		btnTiradasAleatorias.setOpaque(false);
		btnTiradasAleatorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnTiradasAleatorias.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
				
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnTiradasAleatorias.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
				
				
			}
		});
		btnTiradasAleatorias.setFont(mf.MyFont(0, 17));
		btnTiradasAleatorias.setForeground(Color.WHITE);
		btnTiradasAleatorias.setBounds(10, 118, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnTiradasAleatorias);
		
		final JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAyuda.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setFont(mf.MyFont(0, 17));
		btnAyuda.setBorderPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setFocusPainted(false);
		btnAyuda.setOpaque(false);
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
				
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
				
				
			}
		});
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setBounds(10, 343, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Inicio window = new Inicio();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();
			
			}
		});
		btnVolver.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setBounds(10, 388, 414, 34);
		btnVolver.setFont(mf.MyFont(0, 17));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
				
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
				
				
			}
		});
		btnVolver.setForeground(Color.WHITE);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);
		
		final JButton btnHabilidadesYSus = new JButton("Habilidades y sus Atributos");
		btnHabilidadesYSus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File habilidades= new File("./htmls/Habilidades y Atributos.html");
				try {
					Desktop.getDesktop().open(habilidades);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnHabilidadesYSus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnHabilidadesYSus.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
			}
			public void mouseReleased(MouseEvent e) {
				btnHabilidadesYSus.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
			}
		});
		btnHabilidadesYSus.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnHabilidadesYSus.setOpaque(false);
		btnHabilidadesYSus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabilidadesYSus.setForeground(Color.WHITE);
		btnHabilidadesYSus.setFont(mf.MyFont(0, 17));
		btnHabilidadesYSus.setFocusPainted(false);
		btnHabilidadesYSus.setContentAreaFilled(false);
		btnHabilidadesYSus.setBorderPainted(false);
		btnHabilidadesYSus.setBounds(10, 163, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnHabilidadesYSus);
		
		final JButton btnArmera = new JButton("Armer\u00EDa");
		btnArmera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File armeria= new File("./htmls/Armeria.html");
				try {
					Desktop.getDesktop().open(armeria);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnArmera.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnArmera.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
			}
			public void mouseReleased(MouseEvent e) {
				btnArmera.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
			}
		});
		btnArmera.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnArmera.setOpaque(false);
		btnArmera.setHorizontalTextPosition(SwingConstants.CENTER);
		btnArmera.setForeground(Color.WHITE);
		btnArmera.setFont(mf.MyFont(0, 17));
		btnArmera.setFocusPainted(false);
		btnArmera.setContentAreaFilled(false);
		btnArmera.setBorderPainted(false);
		btnArmera.setBounds(10, 208, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnArmera);
		
		final JButton btnConocimientosMgicos = new JButton("Conocimientos M\u00E1gicos");
		btnConocimientosMgicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File habilidades= new File("./htmls/Conocimientosmagicos.html");
				try {
					Desktop.getDesktop().open(habilidades);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnConocimientosMgicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConocimientosMgicos.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio2.png")));
			}
			public void mouseReleased(MouseEvent e) {
				btnConocimientosMgicos.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
			}
		});
		btnConocimientosMgicos.setIcon(new ImageIcon(GestorMain.class.getResource("/images/botonesInicio.png")));
		btnConocimientosMgicos.setOpaque(false);
		btnConocimientosMgicos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConocimientosMgicos.setForeground(Color.WHITE);
		btnConocimientosMgicos.setFont(mf.MyFont(0, 17));
		btnConocimientosMgicos.setFocusPainted(false);
		btnConocimientosMgicos.setContentAreaFilled(false);
		btnConocimientosMgicos.setBorderPainted(false);
		btnConocimientosMgicos.setBounds(10, 253, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnConocimientosMgicos);
		
		JLabel lblGestorDeJuego = new JLabel("Gestor de Juego");
		lblGestorDeJuego.setForeground(Color.WHITE);
		lblGestorDeJuego.setFont(mf.MyFont(0, 30));
		lblGestorDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestorDeJuego.setBounds(10, 11, 413, 51);
		frmHistoriasDeZagas.getContentPane().add(lblGestorDeJuego);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GestorMain.class.getResource("/images/background-inicio.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(0, 0, 433, 437);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
	}
}

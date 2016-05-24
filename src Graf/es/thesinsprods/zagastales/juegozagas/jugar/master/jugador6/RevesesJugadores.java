package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RevesesJugadores {

	private JFrame frmHistoriasDeZagas;
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}
	MorpheusFont mf = new MorpheusFont ();
	private final JLabel lblNewLabel_2 = new JLabel("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RevesesJugadores window = new RevesesJugadores();
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
	public RevesesJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(RevesesJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 348, 322);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reveses");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(mf.MyFont(0, 36));
		lblNewLabel.setBounds(10, 11, 324, 60);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		if(!JugarOnline.personaje6.getSetbacks().getReves().get(0).equals(null)){
			if(!JugarOnline.personaje6.getSetbacks().getReves().get(0).equals("null")){
			lblNewLabel_1.setText(JugarOnline.personaje6.getSetbacks().getReves().get(0)+"");
			}
		}
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(mf.MyFont(0,18));
		lblNewLabel_1.setBounds(10, 82, 322, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDestreza = new JLabel("");
		if(!JugarOnline.personaje6.getSetbacks().getReves().get(1).equals(null)){
			if(!JugarOnline.personaje6.getSetbacks().getReves().get(1).equals("null")){
			lblDestreza.setText(JugarOnline.personaje6.getSetbacks().getReves().get(1)+"");
			}
		}
		lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(mf.MyFont(0,18));
		lblDestreza.setBounds(10, 123, 322, 30);
		frmHistoriasDeZagas.getContentPane().add(lblDestreza);
		
		JLabel lblResistencia = new JLabel("");
		if(!JugarOnline.personaje6.getSetbacks().getReves().get(2).equals(null)){
			if(!JugarOnline.personaje6.getSetbacks().getReves().get(2).equals("null")){
			lblResistencia.setText(JugarOnline.personaje6.getSetbacks().getReves().get(2)+"");
			}
		}
		lblResistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setFont(mf.MyFont(0,18));
		lblResistencia.setBounds(10, 164, 322, 30);
		frmHistoriasDeZagas.getContentPane().add(lblResistencia);
		
		JLabel lblResistenciaMgica = new JLabel("");
		if(!JugarOnline.personaje6.getSetbacks().getReves().get(3).equals(null)){
			if(!JugarOnline.personaje6.getSetbacks().getReves().get(3).equals("null")){
			lblResistenciaMgica.setText(JugarOnline.personaje6.getSetbacks().getReves().get(3)+"");
			}
		}
		lblResistenciaMgica.setHorizontalAlignment(SwingConstants.CENTER);
		lblResistenciaMgica.setForeground(Color.WHITE);
		lblResistenciaMgica.setFont(mf.MyFont(0,18));
		lblResistenciaMgica.setBounds(10, 205, 322, 30);
		frmHistoriasDeZagas.getContentPane().add(lblResistenciaMgica);
		
		
		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(RevesesJugadores.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(RevesesJugadores.class.getResource("/images/boton atras.png")));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				
			}
		});
		button.setIcon(new ImageIcon(RevesesJugadores.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

						null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 246, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button);
		lblNewLabel_2.setIcon(new ImageIcon(RevesesJugadores.class.getResource("/images/background-jugar.jpg")));
		lblNewLabel_2.setBounds(0, 0, 344, 430);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_2);
	}
}

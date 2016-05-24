package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Toolkit;

public class CombateJugadores {

	private JFrame frmHistoriasDeZagas;
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CombateJugadores window = new CombateJugadores();
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
	public CombateJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(CombateJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 337, 401);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblCombate = new JLabel("Combate");
		lblCombate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombate.setForeground(Color.WHITE);
		lblCombate.setFont(mf.MyFont(0, 36));
		lblCombate.setBounds(10, 0, 312, 60);
		frmHistoriasDeZagas.getContentPane().add(lblCombate);
		
		JLabel lblArmasDeUna = new JLabel("Armas de Una Mano:");
		lblArmasDeUna.setForeground(Color.WHITE);
		lblArmasDeUna.setFont(mf.MyFont(0,18));
		lblArmasDeUna.setBounds(10, 66, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeUna);
		
		textField = new JTextField();
		textField.setText(""+JugarOnline.personaje8.getCombatSkills().getOneHanded());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(248, 66, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField);
		
		JLabel lblArmasDeDos = new JLabel("Armas de Dos Manos:");
		lblArmasDeDos.setForeground(Color.WHITE);
		lblArmasDeDos.setFont(mf.MyFont(0,18));
		lblArmasDeDos.setBounds(10, 107, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeDos);
		
		textField_1 = new JTextField();
		textField_1.setText(""+JugarOnline.personaje8.getCombatSkills().getTwoHanded());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(248, 107, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		JLabel lblArmasDeAsta = new JLabel("Armas de Asta:");
		lblArmasDeAsta.setForeground(Color.WHITE);
		lblArmasDeAsta.setFont(mf.MyFont(0,18));
		lblArmasDeAsta.setBounds(10, 148, 164, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeAsta);
		
		textField_2 = new JTextField();
		textField_2.setText(""+JugarOnline.personaje8.getCombatSkills().getPole());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(248, 148, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		JLabel lblArmasADistancia = new JLabel("Armas a Distancia:");
		lblArmasADistancia.setForeground(Color.WHITE);
		lblArmasADistancia.setFont(mf.MyFont(0,18));
		lblArmasADistancia.setBounds(10, 189, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasADistancia);
		
		textField_3 = new JTextField();
		textField_3.setText(""+JugarOnline.personaje8.getCombatSkills().getRanged());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(248, 189, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		
		JLabel lblEsquivar = new JLabel("Esquivar:");
		lblEsquivar.setForeground(Color.WHITE);
		lblEsquivar.setFont(mf.MyFont(0,18));
		lblEsquivar.setBounds(10, 230, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblEsquivar);
		
		textField_4 = new JTextField();
		textField_4.setText(""+JugarOnline.personaje8.getCombatSkills().getDodge());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(248, 230, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
		JLabel lblBloquear = new JLabel("Bloquear:");
		lblBloquear.setForeground(Color.WHITE);
		lblBloquear.setFont(mf.MyFont(0,18));
		lblBloquear.setBounds(10, 271, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblBloquear);
		
		textField_5 = new JTextField();
		textField_5.setText(""+JugarOnline.personaje8.getCombatSkills().getBlock());
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(248, 271, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_5);
		
		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(AtributosJugadores.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(AtributosJugadores.class.getResource("/images/boton atras.png")));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				
				
			}
		});
		button.setIcon(new ImageIcon(CombateJugadores.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 330, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CombateJugadores.class.getResource("/images/background-creadornpcs.jpg")));
		label_1.setBounds(0, 0, 332, 376);
		frmHistoriasDeZagas.getContentPane().add(label_1);
	}
}

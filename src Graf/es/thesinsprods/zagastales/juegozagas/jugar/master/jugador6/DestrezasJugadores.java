package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador6;

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

public class DestrezasJugadores {

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
	
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DestrezasJugadores window = new DestrezasJugadores();
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
	public DestrezasJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(DestrezasJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 337, 354);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblCombate = new JLabel("Destrezas");
		lblCombate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombate.setForeground(Color.WHITE);
		lblCombate.setFont(mf.MyFont(0, 36));
		lblCombate.setBounds(10, 0, 312, 60);
		frmHistoriasDeZagas.getContentPane().add(lblCombate);
		
		JLabel lblArmasDeUna = new JLabel("Atletismo:");
		lblArmasDeUna.setForeground(Color.WHITE);
		lblArmasDeUna.setFont(mf.MyFont(0,18));
		lblArmasDeUna.setBounds(10, 66, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeUna);
		
		textField = new JTextField();
		textField.setText(""+JugarOnline.personaje6.getKnowhowSkills().getAthletics());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(248, 66, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField);
		
		JLabel lblArmasDeDos = new JLabel("Supervivencia:");
		lblArmasDeDos.setForeground(Color.WHITE);
		lblArmasDeDos.setFont(mf.MyFont(0,18));
		lblArmasDeDos.setBounds(10, 107, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeDos);
		
		textField_1 = new JTextField();
		textField_1.setText(""+JugarOnline.personaje6.getKnowhowSkills().getSurvival());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(248, 107, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		JLabel lblArmasDeAsta = new JLabel("Equitaci\u00F3n:");
		lblArmasDeAsta.setForeground(Color.WHITE);
		lblArmasDeAsta.setFont(mf.MyFont(0,18));
		lblArmasDeAsta.setBounds(10, 148, 164, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeAsta);
		
		textField_2 = new JTextField();
		textField_2.setText(""+JugarOnline.personaje6.getKnowhowSkills().getEquitation());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(248, 148, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		JLabel lblArmasADistancia = new JLabel("Trampas:");
		lblArmasADistancia.setForeground(Color.WHITE);
		lblArmasADistancia.setFont(mf.MyFont(0,18));
		lblArmasADistancia.setBounds(10, 189, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArmasADistancia);
		
		textField_3 = new JTextField();
		textField_3.setText(""+JugarOnline.personaje6.getKnowhowSkills().getTraps());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(248, 189, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		
		JLabel lblEsquivar = new JLabel("Sigilo:");
		lblEsquivar.setForeground(Color.WHITE);
		lblEsquivar.setFont(mf.MyFont(0,18));
		lblEsquivar.setBounds(10, 230, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblEsquivar);
		
		textField_4 = new JTextField();
		textField_4.setText(""+JugarOnline.personaje6.getKnowhowSkills().getStealth());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(248, 230, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
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
		button.setIcon(new ImageIcon(DestrezasJugadores.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,


								null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 279, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DestrezasJugadores.class.getResource("/images/background-creadornpcs.jpg")));
		label_1.setBounds(0, 0, 332, 376);
		frmHistoriasDeZagas.getContentPane().add(label_1);
	}
}

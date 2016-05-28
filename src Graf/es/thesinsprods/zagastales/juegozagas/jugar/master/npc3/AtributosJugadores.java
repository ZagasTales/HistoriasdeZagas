package es.thesinsprods.zagastales.juegozagas.jugar.master.npc3;

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

public class AtributosJugadores {

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
	private JTextField textField_6;
	MorpheusFont mf = new MorpheusFont ();
	private final JLabel lblNewLabel_2 = new JLabel("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtributosJugadores window = new AtributosJugadores();
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
	public AtributosJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(AtributosJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 348, 453);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atributos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(mf.MyFont(0, 36));
		lblNewLabel.setBounds(10, 11, 324, 60);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fuerza:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(mf.MyFont(0,18));
		lblNewLabel_1.setBounds(10, 82, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDestreza = new JLabel("Destreza:");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(mf.MyFont(0,18));
		lblDestreza.setBounds(10, 123, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblDestreza);
		
		JLabel lblResistencia = new JLabel("Resistencia:");
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setFont(mf.MyFont(0,18));
		lblResistencia.setBounds(10, 164, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblResistencia);
		
		JLabel lblResistenciaMgica = new JLabel("Resistencia M\u00E1gica:");
		lblResistenciaMgica.setForeground(Color.WHITE);
		lblResistenciaMgica.setFont(mf.MyFont(0,18));
		lblResistenciaMgica.setBounds(10, 205, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblResistenciaMgica);
		
		JLabel lblInteligencia = new JLabel("Inteligencia:");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setFont(mf.MyFont(0,18));
		lblInteligencia.setBounds(10, 246, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblInteligencia);
		
		JLabel lblPercepcin = new JLabel("Percepci\u00F3n:");
		lblPercepcin.setForeground(Color.WHITE);
		lblPercepcin.setFont(mf.MyFont(0,18));
		lblPercepcin.setBounds(10, 287, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblPercepcin);
		
		JLabel lblCarisma = new JLabel("Carisma:");
		lblCarisma.setForeground(Color.WHITE);
		lblCarisma.setFont(mf.MyFont(0,18));
		lblCarisma.setBounds(10, 328, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblCarisma);
		
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
		button.setIcon(new ImageIcon(AtributosJugadores.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
						null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 384, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(""+JugarOnline.npc3.getAtributes().getStrength());
		textField.setEditable(false);
		textField.setBounds(248, 82, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(""+JugarOnline.npc3.getAtributes().getDexterity());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(248, 123, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(""+JugarOnline.npc3.getAtributes().getResistance());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(248, 164, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(""+JugarOnline.npc3.getAtributes().getMagicres());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(248, 205, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(""+JugarOnline.npc3.getAtributes().getIntelligence());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(248, 246, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(""+JugarOnline.npc3.getAtributes().getPerception());
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(248, 287, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText(""+JugarOnline.npc3.getAtributes().getCharisma());
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(248, 328, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_6);
		lblNewLabel_2.setIcon(new ImageIcon(AtributosJugadores.class.getResource("/images/background-jugar.jpg")));
		lblNewLabel_2.setBounds(0, 0, 344, 430);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_2);
	}
}

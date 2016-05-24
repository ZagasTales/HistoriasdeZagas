package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador2;

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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ConocimientosJugadores {

	private JFrame frmHistoriasDeZagas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConocimientosJugadores window = new ConocimientosJugadores();
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
	public ConocimientosJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(ConocimientosJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 337, 495);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblConocimientos = new JLabel("Conocimientos");
		lblConocimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConocimientos.setForeground(Color.WHITE);
		lblConocimientos.setFont(mf.MyFont(0, 36));
		lblConocimientos.setBounds(10, 0, 312, 60);
		frmHistoriasDeZagas.getContentPane().add(lblConocimientos);
		
		JLabel lblArteDeLa = new JLabel("Arte de la Guerra:");
		lblArteDeLa.setForeground(Color.WHITE);
		lblArteDeLa.setFont(mf.MyFont(0,18));
		lblArteDeLa.setBounds(10, 66, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblArteDeLa);
		
		textField = new JTextField();
		textField.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getArtofWar());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(248, 66, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField);
		
		JLabel lblDiplomacia = new JLabel("Diplomacia:");
		lblDiplomacia.setForeground(Color.WHITE);
		lblDiplomacia.setFont(mf.MyFont(0,18));
		lblDiplomacia.setBounds(10, 107, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblDiplomacia);
		
		textField_1 = new JTextField();
		textField_1.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getDiplomacy());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(248, 107, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		JLabel lblEtiqueta = new JLabel("Etiqueta:");
		lblEtiqueta.setForeground(Color.WHITE);
		lblEtiqueta.setFont(mf.MyFont(0,18));
		lblEtiqueta.setBounds(10, 148, 164, 30);
		frmHistoriasDeZagas.getContentPane().add(lblEtiqueta);
		
		textField_2 = new JTextField();
		textField_2.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getEtiquette());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(248, 148, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		JLabel lblMedicina = new JLabel("Medicina:");
		lblMedicina.setForeground(Color.WHITE);
		lblMedicina.setFont(mf.MyFont(0,18));
		lblMedicina.setBounds(10, 189, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblMedicina);
		
		textField_3 = new JTextField();
		textField_3.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getMedicine());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(248, 189, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		
		JLabel lblOcultismo = new JLabel("Ocultismo:");
		lblOcultismo.setForeground(Color.WHITE);
		lblOcultismo.setFont(mf.MyFont(0,18));
		lblOcultismo.setBounds(10, 230, 100, 30);
		frmHistoriasDeZagas.getContentPane().add(lblOcultismo);
		
		textField_4 = new JTextField();
		textField_4.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getOccultism());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(248, 230, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
		JLabel lblNegociacin = new JLabel("Investigaci\u00F3n:");
		lblNegociacin.setForeground(Color.WHITE);
		lblNegociacin.setFont(mf.MyFont(0,18));
		lblNegociacin.setBounds(10, 271, 164, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNegociacin);
		
		textField_5 = new JTextField();
		textField_5.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getResearch());
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(248, 271, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_5);
		
		JLabel lblNegociacin_1 = new JLabel("Negociaci\u00F3n:");
		lblNegociacin_1.setForeground(Color.WHITE);
		lblNegociacin_1.setFont(mf.MyFont(0,18));
		lblNegociacin_1.setBounds(10, 312, 179, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNegociacin_1);
		
		textField_6 = new JTextField();
		textField_6.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getNegotiation());
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(248, 312, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_6);
		
		JLabel lblConocimientosSecretos = new JLabel("Conocimientos Secretos:");
		lblConocimientosSecretos.setForeground(Color.WHITE);
		lblConocimientosSecretos.setFont(mf.MyFont(0,18));
		lblConocimientosSecretos.setBounds(10, 353, 206, 30);
		frmHistoriasDeZagas.getContentPane().add(lblConocimientosSecretos);
		
		textField_7 = new JTextField();
		textField_7.setText(""+JugarOnline.personaje2.getKnowledgeSkills().getSecretKnowledge());
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(248, 353, 50, 30);
		frmHistoriasDeZagas.getContentPane().add(textField_7);
		
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
		button.setIcon(new ImageIcon(ConocimientosJugadores.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 420, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConocimientosJugadores.class.getResource("/images/background-jugar.jpg")));
		label.setBounds(0, 0, 331, 466);
		frmHistoriasDeZagas.getContentPane().add(label);
	}

}

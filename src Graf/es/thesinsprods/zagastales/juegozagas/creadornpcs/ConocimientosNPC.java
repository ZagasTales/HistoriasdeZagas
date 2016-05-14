package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;

public class ConocimientosNPC {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtArteDeLa;
	private JTextField txtDiplomacia;
	private JTextField txtEtiqueta;
	private JTextField txtMedicina;
	private JTextField txtOcultismo;
	private JTextField txtInvestigacin;
	private JTextField txtNegociacin;
	private JTextField txtConocimientosSecretos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public static int minAG = 0;
	public static int minDip = 0;
	public static int minMed = 0;
	public static int minEt = 0;
	public static int minOc = 0;
	public static int minInv = 0;
	public static int minNeg = 0;
	public static int minCS = 0;
	MorpheusFont mf = new MorpheusFont();

	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton btnVolverAHabilidades;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConocimientosNPC window = new ConocimientosNPC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConocimientosNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 474, 376);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		txtArteDeLa = new JTextField();
		txtArteDeLa.setOpaque(false);
		txtArteDeLa.setForeground(Color.WHITE);
		txtArteDeLa.setBackground(new Color(205, 133, 63));
		txtArteDeLa.setText("Arte de la Guerra:");
		txtArteDeLa.setFont(mf.MyFont(0, 13));
		txtArteDeLa.setEditable(false);
		txtArteDeLa.setColumns(10);
		txtArteDeLa.setBorder(null);
		txtArteDeLa.setBounds(10, 34, 126, 20);
		frame.getContentPane().add(txtArteDeLa);

		txtDiplomacia = new JTextField();
		txtDiplomacia.setOpaque(false);
		txtDiplomacia.setForeground(Color.WHITE);
		txtDiplomacia.setBackground(new Color(205, 133, 63));
		txtDiplomacia.setText("Diplomacia:");
		txtDiplomacia.setFont(mf.MyFont(0, 13));
		txtDiplomacia.setEditable(false);
		txtDiplomacia.setColumns(10);
		txtDiplomacia.setBorder(null);
		txtDiplomacia.setBounds(10, 65, 126, 20);
		frame.getContentPane().add(txtDiplomacia);

		txtEtiqueta = new JTextField();
		txtEtiqueta.setOpaque(false);
		txtEtiqueta.setForeground(Color.WHITE);
		txtEtiqueta.setBackground(new Color(205, 133, 63));
		txtEtiqueta.setText("Etiqueta:");
		txtEtiqueta.setFont(mf.MyFont(0, 13));
		txtEtiqueta.setEditable(false);
		txtEtiqueta.setColumns(10);
		txtEtiqueta.setBorder(null);
		txtEtiqueta.setBounds(10, 96, 126, 20);
		frame.getContentPane().add(txtEtiqueta);

		txtMedicina = new JTextField();
		txtMedicina.setOpaque(false);
		txtMedicina.setForeground(Color.WHITE);
		txtMedicina.setBackground(new Color(205, 133, 63));
		txtMedicina.setText("Medicina:");
		txtMedicina.setFont(mf.MyFont(0, 13));
		txtMedicina.setEditable(false);
		txtMedicina.setColumns(10);
		txtMedicina.setBorder(null);
		txtMedicina.setBounds(10, 127, 126, 20);
		frame.getContentPane().add(txtMedicina);

		txtOcultismo = new JTextField();
		txtOcultismo.setOpaque(false);
		txtOcultismo.setForeground(Color.WHITE);
		txtOcultismo.setBackground(new Color(205, 133, 63));
		txtOcultismo.setText("Ocultismo");
		txtOcultismo.setFont(mf.MyFont(0, 13));
		txtOcultismo.setEditable(false);
		txtOcultismo.setColumns(10);
		txtOcultismo.setBorder(null);
		txtOcultismo.setBounds(10, 158, 126, 20);
		frame.getContentPane().add(txtOcultismo);

		txtInvestigacin = new JTextField();
		txtInvestigacin.setOpaque(false);
		txtInvestigacin.setForeground(Color.WHITE);
		txtInvestigacin.setBackground(new Color(205, 133, 63));
		txtInvestigacin.setText("Investigaci\u00F3n:");
		txtInvestigacin.setFont(mf.MyFont(0, 13));
		txtInvestigacin.setEditable(false);
		txtInvestigacin.setColumns(10);
		txtInvestigacin.setBorder(null);
		txtInvestigacin.setBounds(10, 189, 126, 20);
		frame.getContentPane().add(txtInvestigacin);

		txtNegociacin = new JTextField();
		txtNegociacin.setOpaque(false);
		txtNegociacin.setForeground(Color.WHITE);
		txtNegociacin.setBackground(new Color(205, 133, 63));
		txtNegociacin.setText("Negociaci\u00F3n:");
		txtNegociacin.setFont(mf.MyFont(0, 13));
		txtNegociacin.setEditable(false);
		txtNegociacin.setColumns(10);
		txtNegociacin.setBorder(null);
		txtNegociacin.setBounds(10, 220, 126, 20);
		frame.getContentPane().add(txtNegociacin);

		txtConocimientosSecretos = new JTextField();
		txtConocimientosSecretos.setOpaque(false);
		txtConocimientosSecretos.setForeground(Color.WHITE);
		txtConocimientosSecretos.setBackground(new Color(205, 133, 63));
		txtConocimientosSecretos.setText("Conocimientos Secretos:");
		txtConocimientosSecretos.setFont(mf.MyFont(0, 13));
		txtConocimientosSecretos.setEditable(false);
		txtConocimientosSecretos.setColumns(10);
		txtConocimientosSecretos.setBorder(null);
		txtConocimientosSecretos.setBounds(10, 254, 136, 20);
		frame.getContentPane().add(txtConocimientosSecretos);

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setText(""
				+ StartNPC.character.getKnowledgeSkills().getArtofWar());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(mf.MyFont(0, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(156, 32, 31, 20);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(Color.WHITE);
		textField_1.setText(""
				+ StartNPC.character.getKnowledgeSkills().getDiplomacy());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(156, 63, 31, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setBackground(Color.WHITE);
		textField_2.setText(""
				+ StartNPC.character.getKnowledgeSkills().getEtiquette());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(mf.MyFont(0, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(156, 94, 31, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setBackground(Color.WHITE);
		textField_3.setText(""
				+ StartNPC.character.getKnowledgeSkills().getMedicine());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(mf.MyFont(0, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(156, 125, 31, 20);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 0));
		textField_4.setBackground(Color.WHITE);
		textField_4.setText(""
				+ StartNPC.character.getKnowledgeSkills().getOccultism());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(mf.MyFont(0, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 156, 31, 20);
		frame.getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setBackground(Color.WHITE);
		textField_5.setText(""
				+ StartNPC.character.getKnowledgeSkills().getResearch());
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(mf.MyFont(0, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(156, 187, 31, 20);
		frame.getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 0));
		textField_6.setBackground(Color.WHITE);
		textField_6.setText(""
				+ StartNPC.character.getKnowledgeSkills().getNegotiation());
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(mf.MyFont(0, 15));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(156, 218, 31, 20);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setForeground(new Color(0, 0, 0));
		textField_7.setBackground(Color.WHITE);
		textField_7.setText(""
				+ StartNPC.character.getKnowledgeSkills().getSecretKnowledge());
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(mf.MyFont(0, 15));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(156, 252, 31, 20);
		frame.getContentPane().add(textField_7);

		button = new JButton("+");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(139, 69, 19));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(139, 69, 19));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setOpaque(false);
		button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(139, 69, 19));
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setOpaque(false);
		button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(139, 69, 19));
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setOpaque(false);
		button_4 = new JButton("+");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(139, 69, 19));
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setOpaque(false);
		button_5 = new JButton("+");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(139, 69, 19));
		button_5.setBorderPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setFocusPainted(false);
		button_5.setOpaque(false);
		button_6 = new JButton("+");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBackground(new Color(139, 69, 19));
		button_6.setBorderPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setFocusPainted(false);
		button_6.setOpaque(false);
		button_7 = new JButton("+");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBackground(new Color(139, 69, 19));
		button_7.setBorderPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setFocusPainted(false);
		button_7.setOpaque(false);
		button_8 = new JButton("-");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBackground(new Color(139, 69, 19));
		button_8.setBorderPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setFocusPainted(false);
		button_8.setOpaque(false);
		button_9 = new JButton("-");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_9.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_9.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBackground(new Color(139, 69, 19));
		button_9.setBorderPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setFocusPainted(false);
		button_9.setOpaque(false);
		button_10 = new JButton("-");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_10.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_10.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_10.setForeground(new Color(255, 255, 255));
		button_10.setBackground(new Color(139, 69, 19));
		button_10.setBorderPainted(false);
		button_10.setContentAreaFilled(false);
		button_10.setFocusPainted(false);
		button_10.setOpaque(false);
		button_11 = new JButton("-");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_11.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_11.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_11.setForeground(new Color(255, 255, 255));
		button_11.setBackground(new Color(139, 69, 19));
		button_11.setBorderPainted(false);
		button_11.setContentAreaFilled(false);
		button_11.setFocusPainted(false);
		button_11.setOpaque(false);
		button_12 = new JButton("-");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_12.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_12.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_12.setHorizontalTextPosition(SwingConstants.CENTER);
		button_12.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_12.setForeground(new Color(255, 255, 255));
		button_12.setBackground(new Color(139, 69, 19));
		button_12.setBorderPainted(false);
		button_12.setContentAreaFilled(false);
		button_12.setFocusPainted(false);
		button_12.setOpaque(false);
		button_13 = new JButton("-");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_13.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_13.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_13.setHorizontalTextPosition(SwingConstants.CENTER);
		button_13.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_13.setForeground(new Color(255, 255, 255));
		button_13.setBackground(new Color(139, 69, 19));
		button_13.setBorderPainted(false);
		button_13.setContentAreaFilled(false);
		button_13.setFocusPainted(false);
		button_13.setOpaque(false);
		button_14 = new JButton("-");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_14.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_14.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_14.setHorizontalTextPosition(SwingConstants.CENTER);
		button_14.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_14.setForeground(new Color(255, 255, 255));
		button_14.setBackground(new Color(139, 69, 19));
		button_14.setBorderPainted(false);
		button_14.setContentAreaFilled(false);
		button_14.setFocusPainted(false);
		button_14.setOpaque(false);
		button_15 = new JButton("-");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_15.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				button_15.setIcon(new ImageIcon(ConocimientosNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_15.setHorizontalTextPosition(SwingConstants.CENTER);
		button_15.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton +-.png")));
		button_15.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_15.setForeground(new Color(255, 255, 255));
		button_15.setBackground(new Color(139, 69, 19));
		button_15.setBorderPainted(false);
		button_15.setContentAreaFilled(false);
		button_15.setFocusPainted(false);
		button_15.setOpaque(false);
		if (StartNPC.character.getKnowledgeSkills().getArtofWar() == minAG) {
			button_8.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == minDip) {
			button_9.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getEtiquette() == minEt) {
			button_10.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getMedicine() == minMed) {
			button_11.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getOccultism() == minOc) {
			button_12.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getResearch() == minInv) {
			button_13.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getNegotiation() == minNeg) {
			button_14.setEnabled(false);
		}
		if (StartNPC.character.getKnowledgeSkills().getSecretKnowledge() == minCS) {
			button_15.setEnabled(false);
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setArtofWar(
								StartNPC.character.getKnowledgeSkills()
										.getArtofWar() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getArtofWar());

					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setArtofWar(
								StartNPC.character.getKnowledgeSkills()
										.getArtofWar() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getArtofWar());

					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setArtofWar(
								StartNPC.character.getKnowledgeSkills()
										.getArtofWar() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getArtofWar());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setArtofWar(
											StartNPC.character
													.getKnowledgeSkills()
													.getArtofWar() + 1);
							textField.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getArtofWar());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getArtofWar() >= 5) {
						button.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() >= minAG) {
						button_8.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setDiplomacy(
								StartNPC.character.getKnowledgeSkills()
										.getDiplomacy() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getDiplomacy());

					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setDiplomacy(
								StartNPC.character.getKnowledgeSkills()
										.getDiplomacy() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getDiplomacy());

					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setDiplomacy(
								StartNPC.character.getKnowledgeSkills()
										.getDiplomacy() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getDiplomacy());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setDiplomacy(
											StartNPC.character
													.getKnowledgeSkills()
													.getDiplomacy() + 1);
							textField_1.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getDiplomacy());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() >= 5) {
						button_1.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() >= minDip) {
						button_9.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setEtiquette(
								StartNPC.character.getKnowledgeSkills()
										.getEtiquette() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getEtiquette());

					}

					if (StartNPC.character.getKnowledgeSkills().getEtiquette() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setEtiquette(
								StartNPC.character.getKnowledgeSkills()
										.getEtiquette() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getEtiquette());

					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setEtiquette(
								StartNPC.character.getKnowledgeSkills()
										.getEtiquette() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getEtiquette());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setEtiquette(
											StartNPC.character
													.getKnowledgeSkills()
													.getEtiquette() + 1);
							textField_2.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getEtiquette());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getEtiquette() >= 5) {
						button_2.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() >= minEt) {
						button_10.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getMedicine() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setMedicine(
								StartNPC.character.getKnowledgeSkills()
										.getMedicine() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getMedicine());

					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setMedicine(
								StartNPC.character.getKnowledgeSkills()
										.getMedicine() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getMedicine());

					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setMedicine(
								StartNPC.character.getKnowledgeSkills()
										.getMedicine() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getMedicine());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setMedicine(
											StartNPC.character
													.getKnowledgeSkills()
													.getMedicine() + 1);
							textField_3.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getMedicine());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getMedicine() >= 5) {
						button_3.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() >= minMed) {
						button_11.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getOccultism() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setOccultism(
								StartNPC.character.getKnowledgeSkills()
										.getOccultism() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getOccultism());

					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setOccultism(
								StartNPC.character.getKnowledgeSkills()
										.getOccultism() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getOccultism());

					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setOccultism(
								StartNPC.character.getKnowledgeSkills()
										.getOccultism() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getOccultism());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setOccultism(
											StartNPC.character
													.getKnowledgeSkills()
													.getOccultism() + 1);
							textField_4.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getOccultism());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getOccultism() >= 5) {
						button_4.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() >= minOc) {
						button_12.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills().getResearch() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setResearch(
								StartNPC.character.getKnowledgeSkills()
										.getResearch() + 1);
						textField_5.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getResearch());

					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setResearch(
								StartNPC.character.getKnowledgeSkills()
										.getResearch() + 1);
						textField_5.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getResearch());

					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setResearch(
								StartNPC.character.getKnowledgeSkills()
										.getResearch() + 1);
						textField_5.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getResearch());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setResearch(
											StartNPC.character
													.getKnowledgeSkills()
													.getResearch() + 1);
							textField_5.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getResearch());

						}

					}

					if (StartNPC.character.getKnowledgeSkills().getResearch() >= 5) {
						button_5.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() >= minInv) {
						button_13.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills().setNegotiation(
								StartNPC.character.getKnowledgeSkills()
										.getNegotiation() + 1);
						textField_6.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getNegotiation());

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills().setNegotiation(
								StartNPC.character.getKnowledgeSkills()
										.getNegotiation() + 1);
						textField_6.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getNegotiation());

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills().setNegotiation(
								StartNPC.character.getKnowledgeSkills()
										.getNegotiation() + 1);
						textField_6.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getNegotiation());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setNegotiation(
											StartNPC.character
													.getKnowledgeSkills()
													.getNegotiation() + 1);
							textField_6.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getNegotiation());

						}

					}

					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() >= 5) {
						button_6.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() >= minNeg) {
						button_14.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowledgeSkills()
								.setSecretKnowledge(
										StartNPC.character.getKnowledgeSkills()
												.getSecretKnowledge() + 1);
						textField_7.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getSecretKnowledge());

					}

					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowledgeSkills()
								.setSecretKnowledge(
										StartNPC.character.getKnowledgeSkills()
												.getSecretKnowledge() + 1);
						textField_7.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getSecretKnowledge());

					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowledgeSkills()
								.setSecretKnowledge(
										StartNPC.character.getKnowledgeSkills()
												.getSecretKnowledge() + 1);
						textField_7.setText(""
								+ StartNPC.character.getKnowledgeSkills()
										.getSecretKnowledge());

					} else {
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() < 2) {
							StartNPC.character.getKnowledgeSkills()
									.setSecretKnowledge(
											StartNPC.character
													.getKnowledgeSkills()
													.getSecretKnowledge() + 1);
							textField_7.setText(""
									+ StartNPC.character.getKnowledgeSkills()
											.getSecretKnowledge());

						}

					}

					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() >= 5) {
						button_7.setEnabled(false);
					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() >= minCS) {
						button_15.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setSecretKnowledge(
							StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() - 1);
					textField.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getArtofWar());

					if (StartNPC.character.getKnowledgeSkills().getArtofWar() < 5) {
						button.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() <= minAG) {
						button_8.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setDiplomacy(
							StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() - 1);
					textField_1.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getDiplomacy());

					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() < 5) {
						button_1.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getDiplomacy() <= minDip) {
						button_9.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setEtiquette(
							StartNPC.character.getKnowledgeSkills()
									.getEtiquette() - 1);
					textField_2.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getEtiquette());

					if (StartNPC.character.getKnowledgeSkills().getEtiquette() < 5) {
						button_2.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getEtiquette() <= minEt) {
						button_10.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setMedicine(
							StartNPC.character.getKnowledgeSkills()
									.getMedicine() - 1);
					textField_3.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getMedicine());

					if (StartNPC.character.getKnowledgeSkills().getMedicine() < 5) {
						button_3.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getMedicine() <= minMed) {
						button_11.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setOccultism(
							StartNPC.character.getKnowledgeSkills()
									.getOccultism() - 1);
					textField_4.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getOccultism());

					if (StartNPC.character.getKnowledgeSkills().getOccultism() < 5) {
						button_4.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getOccultism() <= minOc) {
						button_12.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setResearch(
							StartNPC.character.getKnowledgeSkills()
									.getResearch() - 1);
					textField_5.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getResearch());

					if (StartNPC.character.getKnowledgeSkills().getResearch() < minInv) {
						button_5.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills().getResearch() <= 0) {
						button_13.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setNegotiation(
							StartNPC.character.getKnowledgeSkills()
									.getNegotiation() - 1);
					textField_6.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getNegotiation());

					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() < 5) {
						button_6.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills()
							.getNegotiation() <= minNeg) {
						button_14.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowledgeSkills().setSecretKnowledge(
							StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() - 1);
					textField_7.setText(""
							+ StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge());

					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() < 5) {
						button_7.setEnabled(true);
					}
					if (StartNPC.character.getKnowledgeSkills()
							.getSecretKnowledge() == minCS) {
						button_15.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(232, 32, 89, 23);
		frame.getContentPane().add(button);

		button_1.setBounds(232, 63, 89, 23);
		frame.getContentPane().add(button_1);

		button_2.setBounds(232, 94, 89, 23);
		frame.getContentPane().add(button_2);

		button_3.setBounds(232, 125, 89, 23);
		frame.getContentPane().add(button_3);

		button_4.setBounds(232, 156, 89, 23);
		frame.getContentPane().add(button_4);

		button_5.setBounds(232, 187, 89, 23);
		frame.getContentPane().add(button_5);

		button_6.setBounds(232, 218, 89, 23);
		frame.getContentPane().add(button_6);

		button_7.setBounds(232, 252, 89, 23);
		frame.getContentPane().add(button_7);

		button_8.setBounds(331, 32, 89, 23);
		frame.getContentPane().add(button_8);

		button_9.setBounds(331, 62, 89, 23);
		frame.getContentPane().add(button_9);

		button_10.setBounds(331, 94, 89, 23);
		frame.getContentPane().add(button_10);

		button_11.setBounds(331, 125, 89, 23);
		frame.getContentPane().add(button_11);

		button_12.setBounds(331, 156, 89, 23);
		frame.getContentPane().add(button_12);

		button_13.setBounds(331, 187, 89, 23);
		frame.getContentPane().add(button_13);

		button_14.setBounds(331, 218, 89, 23);
		frame.getContentPane().add(button_14);

		button_15.setBounds(331, 252, 89, 23);
		frame.getContentPane().add(button_15);

		btnVolverAHabilidades = new JButton("Volver a Habilidades");
		btnVolverAHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(
						ConocimientosNPC.class
								.getResource("/images/boton volver a habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(
						ConocimientosNPC.class
								.getResource("/images/boton volver a habilidades.png")));

			}
		});
		btnVolverAHabilidades.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolverAHabilidades.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/boton volver a habilidades.png")));
		btnVolverAHabilidades.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnVolverAHabilidades.setForeground(new Color(255, 255, 255));
		btnVolverAHabilidades.setBackground(new Color(139, 69, 19));
		btnVolverAHabilidades.setBorderPainted(false);
		btnVolverAHabilidades.setContentAreaFilled(false);
		btnVolverAHabilidades.setFocusPainted(false);
		btnVolverAHabilidades.setOpaque(false);
		btnVolverAHabilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolverAHabilidades.setFont(mf.MyFont(0, 13));
		btnVolverAHabilidades.setBounds(213, 283, 221, 38);
		frame.getContentPane().add(btnVolverAHabilidades);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConocimientosNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 468, 348);
		frame.getContentPane().add(lblNewLabel);	}

}

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

public class MagiaNPC {

	private JFrame frame;
	private JTextField txtFuego;
	private JTextField txtAgua;
	private JTextField txtTierra;
	private JTextField txtViento;
	private JTextField txtBlanca;
	private JTextField txtNegra;
	private JTextField txtDrudica;
	private JTextField txtArcana;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public static int minFuego = 0;
	public static int minAgua = 0;
	public static int minTierra = 0;
	public static int minViento = 0;
	public static int minBlanca = 0;
	public static int minNegra = 0;
	public static int minDruidica = 0;
	public static int minArcana = 0;
	MorpheusFont mf = new MorpheusFont();

	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton btnVolverAHabilidades;
	private JLabel label;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MagiaNPC window = new MagiaNPC();
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
	public MagiaNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 474, 376);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		txtFuego = new JTextField();
		txtFuego.setOpaque(false);
		txtFuego.setForeground(Color.WHITE);
		txtFuego.setBackground(new Color(205, 133, 63));
		txtFuego.setText("Fuego:");
		txtFuego.setFont(mf.MyFont(0, 13));
		txtFuego.setEditable(false);
		txtFuego.setColumns(10);
		txtFuego.setBorder(null);
		txtFuego.setBounds(10, 32, 41, 20);
		frame.getContentPane().add(txtFuego);

		txtAgua = new JTextField();
		txtAgua.setOpaque(false);
		txtAgua.setForeground(Color.WHITE);
		txtAgua.setBackground(new Color(205, 133, 63));
		txtAgua.setText("Agua:");
		txtAgua.setFont(mf.MyFont(0, 13));
		txtAgua.setEditable(false);
		txtAgua.setColumns(10);
		txtAgua.setBorder(null);
		txtAgua.setBounds(10, 62, 41, 20);
		frame.getContentPane().add(txtAgua);

		txtTierra = new JTextField();
		txtTierra.setOpaque(false);
		txtTierra.setForeground(Color.WHITE);
		txtTierra.setBackground(new Color(205, 133, 63));
		txtTierra.setText("Tierra:");
		txtTierra.setFont(mf.MyFont(0, 13));
		txtTierra.setEditable(false);
		txtTierra.setColumns(10);
		txtTierra.setBorder(null);
		txtTierra.setBounds(10, 92, 41, 20);
		frame.getContentPane().add(txtTierra);

		txtViento = new JTextField();
		txtViento.setOpaque(false);
		txtViento.setForeground(Color.WHITE);
		txtViento.setBackground(new Color(205, 133, 63));
		txtViento.setText("Viento:");
		txtViento.setFont(mf.MyFont(0, 13));
		txtViento.setEditable(false);
		txtViento.setColumns(10);
		txtViento.setBorder(null);
		txtViento.setBounds(10, 122, 41, 20);
		frame.getContentPane().add(txtViento);

		txtBlanca = new JTextField();
		txtBlanca.setOpaque(false);
		txtBlanca.setForeground(Color.WHITE);
		txtBlanca.setBackground(new Color(205, 133, 63));
		txtBlanca.setText("Blanca:");
		txtBlanca.setFont(mf.MyFont(0, 13));
		txtBlanca.setEditable(false);
		txtBlanca.setColumns(10);
		txtBlanca.setBorder(null);
		txtBlanca.setBounds(10, 184, 47, 20);
		frame.getContentPane().add(txtBlanca);

		txtNegra = new JTextField();
		txtNegra.setOpaque(false);
		txtNegra.setForeground(Color.WHITE);
		txtNegra.setBackground(new Color(205, 133, 63));
		txtNegra.setText("Negra:");
		txtNegra.setFont(mf.MyFont(0, 13));
		txtNegra.setEditable(false);
		txtNegra.setColumns(10);
		txtNegra.setBorder(null);
		txtNegra.setBounds(10, 215, 41, 20);
		frame.getContentPane().add(txtNegra);

		txtDrudica = new JTextField();
		txtDrudica.setOpaque(false);
		txtDrudica.setForeground(Color.WHITE);
		txtDrudica.setBackground(new Color(205, 133, 63));
		txtDrudica.setText("Dru\u00EDdica:");
		txtDrudica.setFont(mf.MyFont(0, 13));
		txtDrudica.setEditable(false);
		txtDrudica.setColumns(10);
		txtDrudica.setBorder(null);
		txtDrudica.setBounds(10, 153, 54, 20);
		frame.getContentPane().add(txtDrudica);

		txtArcana = new JTextField();
		txtArcana.setOpaque(false);
		txtArcana.setForeground(Color.WHITE);
		txtArcana.setBackground(new Color(205, 133, 63));
		txtArcana.setText("Arcana:");
		txtArcana.setFont(mf.MyFont(0, 13));
		txtArcana.setEditable(false);
		txtArcana.setColumns(10);
		txtArcana.setBorder(null);
		txtArcana.setBounds(10, 246, 47, 20);
		frame.getContentPane().add(txtArcana);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setText("" + StartNPC.character.getMagicSkills().getFire());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(mf.MyFont(0, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(120, 32, 31, 20);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1
				.setText("" + StartNPC.character.getMagicSkills().getWater());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 62, 31, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2
				.setText("" + StartNPC.character.getMagicSkills().getEarth());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(mf.MyFont(0, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 92, 31, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setText("" + StartNPC.character.getMagicSkills().getWind());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(mf.MyFont(0, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 122, 31, 20);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBackground(Color.WHITE);
		textField_4
				.setText("" + StartNPC.character.getMagicSkills().getWhite());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(mf.MyFont(0, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(120, 184, 31, 20);
		frame.getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBackground(Color.WHITE);
		textField_5
				.setText("" + StartNPC.character.getMagicSkills().getBlack());
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(mf.MyFont(0, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(120, 215, 31, 20);
		frame.getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBackground(Color.WHITE);
		textField_6.setText(""
				+ StartNPC.character.getMagicSkills().getDruidic());
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(mf.MyFont(0, 15));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(120, 153, 31, 20);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBackground(Color.WHITE);
		textField_7.setText(""
				+ StartNPC.character.getMagicSkills().getArcane());
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(mf.MyFont(0, 15));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(120, 246, 31, 20);
		frame.getContentPane().add(textField_7);

		final JButton button = new JButton("+");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button.setForeground(Color.WHITE);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.setBackground(new Color(139, 69, 19));
		final JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_1.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_1.setBackground(new Color(139, 69, 19));
		final JButton button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_2.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_2.setBackground(new Color(139, 69, 19));
		final JButton button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_3.setForeground(Color.WHITE);
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_3.setBackground(new Color(139, 69, 19));
		final JButton button_4 = new JButton("+");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_4.setForeground(Color.WHITE);
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_4.setBackground(new Color(139, 69, 19));
		final JButton button_5 = new JButton("+");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_5.setForeground(Color.WHITE);
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_5.setBackground(new Color(139, 69, 19));
		final JButton button_6 = new JButton("+");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_6.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_6.setForeground(Color.WHITE);
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_6.setBackground(new Color(139, 69, 19));
		final JButton button_7 = new JButton("+");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_7.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_7.setForeground(Color.WHITE);
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_7.setBackground(new Color(139, 69, 19));
		button_8 = new JButton("-");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_8.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_8.setBackground(new Color(139, 69, 19));
		button_9 = new JButton("-");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_9.setBackground(new Color(139, 69, 19));
		button_10 = new JButton("-");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_10.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_10.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_10.setForeground(new Color(255, 255, 255));
		button_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_10.setBackground(new Color(139, 69, 19));
		button_11 = new JButton("-");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_11.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_11.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_11.setForeground(new Color(255, 255, 255));
		button_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_11.setBackground(new Color(139, 69, 19));
		button_12 = new JButton("-");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_12.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_12.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_12.setHorizontalTextPosition(SwingConstants.CENTER);
		button_12.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_12.setForeground(new Color(255, 255, 255));
		button_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_12.setBackground(new Color(139, 69, 19));
		button_13 = new JButton("-");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_13.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_13.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_13.setHorizontalTextPosition(SwingConstants.CENTER);
		button_13.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_13.setForeground(new Color(255, 255, 255));
		button_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_13.setBackground(new Color(139, 69, 19));
		button_14 = new JButton("-");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_14.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_14.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_14.setHorizontalTextPosition(SwingConstants.CENTER);
		button_14.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_14.setForeground(new Color(255, 255, 255));
		button_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_14.setBackground(new Color(139, 69, 19));
		button_15 = new JButton("-");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_15.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_15.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_15.setHorizontalTextPosition(SwingConstants.CENTER);
		button_15.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton +-.png")));
		button_15.setForeground(new Color(255, 255, 255));
		button_15.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_15.setBackground(new Color(139, 69, 19));

		button.setBounds(232, 32, 89, 23);
		frame.getContentPane().add(button);

		button_1.setBounds(232, 62, 89, 23);
		frame.getContentPane().add(button_1);

		button_2.setBounds(232, 92, 89, 23);
		frame.getContentPane().add(button_2);

		button_3.setBounds(232, 122, 89, 23);
		frame.getContentPane().add(button_3);

		button_4.setBounds(232, 184, 89, 23);
		frame.getContentPane().add(button_4);

		button_5.setBounds(232, 215, 89, 23);
		frame.getContentPane().add(button_5);

		button_6.setBounds(232, 153, 89, 23);
		frame.getContentPane().add(button_6);

		button_7.setBounds(232, 246, 89, 23);
		frame.getContentPane().add(button_7);

		button_8.setBounds(331, 32, 89, 23);
		frame.getContentPane().add(button_8);

		button_9.setBounds(331, 62, 89, 23);
		frame.getContentPane().add(button_9);

		button_10.setBounds(331, 92, 89, 23);
		frame.getContentPane().add(button_10);

		button_11.setBounds(331, 122, 89, 23);
		frame.getContentPane().add(button_11);

		button_12.setBounds(331, 184, 89, 23);
		frame.getContentPane().add(button_12);

		button_13.setBounds(331, 215, 89, 23);
		frame.getContentPane().add(button_13);

		button_14.setBounds(331, 153, 89, 23);
		frame.getContentPane().add(button_14);

		button_15.setBounds(331, 246, 89, 23);
		frame.getContentPane().add(button_15);

		btnVolverAHabilidades = new JButton("Volver a Habilidades");
		btnVolverAHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton volver a habilidades2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(MagiaNPC.class
						.getResource("/images/boton volver a habilidades.png")));
			}
		});
		btnVolverAHabilidades.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolverAHabilidades.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/boton volver a habilidades.png")));
		btnVolverAHabilidades.setForeground(new Color(255, 255, 255));
		btnVolverAHabilidades.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnVolverAHabilidades.setBackground(new Color(139, 69, 19));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setOpaque(false);
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setOpaque(false);
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setOpaque(false);
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setOpaque(false);
		button_5.setBorderPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setFocusPainted(false);
		button_5.setOpaque(false);
		button_6.setBorderPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setFocusPainted(false);
		button_6.setOpaque(false);
		button_7.setBorderPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setFocusPainted(false);
		button_7.setOpaque(false);
		button_8.setBorderPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setFocusPainted(false);
		button_8.setOpaque(false);
		button_9.setBorderPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setFocusPainted(false);
		button_9.setOpaque(false);
		button_10.setBorderPainted(false);
		button_10.setContentAreaFilled(false);
		button_10.setFocusPainted(false);
		button_10.setOpaque(false);
		button_11.setBorderPainted(false);
		button_11.setContentAreaFilled(false);
		button_11.setFocusPainted(false);
		button_11.setOpaque(false);
		button_12.setBorderPainted(false);
		button_12.setContentAreaFilled(false);
		button_12.setFocusPainted(false);
		button_12.setOpaque(false);
		button_13.setBorderPainted(false);
		button_13.setContentAreaFilled(false);
		button_13.setFocusPainted(false);
		button_13.setOpaque(false);
		button_14.setBorderPainted(false);
		button_14.setContentAreaFilled(false);
		button_14.setFocusPainted(false);
		button_14.setOpaque(false);
		button_15.setBorderPainted(false);
		button_15.setContentAreaFilled(false);
		button_15.setFocusPainted(false);
		button_15.setOpaque(false);
		btnVolverAHabilidades.setBorderPainted(false);
		btnVolverAHabilidades.setContentAreaFilled(false);
		btnVolverAHabilidades.setFocusPainted(false);
		btnVolverAHabilidades.setOpaque(false);

		btnVolverAHabilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolverAHabilidades.setFont(mf.MyFont(0, 15));
		btnVolverAHabilidades.setBounds(213, 283, 221, 38);
		frame.getContentPane().add(btnVolverAHabilidades);

		label = new JLabel("");
		label.setIcon(new ImageIcon(MagiaNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		label.setBounds(0, 0, 468, 348);
		frame.getContentPane().add(label);
		if (StartNPC.character.getMagicSkills().getFire() == minFuego) {
			button_8.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getWater() == minAgua) {
			button_9.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getEarth() == minTierra) {
			button_10.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getWind() == minViento) {
			button_11.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getWhite() == minBlanca) {
			button_12.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getBlack() == minNegra) {
			button_13.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getDruidic() == minDruidica) {
			button_14.setEnabled(false);
		}
		if (StartNPC.character.getMagicSkills().getArcane() == minArcana) {
			button_15.setEnabled(false);
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (StartNPC.character.getMagicSkills().getFire() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setFire(
										StartNPC.character.getMagicSkills()
												.getFire() + 1);
						textField
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getFire());

					}
					if (StartNPC.character.getMagicSkills().getFire() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getFire() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getFire() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getFire() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setFire(
										StartNPC.character.getMagicSkills()
												.getFire() + 1);
						textField
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getFire());

					}
					if (StartNPC.character.getMagicSkills().getFire() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setFire(
										StartNPC.character.getMagicSkills()
												.getFire() + 1);
						textField
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getFire());

					} else {
						if (StartNPC.character.getMagicSkills().getFire() < 2) {
							StartNPC.character.getMagicSkills().setFire(
									StartNPC.character.getMagicSkills()
											.getFire() + 1);
							textField.setText(""
									+ StartNPC.character.getMagicSkills()
											.getFire());

						}

					}

					if (StartNPC.character.getMagicSkills().getFire() >= 5) {
						button.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getFire() >= minFuego) {
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
					if (StartNPC.character.getMagicSkills().getWater() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setWater(
										StartNPC.character.getMagicSkills()
												.getWater() + 1);
						textField_1.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWater());

					}
					if (StartNPC.character.getMagicSkills().getWater() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWater() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWater() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWater() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setWater(
										StartNPC.character.getMagicSkills()
												.getWater() + 1);
						textField_1.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWater());

					}
					if (StartNPC.character.getMagicSkills().getWater() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setWater(
										StartNPC.character.getMagicSkills()
												.getWater() + 1);
						textField_1.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWater());

					} else {
						if (StartNPC.character.getMagicSkills().getWater() < 2) {
							StartNPC.character.getMagicSkills().setWater(
									StartNPC.character.getMagicSkills()
											.getWater() + 1);
							textField_1.setText(""
									+ StartNPC.character.getMagicSkills()
											.getWater());

						}

					}

					if (StartNPC.character.getMagicSkills().getWater() >= 5) {
						button_1.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getWater() >= minAgua) {
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
					if (StartNPC.character.getMagicSkills().getEarth() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setEarth(
										StartNPC.character.getMagicSkills()
												.getEarth() + 1);
						textField_2.setText(""
								+ StartNPC.character.getMagicSkills()
										.getEarth());

					}
					if (StartNPC.character.getMagicSkills().getEarth() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getEarth() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getEarth() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getEarth() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setEarth(
										StartNPC.character.getMagicSkills()
												.getEarth() + 1);
						textField_2.setText(""
								+ StartNPC.character.getMagicSkills()
										.getEarth());

					}
					if (StartNPC.character.getMagicSkills().getEarth() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setEarth(
										StartNPC.character.getMagicSkills()
												.getEarth() + 1);
						textField_2.setText(""
								+ StartNPC.character.getMagicSkills()
										.getEarth());

					} else {
						if (StartNPC.character.getMagicSkills().getEarth() < 2) {
							StartNPC.character.getMagicSkills().setEarth(
									StartNPC.character.getMagicSkills()
											.getEarth() + 1);
							textField_2.setText(""
									+ StartNPC.character.getMagicSkills()
											.getEarth());

						}

					}

					if (StartNPC.character.getMagicSkills().getEarth() >= 5) {
						button_2.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getEarth() >= minTierra) {
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
					if (StartNPC.character.getMagicSkills().getWind() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setWind(
										StartNPC.character.getMagicSkills()
												.getWind() + 1);
						textField_3
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getWind());

					}
					if (StartNPC.character.getMagicSkills().getWind() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWind() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWind() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWind() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setWind(
										StartNPC.character.getMagicSkills()
												.getWind() + 1);
						textField_3
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getWind());

					}
					if (StartNPC.character.getMagicSkills().getWind() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setWind(
										StartNPC.character.getMagicSkills()
												.getWind() + 1);
						textField_3
								.setText(""
										+ StartNPC.character.getMagicSkills()
												.getWind());

					} else {
						if (StartNPC.character.getMagicSkills().getWind() < 2) {
							StartNPC.character.getMagicSkills().setWind(
									StartNPC.character.getMagicSkills()
											.getWind() + 1);
							textField_3.setText(""
									+ StartNPC.character.getMagicSkills()
											.getWind());

						}

					}

					if (StartNPC.character.getMagicSkills().getWind() >= 5) {
						button_3.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getWind() >= minViento) {
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
					if (StartNPC.character.getMagicSkills().getWhite() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setWhite(
										StartNPC.character.getMagicSkills()
												.getWhite() + 1);
						textField_4.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWhite());

					}
					if (StartNPC.character.getMagicSkills().getWhite() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWhite() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWhite() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getWhite() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setWhite(
										StartNPC.character.getMagicSkills()
												.getWhite() + 1);
						textField_4.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWhite());

					}
					if (StartNPC.character.getMagicSkills().getWhite() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setWhite(
										StartNPC.character.getMagicSkills()
												.getWhite() + 1);
						textField_4.setText(""
								+ StartNPC.character.getMagicSkills()
										.getWhite());

					} else {
						if (StartNPC.character.getMagicSkills().getWhite() < 2) {
							StartNPC.character.getMagicSkills().setWhite(
									StartNPC.character.getMagicSkills()
											.getWhite() + 1);
							textField_4.setText(""
									+ StartNPC.character.getMagicSkills()
											.getWhite());

						}

					}

					if (StartNPC.character.getMagicSkills().getWhite() >= 5) {
						button_4.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getWhite() >= minBlanca) {
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
					if (StartNPC.character.getMagicSkills().getBlack() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setBlack(
										StartNPC.character.getMagicSkills()
												.getBlack() + 1);
						textField_5.setText(""
								+ StartNPC.character.getMagicSkills()
										.getBlack());

					}
					if (StartNPC.character.getMagicSkills().getBlack() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getBlack() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getBlack() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getBlack() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setBlack(
										StartNPC.character.getMagicSkills()
												.getBlack() + 1);
						textField_5.setText(""
								+ StartNPC.character.getMagicSkills()
										.getBlack());

					}
					if (StartNPC.character.getMagicSkills().getBlack() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setBlack(
										StartNPC.character.getMagicSkills()
												.getBlack() + 1);
						textField_5.setText(""
								+ StartNPC.character.getMagicSkills()
										.getBlack());

					} else {
						if (StartNPC.character.getMagicSkills().getBlack() < 2) {
							StartNPC.character.getMagicSkills().setBlack(
									StartNPC.character.getMagicSkills()
											.getBlack() + 1);
							textField_5.setText(""
									+ StartNPC.character.getMagicSkills()
											.getBlack());

						}

					}

					if (StartNPC.character.getMagicSkills().getBlack() >= 5) {
						button_5.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getBlack() >= minNegra) {
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
					if (StartNPC.character.getMagicSkills().getDruidic() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills().setDruidic(
								StartNPC.character.getMagicSkills()
										.getDruidic() + 1);
						textField_6.setText(""
								+ StartNPC.character.getMagicSkills()
										.getDruidic());

					}
					if (StartNPC.character.getMagicSkills().getDruidic() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getDruidic() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getDruidic() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getDruidic() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills().setDruidic(
								StartNPC.character.getMagicSkills()
										.getDruidic() + 1);
						textField_6.setText(""
								+ StartNPC.character.getMagicSkills()
										.getDruidic());

					}
					if (StartNPC.character.getMagicSkills().getDruidic() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills().setDruidic(
								StartNPC.character.getMagicSkills()
										.getDruidic() + 1);
						textField_6.setText(""
								+ StartNPC.character.getMagicSkills()
										.getDruidic());

					} else {
						if (StartNPC.character.getMagicSkills().getDruidic() < 2) {
							StartNPC.character.getMagicSkills().setDruidic(
									StartNPC.character.getMagicSkills()
											.getDruidic() + 1);
							textField_6.setText(""
									+ StartNPC.character.getMagicSkills()
											.getDruidic());

						}

					}

					if (StartNPC.character.getMagicSkills().getDruidic() >= 5) {
						button_6.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getDruidic() >= minDruidica) {
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
					if (StartNPC.character.getMagicSkills().getArcane() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getMagicSkills()
								.setArcane(
										StartNPC.character.getMagicSkills()
												.getArcane() + 1);
						textField_7.setText(""
								+ StartNPC.character.getMagicSkills()
										.getArcane());

					}
					if (StartNPC.character.getMagicSkills().getArcane() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getArcane() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getArcane() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getMagicSkills().getArcane() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getMagicSkills()
								.setArcane(
										StartNPC.character.getMagicSkills()
												.getArcane() + 1);
						textField_7.setText(""
								+ StartNPC.character.getMagicSkills()
										.getArcane());

					}
					if (StartNPC.character.getMagicSkills().getArcane() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getMagicSkills()
								.setArcane(
										StartNPC.character.getMagicSkills()
												.getArcane() + 1);
						textField_7.setText(""
								+ StartNPC.character.getMagicSkills()
										.getArcane());

					} else {
						if (StartNPC.character.getMagicSkills().getArcane() < 2) {
							StartNPC.character.getMagicSkills().setArcane(
									StartNPC.character.getMagicSkills()
											.getArcane() + 1);
							textField_7.setText(""
									+ StartNPC.character.getMagicSkills()
											.getArcane());

						}

					}

					if (StartNPC.character.getMagicSkills().getArcane() >= 5) {
						button_7.setEnabled(false);
					}
					if (StartNPC.character.getMagicSkills().getArcane() >= minArcana) {
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
					StartNPC.character.getMagicSkills().setFire(
							StartNPC.character.getMagicSkills().getFire() - 1);
					textField.setText(""
							+ StartNPC.character.getMagicSkills().getFire());

					if (StartNPC.character.getMagicSkills().getFire() < 5) {
						button.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getFire() <= minFuego) {
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
					StartNPC.character.getMagicSkills().setWater(
							StartNPC.character.getMagicSkills().getWater() - 1);
					textField_1.setText(""
							+ StartNPC.character.getMagicSkills().getWater());

					if (StartNPC.character.getMagicSkills().getWater() < 5) {
						button_1.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getWater() <= minAgua) {
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
					StartNPC.character.getMagicSkills().setEarth(
							StartNPC.character.getMagicSkills().getEarth() - 1);
					textField_2.setText(""
							+ StartNPC.character.getMagicSkills().getEarth());

					if (StartNPC.character.getMagicSkills().getEarth() < 5) {
						button_2.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getEarth() <= minTierra) {
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
					StartNPC.character.getMagicSkills().setWind(
							StartNPC.character.getMagicSkills().getWind() - 1);
					textField_3.setText(""
							+ StartNPC.character.getMagicSkills().getWind());

					if (StartNPC.character.getMagicSkills().getWind() < 5) {
						button_3.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getWind() <= minViento) {
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
					StartNPC.character.getMagicSkills().setWhite(
							StartNPC.character.getMagicSkills().getWhite() - 1);
					textField_4.setText(""
							+ StartNPC.character.getMagicSkills().getWhite());

					if (StartNPC.character.getMagicSkills().getWhite() < 5) {
						button_4.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getWhite() <= minBlanca) {
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
					StartNPC.character.getMagicSkills().setBlack(
							StartNPC.character.getMagicSkills().getBlack() - 1);
					textField_5.setText(""
							+ StartNPC.character.getMagicSkills().getBlack());

					if (StartNPC.character.getMagicSkills().getBlack() < 5) {
						button_5.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getBlack() <= minNegra) {
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
					StartNPC.character.getMagicSkills()
							.setDruidic(
									StartNPC.character.getMagicSkills()
											.getDruidic() - 1);
					textField_6.setText(""
							+ StartNPC.character.getMagicSkills().getDruidic());

					if (StartNPC.character.getMagicSkills().getDruidic() < 5) {
						button_6.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getDruidic() <= minDruidica) {
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
					StartNPC.character.getMagicSkills()
							.setArcane(
									StartNPC.character.getMagicSkills()
											.getArcane() - 1);
					textField_7.setText(""
							+ StartNPC.character.getMagicSkills().getArcane());

					if (StartNPC.character.getMagicSkills().getArcane() < 5) {
						button_7.setEnabled(true);
					}
					if (StartNPC.character.getMagicSkills().getArcane() <= minArcana) {
						button_15.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

}

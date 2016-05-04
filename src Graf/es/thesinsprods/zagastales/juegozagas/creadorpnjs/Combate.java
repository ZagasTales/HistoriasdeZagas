package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

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
import es.thesinsprods.zagastales.characters.OutOfPointsException;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;

public class Combate {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtPuntos;
	private JTextField txtArmasDeUna;
	private JTextField txtArmasDeDos;
	private JTextField txtArmasDeAsta;
	private JTextField txtArmasADistancia;
	private JTextField txtEsquivar;
	private JTextField txtBloquear;
	private static JTextField textField_6;
	public static int minUna = 0;
	public static int minDos = 0;
	public static int minAsta = 0;
	public static int minDist = 0;
	public static int minEsq = 0;
	public static int minBloq = 0;
	MorpheusFont mf = new MorpheusFont();
	public static JTextField getTextField_6() {
		return textField_6;
	}

	public static void setTextField_6(JTextField textField_6) {
		Combate.textField_6 = textField_6;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate window = new Combate();
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
	public Combate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						Armas.class
								.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 474, 376);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		txtPuntos = new JTextField();
		txtPuntos.setOpaque(false);
		txtPuntos.setForeground(Color.WHITE);
		txtPuntos.setBackground(new Color(205, 133, 63));
		txtPuntos.setBorder(null);
		txtPuntos.setText("Puntos:");
		txtPuntos.setEditable(false);
		txtPuntos.setFont(mf.MyFont(0, 13));
		txtPuntos.setBounds(10, 301, 86, 20);
		frame.getContentPane().add(txtPuntos);
		txtPuntos.setColumns(10);

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(mf.MyFont(0, 15));
		textField.setEditable(false);
		textField.setBounds(146, 32, 31, 20);
		frame.getContentPane().add(textField);
		textField
				.setText("" + Start.character.getCombatSkills().getOneHanded());
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(Color.WHITE);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(146, 72, 31, 20);
		textField_1.setText(""
				+ Start.character.getCombatSkills().getTwoHanded());
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setBackground(Color.WHITE);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(mf.MyFont(0, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 112, 31, 20);
		textField_2.setText("" + Start.character.getCombatSkills().getPole());
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setBackground(Color.WHITE);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(mf.MyFont(0, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(146, 152, 31, 20);
		textField_3.setText("" + Start.character.getCombatSkills().getRanged());
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 0));
		textField_4.setBackground(Color.WHITE);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(mf.MyFont(0, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(146, 192, 31, 20);
		textField_4.setText("" + Start.character.getCombatSkills().getDodge());
		frame.getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setBackground(Color.WHITE);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(mf.MyFont(0, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(146, 232, 31, 20);
		textField_5.setText("" + Start.character.getCombatSkills().getBlock());
		frame.getContentPane().add(textField_5);

		txtArmasDeUna = new JTextField();
		txtArmasDeUna.setOpaque(false);
		txtArmasDeUna.setForeground(Color.WHITE);
		txtArmasDeUna.setBackground(new Color(205, 133, 63));
		txtArmasDeUna.setText("Armas de Una Mano:");
		txtArmasDeUna.setFont(mf.MyFont(0, 13));
		txtArmasDeUna.setEditable(false);
		txtArmasDeUna.setColumns(10);
		txtArmasDeUna.setBorder(null);
		txtArmasDeUna.setBounds(10, 32, 126, 20);
		frame.getContentPane().add(txtArmasDeUna);

		txtArmasDeDos = new JTextField();
		txtArmasDeDos.setOpaque(false);
		txtArmasDeDos.setForeground(Color.WHITE);
		txtArmasDeDos.setBackground(new Color(205, 133, 63));
		txtArmasDeDos.setText("Armas de Dos Manos:");
		txtArmasDeDos.setFont(mf.MyFont(0, 13));
		txtArmasDeDos.setEditable(false);
		txtArmasDeDos.setColumns(10);
		txtArmasDeDos.setBorder(null);
		txtArmasDeDos.setBounds(10, 72, 126, 20);
		frame.getContentPane().add(txtArmasDeDos);

		txtArmasDeAsta = new JTextField();
		txtArmasDeAsta.setOpaque(false);
		txtArmasDeAsta.setForeground(Color.WHITE);
		txtArmasDeAsta.setBackground(new Color(205, 133, 63));
		txtArmasDeAsta.setText("Armas de Asta:");
		txtArmasDeAsta.setFont(mf.MyFont(0, 13));
		txtArmasDeAsta.setEditable(false);
		txtArmasDeAsta.setColumns(10);
		txtArmasDeAsta.setBorder(null);
		txtArmasDeAsta.setBounds(10, 112, 86, 20);
		frame.getContentPane().add(txtArmasDeAsta);

		txtArmasADistancia = new JTextField();
		txtArmasADistancia.setOpaque(false);
		txtArmasADistancia.setForeground(Color.WHITE);
		txtArmasADistancia.setBackground(new Color(205, 133, 63));
		txtArmasADistancia.setText("Armas a Distancia:");
		txtArmasADistancia.setFont(mf.MyFont(0, 13));
		txtArmasADistancia.setEditable(false);
		txtArmasADistancia.setColumns(10);
		txtArmasADistancia.setBorder(null);
		txtArmasADistancia.setBounds(10, 152, 126, 20);
		frame.getContentPane().add(txtArmasADistancia);

		txtEsquivar = new JTextField();
		txtEsquivar.setOpaque(false);
		txtEsquivar.setForeground(Color.WHITE);
		txtEsquivar.setBackground(new Color(205, 133, 63));
		txtEsquivar.setText("Esquivar:");
		txtEsquivar.setFont(mf.MyFont(0, 13));
		txtEsquivar.setEditable(false);
		txtEsquivar.setColumns(10);
		txtEsquivar.setBorder(null);
		txtEsquivar.setBounds(10, 192, 86, 20);
		frame.getContentPane().add(txtEsquivar);

		txtBloquear = new JTextField();
		txtBloquear.setOpaque(false);
		txtBloquear.setForeground(Color.WHITE);
		txtBloquear.setBackground(new Color(205, 133, 63));
		txtBloquear.setText("Bloquear:");
		txtBloquear.setFont(mf.MyFont(0, 13));
		txtBloquear.setEditable(false);
		txtBloquear.setColumns(10);
		txtBloquear.setBorder(null);
		txtBloquear.setBounds(10, 232, 86, 20);
		frame.getContentPane().add(txtBloquear);

		final JButton button = new JButton("+");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(139, 69, 19));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		final JButton button_1 = new JButton("+");
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_1.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_1.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(139, 69, 19));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setOpaque(false);
		final JButton button_2 = new JButton("+");
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_2.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_2.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(139, 69, 19));
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setOpaque(false);
		final JButton button_3 = new JButton("+");
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_3.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(139, 69, 19));
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setOpaque(false);
		final JButton button_4 = new JButton("+");
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_4.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(139, 69, 19));
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setOpaque(false);
		final JButton button_5 = new JButton("+");
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_5.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(139, 69, 19));
		button_5.setBorderPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setFocusPainted(false);
		button_5.setOpaque(false);
		final JButton button_6 = new JButton("-");
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_6.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_6.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_6.setOpaque(false);
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBackground(new Color(139, 69, 19));
		button_6.setBorderPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setFocusPainted(false);
		button_6.setOpaque(false);
		final JButton button_7 = new JButton("-");
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_7.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});

		button_7.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_7.setOpaque(false);
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBackground(new Color(139, 69, 19));
		button_7.setBorderPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setFocusPainted(false);
		button_7.setOpaque(false);
		final JButton button_8 = new JButton("-");
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_8.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_8.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_8.setOpaque(false);
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBackground(new Color(139, 69, 19));
		button_8.setBorderPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setFocusPainted(false);
		button_8.setOpaque(false);
		final JButton button_9 = new JButton("-");
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_9.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_9.setOpaque(false);
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBackground(new Color(139, 69, 19));
		button_9.setBorderPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setFocusPainted(false);
		button_9.setOpaque(false);
		final JButton button_10 = new JButton("-");
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_10.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_10.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_10.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_10.setOpaque(false);
		button_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_10.setForeground(new Color(255, 255, 255));
		button_10.setBackground(new Color(139, 69, 19));
		button_10.setBorderPainted(false);
		button_10.setContentAreaFilled(false);
		button_10.setFocusPainted(false);
		button_10.setOpaque(false);
		final JButton button_11 = new JButton("-");
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_11.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				button_11.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton +-.png")));
			}
		});
		button_11.setIcon(new ImageIcon(Combate.class
				.getResource("/images/boton +-.png")));
		button_11.setOpaque(false);
		button_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_11.setForeground(new Color(255, 255, 255));
		button_11.setBackground(new Color(139, 69, 19));
		button_11.setBorderPainted(false);
		button_11.setContentAreaFilled(false);
		button_11.setFocusPainted(false);
		button_11.setOpaque(false);
		final JButton button_12 = new JButton("+");
		final JButton button_13 = new JButton("+");
		button_13.setBackground(Color.ORANGE);
		final JButton button_14 = new JButton("+");
		button_14.setBackground(Color.ORANGE);
		final JButton button_15 = new JButton("+");
		button_15.setBackground(Color.ORANGE);
		final JButton button_16 = new JButton("+");
		button_16.setBackground(Color.ORANGE);
		final JButton button_17 = new JButton("+");
		button_17.setBackground(Color.ORANGE);
		if (Start.character.getCombatSkills().getOneHanded() == 5) {
			button.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getTwoHanded() == 5) {
			button_1.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getPole() == 5) {
			button_2.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getRanged() == 5) {
			button_3.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getDodge() == 5) {
			button_4.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getBlock() == 5) {
			button_5.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getOneHanded() == minUna) {
			button_6.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getTwoHanded() == minDos) {
			button_7.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getPole() == minAsta) {
			button_8.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getRanged() == minDist) {
			button_9.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getDodge() == minEsq) {
			button_10.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getBlock() == minBloq) {
			button_11.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getOneHanded() == 5) {
			button_12.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getTwoHanded() == 5) {
			button_13.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getPole() == 5) {
			button_14.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getRanged() == 5) {
			button_15.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getDodge() == 5) {
			button_16.setEnabled(false);
		}
		if (Start.character.getCombatSkills().getBlock() == 5) {
			button_17.setEnabled(false);
		}

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getOneHanded() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increaseOne(
								Start.skpoints);
						textField.setText(""
								+ Start.character.getCombatSkills()
										.getOneHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getOneHanded() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getOneHanded() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getOneHanded() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getOneHanded() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increaseOne(
								Start.skpoints);
						textField.setText(""
								+ Start.character.getCombatSkills()
										.getOneHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getOneHanded() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increaseOne(
								Start.skpoints);
						textField.setText(""
								+ Start.character.getCombatSkills()
										.getOneHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getOneHanded() < 2) {
							Start.character.getCombatSkills().increaseOne(
									Start.skpoints);
							textField.setText(""
									+ Start.character.getCombatSkills()
											.getOneHanded());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getOneHanded() >= 5) {
						button.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getOneHanded() >= minUna) {
						button_6.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();

				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}

		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getTwoHanded() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increaseTwo(
								Start.skpoints);
						textField_1.setText(""
								+ Start.character.getCombatSkills()
										.getTwoHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getTwoHanded() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getTwoHanded() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getTwoHanded() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getTwoHanded() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increaseTwo(
								Start.skpoints);
						textField_1.setText(""
								+ Start.character.getCombatSkills()
										.getTwoHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getTwoHanded() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increaseTwo(
								Start.skpoints);
						textField_1.setText(""
								+ Start.character.getCombatSkills()
										.getTwoHanded());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getTwoHanded() < 2) {
							Start.character.getCombatSkills().increaseTwo(
									Start.skpoints);
							textField_1.setText(""
									+ Start.character.getCombatSkills()
											.getTwoHanded());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getTwoHanded() >= 5) {
						button_1.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getTwoHanded() >= minDos) {
						button_7.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getPole() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increasePole(
								Start.skpoints);
						textField_2.setText(""
								+ Start.character.getCombatSkills().getPole());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getPole() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getPole() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getPole() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getPole() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increasePole(
								Start.skpoints);
						textField_2.setText(""
								+ Start.character.getCombatSkills().getPole());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getPole() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increasePole(
								Start.skpoints);
						textField_2.setText(""
								+ Start.character.getCombatSkills().getPole());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getPole() < 2) {
							Start.character.getCombatSkills().increasePole(
									Start.skpoints);
							textField_2.setText(""
									+ Start.character.getCombatSkills()
											.getPole());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getPole() >= 5) {
						button_2.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getPole() >= minAsta) {
						button_8.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getRanged() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increaseRanged(
								Start.skpoints);
						textField_3
								.setText(""
										+ Start.character.getCombatSkills()
												.getRanged());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getRanged() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getRanged() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getRanged() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getRanged() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increaseRanged(
								Start.skpoints);
						textField_3
								.setText(""
										+ Start.character.getCombatSkills()
												.getRanged());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getRanged() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increaseRanged(
								Start.skpoints);
						textField_3
								.setText(""
										+ Start.character.getCombatSkills()
												.getRanged());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getRanged() < 2) {
							Start.character.getCombatSkills().increaseRanged(
									Start.skpoints);
							textField_3.setText(""
									+ Start.character.getCombatSkills()
											.getRanged());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getRanged() >= 5) {
						button_3.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getRanged() >= minDist) {
						button_9.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getDodge() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increaseDodge(
								Start.skpoints);
						textField_4.setText(""
								+ Start.character.getCombatSkills().getDodge());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getDodge() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getDodge() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getDodge() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getDodge() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increaseDodge(
								Start.skpoints);
						textField_4.setText(""
								+ Start.character.getCombatSkills().getDodge());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getDodge() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increaseDodge(
								Start.skpoints);
						textField_4.setText(""
								+ Start.character.getCombatSkills().getDodge());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getDodge() < 2) {
							Start.character.getCombatSkills().increaseDodge(
									Start.skpoints);
							textField_4.setText(""
									+ Start.character.getCombatSkills()
											.getDodge());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getDodge() >= 5) {
						button_4.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getDodge() >= minEsq) {
						button_10.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();

				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Start.character.getCombatSkills().getBlock() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro")) {
						Start.character.getCombatSkills().increaseBlock(
								Start.skpoints);
						textField_5.setText(""
								+ Start.character.getCombatSkills().getBlock());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getBlock() == 3
							&& Start.character.getPrivileges()
									.Search("Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getBlock() == 4
							&& Start.character.getPrivileges()
									.Search("Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getBlock() == 2
							&& Start.character.getSetbacks().Search("Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (Start.character.getCombatSkills().getBlock() == 3
							&& Start.character.getPrivileges()
									.Search("Experto")) {
						Start.character.getCombatSkills().increaseBlock(
								Start.skpoints);
						textField_5.setText(""
								+ Start.character.getCombatSkills().getBlock());
						textField_6.setText("" + Start.skpoints.getPoints());
					}
					if (Start.character.getCombatSkills().getBlock() < 3
							&& (Start.character.getSetbacks()
									.Search("Aprendiz") == false || Start.character
									.getSetbacks() == null)) {
						Start.character.getCombatSkills().increaseBlock(
								Start.skpoints);
						textField_5.setText(""
								+ Start.character.getCombatSkills().getBlock());
						textField_6.setText("" + Start.skpoints.getPoints());
					} else {
						if (Start.character.getCombatSkills().getBlock() < 2) {
							Start.character.getCombatSkills().increaseBlock(
									Start.skpoints);
							textField_5.setText(""
									+ Start.character.getCombatSkills()
											.getBlock());
							textField_6.setText("" + Start.skpoints.getPoints());
						}

					}

					if (Start.character.getCombatSkills().getBlock() >= 5) {
						button_5.setEnabled(false);
					}
					if (Start.character.getCombatSkills().getBlock() >= minBloq) {
						button_11.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreaseOne(
							Start.skpoints);
					textField.setText(""
							+ Start.character.getCombatSkills().getOneHanded());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getOneHanded() < 5) {
						button.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getOneHanded() <= minUna) {
						button_6.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreaseTwo(
							Start.skpoints);
					textField_1.setText(""
							+ Start.character.getCombatSkills().getTwoHanded());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getTwoHanded() < 5) {
						button_1.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getTwoHanded() <= minDos) {
						button_7.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreasePole(
							Start.skpoints);
					textField_2.setText(""
							+ Start.character.getCombatSkills().getPole());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getPole() < 5) {
						button_2.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getPole() <= minAsta) {
						button_8.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreaseRanged(
							Start.skpoints);
					textField_3.setText(""
							+ Start.character.getCombatSkills().getRanged());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getRanged() < 5) {
						button_3.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getRanged() <= minDist) {
						button_9.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreaseDodge(
							Start.skpoints);
					textField_4.setText(""
							+ Start.character.getCombatSkills().getDodge());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getDodge() < 5) {
						button_4.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getDodge() <= minEsq) {
						button_10.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Start.character.getCombatSkills().decreaseBlock(
							Start.skpoints);
					textField_5.setText(""
							+ Start.character.getCombatSkills().getBlock());
					textField_6.setText("" + Start.skpoints.getPoints());
					if (Start.character.getCombatSkills().getBlock() < 5) {
						button_5.setEnabled(true);
					}
					if (Start.character.getCombatSkills().getBlock() <= minBloq) {
						button_11.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutOfPointsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Magia.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Conocimientos.getTextField_8().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Habilidades.getTextField().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
				try {
					Destrezas.getTextField_5().setText(
							"" + Start.skpoints.getPoints());
				} catch (NullPointerException e) {
				}
			}
		});
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minUna += 1;
					Start.character.getCombatSkills()
							.setOneHanded(
									Start.character.getCombatSkills()
											.getOneHanded() + 1);
					Start.ektraapp = "UnaM";
					button.setVisible(true);
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField.setText(""
							+ Start.character.getCombatSkills().getOneHanded());
					Start.contadorBEktra = 1;

				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minDos += 1;
					Start.character.getCombatSkills()
							.setTwoHanded(
									Start.character.getCombatSkills()
											.getTwoHanded() + 1);
					Start.ektraapp = "DosM";
					button.setVisible(true);
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField_1.setText(""
							+ Start.character.getCombatSkills().getTwoHanded());
					Start.contadorBEktra = 1;
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minAsta += 1;
					Start.character.getCombatSkills().setPole(
							Start.character.getCombatSkills().getPole() + 1);
					Start.ektraapp = "Asta";
					button.setVisible(true);
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField_2.setText(""
							+ Start.character.getCombatSkills().getPole());
					Start.contadorBEktra = 1;
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minDist += 1;
					Start.character.getCombatSkills().setRanged(
							Start.character.getCombatSkills().getRanged() + 1);
					button.setVisible(true);
					Start.ektraapp = "Dist";
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField_3.setText(""
							+ Start.character.getCombatSkills().getRanged());
					Start.contadorBEktra = 1;
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minEsq += 1;
					Start.character.getCombatSkills().setDodge(
							Start.character.getCombatSkills().getDodge() + 1);
					Start.ektraapp = "Esq";
					button.setVisible(true);
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField_4.setText(""
							+ Start.character.getCombatSkills().getDodge());
					Start.contadorBEktra = 1;
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					minBloq += 1;
					Start.character.getCombatSkills().setBlock(
							Start.character.getCombatSkills().getBlock() + 1);
					Start.ektraapp = "Bloq";
					button.setVisible(true);
					button_1.setVisible(true);
					button_2.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					button_5.setVisible(true);
					button_6.setVisible(true);
					button_7.setVisible(true);
					button_8.setVisible(true);
					button_9.setVisible(true);
					button_10.setVisible(true);
					button_11.setVisible(true);
					button_12.setVisible(false);
					button_13.setVisible(false);
					button_14.setVisible(false);
					button_15.setVisible(false);
					button_16.setVisible(false);
					button_17.setVisible(false);
					textField_5.setText(""
							+ Start.character.getCombatSkills().getBlock());
					Start.contadorBEktra = 1;
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_12.setBackground(Color.ORANGE);

		if (Start.character.getBlessing().getBlessing()
				.equals("Espada de Éktra")
				&& Start.contadorBEktra == 0) {
			button.setVisible(false);
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
			button_4.setVisible(false);
			button_5.setVisible(false);
			button_6.setVisible(false);
			button_7.setVisible(false);
			button_8.setVisible(false);
			button_9.setVisible(false);
			button_10.setVisible(false);
			button_11.setVisible(false);
			button_12.setVisible(true);
			button_13.setVisible(true);
			button_14.setVisible(true);
			button_15.setVisible(true);
			button_16.setVisible(true);
			button_17.setVisible(true);

		} else {
			button_12.setVisible(false);
			button_13.setVisible(false);
			button_14.setVisible(false);
			button_15.setVisible(false);
			button_16.setVisible(false);
			button_17.setVisible(false);

		}
		button.setBounds(232, 32, 89, 23);
		frame.getContentPane().add(button);

		button_1.setBounds(232, 72, 89, 23);
		frame.getContentPane().add(button_1);

		button_2.setBounds(232, 112, 89, 23);
		frame.getContentPane().add(button_2);

		button_3.setBounds(232, 152, 89, 23);
		frame.getContentPane().add(button_3);

		button_4.setBounds(232, 192, 89, 23);
		frame.getContentPane().add(button_4);

		button_5.setBounds(232, 232, 89, 23);
		frame.getContentPane().add(button_5);

		button_6.setBounds(331, 32, 89, 23);
		frame.getContentPane().add(button_6);

		button_7.setBounds(331, 72, 89, 23);
		frame.getContentPane().add(button_7);

		button_8.setBounds(331, 112, 89, 23);
		frame.getContentPane().add(button_8);

		button_9.setBounds(331, 152, 89, 23);
		frame.getContentPane().add(button_9);

		button_10.setBounds(331, 192, 89, 23);
		frame.getContentPane().add(button_10);

		button_11.setBounds(331, 232, 89, 23);
		frame.getContentPane().add(button_11);

		button_12.setBounds(232, 32, 89, 23);
		frame.getContentPane().add(button_12);

		button_13.setBounds(232, 72, 89, 23);
		frame.getContentPane().add(button_13);

		button_14.setBounds(232, 112, 89, 23);
		frame.getContentPane().add(button_14);

		button_15.setBounds(232, 152, 89, 23);
		frame.getContentPane().add(button_15);

		button_16.setBounds(232, 192, 89, 23);
		frame.getContentPane().add(button_16);

		button_17.setBounds(232, 232, 89, 23);
		frame.getContentPane().add(button_17);

		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 0));
		textField_6.setBackground(Color.WHITE);
		textField_6.setText("" + Start.skpoints.getPoints());
		textField_6.setEditable(false);

		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(mf.MyFont(0, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(82, 301, 31, 20);
		frame.getContentPane().add(textField_6);

		final JButton btnVolverAHabilidades = new JButton(
				"Volver a Habilidades");
		btnVolverAHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton volver a habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(Combate.class
						.getResource("/images/boton volver a habilidades.png")));

			}
		});
		btnVolverAHabilidades.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolverAHabilidades.setIcon(new ImageIcon(Combate.class
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
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVolverAHabilidades.setFont(mf.MyFont(0, 13));
		btnVolverAHabilidades.setBounds(213, 283, 221, 38);
		frame.getContentPane().add(btnVolverAHabilidades);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Combate.class
				.getResource("/images/background-habilidades2.jpg")));
		lblNewLabel.setBounds(0, 0, 468, 348);
		frame.getContentPane().add(lblNewLabel);
	}

}
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

public class DestrezasNPC {

	private JFrame frame;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private JTextField txtAtletismo;
	private JTextField txtSupervivencia;
	private JTextField txtEquitacin;
	private JTextField txtTrampas;
	private JTextField txtSigilo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static int minAtl = 0;
	public static int minSup = 0;
	public static int minEq = 0;
	public static int minTra = 0;
	public static int minSig = 0;
	MorpheusFont mf = new MorpheusFont();

	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton btnVolverAHabilidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DestrezasNPC window = new DestrezasNPC();
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
	public DestrezasNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 474, 376);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		txtAtletismo = new JTextField();
		txtAtletismo.setOpaque(false);
		txtAtletismo.setForeground(Color.WHITE);
		txtAtletismo.setBackground(new Color(205, 133, 63));
		txtAtletismo.setText("Atletismo:");
		txtAtletismo.setFont(mf.MyFont(0, 13));
		txtAtletismo.setEditable(false);
		txtAtletismo.setColumns(10);
		txtAtletismo.setBorder(null);
		txtAtletismo.setBounds(10, 30, 62, 20);
		frame.getContentPane().add(txtAtletismo);

		txtSupervivencia = new JTextField();
		txtSupervivencia.setOpaque(false);
		txtSupervivencia.setForeground(Color.WHITE);
		txtSupervivencia.setBackground(new Color(205, 133, 63));
		txtSupervivencia.setText("Supervivencia:");
		txtSupervivencia.setFont(mf.MyFont(0, 13));
		txtSupervivencia.setEditable(false);
		txtSupervivencia.setColumns(10);
		txtSupervivencia.setBorder(null);
		txtSupervivencia.setBounds(10, 80, 91, 20);
		frame.getContentPane().add(txtSupervivencia);

		txtEquitacin = new JTextField();
		txtEquitacin.setOpaque(false);
		txtEquitacin.setForeground(Color.WHITE);
		txtEquitacin.setBackground(new Color(205, 133, 63));
		txtEquitacin.setText("Equitaci\u00F3n:");
		txtEquitacin.setFont(mf.MyFont(0, 13));
		txtEquitacin.setEditable(false);
		txtEquitacin.setColumns(10);
		txtEquitacin.setBorder(null);
		txtEquitacin.setBounds(10, 130, 80, 20);
		frame.getContentPane().add(txtEquitacin);

		txtTrampas = new JTextField();
		txtTrampas.setOpaque(false);
		txtTrampas.setForeground(Color.WHITE);
		txtTrampas.setBackground(new Color(205, 133, 63));
		txtTrampas.setText("Trampas:");
		txtTrampas.setFont(mf.MyFont(0, 13));
		txtTrampas.setEditable(false);
		txtTrampas.setColumns(10);
		txtTrampas.setBorder(null);
		txtTrampas.setBounds(10, 180, 62, 20);
		frame.getContentPane().add(txtTrampas);

		txtSigilo = new JTextField();
		txtSigilo.setOpaque(false);
		txtSigilo.setForeground(Color.WHITE);
		txtSigilo.setBackground(new Color(205, 133, 63));
		txtSigilo.setText("Sigilo:");
		txtSigilo.setFont(mf.MyFont(0, 13));
		txtSigilo.setEditable(false);
		txtSigilo.setColumns(10);
		txtSigilo.setBorder(null);
		txtSigilo.setBounds(10, 230, 62, 20);
		frame.getContentPane().add(txtSigilo);

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setText(""
				+ StartNPC.character.getKnowhowSkills().getAthletics());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(mf.MyFont(0, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(156, 30, 31, 20);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(Color.WHITE);
		textField_1.setText(""
				+ StartNPC.character.getKnowhowSkills().getSurvival());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(156, 80, 31, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setBackground(Color.WHITE);
		textField_2.setText(""
				+ StartNPC.character.getKnowhowSkills().getEquitation());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(mf.MyFont(0, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(156, 130, 31, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setBackground(Color.WHITE);
		textField_3.setText(""
				+ StartNPC.character.getKnowhowSkills().getTraps());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(mf.MyFont(0, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(156, 180, 31, 20);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 0));
		textField_4.setBackground(Color.WHITE);
		textField_4.setText(""
				+ StartNPC.character.getKnowhowSkills().getStealth());
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(mf.MyFont(0, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 230, 31, 20);
		frame.getContentPane().add(textField_4);

		final JButton button = new JButton("+");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.setBackground(new Color(139, 69, 19));
		button.setForeground(new Color(255, 255, 255));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		final JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_1.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_1.setBackground(new Color(139, 69, 19));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setOpaque(false);
		button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_2.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_2.setBackground(new Color(139, 69, 19));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setOpaque(false);

		button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_3.setBackground(new Color(139, 69, 19));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setOpaque(false);

		button_4 = new JButton("+");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_4.setBackground(new Color(139, 69, 19));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setOpaque(false);

		button_5 = new JButton("-");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_5.setBackground(new Color(139, 69, 19));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBorderPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setFocusPainted(false);
		button_5.setOpaque(false);

		button_6 = new JButton("-");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_6.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_6.setBackground(new Color(139, 69, 19));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBorderPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setFocusPainted(false);
		button_6.setOpaque(false);

		button_7 = new JButton("-");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_7.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_7.setBackground(new Color(139, 69, 19));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBorderPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setFocusPainted(false);
		button_7.setOpaque(false);

		button_8 = new JButton("-");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_8.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_8.setBackground(new Color(139, 69, 19));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBorderPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setFocusPainted(false);
		button_8.setOpaque(false);

		button_9 = new JButton("-");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton +-.png")));
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_9.setBackground(new Color(139, 69, 19));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBorderPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setFocusPainted(false);
		button_9.setOpaque(false);

		if (StartNPC.character.getKnowhowSkills().getAthletics() == minAtl) {
			button_5.setEnabled(false);
		}
		if (StartNPC.character.getKnowhowSkills().getSurvival() == minSup) {
			button_6.setEnabled(false);
		}
		if (StartNPC.character.getKnowhowSkills().getEquitation() == minEq) {
			button_7.setEnabled(false);
		}
		if (StartNPC.character.getKnowhowSkills().getTraps() == minTra) {
			button_8.setEnabled(false);
		}
		if (StartNPC.character.getKnowhowSkills().getStealth() == minSig) {
			button_9.setEnabled(false);
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowhowSkills().setAthletics(
								StartNPC.character.getKnowhowSkills()
										.getAthletics() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getAthletics());

					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowhowSkills().setAthletics(
								StartNPC.character.getKnowhowSkills()
										.getAthletics() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getAthletics());

					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowhowSkills().setAthletics(
								StartNPC.character.getKnowhowSkills()
										.getAthletics() + 1);
						textField.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getAthletics());

					} else {
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() < 2) {
							StartNPC.character.getKnowhowSkills().setAthletics(
									StartNPC.character.getKnowhowSkills()
											.getAthletics() + 1);
							textField.setText(""
									+ StartNPC.character.getKnowhowSkills()
											.getAthletics());

						}

					}

					if (StartNPC.character.getKnowhowSkills().getAthletics() >= 5) {
						button.setEnabled(false);
					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() >= minAtl) {
						button_5.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (StartNPC.character.getKnowhowSkills().getSurvival() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowhowSkills().setSurvival(
								StartNPC.character.getKnowhowSkills()
										.getSurvival() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getSurvival());

					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowhowSkills().setSurvival(
								StartNPC.character.getKnowhowSkills()
										.getSurvival() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getSurvival());

					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowhowSkills().setSurvival(
								StartNPC.character.getKnowhowSkills()
										.getSurvival() + 1);
						textField_1.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getSurvival());

					} else {
						if (StartNPC.character.getKnowhowSkills().getSurvival() < 2) {
							StartNPC.character.getKnowhowSkills().setSurvival(
									StartNPC.character.getKnowhowSkills()
											.getSurvival() + 1);
							textField_1.setText(""
									+ StartNPC.character.getKnowhowSkills()
											.getSurvival());

						}

					}

					if (StartNPC.character.getKnowhowSkills().getSurvival() >= 5) {
						button_1.setEnabled(false);
					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() >= minSup) {
						button_6.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (StartNPC.character.getKnowhowSkills().getEquitation() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowhowSkills().setEquitation(
								StartNPC.character.getKnowhowSkills()
										.getEquitation() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getEquitation());

					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowhowSkills().setEquitation(
								StartNPC.character.getKnowhowSkills()
										.getEquitation() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getEquitation());

					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowhowSkills().setEquitation(
								StartNPC.character.getKnowhowSkills()
										.getEquitation() + 1);
						textField_2.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getEquitation());

					} else {
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() < 2) {
							StartNPC.character.getKnowhowSkills()
									.setEquitation(
											StartNPC.character
													.getKnowhowSkills()
													.getEquitation() + 1);
							textField_2.setText(""
									+ StartNPC.character.getKnowhowSkills()
											.getEquitation());

						}

					}

					if (StartNPC.character.getKnowhowSkills().getEquitation() >= 5) {
						button_2.setEnabled(false);
					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() >= minEq) {
						button_7.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (StartNPC.character.getKnowhowSkills().getTraps() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowhowSkills().setTraps(
								StartNPC.character.getKnowhowSkills()
										.getTraps() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getTraps());

					}
					if (StartNPC.character.getKnowhowSkills().getTraps() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getTraps() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getTraps() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getTraps() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowhowSkills().setTraps(
								StartNPC.character.getKnowhowSkills()
										.getTraps() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getTraps());

					}
					if (StartNPC.character.getKnowhowSkills().getTraps() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowhowSkills().setTraps(
								StartNPC.character.getKnowhowSkills()
										.getTraps() + 1);
						textField_3.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getTraps());

					} else {
						if (StartNPC.character.getKnowhowSkills().getTraps() < 2) {
							StartNPC.character.getKnowhowSkills().setTraps(
									StartNPC.character.getKnowhowSkills()
											.getTraps() + 1);
							textField_3.setText(""
									+ StartNPC.character.getKnowhowSkills()
											.getTraps());

						}

					}

					if (StartNPC.character.getKnowhowSkills().getTraps() >= 5) {
						button_3.setEnabled(false);
					}
					if (StartNPC.character.getKnowhowSkills().getTraps() >= minTra) {
						button_8.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (StartNPC.character.getKnowhowSkills().getStealth() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro")) {
						StartNPC.character.getKnowhowSkills().setStealth(
								StartNPC.character.getKnowhowSkills()
										.getStealth() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getStealth());

					}
					if (StartNPC.character.getKnowhowSkills().getStealth() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 4 sin el privilegio Experto",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getStealth() == 4
							&& StartNPC.character.getPrivileges().Search(
									"Maestro") == false) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 5 sin el privilegio Maestro",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getStealth() == 2
							&& StartNPC.character.getSetbacks().Search(
									"Aprendiz") == true) {
						JOptionPane
								.showMessageDialog(
										frame.getContentPane(),
										"No puedes subir a nivel 3 con el reves aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);

					}
					if (StartNPC.character.getKnowhowSkills().getStealth() == 3
							&& StartNPC.character.getPrivileges().Search(
									"Experto")) {
						StartNPC.character.getKnowhowSkills().setStealth(
								StartNPC.character.getKnowhowSkills()
										.getStealth() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getStealth());

					}
					if (StartNPC.character.getKnowhowSkills().getStealth() < 3
							&& (StartNPC.character.getSetbacks().Search(
									"Aprendiz") == false || StartNPC.character
									.getSetbacks() == null)) {
						StartNPC.character.getKnowhowSkills().setStealth(
								StartNPC.character.getKnowhowSkills()
										.getStealth() + 1);
						textField_4.setText(""
								+ StartNPC.character.getKnowhowSkills()
										.getStealth());

					} else {
						if (StartNPC.character.getKnowhowSkills().getStealth() < 2) {
							StartNPC.character.getKnowhowSkills().setStealth(
									StartNPC.character.getKnowhowSkills()
											.getStealth() + 1);
							textField_4.setText(""
									+ StartNPC.character.getKnowhowSkills()
											.getStealth());

						} else {

						}
					}

					if (StartNPC.character.getKnowhowSkills().getStealth() >= 5) {
						button_4.setEnabled(false);
					}
					if (StartNPC.character.getKnowhowSkills().getStealth() >= minSig) {
						button_9.setEnabled(true);
					}

				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getKnowhowSkills().setAthletics(
							StartNPC.character.getKnowhowSkills()
									.getAthletics() - 1);
					textField.setText(""
							+ StartNPC.character.getKnowhowSkills()
									.getAthletics());

					if (StartNPC.character.getKnowhowSkills().getAthletics() < 5) {
						button.setEnabled(true);
					}
					if (StartNPC.character.getKnowhowSkills().getAthletics() <= minAtl) {
						button_5.setEnabled(false);
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
					StartNPC.character.getKnowhowSkills()
							.setSurvival(
									StartNPC.character.getKnowhowSkills()
											.getSurvival() - 1);
					textField_1.setText(""
							+ StartNPC.character.getKnowhowSkills()
									.getSurvival());

					if (StartNPC.character.getKnowhowSkills().getSurvival() < 5) {
						button_1.setEnabled(true);
					}
					if (StartNPC.character.getKnowhowSkills().getSurvival() <= minSup) {
						button_6.setEnabled(false);
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
					StartNPC.character.getKnowhowSkills().setEquitation(
							StartNPC.character.getKnowhowSkills()
									.getEquitation() - 1);
					textField_2.setText(""
							+ StartNPC.character.getKnowhowSkills()
									.getEquitation());

					if (StartNPC.character.getKnowhowSkills().getEquitation() < 5) {
						button_2.setEnabled(true);
					}
					if (StartNPC.character.getKnowhowSkills().getEquitation() <= minEq) {
						button_7.setEnabled(false);
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
					StartNPC.character.getKnowhowSkills()
							.setTraps(
									StartNPC.character.getKnowhowSkills()
											.getTraps() - 1);
					textField_3.setText(""
							+ StartNPC.character.getKnowhowSkills().getTraps());

					if (StartNPC.character.getKnowhowSkills().getTraps() < 5) {
						button_3.setEnabled(true);
					}
					if (StartNPC.character.getKnowhowSkills().getTraps() <= minTra) {
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
					StartNPC.character.getKnowhowSkills()
							.setStealth(
									StartNPC.character.getKnowhowSkills()
											.getStealth() - 1);
					textField_4.setText(""
							+ StartNPC.character.getKnowhowSkills()
									.getStealth());

					if (StartNPC.character.getKnowhowSkills().getStealth() < 5) {
						button_4.setEnabled(true);
					}
					if (StartNPC.character.getKnowhowSkills().getStealth() <= minSig) {
						button_9.setEnabled(false);
					}
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(232, 30, 89, 23);
		frame.getContentPane().add(button);

		button_1.setBounds(232, 80, 89, 23);
		frame.getContentPane().add(button_1);

		button_2.setBounds(232, 130, 89, 23);
		frame.getContentPane().add(button_2);

		button_3.setBounds(232, 180, 89, 23);
		frame.getContentPane().add(button_3);

		button_4.setBounds(232, 230, 89, 23);
		frame.getContentPane().add(button_4);

		button_5.setBounds(331, 30, 89, 23);
		frame.getContentPane().add(button_5);

		button_6.setBounds(331, 80, 89, 23);
		frame.getContentPane().add(button_6);

		button_7.setBounds(331, 130, 89, 23);
		frame.getContentPane().add(button_7);

		button_8.setBounds(331, 180, 89, 23);
		frame.getContentPane().add(button_8);

		button_9.setBounds(331, 230, 89, 23);
		frame.getContentPane().add(button_9);

		btnVolverAHabilidades = new JButton("Volver a Habilidades");
		btnVolverAHabilidades.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolverAHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton volver a habilidades2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnVolverAHabilidades.setIcon(new ImageIcon(DestrezasNPC.class
						.getResource("/images/boton volver a habilidades.png")));
			}
		});
		btnVolverAHabilidades.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/boton volver a habilidades.png")));
		btnVolverAHabilidades.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnVolverAHabilidades.setBackground(new Color(139, 69, 19));
		btnVolverAHabilidades.setForeground(new Color(255, 255, 255));
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

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DestrezasNPC.class
				.getResource("/images/background-habilidades2.jpg")));
		label.setBounds(0, 0, 468, 348);
		frame.getContentPane().add(label);


	}

}

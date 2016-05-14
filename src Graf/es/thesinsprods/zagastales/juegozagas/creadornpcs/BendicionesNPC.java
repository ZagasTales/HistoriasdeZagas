package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaBendicion;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

public class BendicionesNPC {

	private JFrame frmHistoriasDeZagas;
	public static int bendicion = 0;
	public static boolean campeon = false;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BendicionesNPC window = new BendicionesNPC();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	/**
	 * Create the application.
	 */
	public BendicionesNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frmHistoriasDeZagas.getContentPane().setLayout(null);
		frmHistoriasDeZagas.setResizable(false);

		JScrollPane scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(272, 83, 296, 337);
		frmHistoriasDeZagas.getContentPane().add(scrollPaneB);

		final JTextArea DescripcionB = new JTextArea();
		DescripcionB.setForeground(new Color(0, 0, 0));
		DescripcionB.setBackground(Color.WHITE);
		DescripcionB.setFont(mf.MyFont(0, 15));
		DescripcionB.setLineWrap(true);
		DescripcionB.setWrapStyleWord(true);
		DescripcionB.setEditable(false);
		scrollPaneB.setViewportView(DescripcionB);

		final JButton btnContinuar = new JButton("");
		final JComboBox<String> cmbxBendicion = new JComboBox<String>();
		cmbxBendicion.setMaximumRowCount(15);
		cmbxBendicion.setBackground(Color.WHITE);
		cmbxBendicion.setForeground(new Color(0, 0, 0));
		cmbxBendicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cmbxBendicion.getSelectedIndex() == 0) {
					Blessing blessing = new Blessing("");
					DescripcionB.setText(null);
					StartNPC.character.setBlessing(blessing);
				}

				if (cmbxBendicion.getSelectedIndex() == 1) {
					Blessing blessing = new Blessing("Arcanista de Sylendyl");
					DescripcionB
							.setText(": Aquellos tocados por esta bendición verán aumentada su resistencia a la hora de realizar consecutivos esfuerzos mágicos,  como don otorgado por parte del padre de la magia. \n+6 de maná.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 2) {
					Blessing blessing = new Blessing(
							"Caballero Arcano de Sylendyl");
					DescripcionB
							.setText("Aquellos que llevan la magia de manera innata en su interior presentan una mayor dificultad para que esta le dañe.\n+1 resistencia mágica");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 3) {
					Blessing blessing = new Blessing("Druida de Yanirem");
					DescripcionB
							.setText("Aquellos que han nacido para vivir en comunión de la naturaleza, logran comprender antes su funcionamiento y evolución, y por tanto pueden manipularla de manera más sencilla.\nMenor gasto de maná al usar magia druídica. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 4) {
					Blessing blessing = new Blessing("Guardabosques de Yanirem");
					DescripcionB
							.setText("Aquellos que forman parte de la naturaleza, no se ven rechazados y atacados por ella de manera tan fuerte como los que se encuentran alejados de la misma.\n+1 resistencia a venenos. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 5) {
					Blessing blessing = new Blessing("Erudito de Bodvar");
					DescripcionB
							.setText("Aquellos que disfrutan de la cortesía del dios del conocimiento, tienen un mayor criterio y juicio que sus semejantes.\n+ 1 de inteligencia. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 6) {
					Blessing blessing = new Blessing("Ingeniero de Bodvar");
					DescripcionB
							.setText("Aquellos nacidos bajo la mirada de Bodvar no solo son de ser capaces de entender mejor su ambiente y los factores de su alrededor, si no que tienen tendencia natural a aplicarla de manera directa y práctica.\n+1 conocimientos secretos. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 7) {
					Blessing blessing = new Blessing("Geomante de Gralnach");
					DescripcionB
							.setText("Aquellos  nacidos para moldear la tierra son capaces de mover masas de tierra suficientes para dejar exhausto a cualquier semejante, sin sentir más que un ligero cansancio.\nMenor gasto de maná a la hora de usar magia de tierra. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 8) {
					Blessing blessing = new Blessing("Montaña de Gralnach");
					DescripcionB
							.setText("Aquellos nacidos de la tierra mantienen su férrea y firme constitución, haciendo que sea más complicado herir o perforar su cuerpo. \n+1 resistencia. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 9) {
					Blessing blessing = new Blessing("Piromante de Yanguín");
					DescripcionB
							.setText("Aquellos nacidos del fuego tienen una mayor afinidad para moldearlo a su parecer.\n Menor gasto de maná a la hora de usar magia de fuego. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 10) {
					Blessing blessing = new Blessing("Dragón de Yanguín");
					DescripcionB
							.setText("Aquellos que comparten el poder del señor de los dragones sienten el calor del propio fuego en su interior, obteniendo una resistencia natural a cualquier ataque realizado por el mismo.\n +1 rango en tiradas de resistencia al fuego. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 11) {
					Blessing blessing = new Blessing("Acuamante de Sérpos");
					DescripcionB
							.setText("Aquellos  acostumbrados a  vivir en torno al líquido elemento, tienen, como es normal, una mayor facilidad a la hora de controlarlo, permitiéndole tomar formas más complicadas, frías y mortales con menos esfuerzo.\n Menor gasto de maná a la hora de usar magia de agua. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 12) {
					Blessing blessing = new Blessing("Kraken de Sérpos");
					DescripcionB
							.setText("Aquellos imbuidos con el poder del dios del mar y del agua, ven en esta su hogar natural, permitiéndoles respirar en ella, encontrando confort donde el resto encontrarían su muerte. \nRespiración acuática.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 13) {
					Blessing blessing = new Blessing("Aeromante de K'aris");
					DescripcionB
							.setText("Aquellos capaces de entender  naturalmente los bruscos cambios y las invisibles variaciones en las corrientes de aire son capaces de modificarlos de manera más rápida y sencilla.\nMenor gasto de maná a la hora de usar magia de viento.  ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 14) {
					Blessing blessing = new Blessing("Vendaval de K'aris");
					DescripcionB
							.setText("Aquellos que comparten destino con el viento adquieren su carácter impredecible y sus vivos movimientos, haciendo que sean más difíciles de predecir  y de herirles con un proyectil.\n +1 rango de tirada a la hora de esquivar proyectiles. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 15) {
					Blessing blessing = new Blessing("Sacerdote de Diliges");
					DescripcionB
							.setText("Aquellos elegidos por la diosa de la vida y la curación para encomendarse al cuidado de sus semejantes, tienen una mayor facilidad a la hora de cumplir con esas tareas. \nMenor gasto de maná a la hora de usar magia blanca. ");
					StartNPC.character.setBlessing(blessing);

				}
				if (cmbxBendicion.getSelectedIndex() == 16) {
					Blessing blessing = new Blessing("Paladín de Diliges");
					DescripcionB
							.setText("Aquellos que portan el poder de la vida y la luz, provocan que los servidores de la oscuridad se oculten de sus ataques.\n +1 modificadores contra criaturas de Tarterus. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 17) {
					Blessing blessing = new Blessing(
							"Sacerdote Negro de Tenerus");
					DescripcionB
							.setText("Aquellos capaces de blandir la propia oscuridad como arma, moradores de las sombras, pueden utilizarla sin esfuerzo alguno.\n Menor gasto de maná a la hora de usar magia negra. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 18) {
					Blessing blessing = new Blessing(
							"Guerrero Oscuro de Tenerus");
					DescripcionB
							.setText(": Aquellos que portan el poder abismal, provocan que la vida y fuerza de sus oponentes se desvanezcan en la penumbra de su ruina.\n Robo de energía al hacer heridas, y una vez acabada esta, de salud.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 19) {
					Blessing blessing = new Blessing(
							"Hechicero Oscuro de Mavrila");
					DescripcionB
							.setText("Aquellos con el favor de la caprichosa señora de Tarterus, podrán invocar algunos de sus demonios más deleznables y desechables.\n Habilidad de invocación de demonios menores, solo uno por vez. (Demonios incluidos: Diablillo, Banshee, Íncubo y Súcubo)");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 20) {
					Blessing blessing = new Blessing("Asesino de Mavrila");
					DescripcionB
							.setText("Aquellos bendecidos, si acaso se puede nombrar como tal, por la princesa de la oscuridad, verán como su silueta se difumina y sus pasos se ahogan para sus iguales.\n+2 destreza al realizar acciones de sigilo.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 21) {
					Blessing blessing = new Blessing(
							"Ladrón de Vida de Aurelius");
					DescripcionB
							.setText("Aquellos humildes siervos del dios de la muerte que tengan agarrada a una pobre alma, podrán separarla poco a poco de su cáscara mortal para seguir cumpliendo los designios de su dios.\n En lugar de maná, permite usar la energía y salud de enemigos que se tenga agarrados a la hora de usar magia negra.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 22) {
					Blessing blessing = new Blessing(
							"Guardia Negro de Aurelius");
					DescripcionB
							.setText("Aquellos tejidos desgarrados por un sirviente del dios de la muerte, se necrosarán, aquellas heridas creadas, no se cerrarán, y aquellos órganos dañados serán consumidos por la enfermedad. \nCrea problemas al herir, como infecciones, desangramientos, heridas graves… (Cuando el jugador obtiene un crítico en su tirada).");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 23) {
					Blessing blessing = new Blessing("Nigromante de Voltarus");
					DescripcionB
							.setText("Aquellos a los que el dios de la resurrección ha mostrado su poder, logran levantar a los muertos de su descanso sin apenas esforzarse en ello.\n +1 rango a la hora de levantar muertos.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 24) {
					Blessing blessing = new Blessing("Pactante de Voltarus");
					DescripcionB
							.setText("Aquellos que cuenten con el favor de Voltarus recibirán la oportunidad de no reunirse con el de manera precipitada, sin cumplir antes su objetivo fijado.\n Al perder toda la salud se tira un dado, si se saca más de 14 se recuperan 3 puntos de vida. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 25) {
					Blessing blessing = new Blessing("Espectro de Timor");
					DescripcionB
							.setText("Aquellos capaces de deleitarse con las contorsionadas caras de terror de sus enemigos obtienen un placentero descanso al hacer salir ese horror primigenio de sus corazones.\n Recuperación de maná prolongada al lograr aterrorizar a sus enemigos. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 26) {
					Blessing blessing = new Blessing("Legionario de Timor");
					DescripcionB
							.setText("Aquellos que han visto el rostro mismo del miedo desde que nacieron, son inmunes a los intentos de todo aquello que intenta parecerse a él.\n Inmunidad al miedo.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 27) {
					Blessing blessing = new Blessing(
							"Mago Sangriento de Timoria");
					DescripcionB
							.setText("Aquellos que disfrutan al infligir daño a sus semejantes, encuentran un respiro entre la sangre goteada por los mismos tras ser lacerados. \nRecuperación de maná al torturar.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 28) {
					Blessing blessing = new Blessing("Brazo de Timoria");
					DescripcionB
							.setText("Aquellos elegidos para ser súbditos de la diosa del castigo, obtienen la destreza necesaria para infligir todas las torturas que puedan imaginarse. \n+1 destreza.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 29) {
					Blessing blessing = new Blessing("Mago de Batalla de Éktra");
					DescripcionB
							.setText("Aquellos nacidos para las artes de la guerra, encuentran innato el lanzar constantes ataques sobre sus enemigos, creando una incansable tormenta de embestidas.\n Menor gasto de maná en acciones ofensivas.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 30) {
					Blessing blessing = new Blessing("Espada de Éktra");
					DescripcionB
							.setText("Aquellos nacidos para luchar, encuentran su lugar en el mundo únicamente cuando empuñan un arma, y esta encuentra su lugar en las manos de su portador.\n Nivel 1 gratuito en una disciplina de combate, a elección.");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 31) {
					Blessing blessing = new Blessing("Embustero de Pséftis");
					DescripcionB
							.setText("Aquellos que portan desde pequeños unos ojos sinceros y una sonrisa amable, también son los que ocultan los mayores embustes en su interior.\n+2 carisma al negociar o mentir. ");
					StartNPC.character.setBlessing(blessing);
				}
				if (cmbxBendicion.getSelectedIndex() == 32) {
					Blessing blessing = new Blessing("Audaz de Pséftis");
					DescripcionB
							.setText("Aquellos que encuentran su lugar entre las trampas y farsas, no pueden ser  engañados de manera sencilla, y menos si se trata de meros aparatos mecánicos sin el carisma de una persona tras ellos.\n +2 percepción al detectar trampas. ");
					StartNPC.character.setBlessing(blessing);
				}
				BendicionesNPC.bendicion = cmbxBendicion.getSelectedIndex();
				if (cmbxBendicion.getSelectedIndex() == 0) {
					btnContinuar.setEnabled(false);
				}
				if (cmbxBendicion.getSelectedIndex() != 0) {
					btnContinuar.setEnabled(true);

				}
			}
		});
		cmbxBendicion
				.setModel(new DefaultComboBoxModel(
						new String[] {
								"-Seleccione una Bendici\u00F3n-",
								"Arcanista de Sylendyl",
								"Caballero Arcano de Sylendyl",
								"Druida de Yanirem",
								"Guardabosques de Yanirem",
								"Erudito de Bodvar",
								"Ingeniero de Bodvar",
								"Geomante de Gralnach",
								"Monta\u00F1a de Gralnach",
								"Piromante de Y\u00E1nguin",
								"Drag\u00F3n de Y\u00E1nguin",
								"Acuamante de S\u00E9rpos",
								"Kraken de S\u00E9rpos",
								"Aeromante de K\u00B4aris",
								"Vendaval de K\u2019aris",
								"Sacerdote de Diliges",
								"Palad\u00EDn de Diliges",
								"Sacerdote Negro de Tenerus",
								"Guerrero Oscuro de Tenerus",
								"Hechicero Oscuro de Mavrila",
								"Asesino de Mavrila",
								"Ladr\u00F3n de Vida de Aurelius",
								"Guardia Negro de Aurelius                                       ",
								"Nigromante de Voltarus",
								"Pactante de Voltarus", "Espectro de Timor",
								"Legionario de Timor",
								"Mago Sangriento de Timoria",
								"Brazo de Timoria ",
								"Mago de Batalla de \u00C9ktra",
								"Espada de \u00C9ktra",
								"Embustero de Ps\u00E9ftis",
								"Audaz de Ps\u00E9ftis" }));
		cmbxBendicion.setSelectedIndex(BendicionesNPC.bendicion);
		cmbxBendicion.setFont(mf.MyFont(0, 15));
		cmbxBendicion.setBounds(10, 83, 252, 20);
		frmHistoriasDeZagas.getContentPane().add(cmbxBendicion);

		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnContinuar.setIcon(new ImageIcon(BendicionesNPC.class
						.getResource("/images/boton continuar2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(BendicionesNPC.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(BendicionesNPC.class
				.getResource("/images/boton continuar.png")));
		btnContinuar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnContinuar.setBackground(new Color(139, 69, 19));
		btnContinuar.setBorderPainted(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setOpaque(false);
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StartNPC.character.getBlessing().getBlessing() != "") {
					try {
						StartNPC.character.getBlessing().calculoExtras(
								StartNPC.character);
						if (StartNPC.character.isCampeon()) {
							StartNPC.character.getBlessing().calculoCampeon(
									StartNPC.character);

						}
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmHistoriasDeZagas.dispose();
					PrivilegiosNPC window = new PrivilegiosNPC();
					window.getFrame().setVisible(true);
				} else {

					JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"Nadie puede sobrevivir en Zagas sin la protección de uno de los dioses",
									"Faltan Datos!", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnContinuar.setFont(mf.MyFont(0, 14));
		btnContinuar.setBounds(469, 459, 99, 34);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				btnAtras.setIcon(new ImageIcon(BendicionesNPC.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				btnAtras.setIcon(new ImageIcon(BendicionesNPC.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(BendicionesNPC.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAtras.setBackground(new Color(139, 69, 19));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartNPC.character.getRace().CalculoRazaInv(
							StartNPC.character);
				} catch (AtributeOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SkillOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frmHistoriasDeZagas.dispose();
				StartNPC window;
				try {
					window = new StartNPC();
					window.getFrmHistoriasDeZagas().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAtras.setFont(mf.MyFont(0, 14));
		btnAtras.setBounds(10, 459, 99, 34);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		final JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaBendicion window = new AyudaBendicion();
				window.getFrame().setVisible(true);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnNewButton.setIcon(new ImageIcon(BendicionesNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setBounds(318, 459, 111, 31);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		btnNewButton.setOpaque(false);

		final JButton btnInicio = new JButton("Inicio");
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seleccion = JOptionPane
						.showOptionDialog(
								frmHistoriasDeZagas,
								"Si vuelves al inicio se perderán todos los datos no guardados.",
								"¡Atención!", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] {
										"Aceptar", "Cancelar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
								"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					StartNPC.razaAnt="";
					StartNPC.nombre = "";
					StartNPC.edad = 0;
					StartNPC.raza = 0;
					StartNPC.descrpF = "";
					BendicionesNPC.bendicion = 0;
					PrivilegiosNPC.priv1 = 0;
					PrivilegiosNPC.priv2 = 0;
					PrivilegiosNPC.priv3 = 0;
					PrivilegiosNPC.priv4 = 0;
					PrivilegiosNPC.priv5 = 0;
					PrivilegiosNPC.rev1 = 0;
					PrivilegiosNPC.rev2 = 0;
					PrivilegiosNPC.rev3 = 0;
					PrivilegiosNPC.rev4 = 0;
					StartNPC.contadorLegendario = 0;
					PrivilegiosNPC.legendario = 0;
					PrivilegiosNPC.posesiones = 0;
					StartNPC.atrpoints = new AtributePoints();
					StartNPC.skpoints = new SkillPoints();
					StartNPC.atributos = new Atributes(StartNPC.atrpoints);
					StartNPC.combatSkills = new CombatSkills(StartNPC.skpoints);
					StartNPC.knowledgeSkills = new KnowledgeSkills(
							StartNPC.skpoints);
					StartNPC.magicSkills = new MagicSkills(StartNPC.skpoints);
					StartNPC.knowhowSkills = new KnowHowSkills(
							StartNPC.skpoints);
					AtributosNPC.minFuerza = 6;
					AtributosNPC.minDestreza = 6;
					AtributosNPC.minResistencia = 6;
					AtributosNPC.minResistenciaM = 6;
					AtributosNPC.minCarisma = 6;
					AtributosNPC.minPercepcion = 6;
					AtributosNPC.minInteligencia = 6;
					CombateNPC.minAsta = 0;
					CombateNPC.minBloq = 0;
					CombateNPC.minDist = 0;
					CombateNPC.minDos = 0;
					CombateNPC.minEsq = 0;
					CombateNPC.minUna = 0;
					ConocimientosNPC.minAG = 0;
					ConocimientosNPC.minCS = 0;
					ConocimientosNPC.minDip = 0;
					ConocimientosNPC.minEt = 0;
					ConocimientosNPC.minInv = 0;
					ConocimientosNPC.minMed = 0;
					ConocimientosNPC.minNeg = 0;
					ConocimientosNPC.minOc = 0;
					MagiaNPC.minAgua = 0;
					MagiaNPC.minArcana = 0;
					MagiaNPC.minBlanca = 0;
					MagiaNPC.minDruidica = 0;
					MagiaNPC.minFuego = 0;
					MagiaNPC.minNegra = 0;
					MagiaNPC.minTierra = 0;
					MagiaNPC.minViento = 0;
					DestrezasNPC.minAtl = 0;
					DestrezasNPC.minEq = 0;
					DestrezasNPC.minSig = 0;
					DestrezasNPC.minSup = 0;
					DestrezasNPC.minTra = 0;
					EquipoNPC.contexcusa = 0;
					EquipoNPC.weapon1 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon2 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon3 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon4 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.armor1 = new Armor("", "", false,false, EquipoNPC.posss);
					EquipoNPC.accesories1 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories2 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories3 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories4 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.misc1 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc2 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc3 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc4 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.pweap = 0;
					EquipoNPC.pmisc = 0;
					StartNPC.contadorBEktra = 0;
					StartNPC.contadorPosesion = 0;
					Blessing blessing = new Blessing("");
					Setbacks setbacks = new Setbacks();
					Race race = new Race("");
					Equipment equipment = new Equipment();
					ArrayList<String> posarm = new ArrayList<String>();
					Possesions posss = new Possesions(posarm);
					Armor armor = new Armor("", "", false,false, posss);
					StartNPC.character = new Characters(null, race, "", 0, 2,
							10, 20, 20, StartNPC.atributos,
							StartNPC.combatSkills, StartNPC.knowledgeSkills,
							StartNPC.magicSkills, StartNPC.knowhowSkills,
							blessing, null, setbacks, false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null,
							0, 1,0,"","","");
					frmHistoriasDeZagas.dispose();
					Inicio window = new Inicio();
					window.getFrmHistoriasDeZagas().setVisible(true);
				}

			}
		});

		final JCheckBox chckbxcampen = new JCheckBox("\u00BFCampe\u00F3n?");
		if (campeon == true) {

			chckbxcampen.setSelected(true);
		}

		if (campeon == false) {

			chckbxcampen.setSelected(false);
		}
		chckbxcampen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxcampen.isSelected()) {

					StartNPC.character.setCampeon(true);
					campeon = true;
				}

				else {

					StartNPC.character.setCampeon(false);
					campeon = false;
				}

			}
		});
		chckbxcampen.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxcampen.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxcampen.setOpaque(false);
		chckbxcampen.setFont(mf.MyFont(0, 13));
		chckbxcampen.setForeground(Color.WHITE);
		chckbxcampen.setBounds(10, 397, 97, 23);
		frmHistoriasDeZagas.getContentPane().add(chckbxcampen);
		btnInicio.setIcon(new ImageIcon(BendicionesNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInicio.setOpaque(false);
		btnInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(mf.MyFont(0, 13));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBounds(159, 459, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		JLabel lblSeleccionBendicion = new JLabel(
				"Selecci\u00F3n de Bendici\u00F3n");
		lblSeleccionBendicion.setForeground(Color.WHITE);
		lblSeleccionBendicion.setFont(mf.MyFont(1, 36));
		lblSeleccionBendicion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSeleccionBendicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionBendicion.setBounds(10, 0, 558, 60);
		frmHistoriasDeZagas.getContentPane().add(lblSeleccionBendicion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BendicionesNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}
}

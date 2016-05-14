package es.thesinsprods.zagastales.perfil;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Resumen;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;

public class CargarPersonaje {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtUnaMano;
	private JTextField txtDosManos;
	private JTextField txtAsta;
	private JTextField txtDistancia;
	private JTextField txtEsquivar;
	private JTextField txtBloquear;
	private JTextField txtArteGuerra;
	private JTextField txtDiplomacia;
	private JTextField txtEtiqueta;
	private JTextField txtMedicina;
	private JTextField txtOcultismo;
	private JTextField txtInvestigacion;
	private JTextField txtNegociacion;
	private JTextField txtCSecretos;
	private JTextField txtDruidica;
	private JTextField txtFuego;
	private JTextField txtAgua;
	private JTextField txtTierra;
	private JTextField txtViento;
	private JTextField txtBlanca;
	private JTextField txtNegra;
	private JTextField txtArcana;
	private JTextField txtAtletismo;
	private JTextField txtSupervivencia;
	private JTextField txtTrampas;
	private JTextField txtEquitacion;
	private JTextField txtSigilo;
	private JTextField txtDestreza;
	private JTextField txtFuerza;
	private JTextField txtResistencia;
	private JTextField txtRMagica;
	private JTextField txtInteligencia;
	private JTextField txtPercepcion;
	private JTextField txtCarisma;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JTextField txtEdad;
	private JTextField txtSino;
	private JTextField txtExperiencia;
	private JTextField txtBendicion;
	private JTextField txtMana;
	private JTextField txtEnergia;
	private JTextField txtSalud;
	private JTextField txtArmadura;
	private JTextField txtArma1;
	private JTextField txtArma2;
	private JTextField txtArma3;
	private JTextField txtArma4;
	private JTextField txtObj1;
	private JTextField txtObj2;
	private JTextField txtObj3;
	private JTextField txtObj4;
	private JTextField txtAcc4;
	private JTextField txtAcc3;
	private JTextField txtAcc2;
	private JTextField txtAcc1;

	public static String armadura = "";
	public static String descripcionArm = "";
	public static String posesionArm = "";
	public static String prop1Arm = "";
	public static String prop2Arm = "";
	public static String prop3Arm = "";
	public static String weap1 = "";
	public static String descripcionWeap1 = "";
	public static String posesionWeap1 = "";
	public static String prop1Weap1 = "";
	public static String prop2Weap1 = "";
	public static String prop3Weap1 = "";
	public static String weap2 = "";
	public static String descripcionWeap2 = "";
	public static String posesionWeap2 = "";
	public static String prop1Weap2 = "";
	public static String prop2Weap2 = "";
	public static String prop3Weap2 = "";
	public static String weap3 = "";
	public static String descripcionWeap3 = "";
	public static String posesionWeap3 = "";
	public static String prop1Weap3 = "";
	public static String prop2Weap3 = "";
	public static String prop3Weap3 = "";
	public static String weap4 = "";
	public static String descripcionWeap4 = "";
	public static String posesionWeap4 = "";
	public static String prop1Weap4 = "";
	public static String prop2Weap4 = "";
	public static String prop3Weap4 = "";
	public static String obj1 = "";
	public static String descripcionObj1 = "";
	public static String posesionObj1 = "";
	public static String prop1Obj1 = "";
	public static String prop2Obj1 = "";
	public static String prop3Obj1 = "";
	public static String obj2 = "";
	public static String descripcionObj2 = "";
	public static String posesionObj2 = "";
	public static String prop1Obj2 = "";
	public static String prop2Obj2 = "";
	public static String prop3Obj2 = "";
	public static String obj3 = "";
	public static String descripcionObj3 = "";
	public static String posesionObj3 = "";
	public static String prop1Obj3 = "";
	public static String prop2Obj3 = "";
	public static String prop3Obj3 = "";
	public static String obj4 = "";
	public static String descripcionObj4 = "";
	public static String posesionObj4 = "";
	public static String prop1Obj4 = "";
	public static String prop2Obj4 = "";
	public static String prop3Obj4 = "";
	public static String acc1 = "";
	public static String descripcionAcc1 = "";
	public static String posesionAcc1 = "";
	public static String prop1Acc1 = "";
	public static String prop2Acc1 = "";
	public static String prop3Acc1 = "";
	public static String acc2 = "";
	public static String descripcionAcc2 = "";
	public static String posesionAcc2 = "";
	public static String prop1Acc2 = "";
	public static String prop2Acc2 = "";
	public static String prop3Acc2 = "";
	public static String acc3 = "";
	public static String descripcionAcc3 = "";
	public static String posesionAcc3 = "";
	public static String prop1Acc3 = "";
	public static String prop2Acc3 = "";
	public static String prop3Acc3 = "";
	public static String acc4 = "";
	public static String descripcionAcc4 = "";
	public static String posesionAcc4 = "";
	public static String prop1Acc4 = "";
	public static String prop2Acc4 = "";
	public static String prop3Acc4 = "";
	public static String tipoWeap1 = "";
	public static String tipoWeap2 = "";
	public static String tipoWeap3 = "";
	public static String tipoWeap4 = "";
	public static String tipoAcc1 = "";
	public static String tipoAcc2 = "";
	public static String tipoAcc3 = "";
	public static String tipoAcc4 = "";
	public static String arrojadizaWeap1 = "";
	public static String arrojadizaWeap2 = "";
	public static String arrojadizaWeap3 = "";
	public static String arrojadizaWeap4 = "";
	
	public static String poderes="";
	public static String extras= "";
	public static String modificadores="";


	MorpheusFont mf = new MorpheusFont();
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarPersonaje window = new CargarPersonaje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public CargarPersonaje() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Resumen.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setTitle("Historias de Zagas");
		frame.setBounds(100, 100, 648, 715);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		FileReader fr = new FileReader(Perfil.fichero);
		BufferedReader br = new BufferedReader(fr);

		final String nombre = br.readLine();
		final int edad = Integer.parseInt(br.readLine());
		final String raza = br.readLine();
		final String descripcionF = br.readLine();
		final String bendicion = br.readLine();
		final String privilegio1 = br.readLine();
		final String privilegio2 = br.readLine();
		final String privilegio3 = br.readLine();
		final String privilegio4 = br.readLine();
		final String privilegio5 = br.readLine();
		final String reves1 = br.readLine();
		final String reves2 = br.readLine();
		final String reves3 = br.readLine();
		final String reves4 = br.readLine();
		final int fuerza = Integer.parseInt(br.readLine());
		final int destreza = Integer.parseInt(br.readLine());
		final int resistencia = Integer.parseInt(br.readLine());
		final int resistenciaM = Integer.parseInt(br.readLine());
		final int inteligencia = Integer.parseInt(br.readLine());
		final int percepcion = Integer.parseInt(br.readLine());
		final int carisma = Integer.parseInt(br.readLine());
		final int unamano = Integer.parseInt(br.readLine());
		final int dosmanos = Integer.parseInt(br.readLine());
		;
		final int asta = Integer.parseInt(br.readLine());
		final int distancia = Integer.parseInt(br.readLine());
		final int esquivar = Integer.parseInt(br.readLine());
		final int bloquear = Integer.parseInt(br.readLine());
		final int arteGuerra = Integer.parseInt(br.readLine());
		final int diplomacia = Integer.parseInt(br.readLine());
		final int etiqueta = Integer.parseInt(br.readLine());
		final int medicina = Integer.parseInt(br.readLine());
		final int ocultismo = Integer.parseInt(br.readLine());
		final int investigacion = Integer.parseInt(br.readLine());
		final int negociacion = Integer.parseInt(br.readLine());
		final int cSecretos = Integer.parseInt(br.readLine());
		final int fuego = Integer.parseInt(br.readLine());
		final int agua = Integer.parseInt(br.readLine());
		final int tierra = Integer.parseInt(br.readLine());
		final int viento = Integer.parseInt(br.readLine());
		final int druidica = Integer.parseInt(br.readLine());
		final int blanca = Integer.parseInt(br.readLine());
		final int negra = Integer.parseInt(br.readLine());
		final int arcana = Integer.parseInt(br.readLine());
		final int atletismo = Integer.parseInt(br.readLine());
		final int supervivencia = Integer.parseInt(br.readLine());
		final int equitacion = Integer.parseInt(br.readLine());
		final int trampas = Integer.parseInt(br.readLine());
		final int sigilo = Integer.parseInt(br.readLine());
		armadura = br.readLine();
		descripcionArm = br.readLine();
		posesionArm = br.readLine();
		prop1Arm = br.readLine();
		prop2Arm = br.readLine();
		prop3Arm = br.readLine();
		weap1 = br.readLine();
		descripcionWeap1 = br.readLine();
		posesionWeap1 = br.readLine();
		prop1Weap1 = br.readLine();
		prop2Weap1 = br.readLine();
		prop3Weap1 = br.readLine();
		weap2 = br.readLine();
		descripcionWeap2 = br.readLine();
		posesionWeap2 = br.readLine();
		prop1Weap2 = br.readLine();
		prop2Weap2 = br.readLine();
		prop3Weap2 = br.readLine();
		weap3 = br.readLine();
		descripcionWeap3 = br.readLine();
		posesionWeap3 = br.readLine();
		prop1Weap3 = br.readLine();
		prop2Weap3 = br.readLine();
		prop3Weap3 = br.readLine();
		weap4 = br.readLine();
		descripcionWeap4 = br.readLine();
		posesionWeap4 = br.readLine();
		prop1Weap4 = br.readLine();
		prop2Weap4 = br.readLine();
		prop3Weap4 = br.readLine();
		obj1 = br.readLine();
		descripcionObj1 = br.readLine();
		posesionObj1 = br.readLine();
		prop1Obj1 = br.readLine();
		prop2Obj1 = br.readLine();
		prop3Obj1 = br.readLine();
		obj2 = br.readLine();
		descripcionObj2 = br.readLine();
		posesionObj2 = br.readLine();
		prop1Obj2 = br.readLine();
		prop2Obj2 = br.readLine();
		prop3Obj2 = br.readLine();
		obj3 = br.readLine();
		descripcionObj3 = br.readLine();
		posesionObj3 = br.readLine();
		prop1Obj3 = br.readLine();
		prop2Obj3 = br.readLine();
		prop3Obj3 = br.readLine();
		obj4 = br.readLine();
		descripcionObj4 = br.readLine();
		posesionObj4 = br.readLine();
		prop1Obj4 = br.readLine();
		prop2Obj4 = br.readLine();
		prop3Obj4 = br.readLine();
		acc1 = br.readLine();
		descripcionAcc1 = br.readLine();
		posesionAcc1 = br.readLine();
		prop1Acc1 = br.readLine();
		prop2Acc1 = br.readLine();
		prop3Acc1 = br.readLine();
		acc2 = br.readLine();
		descripcionAcc2 = br.readLine();
		posesionAcc2 = br.readLine();
		prop1Acc2 = br.readLine();
		prop2Acc2 = br.readLine();
		prop3Acc2 = br.readLine();
		acc3 = br.readLine();
		descripcionAcc3 = br.readLine();
		posesionAcc3 = br.readLine();
		prop1Acc3 = br.readLine();
		prop2Acc3 = br.readLine();
		prop3Acc3 = br.readLine();
		acc4 = br.readLine();
		descripcionAcc4 = br.readLine();
		posesionAcc4 = br.readLine();
		prop1Acc4 = br.readLine();
		prop2Acc4 = br.readLine();
		prop3Acc4 = br.readLine();
		final int salud = Integer.parseInt(br.readLine());
		final int mana = Integer.parseInt(br.readLine());
		final int energia = Integer.parseInt(br.readLine());
		final int experiencia = Integer.parseInt(br.readLine());
		final int sino = Integer.parseInt(br.readLine());
		tipoWeap1 = br.readLine();
		tipoWeap2 = br.readLine();
		tipoWeap3 = br.readLine();
		tipoWeap4 = br.readLine();
		tipoAcc1 = br.readLine();
		tipoAcc2 = br.readLine();
		tipoAcc3 = br.readLine();
		tipoAcc4 = br.readLine();
		arrojadizaWeap1 = br.readLine();
		arrojadizaWeap2 = br.readLine();
		arrojadizaWeap3 = br.readLine();
		arrojadizaWeap4 = br.readLine();
		 extras=br.readLine();
		final String dinero=br.readLine();
		modificadores=br.readLine();
		poderes=br.readLine();
		final String nivel=br.readLine();
		final String exptotal=br.readLine();
		final String campeon=br.readLine();

		JLabel lblGeneral = new JLabel("General:");
		lblGeneral.setForeground(Color.WHITE);
		lblGeneral.setFont(mf.MyFont(0, 15));
		lblGeneral.setBounds(10, 11, 220, 26);
		frame.getContentPane().add(lblGeneral);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(mf.MyFont(0, 13));
		lblNombre.setBounds(10, 47, 64, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setForeground(Color.WHITE);
		lblRaza.setFont(mf.MyFont(0, 13));
		lblRaza.setBounds(10, 72, 64, 14);
		frame.getContentPane().add(lblRaza);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(mf.MyFont(0, 13));
		lblEdad.setBounds(224, 47, 46, 14);
		frame.getContentPane().add(lblEdad);

		JLabel lblSino = new JLabel("Sino:");
		lblSino.setForeground(Color.WHITE);
		lblSino.setFont(mf.MyFont(0, 13));
		lblSino.setBounds(224, 72, 46, 14);
		frame.getContentPane().add(lblSino);

		JLabel lblBendicion = new JLabel("Bendici\u00F3n:");
		lblBendicion.setForeground(Color.WHITE);
		lblBendicion.setFont(mf.MyFont(0, 13));
		lblBendicion.setBounds(324, 47, 70, 14);
		frame.getContentPane().add(lblBendicion);

		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setForeground(Color.WHITE);
		lblExperiencia.setFont(mf.MyFont(0, 13));
		lblExperiencia.setBounds(460, 72, 70, 14);
		frame.getContentPane().add(lblExperiencia);

		JLabel lblSalud = new JLabel("Salud:");
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setFont(mf.MyFont(0, 13));
		lblSalud.setBounds(10, 95, 64, 14);
		frame.getContentPane().add(lblSalud);

		JLabel lblMan = new JLabel("Man\u00E1:");
		lblMan.setForeground(Color.WHITE);
		lblMan.setFont(mf.MyFont(0, 13));
		lblMan.setBounds(224, 95, 64, 14);
		frame.getContentPane().add(lblMan);

		JLabel lblEnerga = new JLabel("Energ\u00EDa:");
		lblEnerga.setForeground(Color.WHITE);
		lblEnerga.setFont(mf.MyFont(0, 13));
		lblEnerga.setBounds(324, 95, 64, 14);
		frame.getContentPane().add(lblEnerga);

		JLabel lblAtributos = new JLabel("Atributos:");
		lblAtributos.setForeground(Color.WHITE);
		lblAtributos.setFont(mf.MyFont(0, 15));
		lblAtributos.setBounds(10, 120, 220, 26);
		frame.getContentPane().add(lblAtributos);

		JLabel lblFuerza = new JLabel("Fuerza:");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setFont(mf.MyFont(0, 13));
		lblFuerza.setBounds(10, 156, 64, 14);
		frame.getContentPane().add(lblFuerza);

		JLabel lblDestreza = new JLabel("Destreza:");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(mf.MyFont(0, 13));
		lblDestreza.setBounds(10, 181, 56, 14);
		frame.getContentPane().add(lblDestreza);

		JLabel lblResistencia = new JLabel("Resistencia:");
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setFont(mf.MyFont(0, 13));
		lblResistencia.setBounds(118, 156, 76, 14);
		frame.getContentPane().add(lblResistencia);

		JLabel lblRMgica = new JLabel("R.M\u00E1gica:");
		lblRMgica.setForeground(Color.WHITE);
		lblRMgica.setFont(mf.MyFont(0, 13));
		lblRMgica.setBounds(118, 181, 76, 14);
		frame.getContentPane().add(lblRMgica);

		JLabel lblInteligencia = new JLabel("Inteligencia:");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setFont(mf.MyFont(0, 13));
		lblInteligencia.setBounds(240, 156, 76, 14);
		frame.getContentPane().add(lblInteligencia);

		JLabel lblPercepcin = new JLabel("Percepci\u00F3n:");
		lblPercepcin.setForeground(Color.WHITE);
		lblPercepcin.setFont(mf.MyFont(0, 13));
		lblPercepcin.setBounds(240, 181, 70, 14);
		frame.getContentPane().add(lblPercepcin);

		JLabel lblCarisma = new JLabel("Carisma:");
		lblCarisma.setForeground(Color.WHITE);
		lblCarisma.setFont(mf.MyFont(0, 13));
		lblCarisma.setBounds(361, 156, 56, 14);
		frame.getContentPane().add(lblCarisma);

		JLabel lblHabilidades = new JLabel("Habilidades:");
		lblHabilidades.setForeground(Color.WHITE);
		lblHabilidades.setFont(mf.MyFont(0, 15));
		lblHabilidades.setBounds(10, 206, 220, 26);
		frame.getContentPane().add(lblHabilidades);

		JLabel lblCombate = new JLabel("Combate:");
		lblCombate.setForeground(Color.WHITE);
		lblCombate.setFont(mf.MyFont(0, 14));
		lblCombate.setBounds(10, 229, 95, 26);
		frame.getContentPane().add(lblCombate);

		JLabel lblArmasDeUna = new JLabel("Armas de Una Mano:");
		lblArmasDeUna.setForeground(Color.WHITE);
		lblArmasDeUna.setFont(mf.MyFont(0, 13));
		lblArmasDeUna.setBounds(10, 257, 127, 14);
		frame.getContentPane().add(lblArmasDeUna);

		JLabel lblArmasDeDos = new JLabel("Armas de Dos Manos:");
		lblArmasDeDos.setForeground(Color.WHITE);
		lblArmasDeDos.setFont(mf.MyFont(0, 13));
		lblArmasDeDos.setBounds(10, 282, 127, 14);
		frame.getContentPane().add(lblArmasDeDos);

		JLabel lblArmasDeAsta = new JLabel("Armas de Asta:");
		lblArmasDeAsta.setForeground(Color.WHITE);
		lblArmasDeAsta.setFont(mf.MyFont(0, 13));
		lblArmasDeAsta.setBounds(10, 307, 127, 14);
		frame.getContentPane().add(lblArmasDeAsta);

		JLabel lblArmasADistancia = new JLabel("Armas a Distancia:");
		lblArmasADistancia.setForeground(Color.WHITE);
		lblArmasADistancia.setFont(mf.MyFont(0, 13));
		lblArmasADistancia.setBounds(10, 332, 127, 14);
		frame.getContentPane().add(lblArmasADistancia);

		JLabel lblEsquivar = new JLabel("Esquivar:");
		lblEsquivar.setForeground(Color.WHITE);
		lblEsquivar.setFont(mf.MyFont(0, 13));
		lblEsquivar.setBounds(10, 357, 127, 14);
		frame.getContentPane().add(lblEsquivar);

		JLabel lblBloquear = new JLabel("Bloquear:");
		lblBloquear.setForeground(Color.WHITE);
		lblBloquear.setFont(mf.MyFont(0, 13));
		lblBloquear.setBounds(10, 382, 127, 14);
		frame.getContentPane().add(lblBloquear);

		JLabel lblConocimientos = new JLabel("Conocimientos:");
		lblConocimientos.setForeground(Color.WHITE);
		lblConocimientos.setFont(mf.MyFont(0, 14));
		lblConocimientos.setBounds(191, 229, 116, 26);
		frame.getContentPane().add(lblConocimientos);

		JLabel lblArteDeLa = new JLabel("Arte de la Guerra:");
		lblArteDeLa.setForeground(Color.WHITE);
		lblArteDeLa.setFont(mf.MyFont(0, 13));
		lblArteDeLa.setBounds(191, 257, 109, 14);
		frame.getContentPane().add(lblArteDeLa);

		JLabel lblDiplomacia = new JLabel("Diplomacia:");
		lblDiplomacia.setForeground(Color.WHITE);
		lblDiplomacia.setFont(mf.MyFont(0, 13));
		lblDiplomacia.setBounds(191, 282, 127, 14);
		frame.getContentPane().add(lblDiplomacia);

		JLabel lblEtiqueta = new JLabel("Etiqueta:");
		lblEtiqueta.setForeground(Color.WHITE);
		lblEtiqueta.setFont(mf.MyFont(0, 13));
		lblEtiqueta.setBounds(191, 307, 127, 14);
		frame.getContentPane().add(lblEtiqueta);

		JLabel lblMedicina = new JLabel("Medicina:");
		lblMedicina.setForeground(Color.WHITE);
		lblMedicina.setFont(mf.MyFont(0, 13));
		lblMedicina.setBounds(191, 332, 127, 14);
		frame.getContentPane().add(lblMedicina);

		JLabel lblOcultismo = new JLabel("Ocultismo:");
		lblOcultismo.setForeground(Color.WHITE);
		lblOcultismo.setFont(mf.MyFont(0, 13));
		lblOcultismo.setBounds(191, 357, 127, 14);
		frame.getContentPane().add(lblOcultismo);

		JLabel lblInvestigacin = new JLabel("Investigaci\u00F3n:");
		lblInvestigacin.setForeground(Color.WHITE);
		lblInvestigacin.setFont(mf.MyFont(0, 13));
		lblInvestigacin.setBounds(191, 382, 127, 14);
		frame.getContentPane().add(lblInvestigacin);

		JLabel lblMagia = new JLabel("Magia:");
		lblMagia.setForeground(Color.WHITE);
		lblMagia.setFont(mf.MyFont(0, 14));
		lblMagia.setBounds(357, 229, 95, 26);
		frame.getContentPane().add(lblMagia);

		JLabel lblFuego = new JLabel("Fuego:");
		lblFuego.setForeground(Color.WHITE);
		lblFuego.setFont(mf.MyFont(0, 13));
		lblFuego.setBounds(357, 257, 127, 14);
		frame.getContentPane().add(lblFuego);

		JLabel lblAgua = new JLabel("Agua:");
		lblAgua.setForeground(Color.WHITE);
		lblAgua.setFont(mf.MyFont(0, 13));
		lblAgua.setBounds(357, 282, 127, 14);
		frame.getContentPane().add(lblAgua);

		JLabel lblTierra = new JLabel("Tierra:");
		lblTierra.setForeground(Color.WHITE);
		lblTierra.setFont(mf.MyFont(0, 13));
		lblTierra.setBounds(357, 307, 127, 14);
		frame.getContentPane().add(lblTierra);

		JLabel lblViento = new JLabel("Viento:");
		lblViento.setForeground(Color.WHITE);
		lblViento.setFont(mf.MyFont(0, 13));
		lblViento.setBounds(357, 332, 127, 14);
		frame.getContentPane().add(lblViento);

		JLabel lblDrudica = new JLabel("Dru\u00EDdica:");
		lblDrudica.setForeground(Color.WHITE);
		lblDrudica.setFont(mf.MyFont(0, 13));
		lblDrudica.setBounds(357, 357, 56, 14);
		frame.getContentPane().add(lblDrudica);

		JLabel lblBlanca = new JLabel("Blanca:");
		lblBlanca.setForeground(Color.WHITE);
		lblBlanca.setFont(mf.MyFont(0, 13));
		lblBlanca.setBounds(357, 382, 127, 14);
		frame.getContentPane().add(lblBlanca);

		JLabel lblDestrezas = new JLabel("Destrezas:");
		lblDestrezas.setForeground(Color.WHITE);
		lblDestrezas.setFont(mf.MyFont(0, 14));
		lblDestrezas.setBounds(470, 229, 95, 26);
		frame.getContentPane().add(lblDestrezas);

		JLabel lblAtletismo = new JLabel("Atletismo:");
		lblAtletismo.setForeground(Color.WHITE);
		lblAtletismo.setFont(mf.MyFont(0, 13));
		lblAtletismo.setBounds(470, 257, 127, 14);
		frame.getContentPane().add(lblAtletismo);

		JLabel lblSupervivencia = new JLabel("Supervivencia:");
		lblSupervivencia.setForeground(Color.WHITE);
		lblSupervivencia.setFont(mf.MyFont(0, 13));
		lblSupervivencia.setBounds(470, 282, 89, 14);
		frame.getContentPane().add(lblSupervivencia);

		JLabel lblTrampas = new JLabel("Trampas:");
		lblTrampas.setForeground(Color.WHITE);
		lblTrampas.setFont(mf.MyFont(0, 13));
		lblTrampas.setBounds(470, 307, 127, 14);
		frame.getContentPane().add(lblTrampas);

		JLabel lblEquitacin = new JLabel("Equitaci\u00F3n:");
		lblEquitacin.setForeground(Color.WHITE);
		lblEquitacin.setFont(mf.MyFont(0, 13));
		lblEquitacin.setBounds(470, 332, 127, 14);
		frame.getContentPane().add(lblEquitacin);

		JLabel lblSigilo = new JLabel("Sigilo:");
		lblSigilo.setForeground(Color.WHITE);
		lblSigilo.setFont(mf.MyFont(0, 13));
		lblSigilo.setBounds(470, 355, 76, 18);
		frame.getContentPane().add(lblSigilo);

		JLabel lblArcana = new JLabel("Arcana:");
		lblArcana.setForeground(Color.WHITE);
		lblArcana.setFont(mf.MyFont(0, 13));
		lblArcana.setBounds(357, 432, 127, 14);
		frame.getContentPane().add(lblArcana);

		JLabel lblNegra = new JLabel("Negra:");
		lblNegra.setForeground(Color.WHITE);
		lblNegra.setFont(mf.MyFont(0, 13));
		lblNegra.setBounds(357, 407, 127, 14);
		frame.getContentPane().add(lblNegra);

		JLabel lblNegociacin = new JLabel("Negociaci\u00F3n:");
		lblNegociacin.setForeground(Color.WHITE);
		lblNegociacin.setFont(mf.MyFont(0, 13));
		lblNegociacin.setBounds(191, 407, 127, 14);
		frame.getContentPane().add(lblNegociacin);

		JLabel lblCSecretos = new JLabel("C.Secretos:");
		lblCSecretos.setForeground(Color.WHITE);
		lblCSecretos.setFont(mf.MyFont(0, 13));
		lblCSecretos.setBounds(191, 433, 127, 14);
		frame.getContentPane().add(lblCSecretos);

		txtUnaMano = new JTextField();
		txtUnaMano.setText("" + unamano);
		txtUnaMano.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnaMano.setEditable(false);
		txtUnaMano.setBounds(144, 257, 32, 18);
		frame.getContentPane().add(txtUnaMano);
		txtUnaMano.setColumns(10);

		txtDosManos = new JTextField();
		txtDosManos.setText("" + dosmanos);
		txtDosManos.setHorizontalAlignment(SwingConstants.CENTER);
		txtDosManos.setEditable(false);
		txtDosManos.setColumns(10);
		txtDosManos.setBounds(144, 282, 32, 18);
		frame.getContentPane().add(txtDosManos);

		txtAsta = new JTextField();
		txtAsta.setText("" + asta);
		txtAsta.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsta.setEditable(false);
		txtAsta.setColumns(10);
		txtAsta.setBounds(144, 307, 32, 18);
		frame.getContentPane().add(txtAsta);

		txtDistancia = new JTextField();
		txtDistancia.setText("" + distancia);
		txtDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDistancia.setEditable(false);
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(144, 332, 32, 18);
		frame.getContentPane().add(txtDistancia);

		txtEsquivar = new JTextField();
		txtEsquivar.setText("" + esquivar);
		txtEsquivar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsquivar.setEditable(false);
		txtEsquivar.setColumns(10);
		txtEsquivar.setBounds(144, 357, 32, 18);
		frame.getContentPane().add(txtEsquivar);

		txtBloquear = new JTextField();
		txtBloquear.setText("" + bloquear);
		txtBloquear.setHorizontalAlignment(SwingConstants.CENTER);
		txtBloquear.setEditable(false);
		txtBloquear.setColumns(10);
		txtBloquear.setBounds(144, 382, 32, 18);
		frame.getContentPane().add(txtBloquear);

		txtArteGuerra = new JTextField();
		txtArteGuerra.setText("" + arteGuerra);
		txtArteGuerra.setHorizontalAlignment(SwingConstants.CENTER);
		txtArteGuerra.setEditable(false);
		txtArteGuerra.setColumns(10);
		txtArteGuerra.setBounds(310, 257, 32, 18);
		frame.getContentPane().add(txtArteGuerra);

		txtDiplomacia = new JTextField();
		txtDiplomacia.setText("" + diplomacia);
		txtDiplomacia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiplomacia.setEditable(false);
		txtDiplomacia.setColumns(10);
		txtDiplomacia.setBounds(310, 282, 32, 18);
		frame.getContentPane().add(txtDiplomacia);

		txtEtiqueta = new JTextField();
		txtEtiqueta.setText("" + etiqueta);
		txtEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		txtEtiqueta.setEditable(false);
		txtEtiqueta.setColumns(10);
		txtEtiqueta.setBounds(310, 307, 32, 18);
		frame.getContentPane().add(txtEtiqueta);

		txtMedicina = new JTextField();
		txtMedicina.setText("" + medicina);
		txtMedicina.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicina.setEditable(false);
		txtMedicina.setColumns(10);
		txtMedicina.setBounds(310, 332, 32, 18);
		frame.getContentPane().add(txtMedicina);

		txtOcultismo = new JTextField();
		txtOcultismo.setText("" + ocultismo);
		txtOcultismo.setHorizontalAlignment(SwingConstants.CENTER);
		txtOcultismo.setEditable(false);
		txtOcultismo.setColumns(10);
		txtOcultismo.setBounds(310, 357, 32, 18);
		frame.getContentPane().add(txtOcultismo);

		txtInvestigacion = new JTextField();
		txtInvestigacion.setText("" + investigacion);
		txtInvestigacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvestigacion.setEditable(false);
		txtInvestigacion.setColumns(10);
		txtInvestigacion.setBounds(310, 382, 32, 18);
		frame.getContentPane().add(txtInvestigacion);

		txtNegociacion = new JTextField();
		txtNegociacion.setText("" + negociacion);
		txtNegociacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtNegociacion.setEditable(false);
		txtNegociacion.setColumns(10);
		txtNegociacion.setBounds(310, 407, 32, 18);
		frame.getContentPane().add(txtNegociacion);

		txtCSecretos = new JTextField();
		txtCSecretos.setText("" + cSecretos);
		txtCSecretos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCSecretos.setEditable(false);
		txtCSecretos.setColumns(10);
		txtCSecretos.setBounds(310, 433, 32, 18);
		frame.getContentPane().add(txtCSecretos);

		txtDruidica = new JTextField();
		txtDruidica.setText("" + druidica);
		txtDruidica.setHorizontalAlignment(SwingConstants.CENTER);
		txtDruidica.setEditable(false);
		txtDruidica.setColumns(10);
		txtDruidica.setBounds(423, 357, 32, 18);
		frame.getContentPane().add(txtDruidica);

		txtFuego = new JTextField();
		txtFuego.setText("" + fuego);
		txtFuego.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuego.setEditable(false);
		txtFuego.setColumns(10);
		txtFuego.setBounds(423, 257, 32, 18);
		frame.getContentPane().add(txtFuego);

		txtAgua = new JTextField();
		txtAgua.setText("" + agua);
		txtAgua.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgua.setEditable(false);
		txtAgua.setColumns(10);
		txtAgua.setBounds(423, 282, 32, 18);
		frame.getContentPane().add(txtAgua);

		txtTierra = new JTextField();
		txtTierra.setText("" + tierra);
		txtTierra.setHorizontalAlignment(SwingConstants.CENTER);
		txtTierra.setEditable(false);
		txtTierra.setColumns(10);
		txtTierra.setBounds(423, 307, 32, 18);
		frame.getContentPane().add(txtTierra);

		txtViento = new JTextField();
		txtViento.setText("" + viento);
		txtViento.setHorizontalAlignment(SwingConstants.CENTER);
		txtViento.setEditable(false);
		txtViento.setColumns(10);
		txtViento.setBounds(423, 332, 32, 18);
		frame.getContentPane().add(txtViento);

		txtBlanca = new JTextField();
		txtBlanca.setText("" + blanca);
		txtBlanca.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlanca.setEditable(false);
		txtBlanca.setColumns(10);
		txtBlanca.setBounds(423, 382, 32, 18);
		frame.getContentPane().add(txtBlanca);

		txtNegra = new JTextField();
		txtNegra.setText("" + negra);
		txtNegra.setHorizontalAlignment(SwingConstants.CENTER);
		txtNegra.setEditable(false);
		txtNegra.setColumns(10);
		txtNegra.setBounds(423, 407, 32, 18);
		frame.getContentPane().add(txtNegra);

		txtArcana = new JTextField();
		txtArcana.setText("" + arcana);
		txtArcana.setHorizontalAlignment(SwingConstants.CENTER);
		txtArcana.setEditable(false);
		txtArcana.setColumns(10);
		txtArcana.setBounds(423, 432, 32, 18);
		frame.getContentPane().add(txtArcana);

		txtAtletismo = new JTextField();
		txtAtletismo.setText("" + atletismo);
		txtAtletismo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtletismo.setEditable(false);
		txtAtletismo.setColumns(10);
		txtAtletismo.setBounds(569, 257, 32, 18);
		frame.getContentPane().add(txtAtletismo);

		txtSupervivencia = new JTextField();
		txtSupervivencia.setText("" + supervivencia);
		txtSupervivencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupervivencia.setEditable(false);
		txtSupervivencia.setColumns(10);
		txtSupervivencia.setBounds(569, 282, 32, 18);
		frame.getContentPane().add(txtSupervivencia);

		txtTrampas = new JTextField();
		txtTrampas.setText("" + trampas);
		txtTrampas.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrampas.setEditable(false);
		txtTrampas.setColumns(10);
		txtTrampas.setBounds(569, 307, 32, 18);
		frame.getContentPane().add(txtTrampas);

		txtEquitacion = new JTextField();
		txtEquitacion.setText("" + equitacion);
		txtEquitacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtEquitacion.setEditable(false);
		txtEquitacion.setColumns(10);
		txtEquitacion.setBounds(569, 332, 32, 18);
		frame.getContentPane().add(txtEquitacion);

		txtSigilo = new JTextField();
		txtSigilo.setText("" + sigilo);
		txtSigilo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSigilo.setEditable(false);
		txtSigilo.setColumns(10);
		txtSigilo.setBounds(569, 355, 32, 18);
		frame.getContentPane().add(txtSigilo);

		txtDestreza = new JTextField();
		txtDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		txtDestreza.setText("" + destreza);
		txtDestreza.setEditable(false);
		txtDestreza.setColumns(10);
		txtDestreza.setBounds(76, 181, 32, 18);
		frame.getContentPane().add(txtDestreza);

		txtFuerza = new JTextField();
		txtFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuerza.setText("" + fuerza);
		txtFuerza.setEditable(false);
		txtFuerza.setColumns(10);
		txtFuerza.setBounds(76, 156, 32, 18);
		frame.getContentPane().add(txtFuerza);

		txtResistencia = new JTextField();
		txtResistencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtResistencia.setText("" + resistencia);
		txtResistencia.setEditable(false);
		txtResistencia.setColumns(10);
		txtResistencia.setBounds(198, 156, 32, 18);
		frame.getContentPane().add(txtResistencia);

		txtRMagica = new JTextField();
		txtRMagica.setHorizontalAlignment(SwingConstants.CENTER);
		txtRMagica.setText("" + resistenciaM);
		txtRMagica.setEditable(false);
		txtRMagica.setColumns(10);
		txtRMagica.setBounds(198, 181, 32, 18);
		frame.getContentPane().add(txtRMagica);

		txtInteligencia = new JTextField();
		txtInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtInteligencia.setText("" + inteligencia);
		txtInteligencia.setEditable(false);
		txtInteligencia.setColumns(10);
		txtInteligencia.setBounds(320, 156, 32, 18);
		frame.getContentPane().add(txtInteligencia);

		txtPercepcion = new JTextField();
		txtPercepcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercepcion.setText("" + percepcion);
		txtPercepcion.setEditable(false);
		txtPercepcion.setColumns(10);
		txtPercepcion.setBounds(320, 181, 32, 18);
		frame.getContentPane().add(txtPercepcion);

		txtCarisma = new JTextField();
		txtCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarisma.setText("" + carisma);
		txtCarisma.setEditable(false);
		txtCarisma.setColumns(10);
		txtCarisma.setBounds(422, 156, 32, 18);
		frame.getContentPane().add(txtCarisma);

		txtNombre = new JTextField();
		txtNombre.setText(nombre);
		txtNombre.setEditable(false);
		txtNombre.setFont(mf.MyFont(0, 13));
		txtNombre.setBounds(64, 47, 150, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtRaza = new JTextField();
		txtRaza.setEditable(false);
		txtRaza.setText(raza);
		txtRaza.setFont(mf.MyFont(0, 13));
		txtRaza.setColumns(10);
		txtRaza.setBounds(64, 70, 150, 20);
		frame.getContentPane().add(txtRaza);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setText("" + edad);
		txtEdad.setColumns(10);
		txtEdad.setBounds(266, 47, 46, 18);
		frame.getContentPane().add(txtEdad);

		txtSino = new JTextField();
		txtSino.setEditable(false);
		txtSino.setText("" + sino);
		txtSino.setColumns(10);
		txtSino.setBounds(266, 70, 46, 18);
		frame.getContentPane().add(txtSino);

		txtExperiencia = new JTextField();
		txtExperiencia.setText("" + experiencia);
		txtExperiencia.setEditable(false);
		txtExperiencia.setColumns(10);
		txtExperiencia.setBounds(540, 72, 32, 18);
		frame.getContentPane().add(txtExperiencia);

		txtBendicion = new JTextField();
		txtBendicion.setEditable(false);
		txtBendicion.setText(bendicion);
		txtBendicion.setColumns(10);
		txtBendicion.setFont(mf.MyFont(0, 13));
		txtBendicion.setBounds(404, 43, 201, 18);
		frame.getContentPane().add(txtBendicion);

		txtMana = new JTextField();
		txtMana.setHorizontalAlignment(SwingConstants.CENTER);
		txtMana.setText("" + mana);
		txtMana.setEditable(false);
		txtMana.setColumns(10);
		txtMana.setBounds(266, 95, 46, 18);
		frame.getContentPane().add(txtMana);

		txtEnergia = new JTextField();
		txtEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia.setText("" + energia);
		txtEnergia.setEditable(false);
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(404, 95, 46, 18);
		frame.getContentPane().add(txtEnergia);

		txtSalud = new JTextField();
		txtSalud.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalud.setText("" + salud);
		txtSalud.setEditable(false);
		txtSalud.setColumns(10);
		txtSalud.setBounds(64, 95, 46, 18);
		frame.getContentPane().add(txtSalud);

		JLabel lblPrivilegios = new JLabel("Privilegios:");
		lblPrivilegios.setForeground(Color.WHITE);
		lblPrivilegios.setFont(mf.MyFont(0, 15));
		lblPrivilegios.setBounds(470, 389, 89, 26);
		frame.getContentPane().add(lblPrivilegios);

		JTextArea txtPrivilegios = new JTextArea();
		if(privilegio1!=(null)){
		txtPrivilegios.append(privilegio1 + "\n");}
		if(privilegio2!=(null)){
		txtPrivilegios.append(privilegio2 + "\n");}
		if(privilegio3!=(null)){
		txtPrivilegios.append(privilegio3 + "\n");}
		if(privilegio4!=null){
		txtPrivilegios.append(privilegio4 + "\n");}
		if(privilegio5!=null){
		txtPrivilegios.append(privilegio5 + "\n");}
		txtPrivilegios.setFont(mf.MyFont(0, 13));
		txtPrivilegios.setWrapStyleWord(true);
		txtPrivilegios.setEditable(false);
		txtPrivilegios.setLineWrap(true);
		txtPrivilegios.setBounds(470, 421, 150, 100);
		frame.getContentPane().add(txtPrivilegios);

		JLabel lblReveses = new JLabel("Reveses:");
		lblReveses.setForeground(Color.WHITE);
		lblReveses.setFont(mf.MyFont(0, 15));
		lblReveses.setBounds(470, 532, 89, 26);
		frame.getContentPane().add(lblReveses);

		JTextArea txtReveses = new JTextArea();
		if(reves1!=(null)){
		txtReveses.append(reves1 + "\n");}
		if(reves2!=(null)){
		txtReveses.append(reves2 + "\n");}
		if(reves3!=(null)){
		txtReveses.append(reves3 + "\n");}
		if(reves4!=(null)){
		txtReveses.append(reves4 + "\n");}
		txtReveses.setFont(mf.MyFont(0, 13));
		txtReveses.setWrapStyleWord(true);
		txtReveses.setEditable(false);
		txtReveses.setLineWrap(true);
		txtReveses.setBounds(470, 564, 150, 100);
		frame.getContentPane().add(txtReveses);

		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setFont(mf.MyFont(0, 15));
		lblEquipo.setBounds(10, 432, 89, 26);
		frame.getContentPane().add(lblEquipo);

		JLabel lblArmadura = new JLabel("Armadura:");
		lblArmadura.setForeground(Color.WHITE);
		lblArmadura.setFont(mf.MyFont(0, 14));
		lblArmadura.setBounds(38, 461, 95, 26);
		frame.getContentPane().add(lblArmadura);

		txtArmadura = new JTextField();
		txtArmadura.setText(armadura);
		txtArmadura.setEditable(false);
		txtArmadura.setFont(mf.MyFont(0, 13));
		txtArmadura.setBounds(38, 490, 95, 20);
		frame.getContentPane().add(txtArmadura);
		txtArmadura.setColumns(10);

		JLabel lblArmas = new JLabel("Armas:");
		lblArmas.setForeground(Color.WHITE);
		lblArmas.setFont(mf.MyFont(0, 14));
		lblArmas.setBounds(143, 461, 95, 26);
		frame.getContentPane().add(lblArmas);

		txtArma1 = new JTextField();
		txtArma1.setText(weap1);
		txtArma1.setEditable(false);
		txtArma1.setFont(mf.MyFont(0, 13));
		txtArma1.setColumns(10);
		txtArma1.setBounds(143, 489, 95, 20);
		frame.getContentPane().add(txtArma1);

		txtArma2 = new JTextField();
		txtArma2.setText(weap2);
		txtArma2.setEditable(false);
		txtArma2.setFont(mf.MyFont(0, 13));
		txtArma2.setColumns(10);
		txtArma2.setBounds(143, 520, 95, 20);
		frame.getContentPane().add(txtArma2);

		txtArma3 = new JTextField();
		txtArma3.setText(weap3);
		txtArma3.setEditable(false);
		txtArma3.setFont(mf.MyFont(0, 13));
		txtArma3.setColumns(10);
		txtArma3.setBounds(143, 551, 95, 20);
		frame.getContentPane().add(txtArma3);

		txtArma4 = new JTextField();
		txtArma4.setText(weap4);
		txtArma4.setEditable(false);
		txtArma4.setFont(mf.MyFont(0, 13));
		txtArma4.setColumns(10);
		txtArma4.setBounds(143, 582, 95, 20);
		frame.getContentPane().add(txtArma4);

		JLabel lblObjetos = new JLabel("Objetos:");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setFont(mf.MyFont(0, 14));
		lblObjetos.setBounds(251, 461, 95, 26);
		frame.getContentPane().add(lblObjetos);

		txtObj1 = new JTextField();
		txtObj1.setText(obj1);
		txtObj1.setEditable(false);
		txtObj1.setFont(mf.MyFont(0, 13));
		txtObj1.setColumns(10);
		txtObj1.setBounds(251, 489, 95, 20);
		frame.getContentPane().add(txtObj1);

		txtObj2 = new JTextField();
		txtObj2.setText(obj2);
		txtObj2.setEditable(false);
		txtObj2.setFont(mf.MyFont(0, 13));
		txtObj2.setColumns(10);
		txtObj2.setBounds(251, 520, 95, 20);
		frame.getContentPane().add(txtObj2);

		txtObj3 = new JTextField();
		txtObj3.setText(obj3);
		txtObj3.setEditable(false);
		txtObj3.setFont(mf.MyFont(0, 13));
		txtObj3.setColumns(10);
		txtObj3.setBounds(251, 551, 95, 20);
		frame.getContentPane().add(txtObj3);

		txtObj4 = new JTextField();
		txtObj4.setText(obj4);
		txtObj4.setEditable(false);
		txtObj4.setFont(mf.MyFont(0, 13));
		txtObj4.setColumns(10);
		txtObj4.setBounds(251, 582, 95, 20);
		frame.getContentPane().add(txtObj4);

		txtAcc1 = new JTextField();
		txtAcc1.setText(acc1);
		txtAcc1.setEditable(false);
		txtAcc1.setFont(mf.MyFont(0, 13));
		txtAcc1.setColumns(10);
		txtAcc1.setBounds(357, 489, 95, 20);
		frame.getContentPane().add(txtAcc1);

		txtAcc2 = new JTextField();
		txtAcc2.setText(acc2);
		txtAcc2.setEditable(false);
		txtAcc2.setFont(mf.MyFont(0, 13));
		txtAcc2.setColumns(10);
		txtAcc2.setBounds(357, 520, 95, 20);
		frame.getContentPane().add(txtAcc2);

		txtAcc3 = new JTextField();
		txtAcc3.setText(acc3);
		txtAcc3.setEditable(false);
		txtAcc3.setFont(mf.MyFont(0, 13));
		txtAcc3.setColumns(10);
		txtAcc3.setBounds(357, 551, 95, 20);
		frame.getContentPane().add(txtAcc3);

		txtAcc4 = new JTextField();
		txtAcc4.setText(acc4);
		txtAcc4.setEditable(false);
		txtAcc4.setFont(mf.MyFont(0, 13));
		txtAcc4.setColumns(10);
		txtAcc4.setBounds(357, 582, 95, 20);
		frame.getContentPane().add(txtAcc4);

		JLabel lblAccesorios = new JLabel("Accesorios:");
		lblAccesorios.setForeground(Color.WHITE);
		lblAccesorios.setFont(mf.MyFont(0, 14));
		lblAccesorios.setBounds(357, 461, 95, 26);
		frame.getContentPane().add(lblAccesorios);

		final JButton btnInfoWeap = new JButton("Info");
		btnInfoWeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoArmasCargar window = new InfoArmasCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoWeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoWeap.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoWeap.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen.png")));

			}
		});
		btnInfoWeap.setForeground(Color.WHITE);
		btnInfoWeap.setContentAreaFilled(false);
		btnInfoWeap.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/botones resumen.png")));
		btnInfoWeap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoWeap.setOpaque(false);
		btnInfoWeap.setFont(mf.MyFont(0, 11));
		btnInfoWeap.setBorderPainted(false);
		btnInfoWeap.setBorder(null);
		btnInfoWeap.setBounds(144, 613, 95, 20);
		frame.getContentPane().add(btnInfoWeap);

		final JButton btnInfoArmadura = new JButton("Info");
		btnInfoArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoArmaduraCargar window = new InfoArmaduraCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoArmadura.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoArmadura.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnInfoArmadura.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen.png")));
			}
		});
		btnInfoArmadura.setForeground(Color.WHITE);
		btnInfoArmadura.setContentAreaFilled(false);
		btnInfoArmadura.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/botones resumen.png")));
		btnInfoArmadura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoArmadura.setOpaque(false);
		btnInfoArmadura.setFont(mf.MyFont(0, 11));
		btnInfoArmadura.setBorderPainted(false);
		btnInfoArmadura.setBorder(null);
		btnInfoArmadura.setBounds(38, 521, 95, 20);
		frame.getContentPane().add(btnInfoArmadura);

		final JButton btnInfoObj = new JButton("Info");
		btnInfoObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoObjetosCargar window = new InfoObjetosCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoObj.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen.png")));

			}
		});
		btnInfoObj.setForeground(Color.WHITE);
		btnInfoObj.setContentAreaFilled(false);
		btnInfoObj.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/botones resumen.png")));
		btnInfoObj.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj.setOpaque(false);
		btnInfoObj.setBorderPainted(false);
		btnInfoObj.setFont(mf.MyFont(0, 11));
		btnInfoObj.setBorder(null);
		btnInfoObj.setBounds(252, 613, 95, 20);
		frame.getContentPane().add(btnInfoObj);

		final JButton btnInfoAcc = new JButton("Info");
		btnInfoAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAccesoriosCargar window = new InfoAccesoriosCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoAcc.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones resumen.png")));

			}

		});
		btnInfoAcc.setForeground(Color.WHITE);
		btnInfoAcc.setContentAreaFilled(false);
		btnInfoAcc.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/botones resumen.png")));
		btnInfoAcc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc.setOpaque(false);
		btnInfoAcc.setFont(mf.MyFont(0, 11));
		btnInfoAcc.setBorderPainted(false);
		btnInfoAcc.setBorder(null);
		btnInfoAcc.setBounds(358, 613, 95, 20);
		frame.getContentPane().add(btnInfoAcc);

		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/boton atras.png")));

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				armadura = "";
				descripcionArm = "";
				posesionArm = "";
				prop1Arm = "";
				prop2Arm = "";
				prop3Arm = "";
				weap1 = "";
				descripcionWeap1 = "";
				posesionWeap1 = "";
				prop1Weap1 = "";
				prop2Weap1 = "";
				prop3Weap1 = "";
				weap2 = "";
				descripcionWeap2 = "";
				posesionWeap2 = "";
				prop1Weap2 = "";
				prop2Weap2 = "";
				prop3Weap2 = "";
				weap3 = "";
				descripcionWeap3 = "";
				posesionWeap3 = "";
				prop1Weap3 = "";
				prop2Weap3 = "";
				prop3Weap3 = "";
				weap4 = "";
				descripcionWeap4 = "";
				posesionWeap4 = "";
				prop1Weap4 = "";
				prop2Weap4 = "";
				prop3Weap4 = "";
				obj1 = "";
				descripcionObj1 = "";
				posesionObj1 = "";
				prop1Obj1 = "";
				prop2Obj1 = "";
				prop3Obj1 = "";
				obj2 = "";
				descripcionObj2 = "";
				posesionObj2 = "";
				prop1Obj2 = "";
				prop2Obj2 = "";
				prop3Obj2 = "";
				obj3 = "";
				descripcionObj3 = "";
				posesionObj3 = "";
				prop1Obj3 = "";
				prop2Obj3 = "";
				prop3Obj3 = "";
				obj4 = "";
				descripcionObj4 = "";
				posesionObj4 = "";
				prop1Obj4 = "";
				prop2Obj4 = "";
				prop3Obj4 = "";
				acc1 = "";
				descripcionAcc1 = "";
				posesionAcc1 = "";
				prop1Acc1 = "";
				prop2Acc1 = "";
				prop3Acc1 = "";
				acc2 = "";
				descripcionAcc2 = "";
				posesionAcc2 = "";
				prop1Acc2 = "";
				prop2Acc2 = "";
				prop3Acc2 = "";
				acc3 = "";
				descripcionAcc3 = "";
				posesionAcc3 = "";
				prop1Acc3 = "";
				prop2Acc3 = "";
				prop3Acc3 = "";
				acc4 = "";
				descripcionAcc4 = "";
				posesionAcc4 = "";
				prop1Acc4 = "";
				prop2Acc4 = "";
				prop3Acc4 = "";
				tipoWeap1 = "";
				tipoWeap2 = "";
				tipoWeap3 = "";
				tipoWeap4 = "";
				tipoAcc1 = "";
				tipoAcc2 = "";
				tipoAcc3 = "";
				tipoAcc4 = "";
				arrojadizaWeap1 = "";
				arrojadizaWeap2 = "";
				arrojadizaWeap3 = "";
				arrojadizaWeap4 = "";
				extras="";
				modificadores="";
				poderes="";
				frame.dispose();

			}

		});
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/boton atras.png")));
		button.setBounds(10, 562, 95, 40);
		frame.getContentPane().add(button);

		final JButton btnBorrar = new JButton("Cargar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConexionDBOnline db = new ConexionDBOnline();
				Connection con;
				try {
					con = db.accederDB();
					final Statement tabla = con.createStatement();
					tabla.executeQuery("INSERT INTO PERSONAJE VALUES('"
							+ Loader.usuario + "','" + nombre + "'," + edad
							+ ",'" + raza + "','" + descripcionF + "','"
							+ bendicion + "','" + privilegio1 + "','"
							+ privilegio2 + "','" + privilegio3 + "','"
							+ privilegio4 + "','" + privilegio5 + "','"
							+ reves1 + "','" + reves2 + "','" + reves3 + "','"
							+ reves4 + "'," + fuerza + "," + destreza + ","
							+ resistencia + "," + resistenciaM + ","
							+ inteligencia + "," + percepcion + "," + carisma
							+ "," + unamano + "," + dosmanos + "," + asta + ","
							+ distancia + "," + esquivar + "," + bloquear + ","
							+ arteGuerra + "," + diplomacia + "," + etiqueta
							+ "," + medicina + "," + ocultismo + ","
							+ investigacion + "," + negociacion + ","
							+ cSecretos + "," + fuego + "," + agua + ","
							+ tierra + "," + viento + "," + druidica + ","
							+ blanca + "," + negra + "," + arcana + ","
							+ atletismo + "," + supervivencia + ","
							+ equitacion + "," + trampas + "," + sigilo + ",'"
							+ armadura + "','" + descripcionArm + "','"
							+ posesionArm + "','" + prop1Arm + "','" + prop2Arm
							+ "','" + prop3Arm + "','" + weap1 + "','"
							+ descripcionWeap1 + "','" + posesionWeap1 + "','"
							+ prop1Weap1 + "','" + prop2Weap1 + "','"
							+ prop3Weap1 + "','" + weap2 + "','"
							+ descripcionWeap2 + "','" + posesionWeap2 + "','"
							+ prop1Weap2 + "','" + prop2Weap2 + "','"
							+ prop3Weap2 + "','" + weap3 + "','"
							+ descripcionWeap3 + "','" + posesionWeap3 + "','"
							+ prop1Weap3 + "','" + prop2Weap3 + "','"
							+ prop3Weap3 + "','" + weap4 + "','"
							+ descripcionWeap4 + "','" + posesionWeap4 + "','"
							+ prop1Weap4 + "','" + prop2Weap4 + "','"
							+ prop3Weap4 + "','" + obj1 + "','"
							+ descripcionObj1 + "','" + posesionObj1 + "','"
							+ prop1Obj1 + "','" + prop2Obj1 + "','" + prop3Obj1
							+ "','" + obj2 + "','" + descripcionObj2 + "','"
							+ posesionObj2 + "','" + prop1Obj2 + "','"
							+ prop2Obj2 + "','" + prop3Obj2 + "','" + obj3
							+ "','" + descripcionObj3 + "','" + posesionObj3
							+ "','" + prop1Obj3 + "','" + prop2Obj3 + "','"
							+ prop3Obj3 + "','" + obj4 + "','"
							+ descripcionObj4 + "','" + posesionObj4 + "','"
							+ prop1Obj4 + "','" + prop2Obj4 + "','" + prop3Obj4
							+ "','" + acc1 + "','" + descripcionAcc1 + "','"
							+ posesionAcc1 + "','" + prop1Acc1 + "','"
							+ prop2Acc1 + "','" + prop3Acc1 + "','" + acc2
							+ "','" + descripcionAcc2 + "','" + posesionAcc2
							+ "','" + prop1Acc2 + "','" + prop2Acc2 + "','"
							+ prop3Acc2 + "','" + acc3 + "','"
							+ descripcionAcc3 + "','" + posesionAcc3 + "','"
							+ prop1Acc3 + "','" + prop2Acc3 + "','" + prop3Acc3
							+ "','" + acc4 + "','" + descripcionAcc4 + "','"
							+ posesionAcc4 + "','" + prop1Acc4 + "','"
							+ prop2Acc4 + "','" + prop3Acc4 + "'," + salud
							+ "," + energia + "," + mana + "," + experiencia
							+ "," + sino + ",'" + tipoWeap1 + "','" + tipoWeap2
							+ "','" + tipoWeap3 + "','" + tipoWeap4 + "','"
							+ tipoAcc1 + "','" + tipoAcc2 + "','" + tipoAcc3
							+ "','" + tipoAcc4 + "','" + arrojadizaWeap1
							+ "','" + arrojadizaWeap2 + "','" + arrojadizaWeap3
							+ "','" + arrojadizaWeap4 + "')");

					ArrayList<String> personajes = new ArrayList<String>();
					personajes.add("-Personaje-");
					personajes.add("-Cargar Personaje-");
					ResultSet datos = tabla
							.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE_DE_USUARIO='"
									+ Loader.usuario + "'");
					while (datos.next()) {
						personajes.add(datos.getString("NOMBRE"));

					}
					Perfil.cmboxPersonajes.setModel(new DefaultComboBoxModel(
							personajes.toArray()));

					int seleccion = JOptionPane.showOptionDialog(null,
							"Personaje cargado con exito.",
							"Cargar Personajes", JOptionPane.YES_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Ok" },

							"opcion 1");
					if (seleccion == JOptionPane.OK_OPTION) {
						con.close();
						frame.dispose();
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnBorrar.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnBorrar.setIcon(new ImageIcon(Resumen.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBorrar.setOpaque(false);
		btnBorrar.setFont(mf.MyFont(0, 15));
		btnBorrar.setBorder(null);
		btnBorrar.setContentAreaFilled(false);
		btnBorrar.setBounds(10, 632, 111, 32);
		frame.getContentPane().add(btnBorrar);

		JLabel lblDescripcinFsica = new JLabel("Descripci\u00F3n F\u00EDsica:");
		lblDescripcinFsica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcinFsica.setForeground(Color.WHITE);
		lblDescripcinFsica.setFont(mf.MyFont(0, 15));
		lblDescripcinFsica.setBounds(474, 95, 158, 14);
		frame.getContentPane().add(lblDescripcinFsica);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(470, 120, 162, 100);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(mf.MyFont(0, 12));
		textArea.setText(descripcionF);
		scrollPane.setViewportView(textArea);
		
		JLabel lblDinero = new JLabel("Dinero:");
		lblDinero.setForeground(Color.WHITE);
		lblDinero.setFont(mf.MyFont(0, 14));
		lblDinero.setBounds(64, 440, 70, 14);
		frame.getContentPane().add(lblDinero);

		textField_1 = new JTextField();
		textField_1.setText("" + dinero);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(118, 438, 58, 18);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCampen = new JLabel("\u00BFCampe\u00F3n?");
		lblCampen.setForeground(Color.WHITE);
		lblCampen.setFont(mf.MyFont(0, 13));
		lblCampen.setBounds(475, 21, 64, 14);
		frame.getContentPane().add(lblCampen);
		
		textField = new JTextField();
		textField.setText(campeon);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(555, 19, 46, 18);
		frame.getContentPane().add(textField);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(mf.MyFont(0, 13));
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setBounds(324, 72, 46, 14);
		frame.getContentPane().add(lblNivel);

		textField_2 = new JTextField();
		textField_2.setText(nivel);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(404, 72, 32, 18);
		frame.getContentPane().add(textField_2);
		
		
		final JButton btnPoderes = new JButton("Poderes");
		btnPoderes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnPoderes.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnPoderes.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
				
			}
		});
		btnPoderes.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
		btnPoderes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoPoderesCargar window=new InfoPoderesCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnPoderes.setOpaque(false);
		btnPoderes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPoderes.setForeground(Color.WHITE);
		btnPoderes.setFont(mf.MyFont(0, 11));
		btnPoderes.setContentAreaFilled(false);
		btnPoderes.setBorderPainted(false);
		btnPoderes.setBorder(null);
		btnPoderes.setBounds(144, 644, 95, 20);
		frame.getContentPane().add(btnPoderes);
		
		final JButton btnExtras = new JButton("Extras");
		btnExtras.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
		btnExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoExtrasCargar window=new InfoExtrasCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnExtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnExtras.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnExtras.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
				
			}
		});
		btnExtras.setOpaque(false);
		btnExtras.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExtras.setForeground(Color.WHITE);
		btnExtras.setFont(mf.MyFont(0, 11));
		btnExtras.setContentAreaFilled(false);
		btnExtras.setBorderPainted(false);
		btnExtras.setBorder(null);
		btnExtras.setBounds(252, 644, 95, 20);
		frame.getContentPane().add(btnExtras);
		
		final JButton btnModificadores = new JButton("Modificadores");
		btnModificadores.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
		btnModificadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoModificadoresCargar window=new InfoModificadoresCargar();
				window.getFrame().setVisible(true);
			}
		});
		btnModificadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnModificadores.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnModificadores.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
				
			}
		});
		btnModificadores.setOpaque(false);
		btnModificadores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificadores.setForeground(Color.WHITE);
		btnModificadores.setFont(mf.MyFont(0, 11));
		btnModificadores.setContentAreaFilled(false);
		btnModificadores.setBorderPainted(false);
		btnModificadores.setBorder(null);
		btnModificadores.setBounds(358, 644, 95, 20);
		frame.getContentPane().add(btnModificadores);
		

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Resumen.class
				.getResource("/images/background-resumen.jpg")));
		label.setBounds(0, 0, 642, 702);
		frame.getContentPane().add(label);
	}

}

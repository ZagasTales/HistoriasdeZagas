package es.thesinsprods.zagastales.perfil;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class DatosPersonaje {

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
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosPersonaje window = new DatosPersonaje();
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
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public DatosPersonaje() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Resumen.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setTitle("Historias de Zagas");
		frame.setBounds(100, 100, 648, 715);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		String nombre = "";
		int edad = 0;
		String raza = "";
		String descripcionF = "";
		String bendicion = "";
		String privilegio1 = "";
		String privilegio2 = "";
		String privilegio3 = "";
		String privilegio4 = "";
		String privilegio5 = "";
		String reves1 = "";
		String reves2 = "";
		String reves3 = "";
		String reves4 = "";
		int fuerza = 0;
		int destreza = 0;
		int resistencia = 0;
		int resistenciaM = 0;
		int inteligencia = 0;
		int percepcion = 0;
		int carisma = 0;
		int unamano = 0;
		int dosmanos = 0;
		int asta = 0;
		int distancia = 0;
		int esquivar = 0;
		int bloquear = 0;
		int arteGuerra = 0;
		int diplomacia = 0;
		int etiqueta = 0;
		int medicina = 0;
		int ocultismo = 0;
		int investigacion = 0;
		int negociacion = 0;
		int cSecretos = 0;
		int fuego = 0;
		int agua = 0;
		int tierra = 0;
		int viento = 0;
		int druidica = 0;
		int blanca = 0;
		int negra = 0;
		int arcana = 0;
		int atletismo = 0;
		int supervivencia = 0;
		int equitacion = 0;
		int trampas = 0;
		int sigilo = 0;

		int salud = 0;
		int mana = 0;
		int energia = 0;
		int experiencia = 0;
		int sino = 0;
		int nivel = 0;

		extras="";
		int dinero = 0;
		modificadores="";
		poderes="";
		int exptotal=0;
		int campeon = 0;

		ConexionDBOnline p = new ConexionDBOnline();
		Connection con = p.accederDB();
		final Statement tabla = con.createStatement();
		ResultSet rs = tabla
				.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE='"
						+ Perfil.nPersonaje + "'");
		while (rs.next()) {
			nombre = rs.getString("NOMBRE");
			edad = rs.getInt("EDAD");
			raza = rs.getString("RAZA");
			descripcionF = rs.getString("DESCRIPCION_FISICA");
			;
			bendicion = rs.getString("BENDICION");
			privilegio1 = rs.getString("PRIVILEGIO1");
			privilegio2 = rs.getString("PRIVILEGIO2");
			privilegio3 = rs.getString("PRIVILEGIO3");
			privilegio4 = rs.getString("PRIVILEGIO4");
			privilegio5 = rs.getString("PRIVILEGIO5");
			reves1 = rs.getString("REVES1");
			reves2 = rs.getString("REVES2");
			reves3 = rs.getString("REVES3");
			reves4 = rs.getString("REVES4");
			fuerza = rs.getInt("FUERZA");
			destreza = rs.getInt("DESTREZA");
			resistencia = rs.getInt("RESISTENCIA");
			resistenciaM = rs.getInt("RESISTENCIA_MAGICA");
			inteligencia = rs.getInt("INTELIGENCIA");
			percepcion = rs.getInt("PERCEPCION");
			carisma = rs.getInt("CARISMA");
			unamano = rs.getInt("ARMAS_DE_UNA_MANO");
			dosmanos = rs.getInt("ARMAS_DE_DOS_MANOS");
			asta = rs.getInt("ARMAS_DE_ASTA");
			distancia = rs.getInt("ARMAS_A_DISTANCIA");
			esquivar = rs.getInt("ESQUIVAR");
			bloquear = rs.getInt("BLOQUEAR");
			arteGuerra = rs.getInt("ARTE_DE_LA_GUERRA");
			diplomacia = rs.getInt("DIPLOMACIA");
			etiqueta = rs.getInt("ETIQUETA");
			medicina = rs.getInt("MEDICINA");
			ocultismo = rs.getInt("OCULTISMO");
			investigacion = rs.getInt("INVESTIGACION");
			negociacion = rs.getInt("NEGOCIACION");
			cSecretos = rs.getInt("CONOCIMIENTOS_SECRETOS");
			fuego = rs.getInt("FUEGO");
			agua = rs.getInt("AGUA");
			tierra = rs.getInt("TIERRA");
			viento = rs.getInt("VIENTO");
			druidica = rs.getInt("DRUIDICA");
			blanca = rs.getInt("BLANCA");
			negra = rs.getInt("NEGRA");
			arcana = rs.getInt("ARCANA");
			atletismo = rs.getInt("ATLETISMO");
			supervivencia = rs.getInt("SUPERVIVENCIA");
			equitacion = rs.getInt("EQUITACION");
			trampas = rs.getInt("TRAMPAS");
			sigilo = rs.getInt("SIGILO");
			armadura = rs.getString("ARMADURA");
			descripcionArm = rs.getString("DESCRIPCION_ARMADURA");
			posesionArm = rs.getString("POSESION_ARMADURA");
			prop1Arm = rs.getString("PROPIEDAD1_ARMADURA");
			prop2Arm = rs.getString("PROPIEDAD2_ARMADURA");
			prop3Arm = rs.getString("PROPIEDAD3_ARMADURA");
			weap1 = rs.getString("ARMA1");
			descripcionWeap1 = rs.getString("DESCRIPCION_ARMA1");
			posesionWeap1 = rs.getString("POSESION_ARMA1");
			prop1Weap1 = rs.getString("PROPIEDAD1_ARMA1");
			prop2Weap1 = rs.getString("PROPIEDAD2_ARMA1");
			prop3Weap1 = rs.getString("PROPIEDAD3_ARMA1");
			weap2 = rs.getString("ARMA2");
			descripcionWeap2 = rs.getString("DESCRIPCION_ARMA2");
			posesionWeap2 = rs.getString("POSESION_ARMA2");
			prop1Weap2 = rs.getString("PROPIEDAD1_ARMA2");
			prop2Weap2 = rs.getString("PROPIEDAD2_ARMA2");
			prop3Weap2 = rs.getString("PROPIEDAD3_ARMA2");
			weap3 = rs.getString("ARMA3");
			descripcionWeap3 = rs.getString("DESCRIPCION_ARMA3");
			posesionWeap3 = rs.getString("POSESION_ARMA3");
			prop1Weap3 = rs.getString("PROPIEDAD1_ARMA3");
			prop2Weap3 = rs.getString("PROPIEDAD2_ARMA3");
			prop3Weap3 = rs.getString("PROPIEDAD3_ARMA3");
			weap4 = rs.getString("ARMA4");
			descripcionWeap4 = rs.getString("DESCRIPCION_ARMA4");
			posesionWeap4 = rs.getString("POSESION_ARMA4");
			prop1Weap4 = rs.getString("PROPIEDAD1_ARMA4");
			prop2Weap4 = rs.getString("PROPIEDAD2_ARMA4");
			prop3Weap4 = rs.getString("PROPIEDAD3_ARMA4");
			obj1 = rs.getString("OBJETO1");
			descripcionObj1 = rs.getString("DESCRIPCION_OBJETO1");
			posesionObj1 = rs.getString("POSESION_OBJETO1");
			prop1Obj1 = rs.getString("PROPIEDAD1_OBJETO1");
			prop2Obj1 = rs.getString("PROPIEDAD2_OBJETO1");
			prop3Obj1 = rs.getString("PROPIEDAD3_OBJETO1");
			obj2 = rs.getString("OBJETO2");
			descripcionObj2 = rs.getString("DESCRIPCION_OBJETO2");
			posesionObj2 = rs.getString("POSESION_OBJETO2");
			prop1Obj2 = rs.getString("PROPIEDAD1_OBJETO2");
			prop2Obj2 = rs.getString("PROPIEDAD2_OBJETO2");
			prop3Obj2 = rs.getString("PROPIEDAD3_OBJETO2");
			obj3 = rs.getString("OBJETO3");
			descripcionObj3 = rs.getString("DESCRIPCION_OBJETO3");
			posesionObj3 = rs.getString("POSESION_OBJETO3");
			prop1Obj3 = rs.getString("PROPIEDAD1_OBJETO3");
			prop2Obj3 = rs.getString("PROPIEDAD2_OBJETO3");
			prop3Obj3 = rs.getString("PROPIEDAD3_OBJETO3");
			obj4 = rs.getString("OBJETO4");
			descripcionObj4 = rs.getString("DESCRIPCION_OBJETO4");
			posesionObj4 = rs.getString("POSESION_OBJETO4");
			prop1Obj4 = rs.getString("PROPIEDAD1_OBJETO4");
			prop2Obj4 = rs.getString("PROPIEDAD2_OBJETO4");
			prop3Obj4 = rs.getString("PROPIEDAD3_OBJETO4");
			acc1 = rs.getString("ACCESORIO1");
			descripcionAcc1 = rs.getString("DESCRIPCION_ACCESORIO1");
			posesionAcc1 = rs.getString("POSESION_ACCESORIO1");
			prop1Acc1 = rs.getString("PROPIEDAD1_ACCESORIO1");
			prop2Acc1 = rs.getString("PROPIEDAD2_ACCESORIO1");
			prop3Acc1 = rs.getString("PROPIEDAD3_ACCESORIO1");
			acc2 = rs.getString("ACCESORIO2");
			descripcionAcc2 = rs.getString("DESCRIPCION_ACCESORIO2");
			posesionAcc2 = rs.getString("POSESION_ACCESORIO2");
			prop1Acc2 = rs.getString("PROPIEDAD1_ACCESORIO2");
			prop2Acc2 = rs.getString("PROPIEDAD2_ACCESORIO2");
			prop3Acc2 = rs.getString("PROPIEDAD3_ACCESORIO2");
			acc3 = rs.getString("ACCESORIO3");
			descripcionAcc3 = rs.getString("DESCRIPCION_ACCESORIO3");
			posesionAcc3 = rs.getString("POSESION_ACCESORIO3");
			prop1Acc3 = rs.getString("PROPIEDAD1_ACCESORIO3");
			prop2Acc3 = rs.getString("PROPIEDAD2_ACCESORIO3");
			prop3Acc3 = rs.getString("PROPIEDAD3_ACCESORIO3");
			acc4 = rs.getString("ACCESORIO4");
			descripcionAcc4 = rs.getString("DESCRIPCION_ACCESORIO4");
			posesionAcc4 = rs.getString("POSESION_ACCESORIO4");
			prop1Acc4 = rs.getString("PROPIEDAD1_ACCESORIO4");
			prop2Acc4 = rs.getString("PROPIEDAD2_ACCESORIO4");
			prop3Acc4 = rs.getString("PROPIEDAD3_ACCESORIO4");
			tipoWeap1 = rs.getString("TIPOARMA1");
			tipoWeap2 = rs.getString("TIPOARMA2");
			tipoWeap3 = rs.getString("TIPOARMA3");
			tipoWeap4 = rs.getString("TIPOARMA4");
			tipoAcc1 = rs.getString("TIPOACC1");
			tipoAcc2 = rs.getString("TIPOACC2");
			tipoAcc3 = rs.getString("TIPOACC3");
			tipoAcc4 = rs.getString("TIPOACC4");
			arrojadizaWeap1 = rs.getString("SUBCLASE_ARMA1");
			arrojadizaWeap2 = rs.getString("SUBCLASE_ARMA2");
			arrojadizaWeap3 = rs.getString("SUBCLASE_ARMA3");
			arrojadizaWeap4 = rs.getString("SUBCLASE_ARMA4");
			salud = rs.getInt("SALUD");
			mana = rs.getInt("MANA");
			energia = rs.getInt("ENERGIA");
			experiencia = rs.getInt("EXPERIENCIA");
			sino = rs.getInt("SINO");
			nivel = rs.getInt("NIVEL");
			extras=rs.getString("EXTRAS");
			dinero=rs.getInt("DINERO");
			modificadores=rs.getString("MODIFICADORES");
			poderes=rs.getString("PODERES");
			exptotal=rs.getInt("EXPTOTAL");
			campeon=rs.getInt("CAMPEON");
			

		}
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
				InfoArmasPerfil window = new InfoArmasPerfil();
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
				InfoArmaduraPerfil window = new InfoArmaduraPerfil();
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
				InfoObjetosPerfil window = new InfoObjetosPerfil();
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
				InfoAccesoriosPerfil window = new InfoAccesoriosPerfil();
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
				modificadores="";
				poderes="";
				extras="";
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

		final JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int confirmacion = JOptionPane
							.showOptionDialog(
									txtEtiqueta,
									"¿Seguro que quieres borrar el personaje? Esta acción no se puede deshacer",
									"Borrar Personaje",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Si", "No" }, "opcion 1");

					if (confirmacion == JOptionPane.YES_OPTION) {
						tabla.executeQuery("DELETE FROM PERSONAJE WHERE NOMBRE='"
								+ txtNombre.getText() + "'");
						ArrayList<String> personajes = new ArrayList<String>();
						personajes.add("-Personaje-");
						personajes.add("-Cargar Personaje-");
						ResultSet datos = tabla
								.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE_DE_USUARIO='"
										+ Loader.usuario + "'");
						while (datos.next()) {
							personajes.add(datos.getString("NOMBRE"));

						}
						Perfil.cmboxPersonajes
								.setModel(new DefaultComboBoxModel(personajes
										.toArray()));
						frame.dispose();
					}
				} catch (SQLException e1) {
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

		textField = new JTextField();
		textField.setText("" + nivel);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(404, 72, 32, 18);
		frame.getContentPane().add(textField);

		JLabel label_1 = new JLabel("Nivel:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(mf.MyFont(0, 13));
		label_1.setBounds(324, 72, 46, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Experiencia:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(mf.MyFont(0, 13));
		label_2.setBounds(470, 72, 70, 14);
		frame.getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setText("" + experiencia);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(550, 72, 32, 18);
		frame.getContentPane().add(textField_1);

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
		if(campeon==0){
		textField.setText("No");}
		else{textField.setText("Si");}
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(555, 19, 46, 18);
		frame.getContentPane().add(textField);
		
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
				InfoPoderes window=new InfoPoderes();
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
				InfoExtras window=new InfoExtras();
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
				InfoModificadores window=new InfoModificadores();
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

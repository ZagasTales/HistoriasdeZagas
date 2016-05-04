package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
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
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Start;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.perfil.DatosPersonaje;
import es.thesinsprods.zagastales.perfil.InfoExtras;
import es.thesinsprods.zagastales.perfil.InfoModificadores;
import es.thesinsprods.zagastales.perfil.InfoPoderes;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Font;

public class ResumenNPC {

	private JFrame frmHistoriasDeZagas;
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
	private JTextField txtArm;
	private JTextField txtWeap1;
	private JTextField txtWeap2;
	private JTextField txtWeap3;
	private JTextField txtWeap4;
	private JTextField txtObj1;
	private JTextField txtObj2;
	private JTextField txtObj3;
	private JTextField txtObj4;
	private JTextField txtAcc4;
	private JTextField txtAcc3;
	private JTextField txtAcc2;
	private JTextField txtAcc1;
	public static int campeon;
	MorpheusFont mf = new MorpheusFont();
	private JTextField textField_1;
	private JTextField textField;


	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumenNPC window = new ResumenNPC();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public ResumenNPC() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initialize() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException {

		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ResumenNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 648, 715);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		campeon=0;
		if(BendicionesNPC.campeon==true){
			campeon=1;
		}
		if(BendicionesNPC.campeon==false){
			campeon=0;
		}
		
		

		JLabel lblGeneral = new JLabel("General:");
		lblGeneral.setForeground(Color.WHITE);
		lblGeneral.setFont(mf.MyFont(0, 15));
		lblGeneral.setBounds(10, 11, 220, 26);
		frmHistoriasDeZagas.getContentPane().add(lblGeneral);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(mf.MyFont(0, 13));
		lblNombre.setBounds(10, 47, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblNombre);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setForeground(Color.WHITE);
		lblRaza.setFont(mf.MyFont(0, 13));
		lblRaza.setBounds(10, 72, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblRaza);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(mf.MyFont(0, 13));
		lblEdad.setBounds(224, 47, 46, 14);
		frmHistoriasDeZagas.getContentPane().add(lblEdad);

		JLabel lblSino = new JLabel("Sino:");
		lblSino.setForeground(Color.WHITE);
		lblSino.setFont(mf.MyFont(0, 13));
		lblSino.setBounds(224, 72, 46, 14);
		frmHistoriasDeZagas.getContentPane().add(lblSino);

		JLabel lblBendicion = new JLabel("Bendici\u00F3n:");
		lblBendicion.setForeground(Color.WHITE);
		lblBendicion.setFont(mf.MyFont(0, 13));
		lblBendicion.setBounds(324, 47, 70, 14);
		frmHistoriasDeZagas.getContentPane().add(lblBendicion);

		JLabel lblSalud = new JLabel("Salud:");
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setFont(mf.MyFont(0, 13));
		lblSalud.setBounds(10, 95, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblSalud);

		JLabel lblMan = new JLabel("Man\u00E1:");
		lblMan.setForeground(Color.WHITE);
		lblMan.setFont(mf.MyFont(0, 13));
		lblMan.setBounds(224, 95, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblMan);

		JLabel lblEnerga = new JLabel("Energ\u00EDa:");
		lblEnerga.setForeground(Color.WHITE);
		lblEnerga.setFont(mf.MyFont(0, 13));
		lblEnerga.setBounds(324, 95, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblEnerga);

		JLabel lblAtributos = new JLabel("Atributos:");
		lblAtributos.setForeground(Color.WHITE);
		lblAtributos.setFont(mf.MyFont(0, 15));
		lblAtributos.setBounds(10, 120, 220, 26);
		frmHistoriasDeZagas.getContentPane().add(lblAtributos);

		JLabel lblFuerza = new JLabel("Fuerza:");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setFont(mf.MyFont(0, 13));
		lblFuerza.setBounds(10, 156, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblFuerza);

		JLabel lblDestreza = new JLabel("Destreza:");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(mf.MyFont(0, 13));
		lblDestreza.setBounds(10, 181, 56, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDestreza);

		JLabel lblResistencia = new JLabel("Resistencia:");
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setFont(mf.MyFont(0, 13));
		lblResistencia.setBounds(118, 156, 76, 14);
		frmHistoriasDeZagas.getContentPane().add(lblResistencia);

		JLabel lblRMgica = new JLabel("R.M\u00E1gica:");
		lblRMgica.setForeground(Color.WHITE);
		lblRMgica.setFont(mf.MyFont(0, 13));
		lblRMgica.setBounds(118, 181, 76, 14);
		frmHistoriasDeZagas.getContentPane().add(lblRMgica);

		JLabel lblInteligencia = new JLabel("Inteligencia:");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setFont(mf.MyFont(0, 13));
		lblInteligencia.setBounds(240, 156, 76, 14);
		frmHistoriasDeZagas.getContentPane().add(lblInteligencia);

		JLabel lblPercepcin = new JLabel("Percepci\u00F3n:");
		lblPercepcin.setForeground(Color.WHITE);
		lblPercepcin.setFont(mf.MyFont(0, 13));
		lblPercepcin.setBounds(240, 181, 70, 14);
		frmHistoriasDeZagas.getContentPane().add(lblPercepcin);

		JLabel lblCarisma = new JLabel("Carisma:");
		lblCarisma.setForeground(Color.WHITE);
		lblCarisma.setFont(mf.MyFont(0, 13));
		lblCarisma.setBounds(361, 156, 56, 14);
		frmHistoriasDeZagas.getContentPane().add(lblCarisma);

		JLabel lblHabilidades = new JLabel("Habilidades:");
		lblHabilidades.setForeground(Color.WHITE);
		lblHabilidades.setFont(mf.MyFont(0, 15));
		lblHabilidades.setBounds(10, 206, 220, 26);
		frmHistoriasDeZagas.getContentPane().add(lblHabilidades);

		JLabel lblCombate = new JLabel("Combate:");
		lblCombate.setForeground(Color.WHITE);
		lblCombate.setFont(mf.MyFont(0, 14));
		lblCombate.setBounds(10, 229, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblCombate);

		JLabel lblArmasDeUna = new JLabel("Armas de Una Mano:");
		lblArmasDeUna.setForeground(Color.WHITE);
		lblArmasDeUna.setFont(mf.MyFont(0, 13));
		lblArmasDeUna.setBounds(10, 257, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeUna);

		JLabel lblArmasDeDos = new JLabel("Armas de Dos Manos:");
		lblArmasDeDos.setForeground(Color.WHITE);
		lblArmasDeDos.setFont(mf.MyFont(0, 13));
		lblArmasDeDos.setBounds(10, 282, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeDos);

		JLabel lblArmasDeAsta = new JLabel("Armas de Asta:");
		lblArmasDeAsta.setForeground(Color.WHITE);
		lblArmasDeAsta.setFont(mf.MyFont(0, 13));
		lblArmasDeAsta.setBounds(10, 307, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArmasDeAsta);

		JLabel lblArmasADistancia = new JLabel("Armas a Distancia:");
		lblArmasADistancia.setForeground(Color.WHITE);
		lblArmasADistancia.setFont(mf.MyFont(0, 13));
		lblArmasADistancia.setBounds(10, 332, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArmasADistancia);

		JLabel lblEsquivar = new JLabel("Esquivar:");
		lblEsquivar.setForeground(Color.WHITE);
		lblEsquivar.setFont(mf.MyFont(0, 13));
		lblEsquivar.setBounds(10, 357, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblEsquivar);

		JLabel lblBloquear = new JLabel("Bloquear:");
		lblBloquear.setForeground(Color.WHITE);
		lblBloquear.setFont(mf.MyFont(0, 13));
		lblBloquear.setBounds(10, 382, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblBloquear);

		JLabel lblConocimientos = new JLabel("Conocimientos:");
		lblConocimientos.setForeground(Color.WHITE);
		lblConocimientos.setFont(mf.MyFont(0, 14));
		lblConocimientos.setBounds(191, 229, 116, 26);
		frmHistoriasDeZagas.getContentPane().add(lblConocimientos);

		JLabel lblArteDeLa = new JLabel("Arte de la Guerra:");
		lblArteDeLa.setForeground(Color.WHITE);
		lblArteDeLa.setFont(mf.MyFont(0, 13));
		lblArteDeLa.setBounds(191, 257, 109, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArteDeLa);

		JLabel lblDiplomacia = new JLabel("Diplomacia:");
		lblDiplomacia.setForeground(Color.WHITE);
		lblDiplomacia.setFont(mf.MyFont(0, 13));
		lblDiplomacia.setBounds(191, 282, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDiplomacia);

		JLabel lblEtiqueta = new JLabel("Etiqueta:");
		lblEtiqueta.setForeground(Color.WHITE);
		lblEtiqueta.setFont(mf.MyFont(0, 13));
		lblEtiqueta.setBounds(191, 307, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblEtiqueta);

		JLabel lblMedicina = new JLabel("Medicina:");
		lblMedicina.setForeground(Color.WHITE);
		lblMedicina.setFont(mf.MyFont(0, 13));
		lblMedicina.setBounds(191, 332, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblMedicina);

		JLabel lblOcultismo = new JLabel("Ocultismo:");
		lblOcultismo.setForeground(Color.WHITE);
		lblOcultismo.setFont(mf.MyFont(0, 13));
		lblOcultismo.setBounds(191, 357, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblOcultismo);

		JLabel lblInvestigacin = new JLabel("Investigaci\u00F3n:");
		lblInvestigacin.setForeground(Color.WHITE);
		lblInvestigacin.setFont(mf.MyFont(0, 13));
		lblInvestigacin.setBounds(191, 382, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblInvestigacin);

		JLabel lblMagia = new JLabel("Magia:");
		lblMagia.setForeground(Color.WHITE);
		lblMagia.setFont(mf.MyFont(0, 14));
		lblMagia.setBounds(357, 229, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblMagia);

		JLabel lblFuego = new JLabel("Fuego:");
		lblFuego.setForeground(Color.WHITE);
		lblFuego.setFont(mf.MyFont(0, 13));
		lblFuego.setBounds(357, 257, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblFuego);

		JLabel lblAgua = new JLabel("Agua:");
		lblAgua.setForeground(Color.WHITE);
		lblAgua.setFont(mf.MyFont(0, 13));
		lblAgua.setBounds(357, 282, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblAgua);

		JLabel lblTierra = new JLabel("Tierra:");
		lblTierra.setForeground(Color.WHITE);
		lblTierra.setFont(mf.MyFont(0, 13));
		lblTierra.setBounds(357, 307, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblTierra);

		JLabel lblViento = new JLabel("Viento:");
		lblViento.setForeground(Color.WHITE);
		lblViento.setFont(mf.MyFont(0, 13));
		lblViento.setBounds(357, 332, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblViento);

		JLabel lblDrudica = new JLabel("Dru\u00EDdica:");
		lblDrudica.setForeground(Color.WHITE);
		lblDrudica.setFont(mf.MyFont(0, 13));
		lblDrudica.setBounds(357, 357, 56, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDrudica);

		JLabel lblBlanca = new JLabel("Blanca:");
		lblBlanca.setForeground(Color.WHITE);
		lblBlanca.setFont(mf.MyFont(0, 13));
		lblBlanca.setBounds(357, 382, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblBlanca);

		JLabel lblDestrezas = new JLabel("Destrezas:");
		lblDestrezas.setForeground(Color.WHITE);
		lblDestrezas.setFont(mf.MyFont(0, 14));
		lblDestrezas.setBounds(470, 229, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblDestrezas);

		JLabel lblAtletismo = new JLabel("Atletismo:");
		lblAtletismo.setForeground(Color.WHITE);
		lblAtletismo.setFont(mf.MyFont(0, 13));
		lblAtletismo.setBounds(470, 257, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblAtletismo);

		JLabel lblSupervivencia = new JLabel("Supervivencia:");
		lblSupervivencia.setForeground(Color.WHITE);
		lblSupervivencia.setFont(mf.MyFont(0, 13));
		lblSupervivencia.setBounds(470, 282, 89, 14);
		frmHistoriasDeZagas.getContentPane().add(lblSupervivencia);

		JLabel lblTrampas = new JLabel("Trampas:");
		lblTrampas.setForeground(Color.WHITE);
		lblTrampas.setFont(mf.MyFont(0, 13));
		lblTrampas.setBounds(470, 307, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblTrampas);

		JLabel lblEquitacin = new JLabel("Equitaci\u00F3n:");
		lblEquitacin.setForeground(Color.WHITE);
		lblEquitacin.setFont(mf.MyFont(0, 13));
		lblEquitacin.setBounds(470, 332, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblEquitacin);

		JLabel lblSigilo = new JLabel("Sigilo:");
		lblSigilo.setForeground(Color.WHITE);
		lblSigilo.setFont(mf.MyFont(0, 13));
		lblSigilo.setBounds(470, 355, 76, 18);
		frmHistoriasDeZagas.getContentPane().add(lblSigilo);

		JLabel lblArcana = new JLabel("Arcana:");
		lblArcana.setForeground(Color.WHITE);
		lblArcana.setFont(mf.MyFont(0, 13));
		lblArcana.setBounds(357, 432, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblArcana);

		JLabel lblNegra = new JLabel("Negra:");
		lblNegra.setForeground(Color.WHITE);
		lblNegra.setFont(mf.MyFont(0, 13));
		lblNegra.setBounds(357, 407, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblNegra);

		JLabel lblNegociacin = new JLabel("Negociaci\u00F3n:");
		lblNegociacin.setForeground(Color.WHITE);
		lblNegociacin.setFont(mf.MyFont(0, 13));
		lblNegociacin.setBounds(191, 407, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblNegociacin);

		JLabel lblCSecretos = new JLabel("C.Secretos:");
		lblCSecretos.setForeground(Color.WHITE);
		lblCSecretos.setFont(mf.MyFont(0, 13));
		lblCSecretos.setBounds(191, 433, 127, 14);
		frmHistoriasDeZagas.getContentPane().add(lblCSecretos);

		txtUnaMano = new JTextField();
		txtUnaMano.setText(""
				+ StartNPC.character.getCombatSkills().getOneHanded());
		txtUnaMano.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnaMano.setEditable(false);
		txtUnaMano.setBounds(144, 257, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtUnaMano);
		txtUnaMano.setColumns(10);

		txtDosManos = new JTextField();
		txtDosManos.setText(""
				+ StartNPC.character.getCombatSkills().getTwoHanded());
		txtDosManos.setHorizontalAlignment(SwingConstants.CENTER);
		txtDosManos.setEditable(false);
		txtDosManos.setColumns(10);
		txtDosManos.setBounds(144, 282, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtDosManos);

		txtAsta = new JTextField();
		txtAsta.setText("" + StartNPC.character.getCombatSkills().getPole());
		txtAsta.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsta.setEditable(false);
		txtAsta.setColumns(10);
		txtAsta.setBounds(144, 307, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtAsta);

		txtDistancia = new JTextField();
		txtDistancia.setText(""
				+ StartNPC.character.getCombatSkills().getRanged());
		txtDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDistancia.setEditable(false);
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(144, 332, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtDistancia);

		txtEsquivar = new JTextField();
		txtEsquivar.setText(""
				+ StartNPC.character.getCombatSkills().getDodge());
		txtEsquivar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsquivar.setEditable(false);
		txtEsquivar.setColumns(10);
		txtEsquivar.setBounds(144, 357, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtEsquivar);

		txtBloquear = new JTextField();
		txtBloquear.setText(""
				+ StartNPC.character.getCombatSkills().getBlock());
		txtBloquear.setHorizontalAlignment(SwingConstants.CENTER);
		txtBloquear.setEditable(false);
		txtBloquear.setColumns(10);
		txtBloquear.setBounds(144, 382, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtBloquear);

		txtArteGuerra = new JTextField();
		txtArteGuerra.setText(""
				+ StartNPC.character.getKnowledgeSkills().getArtofWar());
		txtArteGuerra.setHorizontalAlignment(SwingConstants.CENTER);
		txtArteGuerra.setEditable(false);
		txtArteGuerra.setColumns(10);
		txtArteGuerra.setBounds(310, 257, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtArteGuerra);

		txtDiplomacia = new JTextField();
		txtDiplomacia.setText(""
				+ StartNPC.character.getKnowledgeSkills().getDiplomacy());
		txtDiplomacia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiplomacia.setEditable(false);
		txtDiplomacia.setColumns(10);
		txtDiplomacia.setBounds(310, 282, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtDiplomacia);

		txtEtiqueta = new JTextField();
		txtEtiqueta.setText(""
				+ StartNPC.character.getKnowledgeSkills().getEtiquette());
		txtEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		txtEtiqueta.setEditable(false);
		txtEtiqueta.setColumns(10);
		txtEtiqueta.setBounds(310, 307, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtEtiqueta);

		txtMedicina = new JTextField();
		txtMedicina.setText(""
				+ StartNPC.character.getKnowledgeSkills().getMedicine());
		txtMedicina.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicina.setEditable(false);
		txtMedicina.setColumns(10);
		txtMedicina.setBounds(310, 332, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtMedicina);

		txtOcultismo = new JTextField();
		txtOcultismo.setText(""
				+ StartNPC.character.getKnowledgeSkills().getOccultism());
		txtOcultismo.setHorizontalAlignment(SwingConstants.CENTER);
		txtOcultismo.setEditable(false);
		txtOcultismo.setColumns(10);
		txtOcultismo.setBounds(310, 357, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtOcultismo);

		txtInvestigacion = new JTextField();
		txtInvestigacion.setText(""
				+ StartNPC.character.getKnowledgeSkills().getResearch());
		txtInvestigacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvestigacion.setEditable(false);
		txtInvestigacion.setColumns(10);
		txtInvestigacion.setBounds(310, 382, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtInvestigacion);

		txtNegociacion = new JTextField();
		txtNegociacion.setText(""
				+ StartNPC.character.getKnowledgeSkills().getNegotiation());
		txtNegociacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtNegociacion.setEditable(false);
		txtNegociacion.setColumns(10);
		txtNegociacion.setBounds(310, 407, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtNegociacion);

		txtCSecretos = new JTextField();
		txtCSecretos.setText(""
				+ StartNPC.character.getKnowledgeSkills().getSecretKnowledge());
		txtCSecretos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCSecretos.setEditable(false);
		txtCSecretos.setColumns(10);
		txtCSecretos.setBounds(310, 433, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtCSecretos);

		txtDruidica = new JTextField();
		txtDruidica.setText(""
				+ StartNPC.character.getMagicSkills().getDruidic());
		txtDruidica.setHorizontalAlignment(SwingConstants.CENTER);
		txtDruidica.setEditable(false);
		txtDruidica.setColumns(10);
		txtDruidica.setBounds(423, 357, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtDruidica);

		txtFuego = new JTextField();
		txtFuego.setText("" + StartNPC.character.getMagicSkills().getFire());
		txtFuego.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuego.setEditable(false);
		txtFuego.setColumns(10);
		txtFuego.setBounds(423, 257, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtFuego);

		txtAgua = new JTextField();
		txtAgua.setText("" + StartNPC.character.getMagicSkills().getWater());
		txtAgua.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgua.setEditable(false);
		txtAgua.setColumns(10);
		txtAgua.setBounds(423, 282, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtAgua);

		txtTierra = new JTextField();
		txtTierra.setText("" + StartNPC.character.getMagicSkills().getEarth());
		txtTierra.setHorizontalAlignment(SwingConstants.CENTER);
		txtTierra.setEditable(false);
		txtTierra.setColumns(10);
		txtTierra.setBounds(423, 307, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtTierra);

		txtViento = new JTextField();
		txtViento.setText("" + StartNPC.character.getMagicSkills().getWind());
		txtViento.setHorizontalAlignment(SwingConstants.CENTER);
		txtViento.setEditable(false);
		txtViento.setColumns(10);
		txtViento.setBounds(423, 332, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtViento);

		txtBlanca = new JTextField();
		txtBlanca.setText("" + StartNPC.character.getMagicSkills().getWhite());
		txtBlanca.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlanca.setEditable(false);
		txtBlanca.setColumns(10);
		txtBlanca.setBounds(423, 382, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtBlanca);

		txtNegra = new JTextField();
		txtNegra.setText("" + StartNPC.character.getMagicSkills().getBlack());
		txtNegra.setHorizontalAlignment(SwingConstants.CENTER);
		txtNegra.setEditable(false);
		txtNegra.setColumns(10);
		txtNegra.setBounds(423, 407, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtNegra);

		txtArcana = new JTextField();
		txtArcana.setText("" + StartNPC.character.getMagicSkills().getArcane());
		txtArcana.setHorizontalAlignment(SwingConstants.CENTER);
		txtArcana.setEditable(false);
		txtArcana.setColumns(10);
		txtArcana.setBounds(423, 432, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtArcana);

		txtAtletismo = new JTextField();
		txtAtletismo.setText(""
				+ StartNPC.character.getKnowhowSkills().getAthletics());
		txtAtletismo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtletismo.setEditable(false);
		txtAtletismo.setColumns(10);
		txtAtletismo.setBounds(569, 257, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtAtletismo);

		txtSupervivencia = new JTextField();
		txtSupervivencia.setText(""
				+ StartNPC.character.getKnowhowSkills().getSurvival());
		txtSupervivencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupervivencia.setEditable(false);
		txtSupervivencia.setColumns(10);
		txtSupervivencia.setBounds(569, 282, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtSupervivencia);

		txtTrampas = new JTextField();
		txtTrampas.setText(""
				+ StartNPC.character.getKnowhowSkills().getTraps());
		txtTrampas.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrampas.setEditable(false);
		txtTrampas.setColumns(10);
		txtTrampas.setBounds(569, 307, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtTrampas);

		txtEquitacion = new JTextField();
		txtEquitacion.setText(""
				+ StartNPC.character.getKnowhowSkills().getEquitation());
		txtEquitacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtEquitacion.setEditable(false);
		txtEquitacion.setColumns(10);
		txtEquitacion.setBounds(569, 332, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtEquitacion);

		txtSigilo = new JTextField();
		txtSigilo.setText(""
				+ StartNPC.character.getKnowhowSkills().getStealth());
		txtSigilo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSigilo.setEditable(false);
		txtSigilo.setColumns(10);
		txtSigilo.setBounds(569, 355, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtSigilo);

		txtDestreza = new JTextField();
		txtDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		txtDestreza.setText(""
				+ StartNPC.character.getAtributes().getDexterity());
		txtDestreza.setEditable(false);
		txtDestreza.setColumns(10);
		txtDestreza.setBounds(76, 181, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtDestreza);

		txtFuerza = new JTextField();
		txtFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuerza.setText("" + StartNPC.character.getAtributes().getStrength());
		txtFuerza.setEditable(false);
		txtFuerza.setColumns(10);
		txtFuerza.setBounds(76, 156, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtFuerza);

		txtResistencia = new JTextField();
		txtResistencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtResistencia.setText(""
				+ StartNPC.character.getAtributes().getResistance());
		txtResistencia.setEditable(false);
		txtResistencia.setColumns(10);
		txtResistencia.setBounds(198, 156, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtResistencia);

		txtRMagica = new JTextField();
		txtRMagica.setHorizontalAlignment(SwingConstants.CENTER);
		txtRMagica
				.setText("" + StartNPC.character.getAtributes().getMagicres());
		txtRMagica.setEditable(false);
		txtRMagica.setColumns(10);
		txtRMagica.setBounds(198, 181, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtRMagica);

		txtInteligencia = new JTextField();
		txtInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtInteligencia.setText(""
				+ StartNPC.character.getAtributes().getIntelligence());
		txtInteligencia.setEditable(false);
		txtInteligencia.setColumns(10);
		txtInteligencia.setBounds(320, 156, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtInteligencia);

		txtPercepcion = new JTextField();
		txtPercepcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercepcion.setText(""
				+ StartNPC.character.getAtributes().getPerception());
		txtPercepcion.setEditable(false);
		txtPercepcion.setColumns(10);
		txtPercepcion.setBounds(320, 181, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtPercepcion);

		txtCarisma = new JTextField();
		txtCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarisma
				.setText("" + StartNPC.character.getAtributes().getCharisma());
		txtCarisma.setEditable(false);
		txtCarisma.setColumns(10);
		txtCarisma.setBounds(422, 156, 32, 18);
		frmHistoriasDeZagas.getContentPane().add(txtCarisma);

		txtNombre = new JTextField();
		txtNombre.setText(StartNPC.character.getName());
		txtNombre.setEditable(false);
		txtNombre.setFont(mf.MyFont(0, 13));
		txtNombre.setBounds(64, 47, 150, 20);
		frmHistoriasDeZagas.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtRaza = new JTextField();
		txtRaza.setEditable(false);
		txtRaza.setText(StartNPC.character.getRace().getRace());
		txtRaza.setFont(mf.MyFont(0, 13));
		txtRaza.setColumns(10);
		txtRaza.setBounds(64, 70, 150, 20);
		frmHistoriasDeZagas.getContentPane().add(txtRaza);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setText("" + StartNPC.character.getAge());
		txtEdad.setColumns(10);
		txtEdad.setBounds(266, 47, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(txtEdad);

		txtSino = new JTextField();
		txtSino.setEditable(false);
		txtSino.setText("" + StartNPC.character.getFate());
		txtSino.setColumns(10);
		txtSino.setBounds(266, 70, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(txtSino);

		txtBendicion = new JTextField();
		txtBendicion.setEditable(false);
		txtBendicion.setText(StartNPC.character.getBlessing().getBlessing());
		txtBendicion.setColumns(10);
		txtBendicion.setFont(mf.MyFont(0, 13));
		txtBendicion.setBounds(404, 43, 201, 18);
		frmHistoriasDeZagas.getContentPane().add(txtBendicion);

		txtMana = new JTextField();
		txtMana.setHorizontalAlignment(SwingConstants.CENTER);
		txtMana.setText("" + StartNPC.character.getMana());
		txtMana.setEditable(false);
		txtMana.setColumns(10);
		txtMana.setBounds(266, 95, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(txtMana);

		txtEnergia = new JTextField();
		txtEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnergia.setText("" + StartNPC.character.getEndurance());
		txtEnergia.setEditable(false);
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(404, 95, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(txtEnergia);

		txtSalud = new JTextField();
		txtSalud.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalud.setText("" + StartNPC.character.getLife());
		txtSalud.setEditable(false);
		txtSalud.setColumns(10);
		txtSalud.setBounds(64, 95, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(txtSalud);

		JLabel lblPrivilegios = new JLabel("Privilegios:");
		lblPrivilegios.setForeground(Color.WHITE);
		lblPrivilegios.setFont(mf.MyFont(0, 15));
		lblPrivilegios.setBounds(470, 389, 89, 26);
		frmHistoriasDeZagas.getContentPane().add(lblPrivilegios);

		JTextArea txtPrivilegios = new JTextArea();
		ArrayList<String> privilegios = StartNPC.character.getPrivileges()
				.getPrivilegio();
		for (int i = 0; i < privilegios.size(); i++) {
			if (privilegios.get(i).equals("")) {
			} else {
				txtPrivilegios.append(privilegios.get(i) + "\n");
			}
		}
		txtPrivilegios.setFont(mf.MyFont(0, 13));
		txtPrivilegios.setWrapStyleWord(true);
		txtPrivilegios.setEditable(false);
		txtPrivilegios.setLineWrap(true);
		txtPrivilegios.setBounds(470, 421, 150, 100);
		frmHistoriasDeZagas.getContentPane().add(txtPrivilegios);

		JLabel lblReveses = new JLabel("Reveses:");
		lblReveses.setForeground(Color.WHITE);
		lblReveses.setFont(mf.MyFont(0, 15));
		lblReveses.setBounds(470, 532, 89, 26);
		frmHistoriasDeZagas.getContentPane().add(lblReveses);

		JTextArea txtReveses = new JTextArea();
		ArrayList<String> reveses = StartNPC.character.getSetbacks().getReves();
		for (int i = 0; i < reveses.size(); i++) {
			if (reveses.get(i).equals("")) {
			} else {
				txtReveses.append(reveses.get(i) + "\n");
			}
		}
		txtReveses.setFont(mf.MyFont(0, 13));
		txtReveses.setWrapStyleWord(true);
		txtReveses.setEditable(false);
		txtReveses.setLineWrap(true);
		txtReveses.setBounds(470, 564, 150, 100);
		frmHistoriasDeZagas.getContentPane().add(txtReveses);

		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setFont(mf.MyFont(0, 15));
		lblEquipo.setBounds(10, 432, 89, 26);
		frmHistoriasDeZagas.getContentPane().add(lblEquipo);

		JLabel lblArmadura = new JLabel("Armadura:");
		lblArmadura.setForeground(Color.WHITE);
		lblArmadura.setFont(mf.MyFont(0, 14));
		lblArmadura.setBounds(38, 461, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblArmadura);

		txtArm = new JTextField();
		txtArm.setText(EquipoNPC.armor1.getArmor());
		txtArm.setEditable(false);
		txtArm.setFont(mf.MyFont(0, 13));
		txtArm.setBounds(38, 490, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtArm);
		txtArm.setColumns(10);

		JLabel lblArmas = new JLabel("Armas:");
		lblArmas.setForeground(Color.WHITE);
		lblArmas.setFont(mf.MyFont(0, 14));
		lblArmas.setBounds(143, 461, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblArmas);

		txtWeap1 = new JTextField();
		if (EquipoNPC.weapon1 != null) {
			txtWeap1.setText(EquipoNPC.weapon1.getWeapon());
		}
		txtWeap1.setEditable(false);
		txtWeap1.setFont(mf.MyFont(0, 13));
		txtWeap1.setColumns(10);
		txtWeap1.setBounds(143, 489, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtWeap1);

		txtWeap2 = new JTextField();
		if (EquipoNPC.weapon2 != null) {
			txtWeap2.setText(EquipoNPC.weapon2.getWeapon());
		}
		txtWeap2.setEditable(false);
		txtWeap2.setFont(mf.MyFont(0, 13));
		txtWeap2.setColumns(10);
		txtWeap2.setBounds(143, 520, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtWeap2);

		txtWeap3 = new JTextField();
		if (EquipoNPC.weapon3 != null) {
			txtWeap3.setText(EquipoNPC.weapon3.getWeapon());
		}
		txtWeap3.setEditable(false);
		txtWeap3.setFont(mf.MyFont(0, 13));
		txtWeap3.setColumns(10);
		txtWeap3.setBounds(143, 551, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtWeap3);

		txtWeap4 = new JTextField();
		if (EquipoNPC.weapon4 != null) {
			txtWeap4.setText(EquipoNPC.weapon4.getWeapon());
		}
		txtWeap4.setEditable(false);
		txtWeap4.setFont(mf.MyFont(0, 13));
		txtWeap4.setColumns(10);
		txtWeap4.setBounds(143, 582, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtWeap4);

		JLabel lblObjetos = new JLabel("Objetos:");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setFont(mf.MyFont(0, 14));
		lblObjetos.setBounds(251, 461, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblObjetos);

		txtObj1 = new JTextField();
		if (EquipoNPC.misc1 != null) {
			txtObj1.setText(EquipoNPC.misc1.getMisc());
		}
		txtObj1.setEditable(false);
		txtObj1.setFont(mf.MyFont(0, 13));
		txtObj1.setColumns(10);
		txtObj1.setBounds(251, 489, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtObj1);

		txtObj2 = new JTextField();
		if (EquipoNPC.misc2 != null) {
			txtObj2.setText(EquipoNPC.misc2.getMisc());
		}
		txtObj2.setEditable(false);
		txtObj2.setFont(mf.MyFont(0, 13));
		txtObj2.setColumns(10);
		txtObj2.setBounds(251, 520, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtObj2);

		txtObj3 = new JTextField();
		if (EquipoNPC.misc3 != null) {
			txtObj3.setText(EquipoNPC.misc3.getMisc());
		}
		txtObj3.setEditable(false);
		txtObj3.setFont(mf.MyFont(0, 13));
		txtObj3.setColumns(10);
		txtObj3.setBounds(251, 551, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtObj3);

		txtObj4 = new JTextField();
		if (EquipoNPC.misc4 != null) {
			txtObj4.setText(EquipoNPC.misc4.getMisc());
		}
		txtObj4.setEditable(false);
		txtObj4.setFont(mf.MyFont(0, 13));
		txtObj4.setColumns(10);
		txtObj4.setBounds(251, 582, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtObj4);

		txtAcc4 = new JTextField();
		if (EquipoNPC.accesories4 != null) {
			txtAcc4.setText(EquipoNPC.accesories4.getAccesory());
		}
		txtAcc4.setEditable(false);
		txtAcc4.setFont(mf.MyFont(0, 13));
		txtAcc4.setColumns(10);
		txtAcc4.setBounds(357, 582, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtAcc4);

		txtAcc3 = new JTextField();
		if (EquipoNPC.accesories3 != null) {
			txtAcc3.setText(EquipoNPC.accesories3.getAccesory());
		}
		txtAcc3.setEditable(false);
		txtAcc3.setFont(mf.MyFont(0, 13));
		txtAcc3.setColumns(10);
		txtAcc3.setBounds(357, 551, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtAcc3);

		txtAcc2 = new JTextField();
		if (EquipoNPC.accesories2 != null) {
			txtAcc2.setText(EquipoNPC.accesories2.getAccesory());
		}
		txtAcc2.setEditable(false);
		txtAcc2.setFont(mf.MyFont(0, 13));
		txtAcc2.setColumns(10);
		txtAcc2.setBounds(357, 520, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtAcc2);

		txtAcc1 = new JTextField();
		if (EquipoNPC.accesories1 != null) {
			txtAcc1.setText(EquipoNPC.accesories1.getAccesory());
		}
		txtAcc1.setEditable(false);
		txtAcc1.setFont(mf.MyFont(0, 13));
		txtAcc1.setColumns(10);
		txtAcc1.setBounds(357, 489, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(txtAcc1);

		JLabel lblAccesorios = new JLabel("Accesorios:");
		lblAccesorios.setForeground(Color.WHITE);
		lblAccesorios.setFont(mf.MyFont(0, 14));
		lblAccesorios.setBounds(357, 461, 95, 26);
		frmHistoriasDeZagas.getContentPane().add(lblAccesorios);

		final JButton btnInfoWeap = new JButton("Info");
		btnInfoWeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResumenArmasNPC window = new ResumenArmasNPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoWeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoWeap.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoWeap.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen.png")));

			}
		});
		btnInfoWeap.setForeground(Color.WHITE);
		btnInfoWeap.setContentAreaFilled(false);
		btnInfoWeap.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones resumen.png")));
		btnInfoWeap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoWeap.setOpaque(false);
		btnInfoWeap.setFont(mf.MyFont(0, 11));
		btnInfoWeap.setBorderPainted(false);
		btnInfoWeap.setBorder(null);
		btnInfoWeap.setBounds(144, 613, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(btnInfoWeap);

		final JButton btnInfoArm = new JButton("Info");
		btnInfoArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoArm1NPC window = new InfoArm1NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoArm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen.png")));
			}
		});
		btnInfoArm.setForeground(Color.WHITE);
		btnInfoArm.setContentAreaFilled(false);
		btnInfoArm.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones resumen.png")));
		btnInfoArm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoArm.setOpaque(false);
		btnInfoArm.setFont(mf.MyFont(0, 11));
		btnInfoArm.setBorderPainted(false);
		btnInfoArm.setBorder(null);
		btnInfoArm.setBounds(38, 521, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(btnInfoArm);

		final JButton btnInfoObj = new JButton("Info");
		btnInfoObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResumenMiscNPC window = new ResumenMiscNPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoObj.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen.png")));

			}
		});
		btnInfoObj.setForeground(Color.WHITE);
		btnInfoObj.setContentAreaFilled(false);
		btnInfoObj.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones resumen.png")));
		btnInfoObj.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj.setOpaque(false);
		btnInfoObj.setBorderPainted(false);
		btnInfoObj.setFont(mf.MyFont(0, 11));
		btnInfoObj.setBorder(null);
		btnInfoObj.setBounds(252, 613, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(btnInfoObj);

		final JButton btnInfoAcc = new JButton("Info");
		btnInfoAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResumenAccNPC window = new ResumenAccNPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInfoAcc.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones resumen.png")));

			}

		});
		btnInfoAcc.setForeground(Color.WHITE);
		btnInfoAcc.setContentAreaFilled(false);
		btnInfoAcc.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones resumen.png")));
		btnInfoAcc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc.setOpaque(false);
		btnInfoAcc.setFont(mf.MyFont(0, 11));
		btnInfoAcc.setBorderPainted(false);
		btnInfoAcc.setBorder(null);
		btnInfoAcc.setBounds(358, 613, 95, 20);
		frmHistoriasDeZagas.getContentPane().add(btnInfoAcc);

		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AvanzadoNPC window = new AvanzadoNPC();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();
			}
		});
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/boton atras.png")));
		button.setBounds(10, 551, 95, 40);
		frmHistoriasDeZagas.getContentPane().add(button);

		final JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
					EquipoNPC.weapon1 = new Weapons("", "", false, false, EquipoNPC.posss,"");
					EquipoNPC.weapon2 = new Weapons("", "", false, false, EquipoNPC.posss,"");
					EquipoNPC.weapon3 = new Weapons("", "", false, false, EquipoNPC.posss,"");
					EquipoNPC.weapon4 = new Weapons("", "", false, false, EquipoNPC.posss,"");
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
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInicio.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInicio.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicio.setOpaque(false);
		btnInicio.setFont(mf.MyFont(0, 15));
		btnInicio.setBorder(null);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBounds(10, 601, 111, 32);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(470, 120, 162, 100);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);

		final JTextArea txtDescripcionF = new JTextArea();
		txtDescripcionF.setEditable(false);
		txtDescripcionF.setLineWrap(true);
		txtDescripcionF.setWrapStyleWord(true);
		txtDescripcionF.setFont(mf.MyFont(0, 12));
		txtDescripcionF.setText(StartNPC.character.getDescription());
		scrollPane.setViewportView(txtDescripcionF);

		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = txtNombre.getText();
				int edad = Integer.parseInt(txtEdad.getText());
				String raza = txtRaza.getText();
				String descripcionF = txtDescripcionF.getText();
				String bendicion = txtBendicion.getText();
				ArrayList<String> privilegios = StartNPC.character
						.getPrivileges().getPrivilegio();
				String privilegio1 = "";
				String privilegio2 = "";
				String privilegio3 = "";
				String privilegio4 = "";
				String privilegio5 = "";
				if (privilegios.size() == 1) {
					privilegio1 = privilegios.get(0);
				}
				if (privilegios.size() == 2) {
					privilegio1 = privilegios.get(0);
					privilegio2 = privilegios.get(1);
				}
				if (privilegios.size() == 3) {
					privilegio1 = privilegios.get(0);
					privilegio2 = privilegios.get(1);
					privilegio3 = privilegios.get(2);
				}
				if (privilegios.size() == 4) {
					privilegio1 = privilegios.get(0);
					privilegio2 = privilegios.get(1);
					privilegio3 = privilegios.get(2);
					privilegio4 = privilegios.get(3);
				}
				if (privilegios.size() == 5) {
					privilegio1 = privilegios.get(0);
					privilegio2 = privilegios.get(1);
					privilegio3 = privilegios.get(2);
					privilegio4 = privilegios.get(3);
					privilegio5 = privilegios.get(4);
				}
				ArrayList<String> reveses = StartNPC.character.getSetbacks()
						.getReves();
				String reves1 = "";
				String reves2 = "";
				String reves3 = "";
				String reves4 = "";
				if (reveses.size() == 1) {
					reves1 = reveses.get(0);
				}
				if (reveses.size() == 2) {
					reves1 = reveses.get(0);
					reves2 = reveses.get(1);
				}
				if (reveses.size() == 3) {
					reves1 = reveses.get(0);
					reves2 = reveses.get(1);
					reves3 = reveses.get(2);
				}
				if (reveses.size() == 4) {
					reves1 = reveses.get(0);
					reves2 = reveses.get(1);
					reves3 = reveses.get(2);
					reves4 = reveses.get(3);
				}
				int fuerza = Integer.parseInt(txtFuerza.getText());
				;
				int destreza = Integer.parseInt(txtDestreza.getText());
				int resistencia = Integer.parseInt(txtResistencia.getText());
				int resistenciaM = Integer.parseInt(txtRMagica.getText());
				int inteligencia = Integer.parseInt(txtInteligencia.getText());
				int percepcion = Integer.parseInt(txtPercepcion.getText());
				int carisma = Integer.parseInt(txtCarisma.getText());
				int unamano = Integer.parseInt(txtUnaMano.getText());
				int dosmanos = Integer.parseInt(txtDosManos.getText());
				int asta = Integer.parseInt(txtAsta.getText());
				int distancia = Integer.parseInt(txtDistancia.getText());
				int esquivar = Integer.parseInt(txtEsquivar.getText());
				int bloquear = Integer.parseInt(txtBloquear.getText());
				int arteGuerra = Integer.parseInt(txtArteGuerra.getText());
				int diplomacia = Integer.parseInt(txtDiplomacia.getText());
				int etiqueta = Integer.parseInt(txtEtiqueta.getText());
				int medicina = Integer.parseInt(txtMedicina.getText());
				int ocultismo = Integer.parseInt(txtOcultismo.getText());
				int investigacion = Integer.parseInt(txtInvestigacion.getText());
				int negociacion = Integer.parseInt(txtNegociacion.getText());
				int cSecretos = Integer.parseInt(txtCSecretos.getText());
				int fuego = Integer.parseInt(txtFuego.getText());
				int agua = Integer.parseInt(txtAgua.getText());
				int tierra = Integer.parseInt(txtTierra.getText());
				int viento = Integer.parseInt(txtViento.getText());
				int druidica = Integer.parseInt(txtDruidica.getText());
				int blanca = Integer.parseInt(txtBlanca.getText());
				int negra = Integer.parseInt(txtNegra.getText());
				int arcana = Integer.parseInt(txtArcana.getText());
				int atletismo = Integer.parseInt(txtAtletismo.getText());
				int supervivencia = Integer.parseInt(txtSupervivencia.getText());
				int equitacion = Integer.parseInt(txtEquitacion.getText());
				int trampas = Integer.parseInt(txtTrampas.getText());
				int sigilo = Integer.parseInt(txtSigilo.getText());
				String armadura = EquipoNPC.armor1.getArmor();
				String descripcionArm = EquipoNPC.armor1.getDescription();
				String posesionArm = "";
				String prop1Arm = "";
				String prop2Arm = "";
				String prop3Arm = "";
				if (EquipoNPC.armor1.isPosesion()) {
					posesionArm = "Posesión";
					ArrayList<String> propsArm = EquipoNPC.armor1
							.getPossesion().getPos();
					prop1Arm = propsArm.get(0);
					prop2Arm = propsArm.get(1);
					prop3Arm = propsArm.get(2);
				}
				if (EquipoNPC.armor1.isPosesion() == false) {
					posesionArm = "Normal";
				}
				if (EquipoNPC.armor1.isLegendaria() == true) {
					posesionArm = "Legendario";
					ArrayList<String> propsArm = EquipoNPC.armor1
							.getPossesion().getPos();
					if (propsArm.size() == 1) {
						prop1Arm = propsArm.get(0);
					}
					if (propsArm.size() == 2) {
						prop1Arm = propsArm.get(0);
						prop2Arm = propsArm.get(1);

					}
					if (propsArm.size() == 3) {
						prop1Arm = propsArm.get(0);
						prop2Arm = propsArm.get(1);
						prop3Arm = propsArm.get(2);
					}
				}

				String weap1 = EquipoNPC.weapon1.getWeapon();
				String descripcionWeap1 = EquipoNPC.weapon1.getDescription();
				String posesionWeap1 = "";
				String prop1Weap1 = "";
				String prop2Weap1 = "";
				String prop3Weap1 = "";
				if (EquipoNPC.weapon1.isPosesion()) {
					posesionWeap1 = "Posesión";
					ArrayList<String> propsWeap1 = EquipoNPC.weapon1
							.getPossesion().getPos();
					if (propsWeap1.size() == 1) {
						prop1Weap1 = propsWeap1.get(0);
					}
					if (propsWeap1.size() == 2) {
						prop1Weap1 = propsWeap1.get(0);
						prop2Weap1 = propsWeap1.get(1);

					}
					if (propsWeap1.size() == 3) {
						prop1Weap1 = propsWeap1.get(0);
						prop2Weap1 = propsWeap1.get(1);
						prop3Weap1 = propsWeap1.get(2);
					}
				}
				if (EquipoNPC.weapon1.isPosesion() == false) {
					posesionWeap1 = "Normal";
				}
				if (EquipoNPC.weapon1.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsWeap1 = EquipoNPC.weapon1
							.getPossesion().getPos();
					if (propsWeap1.size() == 1) {
						prop1Weap1 = propsWeap1.get(0);
					}
					if (propsWeap1.size() == 2) {
						prop1Weap1 = propsWeap1.get(0);
						prop2Weap1 = propsWeap1.get(1);

					}
					if (propsWeap1.size() == 3) {
						prop1Weap1 = propsWeap1.get(0);
						prop2Weap1 = propsWeap1.get(1);
						prop3Weap1 = propsWeap1.get(2);
					}
				}

				String weap2 = EquipoNPC.weapon2.getWeapon();
				String descripcionWeap2 = EquipoNPC.weapon2.getDescription();
				String posesionWeap2 = "";
				String prop1Weap2 = "";
				String prop2Weap2 = "";
				String prop3Weap2 = "";
				if (EquipoNPC.weapon2.isPosesion()) {
					posesionWeap2 = "Posesión";
					ArrayList<String> propsWeap2 = EquipoNPC.weapon2
							.getPossesion().getPos();
					if (propsWeap2.size() == 1) {
						prop1Weap2 = propsWeap2.get(0);
					}
					if (propsWeap2.size() == 2) {
						prop1Weap2 = propsWeap2.get(0);
						prop2Weap2 = propsWeap2.get(1);

					}
					if (propsWeap2.size() == 3) {
						prop1Weap2 = propsWeap2.get(0);
						prop2Weap2 = propsWeap2.get(1);
						prop3Weap2 = propsWeap2.get(2);
					}
				}
				if (EquipoNPC.weapon2.isPosesion() == false) {
					posesionWeap2 = "Normal";
				}
				if (EquipoNPC.weapon2.isLegendaria() == true) {
					posesionWeap2 = "Legendario";
					ArrayList<String> propsWeap2 = EquipoNPC.weapon2
							.getPossesion().getPos();
					if (propsWeap2.size() == 1) {
						prop1Weap2 = propsWeap2.get(0);
					}
					if (propsWeap2.size() == 2) {
						prop1Weap2 = propsWeap2.get(0);
						prop2Weap2 = propsWeap2.get(1);

					}
					if (propsWeap2.size() == 3) {
						prop1Weap2 = propsWeap2.get(0);
						prop2Weap2 = propsWeap2.get(1);
						prop3Weap2 = propsWeap2.get(2);
					}
				}

				String weap3 = EquipoNPC.weapon3.getWeapon();
				String descripcionWeap3 = EquipoNPC.weapon3.getDescription();
				String posesionWeap3 = "";
				String prop1Weap3 = "";
				String prop2Weap3 = "";
				String prop3Weap3 = "";
				if (EquipoNPC.weapon3.isPosesion()) {
					posesionWeap3 = "Posesión";
					ArrayList<String> propsWeap3 = EquipoNPC.weapon3
							.getPossesion().getPos();
					if (propsWeap3.size() == 1) {
						prop1Weap3 = propsWeap3.get(0);
					}
					if (propsWeap3.size() == 2) {
						prop1Weap3 = propsWeap3.get(0);
						prop2Weap3 = propsWeap3.get(1);

					}
					if (propsWeap3.size() == 3) {
						prop1Weap3 = propsWeap3.get(0);
						prop2Weap3 = propsWeap3.get(1);
						prop3Weap3 = propsWeap3.get(2);
					}
				}
				if (EquipoNPC.weapon3.isPosesion() == false) {
					posesionWeap3 = "Normal";
				}
				if (EquipoNPC.weapon3.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsWeap3 = EquipoNPC.weapon3
							.getPossesion().getPos();
					if (propsWeap3.size() == 1) {
						prop1Weap3 = propsWeap3.get(0);
					}
					if (propsWeap3.size() == 2) {
						prop1Weap3 = propsWeap3.get(0);
						prop2Weap3 = propsWeap3.get(1);

					}
					if (propsWeap3.size() == 3) {
						prop1Weap3 = propsWeap3.get(0);
						prop2Weap3 = propsWeap3.get(1);
						prop3Weap3 = propsWeap3.get(2);
					}
				}

				String weap4 = EquipoNPC.weapon4.getWeapon();
				String descripcionWeap4 = EquipoNPC.weapon4.getDescription();
				String posesionWeap4 = "";
				String prop1Weap4 = "";
				String prop2Weap4 = "";
				String prop3Weap4 = "";
				if (EquipoNPC.weapon4.isPosesion()) {
					posesionWeap4 = "Posesión";
					ArrayList<String> propsWeap4 = EquipoNPC.weapon4
							.getPossesion().getPos();
					if (propsWeap4.size() == 1) {
						prop1Weap4 = propsWeap4.get(0);
					}
					if (propsWeap4.size() == 2) {
						prop1Weap4 = propsWeap4.get(0);
						prop2Weap4 = propsWeap4.get(1);

					}
					if (propsWeap4.size() == 3) {
						prop1Weap4 = propsWeap4.get(0);
						prop2Weap4 = propsWeap4.get(1);
						prop3Weap4 = propsWeap4.get(2);
					}
				}
				if (EquipoNPC.weapon4.isPosesion() == false) {
					posesionWeap4 = "Normal";
				}
				if (EquipoNPC.weapon4.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsWeap4 = EquipoNPC.weapon4
							.getPossesion().getPos();
					if (propsWeap4.size() == 1) {
						prop1Weap4 = propsWeap4.get(0);
					}
					if (propsWeap4.size() == 2) {
						prop1Weap4 = propsWeap4.get(0);
						prop2Weap4 = propsWeap4.get(1);

					}
					if (propsWeap4.size() == 3) {
						prop1Weap4 = propsWeap4.get(0);
						prop2Weap4 = propsWeap4.get(1);
						prop3Weap4 = propsWeap4.get(2);
					}
				}

				String obj1 = EquipoNPC.misc1.getMisc();
				String descripcionObj1 = EquipoNPC.misc1.getDescription();
				String posesionObj1 = "";
				String prop1Obj1 = "";
				String prop2Obj1 = "";
				String prop3Obj1 = "";
				if (EquipoNPC.misc1.isPosesion()) {
					posesionObj1 = "Posesión";
					ArrayList<String> propsObj1 = EquipoNPC.misc1
							.getPossesion().getPos();
					if (propsObj1.size() == 1) {
						prop1Obj1 = propsObj1.get(0);
					}
					if (propsObj1.size() == 2) {
						prop1Obj1 = propsObj1.get(0);
						prop2Obj1 = propsObj1.get(1);

					}
					if (propsObj1.size() == 3) {
						prop1Obj1 = propsObj1.get(0);
						prop2Obj1 = propsObj1.get(1);
						prop3Obj1 = propsObj1.get(2);
					}
				}
				if (EquipoNPC.misc1.isPosesion() == false) {
					posesionObj1 = "Normal";
				}
				if (EquipoNPC.misc1.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsObj1 = EquipoNPC.misc1
							.getPossesion().getPos();
					if (propsObj1.size() == 1) {
						prop1Obj1 = propsObj1.get(0);
					}
					if (propsObj1.size() == 2) {
						prop1Obj1 = propsObj1.get(0);
						prop2Obj1 = propsObj1.get(1);

					}
					if (propsObj1.size() == 3) {
						prop1Obj1 = propsObj1.get(0);
						prop2Obj1 = propsObj1.get(1);
						prop3Obj1 = propsObj1.get(2);
					}
				}

				String obj2 = EquipoNPC.misc2.getMisc();
				String descripcionObj2 = EquipoNPC.misc2.getDescription();
				String posesionObj2 = "";
				String prop1Obj2 = "";
				String prop2Obj2 = "";
				String prop3Obj2 = "";
				if (EquipoNPC.misc2.isPosesion()) {
					posesionObj2 = "Posesión";
					ArrayList<String> propsObj2 = EquipoNPC.misc2
							.getPossesion().getPos();
					if (propsObj2.size() == 1) {
						prop1Obj2 = propsObj2.get(0);
					}
					if (propsObj2.size() == 2) {
						prop1Obj2 = propsObj2.get(0);
						prop2Obj2 = propsObj2.get(1);

					}
					if (propsObj2.size() == 3) {
						prop1Obj2 = propsObj2.get(0);
						prop2Obj2 = propsObj2.get(1);
						prop3Obj2 = propsObj2.get(2);
					}
				}
				if (EquipoNPC.misc2.isPosesion() == false) {
					posesionObj2 = "Normal";
				}
				
				if (EquipoNPC.misc2.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsObj2 = EquipoNPC.misc2
							.getPossesion().getPos();
					if (propsObj2.size() == 1) {
						prop1Obj2 = propsObj2.get(0);
					}
					if (propsObj2.size() == 2) {
						prop1Obj2 = propsObj2.get(0);
						prop2Obj2 = propsObj2.get(1);

					}
					if (propsObj2.size() == 3) {
						prop1Obj2 = propsObj2.get(0);
						prop2Obj2 = propsObj2.get(1);
						prop3Obj2 = propsObj2.get(2);
					}
				}

				String obj3 = EquipoNPC.misc3.getMisc();
				String descripcionObj3 = EquipoNPC.misc3.getDescription();
				String posesionObj3 = "";
				String prop1Obj3 = "";
				String prop2Obj3 = "";
				String prop3Obj3 = "";
				if (EquipoNPC.misc3.isPosesion()) {
					posesionObj3 = "Posesión";
					ArrayList<String> propsObj3 = EquipoNPC.misc3
							.getPossesion().getPos();
					if (propsObj3.size() == 1) {
						prop1Obj3 = propsObj3.get(0);
					}
					if (propsObj3.size() == 2) {
						prop1Obj3 = propsObj3.get(0);
						prop2Obj3 = propsObj3.get(1);

					}
					if (propsObj3.size() == 3) {
						prop1Obj3 = propsObj3.get(0);
						prop2Obj3 = propsObj3.get(1);
						prop3Obj3 = propsObj3.get(2);
					}
				}
				if (EquipoNPC.misc3.isPosesion() == false) {
					posesionObj3 = "Normal";
				}
				if (EquipoNPC.misc3.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsObj3 = EquipoNPC.misc3
							.getPossesion().getPos();
					if (propsObj3.size() == 1) {
						prop1Obj3 = propsObj3.get(0);
					}
					if (propsObj3.size() == 2) {
						prop1Obj3 = propsObj3.get(0);
						prop2Obj3 = propsObj3.get(1);

					}
					if (propsObj3.size() == 3) {
						prop1Obj3 = propsObj3.get(0);
						prop2Obj3 = propsObj3.get(1);
						prop3Obj3 = propsObj3.get(2);
					}
				}
				String obj4 = EquipoNPC.misc4.getMisc();
				String descripcionObj4 = EquipoNPC.misc4.getDescription();
				String posesionObj4 = "";
				String prop1Obj4 = "";
				String prop2Obj4 = "";
				String prop3Obj4 = "";
				if (EquipoNPC.misc4.isPosesion()) {
					posesionObj4 = "Posesión";
					ArrayList<String> propsObj4 = EquipoNPC.misc4
							.getPossesion().getPos();
					if (propsObj4.size() == 1) {
						prop1Obj4 = propsObj4.get(0);
					}
					if (propsObj4.size() == 2) {
						prop1Obj4 = propsObj4.get(0);
						prop2Obj4 = propsObj4.get(1);

					}
					if (propsObj4.size() == 3) {
						prop1Obj4 = propsObj4.get(0);
						prop2Obj4 = propsObj4.get(1);
						prop3Obj4 = propsObj4.get(2);
					}
				}
				if (EquipoNPC.misc4.isPosesion() == false) {
					posesionObj4 = "Normal";
				}
				
				if (EquipoNPC.misc4.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsObj4 = EquipoNPC.misc4
							.getPossesion().getPos();
					if (propsObj4.size() == 1) {
						prop1Obj4 = propsObj4.get(0);
					}
					if (propsObj4.size() == 2) {
						prop1Obj4 = propsObj4.get(0);
						prop2Obj4 = propsObj4.get(1);

					}
					if (propsObj4.size() == 3) {
						prop1Obj4 = propsObj4.get(0);
						prop2Obj4 = propsObj4.get(1);
						prop3Obj4 = propsObj4.get(2);
					}
				}

				String acc1 = EquipoNPC.accesories1.getAccesory();
				String descripcionAcc1 = EquipoNPC.accesories1.getDescription();
				String posesionAcc1 = "";
				String prop1Acc1 = "";
				String prop2Acc1 = "";
				String prop3Acc1 = "";
				if (EquipoNPC.accesories1.isPosesion()) {
					posesionAcc1 = "Posesión";
					ArrayList<String> propsAcc1 = EquipoNPC.accesories1
							.getPossesion().getPos();
					if (propsAcc1.size() == 1) {
						prop1Acc1 = propsAcc1.get(0);
					}
					if (propsAcc1.size() == 2) {
						prop1Acc1 = propsAcc1.get(0);
						prop2Acc1 = propsAcc1.get(1);

					}
					if (propsAcc1.size() == 3) {
						prop1Acc1 = propsAcc1.get(0);
						prop2Acc1 = propsAcc1.get(1);
						prop3Acc1 = propsAcc1.get(2);
					}
				}
				if (EquipoNPC.accesories1.isPosesion() == false) {
					posesionAcc1 = "Normal";
				}
				if (EquipoNPC.accesories1.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsAcc1 = EquipoNPC.accesories1
							.getPossesion().getPos();
					if (propsAcc1.size() == 1) {
						prop1Acc1 = propsAcc1.get(0);
					}
					if (propsAcc1.size() == 2) {
						prop1Acc1 = propsAcc1.get(0);
						prop2Acc1 = propsAcc1.get(1);

					}
					if (propsAcc1.size() == 3) {
						prop1Acc1 = propsAcc1.get(0);
						prop2Acc1 = propsAcc1.get(1);
						prop3Acc1 = propsAcc1.get(2);
					}
				}

				String acc2 = EquipoNPC.accesories2.getAccesory();
				String descripcionAcc2 = EquipoNPC.accesories2.getDescription();
				String posesionAcc2 = "";
				String prop1Acc2 = "";
				String prop2Acc2 = "";
				String prop3Acc2 = "";
				if (EquipoNPC.accesories2.isPosesion()) {
					posesionAcc2 = "Posesión";
					ArrayList<String> propsAcc2 = EquipoNPC.accesories2
							.getPossesion().getPos();
					if (propsAcc2.size() == 1) {
						prop1Acc2 = propsAcc2.get(0);
					}
					if (propsAcc2.size() == 2) {
						prop1Acc2 = propsAcc2.get(0);
						prop2Acc2 = propsAcc2.get(1);

					}
					if (propsAcc2.size() == 3) {
						prop1Acc2 = propsAcc2.get(0);
						prop2Acc2 = propsAcc2.get(1);
						prop3Acc2 = propsAcc2.get(2);
					}
				}
				if (EquipoNPC.accesories2.isPosesion() == false) {
					posesionAcc2 = "Normal";
				}
				
				if (EquipoNPC.accesories2.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsAcc2 = EquipoNPC.accesories2
							.getPossesion().getPos();
					if (propsAcc2.size() == 1) {
						prop1Acc2 = propsAcc2.get(0);
					}
					if (propsAcc2.size() == 2) {
						prop1Acc2 = propsAcc2.get(0);
						prop2Acc2 = propsAcc2.get(1);

					}
					if (propsAcc2.size() == 3) {
						prop1Acc2 = propsAcc2.get(0);
						prop2Acc2 = propsAcc2.get(1);
						prop3Acc2 = propsAcc2.get(2);
					}
				}

				String acc3 = EquipoNPC.accesories3.getAccesory();
				String descripcionAcc3 = EquipoNPC.accesories3.getDescription();
				String posesionAcc3 = "";
				String prop1Acc3 = "";
				String prop2Acc3 = "";
				String prop3Acc3 = "";
				if (EquipoNPC.accesories3.isPosesion()) {
					posesionAcc3 = "Posesión";
					ArrayList<String> propsAcc3 = EquipoNPC.accesories3
							.getPossesion().getPos();
					if (propsAcc3.size() == 1) {
						prop1Acc3 = propsAcc3.get(0);
					}
					if (propsAcc3.size() == 2) {
						prop1Acc3 = propsAcc3.get(0);
						prop2Acc3 = propsAcc3.get(1);

					}
					if (propsAcc3.size() == 3) {
						prop1Acc3 = propsAcc3.get(0);
						prop2Acc3 = propsAcc3.get(1);
						prop3Acc3 = propsAcc3.get(2);
					}
				}
				if (EquipoNPC.accesories3.isPosesion() == false) {
					posesionAcc3 = "Normal";
				}
				if (EquipoNPC.accesories3.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsAcc3 = EquipoNPC.accesories3
							.getPossesion().getPos();
					if (propsAcc3.size() == 1) {
						prop1Acc3 = propsAcc3.get(0);
					}
					if (propsAcc3.size() == 2) {
						prop1Acc3 = propsAcc3.get(0);
						prop2Acc3 = propsAcc3.get(1);

					}
					if (propsAcc3.size() == 3) {
						prop1Acc3 = propsAcc3.get(0);
						prop2Acc3 = propsAcc3.get(1);
						prop3Acc3 = propsAcc3.get(2);
					}
				}

				String acc4 = EquipoNPC.accesories4.getAccesory();
				String descripcionAcc4 = EquipoNPC.accesories4.getDescription();
				String posesionAcc4 = "";
				String prop1Acc4 = "";
				String prop2Acc4 = "";
				String prop3Acc4 = "";
				if (EquipoNPC.accesories4.isPosesion()) {
					posesionAcc4 = "Posesión";
					ArrayList<String> propsAcc4 = EquipoNPC.accesories4
							.getPossesion().getPos();
					if (propsAcc4.size() == 1) {
						prop1Acc4 = propsAcc4.get(0);
					}
					if (propsAcc4.size() == 2) {
						prop1Acc4 = propsAcc4.get(0);
						prop2Acc4 = propsAcc4.get(1);

					}
					if (propsAcc4.size() == 3) {
						prop1Acc4 = propsAcc4.get(0);
						prop2Acc4 = propsAcc4.get(1);
						prop3Acc4 = propsAcc4.get(2);
					}
				}
				if (EquipoNPC.accesories4.isPosesion() == false) {
					posesionAcc4 = "Normal";
				}
				if (EquipoNPC.accesories4.isLegendaria() == true) {
					posesionWeap1 = "Legendario";
					ArrayList<String> propsAcc4 = EquipoNPC.accesories4
							.getPossesion().getPos();
					if (propsAcc4.size() == 1) {
						prop1Acc4 = propsAcc4.get(0);
					}
					if (propsAcc4.size() == 2) {
						prop1Acc4 = propsAcc4.get(0);
						prop2Acc4 = propsAcc4.get(1);

					}
					if (propsAcc4.size() == 3) {
						prop1Acc4 = propsAcc4.get(0);
						prop2Acc4 = propsAcc4.get(1);
						prop3Acc4 = propsAcc4.get(2);
					}
				}

				String tipoWeap1 = EquipoNPC.weapon1.getClass().getSimpleName();
				String tipoWeap2 = EquipoNPC.weapon2.getClass().getSimpleName();
				String tipoWeap3 = EquipoNPC.weapon3.getClass().getSimpleName();
				String tipoWeap4 = EquipoNPC.weapon4.getClass().getSimpleName();
				String tipoAcc1 = EquipoNPC.accesories1.getClass()
						.getSimpleName();
				String tipoAcc2 = EquipoNPC.accesories2.getClass()
						.getSimpleName();
				String tipoAcc3 = EquipoNPC.accesories3.getClass()
						.getSimpleName();
				String tipoAcc4 = EquipoNPC.accesories4.getClass()
						.getSimpleName();

				String arrojadizaWeap1 = EquipoNPC.weapon1.getTipo();
				String arrojadizaWeap2 = EquipoNPC.weapon2.getTipo();
				String arrojadizaWeap3 = EquipoNPC.weapon3.getTipo();
				String arrojadizaWeap4 = EquipoNPC.weapon4.getTipo();
				
				int salud = Integer.parseInt(txtSalud.getText());
				int mana = Integer.parseInt(txtMana.getText());
				int energia = Integer.parseInt(txtEnergia.getText());
				int experiencia = 0;
				int sino = Integer.parseInt(txtSino.getText());
				
				JFileChooser fileChooser = new JFileChooser();
				int guardar = fileChooser.showSaveDialog(txtEtiqueta);
				if (guardar == JFileChooser.APPROVE_OPTION) {

					File fichero = new File(fileChooser.getSelectedFile()
							+ ".txt");
					PrintWriter writer;

					try {
						writer = new PrintWriter(fichero);

						writer.println(nombre);
						writer.println(edad);
						writer.println(raza);
						writer.println(descripcionF);
						writer.println(bendicion);
						writer.println(privilegio1);
						writer.println(privilegio2);
						writer.println(privilegio3);
						writer.println(privilegio4);
						writer.println(privilegio5);
						writer.println(reves1);
						writer.println(reves2);
						writer.println(reves3);
						writer.println(reves4);
						writer.println(fuerza);
						writer.println(destreza);
						writer.println(resistencia);
						writer.println(resistenciaM);
						writer.println(inteligencia);
						writer.println(percepcion);
						writer.println(carisma);
						writer.println(unamano);
						writer.println(dosmanos);
						writer.println(asta);
						writer.println(distancia);
						writer.println(esquivar);
						writer.println(bloquear);
						writer.println(arteGuerra);
						writer.println(diplomacia);
						writer.println(etiqueta);
						writer.println(medicina);
						writer.println(ocultismo);
						writer.println(investigacion);
						writer.println(negociacion);
						writer.println(cSecretos);
						writer.println(fuego);
						writer.println(agua);
						writer.println(tierra);
						writer.println(viento);
						writer.println(druidica);
						writer.println(blanca);
						writer.println(negra);
						writer.println(arcana);
						writer.println(atletismo);
						writer.println(supervivencia);
						writer.println(equitacion);
						writer.println(trampas);
						writer.println(sigilo);
						writer.println(armadura);
						writer.println(descripcionArm);
						writer.println(posesionArm);
						writer.println(prop1Arm);
						writer.println(prop2Arm);
						writer.println(prop3Arm);
						writer.println(weap1);
						writer.println(descripcionWeap1);
						writer.println(posesionWeap1);
						writer.println(prop1Weap1);
						writer.println(prop2Weap1);
						writer.println(prop3Weap1);
						writer.println(weap2);
						writer.println(descripcionWeap2);
						writer.println(posesionWeap2);
						writer.println(prop1Weap2);
						writer.println(prop2Weap2);
						writer.println(prop3Weap2);
						writer.println(weap3);
						writer.println(descripcionWeap3);
						writer.println(posesionWeap3);
						writer.println(prop1Weap3);
						writer.println(prop2Weap3);
						writer.println(prop3Weap3);
						writer.println(weap4);
						writer.println(descripcionWeap4);
						writer.println(posesionWeap4);
						writer.println(prop1Weap4);
						writer.println(prop2Weap4);
						writer.println(prop3Weap4);
						writer.println(obj1);
						writer.println(descripcionObj1);
						writer.println(posesionObj1);
						writer.println(prop1Obj1);
						writer.println(prop2Obj1);
						writer.println(prop3Obj1);
						writer.println(obj2);
						writer.println(descripcionObj2);
						writer.println(posesionObj2);
						writer.println(prop1Obj2);
						writer.println(prop2Obj2);
						writer.println(prop3Obj2);
						writer.println(obj3);
						writer.println(descripcionObj3);
						writer.println(posesionObj3);
						writer.println(prop1Obj3);
						writer.println(prop2Obj3);
						writer.println(prop3Obj3);
						writer.println(obj4);
						writer.println(descripcionObj4);
						writer.println(posesionObj4);
						writer.println(prop1Obj4);
						writer.println(prop2Obj4);
						writer.println(prop3Obj4);
						writer.println(acc1);
						writer.println(descripcionAcc1);
						writer.println(posesionAcc1);
						writer.println(prop1Acc1);
						writer.println(prop2Acc1);
						writer.println(prop3Acc1);
						writer.println(acc2);
						writer.println(descripcionAcc2);
						writer.println(posesionAcc2);
						writer.println(prop1Acc2);
						writer.println(prop2Acc2);
						writer.println(prop3Acc2);
						writer.println(acc3);
						writer.println(descripcionAcc3);
						writer.println(posesionAcc3);
						writer.println(prop1Acc3);
						writer.println(prop2Acc3);
						writer.println(prop3Acc3);
						writer.println(acc4);
						writer.println(descripcionAcc4);
						writer.println(posesionAcc4);
						writer.println(prop1Acc4);
						writer.println(prop2Acc4);
						writer.println(prop3Acc4);
						writer.println(salud);
						writer.println(energia);
						writer.println(mana);
						writer.println(experiencia);
						writer.println(sino);
						writer.println(tipoWeap1);
						writer.println(tipoWeap2);
						writer.println(tipoWeap3);
						writer.println(tipoWeap4);
						writer.println(tipoAcc1);
						writer.println(tipoAcc2);
						writer.println(tipoAcc3);
						writer.println(tipoAcc4);
						writer.println(arrojadizaWeap1);
						writer.println(arrojadizaWeap2);
						writer.println(arrojadizaWeap3);
						writer.println(arrojadizaWeap4);
						writer.println(StartNPC.character.getExtras());
						writer.println(EquipoNPC.dinero);
						writer.println(StartNPC.character.getModificadores());
						writer.println(StartNPC.character.getPoderes());
						writer.println("1");
						writer.println("0");
						writer.println(""+campeon);

						fichero.setReadable(true);
						fichero.setWritable(false);
						fichero.setExecutable(false);
						writer.close();
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					}

				}

				if (Loader.usuario.length() > 0) {
					try {
						ConexionDBOnline db = new ConexionDBOnline();
						Connection con = db.accederDB();
						final Statement tabla = con.createStatement();
						tabla.executeQuery("INSERT INTO NPC VALUES('"+ nombre + "'," + edad
								+ ",'" + raza + "','" + descripcionF + "','"
								+ bendicion + "','" + privilegio1 + "','"
								+ privilegio2 + "','" + privilegio3 + "','"
								+ privilegio4 + "','" + privilegio5 + "','"
								+ reves1 + "','" + reves2 + "','" + reves3
								+ "','" + reves4 + "'," + fuerza + ","
								+ destreza + "," + resistencia + ","
								+ resistenciaM + "," + inteligencia + ","
								+ percepcion + "," + carisma + "," + unamano
								+ "," + dosmanos + "," + asta + "," + distancia
								+ "," + esquivar + "," + bloquear + ","
								+ arteGuerra + "," + diplomacia + ","
								+ etiqueta + "," + medicina + "," + ocultismo
								+ "," + investigacion + "," + negociacion + ","
								+ cSecretos + "," + fuego + "," + agua + ","
								+ tierra + "," + viento + "," + druidica + ","
								+ blanca + "," + negra + "," + arcana + ","
								+ atletismo + "," + supervivencia + ","
								+ equitacion + "," + trampas + "," + sigilo
								+ ",'" + armadura + "','" + descripcionArm
								+ "','" + posesionArm + "','" + prop1Arm
								+ "','" + prop2Arm + "','" + prop3Arm + "','"
								+ weap1 + "','" + descripcionWeap1 + "','"
								+ posesionWeap1 + "','" + prop1Weap1 + "','"
								+ prop2Weap1 + "','" + prop3Weap1 + "','"
								+ weap2 + "','" + descripcionWeap2 + "','"
								+ posesionWeap2 + "','" + prop1Weap2 + "','"
								+ prop2Weap2 + "','" + prop3Weap2 + "','"
								+ weap3 + "','" + descripcionWeap3 + "','"
								+ posesionWeap3 + "','" + prop1Weap3 + "','"
								+ prop2Weap3 + "','" + prop3Weap3 + "','"
								+ weap4 + "','" + descripcionWeap4 + "','"
								+ posesionWeap4 + "','" + prop1Weap4 + "','"
								+ prop2Weap4 + "','" + prop3Weap4 + "','"
								+ obj1 + "','" + descripcionObj1 + "','"
								+ posesionObj1 + "','" + prop1Obj1 + "','"
								+ prop2Obj1 + "','" + prop3Obj1 + "','" + obj2
								+ "','" + descripcionObj2 + "','"
								+ posesionObj2 + "','" + prop1Obj2 + "','"
								+ prop2Obj2 + "','" + prop3Obj2 + "','" + obj3
								+ "','" + descripcionObj3 + "','"
								+ posesionObj3 + "','" + prop1Obj3 + "','"
								+ prop2Obj3 + "','" + prop3Obj3 + "','" + obj4
								+ "','" + descripcionObj4 + "','"
								+ posesionObj4 + "','" + prop1Obj4 + "','"
								+ prop2Obj4 + "','" + prop3Obj4 + "','" + acc1
								+ "','" + descripcionAcc1 + "','"
								+ posesionAcc1 + "','" + prop1Acc1 + "','"
								+ prop2Acc1 + "','" + prop3Acc1 + "','" + acc2
								+ "','" + descripcionAcc2 + "','"
								+ posesionAcc2 + "','" + prop1Acc2 + "','"
								+ prop2Acc2 + "','" + prop3Acc2 + "','" + acc3
								+ "','" + descripcionAcc3 + "','"
								+ posesionAcc3 + "','" + prop1Acc3 + "','"
								+ prop2Acc3 + "','" + prop3Acc3 + "','" + acc4
								+ "','" + descripcionAcc4 + "','"
								+ posesionAcc4 + "','" + prop1Acc4 + "','"
								+ prop2Acc4 + "','" + prop3Acc4 + "'," + salud
								+ "," + energia + "," + mana + ","
								+ experiencia + "," + sino + ",'" + tipoWeap1
								+ "','" + tipoWeap2 + "','" + tipoWeap3 + "','"
								+ tipoWeap4 + "','" + tipoAcc1 + "','"
								+ tipoAcc2 + "','" + tipoAcc3 + "','"
								+ tipoAcc4 + "','" + arrojadizaWeap1 + "','"
								+ arrojadizaWeap2 + "','" + arrojadizaWeap3
								+ "','" + arrojadizaWeap4 + "','"+StartNPC.character.getExtras()+"'" + ","
								+ EquipoNPC.dinero + ",'"+StartNPC.character.getModificadores()+"','"+StartNPC.character.getPoderes()+"',1,0,"+campeon+")");
						con.close();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					int seleccion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas, "Personaje creado con exito.",
							"Creador de Personajes", JOptionPane.YES_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Ok" },

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
						StartNPC.atrpoints = new AtributePoints();
						StartNPC.skpoints = new SkillPoints();
						StartNPC.atributos = new Atributes(StartNPC.atrpoints);
						StartNPC.combatSkills = new CombatSkills(
								StartNPC.skpoints);
						StartNPC.knowledgeSkills = new KnowledgeSkills(
								StartNPC.skpoints);
						StartNPC.magicSkills = new MagicSkills(
								StartNPC.skpoints);
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
						EquipoNPC.weapon1 = new Weapons("", "", false, false, EquipoNPC.posss,"");
						EquipoNPC.weapon2 = new Weapons("", "", false, false, EquipoNPC.posss,"");
						EquipoNPC.weapon3 = new Weapons("", "", false, false, EquipoNPC.posss,"");
						EquipoNPC.weapon4 = new Weapons("", "", false, false, EquipoNPC.posss,"");
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
						StartNPC.character = new Characters(null, race, "", 0,
								2, 10, 20, 20, StartNPC.atributos,
								StartNPC.combatSkills,
								StartNPC.knowledgeSkills, StartNPC.magicSkills,
								StartNPC.knowhowSkills, blessing, null,
								setbacks, false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null, 0, 1,0,"","","");
						frmHistoriasDeZagas.dispose();
						Inicio window = new Inicio();
						window.getFrmHistoriasDeZagas().setVisible(true);
					}

				}
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnGuardar.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnGuardar.setIcon(new ImageIcon(ResumenNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});

		JLabel lblDescripcinFsica = new JLabel("Descripci\u00F3n F\u00EDsica:");
		lblDescripcinFsica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcinFsica.setForeground(Color.WHITE);
		lblDescripcinFsica.setFont(mf.MyFont(0, 15));
		lblDescripcinFsica.setBounds(474, 95, 158, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDescripcinFsica);

		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setOpaque(false);
		btnGuardar.setFont(mf.MyFont(0, 15));
		btnGuardar.setBorder(null);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBounds(10, 644, 111, 32);
		frmHistoriasDeZagas.getContentPane().add(btnGuardar);
		
		JLabel lblDinero = new JLabel("Dinero:");
		lblDinero.setForeground(Color.WHITE);
		lblDinero.setFont(mf.MyFont(0, 14));
		lblDinero.setBounds(64, 440, 70, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDinero);

		textField_1 = new JTextField();
		textField_1.setText("" + EquipoNPC.dinero);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(118, 438, 58, 18);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		JLabel lblCampen = new JLabel("\u00BFCampe\u00F3n?");
		lblCampen.setForeground(Color.WHITE);
		lblCampen.setFont(mf.MyFont(0, 13));
		lblCampen.setBounds(324, 72, 64, 14);
		frmHistoriasDeZagas.getContentPane().add(lblCampen);
		
		textField = new JTextField();
		if(campeon==1){
		textField.setText("Si");}
		if(campeon==0){
			textField.setText("No");}
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(404, 70, 46, 18);
		frmHistoriasDeZagas.getContentPane().add(textField);
		
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
				PoderesNPC window=new PoderesNPC();
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
		frmHistoriasDeZagas.getContentPane().add(btnPoderes);
		
		final JButton btnExtras = new JButton("Extras");
		btnExtras.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
		btnExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExtrasNPC window=new ExtrasNPC();
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
		frmHistoriasDeZagas.getContentPane().add(btnExtras);
		
		final JButton btnModificadores = new JButton("Modificadores");
		btnModificadores.setIcon(new ImageIcon(DatosPersonaje.class.getResource("/images/botones resumen.png")));
		btnModificadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificadoresNPC window=new ModificadoresNPC();
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
		frmHistoriasDeZagas.getContentPane().add(btnModificadores);
		

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ResumenNPC.class
				.getResource("/images/background-resumen.jpg")));
		label.setBounds(0, 0, 642, 702);
		frmHistoriasDeZagas.getContentPane().add(label);
	}
}

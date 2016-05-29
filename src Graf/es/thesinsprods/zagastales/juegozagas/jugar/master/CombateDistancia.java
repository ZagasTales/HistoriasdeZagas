package es.thesinsprods.zagastales.juegozagas.jugar.master;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.diceroll.DiceRoll;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class CombateDistancia {

	private JFrame frmHistoriasDeZagas;
	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	private JTextField txtmodificador;
	private JTextField txtmodificador_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CombateDistancia window = new CombateDistancia();
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
	public CombateDistancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(CombateDistancia.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 450, 412);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Combate a Distancia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 424, 59);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Atacante");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 83, 212, 53);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);
		
	
		ArrayList<String> intermedio = new ArrayList<String>();
		intermedio.add("-Personaje-");
		for(int i=0; i<JugarOnline.jugadores.size();i++){
			intermedio.add(JugarOnline.jugadores.get(i));
			
		}
		for(int i=0; i<JugarOnline.npcs.size();i++){
			intermedio.add(JugarOnline.npcs.get(i));
			
		}
	
		
		Object [] personajes = intermedio.toArray();
		final JComboBox comboBox_1 = new JComboBox();
	
		final ArrayList <Weapons> armasList= new ArrayList<Weapons>();
		final ArrayList <String> armasN= new ArrayList<String>();
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				armasList.clear();
				armasN.clear();
				armasN.add("-Arma-");
				Characters personaje=Identificar(comboBox.getSelectedItem()+"");
					
					
					
				
					if(personaje.getWeapon1().getClass().getSimpleName().equals("Ranged")){
						
						armasList.add(personaje.getWeapon1());
						armasN.add(personaje.getWeapon1().getWeapon());
						
						
					}
					if(personaje.getWeapon2().getClass().getSimpleName().equals("Ranged")){
						
						armasList.add(personaje.getWeapon2());
						armasN.add(personaje.getWeapon2().getWeapon());
						
						
					}
					if(personaje.getWeapon3().getClass().getSimpleName().equals("Ranged")){
						
						armasList.add(personaje.getWeapon3());
						armasN.add(personaje.getWeapon3().getWeapon());
						
						
					}
					if(personaje.getWeapon4().getClass().getSimpleName().equals("Ranged")){
						
						armasList.add(personaje.getWeapon4());
						armasN.add(personaje.getWeapon4().getWeapon());
						
						
					}
					
					comboBox_1.setModel(new DefaultComboBoxModel(armasN.toArray()));
					
					
					
					
				
				
			
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(personajes));
		comboBox.setBounds(33, 140, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox);
		

		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		

		comboBox_1.setBounds(33, 190, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_1);
		
		JLabel lblDefensor = new JLabel("Defensor");
		lblDefensor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefensor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDefensor.setBounds(222, 83, 212, 53);
		frmHistoriasDeZagas.getContentPane().add(lblDefensor);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(personajes));
		comboBox_4.setBounds(245, 140, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_4);
		
		final JComboBox comboBox_5 = new JComboBox();
		final JComboBox comboBox_6 = new JComboBox();
		final ArrayList <Weapons> defensasList= new ArrayList<Weapons>();
		final ArrayList <String> defN= new ArrayList<String>();
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				defensasList.clear();
				defN.clear();
		
				Characters personaje=Identificar(comboBox.getSelectedItem()+"");
				
				if(comboBox_1.getSelectedItem().equals("Bloquear")){
					
					defN.add("-Arma-");
					
					
					if(personaje.getWeapon1().getClass().getSimpleName().equals("Shield")){
						
						defensasList.add(personaje.getWeapon1());
						defN.add(personaje.getWeapon1().getWeapon());
						
						
					}
					
					
					
					if(personaje.getWeapon2().getClass().getSimpleName().equals("Shield")){
						
						defensasList.add(personaje.getWeapon2());
						defN.add(personaje.getWeapon2().getWeapon());
						
						
					}
					
					
					
					if(personaje.getWeapon3().getClass().getSimpleName().equals("Shield")){
						
						defensasList.add(personaje.getWeapon3());
						defN.add(personaje.getWeapon3().getWeapon());
						
						
					}
				
					if(personaje.getWeapon4().getClass().getSimpleName().equals("Shield")){
					
						defensasList.add(personaje.getWeapon4());
						defN.add(personaje.getWeapon4().getWeapon());
						
						
					}
					
					
					
					comboBox_6.setModel(new DefaultComboBoxModel(armasN.toArray()));
					
					
					
					
				}
			}
		});
	
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"-Habilidad-", "Esquivar", "Bloquear"}));
		comboBox_5.setBounds(245, 190, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_5);
		
		
		comboBox_6.setBounds(245, 240, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_6);
		
		txtmodificador = new JTextField();
		txtmodificador.setText("-Modificador-");
		txtmodificador.setHorizontalAlignment(SwingConstants.CENTER);
		txtmodificador.setBounds(33, 240, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(txtmodificador);
		txtmodificador.setColumns(10);
		
		txtmodificador_1 = new JTextField();
		txtmodificador_1.setText("-Modificador-");
		txtmodificador_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtmodificador_1.setColumns(10);
		txtmodificador_1.setBounds(245, 290, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(txtmodificador_1);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int tirada1=DiceRoll.LanzaDadoAleatorio20();
				int tirada2=DiceRoll.LanzaDadoAleatorio20();
				
				Characters personaje1=Identificar(comboBox.getSelectedItem()+"");
				Characters personaje2=Identificar(comboBox_4.getSelectedItem()+"");
				
				String elemento1 = comboBox_1.getSelectedItem()+"";
				Weapons arma1 = new Weapons("", "", false, false, null, "");
				for(int i=0;i<armasList.size();i++){
					if(armasList.get(i).getWeapon().equals(elemento1)){arma1=armasList.get(i);}
				}
				String atributo1=arma1.atributo();
				int atr1 = 0;
				int atr2 = 0;
				int hab1 = 0;
				int hab2 = 0;
				if(atributo1.equals("Fuerza")){atr1=personaje1.getAtributes().getStrength();}
				else if(atributo1.equals("Destreza")){atr1=personaje1.getAtributes().getDexterity();}

				String elemento2 = comboBox_5.getSelectedItem()+"";
				Weapons arma2 = new Weapons("", "", false, false, null, "");;
			
				if(elemento2.equals("Bloquear")){
				for(int i=0;i<defensasList.size();i++){
					if(defensasList.get(i).getWeapon().equals(elemento2)){arma2=defensasList.get(i);}
				}
					if(arma2.getTipo().equals("Escudo Medio")){atr2=personaje2.getAtributes().getStrength()+1;
																hab2=personaje2.getCombatSkills().getBlock();}
					else if(arma2.getTipo().equals("Escudo de Torre")){atr2=personaje2.getAtributes().getStrength();
																		hab2=personaje2.getCombatSkills().getBlock()+1;}
					else{atr2=personaje2.getAtributes().getStrength();
							hab2=personaje2.getCombatSkills().getBlock();}
					
				}
				else if(elemento2.equals("Esquivar")){atr2=personaje2.getAtributes().getDexterity();
														hab2=personaje2.getCombatSkills().getDodge();}
				
				hab1=personaje1.getCombatSkills().getRanged();
			
				String mod1=txtmodificador.getText();
				String mod2=txtmodificador_1.getText();
				
				int mods= Integer.parseInt(mod1)+Integer.parseInt(mod2);
				
				String result = DiceRoll.EnfrentarTirada(tirada1, atr1, tirada2, atr2, hab1, hab2, mods);
				
				JugarOnline.writer.println("Server:La tirada de "+personaje1.getName()+"ha sido de "+tirada1+":Chat");
				JugarOnline.writer.flush();
				
				JugarOnline.writer.println("Server:La tirada de "+personaje2.getName()+"ha sido de "+tirada2+":Chat");
				JugarOnline.writer.flush();
				
				JugarOnline.writer.println("Server:El resultado del enfrentamiento es "+result+":Chat");
				JugarOnline.writer.flush();
				
				int lugarImpacto = DiceRoll.LanzaDadoAleatorio6();
								
				if(result.equals("Correcto")){
					
					if(lugarImpacto==1){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la cabeza. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==2){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el pecho. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==3){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo derecho. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==4){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo izquierdo. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==5){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna derecha. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==6){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna izquierda. :Chat");
					JugarOnline.writer.flush();}
											
						int resistencia=DiceRoll.ComprobarTirada(DiceRoll.LanzaDadoAleatorio20(), personaje2.getAtributes().getResistance());
						int resultado= 0-resistencia;
						
						if(arma1.getTipo().equals("Arma Arrojadiza") && resistencia==-3){personaje2.setEstado("Desangrandose");
						JugarOnline.writer.println("Server: "+personaje2.getName()+"se está desangrando. :Chat");
						JugarOnline.writer.flush();}
						
						JugarOnline.writer.println("Información: El resultado de la tirada de Resistencia ha sido "+resistencia+" :Chat");
						JugarOnline.writer.flush();	
						
							if(resultado>=3){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 5",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==2){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 4",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==1){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 3",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==0){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 2",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==-1){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 2",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==-2){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 1",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado<=-3){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 1",
										"", JOptionPane.PLAIN_MESSAGE);}
					}
				else if(result.equals("Bien")){
					
					if(lugarImpacto==1){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la cabeza. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==2){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el pecho. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==3){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo derecho. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==4){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo izquierdo. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==5){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna derecha. :Chat");
					JugarOnline.writer.flush();}
					else if(lugarImpacto==6){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna izquierda. :Chat");
					JugarOnline.writer.flush();}
						
						int resistencia=DiceRoll.ComprobarTirada(DiceRoll.LanzaDadoAleatorio20(), personaje2.getAtributes().getResistance());
						int resultado= 1-resistencia;
						
						if(arma1.getTipo().equals("Arma Arrojadiza") && resistencia==-3){personaje2.setEstado("Desangrandose");
						JugarOnline.writer.println("Server: "+personaje2.getName()+"se está desangrando. :Chat");
						JugarOnline.writer.flush();}
						
						
						JugarOnline.writer.println("Información: El resultado de la tirada de Resistencia ha sido "+resistencia+" :Chat");
						JugarOnline.writer.flush();	
						
							if(resultado>=3){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 5",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==2){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 4",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==1){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 3",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==0){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 2",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==-1){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 2",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado==-2){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 1",
										"", JOptionPane.PLAIN_MESSAGE);}
							else if(resultado<=-3){JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"La cantidad de vida recomendada a quitar es 1",
										"", JOptionPane.PLAIN_MESSAGE);}
					}
					else if(result.equals("Excelente")){					
					
						if(lugarImpacto==1){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la cabeza. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==2){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el pecho. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==3){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo derecho. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==4){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo izquierdo. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==5){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna derecha. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==6){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna izquierda. :Chat");
						JugarOnline.writer.flush();}
						
					int resistencia=DiceRoll.ComprobarTirada(DiceRoll.LanzaDadoAleatorio20(), personaje2.getAtributes().getResistance());
					int resultado= 2-resistencia;
					
					if(arma1.getTipo().equals("Arma Arrojadiza") && resistencia==-3){personaje2.setEstado("Desangrandose");
					JugarOnline.writer.println("Server: "+personaje2.getName()+"se está desangrando. :Chat");
					JugarOnline.writer.flush();}
					
					JugarOnline.writer.println("Información: El resultado de la tirada de Resistencia ha sido "+resistencia+" :Chat");
					JugarOnline.writer.flush();	
					
						if(resultado>=3){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 5",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado==2){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 4",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado==1){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 3",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado==0){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 2",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado==-1){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 2",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado==-2){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 1",
									"", JOptionPane.PLAIN_MESSAGE);}
						else if(resultado<=-3){JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"La cantidad de vida recomendada a quitar es 1",
									"", JOptionPane.PLAIN_MESSAGE);}
				}
					else if(result.equals("Crítico")){
						
						if(lugarImpacto==1){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la cabeza. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==2){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el pecho. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==3){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo derecho. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==4){				JugarOnline.writer.println("Server:El lugar del impacto ha sido el brazo izquierdo. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==5){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna derecha. :Chat");
						JugarOnline.writer.flush();}
						else if(lugarImpacto==6){				JugarOnline.writer.println("Server:El lugar del impacto ha sido la pierna izquierda. :Chat");
						JugarOnline.writer.flush();}
							
							int resistencia=DiceRoll.ComprobarTirada(DiceRoll.LanzaDadoAleatorio20(), personaje1.getAtributes().getResistance());
							int resultado= 3-resistencia;
							
							if(arma1.getTipo().equals("Arma Arrojadiza") && resistencia==-3){personaje2.setEstado("Desangrandose");
							JugarOnline.writer.println("Server: "+personaje2.getName()+"se está desangrando. :Chat");
							JugarOnline.writer.flush();}
							
							JugarOnline.writer.println("Información: El resultado de la tirada de Resistencia ha sido "+resistencia+" :Chat");
							JugarOnline.writer.flush();	
							
								if(resultado>=3){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 5",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado==2){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 4",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado==1){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 3",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado==0){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 2",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado==-1){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 2",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado==-2){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 1",
											"", JOptionPane.PLAIN_MESSAGE);}
								else if(resultado<=-3){JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"La cantidad de vida recomendada a quitar es 1",
											"", JOptionPane.PLAIN_MESSAGE);}
						}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(313, 327, 121, 45);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
			}
		});
		button.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

						null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 327, 99, 45);
		frmHistoriasDeZagas.getContentPane().add(button);
	}
	
	public Characters Identificar(String nombre){
		
		Characters personaje=new Characters(nombre, null, "", 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, "", "", "");
		
		if(nombre.equals(JugarOnline.personaje1.getName())){
			personaje= JugarOnline.personaje1;
		}
		else if(nombre.equals(JugarOnline.personaje2.getName())){
				personaje= JugarOnline.personaje2;
			}

		else if(nombre.equals(JugarOnline.personaje3.getName())){
			personaje= JugarOnline.personaje3;
		}
		
		else if(nombre.equals(JugarOnline.personaje4.getName())){
			personaje= JugarOnline.personaje4;
		}
		else if(nombre.equals(JugarOnline.personaje5.getName())){
			personaje= JugarOnline.personaje5;
		}
		else if(nombre.equals(JugarOnline.personaje6.getName())){
			personaje= JugarOnline.personaje6;
		}
		else if(nombre.equals(JugarOnline.personaje7.getName())){
			personaje= JugarOnline.personaje7;
		}
		else if(nombre.equals(JugarOnline.personaje8.getName())){
			personaje= JugarOnline.personaje8;
		}
		else if(nombre.equals(JugarOnline.personaje9.getName())){
			personaje= JugarOnline.personaje9;
		}
		else if(nombre.equals(JugarOnline.npc1.getName())){
			personaje= JugarOnline.npc1;
		}
		else if(nombre.equals(JugarOnline.npc2.getName())){
			personaje= JugarOnline.npc2;
		}
		else if(nombre.equals(JugarOnline.npc3.getName())){
			personaje= JugarOnline.npc3;
		}
		else if(nombre.equals(JugarOnline.npc5.getName())){
			personaje= JugarOnline.npc4;
		}
		else if(nombre.equals(JugarOnline.npc6.getName())){
			personaje= JugarOnline.npc5;
		}
		else if(nombre.equals(JugarOnline.npc7.getName())){
			personaje= JugarOnline.npc7;
		}
		else if(nombre.equals(JugarOnline.npc8.getName())){
			personaje= JugarOnline.npc8;
		}
		else if(nombre.equals(JugarOnline.npc9.getName())){
			personaje= JugarOnline.npc9;
		}
		
		return personaje;
		
	}
}

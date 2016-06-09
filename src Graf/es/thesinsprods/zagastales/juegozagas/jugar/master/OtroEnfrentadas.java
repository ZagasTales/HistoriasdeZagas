package es.thesinsprods.zagastales.juegozagas.jugar.master;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import es.thesinsprods.resources.font.MorpheusFont;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OtroEnfrentadas {

	private JFrame frmHistoriasDeZagas;
	MorpheusFont mf = new MorpheusFont();
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
					OtroEnfrentadas window = new OtroEnfrentadas();
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
	public OtroEnfrentadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(OtroEnfrentadas.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 450, 422);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(mf.MyFont(0,13));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"-3", "-2", "-1", "0", "1", "2", "3"}));
		comboBox_3.setSelectedIndex(3);
		comboBox_3.setBounds(33, 292, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_3);
		
		final JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(mf.MyFont(0,13));
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"-3", "-2", "-1", "0", "1", "2", "3"}));
		comboBox_7.setSelectedIndex(3);
		comboBox_7.setBounds(245, 292, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_7);
		
		JLabel lblNewLabel = new JLabel("Tirada Enfrentada");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(mf.MyFont(0, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 424, 59);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Atacante");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(mf.MyFont(0, 18));
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
	
		final ArrayList <String> atributos= new ArrayList<String>();
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(mf.MyFont(0,13));
		comboBox.setModel(new DefaultComboBoxModel(personajes));
		comboBox.setBounds(33, 140, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(mf.MyFont(0,13));
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(mf.MyFont(0,13));
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atributos.clear();
				String skill=""+comboBox_1.getSelectedItem();
				if(skill.equals("Arte de la Guerra")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Diplomacia")){
					atributos.add("-Atributos-");
					atributos.add("Carisma");
				
					
				}
				if(skill.equals("Etiqueta")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Carisma");
					
				}
				if(skill.equals("Medicina")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Ocultismo")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Investigación")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Percepción");
				}
				if(skill.equals("Negociación")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Carisma");
					
				}
				if(skill.equals("Conocimientos Secretos")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Atletismo")){
					atributos.add("-Atributos-");
					atributos.add("Resistencia");
					atributos.add("Fuerza");
					atributos.add("Destreza");
					
				}
				if(skill.equals("Supervivencia")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Trampas")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Equitación")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					
					
				}
				if(skill.equals("Sigilo")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					
					
				}
				comboBox_2.setModel(new DefaultComboBoxModel(atributos.toArray()));
				
			}
		});
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Habilidad-", "Arte de la Guerra", "Diplomacia", "Etiqueta", "Medicina", "Ocultismo", "Investigaci\u00F3n", "Negociaci\u00F3n", "Conocimientos Secretos", "Atletismo", "Supervivencia", "Trampas", "Equitaci\u00F3n", "Sigilo"}));
		comboBox_1.setBounds(33, 190, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_1);
		
		
		comboBox_2.setBounds(33, 240, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_2);
		
		JLabel lblDefensor = new JLabel("Defensor");
		lblDefensor.setForeground(Color.WHITE);
		lblDefensor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefensor.setFont(mf.MyFont(0, 18));
		lblDefensor.setBounds(222, 83, 212, 53);
		frmHistoriasDeZagas.getContentPane().add(lblDefensor);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(mf.MyFont(0,13));
		comboBox_4.setModel(new DefaultComboBoxModel(personajes));
		comboBox_4.setBounds(245, 140, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_4);
		
		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(mf.MyFont(0,13));
		final JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(mf.MyFont(0,13));
		final ArrayList <Weapons> defensasList= new ArrayList<Weapons>();
		final ArrayList <String> defN= new ArrayList<String>();
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atributos.clear();
				String skill=""+comboBox_5.getSelectedItem();
				if(skill.equals("Arte de la Guerra")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Diplomacia")){
					atributos.add("-Atributos-");
					atributos.add("Carisma");
				
					
				}
				if(skill.equals("Etiqueta")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Carisma");
					
				}
				if(skill.equals("Medicina")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Ocultismo")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Investigación")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Percepción");
				}
				if(skill.equals("Negociación")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					atributos.add("Carisma");
					
				}
				if(skill.equals("Conocimientos Secretos")){
					atributos.add("-Atributos-");
					atributos.add("Inteligencia");
					
				}
				if(skill.equals("Atletismo")){
					atributos.add("-Atributos-");
					atributos.add("Resistencia");
					atributos.add("Fuerza");
					atributos.add("Destreza");
					
				}
				if(skill.equals("Supervivencia")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Trampas")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					atributos.add("Percepción");
					
				}
				if(skill.equals("Equitación")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					
					
				}
				if(skill.equals("Sigilo")){
					atributos.add("-Atributos-");
					atributos.add("Destreza");
					
					
				}
				comboBox_6.setModel(new DefaultComboBoxModel(atributos.toArray()));
				
			
				
			}
		});
	
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"-Habilidad-", "Arte de la Guerra", "Diplomacia", "Etiqueta", "Medicina", "Ocultismo", "Investigaci\u00F3n", "Negociaci\u00F3n", "Conocimientos Secretos", "Atletismo", "Supervivencia", "Trampas", "Equitaci\u00F3n", "Sigilo"}));
		comboBox_5.setBounds(245, 190, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_5);
		
		
		comboBox_6.setBounds(245, 240, 165, 29);
		frmHistoriasDeZagas.getContentPane().add(comboBox_6);
		
		final JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/botones armaduras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/botones armaduras.png")));
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/botones armaduras.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int tirada1=DiceRoll.LanzaDadoAleatorio20();
				int tirada2=DiceRoll.LanzaDadoAleatorio20();
				
				Characters personaje1=Identificar(comboBox.getSelectedItem()+"");
				Characters personaje2=Identificar(comboBox_4.getSelectedItem()+"");

				String atributo1=comboBox_2.getSelectedItem()+"";
				String atributo2=comboBox_6.getSelectedItem()+"";
				
				String habilidad1=comboBox_1.getSelectedItem()+"";
				String habilidad2=comboBox_5.getSelectedItem()+"";

				int atr1 = 0;
				int atr2 = 0;
				int hab1 = 0;
				int hab2 = 0;
			
				if(atributo1.equals("Fuerza")){atr1=personaje1.getAtributes().getStrength();}
				else if(atributo1.equals("Destreza")){atr1=personaje1.getAtributes().getDexterity();}
				else if(atributo1.equals("Carisma")){atr1=personaje1.getAtributes().getCharisma();}
				else if(atributo1.equals("Resistencia")){atr1=personaje1.getAtributes().getResistance();}
				else if(atributo1.equals("Percepción")){atr1=personaje1.getAtributes().getPerception();}
				else if(atributo1.equals("Inteligencia")){atr1=personaje1.getAtributes().getIntelligence();}
				else if(atributo1.equals("Resistencia Mágica")){atr1=personaje1.getAtributes().getMagicres();}
				
				if(atributo2.equals("Fuerza")){atr2=personaje2.getAtributes().getStrength();}
				else if(atributo2.equals("Destreza")){atr2=personaje2.getAtributes().getDexterity();}
				else if(atributo2.equals("Carisma")){atr2=personaje2.getAtributes().getCharisma();}
				else if(atributo2.equals("Resistencia")){atr2=personaje2.getAtributes().getResistance();}
				else if(atributo2.equals("Percepción")){atr2=personaje2.getAtributes().getPerception();}
				else if(atributo2.equals("Inteligencia")){atr2=personaje2.getAtributes().getIntelligence();}
				else if(atributo2.equals("Resistencia Mágica")){atr2=personaje2.getAtributes().getMagicres();}
				
				if(habilidad1.equals("Arte de la Guerra")){hab1=personaje1.getKnowledgeSkills().getArtofWar();}
				else if(habilidad1.equals("Diplomacia")){hab1=personaje1.getKnowledgeSkills().getDiplomacy();}
				else if(habilidad1.equals("Etiqueta")){hab1=personaje1.getKnowledgeSkills().getEtiquette();}
				else if(habilidad1.equals("Medicina")){hab1=personaje1.getKnowledgeSkills().getMedicine();}
				else if(habilidad1.equals("Negociación")){hab1=personaje1.getKnowledgeSkills().getNegotiation();}
				else if(habilidad1.equals("Ocultismo")){hab1=personaje1.getKnowledgeSkills().getOccultism();}
				else if(habilidad1.equals("Profesión")){hab1=personaje1.getKnowledgeSkills().getProfession();}
				else if(habilidad1.equals("Investigación")){hab1=personaje1.getKnowledgeSkills().getResearch();}
				else if(habilidad1.equals("Conocimientos Secretos")){hab1=personaje1.getKnowledgeSkills().getSecretKnowledge();}
				else if(habilidad1.equals("Atletismo")){hab1=personaje1.getKnowhowSkills().getAthletics();}
				else if(habilidad1.equals("Equitación")){hab1=personaje1.getKnowhowSkills().getEquitation();}
				else if(habilidad1.equals("Sigilo")){hab1=personaje1.getKnowhowSkills().getStealth();}
				else if(habilidad1.equals("Supervivencia")){hab1=personaje1.getKnowhowSkills().getSurvival();}
				else if(habilidad1.equals("Trampas")){hab1=personaje1.getKnowhowSkills().getTraps();}
				
				if(habilidad2.equals("Arte de la Guerra")){hab2=personaje2.getKnowledgeSkills().getArtofWar();}
				else if(habilidad2.equals("Diplomacia")){hab2=personaje2.getKnowledgeSkills().getDiplomacy();}
				else if(habilidad2.equals("Etiqueta")){hab2=personaje2.getKnowledgeSkills().getEtiquette();}
				else if(habilidad2.equals("Medicina")){hab2=personaje2.getKnowledgeSkills().getMedicine();}
				else if(habilidad2.equals("Negociación")){hab2=personaje2.getKnowledgeSkills().getNegotiation();}
				else if(habilidad2.equals("Ocultismo")){hab2=personaje2.getKnowledgeSkills().getOccultism();}
				else if(habilidad2.equals("Profesión")){hab2=personaje2.getKnowledgeSkills().getProfession();}
				else if(habilidad2.equals("Investigación")){hab2=personaje2.getKnowledgeSkills().getResearch();}
				else if(habilidad2.equals("Conocimientos Secretos")){hab2=personaje2.getKnowledgeSkills().getSecretKnowledge();}
				else if(habilidad2.equals("Atletismo")){hab2=personaje2.getKnowhowSkills().getAthletics();}
				else if(habilidad2.equals("Equitación")){hab2=personaje2.getKnowhowSkills().getEquitation();}
				else if(habilidad2.equals("Sigilo")){hab2=personaje2.getKnowhowSkills().getStealth();}
				else if(habilidad2.equals("Supervivencia")){hab2=personaje2.getKnowhowSkills().getSurvival();}
				else if(habilidad2.equals("Trampas")){hab2=personaje2.getKnowhowSkills().getTraps();}
				
				String mod1=comboBox_3.getSelectedItem()+"";
				String mod2=comboBox_7.getSelectedItem()+"";
				
				int mods= Integer.parseInt(mod1)-Integer.parseInt(mod2);
				
				
				String result = DiceRoll.EnfrentarTirada(tirada1, atr1, tirada2, atr2, hab1, hab2, mods);
				
				JugarOnline.writer.println("Server:La tirada de "+personaje1.getName()+" ha sido de "+tirada1+":Chat");
				JugarOnline.writer.flush();
				
				JugarOnline.writer.println("Server:La tirada de "+personaje2.getName()+" ha sido de "+tirada2+":Chat");
				JugarOnline.writer.flush();
				
				JugarOnline.writer.println("Server:El resultado del enfrentamiento es "+result+":Chat");
				JugarOnline.writer.flush();
							
			}
		});
		btnNewButton.setFont(mf.MyFont(0, 16));
		btnNewButton.setBounds(313, 327, 124, 47);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		
		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(CombateDistancia.class.getResource("/images/boton atras.png")));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHistoriasDeZagas.dispose();
				
			}
		});
		button.setIcon(new ImageIcon(OtroEnfrentadas.class.getResource("/images/boton atras.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

						null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 335, 99, 45);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OtroEnfrentadas.class.getResource("/images/background-jugar.jpg")));
		label.setBounds(0, 0, 444, 393);
		frmHistoriasDeZagas.getContentPane().add(label);
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

package es.thesinsprods.juegozagas.gestorpartidas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.diceroll.DiceRoll;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class TiradaDeCombate {

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	private JFrame frmHistoriasDeZagas;
	private JTextField txtTirada1;
	private JTextField txtTirada2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	MorpheusFont mf=new MorpheusFont();
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiradaDeCombate window = new TiradaDeCombate();
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
	public TiradaDeCombate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(TiradaDeCombate.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 558, 530);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblTirada = new JLabel("Tirada:");
		lblTirada.setFont(mf.MyFont(0, 13));
		lblTirada.setForeground(Color.WHITE);
		lblTirada.setBounds(10, 169, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblTirada);
		
		JLabel lblTirada_1 = new JLabel("Tirada:");
		lblTirada_1.setFont(mf.MyFont(0, 13));
		lblTirada_1.setForeground(Color.WHITE);
		lblTirada_1.setBounds(296, 169, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblTirada_1);
		
		txtTirada1 = new JTextField();
		txtTirada1.setFont(mf.MyFont(0, 13));
		txtTirada1.setBounds(83, 172, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(txtTirada1);
		txtTirada1.setColumns(10);
		
		txtTirada2 = new JTextField();
		txtTirada2.setFont(mf.MyFont(0, 13));
		txtTirada2.setBounds(377, 173, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(txtTirada2);
		txtTirada2.setColumns(10);
		
		final JCheckBox chckbxAleatorio = new JCheckBox("Aleatorio");
		chckbxAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAleatorio.isSelected()){
					txtTirada1.setEnabled(false);
					txtTirada1.setText("");
				}
				else{
					txtTirada1.setEnabled(true);
					
				}
			}
		});
		chckbxAleatorio.setFont(mf.MyFont(0, 13));
		chckbxAleatorio.setContentAreaFilled(false);
		chckbxAleatorio.setForeground(Color.WHITE);
		chckbxAleatorio.setBounds(175, 172, 97, 23);
		frmHistoriasDeZagas.getContentPane().add(chckbxAleatorio);
		
		final JCheckBox checkBox = new JCheckBox("Aleatorio");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()){
					txtTirada2.setEnabled(false);
					txtTirada2.setText("");
				}
				else{
					txtTirada2.setEnabled(true);
					
				}
				
			}
		});
		checkBox.setContentAreaFilled(false);
		checkBox.setFont(mf.MyFont(0, 13));
		checkBox.setForeground(Color.WHITE);
		checkBox.setBounds(470, 172, 90, 23);
		frmHistoriasDeZagas.getContentPane().add(checkBox);
		
		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setFont(mf.MyFont(0, 13));
		lblHabilidad.setForeground(Color.WHITE);
		lblHabilidad.setBounds(10, 241, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblHabilidad);
		
		textField = new JTextField();
		textField.setFont(mf.MyFont(0, 13));
		textField.setColumns(10);
		textField.setBounds(83, 244, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField);
		
		JLabel lblHabilidad_1 = new JLabel("Habilidad:");
		lblHabilidad_1.setFont(mf.MyFont(0, 13));
		lblHabilidad_1.setForeground(Color.WHITE);
		lblHabilidad_1.setBounds(296, 241, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblHabilidad_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(mf.MyFont(0, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(377, 246, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		JLabel lblAtributo = new JLabel("Atributo:");
		lblAtributo.setFont(mf.MyFont(0, 13));
		lblAtributo.setForeground(Color.WHITE);
		lblAtributo.setBounds(10, 205, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblAtributo);
		
		textField_2 = new JTextField();
		textField_2.setFont(mf.MyFont(0, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(83, 210, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		JLabel lblAtributo_1 = new JLabel("Atributo:");
		lblAtributo_1.setFont(mf.MyFont(0, 13));
		lblAtributo_1.setForeground(Color.WHITE);
		lblAtributo_1.setBounds(296, 205, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblAtributo_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(mf.MyFont(0, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(377, 210, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		
		JLabel lblJugador = new JLabel("Jugador 1");
		lblJugador.setFont(mf.MyFont(0, 20));
		lblJugador.setForeground(Color.WHITE);
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setBounds(10, 103, 245, 55);
		frmHistoriasDeZagas.getContentPane().add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador 2");
		lblJugador_1.setFont(mf.MyFont(0, 20));;
		lblJugador_1.setForeground(Color.WHITE);
		lblJugador_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador_1.setBounds(296, 103, 245, 55);
		frmHistoriasDeZagas.getContentPane().add(lblJugador_1);
		
		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/boton atras2.png")));
			}
			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/boton atras.png")));
			}
		});
		btnVolver.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/boton atras.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHistoriasDeZagas.dispose();
				GestorMain window=new GestorMain();
				window.getFrmHistoriasDeZagas().setVisible(true);
			}
		});
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBounds(10, 450, 95, 40);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);
		textField_6 = new JTextField();
		
		final JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tirada1;
				int tirada2;
				int atributo1=Integer.parseInt(textField_2.getText());
				int atributo2=Integer.parseInt(textField_3.getText());
				int habilidad1=Integer.parseInt(textField.getText());
				int habilidad2=Integer.parseInt(textField_1.getText());
				int modificador1=0;
				int modificador2=0;
				int total;
			
				
				if(txtTirada1.getText().equals("")){
					tirada1=0;
				}
				else{
					tirada1=Integer.parseInt(txtTirada1.getText());
					}
				
				
				if(txtTirada2.getText().equals("")){
					tirada2=0;
				}
				else{
					
					tirada2=Integer.parseInt(txtTirada2.getText());
				
				}
				if(textField_4.getText().equals("")){
					modificador1=0;
				}
				else{
					
					modificador1=Integer.parseInt(textField_4.getText());
				
				}
				
				if(textField_5.getText().equals("")){
					modificador2=0;
				}
				else{
					modificador2=Integer.parseInt(textField_5.getText());
					
				}
				
				if(chckbxAleatorio.isSelected()){
					tirada1=DiceRoll.LanzaDadoAleatorio20();
					
				}
				if(checkBox.isSelected()){
					
					tirada2=DiceRoll.LanzaDadoAleatorio20();
					
				}
				total=modificador1-modificador2;
				
				textField_6.setText(""+DiceRoll.EnfrentarTirada(tirada1, atributo1, tirada2, atributo2, habilidad1, habilidad2,total));
				
			}
		});
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCalcular.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCalcular.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda.png")));
				
			}
		});
		btnCalcular.setFont(mf.MyFont(0, 15));
		btnCalcular.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCalcular.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda.png")));
		btnCalcular.setBorderPainted(false);
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setFocusPainted(false);
		btnCalcular.setOpaque(false);
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBounds(430, 459, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnCalcular);
		
		final JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda.png")));
				
			}
		});
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAyuda.setFont(mf.MyFont(0, 15));
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setBorderPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setFocusPainted(false);
		btnAyuda.setOpaque(false);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setBounds(222, 459, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);
		
		final JButton btnHabilidadesYSus = new JButton("Habilidades y sus Atributos");
		btnHabilidadesYSus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnHabilidadesYSus.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor2.png")));
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnHabilidadesYSus.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
				
			}
		});
		btnHabilidadesYSus.setFont(mf.MyFont(0, 15));
		btnHabilidadesYSus.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
		btnHabilidadesYSus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabilidadesYSus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnHabilidadesYSus.setBorderPainted(false);
		btnHabilidadesYSus.setContentAreaFilled(false);
		btnHabilidadesYSus.setFocusPainted(false);
		btnHabilidadesYSus.setOpaque(false);
		btnHabilidadesYSus.setForeground(Color.WHITE);
		btnHabilidadesYSus .setBounds(10, 329, 257, 37);
		frmHistoriasDeZagas.getContentPane().add(btnHabilidadesYSus);
		
		final JButton btnArmera = new JButton("Armer\u00EDa");
		btnArmera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArmera.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnArmera.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor2.png")));
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnArmera.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
				
			}
		});
		btnArmera.setFont(mf.MyFont(0, 15));
		btnArmera.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
		btnArmera.setHorizontalTextPosition(SwingConstants.CENTER);
		btnArmera.setBorderPainted(false);
		btnArmera.setContentAreaFilled(false);
		btnArmera.setFocusPainted(false);
		btnArmera.setOpaque(false);
		btnArmera.setForeground(Color.WHITE);
		btnArmera.setBounds(284, 329, 257, 37);
		frmHistoriasDeZagas.getContentPane().add(btnArmera);
		
		final JButton btnConocimientosMgicos = new JButton("Conocimientos M\u00E1gicos");
		btnConocimientosMgicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConocimientosMgicos.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor2.png")));
				
			}
			public void mouseReleased(MouseEvent arg0) {
				btnConocimientosMgicos.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
				
			}
		});
		btnConocimientosMgicos.setFont(mf.MyFont(0, 15));
		btnConocimientosMgicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConocimientosMgicos.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
		btnConocimientosMgicos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConocimientosMgicos.setBorderPainted(false);
		btnConocimientosMgicos.setContentAreaFilled(false);
		btnConocimientosMgicos.setFocusPainted(false);
		btnHabilidadesYSus.setOpaque(false);
		btnConocimientosMgicos.setForeground(Color.WHITE);
		btnConocimientosMgicos.setBounds(10, 377, 257, 37);
		frmHistoriasDeZagas.getContentPane().add(btnConocimientosMgicos);
		
		JLabel lblCalcularTiradaDe = new JLabel("Calcular Tirada de Combate");
		lblCalcularTiradaDe.setFont(mf.MyFont(0, 30));
		lblCalcularTiradaDe.setForeground(Color.WHITE);
		lblCalcularTiradaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcularTiradaDe.setBounds(83, 11, 389, 81);
		frmHistoriasDeZagas.getContentPane().add(lblCalcularTiradaDe);
		
		JLabel lblModificador = new JLabel("Modificador:");
		lblModificador.setFont(mf.MyFont(0, 13));
		lblModificador.setForeground(Color.WHITE);
		lblModificador.setBounds(10, 277, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblModificador);
		
		textField_4 = new JTextField();
		textField_4.setFont(mf.MyFont(0, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(83, 280, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
		JLabel lblModificador_1 = new JLabel("Modificador:");
		lblModificador_1.setFont(mf.MyFont(0, 13));
		lblModificador_1.setForeground(Color.WHITE);
		lblModificador_1.setBounds(296, 277, 71, 25);
		frmHistoriasDeZagas.getContentPane().add(lblModificador_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(mf.MyFont(0, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(377, 282, 86, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_5);
		
		final JButton btnResultadosTirada = new JButton("Resultados Enfrentamiento");
		btnResultadosTirada.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnResultadosTirada.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor2.png")));
			}
			public void mouseReleased(MouseEvent e) {
				btnResultadosTirada.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
			}
		});
		btnResultadosTirada.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/botones-ayuda-gestor.png")));
		btnResultadosTirada.setHorizontalTextPosition(SwingConstants.CENTER);
		btnResultadosTirada.setForeground(Color.WHITE);
		btnResultadosTirada.setFont(mf.MyFont(0, 13));
		btnResultadosTirada.setFocusPainted(false);
		btnResultadosTirada.setContentAreaFilled(false);
		btnResultadosTirada.setBorderPainted(false);
		btnResultadosTirada.setBounds(284, 377, 257, 37);
		frmHistoriasDeZagas.getContentPane().add(btnResultadosTirada);
		
	
		textField_6.setEditable(false);
		textField_6.setBounds(284, 428, 257, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(mf.MyFont(0, 19));
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBounds(10, 425, 257, 25);
		frmHistoriasDeZagas.getContentPane().add(lblResultado);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TiradaDeCombate.class.getResource("/images/background-resumen.jpg")));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(0, 0, 552, 501);
		frmHistoriasDeZagas.getContentPane().add(label);
	}
}

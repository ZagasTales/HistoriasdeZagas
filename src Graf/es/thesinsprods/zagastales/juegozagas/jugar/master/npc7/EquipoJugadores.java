package es.thesinsprods.zagastales.juegozagas.jugar.master.npc7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipoJugadores {

	private JFrame frmHistoriasDeZagas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	MorpheusFont mf = new MorpheusFont();
	
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoJugadores window = new EquipoJugadores();
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
	public EquipoJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 600, 557);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(mf.MyFont(0, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 574, 50);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		JLabel lblArmadura = new JLabel("Armadura");
		lblArmadura.setForeground(Color.WHITE);
		lblArmadura.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmadura.setFont(mf.MyFont(0,18));
		lblArmadura.setBounds(3, 72, 287, 50);
		frmHistoriasDeZagas.getContentPane().add(lblArmadura);
		
		JLabel lblArmas = new JLabel("Armas");
		lblArmas.setForeground(Color.WHITE);
		lblArmas.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmas.setFont(mf.MyFont(0,18));
		lblArmas.setBounds(290, 72, 287, 50);
		frmHistoriasDeZagas.getContentPane().add(lblArmas);
		final JButton button = new JButton("Info");
		button.setEnabled(false);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getArmor().getArmor().equals("")){
			if(!JugarOnline.npc7.getArmor().getArmor().equals("null")){
		textField.setText(JugarOnline.npc7.getArmor().getArmor());
		button.setEnabled(true);}}
		textField.setBounds(23, 133, 247, 23);
		frmHistoriasDeZagas.getContentPane().add(textField);
		textField.setColumns(10);
		

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/botones armaduras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/botones armaduras.png")));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArmaduraJugadores window = new ArmaduraJugadores();
				window.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/botones armaduras.png")));
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(mf.MyFont(0,16));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
						null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(88, 167, 124, 47);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		final JButton button_1 = new JButton("Info");
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0,13));
		button_1.setEnabled(false);
		if(!JugarOnline.npc7.getWeapon1().getWeapon().equals("")){
			if(!JugarOnline.npc7.getWeapon1().getWeapon().equals("null")){
		textField_1.setText(JugarOnline.npc7.getWeapon1().getWeapon());
		button_1.setEnabled(true);}}
		textField_1.setColumns(10);
		textField_1.setBounds(329, 133, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfoWeap1Jugadores window= new InfoWeap1Jugadores();
				window.getFrame().setVisible(true);
				
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_1.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_1.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(mf.MyFont(0,16));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
						null, null));
		button_1.setBackground(new Color(139, 69, 19));
		button_1.setBounds(516, 133, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_1);
		
		final JButton button_2 = new JButton("Info");
		button_2.setEnabled(false);
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getWeapon2().getWeapon().equals("")){
			if(!JugarOnline.npc7.getWeapon2().getWeapon().equals("null")){
		textField_2.setText(JugarOnline.npc7.getWeapon2().getWeapon());
		button_2.setEnabled(true);}}
		textField_2.setColumns(10);
		textField_2.setBounds(329, 167, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_2);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				InfoWeap2Jugadores window= new InfoWeap2Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_2.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_2.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_2.setOpaque(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(mf.MyFont(0,16));
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button_2.setBackground(new Color(139, 69, 19));
		button_2.setBounds(516, 167, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_2);
		
		final JButton button_3 = new JButton("Info");
		button_3.setEnabled(false);
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getWeapon3().getWeapon().equals("") ){
			if(!JugarOnline.npc7.getWeapon3().getWeapon().equals("null")){
		textField_3.setText(JugarOnline.npc7.getWeapon3().getWeapon());
		button_3.setEnabled(true);}}
		textField_3.setColumns(10);
		textField_3.setBounds(329, 201, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_3);
		

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfoWeap3Jugadores window= new InfoWeap3Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_3.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_3.setOpaque(false);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(mf.MyFont(0,16));
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button_3.setBackground(new Color(139, 69, 19));
		button_3.setBounds(516, 201, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_3);
		
		final JButton button_4 = new JButton("Info");
		button_4.setEnabled(false);
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getWeapon4().getWeapon().equals("")){
			if(!JugarOnline.npc7.getWeapon4().getWeapon().equals("null")){
		textField_4.setText(JugarOnline.npc7.getWeapon4().getWeapon());
		button_4.setEnabled(true);}}
		textField_4.setColumns(10);
		textField_4.setBounds(329, 235, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_4);
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfoWeap4Jugadores window= new InfoWeap4Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_4.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_4.setOpaque(false);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(mf.MyFont(0,16));
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button_4.setBackground(new Color(139, 69, 19));
		button_4.setBounds(516, 235, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_4);
		
		JLabel lblAccesorios = new JLabel("Accesorios");
		lblAccesorios.setForeground(Color.WHITE);
		lblAccesorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesorios.setFont(mf.MyFont(0,18));
		lblAccesorios.setBounds(290, 269, 287, 50);
		frmHistoriasDeZagas.getContentPane().add(lblAccesorios);
		
		final JButton button_5 = new JButton("Info");
		button_5.setEnabled(false);
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getAcc1().getAccesory().equals("")){
			if(!JugarOnline.npc7.getAcc1().getAccesory().equals("null")){
		textField_5.setText(JugarOnline.npc7.getAcc1().getAccesory());
		button_5.setEnabled(true);}}
		textField_5.setColumns(10);
		textField_5.setBounds(329, 330, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_5);
		
	
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc1Jugadores window = new InfoAcc1Jugadores();
				window.getFrame().setVisible(true);
				
			}
		});
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_5.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_5.setOpaque(false);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(mf.MyFont(0,16));
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button_5.setBackground(new Color(139, 69, 19));
		button_5.setBounds(516, 330, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_5);
		
		final JButton button_6 = new JButton("Info");
		button_6.setEnabled(false);
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getAcc2().getAccesory().equals("")){
			if(!JugarOnline.npc7.getAcc2().getAccesory().equals("null")){
		textField_6.setText(JugarOnline.npc7.getAcc2().getAccesory());
		button_6.setEnabled(true);}}
		textField_6.setColumns(10);
		textField_6.setBounds(329, 364, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_6);
		
	
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc2Jugadores window = new InfoAcc2Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_6.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_6.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_6.setOpaque(false);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(mf.MyFont(0,16));
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_6.setBackground(new Color(139, 69, 19));
		button_6.setBounds(516, 364, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_6);
		
		final JButton button_7 = new JButton("Info");
		button_7.setEnabled(false);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getAcc3().getAccesory().equals("")){
			if(!JugarOnline.npc7.getAcc3().getAccesory().equals("null")){
		textField_7.setText(JugarOnline.npc7.getAcc3().getAccesory());
		button_7.setEnabled(true);}}
		textField_7.setColumns(10);
		textField_7.setBounds(329, 398, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_7);
		
	
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc3Jugadores window = new InfoAcc3Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_7.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_7.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_7.setOpaque(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(mf.MyFont(0,16));
		button_7.setFocusPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_7.setBackground(new Color(139, 69, 19));
		button_7.setBounds(516, 398, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_7);
		
		final JButton button_8 = new JButton("Info");
		button_8.setEnabled(false);
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getAcc4().getAccesory().equals("")){
			if(!JugarOnline.npc7.getAcc4().getAccesory().equals("null")){
		textField_8.setText(JugarOnline.npc7.getAcc4().getAccesory());
		button_8.setEnabled(true);}}
		textField_8.setColumns(10);
		textField_8.setBounds(329, 432, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_8);
		
	
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc4Jugadores window = new InfoAcc4Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_8.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_8.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_8.setOpaque(false);
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(mf.MyFont(0,16));
		button_8.setFocusPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setBorderPainted(false);
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_8.setBackground(new Color(139, 69, 19));
		button_8.setBounds(516, 432, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_8);
		
		JLabel lblObjetos = new JLabel("Objetos");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjetos.setFont(mf.MyFont(0,18));
		lblObjetos.setBounds(3, 269, 287, 50);
		frmHistoriasDeZagas.getContentPane().add(lblObjetos);
		
		final JButton button_9 = new JButton("Info");
		button_9.setEnabled(false);
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getMisc1().getMisc().equals("")){
			if(!JugarOnline.npc7.getMisc1().getMisc().equals("null")){
		textField_9.setText(JugarOnline.npc7.getMisc1().getMisc());
		button_9.setEnabled(true);}}
		textField_9.setColumns(10);
		textField_9.setBounds(42, 330, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_9);
		
	
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc1Jugadores window = new InfoMisc1Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_9.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_9.setOpaque(false);
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(mf.MyFont(0,16));
		button_9.setFocusPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setBorderPainted(false);
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
								null, null));
		button_9.setBackground(new Color(139, 69, 19));
		button_9.setBounds(229, 330, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_9);
		
		final JButton button_10 = new JButton("Info");
		button_10.setEnabled(false);
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getMisc2().getMisc().equals("")){
			if(!JugarOnline.npc7.getMisc2().getMisc().equals("null")){
		textField_10.setText(JugarOnline.npc7.getMisc2().getMisc());
		button_10.setEnabled(true);}}
		textField_10.setColumns(10);
		textField_10.setBounds(42, 364, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_10);
		
		
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoMisc2Jugadores window = new InfoMisc2Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_10.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_10.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_10.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_10.setOpaque(false);
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setForeground(Color.WHITE);
		button_10.setFont(mf.MyFont(0,16));
		button_10.setFocusPainted(false);
		button_10.setContentAreaFilled(false);
		button_10.setBorderPainted(false);
		button_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_10.setBackground(new Color(139, 69, 19));
		button_10.setBounds(229, 364, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_10);
		
		final JButton button_11 = new JButton("Info");
		button_11.setEnabled(false);
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getMisc3().getMisc().equals("")){
			if(!JugarOnline.npc7.getMisc3().getMisc().equals("null")){
		textField_11.setText(JugarOnline.npc7.getMisc3().getMisc());
		button_11.setEnabled(true);}}
		textField_11.setColumns(10);
		textField_11.setBounds(42, 398, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_11);
		
	
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc3Jugadores window = new InfoMisc3Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_11.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_11.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_11.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_11.setOpaque(false);
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setForeground(Color.WHITE);
		button_11.setFont(mf.MyFont(0,16));
		button_11.setFocusPainted(false);
		button_11.setContentAreaFilled(false);
		button_11.setBorderPainted(false);
		button_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_11.setBackground(new Color(139, 69, 19));
		button_11.setBounds(229, 398, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_11);
		
		final JButton button_12 = new JButton("Info");
		button_12.setEnabled(false);
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(mf.MyFont(0,13));
		if(!JugarOnline.npc7.getMisc4().getMisc().equals("")){
			if(!JugarOnline.npc7.getMisc4().getMisc().equals("null")){
		textField_12.setText(JugarOnline.npc7.getMisc4().getMisc());
		button_12.setEnabled(true);}}
		textField_12.setColumns(10);
		textField_12.setBounds(42, 432, 177, 23);
		frmHistoriasDeZagas.getContentPane().add(textField_12);
		
	
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc4Jugadores window = new InfoMisc4Jugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_12.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_12.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
			}
		});
		button_12.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton info.png")));
		button_12.setOpaque(false);
		button_12.setHorizontalTextPosition(SwingConstants.CENTER);
		button_12.setForeground(Color.WHITE);
		button_12.setFont(mf.MyFont(0,16));
		button_12.setFocusPainted(false);
		button_12.setContentAreaFilled(false);
		button_12.setBorderPainted(false);
		button_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
										null, null));
		button_12.setBackground(new Color(139, 69, 19));
		button_12.setBounds(229, 432, 68, 23);
		frmHistoriasDeZagas.getContentPane().add(button_12);
		
		final JButton button_13 = new JButton("");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_13.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_13.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton atras2.png")));
			}
		});
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHistoriasDeZagas.dispose();
				
			}
		});
		button_13.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/boton atras.png")));
		button_13.setOpaque(false);
		button_13.setForeground(Color.WHITE);
		button_13.setFocusPainted(false);
		button_13.setContentAreaFilled(false);
		button_13.setBorderPainted(false);
		button_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
		
		
		
												null, null));
		button_13.setBackground(new Color(139, 69, 19));
		button_13.setBounds(10, 482, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(button_13);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EquipoJugadores.class.getResource("/images/background-resumen.jpg")));
		label.setBounds(3, 0, 591, 528);
		frmHistoriasDeZagas.getContentPane().add(label);
	}
}

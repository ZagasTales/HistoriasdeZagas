package es.thesinsprods.zagastales.juegozagas.jugar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class FichaPersonaje1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaPersonaje1 window = new FichaPersonaje1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public FichaPersonaje1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(OfflineConCon.personaje1.getName());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 11, 464, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel(OfflineConCon.personaje1.getRace().getRace());
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 75, 200, 26);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nivel: "+OfflineConCon.personaje1.getNivel());
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(273, 75, 200, 26);
		frame.getContentPane().add(label_1);
		
		JLabel lblSalud = new JLabel("Salud:");
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalud.setBounds(10, 130, 46, 14);
		frame.getContentPane().add(lblSalud);
		
		JLabel lblMan = new JLabel("Man\u00E1:");
		lblMan.setForeground(Color.WHITE);
		lblMan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMan.setBounds(10, 180, 46, 14);
		frame.getContentPane().add(lblMan);
		
		JLabel lblEnerga = new JLabel("Energ\u00EDa:");
		lblEnerga.setForeground(Color.WHITE);
		lblEnerga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnerga.setBounds(10, 155, 66, 14);
		frame.getContentPane().add(lblEnerga);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setMaximum(OfflineConCon.personaje1.getLife());
		progressBar.setValue(OfflineConCon.personaje1.getLife());
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(76, 130, 200, 14);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(20);
		progressBar_1.setStringPainted(true);
		progressBar_1.setMaximum(20);
		progressBar_1.setForeground(Color.BLUE);
		progressBar_1.setBackground(Color.WHITE);
		progressBar_1.setBounds(76, 180, 200, 14);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(20);
		progressBar_2.setStringPainted(true);
		progressBar_2.setMaximum(20);
		progressBar_2.setForeground(Color.GREEN);
		progressBar_2.setBackground(Color.WHITE);
		progressBar_2.setBounds(76, 155, 200, 14);
		frame.getContentPane().add(progressBar_2);
		
		JButton btnNewButton = new JButton("Atributos");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnNewButton.setBounds(286, 121, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnHabilidades = new JButton("Habilidades");
		btnHabilidades.setForeground(Color.WHITE);
		btnHabilidades.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabilidades.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnHabilidades.setBounds(286, 153, 89, 23);
		frame.getContentPane().add(btnHabilidades);
		
		JButton btnEquipo = new JButton("Equipo");
		btnEquipo.setForeground(Color.WHITE);
		btnEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEquipo.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnEquipo.setBounds(286, 187, 89, 23);
		frame.getContentPane().add(btnEquipo);
		
		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setForeground(Color.WHITE);
		lblExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExperiencia.setBounds(10, 233, 105, 14);
		frame.getContentPane().add(lblExperiencia);
		
		textField = new JTextField();
		textField.setBounds(106, 230, 60, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnExtras = new JButton("Extras");
		btnExtras.setForeground(Color.WHITE);
		btnExtras.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExtras.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnExtras.setBounds(385, 121, 89, 23);
		frame.getContentPane().add(btnExtras);
		
		JButton btnPrivilegios = new JButton("Privilegios");
		btnPrivilegios.setForeground(Color.WHITE);
		btnPrivilegios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrivilegios.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnPrivilegios.setBounds(385, 153, 89, 23);
		frame.getContentPane().add(btnPrivilegios);
		
		JButton btnReveses = new JButton("Reveses");
		btnReveses.setForeground(Color.WHITE);
		btnReveses.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReveses.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnReveses.setBounds(385, 187, 89, 23);
		frame.getContentPane().add(btnReveses);
		
		JLabel label_2 = new JLabel("Edad: "+OfflineConCon.personaje1.getAge());
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 205, 105, 14);
		frame.getContentPane().add(label_2);
		
		JButton btnNewButton_1 = new JButton("Estado");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnNewButton_1.setBounds(286, 221, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnDescripcin = new JButton("Descripci\u00F3n");
		btnDescripcin.setForeground(Color.WHITE);
		btnDescripcin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDescripcin.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/boton fichas pj1.png")));
		btnDescripcin.setBounds(385, 221, 89, 23);
		frame.getContentPane().add(btnDescripcin);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FichaPersonaje1.class.getResource("/images/background-fichaspj.jpg")));
		label_3.setBounds(0, 0, 474, 261);
		frame.getContentPane().add(label_3);
	}
}

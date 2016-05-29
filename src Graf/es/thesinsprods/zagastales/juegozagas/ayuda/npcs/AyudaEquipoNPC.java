package es.thesinsprods.zagastales.juegozagas.ayuda.npcs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.thesinsprods.resources.font.MorpheusFont;

public class AyudaEquipoNPC {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private final JPanel contentPanel = new JPanel();
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaEquipoNPC window = new AyudaEquipoNPC();
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
	public AyudaEquipoNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AyudaCreacionNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));

		frame.setResizable(false);
		frame.setBounds(100, 100, 439, 462);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel("Asignaci\u00F3n de Equipo");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 11, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue
				.setText("Aqu� se elige qu� es lo que va a llevar encima el NPC y se engloba en tres grandes grupos: Armas, armaduras y objetos.\n\nEn cada categor�a estar� marcado una cantidad m�xima de piezas de equipo que se pueden llevar, salvo en armaduras donde solo se puede llevar una. Este m�ximo depende del nivel de fuerza del personaje: hasta nivel 10 se puede llevar un arma y dos objetos, desde el nivel once al doce inclusive se pueden llevar dos armas y dos objetos, del nivel 13 al 16 se puede hasta tres armas y tres objetos y para cualquier nivel mayor de 16 el m�ximo estar� en cuatro armas y cuatro objetos.\n\nPara a�adir equipo primero hay que hacer clic en el bot�n de �a�adir� correspondiente (p.e. para a�adir un arma se pulsa el bot�n �A�adir armas�). Pulsar el bot�n se abrir� una nueva ventana en la que se deben introducir las propiedades de la pieza de equipo en cuesti�n, como el nombre, una descripci�n (opcional) y en el caso de armas y armaduras tambi�n se tiene que marcar la casilla que indique su tipo.");
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 12));
		txtrLoPrimeroQue.setBounds(10, 67, 414, 311);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton recuperar2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton recuperar.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaCreacionNPC window = new AyudaCreacionNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaEquipoNPC.class.getResource("/images/boton recuperar.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(218, 395, 89, 23);
		contentPanel.add(btnNewButton);

		final JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		button_1.setFocusPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaHabilidadesNPC window = new AyudaHabilidadesNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		button_1.setIcon(new ImageIcon(AyudaEquipoNPC.class
				.getResource("/images/boton atras.png")));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBounds(10, 385, 99, 38);
		contentPanel.add(button_1);

		final JButton btnPosesiones = new JButton("Posesiones");
		btnPosesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AyudaPosesionesNPC window = new AyudaPosesionesNPC();
				window.getFrame().setVisible(true);
			}
		});
		btnPosesiones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnPosesiones.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton recuperar2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnPosesiones.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton recuperar.png")));

			}
		});
		btnPosesiones.setIcon(new ImageIcon(AyudaEquipoNPC.class.getResource("/images/boton recuperar.png")));
		btnPosesiones.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPosesiones.setForeground(Color.WHITE);
		btnPosesiones.setFont(mf.MyFont(0, 13));
		btnPosesiones.setFocusPainted(false);
		btnPosesiones.setContentAreaFilled(false);
		btnPosesiones.setBorderPainted(false);
		btnPosesiones.setBorder(null);
		btnPosesiones.setBounds(119, 395, 89, 23);
		contentPanel.add(btnPosesiones);
		
		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton continuar2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(AyudaEquipoNPC.class
						.getResource("/images/boton continuar.png")));

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaExtrasNPC window = new AyudaExtrasNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			}
		});
		button.setIcon(new ImageIcon(AyudaEquipoNPC.class.getResource("/images/boton continuar.png")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(325, 389, 99, 38);
		contentPanel.add(button);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaEquipoNPC.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 434);
		contentPanel.add(label);
	}

}

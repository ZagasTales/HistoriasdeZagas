package es.thesinsprods.zagastales.juegozagas.ayuda.jugar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import es.thesinsprods.zagastales.juegozagas.ayuda.AyudaPrincipal;
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.jugador.AyudaPartidaVentanaJugador;
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.master.AyudaPartidaVentanaMaster;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPartidaJugar {

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
					AyudaPartidaJugar window = new AyudaPartidaJugar();
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
	public AyudaPartidaJugar() {
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
				AyudaCreacionPNJ.class
						.getResource("/images/Historias de Zagas, logo.png")));

		frame.setResizable(false);
		frame.setBounds(100, 100, 439, 487);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Jugar");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 13, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue
				.setText("Tras pulsar el bot\u00F3n de jugar se abrir\u00E1 una nueva ventana con cuatro opciones: crear partida, buscar partida, minijuegos y Volver al inicio.\r\n");
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 14));
		txtrLoPrimeroQue.setBounds(20, 72, 404, 88);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugar.class
						.getResource("/images/boton añadir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugar.class
						.getResource("/images/boton añadir.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPrincipal window = new AyudaPrincipal();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		final JButton btnCrearPartida = new JButton("Crear partida");
		btnCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaPartidaJugarCrearPartida window = new AyudaPartidaJugarCrearPartida();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			}
		});
		btnCrearPartida.addMouseListener(new MouseAdapter() 	{
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnCrearPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnCrearPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnCrearPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnCrearPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCrearPartida.setForeground(Color.WHITE);
		btnCrearPartida.setFont(mf.MyFont(0, 13));
		btnCrearPartida.setFocusPainted(false);
		btnCrearPartida.setContentAreaFilled(false);
		btnCrearPartida.setBorderPainted(false);
		btnCrearPartida.setBorder(null);
		btnCrearPartida.setBounds(51, 153, 325, 37);
		contentPanel.add(btnCrearPartida);
		
		final JButton btnBuscarPartida = new JButton("Buscar partida");
		btnBuscarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnBuscarPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnBuscarPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnBuscarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				AyudaPartidaJugarBuscarPartida window = new AyudaPartidaJugarBuscarPartida();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnBuscarPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnBuscarPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarPartida.setForeground(Color.WHITE);
		btnBuscarPartida.setFont(mf.MyFont(0, 13));
		btnBuscarPartida.setFocusPainted(false);
		btnBuscarPartida.setContentAreaFilled(false);
		btnBuscarPartida.setBorderPainted(false);
		btnBuscarPartida.setBorder(null);
		btnBuscarPartida.setBounds(51, 204, 325, 37);
		contentPanel.add(btnBuscarPartida);
		
		final JButton btnMinijuegos = new JButton("Minijuegos");
		btnMinijuegos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnMinijuegos.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}
			@Override
		public void mouseReleased(MouseEvent arg0) {
			btnMinijuegos.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnMinijuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaPartidaJugarMinijuegos window = new AyudaPartidaJugarMinijuegos();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnMinijuegos.setIcon(new ImageIcon(AyudaPartidaJugar.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnMinijuegos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMinijuegos.setForeground(Color.WHITE);
		btnMinijuegos.setFont(mf.MyFont(0, 13));
		btnMinijuegos.setFocusPainted(false);
		btnMinijuegos.setContentAreaFilled(false);
		btnMinijuegos.setBorderPainted(false);
		btnMinijuegos.setBorder(null);
		btnMinijuegos.setBounds(51, 252, 325, 37);
		contentPanel.add(btnMinijuegos);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugar.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(153, 413, 120, 34);
		contentPanel.add(btnNewButton);
		
		final JButton btnVentanaJugador = new JButton("Ventana Jugador");
		btnVentanaJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnVentanaJugador.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}
			@Override
		public void mouseReleased(MouseEvent arg0) {
			btnVentanaJugador.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnVentanaJugador.setIcon(new ImageIcon(AyudaPartidaJugar.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnVentanaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaVentanaJugador window = new AyudaPartidaVentanaJugador();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnVentanaJugador.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVentanaJugador.setForeground(Color.WHITE);
		btnVentanaJugador.setFont(mf.MyFont(0, 13));
		btnVentanaJugador.setFocusPainted(false);
		btnVentanaJugador.setContentAreaFilled(false);
		btnVentanaJugador.setBorderPainted(false);
		btnVentanaJugador.setBorder(null);
		btnVentanaJugador.setBounds(51, 300, 325, 37);
		contentPanel.add(btnVentanaJugador);
		
		final JButton btnVentanaMaster = new JButton("Ventana Master\r\n");
		btnVentanaMaster.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnVentanaMaster.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}
			@Override
		public void mouseReleased(MouseEvent arg0) {
			btnVentanaMaster.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnVentanaMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaVentanaMaster window = new AyudaPartidaVentanaMaster();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnVentanaMaster.setIcon(new ImageIcon(AyudaPartidaJugar.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnVentanaMaster.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVentanaMaster.setForeground(Color.WHITE);
		btnVentanaMaster.setFont(mf.MyFont(0, 13));
		btnVentanaMaster.setFocusPainted(false);
		btnVentanaMaster.setContentAreaFilled(false);
		btnVentanaMaster.setBorderPainted(false);
		btnVentanaMaster.setBorder(null);
		btnVentanaMaster.setBounds(51, 350, 325, 37);
		contentPanel.add(btnVentanaMaster);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPartidaJugar.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 458);
		contentPanel.add(label);
	}

	

}

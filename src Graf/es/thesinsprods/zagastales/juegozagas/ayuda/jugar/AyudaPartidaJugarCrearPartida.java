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
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPartidaJugarCrearPartida {

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
					AyudaPartidaJugarCrearPartida window = new AyudaPartidaJugarCrearPartida();
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
	public AyudaPartidaJugarCrearPartida() {
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
		frame.setBounds(100, 100, 439, 323);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Crear partida");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 13, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue
				.setText("Si planeas ser al master de la partida entonces ser\u00E1s el responsable de crearla. Tras pulsar el bot\u00F3n se abrir\u00E1 una nueva ventana donde podr\u00E1s Indicar el nombre de la partida, una contrase\u00F1a si fuera necesaria, una descripci\u00F3n y el n\u00FAmero m\u00E1ximo d ejugadores (hasta un m\u00E1ximo de 9). Una vez rellenados los datos necesarios se puede iniciar la partida pulsando en el bot\u00F3n \u201CCrear\u201D\r\n");
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 14));
		txtrLoPrimeroQue.setBounds(20, 72, 404, 146);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
						.getResource("/images/boton a�adir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
						.getResource("/images/boton a�adir.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaJugar window = new AyudaPartidaJugar();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(148, 231, 120, 34);
		contentPanel.add(btnNewButton);

		final JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AyudaPartidaJugarBuscarPartida window = new AyudaPartidaJugarBuscarPartida();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
						.getResource("/images/boton continuar2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
						.getResource("/images/boton continuar.png")));

			}

		});
		button.setFocusPainted(false);
		button.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
				.getResource("/images/boton continuar.png")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(322, 231, 99, 38);
		contentPanel.add(button);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPartidaJugarCrearPartida.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 288);
		contentPanel.add(label);
	}

	

}

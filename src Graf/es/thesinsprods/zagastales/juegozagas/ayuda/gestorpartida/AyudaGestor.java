package es.thesinsprods.zagastales.juegozagas.ayuda.gestorpartida;

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
import es.thesinsprods.zagastales.juegozagas.ayuda.npcs.AyudaBendicionNPC;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaGestor {

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
					AyudaGestor window = new AyudaGestor();
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
	public AyudaGestor() {
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
		frame.setBounds(100, 100, 439, 357);
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
		lblAspectosGeneralesDel.setBounds(10, 0, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue
				.setText("Esta es una ventana que ofrece herramientas adicionales para la direcci\u00F3n de una partida, con el a\u00F1adido de que no hace falta crear una partida para utilizarlas. Puede usarse por ejemplo como apoyo para una partida manual fuera del programa.");
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 14));
		txtrLoPrimeroQue.setBounds(20, 72, 404, 117);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/botones panteon2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/botones panteon.png")));

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
		
		final JButton btnTiradasEnfrentadas = new JButton("Tiradas Enfrentadas");
		btnTiradasEnfrentadas.addMouseListener(new MouseAdapter()  {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnTiradasEnfrentadas.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/boton añadir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnTiradasEnfrentadas.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/boton añadir.png")));

			}
		});
		btnTiradasEnfrentadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				AyudaGestorTiradasEnfrentadas window = new AyudaGestorTiradasEnfrentadas();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnTiradasEnfrentadas.setIcon(new ImageIcon(AyudaGestor.class.getResource("/images/botones panteon.png")));
		btnTiradasEnfrentadas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTiradasEnfrentadas.setForeground(Color.WHITE);
		btnTiradasEnfrentadas.setFont(mf.MyFont(0, 13));
		btnTiradasEnfrentadas.setFocusPainted(false);
		btnTiradasEnfrentadas.setContentAreaFilled(false);
		btnTiradasEnfrentadas.setBorderPainted(false);
		btnTiradasEnfrentadas.setBorder(null);
		btnTiradasEnfrentadas.setBounds(240, 200, 183, 33);
		contentPanel.add(btnTiradasEnfrentadas);
		
		final JButton btnTiradasAleatorias = new JButton("Tiradas Aleatorias");
		btnTiradasAleatorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnTiradasAleatorias.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/botones panteon2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnTiradasAleatorias.setIcon(new ImageIcon(AyudaGestor.class
						.getResource("/images/botones panteon.png")));
			}
		});
		btnTiradasAleatorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaGestorTiradasAleatorias window = new AyudaGestorTiradasAleatorias();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			}
		});
		btnTiradasAleatorias.setIcon(new ImageIcon(AyudaGestor.class.getResource("/images/botones panteon.png")));
		btnTiradasAleatorias.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTiradasAleatorias.setForeground(Color.WHITE);
		btnTiradasAleatorias.setFont(mf.MyFont(0, 13));
		btnTiradasAleatorias.setFocusPainted(false);
		btnTiradasAleatorias.setContentAreaFilled(false);
		btnTiradasAleatorias.setBorderPainted(false);
		btnTiradasAleatorias.setBorder(null);
		btnTiradasAleatorias.setBounds(10, 200, 183, 33);
		contentPanel.add(btnTiradasAleatorias);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaGestor.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(160, 257, 120, 34);
		contentPanel.add(btnNewButton);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaGestor.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 332);
		contentPanel.add(label);
	}

}

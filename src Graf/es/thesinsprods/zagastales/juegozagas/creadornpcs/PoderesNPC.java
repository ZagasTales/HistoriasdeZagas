package es.thesinsprods.zagastales.juegozagas.creadornpcs;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.perfil.InfoExtras;

public class PoderesNPC {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	MorpheusFont mf = new MorpheusFont();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoderesNPC window = new PoderesNPC();
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
	public PoderesNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InfoExtras.class.getResource("/images/Historias de Zagas, logo.png")));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 379, 335);
		frame.getContentPane().setLayout(null);
		{
			final JButton button = new JButton("");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					button.setIcon(new ImageIcon(InfoExtras.class.getResource("/images/boton atras2.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					button.setIcon(new ImageIcon(InfoExtras.class.getResource("/images/boton atras.png")));
				}
			});
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			button.setIcon(new ImageIcon(InfoExtras.class.getResource("/images/boton atras.png")));
			button.setOpaque(false);
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Morpheus", Font.PLAIN, 15));
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setBorder(new BevelBorder(BevelBorder.RAISED, null,

									null,

			

									null, null));
			button.setBackground(new Color(139, 69, 19));
			button.setBounds(10, 251, 99, 45);
			frame.getContentPane().add(button);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 353, 170);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(StartNPC.character.getPoderes());
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(mf.MyFont(0, 13));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Poderes");
		lblNewLabel.setFont(mf.MyFont(0, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 353, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InfoExtras.class.getResource("/images/background-panteon.jpg")));
		label.setBounds(0, 0, 373, 307);
		frame.getContentPane().add(label);
	}

}

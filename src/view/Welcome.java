package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/**
		 * Look and feel
		 */
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// LOGOTIPO JASK
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Welcome.class.getResource("/view/img/logos/logo_jask_v1.png")));
		label.setBounds(100, 85, 200, 200);
		frame.getContentPane().add(label);
		
		// BOTÃO DE ENTRAR
		JButton btnEntrar = new JButton("Entre");
		btnEntrar.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(46,204,113));
		//setBounds: positionX, positionY, width, height.
		btnEntrar.setBounds(100, 350, 200, 35);
		frame.getContentPane().add(btnEntrar);
		
		// BOTÃO DE CADASTRO
		JButton btnCadastro = new JButton("Cadastre-se");
		btnCadastro.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnCadastro.setForeground(new Color(255, 255, 255));
		//setBounds: positionX, positionY, width, height:
		btnCadastro.setBackground(new Color(231,76,60));
		//setBounds: positionX, positionY, width, height.
		btnCadastro.setBounds(100, 395, 200, 35);
		frame.getContentPane().add(btnCadastro);
		
	}
}
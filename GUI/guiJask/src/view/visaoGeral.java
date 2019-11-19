package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;

public class visaoGeral extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visaoGeral frame = new visaoGeral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public visaoGeral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(354, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnViewprojects = new JButton("");
		btnViewprojects.setForeground(Color.WHITE);
		btnViewprojects.setBackground(Color.WHITE);
		btnViewprojects.setBorderPainted(false);
		btnViewprojects.setBounds(10, 10, 45, 45);
		btnViewprojects.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/listProjects.png")));
		contentPane.add(btnViewprojects);
		
		JButton btnViewcolaborators = new JButton("");
		btnViewcolaborators.setForeground(Color.WHITE);
		btnViewcolaborators.setBackground(Color.WHITE);
		btnViewprojects.setBorderPainted(false);
		btnViewcolaborators.setBounds(105, 10, 45, 45);
		btnViewcolaborators.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/collaborators.png")));
		contentPane.add(btnViewcolaborators);
		
		JButton btnViewChat = new JButton("");
		btnViewChat.setForeground(Color.WHITE);
		btnViewChat.setBackground(Color.WHITE);
		btnViewChat.setBorderPainted(false);
		btnViewChat.setBounds(546, 10, 45, 45);
		btnViewChat.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/message.png")));
		contentPane.add(btnViewChat);
		
		JButton btnUserConfig = new JButton("");
		btnUserConfig.setForeground(Color.WHITE);
		btnUserConfig.setBackground(Color.WHITE);
		btnUserConfig.setBorderPainted(false);
		btnUserConfig.setBounds(745, 10, 45, 45);
		btnUserConfig.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/moreHorizontal.png")));
		contentPane.add(btnUserConfig);
	}
}

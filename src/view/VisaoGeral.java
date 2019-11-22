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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaoGeral extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
					VisaoGeral frame = new VisaoGeral();
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
	public VisaoGeral() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnViewprojects = new JButton("");
		btnViewprojects.setToolTipText("Listar projetos");
		btnViewprojects.setForeground(Color.WHITE);
		btnViewprojects.setBackground(Color.WHITE);
		btnViewprojects.setBorderPainted(false);
		btnViewprojects.setBounds(10, 10, 45, 45);
		btnViewprojects.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/listProjects.png")));
		contentPane.add(btnViewprojects);
		
		JButton btnViewcolaborators = new JButton("");
		btnViewcolaborators.setToolTipText("Colaboradores");
		btnViewcolaborators.setForeground(Color.WHITE);
		btnViewcolaborators.setBackground(Color.WHITE);
		btnViewcolaborators.setBorderPainted(false);
		btnViewcolaborators.setBounds(105, 10, 45, 45); //150
		btnViewcolaborators.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/collaborators.png")));
		contentPane.add(btnViewcolaborators);

		
		//Caixa de busca:
		textField = new JTextField();
		textField.setToolTipText("insira aqui um termo para buscar");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(302, 20, 200, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnViewChat = new JButton("");
		btnViewChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Chat we = new Chat();
				we.setVisible(true);
			}
		});
		btnViewChat.setToolTipText("Mensagens");
		btnViewChat.setForeground(Color.WHITE);
		btnViewChat.setBackground(Color.WHITE);
		btnViewChat.setBorderPainted(false);
		btnViewChat.setBounds(644, 10, 45, 45);
		btnViewChat.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/message.png")));
		contentPane.add(btnViewChat);
		

		JButton btnUserConfig = new JButton("");
		btnUserConfig.setToolTipText("Op\u00E7\u00F5es");
		btnUserConfig.setForeground(Color.WHITE);
		btnUserConfig.setBackground(Color.WHITE);
		btnUserConfig.setBorderPainted(false);
		btnUserConfig.setBounds(739, 10, 45, 45);
		btnUserConfig.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/moreHorizontal.png")));
		contentPane.add(btnUserConfig);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(105, 105, 105)));
		table.setBackground(new Color(176, 196, 222));
		table.setBounds(149, 149, 487, 246);
		contentPane.add(table);
		
		JLabel lblProjetos = new JLabel("Projetos");
		lblProjetos.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProjetos.setBounds(149, 102, 134, 37);
		contentPane.add(lblProjetos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 65, 794, 13);
		contentPane.add(separator);
	}


}

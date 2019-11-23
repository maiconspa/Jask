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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VisaoGeral extends JFrame {
	
	/**
	 * Atributo de composição de tela, utilizado para adiconar elementos à exibição
	 */
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
		} catch (Exception e) {}
		
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

	//<-------------------------------- COMPORTAMENTO(métodos) ------------------------------------------->\\
	public static void chamarChat(JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Chat we = new Chat();
				we.setVisible(true);
			}
		});
	}
	
	
	public static void vanish(JButton botao, JPanel paineis [], JPanel painel) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < paineis.length; i++) {
					paineis[i].setVisible(false);
				}
				painel.setVisible(true);
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public VisaoGeral() {
		/**
		 * variavel para controle facilitado da largura de JFrame e seus componentes
		 */
		int maxWidth = 800;
		
		/**
		 * variavel para controle facilitado da altura de JFrame e seus componentes
		 */
		int maxHeight = 600;
		
		//<----------------------------------- TEMAS ---------------------------------------->\\
		// TEMA AZUL
		/**
		 * Array para utilização de codigo RGB para background do tema azul
		 */
		int bgBlueTheme [] = {205, 224, 231};
		/**
		 * Array para utilização de código RGB para background da navbar do tema azul
		 */
		int bgNavBlueTheme [] = {140, 185, 200};
		/**
		 * Array para utilização de código RGB para background dos JPanels internos
		 */
		int bgJpBlueTheme [] = {88, 97, 99};
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, maxWidth, maxHeight);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//<------------- BARRA DE NAVEGAÇÃO (JPanel) --------------->\\
		JPanel navbar = new JPanel();
		navbar.setBounds(0, 0, maxWidth, 40);
		navbar.setBackground(new Color (bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]));
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JButton btnViewprojects = new JButton("");
		btnViewprojects.setToolTipText("Listar projetos");
		btnViewprojects.setForeground(Color.WHITE);
		btnViewprojects.setBackground(null);
		btnViewprojects.setBorderPainted(false);
		btnViewprojects.setBounds(10, 0, 45, 45);
		btnViewprojects.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/listProjects.png")));
		navbar.add(btnViewprojects);
		
		JButton btnViewcolaborators = new JButton("");
		btnViewcolaborators.setToolTipText("Colaboradores");
		btnViewcolaborators.setForeground(Color.WHITE);
		btnViewcolaborators.setBackground(null);
		btnViewcolaborators.setBorderPainted(false);
		btnViewcolaborators.setBounds(105, 0, 45, 45); //150
		btnViewcolaborators.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/collaborators.png")));
		navbar.add(btnViewcolaborators);

		
		/**
		 * caixa de busca
		 */
		textField = new JTextField();
		textField.setToolTipText("insira aqui um termo para buscar");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(302, 7, 200, 26);
		textField.setColumns(10);
		textField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		navbar.add(textField);
		
		
		/**
		 * Botão de mensagens
		 */
		JButton btnViewChat = new JButton("");
		btnViewChat.setToolTipText("Mensagens");
		btnViewChat.setForeground(Color.WHITE);
		btnViewChat.setBackground(null);
		btnViewChat.setBorderPainted(false);
		btnViewChat.setBounds(644, 0, 45, 45);
		btnViewChat.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/message.png")));
		navbar.add(btnViewChat);
		
		/**
		 * Botão de configurações
		 */
		JButton btnViewConfig = new JButton("");
		btnViewConfig.setToolTipText("Opções");
		btnViewConfig.setForeground(Color.WHITE);
		btnViewConfig.setBackground(null);
		btnViewConfig.setBorderPainted(false);
		btnViewConfig.setBounds(739, 0, 45, 45);
		btnViewConfig.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/moreHorizontal.png")));
		navbar.add(btnViewConfig);
		
		
		//<------------------------  JPANELS INTERNOS (troca usando funções VANISH e MANIFEST)  ---------------------------->\\
		int maxWidthPanels = maxWidth - (maxWidth/4);
		int maxHeightPanels = maxHeight - (maxHeight/4);
		
		/**
		 * Painel de exibição de projetos
		 */
		JPanel painelProjetos = new JPanel();
		painelProjetos.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelProjetos.setBackground(new Color(bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]));
		contentPane.add(painelProjetos);
		painelProjetos.setLayout(null);
		
		JLabel lblProjetos = new JLabel("Projetos");
		lblProjetos.setBounds(10, 11, 150, 40);
		painelProjetos.add(lblProjetos);
		lblProjetos.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		/**
		 * Painel de exibição de colaboradores
		 */
		JPanel painelCollab = new JPanel();
		painelCollab.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelCollab.setBackground(new Color(bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]));
		contentPane.add(painelCollab);
		painelCollab.setLayout(null);
		
		JLabel lblCollab = new JLabel("Collab");
		lblCollab.setBounds(10, 11, 150, 40);
		painelCollab.add(lblCollab);
		lblCollab.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		/**
		 * Painel de exibição de configurações
		 */
		JPanel painelConfig = new JPanel();
		painelConfig.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelConfig.setBackground(new Color(bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]));
		contentPane.add(painelConfig);
		painelConfig.setLayout(null);
		
		JLabel lblConfig = new JLabel("Config");
		lblConfig.setBounds(10, 11, 150, 40);
		painelConfig.add(lblConfig);
		lblConfig.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		/**
		 * Array de paineis
		 */
		JPanel arrayPaineis [] = {painelProjetos, painelCollab, painelConfig};
		
		
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		/**
		 * Exibir chat ao clicar em btnViewChat
		 */
		chamarChat(btnViewChat);
		
		vanish(btnViewprojects, arrayPaineis, painelProjetos);
		vanish(btnViewcolaborators, arrayPaineis, painelCollab);
		vanish(btnViewConfig, arrayPaineis, painelConfig);
	
	}
	

		

}

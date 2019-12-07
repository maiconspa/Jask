package src.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Tela de visão geral do projeto, interações com tarefas, mensagens e etc.
 * @author Maicon Souza
 */
public class VisaoGeral {
	
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
	
	// TEMA ESCURO
	/**
	 * Array para utilização de codigo RGB para background do tema ESCURO
	 */
	int bgDarkTheme [] = {0, 0, 0};
	/**
	 * Array para utilização de código RGB para background da navbar do tema ESCURO
	 */
	int bgNavDarkTheme [] = {100, 100, 100};
	/**
	 * Array para utilização de código RGB para background dos JPanels internos 
	 */
	int bgJpDarkTheme [] = {50, 50, 50};
			
	//Tema PADRÃO
	/**
	 * Array de cores RGB para o background da janela
	 */
	int bg [] = {bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]};
	/**
	 * Array de cores RGB para o background da barra de navegação
	 */
	int bgNav [] = {bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]};
	/**
	 * Array de cores RGB para o background dos paineis internos
	 */
	int bgJp [] = {bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]};

	
	//<-------------------------------- COMPORTAMENTO(métodos) ------------------------------------------->\\
	private void switchTheme(JButton botao, String tema, JPanel nav, JPanel geral, JPanel paineis [], JLabel labels []) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i = 0; i < 3; i++) {
					if (tema.equals("Just blue")) {
						nav.setBackground(new Color(bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]));
						geral.setBackground(new Color(bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]));
						paineis [i].setBackground(new Color(bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]));
						labels [i].setForeground(Color.BLACK);
					} else if (tema.equals("Just black")) {
						nav.setBackground(new Color(bgNavDarkTheme[0], bgNavDarkTheme[1], bgNavDarkTheme[2]));
						geral.setBackground(new Color(bgDarkTheme[0], bgDarkTheme[1], bgDarkTheme[2]));
						paineis [i].setBackground(new Color(bgJpDarkTheme[0], bgJpDarkTheme[1], bgJpDarkTheme[2]));
						labels [i].setForeground(Color.WHITE);
					}
				}
			}
		});
		
	}
	
	/**
	 * Chamar tela de chat para op primeiro plano, recebe um objeto do tipo JButton
	 * @param botao
	 */
	public static void chamarChat(JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Chat().composeChat();
			}
		});
	}
	
	/**
	 * Função para realizar a troca de JPanels dentro da TelaPrincipal
	 * @param botao
	 * @param paineis
	 * @param painel
	 */
	public static void switchPanel(JButton botao, JPanel paineis [], JPanel painel) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < paineis.length; i++) {
					paineis[i].setVisible(false);
				}
				painel.setVisible(true);
			}
		});
	}
	

	
	//<------------------------------------------------------------------->\\
	/**
	 * Janela de Visão Geral do aplicativo
	 * @return 
	 */
	public void composeVisaoGeral() {
		/**
		 * variavel para controle facilitado da largura de JFrame e seus componentes
		 */
		int maxWidth = 800;
		
		/**
		 * variavel para controle facilitado da altura de JFrame e seus componentes
		 */
		int maxHeight = 600;
		
		JFrame janela = new JFrame();
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setBounds(100, 100, maxWidth, maxHeight);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(bg[0], bg[1], bg[2]));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setLayout(null);
		janela.setContentPane(painelPrincipal);
		
		//<------------- BARRA DE NAVEGAÇÃO (JPanel) --------------->\\
		JPanel navbar = new JPanel();
		navbar.setBounds(0, 0, maxWidth, 40);
		navbar.setBackground(new Color (bgNav[0], bgNav[1], bgNav[2]));
		painelPrincipal.add(navbar);
		navbar.setLayout(null);
		
		JButton btnViewProjetos = new JButton("");
		btnViewProjetos.setToolTipText("Listar projetos");
		btnViewProjetos.setForeground(Color.WHITE);
		btnViewProjetos.setBackground(null);
		btnViewProjetos.setBorderPainted(false);
		btnViewProjetos.setBounds(10, 0, 45, 45);
		btnViewProjetos.setIcon(new ImageIcon(Cadastro.class.getResource("/src/view/img/icons/listProjects.png")));
		navbar.add(btnViewProjetos);
		
		JButton btnViewColab = new JButton("");
		btnViewColab.setToolTipText("Colaboradores");
		btnViewColab.setForeground(Color.WHITE);
		btnViewColab.setBackground(null);
		btnViewColab.setBorderPainted(false);
		btnViewColab.setBounds(105, 0, 45, 45); //150
		btnViewColab.setIcon(new ImageIcon(Cadastro.class.getResource("/src/view/img/icons/collaborators.png")));
		navbar.add(btnViewColab);

		
		/**
		 * caixa de busca
		 */
		JTextField campoBusca = new JTextField();
		campoBusca.setToolTipText("insira aqui um termo para buscar");
		campoBusca.setHorizontalAlignment(SwingConstants.CENTER);
		campoBusca.setBounds(302, 7, 200, 26);
		campoBusca.setColumns(10);
		campoBusca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
		navbar.add(campoBusca);
		
		
		/**
		 * Botão de mensagens
		 */
		JButton btnViewChat = new JButton("");
		btnViewChat.setToolTipText("Mensagens");
		btnViewChat.setForeground(Color.WHITE);
		btnViewChat.setBackground(null);
		btnViewChat.setBorderPainted(false);
		btnViewChat.setBounds(644, 0, 45, 45);
		btnViewChat.setIcon(new ImageIcon(Cadastro.class.getResource("/src/view/img/icons/message.png")));
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
		btnViewConfig.setIcon(new ImageIcon(Cadastro.class.getResource("/src/view/img/icons/moreHorizontal.png")));
		navbar.add(btnViewConfig);
		
		
		//<------------------------  JPANELS INTERNOS (troca utilizando switchPanel)  ---------------------------->\\
		int maxWidthPanels = maxWidth - (maxWidth/4);
		int maxHeightPanels = maxHeight - (maxHeight/4);
		
		/**
		 * Painel de exibição de projetos ativos
		 */
		JPanel painelProjetos = new JPanel();
		painelProjetos.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelProjetos.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelProjetos.setForeground(Color.white);
		painelProjetos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
		painelProjetos.setLayout(null);
		painelProjetos.setVisible(true);
		painelPrincipal.add(painelProjetos);
		
		JLabel lblProjetos = new JLabel("Projetos Ativos");
		lblProjetos.setBounds(10, 11, maxWidthPanels, 40);
		painelProjetos.add(lblProjetos);
		lblProjetos.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		/**
		 * Painel de exibição de colaboradores
		 */
		JPanel painelColab = new JPanel();
		painelColab.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelColab.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelColab.setLayout(null);
		painelColab.setVisible(false);
		painelPrincipal.add(painelColab);
		
		JLabel lblCollab = new JLabel("Colaboradores");
		lblCollab.setBounds(10, 11, maxWidthPanels, 40);
		painelColab.add(lblCollab);
		lblCollab.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		/**
		 * Painel de exibição de configurações
		 */
		JPanel painelConfig = new JPanel();
		painelConfig.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelConfig.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelConfig.setLayout(null);
		painelConfig.setVisible(false);
		painelPrincipal.add(painelConfig);
		
		/**
		 * Label de título do JPanel
		 */
		JLabel lblConfig = new JLabel("Configurações");
		lblConfig.setBounds(10, 11, maxWidthPanels, 40);
		lblConfig.setFont(new Font("Tahoma", Font.BOLD, 30));
		painelConfig.add(lblConfig);
		
		JButton btnThemeJustBlue = new JButton("Just Blue");
		btnThemeJustBlue.setToolTipText("Altera tema");
		btnThemeJustBlue.setForeground(Color.WHITE);
		btnThemeJustBlue.setBackground(null);
		btnThemeJustBlue.setBounds(20, 60, 70, 20);
		btnThemeJustBlue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
		painelConfig.add(btnThemeJustBlue);
		
		JButton btnThemeJustBlack = new JButton("Just Black");
		btnThemeJustBlack.setToolTipText("Altera tema");
		btnThemeJustBlack.setForeground(Color.WHITE);
		btnThemeJustBlack.setBackground(null);
		btnThemeJustBlack.setBounds(20, 85, 70, 20);
		btnThemeJustBlack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
		painelConfig.add(btnThemeJustBlack);
		
		
		//Array com todos os JPanels internos para verificação de visibilidade
		/**
		 * Array de paineis
		 */
		JPanel arrayPaineis [] = {painelProjetos, painelColab, painelConfig};
		
		//Array com todas as JLabels internas para alteração de tema
		/**
		 * Array de labels
		 */
		JLabel arrayLabels [] = {lblProjetos, lblCollab, lblConfig};
		
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		/**
		 * Exibir chat ao clicar em btnViewChat
		 */
		chamarChat(btnViewChat);
		/**
		 * Adicionar ação ao botão btnViewProjetos
		 */
		switchPanel(btnViewProjetos, arrayPaineis, painelProjetos);
		/**
		 * Adicionar ação ao botão btnViewColab
		 */
		switchPanel(btnViewColab, arrayPaineis, painelColab);
		/**
		 * Adicionar ação ao botão btnViewConfig
		 */
		switchPanel(btnViewConfig, arrayPaineis, painelConfig);
		
		switchTheme(btnThemeJustBlue, "Just blue", navbar, painelPrincipal, arrayPaineis, arrayLabels);
		switchTheme(btnThemeJustBlack, "Just black", navbar, painelPrincipal, arrayPaineis, arrayLabels);
		
		
		
		
		
		//! setVisible
		janela.setVisible(true);
	}

	
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		
		new VisaoGeral().composeVisaoGeral();
	}
}

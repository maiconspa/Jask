package view;

import java.awt.Color;
import java.awt.Cursor;

import utils.EstadoTarefa;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import utils.Prioridade;
import dao.Conexao;
import dao.ProjetoDao;
import dao.TarefaDao;
import dao.UsuarioDao;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modelos.*;
import utils.EstadoTarefa;
import utils.Prioridade;

/**
 * Tela de vis�o geral do projeto, intera��es com tarefas, mensagens e etc.
 * @author Maicon Souza
 */
public class VisaoGeral {
	
	private String apelido;
	
	//CONSTRUTORES:
	public VisaoGeral() {}
	
	public VisaoGeral(String apelido) {
		this.apelido = apelido;
	}
	
	public String getApelido() {
		return this.apelido;
	}
	
	//VARI�VEIS DE CONTROLE DE TEMAS:
	//TEMA AZUL
	int bgBlueTheme [] = {212, 220, 229}; //{20, 162, 251};
	int bgNavBlueTheme [] = {63, 111, 163};
	int bgJpBlueTheme [] = {212, 220, 229};
	
	//TEMA ESCURO
	int bgDarkTheme [] = {50, 50, 50}; //{0, 0, 0};
	int bgNavDarkTheme [] = {20, 20, 20}; //{100, 100, 100};
	int bgJpDarkTheme [] = {50, 50, 50}; //{50, 50, 50};
			
	//TEMA DEFAULT (utilizado para substitui��o de valores)
	int bg [] = {bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]};
	int bgNav [] = {bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]};
	int bgJp [] = {bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]};

	//M�TODO PARA TROCA DE TEMA:
	private void switchTheme(JButton botao, String tema, JPanel nav, JPanel geral, JPanel paineis [], JLabel labels [], JButton [] buttons) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 3; i++) {
					
					if (tema.equals("azul")) {
						System.out.println("a");
						nav.setBackground(new Color(bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]));
						geral.setBackground(new Color(bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]));
						paineis [i].setBackground(new Color(bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]));
						buttons [i].setForeground(Color.BLACK);
						buttons [i].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					} else if (tema.equals("escuro")) {
						System.out.println("b");
						nav.setBackground(new Color(bgNavDarkTheme[0], bgNavDarkTheme[1], bgNavDarkTheme[2]));
						geral.setBackground(new Color(bgDarkTheme[0], bgDarkTheme[1], bgDarkTheme[2]));
						paineis [i].setBackground(new Color(bgJpDarkTheme[0], bgJpDarkTheme[1], bgJpDarkTheme[2]));
						buttons [i].setForeground(Color.WHITE);
						buttons [i].setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
					}
					
					for (int j = 0; j < labels.length; j++) {
						if (tema.equals("azul")) {
							System.out.println("a");
							labels [j].setForeground(Color.BLACK);
						} else if (tema.equals("escuro")) {
							System.out.println("b");
							labels [j].setForeground(Color.WHITE);
						}
					}
				}
				
			}
		});
		
	}
	
	//
	public void atualiza(JPanel painel, JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				//EXIBI��O DE PROJETOS
				ProjetoDao projectDao = new ProjetoDao(Conexao.conectar());
				ArrayList<Projeto> colecaoProjeto = new ArrayList<>();
				
				int posicao = 60;
				
				try {
					colecaoProjeto = projectDao.listarProjeto();	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				for (int x = 0 ; x < colecaoProjeto.size() ; x++ ) {
					JButton temp = new JButton(colecaoProjeto.get(x).getNomeProjeto());
					temp.setBounds(10, posicao + (x*30), 150, 25);
					temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
					temp.setBackground(null);
					temp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					temp.setFont(new Font("Tahoma", Font.BOLD, 12));
					painel.add(temp);
				}
				
				
				
			}
		});
	}
	
	
	//
	public void atualizaT(JPanel painel, JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				//EXIBI��O DE TAREFAS:
				TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
				ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();
				
				int p = 60;
				
				try {
					colecaoTarefa = tarefaDao.listarTarefas();	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				for (int x = 0 ; x < colecaoTarefa.size() ; x++ ) {
					JButton tempT = new JButton(colecaoTarefa.get(x).getTitulo());
					tempT.setBounds(10, p + (x*30), 150, 25);
					tempT.setCursor(new Cursor(Cursor.HAND_CURSOR));
					tempT.setBackground(null);
					tempT.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					tempT.setFont(new Font("Tahoma", Font.BOLD, 12));
					painel.add(tempT);
				}
				
				
				
			}
		});
	}
	
	
	
	//M�TODO QUE CHAMA A TELA DE CHAT:
	public static void chamarChat(JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Chat().composeChat();
			}
		});
	}
	
	
	//M�TODO QUE CHAMA A TELA DE PERFIL:
	public static void chamarExtProfile(JButton botao, String apelido) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("chamandoo perfil de:" +apelido);
				Profile p = new Profile(apelido);
				
				p.composeProfile();
			}
		});
	}
	
	
	//M�TODO QUE CRIA UM NOVO PROJETO:
		public static void criaProjeto(JButton botao, String apelido, JTextField nomeProjeto) {
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id = 0;
					
					UsuarioDao ud = new UsuarioDao(Conexao.conectar());
					Usuario u = ud.consultarUsuario(apelido);
					
					
					System.out.println("criando projeto:" +apelido);
					ProjetoDao pd = new ProjetoDao(Conexao.conectar());
					
					
					Projeto p = new Projeto(id, nomeProjeto.getText(), u);
					pd.cadastrarProjeto(p);
					
				}
			});
		}
	
		
		/*
		public static void criaT(JButton botao, String apelido, JTextField nometarefa) {
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id = 0;
					
					UsuarioDao ud = new UsuarioDao(Conexao.conectar());
					Usuario u = ud.consultarUsuario(apelido);
					
					
					System.out.println("criando tarefa:" +apelido);
					TarefaDao td = new TarefaDao(Conexao.conectar());
					
					Tarefa t = new Tarefa(5000, u, EstadoTarefa.Pendente.estadoTarefa, nomeTarefa.getText(), "", 1;
					pd.cadastrarProjeto(p);
					
				}
			});
		}*/
		
	
	//M�TODO PARA A TROCA DE PAINEIS INTERNOS (projetos... configura��es...)
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
	
	
	//COMPONENTES GR�FICOS:
	public void composeVisaoGeral() {
		//VARI�VEIS DE CONTROLE INTERNO:
		int maxWidth = 800;
		int maxHeight = 600;
		int maxWidthPanels = maxWidth - (maxWidth/4);
		int maxHeightPanels = maxHeight - (maxHeight/4);
		
		
		//JFRAME:
		JFrame janela = new JFrame();
		janela.setResizable(false);
		//janela.setIconImage(Toolkit.getDefaultToolkit().getImage("logo/bee_square.png"));//
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setBounds(100, 100, maxWidth, maxHeight);
		janela.setLocationRelativeTo(null);
		
		
		//JPANEL PRINCIPAL:
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(bg[0], bg[1], bg[2]));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setLayout(null);
		janela.setContentPane(painelPrincipal);
		
		
		//BARRA DE NAVEGA��O (�cones e barra de pesquisa)
		JPanel navbar = new JPanel();
		navbar.setBounds(0, 0, maxWidth, 40);
		navbar.setBackground(new Color (bgNav[0], bgNav[1], bgNav[2]));
		painelPrincipal.add(navbar);
		navbar.setLayout(null);
		
		System.out.println(getApelido() +"na VISAO GERAL");
		
		JButton btnViewProjetos = new JButton();
		btnViewProjetos.setToolTipText("Listar projetos");
		btnViewProjetos.setForeground(Color.WHITE);
		btnViewProjetos.setBackground(null);
		btnViewProjetos.setBorderPainted(false);
		btnViewProjetos.setBounds(10, -2, 45, 45);
		btnViewProjetos.setIcon(new ImageIcon("icons/listProjects.png"));
		navbar.add(btnViewProjetos);
		
		JButton btnViewColab = new JButton("");
		btnViewColab.setToolTipText("Tarefas");
		btnViewColab.setForeground(Color.WHITE);
		btnViewColab.setBackground(null);
		btnViewColab.setBorderPainted(false);
		btnViewColab.setBounds(105, 0, 45, 45);
		btnViewColab.setIcon(new ImageIcon("icons/tarefas.png"));
		navbar.add(btnViewColab);

		JButton btnExtProfile = new JButton();
		btnExtProfile.setToolTipText("Acessar perfil");
		btnExtProfile.setForeground(Color.WHITE);
		btnExtProfile.setBorderPainted(false);
		btnExtProfile.setBounds(250, 0, 45, 45);
		btnExtProfile.setBackground(null);
		btnExtProfile.setIcon(new ImageIcon("icons/userProfile.png"));
		navbar.add(btnExtProfile);

		
		JButton btnPesquisa = new JButton();
		btnPesquisa.setToolTipText("Pesquisar tarfeas e projetos");
		btnPesquisa.setIcon(new ImageIcon("icons/search.png"));
		btnPesquisa.setForeground(Color.WHITE);
		btnPesquisa.setBorderPainted(false);
		btnPesquisa.setBackground(null);
		btnPesquisa.setBounds(510, 7, 30, 30);
		navbar.add(btnPesquisa);
		
		JButton btnViewChat = new JButton("");
		btnViewChat.setToolTipText("Mensagens");
		btnViewChat.setForeground(Color.WHITE);
		btnViewChat.setBorderPainted(false);
		btnViewChat.setBounds(644, 0, 45, 45);
		btnViewChat.setBackground(null);
		btnViewChat.setIcon(new ImageIcon("icons/message.png"));
		navbar.add(btnViewChat);
		
		JButton btnViewConfig = new JButton("");
		btnViewConfig.setToolTipText("Op��es");
		btnViewConfig.setForeground(Color.WHITE);
		btnViewConfig.setBackground(null);
		btnViewConfig.setBorderPainted(false);
		btnViewConfig.setBounds(739, 0, 45, 45);
		btnViewConfig.setIcon(new ImageIcon("icons/settings.png"));
		navbar.add(btnViewConfig);
		
		
		//JPANELs INTERNOS (visualiza��o de projetos... configura��oes e etc):
		//PAINEL DE PROJETOS:
		JPanel painelProjetos = new JPanel();
		painelProjetos.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelProjetos.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelProjetos.setForeground(Color.BLACK);
		painelProjetos.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		painelProjetos.setLayout(null);
		painelProjetos.setVisible(true);
		painelPrincipal.add(painelProjetos);
		
		JLabel lblProjetos = new JLabel("Meus Projetos");
		lblProjetos.setBounds(10, 11, maxWidthPanels, 40);
		lblProjetos.setForeground(Color.BLACK);
		lblProjetos.setFont(new Font("Tahoma", Font.BOLD, 30));
		painelProjetos.add(lblProjetos);
		
		if (getApelido().equals("Davi")) {
		
		//EXIBI��O DE PROJETOS
		ProjetoDao projectDao = new ProjetoDao(Conexao.conectar());
		ArrayList<Projeto> colecaoProjeto = new ArrayList<>();
		
		int posicao = 60;
		
		try {
			colecaoProjeto = projectDao.listarProjeto();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int x = 0 ; x < colecaoProjeto.size() ; x++ ) {
			JButton temp = new JButton(colecaoProjeto.get(x).getNomeProjeto());
			temp.setBounds(10, posicao + (x*30), 150, 25);
			temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			temp.setBackground(null);
			temp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			temp.setFont(new Font("Tahoma", Font.BOLD, 12));
			painelProjetos.add(temp);
		}
		}
		
		//ADICIONAR PROJETOS:
		JTextField txtAddProjetos = new JTextField();
		txtAddProjetos.setText("projeto");
		txtAddProjetos.setEnabled(true);
		txtAddProjetos.setBounds(350, 90, 200, 25);
		txtAddProjetos.setBorder(new LineBorder(Color.BLACK));
		painelProjetos.add(txtAddProjetos);
		
		//btn ADICIONAR PROJETOS
		JButton btnAlterar = new JButton();
		btnAlterar.setToolTipText("Confirmar altera��o de dados");
		btnAlterar.setText("Confirmar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(480, 120, 70, 20);
		btnAlterar.setBorder(new LineBorder(Color.WHITE, 1, true));
		painelProjetos.add(btnAlterar);
		
		atualiza(painelProjetos, btnAlterar);
		
		
		
		//PAINEL DE TAREFAS:
		JPanel painelTarefas = new JPanel();
		painelTarefas.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelTarefas.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelTarefas.setLayout(null);
		painelTarefas.setVisible(false);
		painelPrincipal.add(painelTarefas);
		
		JLabel lblCollab = new JLabel("Tarefas");
		lblCollab.setBounds(10, 11, maxWidthPanels, 40);
		lblCollab.setForeground(Color.BLACK);
		lblCollab.setFont(new Font("Tahoma", Font.BOLD, 30));
		painelTarefas.add(lblCollab);
		
		//Tenso
		if (getApelido().contentEquals("Davi")) {
		
		//EXIBI��O DE TAREFAS:
		TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
		ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();
		
		int p = 60;
		
		try {
			colecaoTarefa = tarefaDao.listarTarefas();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int x = 0 ; x < colecaoTarefa.size() ; x++ ) {
			JButton tempT = new JButton(colecaoTarefa.get(x).getTitulo());
			tempT.setBounds(10, p + (x*30), 150, 25);
			tempT.setCursor(new Cursor(Cursor.HAND_CURSOR));
			tempT.setBackground(null);
			tempT.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			tempT.setFont(new Font("Tahoma", Font.BOLD, 12));
			painelTarefas.add(tempT);
		}
		}
		//ADICIONAR PROJETOS:
		JTextField txtAddTarefas = new JTextField();
		txtAddTarefas.setText("tarefa");
		txtAddTarefas.setEnabled(true);
		txtAddTarefas.setBounds(350, 90, 200, 25);
		txtAddTarefas.setBorder(new LineBorder(Color.BLACK));
		painelTarefas.add(txtAddTarefas);
		
		//btn ADICIONAR PROJETOS
		JButton btnAlterarT = new JButton();
		btnAlterarT.setToolTipText("Confirmar altera��o de dados");
		btnAlterarT.setText("Confirmar");
		btnAlterarT.setForeground(Color.BLACK);
		btnAlterarT.setBackground(Color.WHITE);
		btnAlterarT.setBounds(480, 120, 70, 20);
		btnAlterarT.setBorder(new LineBorder(Color.WHITE, 1, true));
		painelTarefas.add(btnAlterarT);
		
		
		
		
		
		
		
		//PAINEL DE CONFIGURA��ES:
		JPanel painelConfig = new JPanel();
		painelConfig.setBounds(maxWidth/8, 80, maxWidthPanels, maxHeightPanels);
		painelConfig.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelConfig.setLayout(null);
		painelConfig.setVisible(false);
		painelPrincipal.add(painelConfig);
		
		JLabel lblConfig = new JLabel("Configura��es");
		lblConfig.setBounds(10, 11, maxWidthPanels, 40);
		lblConfig.setForeground(Color.BLACK);
		lblConfig.setFont(new Font("Tahoma", Font.BOLD, 30));
		painelConfig.add(lblConfig);
		
		JLabel lblDica1 = new JLabel("Alterar tema:");
		lblDica1.setBounds(30, 60, 120, 20);
		lblDica1.setForeground(Color.BLACK);
		lblDica1.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelConfig.add(lblDica1);
		
		JButton btnTemaAzul = new JButton("azul");
		btnTemaAzul.setToolTipText("Altera tema");
		btnTemaAzul.setForeground(Color.BLACK);
		btnTemaAzul.setBackground(null);
		btnTemaAzul.setBounds(160, 60, 70, 20);
		btnTemaAzul.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		painelConfig.add(btnTemaAzul);
		
		JButton btnTemaEscuro = new JButton("escuro");
		btnTemaEscuro.setToolTipText("Altera tema");
		btnTemaEscuro.setForeground(Color.BLACK);
		btnTemaEscuro.setBackground(null);
		btnTemaEscuro.setBounds(240, 60, 70, 20);
		btnTemaEscuro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		painelConfig.add(btnTemaEscuro);
		
		
		//ARRAYS DE CONTROLE:
		//JPanels internos para verifica��o de visibilidade
		JPanel arrayPaineis [] = {painelProjetos, painelTarefas, painelConfig};
		
		//JLabels internas para altera��o de tema
		JLabel arrayLabels [] = {lblProjetos, lblCollab, lblConfig, lblDica1};
		
		//JLabels internas para altera��o de tema
		JButton arrayButtons [] = {btnTemaAzul, btnTemaEscuro};
		
		//CHAMADA DE A��ES DE BOT�ES:
		
		//chamar janelas externas:
		chamarChat(btnViewChat);
		chamarExtProfile(btnExtProfile, getApelido());
		
		//troca de paineis:
		switchPanel(btnViewProjetos, arrayPaineis, painelProjetos);
		switchPanel(btnViewColab, arrayPaineis, painelTarefas);
		switchPanel(btnViewConfig, arrayPaineis, painelConfig);
		
		//troca de tema:
		switchTheme(btnTemaAzul, "azul", navbar, painelPrincipal, arrayPaineis, arrayLabels, arrayButtons);
		switchTheme(btnTemaEscuro, "escuro", navbar, painelPrincipal, arrayPaineis, arrayLabels, arrayButtons);
		
		
		//CRIA PROJETO
		criaProjeto(btnAlterar, apelido, txtAddProjetos);
		
		
		//CRIA T
		// /!\ criaT(btnAlterarT, apelido, txtAddTarefas);
		
		
		//----------------------
		//-- SET VISIBLE JFRAME:
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
		
		//CHAMADA DE COMPOSI��O DE TELA:
		VisaoGeral vg = new VisaoGeral();
		vg.composeVisaoGeral();
	}

	//<-------------------------ARRAYLIST DE PROJETOS (em andamento /!\) --------------------------->//

}
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
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modelos.*;
import utils.EstadoTarefa;
import utils.Prioridade;

/**
 * Tela de visão geral do projeto, interações com tarefas, mensagens e etc.
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
	
	//VARIÁVEIS DE CONTROLE DE TEMAS:
	//TEMA AZUL
	int bgBlueTheme [] = {212, 220, 229}; //{20, 162, 251};
	int bgNavBlueTheme [] = {63, 111, 163};
	int bgJpBlueTheme [] = {212, 220, 229};
	
	//TEMA ESCURO
	int bgDarkTheme [] = {50, 50, 50}; //{0, 0, 0};
	int bgNavDarkTheme [] = {20, 20, 20}; //{100, 100, 100};
	int bgJpDarkTheme [] = {50, 50, 50}; //{50, 50, 50};
			
	//TEMA DEFAULT (utilizado para substituição de valores)
	int bg [] = {bgBlueTheme[0], bgBlueTheme[1], bgBlueTheme[2]};
	int bgNav [] = {bgNavBlueTheme[0], bgNavBlueTheme[1], bgNavBlueTheme[2]};
	int bgJp [] = {bgJpBlueTheme[0], bgJpBlueTheme[1], bgJpBlueTheme[2]};

	//MÉTODO PARA TROCA DE TEMA:
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
						buttons [i].setBorder(new LineBorder(Color.BLACK, 1, true));
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


				//EXIBIÇÃO DE PROJETOS
				ProjetoDao projectDao = new ProjetoDao(Conexao.conectar());
				ArrayList<Projeto> colecaoProjeto = new ArrayList<>();
				
				int posicao = 60;
				
				try {
					colecaoProjeto = projectDao.listarProjeto(getApelido());	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				for (int x = 0 ; x < colecaoProjeto.size() ; x++ ) {
					JButton temp = new JButton(colecaoProjeto.get(x).getNomeProjeto());
					temp.setBounds(10, posicao + (x*30), 150, 25);
					temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
					temp.setBackground(null);
					temp.setBorder(new LineBorder(Color.BLACK, 1, true));
					temp.setFont(new Font("Tahoma", Font.BOLD, 12));
					painel.add(temp);
				}
				
				
				
			}
		});
	}
	
	public void atualizaT(JPanel painel, JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				//EXIBIÇÃO DE TAREFAS:
				TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
				ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();
				
				int p = 60;
				
				try {
					colecaoTarefa = tarefaDao.listarTarefas(getApelido());	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				for (int x = 0 ; x < colecaoTarefa.size() ; x++ ) {
					JButton tempT = new JButton(colecaoTarefa.get(x).getTitulo());
					tempT.setBounds(10, p + (x*30), 150, 25);
					tempT.setCursor(new Cursor(Cursor.HAND_CURSOR));
					tempT.setBackground(null);
					tempT.setBorder(new LineBorder(Color.BLACK, 1, true));
					tempT.setFont(new Font("Tahoma", Font.BOLD, 12));
					painel.add(tempT);
				}
				
				
				
			}
		});
	}
	
	
	
	//MÉTODO QUE CHAMA A TELA DE CHAT:
	public static void chamarChat(JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Chat().composeChat();
			}
		});
	}
	
	
	//MÉTODO QUE CHAMA A TELA DE PERFIL:
	public static void chamarExtProfile(JButton botao, String apelido) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("chamando o perfil de:"+apelido);
				Profile p = new Profile(apelido);
				
				p.composeProfile();
			}
		});
	}
	
	
	//MÉTODO QUE CRIA UM NOVO PROJETO:
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
	

	//MÉTODO QUE BUSCA TAREFAS DE ACORDO COM O PROJETO CLICADO:
	public static void consultaTarefas(JButton botao, String apelido) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nomeProjeto = botao.getText();
				
				JFrame janelaTarefas = new JFrame();
				janelaTarefas.setResizable(false);
				janelaTarefas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				janelaTarefas.setSize(400, 300);
				janelaTarefas.setLocationRelativeTo(null);
				
				JPanel painelTarefas  = new JPanel();
				painelTarefas.setBounds(0, 0, 400, 300);
				painelTarefas.setLayout(null);
				janelaTarefas.add(painelTarefas);
				painelTarefas.setVisible(true);
		
				TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
  				ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();				
  				
  				try {
					colecaoTarefa = tarefaDao.listarTarefas(apelido);	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
  				//
  				// MÉTODO DE CRIAR TAREFAS PRATICAMENTE PRONTO, FALTA PASSAR O NOME DO PROJETO SELECIONADO PARA CONSULTAR SOMENTE SUAS TAREFAS 
  				// E IMPLEMENTAR ISSO NO BOTAO "TEMPORARIO"
  				//
  				
  				Tarefa arrayTarefas []= new Tarefa[colecaoTarefa.size()] ;
				
				for (int x = 0 ; x < colecaoTarefa.size() ; x++ ) {
					arrayTarefas [x] = colecaoTarefa.get(x);
				}
				
				
				
				JList lista = new JList(arrayTarefas);
				painelTarefas.add(lista);
				
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
		
	
	//MÉTODO PARA A TROCA DE PAINEIS INTERNOS (projetos... configurações...)
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
	
	
	//COMPONENTES GRÁFICOS:
	public void composeVisaoGeral() {
		ProjetoDao projectDao = new ProjetoDao(Conexao.conectar());
		
		//INICIALIZANDO COMPONENTES
		//JFrame
		JFrame mainFrame = new JFrame();
		
		//JPanel
		
		//JButton
		JButton tempTasks = null;
		
		
		//JFRAME:
		
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 800, 600);
		mainFrame.setLocationRelativeTo(null);
		
		
		//JPANEL PRINCIPAL:
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(bg[0], bg[1], bg[2]));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setLayout(null);
		mainFrame.setContentPane(painelPrincipal);
		
		
		//BARRA DE NAVEGAÇÃO (ícones e barra de pesquisa)
		JPanel navbar = new JPanel();
		navbar.setBounds(0, 0, 800, 40);
		navbar.setBackground(new Color (bgNav[0], bgNav[1], bgNav[2]));
		painelPrincipal.add(navbar);
		navbar.setLayout(null);
		
		System.out.println(getApelido() +" na VISAO GERAL");
		
		JButton btnViewProjetos = new JButton();
		btnViewProjetos.setToolTipText("Listar projetos");
		btnViewProjetos.setForeground(Color.WHITE);
		btnViewProjetos.setBackground(null);
		btnViewProjetos.setBorderPainted(false);
		btnViewProjetos.setBounds(10, -2, 45, 45);
		btnViewProjetos.setIcon(new ImageIcon("icons/listProjects.png"));
		navbar.add(btnViewProjetos);
		
//		JButton btnViewColab = new JButton("");
//		btnViewColab.setToolTipText("Tarefas");
//		btnViewColab.setForeground(Color.WHITE);
//		btnViewColab.setBackground(null);
//		btnViewColab.setBorderPainted(false);
//		btnViewColab.setBounds(105, 0, 45, 45);
//		btnViewColab.setIcon(new ImageIcon("icons/tarefas.png"));
//		navbar.add(btnViewColab);

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
		btnViewConfig.setToolTipText("Opções");
		btnViewConfig.setForeground(Color.WHITE);
		btnViewConfig.setBackground(null);
		btnViewConfig.setBorderPainted(false);
		btnViewConfig.setBounds(739, 0, 45, 45);
		btnViewConfig.setIcon(new ImageIcon("icons/settings.png"));
		navbar.add(btnViewConfig);
		
		
		//JPANELs INTERNOS (visualização de projetos... configuraçãoes e etc):
		//PAINEL DE PROJETOS:
		JPanel painelProjetos = new JPanel();
		painelProjetos.setBounds(100, 80, 600, 450);
		painelProjetos.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelProjetos.setForeground(Color.BLACK);
		painelProjetos.setBorder(new LineBorder(Color.BLACK, 0, true));
		painelProjetos.setLayout(null);
		painelProjetos.setVisible(true);
		painelPrincipal.add(painelProjetos);
		
		JLabel lblProjetos = new JLabel("Meus Projetos");
		lblProjetos.setBounds(10, 11, 590, 40);
		lblProjetos.setForeground(Color.BLACK);
		lblProjetos.setFont(new Font("Tahoma", Font.BOLD, 30));
		painelProjetos.add(lblProjetos);
		//EXIBIÇÃO DE PROJETOS
		
		ArrayList<Projeto> colecaoProjeto = new ArrayList<>();
		
		try {
			colecaoProjeto = projectDao.listarProjeto(getApelido());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int x = 0 ; x < colecaoProjeto.size() ; x++ ) {
			JButton tempProject = new JButton(colecaoProjeto.get(x).getNomeProjeto());
			tempProject.setBounds(10, 60 + (x*30), 150, 25);
			tempProject.setCursor(new Cursor(Cursor.HAND_CURSOR));
			tempProject.setForeground(Color.WHITE);
			tempProject.setBackground(Color.GRAY);
			tempProject.setBorder(new LineBorder(Color.WHITE, 1, true));
			tempProject.setFont(new Font("Tahoma", Font.BOLD, 12));
			painelProjetos.add(tempProject);
		}
		
		//CAMPO DE TEXTO PARA ADICIONAR PROJETOS:
		JTextField txtAddProjetos = new JTextField();
		txtAddProjetos.setText("projeto");
		txtAddProjetos.setEnabled(true);
		txtAddProjetos.setBounds(350, 90, 200, 25);
		txtAddProjetos.setBorder(new LineBorder(Color.BLACK));
		painelProjetos.add(txtAddProjetos);
		
		//BOTÃO PARA ADICIONAR NOVOS PROJETOS
		JButton btnAddProjeto = new JButton();
		btnAddProjeto.setToolTipText("Adicionar novo projeto");
		btnAddProjeto.setText("Confirmar");
		btnAddProjeto.setForeground(Color.BLACK);
		btnAddProjeto.setBackground(Color.WHITE);
		btnAddProjeto.setBounds(480, 120, 70, 20);
		btnAddProjeto.setBorder(new LineBorder(Color.WHITE, 1, true));
		painelProjetos.add(btnAddProjeto);
		
		
		
		//PAINEL DE TAREFAS:
//		JPanel painelTarefas = new JPanel();
//		painelTarefas.setBounds(100, 80, 800, 600);
//		painelTarefas.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
//		painelTarefas.setLayout(null);
//		painelTarefas.setVisible(false);
//		painelPrincipal.add(painelTarefas);
		
//		JLabel lblCollab = new JLabel("Tarefas");
//		lblCollab.setBounds(10, 11, 800, 40);
//		lblCollab.setForeground(Color.BLACK);
//		lblCollab.setFont(new Font("Tahoma", Font.BOLD, 30));
//		painelTarefas.add(lblCollab);
		
//
//		
//		//EXIBIÇÃO DE TAREFAS:
//		TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
//		ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();
//		
//		int p = 60;
//		
//		try {
//			colecaoTarefa = tarefaDao.listarTarefas(getApelido());	
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		for (int x = 0 ; x < colecaoTarefa.size() ; x++ ) {
//			tempTasks = new JButton(colecaoTarefa.get(x).getTitulo());
//			tempTasks.setBounds(10, p + (x*30), 150, 25);
//			tempTasks.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			tempTasks.setBackground(null);
//			tempTasks.setBorder(new LineBorder(Color.BLACK, 1, true));
//			tempTasks.setFont(new Font("Tahoma", Font.BOLD, 12));
//			painelTarefas.add(tempTasks);
//		}
		//}
		
		//<-------------------------------------------------------------------------------------------------------------->
		
//		//ADICIONAR tarefas:
//		JTextField txtAddTarefas = new JTextField();
//		txtAddTarefas.setText("tarefa");
//		txtAddTarefas.setEnabled(true);
//		txtAddTarefas.setBounds(350, 90, 200, 25);
//		txtAddTarefas.setBorder(new LineBorder(Color.BLACK));
//		painelTarefas.add(txtAddTarefas);
//		
//		//btn ADICIONAR tarefas
//		JButton btnAlterarT = new JButton();
//		btnAlterarT.setToolTipText("Confirmar alteração de dados");
//		btnAlterarT.setText("Confirmar");
//		btnAlterarT.setForeground(Color.BLACK);
//		btnAlterarT.setBackground(Color.WHITE);
//		btnAlterarT.setBounds(480, 120, 70, 20);
//		btnAlterarT.setBorder(new LineBorder(Color.WHITE, 1, true));
//		painelTarefas.add(btnAlterarT);
		
		//<-------------------------------------------------------------------------------------------------------------->
		
		//PAINEL DE CONFIGURAÇÕES:
		JPanel painelConfig = new JPanel();
		painelConfig.setBounds(100, 80, 600, 450);
		painelConfig.setBackground(new Color(bgJp[0], bgJp[1], bgJp[2]));
		painelConfig.setLayout(null);
		painelConfig.setVisible(false);
		painelPrincipal.add(painelConfig);
		
		JLabel lblConfig = new JLabel("Configurações");
		lblConfig.setBounds(10, 11, 600, 40);
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
		btnTemaAzul.setBorder(new LineBorder(Color.BLACK, 1, true));
		painelConfig.add(btnTemaAzul);
		
		JButton btnTemaEscuro = new JButton("escuro");
		btnTemaEscuro.setToolTipText("Altera tema");
		btnTemaEscuro.setForeground(Color.BLACK);
		btnTemaEscuro.setBackground(null);
		btnTemaEscuro.setBounds(240, 60, 70, 20);
		btnTemaEscuro.setBorder(new LineBorder(Color.BLACK, 1, true));
		painelConfig.add(btnTemaEscuro);
		
		
		//ARRAYS DE CONTROLE:
		//JPanels internos para verificação de visibilidade
		JPanel arrayPaineis [] = {painelProjetos, painelConfig};
		
		//JLabels internas para alteração de tema
		JLabel arrayLabels [] = {lblProjetos, lblConfig, lblDica1};
		
		//JLabels internas para alteração de tema
		JButton arrayButtons [] = {btnTemaAzul, btnTemaEscuro};
		
		//CHAMADA DE AÇÕES DE BOTÕES:
		
		//chamar mainFrames externas:
		chamarChat(btnViewChat);
		chamarExtProfile(btnExtProfile, getApelido());
		
		//troca de paineis:
		switchPanel(btnViewProjetos, arrayPaineis, painelProjetos);
//		switchPanel(btnViewColab, arrayPaineis, painelTarefas);
		switchPanel(btnViewConfig, arrayPaineis, painelConfig);
		
		//troca de tema:
		switchTheme(btnTemaAzul, "azul", navbar, painelPrincipal, arrayPaineis, arrayLabels, arrayButtons);
		switchTheme(btnTemaEscuro, "escuro", navbar, painelPrincipal, arrayPaineis, arrayLabels, arrayButtons);
		
		
		//CRIA PROJETO
		criaProjeto(btnAddProjeto, apelido, txtAddProjetos);
		
//ainda em testes//		consultaTarefas(btnTempProjects, apelido);
		
		//ATUALIZA LISTA DE PROJETOS
		atualiza(painelProjetos, btnAddProjeto);
		
		
		//----------------------
		//-- SET VISIBLE JFRAME:
		mainFrame.setVisible(true);
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
		
		//CHAMADA DE COMPOSIÇÃO DE TELA:
		VisaoGeral vg = new VisaoGeral();
		vg.composeVisaoGeral();
	}

	//<-------------------------ARRAYLIST DE PROJETOS (em andamento /!\) --------------------------->//

}
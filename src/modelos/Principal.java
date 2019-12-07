package src.modelos;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import src.dao.Conexao;
import src.dao.MensagemDao;
import src.dao.TarefaDao;
import src.dao.UsuarioDao;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Principal {

	public static void main(String[] args) {
		

		/**
		 * @author Davi Fonseca
		 * Consultando Usuario
		 */

		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		//String foto = user
		
		
		// /!\ COLOCAR ISSO EM UM M�TODO
		
		
		//EXIBI��O:
		//FRAME DE TESTE:
		JFrame frame = new JFrame();
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		
		//JPANEL:
		JPanel painel = new JPanel();
		painel.setBackground(Color.WHITE);
		painel.setBounds(0, 0, 250, 250);
		painel.setLayout(null);
		frame.setContentPane(painel);
		
		//FOTO DO USUARIO:
		JButton lbFotoUsuario = new JButton();
		lbFotoUsuario.setBackground(Color.WHITE);
		//coleta da foto:
		try {
			if (resultado.getFoto() != null) {
				System.out.println("TEM IMAGEM");
				lbFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			} else {
				//Caso o usu�rio n�o tenha imagem, � definido uma padr�o:
				
				userDao.imagemRandomica();
				System.out.println("NAO TEM IMAGEM");
				lbFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			}
		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//restante da label:
		System.out.println(lbFotoUsuario.getIcon());
		lbFotoUsuario.setBounds(0, 0, 250, 250);
		painel.add(lbFotoUsuario);
		
		frame.setVisible(true);
		
		//LINHA DE COMANDO
		System.out.println("Apelido: " + resultado.getApelido());

		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Inserindo uma imagem:
		 */
/*
		try {
			//Usuario user = new Usuario("batata", "batata@ruffles.com", "4002-8922", "batBatata", "1231");
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			//teste.cadastrarUsuario(user);
			teste.armazenarImagens(new File("github.png"), "Bike");
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
*/
		//<----------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Criando uma Tarefa:
		 */
		/*
		Tarefa tarefa = new Tarefa (0, 1,"Bike", "Pendente", "Tarefa-Teste", "Prepara que agora tem tarefa");
		
		System.out.println("DAVI");
		
			TarefaDao teste = new TarefaDao(Conexao.conectar());
			teste.cadastrarTarefa(tarefa);
		*/
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Consultando uma Tarefa:
		 */
		/*TarefaDao teste = new TarefaDao(Conexao.conectar());
		Tarefa resultado = teste.consultarTarefa(1);
		
		System.out.println("Descricao: " + resultado.getDescricao());
		*/
		
		//<---------------------------------------------------------------------------------------------->
		/*
		//Teste da classe mensagem
		MensagemDao mensagemDao = new MensagemDao(Conexao.conectar());
		
		Mensagem mensagem = mensagemDao.consultarMensagem(1);
		
		mensagem.dhToString(mensagem.getDhEnvio());
		
		mensagem.dhToString(mensagem.getDhVisualizacao());
		*/
		
		//<---------------------------------------------------------------------------------------------->
		
		
	}
}
package modelos;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import dao.Conexao;
import dao.MensagemDao;
import dao.ProjetoDao;
import dao.TarefaDao;
import dao.UsuarioDao;
import utils.EstadoTarefa;
import utils.Prioridade;

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
		
		/*
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultadoUser = userDao.consultarUsuario("Bike");
		
		//LINHA DE COMANDO
		System.out.println("Apelido: " + resultadoUser.getApelido());
		*/
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Inserindo uma imagem:
		 */
		/*
		try {
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			teste.armazenarImagens(new File("logo/default250.png"), "Bike"); // /!\ - Problemas ! 
			System.out.println("Feito");
			
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
		TarefaDao tarefaDao = new TarefaDao(Conexao.conectar());
		ProjetoDao projetoDao = new ProjetoDao(Conexao.conectar());
		
		Projeto resultado = projetoDao.consultarProjeto(1);
		int consultaIdProjeto = resultado.getIdProjeto();
		//(int idTarefa, Usuario proprietario, EstadoTarefa estado, String titulo, String descricao, Prioridade prioridade)
		
		//Para cadastrar uma tarefa precisamos de um objeto do tipo Usuario, por isso usei o resultdo user já utilizado la em cima.
		Tarefa tarefaTeste = new Tarefa(0, resultadoUser, EstadoTarefa.Pendente, "Teste2", "TESTE-TESTE", Prioridade.Alta);
		tarefaDao.cadastrarTarefa(tarefaTeste, consultaIdProjeto);
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
		
		//Teste listarProjeto
		/*
		ProjetoDao projectDao = new ProjetoDao(Conexao.conectar());
		
		ArrayList<Projeto> colecaoProjeto = new ArrayList<>();
		
		try {
			
		colecaoProjeto = projectDao.listarProjeto();
		
		}catch (Exception e){
			
			e.printStackTrace();
			
		}
		
		for (int x = 0 ; x < colecaoProjeto.size() ; ++x ) {
			
			//System.out.println(colecaoProjeto.get(x));
			System.out.println((colecaoProjeto.get(x).getNomeProjeto()));
			System.out.println((colecaoProjeto.get(x).getIdProjeto()));
		}
		
		*/
		//<---------------------------------------------------------------------------------------------->
		
		//System.out.println("Teste");
		
		//<---------------------------------------------------------------------------------------------->
		
		
	}
}

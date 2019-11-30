package modelos;

import java.io.File;
import java.util.GregorianCalendar;

import dao.Conexao;
import dao.MensagemDao;
import dao.TarefaDao;
import dao.UsuarioDao;


public class Principal {

	public static void main(String[] args) {
		

		/**
		 * @author Davi Fonseca
		 * Consultando Usuario
		 */
		/*UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		System.out.println("Apelido: " + resultado.getApelido());
		System.out.println("Nome: " + resultado.getNome());
		*/
		
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Inserindo uma imagem:
		 */
		/*try {
			//Usuario user = new Usuario("batata", "batata@ruffles.com", "4002-8922", "batBatata", "1231");
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			//teste.cadastrarUsuario(user);
			teste.armazenarImagens(new File("github.png"), "Pikachu");
			teste.recuperarImagem("Bike");
			
		} catch (Exception e) {
			e.printStackTrace();	
		}*/
		
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Criando uma Tarefa:
		 */
		/**
		Tarefa tarefa = new Tarefa (0, 1,"Bike", "Pendente", "Tarefa-Teste", "Prepara que agora tem tarefa");
		
		System.out.println("DAVI");
		
			TarefaDao teste = new TarefaDao(Conexao.conectar());
			teste.cadastrarTarefa(tarefa);
		**/
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Consultando uma Tarefa:
		 */
		/*TarefaDao teste = new TarefaDao(Conexao.conectar());
		Tarefa resultado = teste.consultarTarefa(1);
		
		System.out.println("Descricao: " + resultado.getDescricao());
		*/
		
		//Teste da classe mensagem
		MensagemDao mensagemDao = new MensagemDao(Conexao.conectar());
		
		Mensagem mensagem = mensagemDao.consultarMensagem(1);
		
		mensagem.dhToString(mensagem.getDhEnvio());
		
		mensagem.dhToString(mensagem.getDhVisualizacao());
	}

}

package modelos;

import java.io.File;
import dao.Conexao;
import dao.TarefaDao;
import dao.UsuarioDao;


public class Principal {

	public static void main(String[] args) {
		

		/**
		 * @author Davi Fonseca
		 * Consultando Usuario
		 */
		/*UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
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
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			teste.armazenarImagens(new File("github.png"), "Bike");
			
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
		TarefaDao teste = new TarefaDao(Conexao.conectar());
		Tarefa resultado = teste.consultarTarefa(1);
		
		System.out.println("Descricao: " + resultado.getDescricao());
		
		

	}

}

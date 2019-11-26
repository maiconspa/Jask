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
<<<<<<< HEAD
		/*UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
=======
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
>>>>>>> branch 'master' of https://github.com/maiconspa/Jask
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		System.out.println("Apelido: " + resultado.getApelido());
		System.out.println("Nome: " + resultado.getNome());
<<<<<<< HEAD
		*/
=======
		
>>>>>>> branch 'master' of https://github.com/maiconspa/Jask
		
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Inserindo uma imagem:
		 */
<<<<<<< HEAD
		/*try {
=======
		try {
			//Usuario user = new Usuario("batata", "batata@ruffles.com", "4002-8922", "batBatata", "1231");
>>>>>>> branch 'master' of https://github.com/maiconspa/Jask
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
		TarefaDao teste = new TarefaDao(Conexao.conectar());
		Tarefa resultado = teste.consultarTarefa(1);
		
		System.out.println("Descricao: " + resultado.getDescricao());
		
		

	}

}

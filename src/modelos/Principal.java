package modelos;

import java.io.File;
import dao.Conexao;
import dao.UsuarioDao;
//import dao.TipoDAO;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * @author Davi Fonseca
		 * Consultando Usuario
		 */
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		System.out.println("Apelido: " + resultado.getApelido());
		System.out.println("Nome: " + resultado.getNome());
		
		
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		/**
		 * @author Davi Fonseca
		 * Inserindo uma imagem:
		 */
		try {
			//Usuario user = new Usuario("batata", "batata@ruffles.com", "4002-8922", "batBatata", "1231");
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			//teste.cadastrarUsuario(user);
			teste.armazenarImagens(new File("github.png"), "Pikachu");
			teste.recuperarImagem("Bike");
			
		} catch (Exception e) {
				e.printStackTrace();	
		}
		
		//<---------------------------------------------------------------------------------------------------------------------------->//
		
		
		
	}

}

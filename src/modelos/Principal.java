package modelos;

import java.io.File;

import dao.Conexao;
import dao.UsuarioDao;
//import dao.TipoDAO;

public class Principal {

	public static void main(String[] args) {
		
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		System.out.println("Apelido: " + resultado.getApelido());
		System.out.println("Nome: " + resultado.getNome());
		
		/**
		 * Inserindo uma imagem:
		 */
		/*try {
			UsuarioDao teste = new UsuarioDao(Conexao.conectar());
			teste.armazenarImagens(new File("github.png"), "Bike");
			
		} catch (Exception e) {
				e.printStackTrace();	
		}*/
		
	}

}

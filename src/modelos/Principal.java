package modelos;

import dao.Conexao;
import dao.UsuarioDao;
//import dao.TipoDAO;

public class Principal {

	public static void main(String[] args) {
		
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		System.out.println("Nome: " + resultado.getApelido());
				
	}

}

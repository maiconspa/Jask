package modelos;

import dao.Conexao;
//import dao.TipoDAO;

public class Principal {

	public static void main(String[] args) {
		
		Conexao.conectar();
		
		/*TipoDAO tipoDAO = new TipoDAO(Conexao.conectar());
		
		Tipo tipoPokemon = new Tipo(7, "Venenoso");
		
		tipoDAO.cadastrarTipo(tipoPokemon);
		
		System.out.println("Cadastrado com sucesso !");*/

	}

}

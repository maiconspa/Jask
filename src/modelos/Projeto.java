package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Conexao;


/**
 * Classe que representa um projeto
 * 
 * @author Davi Fonseca
 * @version 2.0
 * @since 1.0 -> desde qual versão esta classe está no projeto
 *
 */

public class Projeto {
	
	/**
	 * Atributo do tipo Int para armazenar o id									do Projeto.
	 */
	private int idProjeto;
	
	/**
	 * Atributo do tipo String pra armazenar o nome								do Projeto.
	 */
	private String nomeProjeto;
	
	/**
	 * Atributo do tipo String pra armazenar o apelido do proprietário			do Projeto
	 */
	private String apelidoProprietario; // /!\ --------------------------------------------> Verificar como fazer isso.
	
	/**
	 * Atributo do tipo ArrayList pra armazenar os usuarios participantes		do Projeto
	 */
	private ArrayList<Usuario> usuarios; // /!\ --------------------------------------------> Verificar como fazer isso.
										 // /!\ Como e um Array list não seria uma consulta apenas e nao um atributo ?
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criacao de um construtor vazio:
	 */
	public Projeto() {}
	
	/**
	 * Criacao de um contrutor cheio:
	 * 
	 * @param idProjeto				Armazena o ID						do Projeto
	 * @param nomeProjeto			Armazena o nome						do Projeto
	 * @param apelidoProprietario	Armazena o Apelido do Proprietario	do Projeto
	 * @param usuarios				Armazena os Usuarios atrelados	 	ao Projeto
	 */
	public Projeto(int idProjeto, String nomeProjeto, String apelidoProprietario, ArrayList<Usuario> usuarios) {
		this.idProjeto = idProjeto;
		this.nomeProjeto = nomeProjeto;
		this.usuarios = usuarios; // /!\ --------------------------------------------> Verificar como fazer isso.
								  // /!\ Como e um Array list e possivelmente uma consulta, aqui não devia ser criado um metodo
								  //     para exibição dos usários ?
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de retornos de consulta	(get)
	 *
	 */
	
	/**
	 * Retorna o ID do Projeto
	 * @return	this.idProjeto
	 */
	public int getIdProjeto() {
		return this.idProjeto;
	}
	
	/**
	 * Retorna o Nome do Projeto
	 * @return	this.nomeProjeto
	 */
	public String getNomeProjeto() {
		return this.nomeProjeto;
	}

	/**
	 * Retorna o Apelido do Proprietario do Projeto
	 * @return			   this.apelidoProprietario
	 */
	public String getApelidoProprietario() {
		return this.apelidoProprietario;
	}
	
	/**
	 * Retorna os Usuarios atrelados ao Projeto
	 * @return					  this.usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de metodos de alteracao	(set)
	 *
	 */
	
	/**
	 * Altera o ID do Projeto
	 * @param		idProjeto
	 */
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	
	/**
	 * Altera o Nome do Projeto
	 * @param		nomeProjeto
	 */
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
	/**
	 * Altera o Apelido do Proprieterio do Projeto
	 * @param 				   apelidoProprietario
	 */
	public void setApelidoProprietario(String apelidoProprietario) {
		this.apelidoProprietario = apelidoProprietario;
	}
	
	/**
	 * Aletra os Usuarios participantes do projeto
	 * @param usuarios
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	} // /!\ --------------------------------------------> Verificar como fazer isso.
	  // /!\ Por ser um Arraylist não deveria ter um metódo para alterar estes registros ?.
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
		/**
		 * Sobescrevendo o metodo toString:
		 */
		@Override
		public String toString() {
			return "Projeto{Id Projeto: " + this.idProjeto
					+ ", Nome: " + this.nomeProjeto
					+ ", Proprietário: " + this.apelidoProprietario
					+ ", Usuários: " + this.usuarios // /!\ --------------------------------------------> Verificar como fazer isso.
				   +"}";							 // /!\ Por ser um Arraylist não deveria ter um metódo para trazer está infomação ?
		}
		
		
		public ArrayList<Projeto> arrayProjeto(String nome) throws Exception {
			
			String select = "SELECT nome FROM Projeto";
			
			ArrayList<Projeto> pros = new ArrayList<>();
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(select);
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				
				Projeto pr = new Projeto();
				pr.setNomeProjeto(resultado.getString("nome"));
				
				pros.add(pr);
			}
			
			return pros;
		}
		
		
	
}

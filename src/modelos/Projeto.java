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
 * @since 1.0 -> desde qual vers�o esta classe est� no projeto
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
	 * Atributo do tipo String pra armazenar o apelido do propriet�rio			do Projeto
	 */
	private Usuario proprietario;
	
	/**
	 * Atributo do tipo ArrayList pra armazenar os usuarios participantes		do Projeto
	 */
	private ArrayList<Usuario> usuarios;  // /!\ lista de id de usu�rio join lista de usu�rios
								
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
	public Projeto(int idProjeto, String nomeProjeto, Usuario proprietario, ArrayList<Usuario> usuarios) {
		this.idProjeto = idProjeto;
		this.nomeProjeto = nomeProjeto;
		this.usuarios = usuarios; // /!\ Como e um Array list e possivelmente uma consulta, aqui n�o devia ser criado um metodo
								  //     para exibi��o dos us�rios ?
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Cria��o de retornos de consulta	(get)
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
	public Usuario getProprietario() {
		return this.proprietario;
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
	 * Cria��o de metodos de alteracao	(set)
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
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
	
	/**
	 * Aletra os Usuarios participantes do projeto
	 * @param usuarios
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	} // /!\ --------------------------------------------> Verificar como fazer isso.
	  // /!\ Por ser um Arraylist n�o deveria ter um met�do para alterar estes registros ?.
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
		/**
		 * Sobescrevendo o metodo toString:
		 */
		@Override
		public String toString() {
			return "Projeto{Id Projeto: " + this.idProjeto
					+ ", Nome: " + this.nomeProjeto
					+ ", Propriet�rio: " + this.proprietario
					+ ", Usu�rios: " + this.usuarios // /!\ --------------------------------------------> Verificar como fazer isso.
				   +"}";							 // /!\ Por ser um Arraylist n�o deveria ter um met�do para trazer est� infoma��o ?
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

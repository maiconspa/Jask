package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.modelos.Projeto;

/**
 * Classe DAO para o Projeto
 * 
 * @author Henrique Cayoni
 *
 */



public class ProjetoDao {

	private Connection conexao;
	
	public ProjetoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	
	/**
	 * Método de criação de um projeto
	 *@param projeto
	 * 
	 */
	
	public void cadastrarProjeto(Projeto projeto) {
	
		String inserir = "INSERT INTO Projeto(id_projeto, nomeProjeto, apelidoProprietario)"
				+ "VALUES (?, ?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setInt(1,		projeto.getIdProjeto());
			pst.setString(2,	projeto.getNomeProjeto());
			pst.setString(3,	projeto.getApelidoProprietario());
			
			//ATE AQUI SO FOI CRIADA a STRING da linha cadastrarUsuario
			
			/**
			 * Comando para executar a String no banco de dados
			 */
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			/**
			 * Tratando as excessoes
			 */
			
			ex.printStackTrace();
			
		}
		
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Metodos de consultas
	 * @param idProjeto
	 */
	
	public Projeto consultarProjeto(int idProjeto) {
		
		/**
		 * Criando a String de consulta
		 */
		
		String consulta = "SELECT * FROM Projeto WHERE id_projeto = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setInt(1, idProjeto);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/**
			 * 	Instanciando um objeto com valor nulo para preencimento com
			 *  base no retorno da consulta realizada.
			 */
			Projeto projeto = null;
			
			if (resultado.next()) {
				projeto = new Projeto();
				int id = resultado.getInt("id_projeto");
				String nome = resultado.getString("nome");
				String proprietario = resultado.getString("fk_apelido_proprietario");
			
				projeto.setIdProjeto(id);
				projeto.setNomeProjeto(nome);
				projeto.setApelidoProprietario(proprietario);
			
				return projeto;
		}
		
	} catch(SQLException ex) {
		
		/**
		 * Tratando as excessoes
		 */
		ex.printStackTrace();
		
	}
		
		return null;
	
	}
}

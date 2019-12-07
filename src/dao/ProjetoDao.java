package src.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
	 * M�todo de cria��o de um projeto
	 *@param projeto
	 * 
	 */
	
	public void cadastrarProjeto(Projeto projeto) {
	
		String inserir = "INSERT INTO Projeto(nomeProjeto, apelidoProprietario)"
				+ "VALUES (?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,	projeto.getNomeProjeto());
			pst.setString(2,	projeto.getApelidoProprietario());
			
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

	
	//<-------------------------------------------------------------------------->//
	
	public void atualizarProjeto(String projetoNome, String apelido) {
		
		//Preparando a String para atualiza��o:
		String atualizar = "UPDATE Projeto set nome =" + "? where fk_apelido_proprietario = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(atualizar)) {
			
			pst.setString(1, projetoNome);
			
			pst.setString(2, apelido);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
		
	}
	
	//<-------------------------------------------------------------------------->//
	
public void deletarProjeto(String projetoNome, String apelido) {
		
		//Preparando a String para atualiza��o:
		String deletar = "DELETE FROM Projeto where nome =" + "? where fk_apelido_proprietario = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deletar)) {
			
			pst.setString(1, projetoNome);
			
			pst.setString(2, apelido);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
		
	}

}


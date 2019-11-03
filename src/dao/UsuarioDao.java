package dao;

import java.security.KeyStore.ProtectionParameter;
import modelos.Usuario;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
	
	private Connection conexao;
	
	public UsuarioDao (Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		String inserir = "INSERT INTO Usuario(       INSERIR OS CAMPOS AQUI              )"
				+ "VALUES (            INSERIR OS CAMPOS AQUI                    )";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,usuario.getNome());
			pst.setString(2,usuario.getEmail());
			pst.setString(3,usuario.getTelefone());
			pst.setString(4,usuario.getApelido());
			pst.setString(5,usuario.getSenha());
			pst.setImage(6,usuario.getFoto());
			
			//ATE AQUI SO FOI CRIADA UMA STRING
			
			pst.execute();
			
			//EXECUTANDO O COMANDO
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Preparando a parte de consultas
	 * @param apelido
	 * @return
	 */
	
	
	public Usuario consultarUsuario(String apelido) {
		
		/**
		 * Criando a String de consulta
		 */
		
		String consulta = "SELECT * FROM Usuario WHERE apelido = '?'";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setString(1, apelido);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/**
			 * Perguntar ao professor --------------------------------------------------------------
			 */
			Usuario usuario = null;
			
			if (resultado.next()) {
				usuario = new Usuario();
				String apelidoUsuario = resultado.getString("apelido");
				/*-----------------------------nao sei o motivo da linha a baixo ter sido criada
				String nome = resultado.getString("nomeTipo");
				*/
				
				usuario.setApelido(apelidoUsuario);
				/*-----------------------------nao sei o motivo da linha a baixo ter sido criada
				 * usuario.setNomeTipo(nome);
				 */
				
				return usuario;
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
		
	}

}

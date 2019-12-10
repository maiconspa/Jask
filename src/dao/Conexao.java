package dao;
/**
 * Data Acess Object (DAO)
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Estabelece a conexao com o banco de dados
 */
public class Conexao {
	
	/**
	 * Devemos comecar com Static para nao haver a necessidade
	 * de instanciar um  objeto para esta classe deste modo e executado
	 * uma unica vez durante todo o programa.
	 * 
	 * O metodo statico a seguir tem como funcao encontrar o driver do mysql
	 */
	static {
		
		try {
			
			//System.out.println("Procurando driver..");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//System.out.println("Drive encontrado !");
			
		} catch (ClassNotFoundException ex) {

			//System.out.println("Driver NAO encontrado...");
			JOptionPane.showMessageDialog(null, "Driver N�O encontrado...", "Problemas !", JOptionPane.WARNING_MESSAGE);			
			
			/**imprime a pilha de erros "linhas vermelhas"**/
			ex.printStackTrace();
			
		}
		
	}
	
	/**
	 * Criando um metodo para realizar a conexao com o banco de dados.
	 */
	
	public static Connection conectar() {
		
		try {
	
			//System.out.println("Estabelecendo conex�o...");
			Connection c = null;
			
			c = DriverManager.getConnection("jdbc:mysql://localhost/jask?useSSL=false","root","");
			
			//System.out.println("Conex�o estabelecida com sucesso !");
			
			return c;
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Problemas na conexao com o Banco de dados.", "Erro !", JOptionPane.WARNING_MESSAGE);
			
			return null;
			
		}
			
	}
}

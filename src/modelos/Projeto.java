
package modelos;

import java.util.ArrayList;


/**
 * Classe que representa um usuario dentro do projeto
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
	private ArrayList<Usuario> usuario;

	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criacao de um construtor vazio:
	 */
	public Projeto() {}
	
	public Projeto(int idProjeto, ) {
		
	}
	
	
	
	
	
	
}

package modelos;

/**
 * Classe que representa uma tarefa dentro do projeto
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual versão esta classe está no projeto
 *
 */

public class Tarefa {
	
	/**
	 * Atributo do tipo int para armazenar o id					 da Tarefa
	 */
	private int idTarefa;
	
	/**
	 * Atributo do tipo int para armazenar o id do projeto desta 	Tarefa
	 * // /!\ --------------------------------------------> Verificar como fazer isso.
	 */
	private int idProjeto;
	
	/**
	 * Atributo do tipo String para armazenar o estado			  da Tarefa
	 */
	private String estado;
	
	/**
	 * Atributo do tipo String para armazenar o titulo			  da Tarefa
	 */
	private String titulo;
	
	/**
	 *  Atributo do tipo String para armazenar a descricao		  da Tarefa
	 */
	private String descricao;
	
	//<---------------------------------------------------------------------------------------------------------------------------->//

	/**
	 * Criacao de um construtor vazio:
	 */
	public Tarefa() {}
		
	//<---------------------------------------------------------------------------------------------------------------------------->//

	/**
	 * Criacao de um contrutor cheio
	 * @param idTarefa		Armazena o id da 		Tarefa
	 * @param idProjeto		Armazena o id do Porjeto que está tarefa pertence
	 * @param estado		Armazena o estado da 	Tarefa (do, to do, concluida)
	 * @param titulo		Armazena o titulo da 	Tarefa
	 * @param descricao		Armazena a descricao da Tarefa
	 */
	public Tarefa(int idTarefa, int idProjeto, String estado, String titulo, String descricao) {
		this.idTarefa = idTarefa;
		this.idProjeto = idProjeto; // /!\ --------------------------------------------> Verificar como fazer isso.
		this.estado = estado;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de retornos de consulta	(get)
	 *
	 */
	
	/**
	 * Retorna o ID			da Tarefa
	 * @return	this.idTarefa
	 */
	public int getIdTarefa() {
		return this.idTarefa;
	}
	
	/**
	 * Retorna o ID 		da Tarefa
	 * @return	this.idProjeto
	 */
	public int getIdProjeto() {
		return this.idProjeto;
	}
	
	/**
	 * Retorna o estado		da Tarefa
	 * @return	this.estado
	 */
	public String getEstado() {
		return this.estado;
	}
	
	/**
	 * Retorna o titulo		da Tarefa
	 * @return	this.titulo
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Retorna o descricao 	da Tarefa
	 * @return	this.descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de metodos de alteracao	(set)
	 *
	 */
	
	/**
	 * Altera o ID da Tarefa
	 * @param idTarefa
	 */
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	/**
	 * Altera o ID do Projeto ao Qual a Tarefa esta associada
	 * @param idProjeto
	 */
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Tarefa{Id Tarefa:"	+ this.idTarefa
				+ ", Id Projeto:"	+ this.idProjeto
				+ ", Estado:"		+ this.estado
				+ ", Titulo:"		+ this.titulo
			   +"}";
	}
	
}

	
	
	
	

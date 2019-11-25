package modelos;

/**
 * Representa mensagem no projeto
 * 
 * @author Maicon Souza
 * @version 2.0
 * @since 1.0
 *
 */
public class Mensagem {
    // Composicao:
    /**
     * Composicao da classe Usuario
     */
    Usuario u = new Usuario();
    
    
    // Atributos:
    /**
     * id da mensagem
     */
    private int id;
    
	/**
     * apelido do destinatário
     */
    private String apelidoDestinatario;
    
    /**
     * apelido do remetente
     */
    private String apelidoRemetente;
    
    /**
     * corpo da mensagem
     */
    private String texto;
    
    /**
     * data e hora de envio
     */
    private String dhEnvio;
    
    /**
     * data e hora de visualizacaoo
     */
    private String dhVisualizacao;
    
    /**
     * estado de visualização
     */
    private boolean estadoVisualizacao;
    
    
    // Construtores:
    /**
     * @param int id
     * @param String texto
     * @param String dhEnvio
     * @param String dhVisualizacao
     * @param String dhRecebimento
     * @param boolean estadoVisualizacao
     */
    public Mensagem(int id, String texto, String dhEnvio, String dhVisualizacao, boolean estadoVisualizacao) {
        this.id = id;
        this.texto = texto;
        this.dhEnvio = dhEnvio;
        this.dhVisualizacao = dhVisualizacao;
        this.estadoVisualizacao = estadoVisualizacao;
    }
    
    
    // Getters e setters:
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getApelidoRemetente() {
		return apelidoRemetente;
	}

	public void setApelidoRemetente(String apelidoRemetente) {
		this.apelidoRemetente = apelidoRemetente;
	}

	public String getApelidoDestinatario() {
		return apelidoDestinatario;
	}

	public void setApelidoDestinatario(String apelidoDestinatario) {
		this.apelidoDestinatario = apelidoDestinatario;
	}
    
    public String getTexto() {
        return this.texto;
    }
    public void setTexto(String texto) {
        this.texto = texto; 
    }
    
    public String getDhEnvio() {
        return this.dhEnvio;
    }
    public void setDhEnvio(String dhEnvio) {
        this.dhEnvio = dhEnvio;
    }
    
    public String getDhVisualizacao() {
        return this.dhVisualizacao;
    }
    public void setDhVisualizacao(String dhVisualizacao) {
        this.dhVisualizacao = dhVisualizacao;
    }
    
    public boolean getEstadoVisualizacao() {
        return this.estadoVisualizacao;
    }
    public void setEstadoVisualizacao(boolean estadoVisualizacao) {
        this.estadoVisualizacao = estadoVisualizacao;
    }  
}

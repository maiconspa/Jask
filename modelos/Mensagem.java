package modelos;
import java.util.GregorianCalendar;
import java.sql.Date;

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
    private GregorianCalendar dhEnvio;
    
    /**
     * data e hora de visualizacaoo
     */
    private GregorianCalendar dhVisualizacao;
    
    /**
     * estado de visualização
     */
    private String estadoVisualizacao;
    
    
    // Construtores:
    /**
     * Construtor vazio
     */
    public Mensagem() {}
    /**
     * @param int id
     * @param String texto
     * @param String dhEnvio
     * @param String dhVisualizacao
     * @param String dhRecebimento
     * @param boolean estadoVisualizacao
     */
    public Mensagem(int id, String texto, GregorianCalendar dhEnvio, GregorianCalendar dhVisualizacao, String estadoVisualizacao) {
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
    public GregorianCalendar getDhEnvio() {
        return this.dhEnvio;
    }
    public void setDhEnvio(GregorianCalendar dhEnvio) {
        this.dhEnvio = dhEnvio;
    }
    public GregorianCalendar getDhVisualizacao() {
        return this.dhVisualizacao;
    }
    public void setDhVisualizacao(GregorianCalendar dhVisualizacao) {
        this.dhVisualizacao = dhVisualizacao;
    }
    public String getEstadoVisualizacao() {
        return this.estadoVisualizacao;
    }
    public void setEstadoVisualizacao(String estadoVisualizacao) {
        this.estadoVisualizacao = estadoVisualizacao;
    }
    
    //<----------------------------------------------------------------------->//
    public java.sql.Date convertSqlDate(GregorianCalendar gc) {
    	gc.set(GregorianCalendar.YEAR, 2017);
    	
    	// Convertendo para java.util.Date:
		java.util.Date dataUtil = new java.util.Date();
		dataUtil.setTime(gc.getTimeInMillis());
    	
		// Convertendo para java.sql.Date:
		java.sql.Date dataSql = new java.sql.Date(gc.getTimeInMillis());
		
		return dataSql;
    }
}

//@Override






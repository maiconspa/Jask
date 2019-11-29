package modelos;
import java.util.GregorianCalendar;

/**
 * Manipulação de mensagens
 * 
 * @author Maicon Souza
 * @version 3.0
 * @since 1.0
 *
 */
public class Mensagem {
    // Composicao da classe Usuario:
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
     * default
     */
    public Mensagem() {}
    
    /**
     * 
     * @param id
     * @param texto
     * @param dhEnvio
     * @param dhVisualizacao
     * @param estadoVisualizacao
     */
    public Mensagem(int id, String texto, GregorianCalendar dhEnvio, GregorianCalendar dhVisualizacao, String estadoVisualizacao) {
        this.id = id;
        this.texto = texto;
        this.dhEnvio = dhEnvio;
        this.dhVisualizacao = dhVisualizacao;
        this.estadoVisualizacao = estadoVisualizacao;
    }


    //Getters:
    public int getId() {
        return this.id;
    }    
    public String getApelidoRemetente() {
		return apelidoRemetente;
	}
	public String getApelidoDestinatario() {
		return apelidoDestinatario;
	}
    public String getTexto() {
        return this.texto;
    }
    public GregorianCalendar getDhEnvio() {
        return this.dhEnvio;
    }
    public GregorianCalendar getDhVisualizacao() {
        return this.dhVisualizacao;
    }
    public String getEstadoVisualizacao() {
        return this.estadoVisualizacao;
    }

   
    //Setters:
    public void setId(int id) {
        this.id = id;
    }
	public void setApelidoRemetente(String apelidoRemetente) {
		this.apelidoRemetente = apelidoRemetente;
	}
	public void setApelidoDestinatario(String apelidoDestinatario) {
		this.apelidoDestinatario = apelidoDestinatario;
	}
    public void setTexto(String texto) {
        this.texto = texto; 
    }
    public void setDhEnvio(GregorianCalendar dhEnvio) {
        this.dhEnvio = dhEnvio;
    }
    public void setDhVisualizacao(GregorianCalendar dhVisualizacao) {
        this.dhVisualizacao = dhVisualizacao;
    }
    public void setEstadoVisualizacao(String estadoVisualizacao) {
        this.estadoVisualizacao = estadoVisualizacao;
    }
    
    /**
     * @param gc data coletada do sistema no formato GregorianCalendar
     * @return dataSql uma data formatada em java.sql.Date 
     */
    public java.sql.Date toSqlDate(GregorianCalendar gc) {
    	gc.set(GregorianCalendar.YEAR, 2017);
    	
		java.util.Date dataUtil = new java.util.Date();
		dataUtil.setTime(gc.getTimeInMillis());
    	
		java.sql.Date dataSql = new java.sql.Date(gc.getTimeInMillis());
		
		return dataSql;
    }
}
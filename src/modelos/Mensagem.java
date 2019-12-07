package src.modelos;
import java.util.GregorianCalendar;

/**
 * Manipulação de mensagens
 * 
 * @author Maicon Souza
 * @version 4.0
 * @since 1.0
 *
 */
public class Mensagem {
    // Composicao da classe Usuario:
    Usuario u = new Usuario(); // /!\ verificar se tem REALMENTE importancia, pois não está sendo utilizado e uma vez removida, não retorna erro.
    
    // Atributos:
    private int id;
    private String apelidoDestinatario;
    private String apelidoRemetente;
    private String texto;
    private GregorianCalendar dhEnvio;
    private GregorianCalendar dhVisualizacao;
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
    
    
    //Métodos conversores de dados:
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
    
    /**
     * 
     * @param valorSql data coletada do banco de dados
     * @return data em formato GregorianCalendar
     */
    public GregorianCalendar toGregorian(java.sql.Date valorSql) {
    	GregorianCalendar valorGregorian = new GregorianCalendar();
    	valorGregorian.setTimeInMillis(valorSql.getTime());
    	
    	return valorGregorian;
    }
    
    /**
     * 
     * @param objetoGc
     */
    public void dhToString(GregorianCalendar objetoGc) {
    	int dia = objetoGc.get(GregorianCalendar.DAY_OF_MONTH);
    	// Soma-se 1 ao valor obtido por esse ser zero based.
    	int mes = objetoGc.get(GregorianCalendar.MONTH) + 1;
    	int ano = objetoGc.get(GregorianCalendar.YEAR);
    	
    	System.out.printf("%d/%d/%d", dia, mes, ano);
    }
    
    
}
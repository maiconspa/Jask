
/**
 * Processa mensagem entre usuários
 */
public class Mensagem
{
    // Composição:
    /**
     * Composição da classe Usuario
     */
    Usuario u = new Usuario();
    
    
    // Atributos:
    private String remetente = u.getApelido();
    private String destinatario = u.getApelido(); // /!\ Verificar como diferenciar remetente e destinatario.
    
    /**
     * id da mensagem
     */
    private int id;
    /**
     * corpo da mensagem
     */
    private String texto;
    /**
     * data e hora de envio
     */
    private String dhSend;
    /**
     * data e hora de visualização
     */
    private String dhView;
    /**
     * data e hora de recebimento
     */
    private String dhRecept;
    /**
     * estado de visualização
     */
    private boolean viewState;
    
    
    // Construtor:
    
    /**
     * @param int id
     * @param String texto
     * @param String dhSend
     * @param String dhView
     * @param String dhRecept
     * @param boolean viewState
     */
    public Mensagem(int id, String texto, String dhSend, String dhView, String dhRecept, boolean viewState) {
        this.id = id;
        this.texto = texto;
        this.dhSend = dhSend;
        this.dhView = dhView;
        this.dhRecept = dhRecept;
        this.viewState = viewState;
    }
    
    
    // Getters e setters:
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTexto() {
        return this.texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getDhSend() {
        return this.dhSend;
    }
    public void setDhSend(String dhSend) {
        this.dhSend = dhSend;
    }
    
    public String getDhView() {
        return this.dhView;
    }
    public void setDhView(String dhView) {
        this.dhView = dhView;
    }
    
    public String getDhRecept() {
        return this.dhRecept;
    }
    public void setDhRecept(String dhRecept) {
        this.dhRecept = dhRecept;
    }
    
    public boolean getViewState() {
        return this.viewState;
    }
    public void setViewState(boolean viewState) {
        this.viewState = viewState;
    }  
}

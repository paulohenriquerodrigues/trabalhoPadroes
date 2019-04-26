package Model;

import java.io.Serializable;

/**
 *
 * @author paulohenrique
 */
public class Mensagem implements Serializable{
    private static final long serialVersionUID = 7526472295622776145L;
    
    private MensagemTipo type;
    private Object message;

    public Mensagem(MensagemTipo type, Object message) {
        this.type = type;
        this.message = message;
    }

    public MensagemTipo getType() {
        return type;
    }

    public Object getMessage() {
        return message;
    }  
    
    
}

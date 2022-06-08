
package excecoes;

/**
 *
 * @author thiag
 */
public class QuantidadeException extends Exception{
    
    public QuantidadeException(){
    
        super("ALERTA: O valor da quantidade passado é invalido");
    }
}

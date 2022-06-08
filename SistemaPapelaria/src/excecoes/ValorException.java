
package excecoes;
/**
 *
 * @author thiag
 */
public class ValorException extends Exception{
    
    public ValorException(){
    
        super("ALERTA: O valor passado é invalido");
    }
}

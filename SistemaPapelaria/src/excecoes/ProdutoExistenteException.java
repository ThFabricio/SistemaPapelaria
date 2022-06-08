
package excecoes;
/**
 *
 * @author thiag
 */
public class ProdutoExistenteException extends Exception{
    
    public ProdutoExistenteException(){
    
        super("ALERTA: O produto a ser adicionado já é existente");

    }
    
}

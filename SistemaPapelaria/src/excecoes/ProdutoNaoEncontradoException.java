
package excecoes;
/**
 *
 * @author thiag
 */
public class ProdutoNaoEncontradoException extends Exception{
    
    public ProdutoNaoEncontradoException(){
    
        super("ALERTA: O produto procurado não foi encontrado");
    }
    
}

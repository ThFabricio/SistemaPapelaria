
package basico;

import excecoes.QuantidadeException;
import excecoes.ValorException;

/**
 *
 * @author thiag
 */
public interface IAtualizarPreco {
    
    public void atualizarPreço(double valor) throws ValorException;
    
}

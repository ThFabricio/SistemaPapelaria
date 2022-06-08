package basico;

import excecoes.QuantidadeException;
import excecoes.ValorException;

/**
 *
 * @author thiag
 */
public interface IAtualizarQuantidade {
    
    public void atualizarQuantidade(double quantidade) throws QuantidadeException;
    
}

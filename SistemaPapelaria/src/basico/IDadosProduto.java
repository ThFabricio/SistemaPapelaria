package basico;

import excecoes.QuantidadeException;
import excecoes.ValorException;

/**
 *
 * @author thiag
 */
public interface IDadosProduto {
    
    public void dadosProduto(double valor, double quantidade) throws QuantidadeException, ValorException;
    
    public void atualizarNome(String nome);
           
    
    
}

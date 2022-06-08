
package basico;

import excecoes.QuantidadeException;
import excecoes.ValorException;
import java.io.Serializable;

/**
 *
 * @author thiag
 */
public class ProdutoUnitario extends ProdutoAbstrato implements IDadosProduto, Serializable, IAtualizacoes{
    
    public ProdutoUnitario(String nome){
    
        super(nome);
    }
    
    @Override
    public void dadosProduto(double valor, double quantidade) throws QuantidadeException, ValorException{
    
        
        int aux = (int) quantidade;
        
        if((quantidade-aux) == 0 && quantidade >= 0){
        
            setQuantidade(quantidade);
            
            if(valor >= 0){
            
                setValor(valor);
            }
            else{
                
                throw new ValorException();
            }
        }
        else{
        
            throw new QuantidadeException();
        }
    }
    
    @Override
    public void atualizarNome(String nome){
    
        setNome(nome);
    }
            
    @Override
    public void atualizarQuantidade(double quantidade) throws QuantidadeException{
    
        int aux = (int) quantidade;
        
        if((quantidade-aux) == 0 && quantidade >= 0){
        
            setQuantidade(quantidade);
        }
        else{
        
            throw new QuantidadeException();
        }
    
    }
    
    @Override
    public void atualizarPreço(double valor) throws ValorException{
    
        if(valor >= 0){
            
                setValor(valor);
            }
            else{
                
                throw new ValorException();
            }
    }
    
    @Override
    public String toString(){
    
        return "Produto - ID: "+getID()+"\n"+
                "Nome: "+getNome()+"\n"+
                "Quantidade: "+getQuantidade()+" unidades\n"+
                "Valor: R$ "+getValor()+"\n";
    }
    
    
}

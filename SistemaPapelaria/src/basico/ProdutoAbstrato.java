
package basico;

import java.io.Serializable;

/**
 *
 * @author thiag
 */
public abstract class ProdutoAbstrato implements IProduto, Serializable{
    
    private String nome;
    private double quantidade;
    private double valor;
    private int id;

    public ProdutoAbstrato(String nome){
    
        this.nome = nome;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public int getID(){
        
        return id;
    }
    
    @Override
    public void setID(int id){
        this.id = id;
    }
    
    
     
}

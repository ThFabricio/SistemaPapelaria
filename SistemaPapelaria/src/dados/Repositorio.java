
package dados;

import java.io.Serializable;
import basico.ProdutoAbstrato;
import basico.IProduto;
import excecoes.ProdutoNaoEncontradoException;
import excecoes.ProdutoExistenteException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/**
 *
 * @author thiag
 */

public class Repositorio implements Serializable{
    
    ArrayList<IProduto> repositorio = new ArrayList();
    int idCont = 0;
    
    public void adicionar(IProduto produto){
    
        produto.setID(this.idCont);
        this.repositorio.add(produto);
        ++this.idCont;
    }
    
    public void remover(int id) throws ProdutoNaoEncontradoException{
    
        if(id <= idCont){
        
            Iterator aux = this.repositorio.iterator();
        
            while(aux.hasNext()){

                IProduto inter = (IProduto) aux.next();
                inter.setID(inter.getID()-1);
            }

            if(id != 0){
            
                this.repositorio.remove(id-1);
                --this.idCont;
            }else{
            
                this.repositorio.remove(id);
                --this.idCont;
            }
            
        
        }else{
        
            throw new ProdutoNaoEncontradoException();
        }
        
    }
    
    public IProduto procura(int id) throws ProdutoNaoEncontradoException{
    
        Iterator aux = this.repositorio.iterator();
        
        while(aux.hasNext()){
        
            IProduto inter = (IProduto) aux.next();
            if(inter.getID()== id){
            
                return inter;
            }
        }
        
        throw new ProdutoNaoEncontradoException();
    }
    
    public int ultimoID(){
        
        return this.idCont;
    }
    
    public void editarProduto(IProduto produto){
    
        
        
        Iterator aux = this.repositorio.iterator();

        while(aux.hasNext()){

            IProduto inter = (IProduto) aux.next();
            
            if(inter.getID()== produto.getID()){
            
                inter = (IProduto) produto;
            }
        }
       
    }
    
    
    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        
        FileOutputStream file = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(this);
        os.close();
    
    }
    
    public static Repositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException{
    
        FileInputStream file = new FileInputStream(caminhoArquivo);
        ObjectInputStream is = new ObjectInputStream(file);
        Repositorio resp = (Repositorio) is.readObject();
        is.close();
        return resp;
    }
    
}

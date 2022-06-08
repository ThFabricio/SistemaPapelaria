
package GUI;
import basico.IDadosProduto;
import java.util.Scanner;
import dados.Repositorio;
import java.io.IOException;
import basico.IProduto;
import excecoes.ProdutoNaoEncontradoException;
import basico.ProdutoPeso;
import basico.ProdutoUnitario;
import excecoes.QuantidadeException;
import excecoes.ValorException;
import basico.ProdutoAbstrato;

/**
 *
 * @author thiag
 */
public class Main {
    
    static final String opcoes = "Digite qual operação vocês quer realizar:\n1 - Consultar Produto.\n2 - Cadastrar Produto.\n3 - Mostrar todos os produtos.\n4 - Remover Produto\n5 - Editar Produto\n6 - Venda de Produto\n7 - sair.";
    
    
    public static void main(String[] args) {
        
        boolean continuar = true;
        
        Scanner sc = new Scanner(System.in);
        
        Repositorio repositorio = null;
        
        String arquivoRepositorio = "./repositorio.teste";
        
        try {
            repositorio = Repositorio.carregarRepositorio(arquivoRepositorio);
            
        } catch (IOException abriRep1) {
            
            System.out.println("Não foi possível carregar o repositório.");
            repositorio = new Repositorio();
            
        } catch (ClassNotFoundException abriRep2) {
            
            abriRep2.printStackTrace();
        }
        
        while(true) {
            while(continuar) {
                
                System.out.println(opcoes);
                
                int leitura = sc.nextInt();
                
                String leituraNome;
                double leituraQuantidade;
                double leituraValor;
                int leituraID;
                
                if (leitura == 1) {
                    
                    System.out.println("Digite o ID do item a ser consultado:");
                    leituraID = sc.nextInt();
                    

                    try {
                        
                        IProduto resp = repositorio.procura(leituraID);
                        System.out.println(resp);
                        
                    } catch (ProdutoNaoEncontradoException produtoInexistente1) {
                        
                        System.out.println(produtoInexistente1.getMessage());
                    }
                    
                } else if (leitura == 2) {
                    
                    System.out.println("Produto a ser Cadastrado\n1 - Produto Unitario\n2 - Produto Peso");
                    
                    leitura = sc.nextInt();
                    
                    if(leitura == 1){
                    
                        System.out.println("Digite o nome do Produto:");
                        leituraNome = sc.next();

                        System.out.println("Digite a quantidade unitaria do produto:");
                        leituraQuantidade = sc.nextDouble();
                        
                        System.out.println("Digite a valor do produto:");
                        leituraValor = sc.nextDouble();

                        ProdutoUnitario produto = new ProdutoUnitario(leituraNome);
                        
                        try{
                        
                            produto.dadosProduto(leituraValor, leituraQuantidade);
                            repositorio.adicionar(produto);
                        
                        }
                        catch(QuantidadeException quantidadeValidacao1){
                        
                            System.out.println(quantidadeValidacao1.getMessage());
                        }
                        catch(ValorException valorValidacao1){
                        
                            System.out.println(valorValidacao1.getMessage());
                        }
                        

                        try {
                            
                            repositorio.salvarRepositorio(arquivoRepositorio);
                            
                        } catch (IOException var13) {
                            
                            var13.printStackTrace();
                            System.out.println("Não foi possível salvar o arquivo.");
                        }
                    }
                    else if(leitura == 2){
                    
                        System.out.println("Digite o nome do Produto:");
                        leituraNome = sc.next();

                        System.out.println("Digite a quantidade do produto:");
                        leituraQuantidade = sc.nextDouble();
                        
                        System.out.println("Digite a valor do produto:");
                        leituraValor = sc.nextDouble();

                        ProdutoPeso produto = new ProdutoPeso(leituraNome);
                        
                        try{
                        
                            produto.dadosProduto(leituraValor, leituraQuantidade);
                            repositorio.adicionar(produto);
                        
                        }
                        catch(QuantidadeException quantidadeValidacao1){
                        
                            System.out.println(quantidadeValidacao1.getMessage());
                        }
                        catch(ValorException valorValidacao1){
                        
                            System.out.println(valorValidacao1.getMessage());
                        }

                        try {
                            
                            repositorio.salvarRepositorio(arquivoRepositorio);
                            
                        } catch (IOException var13) {
                            
                            var13.printStackTrace();
                            System.out.println("Não foi possível salvar o arquivo.");
                        }
                    
                    }
                    
                    
                } else if (leitura == 3) {
                    
                    System.out.println("TODOS OS ITENS DO REPOSITÓRIO:");

                    for(int i = 0; i < repositorio.ultimoID(); ++i) {
                        
                        try {
                            
                            IProduto a = repositorio.procura(i);
                            System.out.println(a.toString());
                            
                        } catch (ProdutoNaoEncontradoException var12) {
                            
                            System.out.println("Não foi encontrado item com ID " + i);
                        }
                    }
                    
                } else if (leitura == 4){
                
                    System.out.println("Digite o ID do item a ser removido:");
                    leituraID = sc.nextInt();
            
                    try{
                    
                        repositorio.remover(leituraID);
                        
                    }catch(ProdutoNaoEncontradoException produtoNaoExiste){
                    
                        System.out.println(produtoNaoExiste.getMessage());
                    }
                    
                    try {
                            
                        repositorio.salvarRepositorio(arquivoRepositorio);

                    } catch (IOException var13) {

                        var13.printStackTrace();
                        System.out.println("Não foi possível salvar o arquivo.");
                    }
                        
                    
                    
                }else if (leitura == 5){
                
                    System.out.println("Digite o tipo de produto que sera editado\n1 - Produto Unitario\n2 - Produto Peso");
                    leitura = sc.nextInt();
                    
                    if(leitura == 1){
                    
                        System.out.println("Digite o ID do item a ser consultado:");
                        leituraID = sc.nextInt();

                        ProdutoUnitario produtoEditado = null;
                        
                        try {

                            IProduto resp = repositorio.procura(leituraID);
                            System.out.println(resp);
                            produtoEditado = (ProdutoUnitario) resp;
                            
                            System.out.println("Deseja altera o nome do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite novo nome do Produto");
                                leituraNome = sc.next();

                                produtoEditado.atualizarNome(leituraNome);

                            }

                            System.out.println("Deseja altera a quantidade do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite a nova quantidade do Produto");
                                leituraQuantidade = sc.nextDouble();

                                try{

                                    produtoEditado.atualizarQuantidade(leituraQuantidade);
                                }
                                catch(QuantidadeException quantidadeInvalida2){

                                    System.out.println(quantidadeInvalida2.getMessage());
                                }

                            }

                            System.out.println("Deseja altera o valor do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite novo valor do Produto");
                                leituraValor = sc.nextDouble();

                                try{

                                    produtoEditado.atualizarPreço(leituraValor);
                                }
                                catch(ValorException valorInvalida2){

                                    System.out.println(valorInvalida2.getMessage());
                                }

                            }
                            

                        } catch (ProdutoNaoEncontradoException produtoInexistente1) {

                            System.out.println(produtoInexistente1.getMessage());
                        }
        
                    
                    }else if(leitura == 2){
                        
                        System.out.println("Digite o ID do item a ser consultado:");
                        leituraID = sc.nextInt();

                        ProdutoPeso produtoEditado = null;
                        
                        try {

                            IProduto resp = repositorio.procura(leituraID);
                            System.out.println(resp);
                            produtoEditado = (ProdutoPeso) resp;
                            
                            System.out.println("Deseja altera o nome do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite novo nome do Produto");
                                leituraNome = sc.next();

                                produtoEditado.atualizarNome(leituraNome);

                            }

                            System.out.println("Deseja altera a quantidade do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite a nova quantidade do Produto");
                                leituraQuantidade = sc.nextDouble();

                                try{

                                    produtoEditado.atualizarQuantidade(leituraQuantidade);
                                }
                                catch(QuantidadeException quantidadeInvalida2){

                                    System.out.println(quantidadeInvalida2.getMessage());
                                }

                            }

                            System.out.println("Deseja altera o valor do Produto\n1 - Sim\n2 - Nao");
                            leitura = sc.nextInt();

                            if(leitura == 1){

                                System.out.println("Digite novo valor do Produto");
                                leituraValor = sc.nextDouble();

                                try{

                                    produtoEditado.atualizarPreço(leituraValor);
                                }
                                catch(ValorException valorInvalida2){

                                    System.out.println(valorInvalida2.getMessage());
                                }

                            }
                            

                        } catch (ProdutoNaoEncontradoException produtoInexistente1) {

                            System.out.println(produtoInexistente1.getMessage());
                        }
                    
                    }
                    
                    try {
                            
                            repositorio.salvarRepositorio(arquivoRepositorio);
                            System.out.println("A edicao do produto foi feita com sucesso\n");
                            
                        } catch (IOException var13) {
                            
                            var13.printStackTrace();
                            System.out.println("Não foi possível salvar o arquivo.");
                        }
                                                       
                
                } else if (leitura == 6) {
                    
                    System.out.println("Digite o tipo de produto que sera editado\n1 - Produto Unitario\n2 - Produto Peso");
                    leitura = sc.nextInt();
                    
                    if(leitura == 1){
                    
                        System.out.println("Digite o ID do Produto a ser vendido: ");
                        leituraID = sc.nextInt();

                        try {

                            IProduto venda = repositorio.procura(leituraID);
                            System.out.println(venda + "\n");

                            System.out.println("Digite a quantidade a ser comprada do produto: ");
                            leituraQuantidade = sc.nextDouble();

                            ProdutoUnitario aux = (ProdutoUnitario) venda;
                            
                            try{
                            
                                aux.atualizarQuantidade(leituraQuantidade);
                                System.out.println("O valor da venda é de: " + (leituraQuantidade*aux.getValor()));
                                
                                try{

                                    aux.atualizarQuantidade((aux.getQuantidade()-leituraQuantidade));
                                }
                                catch(QuantidadeException quantidadeInvalida2){

                                    System.out.println(quantidadeInvalida2.getMessage());
                                }
                                
                                
                                
                            }catch(QuantidadeException vendaQuantidade){
                            
                                System.out.println("Quantidade invalida para venda");
                            }



                        } catch (ProdutoNaoEncontradoException produtoInexistente1) {

                            System.out.println(produtoInexistente1.getMessage());
                        }
                    }
                    else if(leitura == 2){
                    
                        System.out.println("Digite o ID do Produto a ser vendido: ");
                        leituraID = sc.nextInt();

                        try {

                            IProduto venda = repositorio.procura(leituraID);
                            System.out.println(venda + "\n");

                            System.out.println("Digite a quantidade a ser comprada do produto: ");
                            leituraQuantidade = sc.nextDouble();

                            ProdutoPeso aux = (ProdutoPeso) venda;
                            
                            try{
                            
                                aux.atualizarQuantidade(leituraQuantidade);
                                System.out.println("O valor da venda é de: " + (leituraQuantidade*aux.getValor()));
                                
                                try{

                                    aux.atualizarQuantidade((aux.getQuantidade()-leituraQuantidade));
                                    System.out.println("Venda feita com sucesso\n");
                                    
                                    
                                }
                                catch(QuantidadeException quantidadeInvalida2){

                                    System.out.println(quantidadeInvalida2.getMessage());
                                }
                                
                                
                                
                            }catch(QuantidadeException vendaQuantidade){
                            
                                System.out.println("Quantidade invalida para venda");
                            }
                            



                        } catch (ProdutoNaoEncontradoException produtoInexistente1) {

                            System.out.println(produtoInexistente1.getMessage());
                        }
                    }  
                    
                    try {
                            
                            repositorio.salvarRepositorio(arquivoRepositorio);
                            System.out.println("A edicao do produto foi feita com sucesso\n");
                            
                        } catch (IOException var13) {
                            
                            var13.printStackTrace();
                            System.out.println("Não foi possível salvar o arquivo.");
                        }
                    
                }
                else if(leitura == 7){
                
                    continuar = false;
                }
            }
            
            return;
        }
        
    }
}

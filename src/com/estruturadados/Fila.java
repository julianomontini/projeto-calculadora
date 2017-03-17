

package com.estruturadados;


public class Fila<T> extends EstruturaDados<T> {
   
    public Fila(int tamanho){   
        super(tamanho);
    }

    @Override
    public void adicionar(T valor)throws Exception {
        
        if(this.estrutura.length-1 == this.posicao)
            throw new Exception("A fila já está cheia");
        
            this.posicao++;
            this.estrutura[posicao] = valor; 
    }
    
    @Override
    public T recuperar() throws Exception{     
            if(estaVazio())
                throw new Exception("Não há nada para ser recuperado na fila");
            
            return (T)this.estrutura[0];        
    }

    @Override
    public void remover()throws Exception {
        
        if(estaVazio())
            throw new Exception("Não há nada para ser recuperado na fila");
        
        for(int i=0 ; i < posicao ; i++){
            this.estrutura[i] = this.estrutura[i+1];
        
        }
        
        this.estrutura[posicao] = null; 
        this.posicao--;  
    }
    
}

package com.estruturadados;

public abstract class EstruturaDados<T> {
    
    protected int posicao = -1; 
    protected Object[] estrutura; 
    
    public EstruturaDados(int tamanho){
        this.estrutura = new Object[tamanho];
    }
    
    public abstract T recuperar() throws Exception;
    
    public abstract void adicionar (T valor) throws Exception;
    
    public abstract void remover() throws Exception; 
    
    public boolean estaVazio(){
        return (this.posicao == -1);
    }
    
    public int tamanhoEstrutura(){
        return estrutura.length;
    }
    
    public int getPosicaoAtual(){
    	return this.posicao;
    }
    
}

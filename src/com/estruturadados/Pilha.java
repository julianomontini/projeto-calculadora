package com.estruturadados;

public class Pilha<T> extends EstruturaDados<T> {
    
	public Pilha(int tamanhoPilha) {
            super(tamanhoPilha);
	}

	@Override
	public T recuperar() throws Exception {

		if (this.posicao == -1)
			throw new Exception("Não há nada para ser recuperado");

		return (T)this.estrutura[posicao];

	}

	@Override
	public void adicionar(T valor) throws Exception {

		if (posicao == estrutura.length - 1)
			throw new ArrayIndexOutOfBoundsException("A pilha já está cheia");

		this.posicao++;
		this.estrutura[posicao] = valor;

	}

	@Override
	public void remover() throws Exception {

		if (this.posicao == -1)
			throw new Exception("Não há nada para ser removido");

		this.estrutura[posicao] = null;

		this.posicao--;

	}
}

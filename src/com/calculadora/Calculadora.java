package com.calculadora;

import java.util.StringTokenizer;

import com.estruturadados.*;

public class Calculadora {
	
	public static Double calculaExpressao(String expressao) throws Exception{
		
		Fila<String> tokens = convertToTokens(expressao);
		Fila<String> posfix = convertePosfix(tokens);
		
		return calculaResultado(posfix);
	}
	
	private static Double calculaResultado(Fila<String> posfix) throws Exception{
		
		Pilha<String> pilha = new Pilha<String>(posfix.tamanhoEstrutura());
		Character op;
		Double n1,n2;
		while(!posfix.estaVazio()){
			
			try{
				Double valor = Double.valueOf(posfix.recuperar());
				pilha.adicionar(String.valueOf(valor));
				posfix.remover();
			}catch(NumberFormatException e){
				op = posfix.recuperar().charAt(0);
				posfix.remover();
				
				n2 = Double.valueOf(pilha.recuperar());
				pilha.remover();
				n1 = Double.valueOf(pilha.recuperar());
				pilha.remover();
			}
			
			
		}
		
		return null;
	}
	
	private static Fila<String> convertToTokens(String expressao)throws Exception{
		Fila<String> fila = new Fila<String>(expressao.length());
		
		StringTokenizer myString = new StringTokenizer(expressao,"+-*/^()",true);
		
		while(myString.hasMoreTokens()){
			fila.adicionar(myString.nextToken());
		}
		
		return fila;
	}
    
    private static Fila<String> convertePosfix(Fila<String> filaDesorganizada) throws Exception{
        
    	Fila<String> filaOrganizada = new Fila<String>(filaDesorganizada.tamanhoEstrutura());
    	Pilha<String> pilhaOperadores = new Pilha<String>(filaDesorganizada.tamanhoEstrutura());
    	
        while(!filaDesorganizada.estaVazio()){
        	
        	try{
        	
        		if(filaDesorganizada.recuperar().equals(")")){
        			filaDesorganizada.remover();
        			while(!pilhaOperadores.recuperar().equals("(")){
        				filaOrganizada.adicionar(pilhaOperadores.recuperar());
        				pilhaOperadores.remover();
        			}
        			pilhaOperadores.remover();
        		}
        		
        		String valor = filaDesorganizada.recuperar();
        		
        		Double valorNumerico;
        		
        		valorNumerico = Double.parseDouble(valor);
        		
        		filaOrganizada.adicionar(String.valueOf(valorNumerico));
        		
        		filaDesorganizada.remover();
        		
        	}
        	catch(NumberFormatException e){
        		
        		if(pilhaOperadores.estaVazio()){
        			pilhaOperadores.adicionar(filaDesorganizada.recuperar());
        			filaDesorganizada.remover();
        		}else{
        			
        			if(!deveSair(pilhaOperadores.recuperar(), filaDesorganizada.recuperar())){
        				
        				pilhaOperadores.adicionar(filaDesorganizada.recuperar());
        				filaDesorganizada.remover();
        				
        			}else{
        			
        				while(deveSair(pilhaOperadores.recuperar(), filaOrganizada.recuperar())){
            				
            				filaOrganizada.adicionar(pilhaOperadores.recuperar());
            				pilhaOperadores.remover();
            				
            			}
        				
        				filaOrganizada.adicionar(pilhaOperadores.recuperar());
        				pilhaOperadores.remover();
        				
        			}
        			
        		}
        		
        	}
        	catch(Exception e){
        		
        	}
        	
        }
        
        while(!pilhaOperadores.estaVazio()){
        	filaOrganizada.adicionar(pilhaOperadores.recuperar());
        	pilhaOperadores.remover();
        }
        
        
        return filaOrganizada;
    }
    
    private static int numeroOperador(String op){
        
        switch(op.charAt(0)){
            case '(':
                return 0;
            case '^':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '+':
                return 4;
            case '-':
                return 5;
            case ')':
                return 6;
            default:
                return 0;
        }
        
    }
    
    private static boolean deveSair(String op1, String op2){
        
        int o1 = numeroOperador(op1);
        int o2 = numeroOperador(op2);
        
        boolean tabela[][] = getTabelaCondicional();
        
        return tabela[o1][o2];
    }
    
    private static boolean[][] getTabelaCondicional(){
        
        boolean[][] tabela = new boolean[7][7];
        
        tabela[0][0] = false;
        tabela[0][1] = false;
        tabela[0][2] = false;
        tabela[0][3] = false;
        tabela[0][4] = false;
        tabela[0][5] = false;
        tabela[0][6] = true;
        
        tabela[1][0] = false;
        tabela[1][1] = false;
        tabela[1][2] = true;
        tabela[1][3] = true;
        tabela[1][4] = true;
        tabela[1][5] = true;
        tabela[1][6] = true;
        
        tabela[2][0] = false;
        tabela[2][1] = false;
        tabela[2][2] = true;
        tabela[2][3] = true;
        tabela[2][4] = true;
        tabela[2][5] = true;
        tabela[2][6] = true;
        
        tabela[3][0] = false;
        tabela[3][1] = false;
        tabela[3][2] = true;
        tabela[3][3] = true;
        tabela[3][4] = true;
        tabela[3][5] = true;
        tabela[3][6] = true;
        
        tabela[4][0] = false;
        tabela[4][1] = false;
        tabela[4][2] = false;
        tabela[4][3] = false;
        tabela[4][4] = true;
        tabela[4][5] = true;
        tabela[4][6] = true;
        
        tabela[5][0] = false;
        tabela[5][1] = false;
        tabela[5][2] = false;
        tabela[5][3] = false;
        tabela[5][4] = true;
        tabela[5][5] = true;
        tabela[5][6] = true;
        
        tabela[6][0] = false;
        tabela[6][1] = false;
        tabela[6][2] = false;
        tabela[6][3] = false;
        tabela[6][4] = false;
        tabela[6][5] = false;
        tabela[6][6] = false;
        
        return tabela;
    }
    
}

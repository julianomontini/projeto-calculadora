package projeto1;

import java.util.StringTokenizer;

import com.calculadora.Calculadora;
import com.estruturadados.Fila;

public class Teste {

	public static void main(String[] batatinhas){
		
		String expressao = "2^2^3";
		
		Fila<String> fila = new Fila<String>(expressao.length());
	
		try{
			
			StringTokenizer myString = new StringTokenizer(expressao,"+-*/^()",true);
			
			while(myString.hasMoreTokens()){
				fila.adicionar(myString.nextToken());
			}
			
			Calculadora.convertePosfix(fila);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}

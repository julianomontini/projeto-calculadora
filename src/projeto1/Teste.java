package projeto1;

import com.calculadora.Calculadora;

public class Teste {

	public static void main(String[] args){
		
		try{
			
			System.out.println(Calculadora.calculaExpressao("1+(2-3)^4/5"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}

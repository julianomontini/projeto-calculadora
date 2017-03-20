package projeto1;

import java.util.Scanner;

import com.calculadora.Calculadora;

public class Programa {

	public static void main(String[] args) {
		
		Scanner scannerOpc = new Scanner(System.in);
		Scanner scannerExp = new Scanner(System.in);
		
		int opc = 1;
		
		do{
			
			System.out.println("Digite uma expressao");
			String expressao = scannerExp.nextLine();
			
			try{
				System.out.println(Calculadora.calculaExpressao(expressao));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				System.out.println("1 - Proxima expressao / 2 - Sair");
				opc = scannerOpc.nextInt();
			}
		}while(opc != 2);
		
		System.out.println("Programa encerrado");

	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMovimentacao {
	public static void main(String[] args) {
		// declaracao das sondas
		Sonda s1 = new Sonda (1,2,'N');
		
		// iniciacao da leitura pelo teclado
		Scanner leitura = new Scanner(System.in);
		
		// criacao da malha do planalto retangular
		String tamanho = leitura.nextLine();
		String arrayTamanho[] = tamanho.split(" ");
		Planalto planalto = new Planalto (Integer.parseInt(arrayTamanho[0]), 
				Integer.parseInt(arrayTamanho[1]));
		
		// adicao das sondas ao planalto
		planalto.addSonda(s1);
		
		// leitura e processamento dos comandos
		String comandoSonda;
		for (int i = 0; i < planalto.numeroDeSondas(); i++) {
			planalto.getSonda(i).imprimeSaida();;
			comandoSonda = leitura.nextLine();
			processaComando(i, comandoSonda, planalto);
		}
		
		//impressao das saidas
		System.out.println(" ");
		planalto.imprimeLocalizacoes();
		
	}
	
	private static void processaComando (int indiceDaSonda, String comando, Planalto planalto) {
		Sonda sonda = planalto.getSonda(indiceDaSonda);
		for (int i = 0; i < comando.length(); i++) {
			char unidadeDeComando = comando.charAt(i);
			if ((unidadeDeComando == 'L')||(unidadeDeComando =='R')) {
				sonda.gira(unidadeDeComando);
			} else if ((unidadeDeComando == 'M')&&(planalto.movimentoValido(sonda))) {
				sonda.movimenta();
			}
		}
	}
	
}

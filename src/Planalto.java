import java.util.ArrayList;

public class Planalto {

	private int tamanhoX;
	private int tamanhoY;
	private ArrayList<Sonda> sondas = new ArrayList();
		
	public Planalto (int tamanhoX, int tamanhoY) {
		
		boolean tamanhoInvalido = (tamanhoX <= 0)||(tamanhoY <= 0);
		
		if (tamanhoInvalido) {
			throw new IllegalArgumentException();
		}
		
		this.tamanhoX = tamanhoX;
		this.tamanhoY = tamanhoY;
	}
		
	public void addSonda (Sonda sonda) {
		if (this.posicaoInvalida(sonda)) {
			throw new IllegalArgumentException();
		}
		
		this.sondas.add(sonda);
	}

	public boolean movimentoValido(Sonda sonda) {
		
		//poderia adicionar outras condicoes, como colisao
		boolean movimentoValido = !this.saiDaBorda(sonda); 
		
		if (movimentoValido) {
			return true;
		}
		return false;
	}
	
	public void imprimeLocalizacoes () {
		for (int i = 0; i < this.sondas.size(); i++) {
			this.sondas.get(i).imprimeSaida();
		}
	}
	
	public int numeroDeSondas () {
		return this.sondas.size();
	}
	
	public Sonda getSonda(int i) {
		return this.sondas.get(i);
	}

	private boolean posicaoInvalida(Sonda sonda) {
		boolean posicaoInvalida;
		posicaoInvalida = (sonda.getCoordenadaX() > this.tamanhoX)
				||(sonda.getCoordenadaY() > this.tamanhoY);
		return posicaoInvalida;
	}
	
	private boolean saiDaBorda (Sonda sonda) {
		switch (sonda.getOrientacao()) {
			case 'N': 
				if (sonda.getCoordenadaY() == this.tamanhoY) {
					return true;
				}
				return false;
			case 'S': 
				if (sonda.getCoordenadaY() == 0) {
					return true;
				}
				return false;
			case 'W': 
				if (sonda.getCoordenadaX() == 0) {
					return true;
				}
				return false;
			case 'E': 
				if (sonda.getCoordenadaX() == this.tamanhoX) {
					return true;
				}
				return false;
			default:
				return true;
		}
	}

}
public class Sonda {
	
	private int coordenadaX;
	private int coordenadaY;
	private char orientacao;
	
	public Sonda (int coordenadaX, int coordenadaY, char orientacao) {
		
		boolean orientacaoInvalida = (orientacao != 'N')
				&&(orientacao != 'S')
				&&(orientacao != 'E')
				&&(orientacao != 'W');
		
		boolean posicaoNegativa = (coordenadaX < 0)||(coordenadaY < 0);
		
		if(posicaoNegativa||orientacaoInvalida) {
			throw new IllegalArgumentException();
		}
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.orientacao = orientacao;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}
	
	public char getOrientacao() {
		return orientacao;
	}
	
	public void imprimeSaida() {
		System.out.println(this.getCoordenadaX() + " " + 
	this.getCoordenadaY()+ " " + this.getOrientacao());
	}

	public void gira(char giro) {
		 
		switch (this.orientacao) {
		 	case 'N':
		 		if (giro == 'L') {
		 			this.orientacao = 'W';
		 		} else if (giro == 'R'){
		 			this.orientacao = 'E';
		 		}
		 		break;
		 	case 'S':
		 		if (giro == 'L') {
		 			this.orientacao = 'E';
		 		} else if (giro == 'R'){
		 			this.orientacao = 'W';
		 		}
		 		break;
		 	case 'W':
		 		if (giro == 'L') {
		 			this.orientacao = 'S';
		 		} else if (giro == 'R'){
		 			this.orientacao = 'N';
		 		}
		 		break;
		 	case 'E':
		 		if (giro == 'L') {
		 			this.orientacao = 'N';
		 		} else if (giro == 'R'){
		 			this.orientacao = 'S';
		 		}
		 		break;
		 }
	}

	public void movimenta() {
		switch (this.orientacao) {
			case 'N':
				this.coordenadaY += 1;
				break;
			case 'S':
				this.coordenadaY -= 1;
				break;
			case 'W':
				this.coordenadaX -= 1;
				break;
			case 'E':
				this.coordenadaX += 1;
				break;
		}
	}
	
}
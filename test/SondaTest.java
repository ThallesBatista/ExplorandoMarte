import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

public class SondaTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void AceitaApenasOrientacaoValida() {
		Sonda sonda = new Sonda(0,0,'A');
	}

	@Test(expected=IllegalArgumentException.class)
	public void AceitaApenasPosicaoPositiva() {
		Sonda sonda = new Sonda(-1,0,'N');
	}
	
	@Test
	public void GiraParaOLadoCerto() {
		
		//criacao das sondas
		Sonda sondaNL = new Sonda(0,0,'N');
		Sonda sondaSL = new Sonda(0,0,'S');
		Sonda sondaEL = new Sonda(0,0,'E');
		Sonda sondaWL = new Sonda(0,0,'W');
		
		Sonda sondaNR = new Sonda(0,0,'N');
		Sonda sondaSR = new Sonda(0,0,'S');
		Sonda sondaER = new Sonda(0,0,'E');
		Sonda sondaWR = new Sonda(0,0,'W');
		
		//giro das sondas
		sondaNL.gira('L');
		sondaSL.gira('L');
		sondaEL.gira('L');
		sondaWL.gira('L');
		
		sondaNR.gira('R');
		sondaSR.gira('R');
		sondaER.gira('R');
		sondaWR.gira('R');
		
		//validacao
		assertEquals('W',sondaNL.getOrientacao());
		assertEquals('E',sondaSL.getOrientacao());
		assertEquals('N',sondaEL.getOrientacao());
		assertEquals('S',sondaWL.getOrientacao());
		
		assertEquals('E',sondaNR.getOrientacao());
		assertEquals('W',sondaSR.getOrientacao());
		assertEquals('S',sondaER.getOrientacao());
		assertEquals('N',sondaWR.getOrientacao());
	}
	
	@Test
	public void IgnoraComandosDeGiroInvalidos() {
		Sonda sonda = new Sonda(0,0,'N');
		
		sonda.gira('A');
		
		assertEquals(0,sonda.getCoordenadaX());
		assertEquals(0,sonda.getCoordenadaY());
		assertEquals('N',sonda.getOrientacao());
	}
	
	@Test
	public void SeMoveParaPosicoesCorretas() {
		
		//criacao das sondas
		Sonda sondaN = new Sonda(0,0,'N');
		Sonda sondaS = new Sonda(0,0,'S');
		Sonda sondaE = new Sonda(0,0,'E');
		Sonda sondaW = new Sonda(0,0,'W');
		
		//movimetacao das sondas
		sondaN.movimenta();
		sondaS.movimenta();
		sondaE.movimenta();
		sondaW.movimenta();
		
		//validacao
		assertEquals(0,sondaN.getCoordenadaX());
		assertEquals(1,sondaN.getCoordenadaY());
		assertEquals('N',sondaN.getOrientacao());
		
		assertEquals(0,sondaS.getCoordenadaX());
		assertEquals(-1,sondaS.getCoordenadaY());
		assertEquals('S',sondaS.getOrientacao());

		assertEquals(1,sondaE.getCoordenadaX());
		assertEquals(0,sondaE.getCoordenadaY());
		assertEquals('E',sondaE.getOrientacao());
		
		assertEquals(-1,sondaW.getCoordenadaX());
		assertEquals(0,sondaW.getCoordenadaY());
		assertEquals('W',sondaW.getOrientacao());
		
	}
	
}

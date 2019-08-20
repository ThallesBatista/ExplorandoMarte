import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PlanaltoTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void AceitaApenasTamanhosValidos() {
		Planalto planalto = new Planalto(-1,1);
	}
	
	@Test
	public void VerificaCorretamenteValidadeDoMovimento() {
		
		// inicializacoes
		Planalto planaltoV = new Planalto(5,5);
		Sonda sondaVN = new Sonda(1,1,'N');
		Sonda sondaVS = new Sonda(1,1,'S');
		Sonda sondaVE = new Sonda(1,1,'E');
		Sonda sondaVW = new Sonda(1,1,'W');
		
		Planalto planaltoI = new Planalto(5,5);
		Sonda sondaIN = new Sonda(1,5,'N');
		Sonda sondaIS = new Sonda(1,0,'S');
		Sonda sondaIE = new Sonda(5,1,'E');
		Sonda sondaIW = new Sonda(0,1,'W');
		
		// adicao das sondas nos planaltos
		planaltoV.addSonda(sondaVN);
		planaltoV.addSonda(sondaVS);
		planaltoV.addSonda(sondaVE);
		planaltoV.addSonda(sondaVW);
		
		planaltoI.addSonda(sondaIN);
		planaltoI.addSonda(sondaIS);
		planaltoI.addSonda(sondaIE);
		planaltoI.addSonda(sondaIW);
		
		// validacao
		Sonda sonda;
		for (int i=0; i<planaltoV.numeroDeSondas(); i++) {
			sonda = planaltoV.getSonda(i);
			assertEquals(true,planaltoV.movimentoValido(sonda));
		}
		for (int i=0; i<planaltoI.numeroDeSondas(); i++) {
			sonda = planaltoI.getSonda(i);
			assertEquals(false,planaltoI.movimentoValido(sonda));
		}
		
	}
	
	@Test
	public void AdiconaSondasComSucesso() {
		
		// inicializacoes
		Planalto planalto = new Planalto(10,10);
		Sonda sonda1 = new Sonda(1,1,'N');
		Sonda sonda2 = new Sonda(2,2,'S');
		Sonda sonda3 = new Sonda(3,3,'E');
		Sonda sonda4 = new Sonda(4,4,'W');
		
		// adicao das sondas
		planalto.addSonda(sonda1);
		planalto.addSonda(sonda2);
		planalto.addSonda(sonda3);
		planalto.addSonda(sonda4);
		
		// validacoes
		assertEquals(4,planalto.numeroDeSondas());
		assertEquals(sonda1,planalto.getSonda(0));
		assertEquals(sonda2,planalto.getSonda(1));
		assertEquals(sonda3,planalto.getSonda(2));
		assertEquals(sonda4,planalto.getSonda(3));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NaoAdicionaSondasForaDoPlanalto() {
		Sonda sonda = new Sonda(8,8,'N');
		Planalto planalto = new Planalto(5,5);
		
		planalto.addSonda(sonda);
	}
	
}

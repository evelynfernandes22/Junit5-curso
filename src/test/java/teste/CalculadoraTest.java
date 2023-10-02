package teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Calculadora;

public class CalculadoraTest {

	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		Assertions.assertFalse(calc.soma(2, 3) == 3);
		Assertions.assertEquals(5,calc.soma(2, 3));
	}
	
	@Test
	public void assertivas() {
		//assertivas mais comuns...
		
		Assertions.assertEquals("Casa", "Casa");
		Assertions.assertNotEquals("Casa", "casa"); //não importa se é igual, o que importa que é casa
		Assertions.assertTrue("Casa".equalsIgnoreCase("CASA"));
		Assertions.assertTrue("Casa".endsWith("sa"));
		Assertions.assertTrue("Casa".startsWith("Ca"));
		
		List<String> s1 = new ArrayList();
		List<String> s2 = new ArrayList();
		List<String> s3 = null;
		
		Assertions.assertEquals(s1, s2);
		Assertions.assertSame(s1, s1); //com a mesma referencia de objeto
		Assertions.assertNotEquals(s1, s3);
		Assertions.assertNull(s3);
		Assertions.assertNotNull(s1);
//		Assertions.fail("Falhou pelo motivo xxx");
		
		
	}
}

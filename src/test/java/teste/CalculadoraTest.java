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
	
	@Test
	public void deveRetornarNumeroInteiroNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, 2);
		Assertions.assertEquals(3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroNegativoNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, -2);
		Assertions.assertEquals(-3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroDecimalNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(10, 3);
		Assertions.assertEquals(3.3333332538604736, resultado);

		//assertEquals especial para float
		Assertions.assertEquals(3.33, resultado, 0.01); //colocando no final a margem de erro, ou delta, a máximo de diferença aceitável entre o resultado e o esperado.
	}
	
}

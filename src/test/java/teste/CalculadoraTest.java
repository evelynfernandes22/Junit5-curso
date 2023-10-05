package teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import model.Calculadora;

public class CalculadoraTest {

	private Calculadora calc = new Calculadora();
	
	/*
	 * @BeforeEach e @AfterEach => Executam antes e depois de cada teste que existe na classe
	 * @BeforeAll e @AfterAll => É uma única execução no clico de teste da classe, before no começo e after no final
	 */
	
	@BeforeEach
	public void setup() {
		System.out.println("^^^");
	}
	
	@AfterEach
	public void teardown() {
		System.out.println("vvv");
	}
	
	@BeforeAll
	public static void  setupAll() {
		System.out.println("--- Before All ---");
	}
	
	@AfterAll
	public static void teardownAll() {
		System.out.println("--- After All ---");
	}
	
	/*
	 * TESTES DA CLASSE CALCULADORA
	 */
	
	@Test
	public void testSomar() {
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
		float resultado = calc.dividir(6, 2);
		Assertions.assertEquals(3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroNegativoNaDivisao() {
		float resultado = calc.dividir(6, -2);
		Assertions.assertEquals(-3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroDecimalNaDivisao() {
		float resultado = calc.dividir(10, 3);
		Assertions.assertEquals(3.3333332538604736, resultado);

		//assertEquals especial para float
		Assertions.assertEquals(3.33, resultado, 0.01); //colocando no final a margem de erro, ou delta, a máximo de diferença aceitável entre o resultado e o esperado.
	}
	
	@Test
	public void deveRetornarNumeroZeroComNumeradorZeroNaDivisao() {
		float resultado = calc.dividir(0, 2);
		Assertions.assertEquals(0, resultado);
	}
	
	@Test
	public void deveLancarExcecaoQuandoDividirPorZero_Junit4() {
//		throw new AssertionFailedError(); //para ser considerado uma falha
		try {
			float resultado = 10/0;
			Assertions.fail("Deveria ter sido lançado uma exceção na divisão.");
		} catch (ArithmeticException e) {
			Assertions.assertEquals("/ by zero", e.getMessage()); //deve ser lançada pelo motivo que estou esperando
		}
	}
	
	//faz o mesmo que a de cima
	@Test
	public void deveLancarExcecaoQuandoDividirPorZero_Junit5() {
		ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {  //no executável utilizar uma lambda supplier
			float resultado = 10/0;
		});
		Assertions.assertEquals("/ by zero", exception.getMessage());
	}
	
}

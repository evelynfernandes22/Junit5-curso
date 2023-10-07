package contexto;

public class Calculadora {

	public Calculadora() {
		System.out.println("instaciando calculadora");
	}

	public int soma(int a , int b) {
		return a + b;
	}

	public float dividir(int numerador, int denominador) {
		return (float) numerador / denominador;
	}
}

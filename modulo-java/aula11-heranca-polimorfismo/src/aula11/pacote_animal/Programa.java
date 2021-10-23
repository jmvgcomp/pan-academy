package aula11.pacote_animal;

public class Programa {
	public static void main(String[] args) {
		
		Gato gatinho1 = new Gato();
		gatinho1.dormir();
		gatinho1.peso = 7;
		gatinho1.raca = "Siameses";
		
		System.out.println("---- Sobre Gato ----");
		System.out.println(gatinho1.peso);
		
		Cachorro cachorrinho1 = new Cachorro();
		cachorrinho1.dormir();
		cachorrinho1.peso = 10;
		cachorrinho1.raca = "Labrador";
		System.out.println("---- Sobre Cachorro ----");
		System.out.println(cachorrinho1.peso);

	}
}

package vectores_ordenados;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VectoresOrdenados v1 = new VectoresOrdenados(20);
		v1.ordenar();
		v1.print();
		
		
		VectoresOrdenados vectorReducido = v1.reducir();
		vectorReducido.print();
		
		
		
		
		
		
		
	}

}

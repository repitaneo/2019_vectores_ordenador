package vectores_ordenados;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VectoresOrdenados v1 = new VectoresOrdenados(5);
		VectoresOrdenados v2 = new VectoresOrdenados(5);
		v1.ordenar();
		v2.ordenar();
		v1.print();
		v2.print();
		
		
		VectoresOrdenados v3 = v1.merge(v2);
		v3.print();
		
		
		
		
		
		
	}

}

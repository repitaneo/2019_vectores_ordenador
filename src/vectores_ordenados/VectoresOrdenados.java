package vectores_ordenados;

public class VectoresOrdenados {

	private int datos[];
	
	
	
	public VectoresOrdenados(int elementos) {
		
		datos = new int[elementos];
		
		for(int i=0;i<datos.length;i++) {
			
			datos[i] = (int)(Math.random()*100);
		}
	}
	
	
	public VectoresOrdenados merge(VectoresOrdenados otro) {

		VectoresOrdenados mezcla; 
		mezcla = new VectoresOrdenados(datos.length+otro.datos.length);     
		

		this.ordenar();
		otro.ordenar();
		

		// se mueve por this
		int i = 0;  
		// se mueve por "otro" 
		int j = 0;
		// se mueve por mezcla
		int x = 0;
		

		for(x=0;x<mezcla.datos.length;x++) {
			
			if(datos[i]<otro.datos[j]) {
				
				mezcla.datos[x] = datos[i];
				i++;
			}
			else {
				
				mezcla.datos[x] = otro.datos[j];
				j++;
			}
			
		}
		
		
		
		
		
		
		
		return mezcla;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ordenar() {
		
		for(int i=0;i<datos.length-1;i++) {
			
			for(int j=0;j<datos.length-1-i;j++) {
				
				int aux;
				if(datos[j]>datos[j+1]) {
					
					aux = datos[j];
					datos[j] = datos[j+1];
					datos[j+1] = aux;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Imprime el contendo del vector
	 * 
	 */
	public void print() {
		
		for(int i=0;i<datos.length;i++) {

			System.out.print(datos[i]+" ");
		}
		System.out.println();
	}
	
	
	
	
	
	
}

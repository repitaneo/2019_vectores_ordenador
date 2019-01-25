package vectores_ordenados;

public class VectoresOrdenados {

	private int datos[];
	
	
	
	public VectoresOrdenados(int elementos) {
		
		datos = new int[elementos];
		
		for(int i=0;i<datos.length;i++) {
			
			datos[i] = (int)(Math.random()*10)+1;
		}
	}
	

	
	
	
	public void reset() {
		
		for(int i=0;i<datos.length;i++) {
			
			datos[i] = 0;
		}
		
	}
	
	
	
	
	
	/**
	 * mezcla dos vectores ordenados, this y otro en un vector 
	 * ordenado nuevo que es devuelto
	 * 
	 * @param otro el vector ordenado con el que mezclarse
	 * @return un nuevo vector ordenado mezcla de los dos anteriores
	 */
	public VectoresOrdenados merge(VectoresOrdenados otro) {

		VectoresOrdenados mezcla; 
		mezcla = new VectoresOrdenados(datos.length+otro.datos.length);     
		

		this.ordenar();
		otro.ordenar();
		mezcla.reset();
		

		// se mueve por this
		int i = 0;  
		// se mueve por "otro" 
		int j = 0;
		// se mueve por mezcla
		int x = 0;
		
		// recorremos el nuevo vector
		for(x=0;x<mezcla.datos.length;x++) {
			
			// mientras que ninguno de los dos subvectores se hayan agotado
			// cogemos datos de ellos
			if((i<datos.length)&&(j<otro.datos.length)) {
				
					// cojo el menor de los dos que estoy "visualizando"
					if(datos[i]<otro.datos[j]) {
					
						mezcla.datos[x] = datos[i];
						i++;
					}
					else if(j<otro.datos.length) {
						
						mezcla.datos[x] = otro.datos[j];
						j++;
					}	
			}
			// si "this" se ha agotado cojo numeros de "otro"
			else if(i==datos.length){
				
					mezcla.datos[x] = otro.datos[j];
					j++;
			}
			// si "otro" se ha agotado cojo numeros de "this"
			else if(j==otro.datos.length){
				
					mezcla.datos[x] = datos[i];
					i++;
			}
		}
		return mezcla;
	}
	
	
	
	
	/**
	 * Crear un vectorOrdenado sin elementos repetidos
	 * @return el vector ordenado sin elementos repetidos
	 */
	public VectoresOrdenados reducir() {
		
		int[] nuevosDatos = new int[datos.length];
		
		// marco los repetidos
		int repetidos = 0;
		
		// posicione los indices que me van a permitir moverme 
		// por el vector original y copiar en el nuevo
		int siguiente = 1;
		int actual = 0;
		
		// copio la primera de las posiciones
		nuevosDatos[actual] = datos[actual];
		
		//mientras que el índice "actual" no llegue al final...
		while(actual<datos.length) {
			
			// si me encuentro coincidencias con "siguiente"
			while(	(siguiente<datos.length)&&
					(datos[siguiente]==datos[actual])) {
				
				// en el nuevo vector voy colocando 0s
				nuevosDatos[siguiente] = 0;
				// avanzo el índice "siguiente"
				siguiente++;
				// aumento los repetidos
				repetidos++;
			}
			/* si salgo del bucle anterior en pq ya no coinciden
			 el "actual" lo coloco donde estaba "siguiente"
			 que es donde acabaron las coincidencias */
			actual = siguiente;
			// el siguiente lo hago avanzar
			siguiente++;
			// si "actual" es legal, copio en el nuevo vector 
			// su contenido
			if(actual<datos.length) {
				nuevosDatos[actual] = datos[actual];
			}
		}
		
		
		/*
		 * Copiar los valores que no son 0s en el nuevo vector
		 * 
		 */
		VectoresOrdenados reducido = new VectoresOrdenados(datos.length-repetidos);

		// usamos dos índices para movernos por los dos vectores que tenemos
		int indiceNuevosDatos = 0;
		int indiceDatosReducidos= 0;
		
		// nos movemos mientras que haya datos para copiar
		while((indiceNuevosDatos<nuevosDatos.length)&
			  (indiceDatosReducidos<reducido.datos.length)) {
			
			// si hay un dato copiable, lo coloco en el vector reducido
			if(nuevosDatos[indiceNuevosDatos]!=0) {

				// coloco el dato
				reducido.datos[indiceDatosReducidos] = nuevosDatos[indiceNuevosDatos];
				
				// avanzo los índices
				indiceNuevosDatos++;
				indiceDatosReducidos++;
			}
			else {

				// si no era un dato para copiar, avanzo el 
				// indice (hasta que lo haya)
				indiceNuevosDatos++;
			}
			
		}

		// devuelvo el objeto que contiene el vector con los 
		// datos no repetidos
		return reducido;
	}
	
	
	
	
	
	
	
	
	/**
	 * Ordena por el método de la burbuja
	 */
	public void ordenar() {
		
		// para todos los elementos del vector
		for(int i=0;i<datos.length-1;i++) {
			
			// voy comparándolo con el siguiente y moviéndolo 
			// para que el mayor siempre quede "arriba" 
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

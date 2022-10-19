package test;
import javax.swing.JOptionPane;

public class Matriz {
	
	private static int[][] matriz = {{1, 2, 3},
									 {4, 5, 6},
									 {7, 8, 9}
	};
	//definir tamaño de matriz
	private static int talla = matriz.length;
	
	public static void main(String[] args) {
		//pedimos al usuario la cantidad de veces que quiere rotar la matriz
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿cuantas veces quiere rotar la matriz"));
		
		do {
			//crear una matriz vacia para almacenar nuevos valores
			int[][] nuevaMatriz = new int[matriz.length][matriz.length];
			rotarMatriz(0, 0, nuevaMatriz);
			System.out.println(imprimirMatriz());
			
			//para decrementar cantidad
			cantidad = cantidad-1;
		} while (cantidad != 0);
	}
	
	/**
	 * Metodo que me permite de forma recursiva rotar una matriz
	 * @param x
	 * @param y
	 * @param nuevaMatriz
	 */
	private static void rotarMatriz(int x, int y, int[][] nuevaMatriz) {
		if (x == talla) {
			//cuando se cumple la recursividad, la matriz sera la nueva matriz
			matriz = nuevaMatriz;
			return;			
		}else {
			//a la matriz vacia en diferente fila y misma columna se agregue un valor
			//de misma fila y diferente columna de otra matriz
			recorrer(x, y, nuevaMatriz);
			//llamado recursivo
			rotarMatriz(x+1, y, nuevaMatriz);
		}	
		return;
	}
	
	/**
	 * a la matriz vacia en diferente fila y misma columna se agregue un valor
	 * de misma fila y diferente columna de otra matriz
	 * 
	 * pasar cada fila a columna, rotar
	 * @param x
	 * @param y
	 * @param i
	 * @param nuevaMatriz
	 */
	private static void recorrer(int x, int y, int[][] nuevaMatriz) {
		if (y == talla) {
			return;
		}else {
			nuevaMatriz[y] [talla-1-x] = matriz[x][y];	
			//llamado recursivo
			recorrer(x, y+1, nuevaMatriz);
		}
		return;
	}
	
	/**
	 * imprime la matriz resultante
	 * @param nuevaMatriz
	 * @return
	 */
	private static String imprimirMatriz() {
		String salida = "";
        for ( int  i = 0 ; i < talla ; i ++) { 
            for ( int  j = 0 ; j < talla; j ++) { 
                salida += matriz[i][j] + " ";
            } 
           salida += "\n";
        } 
        return salida;
	}

//  //Metodo con un ciclo for	
//	private static void rotarMatriz( int[][] nuevaMatriz) {
//		for (int x=0;x<talla;x++) {
//			  for (int y=0;y<talla;y++) {
//			    nuevaMatriz[y][talla-1-x] = matriz[x][y];
//			  }
//			}
//		matriz = nuevaMatriz;
//			
//		}
}

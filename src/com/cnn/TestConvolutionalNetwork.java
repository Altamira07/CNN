package com.cnn;


import org.junit.jupiter.api.Test;

class TestConvolutionalNetwork {

	int [][] matrix = {
			{1,1,1,0,0},
			{0,1,1,1,0},
			{0,0,1,1,1},
			{0,0,1,1,0},
			{0,1,1,0,0},
			
	};
	ConvolutionalNetwork cn = new ConvolutionalNetwork();
	
	@Test
	void test() {
		int [][] m = cn.obtSector(matrix, 1, 0);
	//	imprime(m);
		
	}
	@Test
	void testCapaFiltro()
	{
		int [][] result = cn.capaFiltro(matrix);
		imprime(result);
	}
	@Test
	void testConversor()
	{
		int valores[] = {1,2,3,4,5,6,7,8,9};
		int [][] result = cn.convertir1Da2D(valores);
		//imprime(result);
	}
	void imprime(int [][] matrix)
	{
		for(int i = 0; i< matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
}

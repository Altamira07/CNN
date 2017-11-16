package com.cnn;

public class ConvolutionalNetwork
{
	private final int [][] filtro = 
		{
				{1,0,1},
				{0,1,0},
				{1,0,1}
		};
	public int [][] capaFiltro(int [][] imagen)
	{
		int []resultFiltro = new int[9];
		int k = 0;
		int suma  = 0;
		for(int y = 0; (y+2)< imagen.length;y++)
			for (int x = 0 ; (2+x)<imagen[y].length; x++)
			{
				int [][] sector = obtSector(imagen, x, y);
				for(int i = 0; i < filtro.length; i++)
				{
					for(int j = 0;j<filtro[i].length;j++ )
					{
						suma+= (filtro[i][j] * sector[i][j]);
					}
				}
				resultFiltro[k++] = suma;
				suma = 0;
			}
		
		return convertir1Da2D(resultFiltro);
	}
	public int [][] capaReLU(int [][]imagen)
	{
		
		return null;
	}
	
	public int [][] capaPooling(int [][]matriz)
    {
        int [][] resultado= new int [((int)matriz.length/2)+1][((int)matriz[0].length/2)+1];
        int f=0,c=0;
        for(int x=0; x<matriz.length;x=x+2)
        {
            if(x+1>=matriz.length)
            {x--;}
            
            for(int y=0; y<matriz[x].length;y=y+2)
            {
                if(y+1>=matriz[x].length)
                {y--;}
                int max=0;
                if(matriz[x][y]>max)
                {
                    max=matriz[x][y];
                }
                
                if(matriz[x][y+1]>max)
                {
                    max=matriz[x][y+1];
                }
                
                if(matriz[x+1][y]>max)
                {
                    max=matriz[x+1][y];
                }
                
                if(matriz[x+1][y+1]>max)
                {
                    max=matriz[x+1][y+1];
                }
                
                resultado[c][f]=max;
                f++;
            }
            c++;
            f=0;
        }
        return resultado;
    }
    
	
	
	public int [][] convertir1Da2D(int matrix[])
	{
		int [][] temp = new int[3][3];
		int x = 0,y= 0;
		for(int i = 0 ; i < 9;i++)
		{
			temp[y][x]=matrix[i];
			x++;
			if(2<x)
			{
				y++;
				x=0;
			}
		}
		
		return temp;
	}
	public int[][] obtSector(int [][] img, int x, int y)
	{
		int [][] result = new int [3][3];
		for(int i = 0;i<3;i++)
		{
			for(int j = 0;j< 3;j++ )
			{
				result[i][j] = img[i+y][j+x];
				
			}
		}
		return result; 
	}
	
}

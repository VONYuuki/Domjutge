package Domjutge;

import java.util.Scanner;

/*
 * Autor - Daniel Díaz Rodríguez
 * Versió - 0.3
 */

public class Domjutge
{
	public static Scanner S = new Scanner(System.in);
	public static final int COSTAT = 8;
	public static char[][] tauler = new char[COSTAT][COSTAT];
	
	public static void inicialitzaTauler()
	{
		int count = 0;
		
		for(int i= 0; i < COSTAT; i++)
		{
			for(int j = 0; j < COSTAT; j++)
			{
				if(i % 2 != 0)	//filas par
				{
					if(count == 1)
					{
						if(j > 0)
						{
							tauler[i][j] = '.';
							count = 0;
						}
						else
						{
							tauler[i][j] = '.';
							count = 0;
						}
					}
					else
					{
						if(j > 0)
						{
							tauler[i][j] = 'x';
							count++;
						}
						else
						{
							tauler[i][j] = 'x';
							count++;
						}
					}	
				}
				else	//filas impar
				{
					if(count == 1)
					{
						if(j > 0)
						{
							tauler[i][j] = 'x';
							count = 0;
						}
						else
						{
							tauler[i][j] = 'x';
							count = 0;
						}
					}
					else
					{
						if(j > 0)
						{
							tauler[i][j] = '.';
							count++;
						}
						else
						{
							tauler[i][j] = '.';
							count++;
						}
					}	
				}
			}
		}
	}
	
	/*
	 * inicialitzaTauler - Inicialitza la matriu segons si la fila es parell o senar
	 */
	
	public static void mostraTauler()
	{
		for(int i = 0; i < COSTAT; i++)
		{
			for(int j = 0; j < COSTAT; j++)
			{
				if(j > 0)
				{
					System.out.print(" " + tauler[i][j]);
				}
				else
				{
					System.out.print(tauler[i][j]);
				}
				
				if(j == (COSTAT - 1))	//numero
				{
					System.out.print(" " + i);
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < COSTAT; i++)
		{
			if(i > 0)
			{
				System.out.print(" " + i);
			}
			else
			{
				System.out.print(i);
			}
		}
		System.out.println();
		
		/*for(int i = 0; i < COSTAT; i++) //Letras
		{
			if(i > 0)
			{
				System.out.print(" " + (char)(97 + i));
			}
			else
			{
				System.out.print((char)(97 + i));
			}
		}
		System.out.println();*/
	}
	
	/*
	 * mostraTauler - Mostra el tauler per pantalla
	 * 
	 * Només s'utilitza com a orientació, no es necessari al programa
	 */
	
	public static void introdueixFitxa(int x)
	{
		int fila, columna;
		
		//System.out.print("Fila: ");
		fila = S.nextInt();
		//System.out.print("Columna: ");
		columna = S.nextInt();
		
		if(x == 0)
		{
			tauler[fila][columna] = 'J';
		}
		else
		{
			tauler[fila][columna] = 'D';
		}
	}
	
	/*
	 * introdueixFitxa - Introduim una fitxa al tauler
	 * 
	 * Li passem per parametre un valor x, si és 0 és la fixa del jugador, si és 1 és la fixa del rival
	 */
	
	public static int getpos(int x)
	{
		for(int i = 0; i < COSTAT; i++)
		{
			for(int j = 0; j < COSTAT; j++)
			{
				if(tauler[i][j] == 'J')
				{
					if(x == 0)
					{
						x = i;
					}
					else
					{
						x = j;
					}
				}
			}
		}
		
		return x;
	}
	
	/*
	 * getpos - Ens retorna la posició d'una fitxa
	 * 
	 * Li passem per parametre un valor x, si es 0 és la posició de la fila, si es 1 és la posició de la columna
	 */
	
	public static int movimentseguent(int Rx, int Ry, int diagonal) //Rx = Pos fila, Ry = pos columna, diagonal = 0(izquierda), 1(derecha)
	{
		int count;
		
		count = 0;
		
		/*if((Rx == 0) && (Ry == (COSTAT - 1)) //Esquina 3
				 {
				 	if((tauler[Rx - 1][Ry + 1] == 'x') || (tauler[Rx - 1][Ry + 1] == 'D')) //Arriba derecha
					{
						count++;
						
						if(tauler[Rx - 1][Ry + 1] == 'D')
						{
							count = count + movimentseguent(Rx - 1, Ry + 1, 1);
						}
					}
				 }
				 else
				 {
				 	
				 }*/
		
		if(tauler[Rx][Ry] == 'D')
		{
			count--;
			return count;
		}
		else
		{
			if(diagonal == 0)//(izquierda)
			{
				if(Rx == (COSTAT - 1)) // fila abajo
				{
					if(tauler[Rx - 1][Ry - 1] == 'D') //Arriba izquierda
					{
						count++;
					}
				}
				else
				{
					if(Ry == 0) //fila izquierda
					{
						
					}
					else
					{
						if(Ry == (COSTAT - 1)) // fila derecha
						{
							if(tauler[Rx - 1][Ry - 1] == 'D') //Arriba izquierda
							{
								count++;
							}
						}
						else //resta
						{
							if(tauler[Rx - 1][Ry - 1] == 'D') //Arriba izquierda
							{
								count++;
							}
						}
					}
				}
			}
			else //1(derecha)
			{
				if(Rx == (COSTAT - 1)) // fila abajo
				{
					if(tauler[Rx - 1][Ry + 1] == 'D') //Arriba derecha
					{
						count++;
					}
				}
				else
				{
					if(Ry == 0) //fila izquierda
					{
						if(tauler[Rx - 1][Ry + 1] == 'D') //Arriba derecha
						{
							count++;
						}
					}
					else
					{
						if(Ry == (COSTAT - 1)) // fila derecha
						{
							
						}
						else //resta
						{
							if(tauler[Rx - 1][Ry + 1] == 'D') //Arriba derecha
							{
								count++;
							}
						}
					}
				}
			}
		}
		
		return count;
	}
	
	/*
	 * movimentseguent - Calcula els moviments possibles des de la posició al "matar" una fitxa rival, només compta 1 cas, el de
	 * la mateixa diagonal on s'ha mogut, no compta la diagonal contraria
	 * 
	 * Li passem per paràmetre la posició fila (Rx) i la columna (Ry) de la posició de la fixa del jugador al "matar" una fitxa rival
	 * i la diagonal d'on ve la fitxa
	 * count = num de moviments posibles
	 */
	
	public static int movimentsPossibles(int Rx, int Ry) //Rx = Pos fila, Ry = pos columna
	{
		int count;
		
		count = 0;
		
		if((Rx == 0) && (Ry == (COSTAT - 1)))
		{
			return count;
		}
		else
		{
			if((Rx == (COSTAT - 1)) && (Ry == 0)) //Esquina 3
			 {
			 	if((tauler[Rx - 1][Ry + 1] == 'x') || (tauler[Rx - 1][Ry + 1] == 'D')) //Arriba derecha
				{
					count++;
					
					if(tauler[Rx - 1][Ry + 1] == 'D')
					{
						count = count + movimentseguent(Rx - 2, Ry + 2, 1);
					}
				}
			 }
			 else
			 {
				 if(Rx == (COSTAT - 1)) // fila abajo
					{
						if((tauler[Rx - 1][Ry - 1] == 'x') || (tauler[Rx - 1][Ry - 1] == 'D')) //Arriba izquierda
						{
							count++;
							
							if(tauler[Rx - 1][Ry - 1] == 'D')
							{
								count = count + movimentseguent(Rx - 2, Ry - 2, 0);
							}
						}
						
						if((tauler[Rx - 1][Ry + 1] == 'x') || (tauler[Rx - 1][Ry + 1] == 'D')) //Arriba derecha
						{
							count++;
							
							if(tauler[Rx - 1][Ry + 1] == 'D')
							{
								count = count + movimentseguent(Rx - 2, Ry + 2, 1);
							}
						}
					}
					else
					{
						if(Ry == 0) //fila izquierda
						{
							if((tauler[Rx - 1][Ry + 1] == 'x') || (tauler[Rx - 1][Ry + 1] == 'D')) //Arriba derecha
							{
								count++;
								
								if(tauler[Rx - 1][Ry + 1] == 'D')
								{
									count = count + movimentseguent(Rx - 2, Ry + 2, 1);
								}
							}
						}
						else
						{
							if(Ry == (COSTAT - 1)) // fila derecha
							{
								if((tauler[Rx - 1][Ry - 1] == 'x') || (tauler[Rx - 1][Ry - 1] == 'D')) //Arriba izquierda
								{
									count++;
									
									if(tauler[Rx - 1][Ry - 1] == 'D')
									{
										count = count + movimentseguent(Rx - 2, Ry - 2, 0);
									}
								}
							}
							else //resta
							{
								if((tauler[Rx - 1][Ry - 1] == 'x') || (tauler[Rx - 1][Ry - 1] == 'D')) //Arriba izquierda
								{
									count++;
									
									if(tauler[Rx - 1][Ry - 1] == 'D')
									{
										count = count + movimentseguent(Rx - 2, Ry - 2, 0);
									}
								}
								
								if((tauler[Rx - 1][Ry + 1] == 'x') || (tauler[Rx - 1][Ry + 1] == 'D')) //Arriba derecha
								{
									count++;
									
									if(tauler[Rx - 1][Ry + 1] == 'D')
									{
										count = count + movimentseguent(Rx - 2, Ry + 2, 1);
									}
								}
							}
						}
					}
			 }
		}
		
		return count;
	}
	
	/*
	 * movimentsPossibles - Calcula els moviments posibles des de la fitxa del jugador, crida a la funció moviment seguent
	 * 
	 * Li passem per paràmetre la posició de la fila (Rx) i la columna (Ry) de la fixa del jugador
	 * count = num de moviments possibles.
	 */
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int ncasos, nfitxes, posf, posc, posibles;
		
		ncasos = S.nextInt();
		
		for(int i = 0; i < ncasos; i++)
		{
			inicialitzaTauler();
			//mostraTauler();
			
			//System.out.println("Jugador");
			introdueixFitxa(0);
			//System.out.println("Num fitxes");
			nfitxes = S.nextInt();
			for(int j = 0; j < nfitxes; j++)
			{
				//System.out.println("Fitxa " + (j + 1));
				introdueixFitxa(1);
			}
			
			//mostraTauler();
			
			posf = getpos(0); //0 = fila
			posc = getpos(1); //1 = columna
			posibles = movimentsPossibles(posf, posc);
			
			//System.out.println("Movimientos posibles: " + posibles);
			System.out.println(posibles);
		}
		
		S.close();
	}
	
	/*
	 * main() - Funció pricipal del programa:
	 * A partir d'un número de casos introduim la fitxa del jugador, a continuació el número de fitxes
	 * del rival, obtenim la posició del jugador i calculem els moviments possibles
	 * 
	 * ncasos = número de casos
	 * nfitxes = número de fitxes rivals
	 * posf, posc = posició de la fitxa del jugador
	 * posibles = número de moviments possibles
	 */
}

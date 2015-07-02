package sudoku;

import java.util.Scanner;
import java.io.*;


import java.io.IOException;


public class Solver {





	static int total=0;
	public static void printGrid(int ar[][]){
		for (int i =0;i<ar.length;i++){

			for(int j =0;j<ar.length;j++){
				//System.out.print(ar[i][j]+" ");
			}
			//System.out.println("");
		}
	}
	public static boolean solve(int[][] ar,int ind,int sum)
	{
		int i;
		if(ind >80) {sum=100*ar[0][0]+10*ar[0][1]+ar[0][2];
			total=total+sum;
			//System.out.println(sum);
			return true;}

		else i =ind/9;

		int j =ind%9;;
		if (ar[i][j]!=0){
			return solve(ar,ind+1,sum);
		}	
		else
		{
			for(int a=1;a<=9;a++){
				if (check(a,ar,i,j)){
					ar[i][j]=a;
					if(solve(ar, ind+1,sum)){ 
						return true;}
					else
						ar[i][j] = 0;
				}
			} 
		}
		return false;
	}




	public static boolean check(int a,int ar[][],int x,int y){
		int count=0;

		for( int i=0;i<9;i++){

			if(ar[i][y]==a){count++;
				if(count>0)return false;}}

		for( int j=0;j<9;j++){
			if(ar[x][j]==a){count++;
				if(count>0)return false;}}

		for (int k=(x-x%3) ;k<x+3-x%3;k++)
			for(int l=(y-y%3);l<y+3-y%3;l++){

				if(ar[k][l]==a)
				{count++;

				}
			}
		if(count==0)return true;
		else return false;}

		public  static void main(String[] args)  throws IOException

		{

			int ind =0;
			int sum=0;
			int[][] ar=new int[9][9];

			Scanner g = new Scanner(new File("/home/zemoso9/eclipse_workspace/Practice/src/sudoku/p096_sudokucode.txt"));

			while(g.hasNextLine())
			{	
				g.nextLine();
				for(int i=0;i<9;i++)
				{
					String nextLine = g.nextLine();
					//System.out.println(nextLine);
					for(int j=0;j<9;j++){

						char c = nextLine.charAt(j);
						ar[i][j]=(int)c-48;
						//						System.out.println(ar[i][j]);
					}
				}
				if(solve(ar,ind,sum)){
					//total=total+sum;
				}
				else System.out.println("Error");
			}














			System.out.println(" ");


			System.out.println(" "+total);}






		private static boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
	}











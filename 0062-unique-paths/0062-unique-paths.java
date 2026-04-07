import java.util.* ;
import java.io.*; 
public class Solution {

	public static int f(int m, int n)
	{	int []prev= new int[n];
		int [] temp= new int [n];
		for(int i=0; i<m; i++)
		{	

			for(int j=0; j< n; j++)
			{
				if(i==0 && j==0)
					temp[j]=1; // base case
				//continue;

				else
				{
					int up=0;
					int left=0;
				if(i>0)
				 up= prev[j];
				if(j>0)
				 left= temp[j-1];

				 temp[j]=up+left;

				}
				prev= temp;
			}
		}
		return temp[n-1];

	}
	public static int uniquePaths(int m, int n) {
	
		return f(m, n);
		
		
	}
}
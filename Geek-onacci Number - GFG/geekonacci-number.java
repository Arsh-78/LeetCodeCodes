/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =1 ;i<=t;i++)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    int n = sc.nextInt();
		    System.out.println(geekonacci(a,b,c,n));
		}
	}
	
	public static int geekonacci(int a ,int b,int c,int n)
	{
	    if(n<=1)
	    {
	        return a;
	    }
	    else if(n==2)
	    {
	        return b;
	    }
	    if(n==3)
	    {
	        return c;
	    }
	    
	        return geekonacci(a,b,c,n-1)+geekonacci(a,b,c,n-2)+geekonacci(a,b,c,n-3);
	}
}
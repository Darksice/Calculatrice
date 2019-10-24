package calculatrice;

//enregistrer une operande
//appliquer une operation sur operande
//retourner ensemble operandes stockees

import java.util.Scanner;
import java.util.Stack;

public class MoteurRPN {
	
	public Stack<Integer> pile;
	
	
	public MoteurRPN()
	{
		pile = new Stack<Integer>();
	}
	
	
	public void affichePile()
	{
		if(!pile.empty())
		{
			Stack<Integer> pileTransition = new Stack<Integer>();
			System.out.print("Pile contient : ");
			
			while(!pile.empty())
			{
				int tmp = pile.pop();		
				pileTransition.push(tmp);
			}			
			while(!pileTransition.empty())
			{
				int val = pileTransition.pop();
				System.out.print(val);
				System.out.print(' ');
				pile.push(val);
			}
			System.out.println();
		}	
	}
	
	
	public void gereOperation(char caract)
	{
		int a = pile.pop();
		int b = pile.pop();
		int res = 0;
		
		if(caract == '+')
		{
			try 
			{
				res = Operation.PLUS.eval(b, a);
				System.out.println(res);
				pile.push(res);						
			}
			
			catch(Exception e)
			{
				System.out.println(e);
				pile.push(b);	
				pile.push(a);	
				
			}
		}
		
		if(caract == '-')
		{
			try 
			{
				res = Operation.MOINS.eval(b, a);
				System.out.println(res);
				pile.push(res);						
			}
			
			catch(Exception e)
			{
				System.out.println(e);
				pile.push(b);	
				pile.push(a);	
				
			}
			
		}
		if(caract == '/')
		{
			try 
			{
				res = Operation.DIV.eval(b, a);
				System.out.println(res);
				pile.push(res);						
			}
			
			catch(Exception e)
			{
				System.out.println("Division par 0 impossible");
				pile.push(b);	
				pile.push(a);	
				
			}					
		}
		
		if(caract == '*')
		{
			try 
			{
				res = Operation.MULT.eval(b, a);
				System.out.println(res);
				pile.push(res);						
			}
			
			catch(Exception e)
			{
				System.out.println(e);
				pile.push(b);	
				pile.push(a);	
				
			}
		}
	}
	
	
	
	
	

}

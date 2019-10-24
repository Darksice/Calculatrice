package calculatrice;

import java.util.Scanner;

public class SaisieRPN {
	
	private MoteurRPN m;
	
	public SaisieRPN()
	{
		this.m = new MoteurRPN();
	}
	
	
	
	public boolean verifInt(String s)
	{
		for(int i = 0; i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9')
				return false;
		}
	
		return true;
	}
	
	
	public boolean verifRange(int val)
	{
		try
		{
			if(val>Calculatrice.MAX_VALUE)
				throw new overflowException();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		try
		{
			if(val<Calculatrice.MIN_VALUE)
				throw new minOverflowException();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
		
		
	}
	
	public char lire()
	{
		m.affichePile();
		System.out.println("Taper un caractere ou 'e' pour sortir");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char caract = ' ';
		if(str.length() != 0)
		{
			caract = str.charAt(0);
			if((caract != '+' && caract != '-' && caract != '/' && caract != '*' && caract != 'e') && str.length() != 0)
			{
				if(verifInt(str))
				{
					int val = Integer.parseInt(str);
					if(verifRange(val))
					{
						m.pile.push(val);
					}
				}
			}
			else if(str.length() == 1)
			{
				if(caract == 'e')
				{
					return caract;
				}
				
				if(m.pile.size() < 2)
				{ 
					System.out.println("Opération impossible : il vous manque des opérandes");
				}
				else
				{
					m.gereOperation(caract);
				}
			
			}
		}
		System.out.println();
		return ' ';
	}
	
}

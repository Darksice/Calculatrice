package calculatrice;

public enum Operation {
	
	PLUS('+')
	{
		@Override
		
		public int eval(int opeG, int opeD) throws overflowException
		{
			if(opeG + opeD > Calculatrice.MAX_VALUE)
			{
				throw new overflowException();
			}
			else
			return opeG + opeD;
		}
	},
	MOINS('-')
	{	
		@Override
		
		public int eval(int opeG, int opeD) throws minOverflowException
		{
			if(opeG - opeD < Calculatrice.MIN_VALUE)
			{
				throw new minOverflowException();
			}
			else
				return opeG - opeD;		
		}
		
	},
	DIV('/')
	{	
		@Override
		
		public int eval(int opeG, int opeD) throws ArithmeticException
		{
			if(opeD == 0)
			{
				throw new ArithmeticException();
			}
			return opeG / opeD;
		}
		
	},
	MULT('*')
	{
		@Override
		
		public int eval(int opeG, int opeD) throws overflowException
		{
			if(opeG * opeD > Calculatrice.MAX_VALUE)
			{
				throw new overflowException();
			}
			else
				return opeG * opeD;
		}
		
	};
	
	private char symbole;
	
	private Operation(char pOperator)
	{
		this.symbole = pOperator;
	}
	
	public abstract int eval(int a, int b) throws Exception;

}

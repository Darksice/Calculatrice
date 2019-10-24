package calculatrice;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsUnitaires {

	@Test(expected=overflowException.class)
	public void additionNeDepassePas() throws Exception{
		Operation.PLUS.eval(10001, 0);
	}
	
	@Test(expected=overflowException.class)
	public void multiplicationNeDepassePas() throws Exception{
		Operation.MULT.eval(1000, 30);
	}
	
	@Test(expected=minOverflowException.class)
	public void soustractionNeDepassePas() throws Exception{
		Operation.MOINS.eval(0, 20000);
	}
	
	@Test(expected=ArithmeticException.class)
	public void pasDeDivisionPar0() throws Exception{
		Operation.DIV.eval(30, 0);
	}
	
	@Test
	public void rangeSuperieureAMax(){
		SaisieRPN s = new SaisieRPN();
		assertFalse(s.verifRange(20000));
	}
	
	@Test
	public void rangeInferieureAMax(){
		SaisieRPN s = new SaisieRPN();
		assertFalse(s.verifRange(-20000));
	}
	
	@Test
	public void rangeAcceptee(){
		SaisieRPN s = new SaisieRPN();
		assertTrue(s.verifRange(5876));
	}

}

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
	
	@Test
	public void addAccept() throws Exception {
		int res = Operation.PLUS.eval(4000, 50);
		assertEquals(res,4050);
	}
	
	@Test
	public void minAccept() throws Exception {
		int res = Operation.MOINS.eval(4000, 50);
		assertEquals(res,3950);
	}
	
	@Test
	public void multAccept() throws Exception {
		int res = Operation.MULT.eval(10, 50);
		assertEquals(res,500);
	}
	
	@Test
	public void divAccept() throws Exception {
		int res = Operation.DIV.eval(50, 50);
		assertEquals(res,1);
	}
	
	
	@Test
	public void verifStringFalse() {
		SaisieRPN s = new SaisieRPN();
		assertFalse(s.verifInt("1233e"));
		
	}
	
	@Test
	public void verifStringTrue() {
		SaisieRPN s = new SaisieRPN();
		assertTrue(s.verifInt("1233"));
		
	}
	
	

}

package SC;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalcTest {

	@Test
	public void returnZeroOnEmptyString() {
		assertEquals(0,StringCalc.Add(""));
	}
	
	@Test
	public void returnNumberItselfForOneNumber() {
		assertEquals(2,StringCalc.Add("2"));
	}
	
	@Test
	public void returnAdditionOfTwoNumbers() {
		assertEquals(3,StringCalc.Add("1,2"));
	}
	
	@Test
	public void returnAdditionForAnyAmountOfNumbers() {
		assertEquals(8,StringCalc.Add("5,2,1"));
	}
	
	@Test
	public void returnAdditionForNumbersSeparatedByNewLineAndCommaBoth() {
		assertEquals(8,StringCalc.Add("5,2\n1"));
	}
	
	@Test
	public void returnAdditionForDifferentDelimiters() {
		assertEquals(8,StringCalc.Add("//;\n1;3;4"));
		assertEquals(8,StringCalc.Add("//%\n1%3%4"));
	}
	
	@Test
	public void returnAdditionForSingleSeparater() {
		assertEquals(8,StringCalc.Add("//[**]\n5**2**1"));
	}
	
	@Test
	public void returnAdditionForMultipleSeparater() {
		assertEquals(8,StringCalc.Add("//[***][%]\n5***2%1"));
		assertEquals(8,StringCalc.Add("//[*][%]\n5*2%1"));
		assertEquals(8,StringCalc.Add("//[*$*][%]\n5*$*2%1"));
		assertEquals(8,StringCalc.Add("//[*%%][%]\n5*%%2%1"));
	}
	
	@Test
	public void returnAdditionOfNumbersAftersIgnoringGreaterThan1000() {
		assertEquals(7,StringCalc.Add("//[***][%]\n5***2%1003"));
	}
	
	@Test
	public void exceptionOnNegativeNumber() {
		try {
			StringCalc.Add("-1,2,-3");
			
		}
		catch(Exception ex) {
			assertEquals("negative not allowed -1, -3",ex.getMessage());
		}
	}
	
	
	
	
}

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
	
}

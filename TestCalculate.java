

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCalculate 
{
	private StringCalculator Calculator;
	@Before
	public  void beforeTest() {
		Calculator=new StringCalculator();
		
      
    }
//Question 1
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.Add(""));
	}	@Test
	public void testOneLength()
	{
		assertEquals(1, Calculator.Add("1"));
	}
	@Test
	public void testTwoLength()
	{
		assertEquals(3, Calculator.Add("1,2"));
	}
	//Question 2
		@Test
		public void testUnknownLength()
		{
			assertEquals(15, Calculator.Add("1,2,3,4,5"));
		}


	//Question 3
		@Test
		public void testNewLine()
		{
			assertEquals(6, Calculator.Add("1\n2,3"));
			
			
		}

	//Question 4
		@Test
		public void testNewDelimeter()
		{
			assertEquals(3, Calculator.Add("//;\n1;2"));
			
			
		}
	//Question 5
		@Test
		public void testOneNegative()
		{
			try
			{
				Calculator.Add("-1,2");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "negatives not allowed-1");
			}
		}
	//Question 5(Multiple Negative)
		@Test
		public void testMultipleNegative()
		{
			try
			{
				Calculator.Add("-1,2,-3");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "negatives not allowed-1-3");
			}
		}
	//Question 6
		@Test
		public void testNoGreaterThanthousand()
		{
			assertEquals(2, Calculator.Add("1001,2"));
		}

	//Question 7
		@Test
		public void testDelimiterLengthGreaterThanOne()
		{
			assertEquals(6, Calculator.Add("//[***]\n1***2***3"));
		}
		//Question 8
		@Test
		public void testMultipleDelimeter()
		{
			assertEquals(6, Calculator.Add("//[%][*]\n1%2*3"));
		}
		//Question 9
		
		public void testMultipleDelimeterwithlengthGreaterthanOne()
		{
			assertEquals(6, Calculator.Add("//[%%][**]\n1%%2**3"));
		}

}
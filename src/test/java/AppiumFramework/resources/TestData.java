package AppiumFramework.resources;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public static Object[][] getDataforEditField()
	{
		//2 sets of data, "hello" , "!@#$$"
		Object[][] obj=new Object[][]
				{
			
			{"hello"}, {"@#$%"}
				};
				
				return obj;
				
	}

}

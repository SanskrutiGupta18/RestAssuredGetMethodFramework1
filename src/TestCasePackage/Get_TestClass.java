package TestCasePackage;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import CommonFunctionPackage.APICommonFunction;
import CommonFunctionPackage.UtilityCommonFunction;
import RequestRepository.Get_Method_Repository;
public class Get_TestClass {
@Test
	public static void execute() throws IOException {
		for (int i=0; i<5; i++)
		{
		int statusCode=APICommonFunction.statusCode(Get_Method_Repository.BaseURI(),Get_Method_Repository.resource());
		System.out.println(statusCode);
		if(statusCode==200)
		{
		String responseBody=APICommonFunction.responseBody(Get_Method_Repository.BaseURI(),Get_Method_Repository.resource());
		System.out.println(responseBody);
		Get_TestClass.validator(responseBody);
		UtilityCommonFunction.evidencefilecreator("GetEvidenceTestFile", responseBody);
		break;
		}
		else
		{
			System.out.println("Status code found is incorrect therefore retrying the API");
		}
		}
}		
		public static void validator(String responseBody) {
		JsonPath jsp = new JsonPath(responseBody);
		int datasize = jsp.getList("data").size();
		
		for (int i=0;i<datasize;i++)
		{
			String res_id = jsp.getString("["+i+"].id");
			String res_name = jsp.getString("["+i+"].name");
			String res_email = jsp.getString("["+i+"].email");
			String res_gender = jsp.getString("["+i+"].gender");
			String res_status = jsp.getString("["+i+"].status");
			
			Assert.assertNotNull(res_id);
			Assert.assertNotNull(res_name);
			Assert.assertNotNull(res_email);
			Assert.assertNotNull(res_gender);
			Assert.assertNotNull(res_status);
			
		}
	}
}
		
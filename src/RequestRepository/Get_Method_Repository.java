package RequestRepository;
import org.testng.annotations.BeforeTest;

public class Get_Method_Repository {
@BeforeTest
	public static String BaseURI() {
		String BaseURI = "https://gorest.co.in/";
		return BaseURI;
	}
	
	public static String resource() {
		String resource = "/public/v2/users";
		return resource;
	}
}

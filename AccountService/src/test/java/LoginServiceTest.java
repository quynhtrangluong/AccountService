import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LoginServiceTest {

	private CustomerService customerService;
	private LoginService loginService;

	public LoginServiceTest(){
		customerService = new CustomerService();
		loginService = new LoginService(customerService);
		customerService.createData();
	}
	@Test
	public void testVerifyUserWithCorrectUsernamePasswordReturnsTrue() {
		String correctUsername = "Ahihi";
		String correctPassword = "345";

		boolean actualOutput = loginService.verifyUser(correctUsername, correctPassword);
		Assertions.assertEquals(true, actualOutput);
	}
	@Test
	public void testVerifyUserWithWrongUsernameReturnFalse() {
		String wrongUsername = "Blabla";
		String correctPassword = "345";

		boolean actualOutput = loginService.verifyUser(wrongUsername, correctPassword);
		Assertions.assertEquals(false, actualOutput);
	}

	@Test
	public void testVerifyUserWithWrongPasswordReturnFalse() {
		String correctUsername = "Ahihi";
		String wrongPassword = "344";

		boolean actualOutput = loginService.verifyUser(correctUsername, wrongPassword);
		Assertions.assertEquals(false, actualOutput);
	}

	@Test
	public void testVerifyUserWithWrongUsernamePasswordReturnFalse() {
		String wrongUsername = "Blabla";
		String wrongPassword = "344";

		boolean actualOutput = loginService.verifyUser(wrongUsername, wrongPassword);
		Assertions.assertEquals(false, actualOutput);
	}

	@Test
	public void testVerifyCorrectUsernameReturnTrue(){
		String correctUsername = "TrangLuong";
		boolean actualOutput = loginService.verifyUsername(correctUsername);
		Assertions.assertEquals(true, actualOutput);
	}
	@Test
	public void testVerifyWrongUsernameReturnTrue(){
		String wrongUsername = "Bleble";
		boolean actualOutput = loginService.verifyUsername(wrongUsername);
		Assertions.assertEquals(false, actualOutput);
	}

}

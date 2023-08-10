package testbloodfeature;

import static org.junit.jupiter.api.Assertions.fail;

import bloodDAOexception.DAOException;
import bloodmodel.Request;
import bloodserviceexception.ServicesException;
import bloodservices.RequestService;

public class TestRequestFeature {

	public static void main(String[] args) {
		
		Request user1 = new Request("I need A+ blood", "Thank you for giving blood", "A+", "2012-03-23", "218865870911", "2188658709");
		RequestService requestService = new RequestService();

		try {
			requestService .create(user1);
		} catch (ServicesException | DAOException e) {
			e.printStackTrace();
			fail();
		}

	}


}

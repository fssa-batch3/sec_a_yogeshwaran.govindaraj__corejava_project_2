package testbloodfeature;

import static org.junit.jupiter.api.Assertions.fail;

import bloodDAOexception.DAOException;
import bloodmodel.Request;
import bloodserviceexception.ServicesException;
import bloodservices.RequestService;

public class TestRequestFeature {

	public static void main(String[] args) {
		
		Request user1 = new Request("i need O+ blood group", "Thank you for giving blood", "O+", "2023-08-10", "218965870911", "2188658708");
		RequestService requestService = new RequestService();

		try {
			requestService .create(user1);
		} catch (ServicesException | DAOException e) {
			e.printStackTrace();
			fail();
		}

	}


}

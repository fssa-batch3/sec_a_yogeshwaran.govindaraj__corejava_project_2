package bloodvalidation;

import java.util.regex.Pattern;

import bloodmodel.User;
import bloodvalidationexception.InvalidUserException;

public class UserValidator {
	
	public static boolean Validation(User user)throws InvalidUserException {
		boolean match = false;
		if(user != null && Validatename(user.getname())&&Validateemail(user.getemail()) && Validatepassword(user.getpassword())&& Validatephone(user.getphone())&& Validateaddress(user.getaddress())&& Validateid(user.getid())){
			match = true;
		} else {
			match = false;
		}
		return match;
	}
	


		public static boolean Validatename(String name) {
			boolean match = false;
		
			String regex = "^[A-Za-z0-9]{3,29}";
			match = Pattern.matches(regex,name);
			
			if(match) {
				System.out.println("The user name is validate");
			}else {
				System.out.println("The user name is not validate");
			}
			return match;
		}
			
			public static boolean Validateemail(String email) {
				
				boolean match = false;
				String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
				match = Pattern.matches(emailRegex,email);
				
				if(match) {
					System.out.println("The user email is validate");
				}else {
					System.out.println("The user email is not validate");
				}
				return match;
			}
			
			public static boolean Validatepassword(String password) {
					boolean match = false;
					
					String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
					match = Pattern.matches(passwordRegex, password);
					
					if(match) {
						System.out.println("The user password is validate");
					}else {
						System.out.println("The user password is not validate");
					}
					return match;
			}
			
			public static boolean Validateaddress(String address) {
				
				boolean match = false;
				
				String addressRegex = "^[A-Za-z0-9\\s,.'-]{3,}$";
				match = Pattern.matches(addressRegex,address);
				
			
			
			if(match) {
				System.out.println("The user address is validate");
			}else {
				System.out.println("The user address is not validate");
			}
			return match;
			}
			
			public static boolean Validatephone(String phone) {
				
				boolean match = false;
				String phoneRegex = "^(\\+\\d{1,3})?\\s?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$";
				match = Pattern.matches(phoneRegex, phone);
				
				if(match) {
					System.out.println("The user phone is validate");
				}else {
					System.out.println("The user phone is not validate");
				}
				return match;
			}
				
				public static boolean Validateid(String id) {
					boolean match = false;
					
					String idRegex = "^[0-9]{12}$";
					match = Pattern.matches(idRegex, id);
					
					if(match){
						System.out.println("The user phone is validate");
					}else {
						System.out.println("The user phone is not validate");
					}
					return match;		
				}
			}
		



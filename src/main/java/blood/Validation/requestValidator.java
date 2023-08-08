package blood.Validation;

import java.util.regex.Pattern;

import blood.ValidationException.InvalidUserExecption;
import blood.model.Request;

public class requestValidator {

	public static boolean Validation(Request request)throws InvalidUserExecption {
		
		boolean match = false;
		if(request != null && ValidateBloodGroup(request.getBloodGroup()) && ValidaterequestDate(request.getrequestDate()) && ValidatecontactNo(request.getcontactNo()) ) {
			match = true;
		} else {
			match = false;
		}
		return match;
		}
	
	public static boolean ValidateBloodGroup(String BloodGroup) {
		boolean match = false;
		
		String Regex = "^(A|B|AB|O)[+-]?$";
		match = Pattern.matches(Regex,BloodGroup);
		
		if(match) {
			System.out.println("The request BloodGroup is validate");
		}else {
			System.out.println("The request BloodGroup is not validate");
		}
		
		return match;
	}
	
	public static boolean ValidaterequestDate(String requestDate) {
		
		boolean match = false;
		String dateRegex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
		match = Pattern.matches(dateRegex,requestDate);
		
		if(match) {
			System.out.println("The request requestDate is validate");
		}
		else {
			System.out.println("The request requestDate is not validate");
		}
		
		return match;
	}
	
	
	public static boolean ValidatecontactNo(String contactNo) {
		boolean match = false;
		
		String NumberRegex = "^[0-9]{10}$";
		match = Pattern.matches(NumberRegex, contactNo);
		
		if(match) {
			System.out.println("The request contactNo is validate");
		}
		else {
			System.out.println("The request contactNo is not validate");
		}
		return match;
	}
	
}

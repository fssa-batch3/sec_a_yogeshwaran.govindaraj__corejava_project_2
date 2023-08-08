package blood.model;

public class Request {
	
	public String title;
	public String description;
	public String BloodGroup;
	public String requestDate;
	public String id;
	public String contactNo;
	
	public Request(String title, String description,String BloodGroup,String requestDate,String id,String contactNo) {
		this.title = title;
		this.description = description;
		this.BloodGroup = BloodGroup;
		this.requestDate = requestDate;
		this.id= id;
		this.contactNo = contactNo;
	}
	
	public void settitle(String title) {
		this.title = title;
	}
	
	public void setdescription(String description) {
		this.description =  description;
	}
	
	public void setBloodGroup(String BloodGroup) {
		this.BloodGroup = BloodGroup;
	}
	

	public void setrequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	
	public void setcontactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	

	public String gettitle() {
		return title;
	}
	
	public String getdescription() {
		return description;
	}
	
	public String getBloodGroup() {
		return BloodGroup;
	}
	
	public String getrequestDate() {
		return requestDate;
	}
	
	public String getid() {
		return id;
	}
	
	public String getcontactNo() {
		return contactNo;
	}



	
}

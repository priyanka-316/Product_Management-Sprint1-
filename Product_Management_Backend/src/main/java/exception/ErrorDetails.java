package exception;

import java.util.Date;

public class ErrorDetails {


	private Date timestamp;
	private String meassage;
	private String details;
	
	

	public ErrorDetails(Date timestamp, String meassage, String details) {
		super();
		this.timestamp = timestamp;
		this.meassage = meassage;
		this.details = details;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getMeassage() {
		return meassage;
	}


	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}

package app.webservice;

/**
 * Class meant to create status objects returned by the web service
 * 
 * @author Rubén Jiménez Goñi
 */
public class StatusResponse {

	/**
	 * Whether the web service succeded or not
	 */
	private String status;

	/**
	 * Allows to set a status
	 * 
	 * @param status
	 *            Status to be set in the response
	 */
	public StatusResponse(String status) {
		this.status = status;
	}

	/**
	 * Returns the status set
	 * 
	 * @return Status
	 */
	public String getStatus() {
		return status;
	}
}

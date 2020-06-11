package mx.profuturo.ap.middle.service.exception;

public class RestClientException extends RuntimeException {

	
	  
		/**
	 * 
	 */
	private static final long serialVersionUID = -1311019714084831927L;

		/**
	     * @param msg
	     */
	    public RestClientException(String msg) {
	        super(msg);
	    }
	    
	    /**
	     * @param mensaje
	     * @param exception
	     */
	    public RestClientException(String mensaje, Throwable exception) {
	        super(mensaje);
	    }

}

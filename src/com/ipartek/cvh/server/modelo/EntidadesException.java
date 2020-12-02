package com.ipartek.cvh.server.modelo;

public class EntidadesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6600675486993454894L;

	public EntidadesException() {
	}

	public EntidadesException(String message) {
		super(message);
	}

	public EntidadesException(Throwable cause) {
		super(cause);
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}	
}

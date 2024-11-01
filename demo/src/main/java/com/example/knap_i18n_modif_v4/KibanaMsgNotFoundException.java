package com.example.knap_i18n_modif_v4;

import lombok.Getter;

public class KibanaMsgNotFoundException extends Exception {
	
	@Getter
	private final String msgCode;
	
	/**
	 * Constructs a new exception with the specified detail message.  The
	 * cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for
	 *                later retrieval by the {@link #getMessage()} method.
	 */
	public KibanaMsgNotFoundException(String message) {
		super(message);
		msgCode = null;
	}
	
	public KibanaMsgNotFoundException(String message, String msgCode) {
		super(message);
		this.msgCode = msgCode;
	}
	
	
	public KibanaMsgNotFoundException(String message, Throwable cause) {
		super(message, cause);
		msgCode = null;
	}
	
	
}


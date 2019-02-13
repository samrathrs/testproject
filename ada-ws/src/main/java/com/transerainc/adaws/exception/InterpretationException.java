package com.transerainc.adaws.exception;

/**
 * Encompasses exceptions with encryption/decryption
 * and xml parsing of server messages.
 * 
 * @author rajeev.lochanam
 */
public class InterpretationException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public InterpretationException() {
        super();
    }

    /**
     * @param message
     */
    public InterpretationException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public InterpretationException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public InterpretationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

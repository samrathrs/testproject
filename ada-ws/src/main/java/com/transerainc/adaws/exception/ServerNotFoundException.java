/**
 * 
 */
package com.transerainc.adaws.exception;

/**
 * @author rajeev.lochanam
 */
public class ServerNotFoundException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ServerNotFoundException() {
        super();
    }

    /**
     * @param message
     */
    public ServerNotFoundException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ServerNotFoundException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ServerNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

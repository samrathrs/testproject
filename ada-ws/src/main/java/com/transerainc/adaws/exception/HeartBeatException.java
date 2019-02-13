/**
 * 
 */
package com.transerainc.adaws.exception;

/**
 * @author rajeev.lochanam
 */
public class HeartBeatException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public HeartBeatException() {
        super();
    }

    /**
     * @param message
     */
    public HeartBeatException(final String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public HeartBeatException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public HeartBeatException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

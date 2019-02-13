/**
 *
 */
package com.transerainc.adaws.exception;

/**
 * @author rajeev.lochanam
 */
public class BaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public BaseException(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public BaseException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param cause
     */
    public BaseException() {
        super();
    }

}

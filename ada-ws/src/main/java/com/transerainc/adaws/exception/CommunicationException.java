/**
 *
 */
package com.transerainc.adaws.exception;

/**
 * @author varsha.shivaram
 */
public class CommunicationException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public CommunicationException(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public CommunicationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public CommunicationException(final Throwable cause) {
        super(cause);
    }

}

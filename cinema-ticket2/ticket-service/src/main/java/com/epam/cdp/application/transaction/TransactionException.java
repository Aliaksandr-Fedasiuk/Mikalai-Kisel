package com.epam.cdp.application.transaction;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class TransactionException extends RuntimeException {

    public TransactionException(String message) {
        super(message);
    }
}

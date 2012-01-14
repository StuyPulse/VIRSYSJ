package edu.wpi.first.wpilibj.util;
public class CheckedAllocationException extends RuntimeException {

    /**
     * Create a new AllocationException
     * @param msg the message to attach to the exception
     */
    public CheckedAllocationException(String msg) {
        super(msg);
    }
}
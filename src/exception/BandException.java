package exception;

public class BandException extends Exception {

    public BandException(String message) {
        super(message);
    }

    public BandException(String message, Throwable cause) {
        super(message, cause);
    }
}
package Exceptions;

/**
 * Created by e.dima on 19.7.17.
 */
public class TooLongConnectionToServerException extends Exception{

    public TooLongConnectionToServerException() {
        super("Too long connection to server...");
    }
}

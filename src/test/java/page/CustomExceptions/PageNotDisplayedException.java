package page.CustomExceptions;

public class PageNotDisplayedException extends Exception {
    public PageNotDisplayedException(String reason) {
        super(reason);
    }
}

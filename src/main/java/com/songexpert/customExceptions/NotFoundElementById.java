package customExceptions;

public class NotFoundElementById extends RuntimeException{
    @Override
    public String getMessage() {
        return "Element with this id doesn't exist";
    }
}

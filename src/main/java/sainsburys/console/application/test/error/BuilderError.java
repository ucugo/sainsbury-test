package sainsburys.console.application.test.error;

public class BuilderError extends RuntimeException {

    private final String message;

    public BuilderError(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

package spring.io.restfulAPI.Service;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

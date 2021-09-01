package exceptions;

public class UserNotDefinedException extends Exception{
    @Override
    public void printStackTrace() {
        System.err.println("User is null. You created browser without user object, using default account.");
        super.printStackTrace();
    }
}

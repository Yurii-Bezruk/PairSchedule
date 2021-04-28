package exceptions;

public class PairNotAvailableException extends Exception{
    private final int pairNumber;
    public PairNotAvailableException(int pairNumber) {
        this.pairNumber = pairNumber;
    }

    @Override
    public void printStackTrace() {
        System.err.println("Such pair is not available in this day :"+pairNumber);
        super.printStackTrace();
    }
}

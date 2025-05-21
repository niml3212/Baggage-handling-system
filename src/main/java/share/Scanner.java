package share;

import Interfaces.IScanner;
import lombok.Builder;


public abstract class Scanner implements IScanner {

    private String location;
    private String prewiousLocation;

    //private String destination;

    /*
    public boolean scanBaggage(BaggageTag baggageTag) {
        if (baggageTag.getDestination().equals(destination)) {
            System.out.println("Baggage scanned successfully.");
            return true;
        } else {
            System.out.println("Baggage scanned successfully.");
            return false;
        }
    }*/
}

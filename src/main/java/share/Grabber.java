package share;

import Interfaces.IBaggageTaker;
import Interfaces.IDestinationBelt;
import Interfaces.IGrabber;
import Interfaces.IScanner;
import lombok.Builder;
import lombok.Setter;


@Builder
public class Grabber implements IGrabber {
    private Baggage baggage;
    @Setter
    private IScanner scanner;
    @Setter
    private IBaggageTaker container;
    @Setter
    private IDestinationBelt destinationBelt;


    public boolean grabOneBaggage() {
        baggage =  destinationBelt.popBaggage();
        if (baggage == null) return false;
        scanner.scanBaggage(baggage.getBaggageTag());
        container.takeBaggage(baggage);
        return true;
    }
}

package share;


import Interfaces.IBaggageTagPrinter;
import Interfaces.IScanner;
import Interfaces.IBaggageTaker;

import lombok.Setter;
import manager.ControlModule;


public class CheckinDesk {
    private IScanner scanner;
    private IBaggageTagPrinter baggageTagPrinter = new BaggageTagPrinter();
    @Setter
    private IBaggageTaker takeBaggage;

    public CheckinDesk(ControlModule controlModule) {
        this.scanner = new CheckinScanner(controlModule);

    }

    public void checkInBaggage(Baggage baggage, Destination destination) {
        baggage.setBaggageTag(baggageTagPrinter.printTag(destination));
        scanner.scanBaggage(baggage.getBaggageTag());

        takeBaggage.takeBaggage(baggage);
    }




}

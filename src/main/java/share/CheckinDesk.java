package share;


import Interfaces.IBaggageTagPrinter;
import Interfaces.IScanner;
import Interfaces.ITakeBaggage;

import lombok.Setter;
import manager.ControlModul;


public class CheckinDesk {
    private IScanner scanner;
    private IBaggageTagPrinter baggageTagPrinter = new BaggageTagPrinter();
    @Setter
    private ITakeBaggage takeBaggage;

    public CheckinDesk(ControlModul controlModul) {
        this.scanner = new CheckinScanner(controlModul);

    }

    public void checkInBaggage(Baggage baggage, Destination destination) {
        baggage.setBaggageTag(baggageTagPrinter.printTag(destination));
        scanner.scanBaggage(baggage.getBaggageTag());

        takeBaggage.takeBaggage(baggage);
    }




}

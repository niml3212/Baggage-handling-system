package share;


import Interfaces.IBaggageTagPrinter;
import Interfaces.IScanner;
import manager.ControlModul;


public class CheckinDesk {
    private IScanner scanner;
    private IBaggageTagPrinter baggageTagPrinter = new BaggageTagPrinter();

    public CheckinDesk(ControlModul controlModul) {
        this.scanner = new CheckinScanner(controlModul);
    }
    public void checkInBaggage(Baggage baggage, Destination destination) {
        baggage.setBaggageTag(baggageTagPrinter.prtintTag(destination));
        scanner.scanBaggage(baggage.getBaggageTag());
    }




}

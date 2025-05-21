package share;


import Interfaces.IBaggageTagPrinter;
import Interfaces.IScanner;

public class CheckinDesk {
    private IScanner scanner = new Scanner();
    private IBaggageTagPrinter baggageTagPrinter = new BaggageTagPrinter();

        public void checkInBaggage(Baggage baggage, Destination destination) {
            baggageTagPrinter.prtintTag(destination);
        }


}

import lombok.Builder;
import share.Baggage;
import share.CheckinDesk;
import share.Destination;

import java.security.Provider;

@Builder
public class Application {
    public static void main(String[] args) {

        Baggage baggage = new Baggage();

        CheckinDesk checkinDesk = new CheckinDesk();
        checkinDesk.checkInBaggage(baggage, Destination.BER);

    }
}

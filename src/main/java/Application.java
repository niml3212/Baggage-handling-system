import lombok.Builder;
import lombok.Setter;
import manager.ControlModul;
import share.Baggage;
import share.CheckinDesk;
import share.Destination;
import lombok.extern.slf4j.Slf4j;

import java.security.Provider;

@Slf4j
@Builder
public class Application {
    public static void main(String[] args) {

        Baggage baggage = new Baggage();
        ControlModul controlModul = ControlModul.builder().build();
        CheckinDesk checkinDesk = new CheckinDesk(controlModul);
        checkinDesk.checkInBaggage(baggage, Destination.BER);

        log.info(controlModul.getBaggageMap().toString());
    }
}

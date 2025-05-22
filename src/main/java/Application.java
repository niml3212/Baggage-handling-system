import lombok.Builder;
import lombok.Setter;
import manager.ControlModul;
import share.*;
import lombok.extern.slf4j.Slf4j;

import java.security.Provider;

@Slf4j
@Builder
public class Application {
    public static void main(String[] args) {

        Baggage baggage = new Baggage();
        ControlModul controlModul = ControlModul.builder().build();
        CheckinDesk checkinDesk = new CheckinDesk(controlModul);
        CameraModul cameraModul = CameraModul.builder()
                .controlModul(controlModul)
                .build();


        ConveyorBelt conveyorBelt = ConveyorBelt.builder()
                .controlModul(controlModul)
                .cameraModul(cameraModul)
                .location("Eingangsband")
                .build();
        checkinDesk.setTakeBaggage(conveyorBelt);
        checkinDesk.checkInBaggage(baggage, Destination.BER);



        log.info(controlModul.getBaggageMap().toString());
    }
}

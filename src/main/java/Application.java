import lombok.Builder;
import manager.ControlModule;
import share.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Application {
    public static void main(String[] args) {

        Baggage baggage = new Baggage();
        ControlModule controlModule = ControlModule.builder().build();
        CheckinDesk checkinDesk = new CheckinDesk(controlModule);
        CameraModul cameraModul = CameraModul.builder()
                .controlModule(controlModule)
                .build();

        CheckinConveyorBelt checkinConveyorBelt = CheckinConveyorBelt.builder()
                .controlModule(controlModule)
                .cameraModul(cameraModul)
                .build();
        checkinDesk.setTakeBaggage(checkinConveyorBelt);

        SortingBelt sortingBelt = SortingBelt.builder()
                .controlModule(controlModule)
                .build();
        checkinConveyorBelt.setBaggageTaker(sortingBelt);






        checkinDesk.checkInBaggage(baggage, Destination.BER);
        log.info(controlModule.getBaggageMap().toString());
    }
}

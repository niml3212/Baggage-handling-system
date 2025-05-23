import Interfaces.IBaggageTagPrinter;
import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Setter;
import manager.ControlModule;
import share.*;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

        SecurityCheck securityCheck = SecurityCheck.builder()
                .controlModule(controlModule)
                .build();

        BufferBelt bufferBelt = BufferBelt.builder()
                .controlModule(controlModule)
                .build();

        SortingBelt sortingBelt = SortingBelt.builder()
                .controlModule(controlModule)
                .securityCheck(securityCheck)
                .bufferBelt(bufferBelt)
                .build();
        checkinConveyorBelt.setBaggageTaker(sortingBelt);


        securityCheck.setSortingBelt(sortingBelt);

        Map<Destination, IBaggageTaker> sortingMap =  sortingBelt.getSortingMap();

        LinkedList<Grabber> grabbers = new LinkedList<>();
        for(Destination destination: Destination.values()){
            DestinationBelt destinationBelt = DestinationBelt.builder().destination(destination).controlModule(controlModule).sortingBelt(sortingBelt).build();
            Container container = new Container();
            Grabber grabber = Grabber.builder().destinationBelt(destinationBelt).scanner(new ExitScanner(controlModule)).container(new GroundContainer()).build();
            grabbers.addLast(grabber);
            sortingMap.put(destination, destinationBelt);
        }



        Random random = new Random();
        Destination destinations[] = Destination.values();
        for (int i = 0; i < 350; i++ ){
            checkinDesk.checkInBaggage(baggage, destinations[random.nextInt(destinations.length)]);

            grabbers.get(i% grabbers.size()).grabOneBaggage();

            //log.info(controlModule.getBaggageMap().toString());
        }

    }
}

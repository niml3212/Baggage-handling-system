package share;

import Interfaces.IConveyorBelt;
import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import manager.ControlModule;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Builder
public class SortingBelt implements IConveyorBelt {
    @Builder.Default
    private Status status = Status.ACTIVE;
    private final ControlModule controlModule;
    private Baggage baggage;
    @Builder.Default
    private Random random = new Random();
    @Builder.Default
    @Getter
    private Map<Destination, IBaggageTaker> sortingMap = new HashMap<>();
    private BufferBelt bufferBelt;
    @Setter
    private IBaggageTaker securityCheck;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        Destination destination = baggage.getBaggageTag().getDestination();
        IBaggageTaker destinationBelt = sortingMap.get(destination);

        if (random.nextInt(0,100) < 10){
            securityCheck.takeBaggage(baggage);

        } else {
            if (!destinationBelt.takeBaggage(baggage)) {
                controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), "buffered");
                bufferBelt.takeBaggage(baggage);
            }
        }
        return true;
    }

    public Baggage retrieveBaggageFromBuffer(Destination destination){
        return bufferBelt.getBaggage(destination);
    }

    @Override
    public boolean startBelt() {
        this.status=Status.ACTIVE;
        return true;
    }

    @Override
    public boolean stopBelt() {
        this.status=Status.STOP;
        return true;
    }


}

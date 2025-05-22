package share;

import Interfaces.IConveyorBelt;
import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import manager.ControlModule;

import java.util.HashMap;
import java.util.Map;


@Builder
public class SortingBelt implements IConveyorBelt {
    @Builder.Default
    private Status status = Status.ACTIVE;
    private ControlModule controlModule;
    private Baggage baggage;
    @Setter
    private IBaggageTaker baggageTaker;
    @Builder.Default
    @Getter
    private Map<Destination, IBaggageTaker> sortingMap = new HashMap<>();
    private BufferBelt bufferBelt;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        Destination destination = baggage.getBaggageTag().getDestination();
        IBaggageTaker destinationBelt = sortingMap.get(destination);
        if (!destinationBelt.takeBaggage(baggage)){
            bufferBelt.takeBaggage(baggage);
            controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), "full");
        }
        return true;
    }

    public Baggage retrieveBaggageFromBuffer(Destination destination){
        return bufferBelt.getBaggage(destination);
    }

    @Override
    public boolean startBelt() {
        this.status=Status.ACTIVE;
        baggageTaker.takeBaggage(baggage);
        this.baggage=null;
        return true;
    }

    @Override
    public boolean stopBelt() {
        this.status=Status.STOP;
        return true;
    }
}

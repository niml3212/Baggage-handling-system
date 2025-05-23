package share;

import Interfaces.IBaggageTaker;
import Interfaces.IDestinationBelt;
import lombok.Builder;
import manager.ControlModule;

import java.util.LinkedList;


@Builder
public class DestinationBelt implements IBaggageTaker, IDestinationBelt {
    @Builder.Default
    private final byte size = 21;
    @Builder.Default
    private final LinkedList<Baggage> list = new LinkedList<>();
    private final SortingBelt sortingBelt;
    private final Destination destination;
    private final ControlModule controlModule;
    private final String location = "Destination Belt";

    @Override
    public boolean takeBaggage(Baggage baggage) {
        if (list.size() < size){
            controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), destination.getName());
            list.addLast(baggage);
            controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), location);
            return true;
        }
        return false;
    }

    public Baggage popBaggage() {
        Baggage result = list.pollFirst();
        if (list.size() == size -1){
            Baggage baggage = sortingBelt.retrieveBaggageFromBuffer(destination);
            if(baggage != null){
                list.addLast(baggage);
            }
        }
        return result;
    }
}

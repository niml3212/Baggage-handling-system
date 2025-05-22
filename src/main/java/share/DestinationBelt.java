package share;

import Interfaces.IBaggageTaker;
import lombok.Builder;
import manager.ControlModule;

import java.util.Collection;
import java.util.LinkedList;

@Builder
public class DestinationBelt implements IBaggageTaker {
    @Builder.Default
    private final byte size = 21;
    @Builder.Default
    private final LinkedList<Baggage> list = new LinkedList<>();
    private final SortingBelt sortingBelt;
    private final Destination destination;
    private final ControlModule controlModule;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        if (list.size() < size){
            controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), destination.name());
            list.addLast(baggage);
            return true;
        }
        return false;
    }

    public Baggage popBaggage() {
        Baggage result = list.removeFirst();
        if (list.size() == size -1){
            Baggage baggage = sortingBelt.retrieveBaggageFromBuffer(destination);
            if(baggage != null){
                list.addLast(baggage);
            }
        }
        return result;
    }
}

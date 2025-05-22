package share;

import Interfaces.IBaggageTaker;
import Interfaces.IConveyorBelt;
import lombok.Builder;
import manager.ControlModule;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@Builder
public class BufferBelt implements IBaggageTaker {
    @Builder.Default
    private LinkedList<Baggage> list = new LinkedList<>();
    private final ControlModule controlModule;

    public boolean takeBaggage(Baggage baggage){
        this.list.add(baggage);
        controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), "buffered");
        return true;
    }

    public Baggage getBaggage(Destination destination){
        Iterator<Baggage> it = list.iterator();
        while (it.hasNext()){
            Baggage baggage = it.next();
            if(baggage.getBaggageTag().getDestination().equals(destination)){
                it.remove();
                return baggage;
            }
        }
        return null;
    }
}

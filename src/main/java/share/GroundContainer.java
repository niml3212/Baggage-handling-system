package share;

import Interfaces.IBaggageTaker;
import lombok.Builder;
import java.util.ArrayDeque;

@Builder
public class GroundContainer implements IBaggageTaker{
    @Builder.Default
    private ArrayDeque<Baggage> containerContent = new ArrayDeque<>();

    @Override
    public boolean takeBaggage(Baggage baggage) {
        containerContent.addLast(baggage);
        return true;
    }
}

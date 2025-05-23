package share;

import Interfaces.IBaggageTaker;

import java.util.ArrayDeque;


public class GroundContainer implements IBaggageTaker{
    private final ArrayDeque<Baggage> containerContent = new ArrayDeque<>();

    @Override
    public boolean takeBaggage(Baggage baggage) {
        containerContent.addLast(baggage);
        return true;
    }
}

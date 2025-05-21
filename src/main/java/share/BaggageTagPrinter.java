package share;

import Interfaces.IBaggageTagPrinter;

import java.util.UUID;

public class BaggageTagPrinter implements IBaggageTagPrinter {

    @Override
    public BaggageTag prtintTag() {
        return new BaggageTag(UUID.randomUUID(), );
    }
}

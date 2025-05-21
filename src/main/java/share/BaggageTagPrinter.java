package share;

import Interfaces.IBaggageTagPrinter;
import lombok.Data;


import java.util.UUID;


@Data
public class BaggageTagPrinter implements IBaggageTagPrinter {

    @Override
    public BaggageTag prtintTag(Destination destination) {
        return new BaggageTag(UUID.randomUUID(), destination );
    }
}

package share;

import Interfaces.IBaggageTagPrinter;
import lombok.Data;

import java.util.UUID;

@Data
public class BaggageTagPrinter implements IBaggageTagPrinter {

    @Override
    public BaggageTag printTag(Destination destination) {
        return new BaggageTag(destination,UUID.randomUUID());
    }


}

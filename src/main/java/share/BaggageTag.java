package share;

import lombok.Data;
import java.util.UUID;

@Data
public class BaggageTag {
    private final Destination destination;
    private final UUID id;

}

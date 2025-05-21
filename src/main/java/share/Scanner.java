package share;

import Interfaces.IScanner;
import lombok.Builder;


@Builder
public class Scanner implements IScanner {

    private String location;
    private String prewiousLocation;
    private Destination destination;
}

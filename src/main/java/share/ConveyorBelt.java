package share;

import Interfaces.IConveyorBelt;
import lombok.Builder;
import manager.ControlModul;

@Builder
public class ConveyorBelt implements IConveyorBelt {
    private final String location;
    private final ControlModul controlModul;
    private Baggage baggage;
    private Status status;
    private final CameraModul cameraModul;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        if(status != Status.ACTIVE) return false;
        this.baggage = baggage;
        controlModul.logMessage("Box entgegengenommen");
        controlModul.updateBaggageRecord(baggage.getBaggageTag().getId(), location);
        if(!cameraModul.scanBaggage(baggage.getBaggageTag())) status = Status.STOP;
        return true;
        }


}

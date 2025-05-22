package share;

import Interfaces.IConveyorBelt;
import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Setter;
import manager.ControlModule;

@Builder
public class CheckinConveyorBelt implements IConveyorBelt {
    @Builder.Default
    private final String location="Entry Belt";
    private final ControlModule controlModule;
    private Baggage baggage;
    @Builder.Default
    private Status status = Status.ACTIVE;
    private final CameraModul cameraModul;
    @Setter
    private IBaggageTaker baggageTaker;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        if (status != Status.ACTIVE) return false;
        this.baggage = baggage;
        controlModule.logMessage("Box received");
        controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), location);
        if (!cameraModul.scanBaggage(baggage.getBaggageTag())){
            status = Status.STOP;
        } else {
            baggageTaker.takeBaggage(baggage);
            this.baggage=null;
        }
        return true;
    }

    @Override
    public boolean startBelt() {
        this.status=Status.ACTIVE;
        if(!baggageTaker.takeBaggage(baggage))status=Status.STOP;
        else this.baggage = null;

        return true;
    }

    @Override
    public boolean stopBelt() {
        this.status=Status.STOP;
        return true;
    }
}

package share;

import Interfaces.IScanner;
import lombok.Builder;
import manager.ControlModule;

@Builder
public class CameraModul implements IScanner {
    private final ControlModule controlModule;

    @Override
    public boolean scanBaggage(BaggageTag baggageTag) {
        if(controlModule.checkBaggageRecord(baggageTag.getId(),"Entry Belt")){
            controlModule.updateBaggageRecord(baggageTag.getId(), "first Scanpoint");
            return true;
        } else {
            controlModule.logMessage("Error Checking Baggage! CheckinConveyorBelt Stopped");
            return false;
        }
    }
}

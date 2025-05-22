package share;

import Interfaces.IScanner;
import Interfaces.ITakeBaggage;
import lombok.Builder;
import manager.ControlModul;

@Builder
public class CameraModul implements IScanner {
    private final ControlModul controlModul;

    @Override
    public boolean scanBaggage(BaggageTag baggageTag) {
        if(controlModul.checkBaggageRecord(baggageTag.getId(),"Entry Belt")){
            controlModul.updateBaggageRecord(baggageTag.getId(), "first Scanpoint");
            return true;
        } else {
            controlModul.logMessage("Error Checking Baggage! ConveyorBelt Stopped");

            return false;
        }
    }
}

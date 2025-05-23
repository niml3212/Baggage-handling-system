package share;

import Interfaces.IScanner;
import lombok.AllArgsConstructor;
import manager.ControlModule;

@AllArgsConstructor
public class ExitScanner implements IScanner {

    private final ControlModule controlModule;

    @Override
    public boolean scanBaggage(BaggageTag baggageTag) {
        if(controlModule.checkBaggageRecord(baggageTag.getId(), "Destination Belt")){
            controlModule.updateBaggageRecord(baggageTag.getId(), "done");
            return true;
        }


        return false;
    }
}

package share;

import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import manager.ControlModule;


@Slf4j
@Builder
public class SecurityCheck implements IBaggageTaker {
    private Baggage baggage;
    private final ControlModule controlModule;
    @Setter
    private IBaggageTaker sortingBelt;

    @Override
    public boolean takeBaggage(Baggage baggage) {
        if(controlModule.checkBaggageRecord(baggage.getBaggageTag().getId(), "first Scanpoint")){
            log.info("Security check completed");
            controlModule.updateBaggageRecord(baggage.getBaggageTag().getId(), "security checked");
            sortingBelt.takeBaggage(baggage);
        };
        return true;
    }
}

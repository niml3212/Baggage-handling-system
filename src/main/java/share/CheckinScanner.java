package share;

import Interfaces.IScanner;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import manager.ControlModule;

@Builder
@RequiredArgsConstructor
public class CheckinScanner implements IScanner {
    private final ControlModule controlModule;

    public boolean scanBaggage(BaggageTag baggageTag) {
        BaggageRecord baggageRecord = BaggageRecord.builder()
                .location("CheckinDesk")
                .destination(baggageTag.getDestination())
                .build();
        controlModule.addBaggageRecord(baggageTag.getId(),baggageRecord);
        return true;
    }
}

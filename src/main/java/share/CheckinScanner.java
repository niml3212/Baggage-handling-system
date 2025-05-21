package share;

import Interfaces.IScanner;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import manager.ControlModul;

@Builder
@RequiredArgsConstructor
public class CheckinScanner implements IScanner {
    private final ControlModul controlModul;

    public boolean scanBaggage(BaggageTag baggageTag) {
        BaggageRecord baggageRecord = BaggageRecord.builder()
                .location("CheckinDesk")
                .destination(baggageTag.getDestination())
                .build();
        controlModul.addBaggageRecord(baggageTag.getId(),baggageRecord);
        return true;
    }
}

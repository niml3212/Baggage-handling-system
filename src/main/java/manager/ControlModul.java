package manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import share.BaggageRecord;

@Builder
public class ControlModul {
    @Builder.Default
    private Map<UUID, BaggageRecord> BaggageMap = new HashMap<>();

    public boolean addBaggageRecord(UUID id, BaggageRecord baggageRecord) {
        BaggageMap.put(id, baggageRecord);
        return true;
    }
}

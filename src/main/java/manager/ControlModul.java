package manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import share.BaggageRecord;

@Getter
@Builder
public class ControlModul {
    @Builder.Default
    private final Map<UUID, BaggageRecord> BaggageMap = new HashMap<>();

    public boolean addBaggageRecord(UUID id, BaggageRecord baggageRecord) {
        BaggageMap.put(id, baggageRecord);
        return true;
    }
}

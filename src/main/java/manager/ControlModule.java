package manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import share.BaggageRecord;

@Slf4j
@Getter
@Builder
public class ControlModule {
    @Builder.Default
    private final Map<UUID, BaggageRecord> BaggageMap = new HashMap<>();

    public boolean addBaggageRecord(UUID id, BaggageRecord baggageRecord) {
        BaggageMap.put(id, baggageRecord);
        return true;
    }

    public boolean updateBaggageRecord(UUID id, String location){
        BaggageMap.get(id).setLocation(location);
        return true;
    }

    public boolean checkBaggageRecord(UUID id, String location){
        return BaggageMap.get(id).getLocation().equals(location);
    }

    public void logMessage(String message){
        log.info(message);
    }

}

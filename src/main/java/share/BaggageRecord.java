package share;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BaggageRecord {

    private String location;
    private Destination destination;

    //private String status;
}

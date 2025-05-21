package share;


import lombok.Builder;

@Builder
public class BaggageRecord {

    private String location;
    private Destination destination;

    //private String status;
}

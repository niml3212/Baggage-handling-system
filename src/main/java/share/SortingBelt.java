package share;

import Interfaces.IConveyorBelt;
import Interfaces.IBaggageTaker;
import lombok.Builder;
import lombok.Setter;
import manager.ControlModule;

@Builder
public class SortingBelt implements IConveyorBelt {
    @Builder.Default
    private Status status = Status.ACTIVE;
    private ControlModule controlModule;
    private Baggage baggage;
    @Setter
    private IBaggageTaker baggageTaker;

    @Override
    public boolean takeBaggage(Baggage baggage) {

        return true;
    }

    @Override
    public boolean startBelt() {
        this.status=Status.ACTIVE;
        baggageTaker.takeBaggage(baggage);
        this.baggage=null;
        return true;
    }

    @Override
    public boolean stopBelt() {
        this.status=Status.STOP;
        return true;
    }
}

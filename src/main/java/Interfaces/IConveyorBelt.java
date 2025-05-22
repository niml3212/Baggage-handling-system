package Interfaces;

import share.Baggage;

public interface IConveyorBelt extends IBaggageTaker {

    @Override
    public boolean takeBaggage(Baggage baggage);

    public boolean startBelt();

    public boolean stopBelt();


}

package share;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Destination{

    HND("Tokyo Haneda Airport"),
    NRT("Tokyo Narita Airport"),
    LAX("Los Angeles International Airport"),
    TFS("Tenerife South Airport"),
    MAD("Adolfo Suárez Madrid–Barajas Airport"),
    PVG("Shanghai Pudong International Airport"),
    SEA("Seattle–Tacoma International Airport"),
    JFK("John F. Kennedy International Airport"),
    FRA("Frankfurt Airport"),
    LHR("London Heathrow Airport"),
    SIN("Singapore Changi Airport"),
    BOG("El Dorado International Airport"),
    SFO("San Francisco International Airport"),
    PKG("Peking Capital International Airport"),
    BER("Berlin Brandenburg Airport"),
    ZRH("Zurich Airport"),
    PAR("Paris Charles de Gaulle Airport"),
    HKG("Hong Kong International Airport"),
    MEX("Mexico City International Airport"),
    DUB("Dubai International Airport"),
    ABD("Abu Dhabi International Airport"),
    PAT("Pattaya International Airport"),
    DEL("Indira Gandhi International Airport"),
    MOS("Moscow Sheremetyevo International Airport"),
    STO("Stockholm Arlanda Airport"),
    NJN("Nanjing Lukou International Airport"),
    HOU("George Bush Intercontinental Airport");

    private final String name;

    Destination(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
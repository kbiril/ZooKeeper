package be.vdab.dieren;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public class Krokodil extends Reptiel{
    private final String naam;
    private BigDecimal lengteInMeter;
    private BigDecimal gewichtInKilo;

    public Krokodil(String naam, BigDecimal lengteInMeter, BigDecimal gewichtInKilo) {
        super();
        this.lengteInMeter = lengteInMeter;
        this.gewichtInKilo = gewichtInKilo;
        this.naam = naam;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    public BigDecimal getLengteInMeter() {
        return lengteInMeter;
    }

    public final void setLengteInMeter(BigDecimal lengteInMeter) {
        if (lengteInMeter.compareTo(BigDecimal.ZERO) > 0) {
            this.lengteInMeter = lengteInMeter;
        } throw new IllegalArgumentException("Lengte moet een positief getal zijn!");
    }

    public BigDecimal getGewichtInKilo() {
        return gewichtInKilo;
    }

    public final void setGewichtInKilo(BigDecimal gewichtInKilo) {
        if (gewichtInKilo.compareTo(BigDecimal.ZERO) > 0) {
            this.gewichtInKilo = gewichtInKilo;
        } throw new IllegalArgumentException("Gewicht moet een positief getal zijn!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Krokodil krokodil)) return false;

        return super.equals(o) && lengteInMeter.equals(krokodil.lengteInMeter)
                && gewichtInKilo.equals(krokodil.gewichtInKilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lengteInMeter, gewichtInKilo);
    }

    public static Comparator<Krokodil> sorteerOpGewicht() {
        Comparator<Krokodil> comparator = Comparator.comparing (
                Krokodil::getGewichtInKilo
        );
        return comparator;
    }

    //nog een versie:

//    public static Comparator<Krokodil> sorteerOpGewicht() {
//        return new Comparator<Krokodil>() {
//            @Override
//            public int compare(Krokodil o1, Krokodil o2) {
//                return o1.getGewichtInKilo().compareTo(o2.getGewichtInKilo());
//            }
//        };
//    }

    @Override
    public String toString() {
        return super.toString() + "\nNaam Krokodil: " + naam + "\nType: Krokodil\nLengte in meeter: " + lengteInMeter
                + "\nGewicht in kg: " + gewichtInKilo + "\n";
    }
}

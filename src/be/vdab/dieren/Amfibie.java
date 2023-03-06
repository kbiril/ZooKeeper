package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;

import java.util.List;

public abstract non-sealed class Amfibie extends GewerveldeDier {

    public Amfibie() {
        this ("Amfibie", Huidbedekking.GLAD, List.of(Milieu.LAND, Milieu.WATER));
    }
    public Amfibie(String naam, Huidbedekking huidbedekking, List<Milieu> milieus) {
        super(naam, huidbedekking, milieus);
    }
}

package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;

import java.util.List;

public abstract non-sealed class Zoogdier extends GewerveldeDier {

    public Zoogdier() {
        this ("Zoogdier", Huidbedekking.HAREN, List.of(Milieu.LAND, Milieu.WATER));
    }

    public Zoogdier(String naam, Huidbedekking huidbedekking, List<Milieu> milieus) {
        super(naam, huidbedekking, milieus);
    }
}

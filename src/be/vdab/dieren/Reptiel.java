package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;

import java.util.List;

public abstract non-sealed class Reptiel extends GewerveldeDier {

    public Reptiel() {
        this ("Reptiel", Huidbedekking.SCHUBBEN, List.of(Milieu.LAND, Milieu.WATER));
    }

    public Reptiel(String naam, Huidbedekking huidbedekking, List<Milieu> milieus) {
        super(naam, huidbedekking, milieus);
    }
}

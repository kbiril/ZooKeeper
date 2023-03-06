package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;

import java.util.List;

public abstract non-sealed class Vogel extends GewerveldeDier {

    private final boolean vliegen;

    public Vogel(boolean vliegen) {
        this ("Vogel", Huidbedekking.VEREN, List.of(Milieu.LAND, Milieu.LUCHT), vliegen);
    }

    public Vogel(String naam, Huidbedekking huidbedekking, List<Milieu> milieus, boolean vliegen) {
        super(naam, huidbedekking, milieus);
        this.vliegen = vliegen;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDe vogel vliegt: " + (vliegen? "JA" : "NEEN");
    }
}

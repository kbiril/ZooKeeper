package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;
import be.vdab.util.TypeWater;

import java.util.List;

public abstract non-sealed class Vis extends GewerveldeDier {
    private final TypeWater typeWater;

    public Vis(TypeWater typeWater) {
        this ("Vis", Huidbedekking.SCHUBBEN, List.of(Milieu.WATER), typeWater);
    }

    public Vis(String naam, Huidbedekking huidbedekking, List<Milieu> milieus, TypeWater typeWater) {

        super(naam, huidbedekking, milieus);
        this.typeWater = typeWater;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nType Water: " + typeWater;
    }
}

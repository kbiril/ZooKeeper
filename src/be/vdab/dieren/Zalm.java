package be.vdab.dieren;

import be.vdab.util.TypeWater;

import java.util.Objects;

public class Zalm extends Vis{
    private final String kleur;
    private final String naam;

    public Zalm(String naam, TypeWater typeWater, String kleur) {
        super(typeWater);
        this.kleur = kleur;
        this.naam = naam;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zalm zalm)) return false;

        return super.equals(o) && kleur.equals(zalm.kleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kleur);
    }

    @Override
    public String toString() {
        return super.toString() + "\nNaam Zalm: " + naam  + "\nType: Zalm\nkleur: " + kleur + "\n";
    }
}

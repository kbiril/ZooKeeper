package be.vdab.dieren;

import be.vdab.util.Huidbedekking;
import be.vdab.util.Milieu;

import java.util.List;
import java.util.Objects;

public abstract sealed class GewerveldeDier permits Reptiel, Amfibie, Vis, Vogel, Zoogdier {
    private final String naam;
    private final Huidbedekking huidbedekking;
    private final List<Milieu> milieus;

    public GewerveldeDier(String naam, Huidbedekking huidbedekking, List<Milieu> milieus) {
        this.naam = naam;
        this.huidbedekking = huidbedekking;
        this.milieus = milieus;
    }

    public List<Milieu> getMilieus() {
        return milieus;
    }

    public String getNaam() {
        return naam;
    }

    public Huidbedekking getHuidbedekking() {
        return huidbedekking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GewerveldeDier gd)) return false;

        return naam.equals(gd.naam) && huidbedekking == gd.huidbedekking && milieus.equals(gd.milieus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, huidbedekking, milieus);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Naam: " + naam  + "\n")
                .append("Huidbedekking: " + huidbedekking  + "\n").append("Milieus: ");

        for (var milieu : milieus) {
            stringBuilder.append(milieu).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        return  stringBuilder.toString();
    }

    public String verzorging(Huidbedekking huidbedekking) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (huidbedekking) {
            case SCHUBBEN -> stringBuilder.append("Geen speciale verzorging nodig");
            case GLAD -> stringBuilder.append("Regelmatig laten afkoelen");
            case HAREN -> stringBuilder.append("Regelmatig wassen");
            case VEREN -> stringBuilder.append("Regelmatig wassen, gladstrijken en invetten");
            default -> throw new IllegalArgumentException("huidbedekking is onbekend!");
        }
        return stringBuilder.toString();
    }

}

package be.vdab.dieren;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Beer extends Zoogdier{
    private List<String> leefgebieden;
    private String naamBeer;

    public Beer() {
        super();
    }


    public Beer(String naamBeer, List<String> leefgebieden) {
        super();
        this.naamBeer = naamBeer;
        addLeefgebieden(leefgebieden);

    }

    public String getNaam() {
        return naamBeer;
    }

    public final void addLeefgebieden (List<String> leefgebieden) {
        if (validatieLeefgebieden(leefgebieden)) {
            this.leefgebieden = leefgebieden;
        } else {
            throw new IllegalArgumentException("Lijst bevat twe hetzelfde leefgebieden, het is niet toegelaten!");
        }
    }

    public boolean validatieLeefgebieden (List<String> leefgebieden) {

        TreeSet<String> leefgebiedenSet = new TreeSet<>();
        if (leefgebieden != null && !leefgebieden.isEmpty()) {
            for (String leefgebied : leefgebieden) {
                if (leefgebied != null && !leefgebied.isBlank()) {
                    leefgebiedenSet.add(leefgebied);
                } else {
                    throw new IllegalArgumentException("Leefgebieden mag niet leeg zijn!");
                }
            }
        } else {
            throw new IllegalArgumentException("Lijst van leefgebieden mag niet leeg zijn!");
        }

        return leefgebiedenSet.size() == leefgebieden.size() ? true : false;
    }

    public List<String> getLeefgebieden () {
        return leefgebieden;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Beer beer)) return false;
        return super.equals(o) && leefgebieden.equals(beer.leefgebieden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), leefgebieden);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append("\nNaam Beer: " + naamBeer).append("\nType: Beer")
                .append("\nLeefgebieden: ");

        for (String leefgebied : leefgebieden) {
            stringBuilder.append(leefgebied).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        stringBuilder.append("\n");
        return stringBuilder.toString() ;
    }
}

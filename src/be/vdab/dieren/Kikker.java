package be.vdab.dieren;

public class Kikker extends Amfibie{
    private final String naam;
    public Kikker(String naam) {
        super();
        this.naam = naam;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNaam Kikker: " + naam + "\nType: Kikker\n";
    }
}

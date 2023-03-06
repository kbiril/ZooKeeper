package be.vdab.dieren;

public class Struisvogel extends Vogel{

    private final String naam;

    public Struisvogel(String naam, boolean vliegen) {
        super(vliegen);
        this.naam = naam;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNaam Struisvogel: " + naam + "\nType: Struisvogel\n";
    }
}

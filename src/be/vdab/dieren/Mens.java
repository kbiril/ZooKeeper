package be.vdab.dieren;

import be.vdab.util.RijksregisternummerNietGeldigException;
import be.vdab.util.RijksregisternummerValidator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Mens extends Zoogdier{
    private final String naam;
    private Long rijksregisternummer;
    private LocalDate geboortedatum;
    RijksregisternummerValidator validator = new RijksregisternummerValidator();
    public Mens(String naam, Long rijksregisternummer, LocalDate geboortedatum) {
        super();
        this.naam = naam;
        setRijksregisterGD(rijksregisternummer, geboortedatum);

    }

    @Override
    public String getNaam() {
        return naam;
    }

    public Long getRijksregisternummer () {
        return rijksregisternummer;
    }

    public void setRijksregisterGD(Long rijksregisternummer, LocalDate geboortedatum) {
        if(validator.isValid(rijksregisternummer, geboortedatum)) {
            this.rijksregisternummer = rijksregisternummer;
            this.geboortedatum = geboortedatum;
        } else {
            throw new RijksregisternummerNietGeldigException("Rijkregister nummer is niet correct!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mens mens)) return false;

        return rijksregisternummer.equals(mens.rijksregisternummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rijksregisternummer);
    }

    @Override
    public String toString() {
        return super.toString() + "\nNaam van de Mens: " + naam  + "\nType: Mens\nLeeftijd (jaren): "
                + ChronoUnit.YEARS.between(geboortedatum, LocalDate.now()) + "\n";
    }
}

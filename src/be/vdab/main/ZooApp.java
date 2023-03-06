package be.vdab.main;

import be.vdab.dieren.*;
import be.vdab.util.RijksregisternummerNietGeldigException;
import be.vdab.util.TypeWater;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ZooApp {
    public static void main(String[] args) {

        // Beren:
        Beer bruineBeer = new Beer("Bruine Beer", List.of("Rusland", "Noord America", "Europe"));
//        System.out.println(bruineBeer.toString());
        Beer koala = new Beer("Koala", List.of("Australië"));
//        System.out.println(koala.toString());
        Beer panda = new Beer("Panda", List.of("Oost Azië", "China"));
//        System.out.println(panda.toString());

        try {
            Beer fout1 = new Beer("Fout1", List.of());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Beer fout2 = new Beer("Fout2", List.of("Australië", "Australië"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Beer fout3 = new Beer("Fout3",null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Beer fout4 = new Beer();
            fout4.addLeefgebieden(List.of());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        //Overige dieren

        Kikker roodoogmakikikker = new Kikker("Roodoogmakikikker");
        Struisvogel struisvogel = new Struisvogel("Struthio Camelus", false);
        Zalm regenboogforel = new Zalm("Regenboogforel", TypeWater.ZOET, "Roos");

        // Mensen:

        Mens mens1 = new Mens("Katia", 76120839476L, LocalDate.of(1976, 12, 8));
//        System.out.println(mens1);
        Mens mens2 = new Mens("Annick", 90020199704L, LocalDate.of(1990, 2, 1));
//        System.out.println(mens1);
        Mens mens3 = new Mens("Petr",88101322344L, LocalDate.of(1988, 10, 13));
//        System.out.println(mens2);
        try {
            Mens mensfout1 = new Mens("Fout1", 76120839474L, LocalDate.of(1976, 12, 8));
        } catch (RijksregisternummerNietGeldigException re) {
            System.out.println(re.getMessage());
        }

        try {
            Mens mensfout2 = new Mens("Fout2", 74120839474L, LocalDate.of(1976, 12, 8));
        } catch (RijksregisternummerNietGeldigException re) {
            System.out.println(re.getMessage());
        }

        // Krokodillen
        Krokodil krokodil1 = new Krokodil("Zoetwaterkrokodil", BigDecimal.valueOf(6.2), BigDecimal.valueOf(1000));
        Krokodil krokodil2 = new Krokodil("Bultkrokodil", BigDecimal.valueOf(3.5), BigDecimal.valueOf(400));
        Krokodil krokodil3 = new Krokodil("Nijlkrokodil", BigDecimal.valueOf(6.5), BigDecimal.valueOf(700));
        Krokodil krokodil4 = new Krokodil("Moeraskrokodil", BigDecimal.valueOf(5), BigDecimal.valueOf(450));

        try {
            Krokodil krokodilfout1 = new Krokodil("Fout1", BigDecimal.valueOf(-2), BigDecimal.valueOf(500));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Krokodil krokodilfout2 = new Krokodil("Fout2", BigDecimal.valueOf(3), BigDecimal.valueOf(-500));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        List<GewerveldeDier> gewerveldeDierens = new ArrayList<>();

        Zoo zoo = new Zoo(gewerveldeDierens);
        zoo.voegDierToe(bruineBeer);
        zoo.voegDierToe(koala);
        zoo.voegDierToe(panda);
        zoo.voegDierToe(mens1);
        zoo.voegDierToe(mens2);
        zoo.voegDierToe(mens3);
        zoo.voegDierToe(krokodil1);
        zoo.voegDierToe(krokodil2);
        zoo.voegDierToe(krokodil3);
        zoo.voegDierToe(krokodil4);
        zoo.voegDierToe(roodoogmakikikker);
        zoo.voegDierToe(struisvogel);
        zoo.voegDierToe(regenboogforel);

        System.out.println("**** Lijst van alle dieren ****");
        zoo.printLijst();

        System.out.println("**** Lijst van alle Land dieren ****");

        for (var dier : zoo.lijstVanAlleLandDieren()) {
            System.out.println(dier.toString());
        }

        System.out.println("**** Lijst van alle krokodillen ****");

        for (var dier : zoo.lijstVanAlleKrokodillenGesorteerdOpGewicht()) {
            System.out.println(dier.toString());
        }

        System.out.println("Percentage Mensen: " + zoo.percentageMensen() + "%");
        System.out.println();

        System.out.println("**** Alle namen gesorteerd ****");

        for (String naam : zoo.lijstVanAlleDierenNamenGesorteerdOpAlfabet()) {
            System.out.println(naam);
        }

    }
}

package be.vdab.dieren;

import be.vdab.util.Milieu;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record Zoo(List<GewerveldeDier> gewerveldeDierens) {

    public void voegDierToe(GewerveldeDier dier) {
        if (dier != null && !gewerveldeDierens.contains(dier)) {
            gewerveldeDierens.add(dier);
        }
    }

    public void printLijst() {
        gewerveldeDierens.forEach(dier -> System.out.println(dier.toString()));
    }

    public List<GewerveldeDier> lijstVanAlleLandDieren() {
        return gewerveldeDierens.stream().filter(dier -> dier.getMilieus().contains(Milieu.LAND))
                .collect(Collectors.toList());
    }

    public List<String> lijstVanAlleDierenNamenGesorteerdOpAlfabet() { // enkel namen
        return gewerveldeDierens.stream().map(dier ->dier.getNaam()).sorted((d1, d2) -> d1.compareToIgnoreCase(d2))
                .collect(Collectors.toList());
    }

    public double percentageMensen() {
        return Math.round((double) (gewerveldeDierens.stream().filter(dier -> dier instanceof Mens)
                .map(mens -> mens.getNaam())
                .count())
                / (double) (gewerveldeDierens.size()) * 100.0D);
    }

    public List<Krokodil> lijstVanAlleKrokodillenGesorteerdOpGewicht() {

        return gewerveldeDierens.stream().filter(dier -> dier instanceof Krokodil)
                .map(dier -> (Krokodil) dier).sorted(Krokodil.sorteerOpGewicht()).collect(Collectors.toList());


    }

}

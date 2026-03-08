package zadanie.model;

import zadanie.enumy.Status;
import zadanie.uslugi.Wnioski;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UrzadMiasta implements Wnioski {
    private List<Sprawa> sprawy;
    private List<Obywatel> obywatele;

    public UrzadMiasta() {
        this.sprawy = new ArrayList<>();
        this.obywatele = new ArrayList<>();
    }

    public void dodajSprawe(Sprawa sprawa) {
        sprawy.add(sprawa);
    }

    public void dodajObywatela(Obywatel obywatel) {
        obywatele.add(obywatel);
    }

    public void usunSprawe(int id) {
        try {
            sprawy.remove(id);
            System.out.println("Wniosek został pomyślnie usunięty!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma takiej sprawy!");
        }
    }

    public void usunObywatela(int id) {
        try {
            obywatele.remove(id);
            System.out.println("Obywatel został pomyślnie usunięty!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma takiej sprawy!");
        }
    }
    public Sprawa znajdzSprawe(int id) {
        if (id < 0 || id >= sprawy.size()) return null;
        return sprawy.get(id);
    }
    public Obywatel znajdzObywatela(int id) {
        if (id < 0 || id >= obywatele.size()) return null;
        return obywatele.get(id);
    }

    public List<Sprawa> znajdzSprawe(Status statusSprawy) {
        List<Sprawa> szukaneSprawy = new ArrayList<>();
        for (Sprawa sprawa : sprawy) if (sprawa.getStatus() == statusSprawy) szukaneSprawy.add(sprawa);
        return szukaneSprawy;
    }

    public List<Sprawa> znajdzSprawe(String opis) {
        List<Sprawa> szukaneSprawy = new ArrayList<>();
        for (Sprawa sprawa : sprawy) if (sprawa.getOpis().equalsIgnoreCase(opis)) szukaneSprawy.add(sprawa);
        return szukaneSprawy;
    }

    public List<Sprawa> znajdzSprawe(LocalDate date) {
        List<Sprawa> szukaneSprawy = new ArrayList<>();
        for (Sprawa sprawa : sprawy) if (sprawa.getDataZlozenia().isEqual(date)) szukaneSprawy.add(sprawa);
        return szukaneSprawy;
    }

    public List<Obywatel> znajdzObywatela(String string, int szukanyArgument) {
        List<Obywatel> szukaniObywatele = new ArrayList<>();
        switch (szukanyArgument) {
            case 1 -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getImie().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case 2 -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getNazwisko().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case 3 -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getAdres().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case 4 -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getTelefon() != null && obywatel.getTelefon().equalsIgnoreCase(string))
                        szukaniObywatele.add(obywatel);
            } default -> {
                return null;
            }
        } return szukaniObywatele;
    }

    public void przypiszDzial(Sprawa sprawa, String dzial) {
        sprawa.setDzial(dzial);
    }

    public void sprawdzPostep(Sprawa sprawa) {
        System.out.println("Status sprawy "+sprawa.getOpis()+" jest: "+sprawa.getStatus());
    }

    public List<Sprawa> getSprawy() {
        return sprawy;
    }

    public List<Obywatel> getObywatele() {
        return obywatele;
    }

    public void pokazSprawy(List<Sprawa> znalezioneSprawy){
        if (znalezioneSprawy == null || znalezioneSprawy.isEmpty()){
            System.out.println("Nie znaleziono spraw.");
        } else {
            System.out.println("Znalezione sprawy:");
            for (Sprawa sprawa : znalezioneSprawy) System.out.println(sprawa);
        }
    }

    public void pokazObywatelow(List<Obywatel> znalezieniObywatele){
        if (znalezieniObywatele == null || znalezieniObywatele.isEmpty()){
            System.out.println("Nie znaleziono obywatelów.");
        } else {
            System.out.println("Znalezieni obywatele:");
            for (Obywatel obywatel : znalezieniObywatele) System.out.println(obywatel);
        }
    }

    @Override
    public String toString() {
        return "UrzadMiasta{" +
                "sprawy=" + sprawy +
                ", obywatele=" + obywatele +
                '}';
    }
}
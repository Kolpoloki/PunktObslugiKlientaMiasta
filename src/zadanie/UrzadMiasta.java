package zadanie;

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
        System.out.println("Wniosek został pomyślnie dodany!");
    }

    public void dodajObywatela(Obywatel obywatel) {
        obywatele.add(obywatel);
        System.out.println("Obywatel został pomyślnie dodany!");
    }

    public void usunSprawe(int id) {
        if (id < 0 || id >= sprawy.size()) System.out.println("Nie ma takiej sprawy!");
        else {
            sprawy.remove(id);
            System.out.println("Wniosek został pomyślnie usunięty!");
        }
    }

    public void usunObywatela(int id) {
        if (id < 0 || id >= sprawy.size()) System.out.println("Nie ma takiego obywatela!");
        else {
            obywatele.get(id);
            System.out.println("Obywatel został pomyślnie usunięty!");
        }
    }
    public Sprawa znajdzSprawe(int id) {
        if (id < 0 || id >= sprawy.size()) return null;
        return sprawy.get(id);
    }
    public Obywatel ZnajdzObywatela(int id) {
        if (id < 0 || id >= obywatele.size()) return null;
        return obywatele.get(id);
    }

    public List<Sprawa> znajdzSprawe(Status statusSprawy) {
        List<Sprawa> szukaneSprawy = new ArrayList<>();
        for (Sprawa sprawa : sprawy) if (sprawa.getStatus() == statusSprawy) szukaneSprawy.add(sprawa);
        return szukaneSprawy;
    }

    public List<Sprawa> znajdzSprawe(Platnosc platnosc) {
        List<Sprawa> szukaneSprawy = new ArrayList<>();
        for (Sprawa sprawa : sprawy) if (sprawa.getPlatnosc() == platnosc) szukaneSprawy.add(sprawa);
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

    public List<Obywatel> znajdzObywatela(String string, String szukanyArgument) {
        List<Obywatel> szukaniObywatele = new ArrayList<>();
        switch (szukanyArgument.toLowerCase()) {
            case "imie","imię" -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getImie().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case "nazwisko" -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getNazwisko().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case "adres" -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getAdres().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            case "telefon" -> {
                for (Obywatel obywatel : obywatele)
                    if (obywatel.getTelefon().equalsIgnoreCase(string)) szukaniObywatele.add(obywatel);
            }
            default -> {
                return null;
            }
        } return szukaniObywatele;
    }

    public void przypiszDzial(Sprawa sprawa, String dzial) {
        sprawa.setDzial(dzial);
        System.out.println("Status sprawy "+sprawa.getOpis()+" została przypiana do działu: "+dzial);
    }

    public void sprawdzPostep(Sprawa sprawa) {
        System.out.println("Status sprawy "+sprawa.getOpis()+" jest: "+sprawa.getStatus());
    }

    @Override
    public String toString() {
        return "UrzadMiasta{" +
                "sprawy=" + sprawy +
                ", obywatele=" + obywatele +
                '}';
    }
}
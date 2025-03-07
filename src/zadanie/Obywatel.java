package zadanie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Obywatel implements Dokumentacja{
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private List<Dokument> dokumenty = new ArrayList<>();

    public Obywatel(String imie, String nazwisko, String adres, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;
    }
    public Obywatel(String imie, String nazwisko, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }
    public Obywatel(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void dodajDokument(Dokument dokument) {
        dokumenty.add(dokument);
        System.out.println("Dokument został dodany pomyslnie!");
    }

    public void sprawdzWaznoscDokumentu(Dokument dokument) {
        if (dokument.getDataWaznosci().isAfter(LocalDate.now())) System.out.println("Dokument jest ważny.");
        else System.out.println("Dokument stracił ważnośc.");
    }

    public Dokument ZnajdzDokument(RodzajDokumentu rodzajDokumentu) {
        for (Dokument dokument : dokumenty) if (dokument.getRodzajDokumentu() == rodzajDokumentu) return dokument;
        return null;
    }

    @Override
    public String toString() {
        return "Obywatel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                ", dokumenty=" + dokumenty +
                '}';
    }
}

package zadanie;

import java.time.LocalDate;

public class Dokument {
    private String numer;
    private LocalDate dataWydania;
    private LocalDate dataWaznosci;
    private String opis;
    private RodzajDokumentu rodzajDokumentu;

    public Dokument(String numer, LocalDate dataWydania, LocalDate dataWaznosci, String opis,RodzajDokumentu rodzajDokumentu) {
        this.numer = numer;
        this.dataWydania = dataWydania;
        this.dataWaznosci = dataWaznosci;
        this.opis = opis;
        this.rodzajDokumentu = rodzajDokumentu;
    }

    public String getNumer() {
        return numer;
    }

    public LocalDate getDataWydania() {
        return dataWydania;
    }

    public LocalDate getDataWaznosci() {
        return dataWaznosci;
    }

    public String getOpis() {
        return opis;
    }

    public RodzajDokumentu getRodzajDokumentu() {
        return rodzajDokumentu;
    }

    @Override
    public String toString() {
        return "Dokument{" +
                "numer='" + numer + '\'' +
                ", dataWydania=" + dataWydania +
                ", dataWaznosci=" + dataWaznosci +
                ", opis='" + opis + '\'' +
                ", rodzajDokumentu=" + rodzajDokumentu +
                '}';
    }
}

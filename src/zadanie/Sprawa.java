package zadanie;

import java.time.LocalDate;

public class Sprawa {
    private Obywatel obywatel;
    private String opis;
    private LocalDate dataZlozenia;
    private Status status;
    private Platnosc platnosc;
    private String dzial;

    public Sprawa(Obywatel obywatel, String opis, LocalDate dataZlozenia, Status status, Platnosc platnosc) {
        this.obywatel = obywatel;
        this.opis = opis;
        this.dataZlozenia = dataZlozenia;
        this.status = status;
        this.platnosc = platnosc;
        this.dzial="nie przypisany";
    }

    public String getOpis() {
        return opis;
    }

    public LocalDate getDataZlozenia() {
        return dataZlozenia;
    }

    public Status getStatus() {
        return status;
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setDzial(String dzial) {this.dzial = dzial;}

    @Override
    public String toString() {
        return "Sprawa{" +
                "obywatel=" + obywatel +
                ", opis='" + opis + '\'' +
                ", dataZlozenia=" + dataZlozenia +
                ", status=" + status +
                ", platnosc=" + platnosc +
                ", dzial='" + dzial + '\'' +
                '}';
    }
}

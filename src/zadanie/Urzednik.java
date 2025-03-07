package zadanie;

public class Urzednik extends Obywatel{
    private String stanowisko;

    public Urzednik(String imie, String nazwisko, String adres, String telefon, String stanowisko) {
        super(imie, nazwisko, adres, telefon);
        this.stanowisko = stanowisko;
    }
    public Urzednik(String imie, String nazwisko, String telefon, String stanowisko) {
        super(imie, nazwisko, telefon);
        this.stanowisko = stanowisko;
    }
    public Urzednik(String imie, String nazwisko, String stanowisko) {
        super(imie, nazwisko);
        this.stanowisko = stanowisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    @Override
    public String toString() {
        return super.toString()+"stanosisko="+stanowisko;
    }
}

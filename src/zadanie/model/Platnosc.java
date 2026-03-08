package zadanie.model;

import zadanie.uslugi.OperacjePlatnosci;
import zadanie.enumy.RodzajPlatnosci;
import zadanie.enumy.Status;

public class Platnosc implements OperacjePlatnosci {
    private double ilosc;
    private RodzajPlatnosci rodzajPlatnosci;
    private Status status;

    public Platnosc(double ilosc, RodzajPlatnosci rodzajPlatnosci,Status status) {
        this.ilosc = ilosc;
        this.rodzajPlatnosci = rodzajPlatnosci;
        this.status = status;
    }

    public double getIlosc() {
        return ilosc;
    }

    public RodzajPlatnosci getRodzajPlatnosci() {
        return rodzajPlatnosci;
    }
    public Status getStatusPlatnosci() {return status;}
    public void wykonajPlatnosc(){
        System.out.println("Płatność została dokonana.");
    }

    @Override
    public String toString() {
        return "Platnosc{" +
                "ilosc=" + ilosc +
                ", rodzajPlatnosci=" + rodzajPlatnosci +
                ", status=" + status +
                '}';
    }
}

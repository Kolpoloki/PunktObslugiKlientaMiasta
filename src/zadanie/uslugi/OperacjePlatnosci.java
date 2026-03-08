package zadanie.uslugi;

import zadanie.enumy.RodzajPlatnosci;
import zadanie.enumy.Status;

public interface OperacjePlatnosci {
    double getIlosc();

    RodzajPlatnosci getRodzajPlatnosci();
    Status getStatusPlatnosci();
    void wykonajPlatnosc();

}

package zadanie.enumy;

public enum RodzajPlatnosci {
    KARTA("Karta"),
    GOTOWKA("Gotówka"),
    BLIK("Blik");

    private final String opis;

    RodzajPlatnosci(String opis) {this.opis=opis;}

    public String getOpis() {return opis;}

    public static boolean czyPoprawny(String str){
        for(RodzajPlatnosci rodzajPlatnosci : RodzajPlatnosci.values())
            if (rodzajPlatnosci.name().equalsIgnoreCase(str)) return true;
        return false;
    }
}

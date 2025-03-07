package zadanie;

public enum RodzajPlatnosci {
    KARTA("Karta"),
    GOTOWKA("Gotówka"),
    BLIK("Blik");

    private final String opis;

    RodzajPlatnosci(String opis) {this.opis=opis;}

    public String getOpis() {return opis;}

    public static boolean czyPoprawny(String opis){
        for(RodzajPlatnosci rodzajPlatnosci : RodzajPlatnosci.values())
            if (rodzajPlatnosci.getOpis().equalsIgnoreCase(opis)) return true;
        return false;
    }
}

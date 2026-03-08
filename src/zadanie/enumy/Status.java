package zadanie.enumy;

public enum Status {
    ZLOZONA("Zlozona"),
    W_TRAKCIE("W_Trakcie"),
    ZREALIZOWANA("Zrealizowana");

    private final String opis;

    Status(String opis) {this.opis=opis;}

    public String getOpis() {return opis;}

    public static boolean czyPoprawny(String str){
        for(Status status : Status.values())
            if (status.name().equalsIgnoreCase(str)) return true;
        return false;
    }
}

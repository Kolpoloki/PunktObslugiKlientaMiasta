package zadanie;

public enum Status {
    ZLOZONA("Żłożona"),
    W_TRAKCIE("W Trakcie"),
    ZREALIZOANA("Zrealizowana");

    private final String opis;

    Status(String opis) {this.opis=opis;}

    public String getOpis() {return opis;}

    public static boolean czyPoprawny(String opis){
        for(Status status : Status.values())
            if (status.getOpis().equalsIgnoreCase(opis)) return true;
        return false;
    }
}

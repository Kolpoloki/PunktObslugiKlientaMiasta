package zadanie;

public enum RodzajDokumentu {
    PASZPORT("Paszport"),
    DOWOD_OSOBISTY("Dowód Osobisty"),
    PRAWO_JAZDY("Prawo Jazdy"),
    DOWOD_REJESTRACYJNY("Dowód Osobisty"),
    LEGITYMACJA_SZKOLNA("Legitymacja Szkolna"),
    LEGITYMACJA_STUDENCKA("Legitymacja Studencka");

    private final String opis;

    RodzajDokumentu(String opis) {this.opis=opis;}

    public String getOpis() {return opis;}

    public static boolean czyPoprawny(String opis){
        for(RodzajDokumentu dokument : RodzajDokumentu.values())
            if (dokument.getOpis().equalsIgnoreCase(opis)) return true;
        return false;
    }

}

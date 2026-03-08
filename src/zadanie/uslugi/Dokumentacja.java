package zadanie.uslugi;

import zadanie.model.Dokument;

public interface Dokumentacja {
    void dodajDokument(Dokument dokument);
    void sprawdzWaznoscDokumentu(Dokument dokument);
}

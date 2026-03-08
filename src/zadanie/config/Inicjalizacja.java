package zadanie.config;

import zadanie.model.*;
import zadanie.enumy.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Inicjalizacja {
    public static Scanner scanner = new Scanner(System.in);
    public static UrzadMiasta urzad = new UrzadMiasta();

    public static void inicjalizujDane() {

        // Tworzenie obywateli
        Obywatel ob1 = new Obywatel("Jan", "Kowalski", "ul. Warszawska 1", "123456789");
        Obywatel ob2 = new Obywatel("Anna", "Nowak", "ul. Krakowska 2", "987654321");
        Obywatel ob3 = new Obywatel("Piotr", "Zieliński", "ul. Gdańska 3", "567890123");
        Obywatel ob4 = new Obywatel("Ewa", "Dąbrowska", "ul. Poznańska 4", "456789012");
        Obywatel ob5 = new Obywatel("Karol", "Wiśniewski", "ul. Katowicka 5", "345678901");

        urzad.dodajObywatela(ob1);
        urzad.dodajObywatela(ob2);
        urzad.dodajObywatela(ob3);
        urzad.dodajObywatela(ob4);
        urzad.dodajObywatela(ob5);

        // Tworzenie urzędników
        Urzednik urz1 = new Urzednik("Marek", "Lewandowski", "Biuro Paszportów");
        Urzednik urz2 = new Urzednik("Magdalena", "Wójcik","Dział Rejestracji");
        Urzednik urz3 = new Urzednik("Tomasz", "Kaczmarek", "567890120", "Dział Podatkowy");

        urzad.dodajObywatela(urz1);
        urzad.dodajObywatela(urz2);
        urzad.dodajObywatela(urz3);

        // Tworzenie płatności
        Platnosc pl1 = new Platnosc(200, RodzajPlatnosci.KARTA, Status.ZLOZONA);
        Platnosc pl2 = new Platnosc(150, RodzajPlatnosci.GOTOWKA, Status.ZLOZONA);
        Platnosc pl3 = new Platnosc(300, RodzajPlatnosci.BLIK, Status.W_TRAKCIE);
        Platnosc pl4 = new Platnosc(100, RodzajPlatnosci.KARTA, Status.ZLOZONA);
        Platnosc pl5 = new Platnosc(250, RodzajPlatnosci.GOTOWKA, Status.W_TRAKCIE);

        // Tworzenie spraw
        Sprawa sp1 = new Sprawa(ob1, "Wydanie paszportu", LocalDate.now(), Status.ZLOZONA, pl1);
        Sprawa sp2 = new Sprawa(ob2, "Rejestracja pojazdu", LocalDate.now().minusDays(3), Status.W_TRAKCIE, pl2);
        Sprawa sp3 = new Sprawa(ob3, "Zmiana nazwiska", LocalDate.now().minusWeeks(1), Status.ZREALIZOWANA, pl3);
        Sprawa sp4 = new Sprawa(ob4, "Zgłoszenie meldunkowe", LocalDate.now().minusDays(5), Status.ZLOZONA, pl4);
        Sprawa sp5 = new Sprawa(ob5, "Wymiana dowodu osobistego", LocalDate.now().minusWeeks(2), Status.W_TRAKCIE, pl5);

        urzad.dodajSprawe(sp1);
        urzad.dodajSprawe(sp2);
        urzad.dodajSprawe(sp3);
        urzad.dodajSprawe(sp4);
        urzad.dodajSprawe(sp5);

        // Dokumenty obywateli
        Dokument doc1 = new Dokument("ABC123", LocalDate.of(2020,5,10), LocalDate.of(2030,5,10), "Dowód osobisty", RodzajDokumentu.DOWOD_OSOBISTY);
        Dokument doc2 = new Dokument("XYZ789", LocalDate.of(2018,3,15), LocalDate.of(2028,3,15), "Prawo jazdy", RodzajDokumentu.PRAWO_JAZDY);
        Dokument doc3 = new Dokument("LMN456", LocalDate.of(2019,7,20), LocalDate.of(2029,7,20), "Paszport", RodzajDokumentu.PASZPORT);
        Dokument doc4 = new Dokument("QWE987", LocalDate.of(2021,9,30), LocalDate.of(2031,9,30), "Dowód rejestracyjny", RodzajDokumentu.DOWOD_REJESTRACYJNY);
        Dokument doc5 = new Dokument("RTY654", LocalDate.of(2022,6,5), LocalDate.of(2032,6,5), "Legitymacja studencka", RodzajDokumentu.LEGITYMACJA_STUDENCKA);

        ob1.dodajDokument(doc1);
        ob2.dodajDokument(doc2);
        ob3.dodajDokument(doc3);
        ob4.dodajDokument(doc4);
        ob5.dodajDokument(doc5);

        // Dokumenty urzędników
        Dokument doc6 = new Dokument("A12345", LocalDate.of(2020,5,10), LocalDate.of(2030,5,10), "Dowód osobisty", RodzajDokumentu.DOWOD_OSOBISTY);
        Dokument doc7 = new Dokument("B23456", LocalDate.of(2018,3,15), LocalDate.of(2028,3,15), "Prawo jazdy", RodzajDokumentu.PRAWO_JAZDY);
        Dokument doc8 = new Dokument("C34567", LocalDate.of(2019,7,20), LocalDate.of(2029,7,20), "Paszport", RodzajDokumentu.PASZPORT);

        urz1.dodajDokument(doc6);
        urz2.dodajDokument(doc7);
        urz3.dodajDokument(doc8);

        urzad.przypiszDzial(sp1, "Biuro Paszportów");
        urzad.przypiszDzial(sp2, "Dział Rejestracji");
        urzad.przypiszDzial(sp3, "Dział Podatkowy");
        urzad.przypiszDzial(sp4, "Departament Tajemnic");
        urzad.przypiszDzial(sp5, "Biuro Paszportów");

    }
}
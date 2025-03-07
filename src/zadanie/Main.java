package zadanie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static UrzadMiasta urzad = new UrzadMiasta();

    public static void main(String[] args) {

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

        Urzednik urz1 = new Urzednik("Marek", "Lewandowski", "Biuro Paszportów");
        Urzednik urz2 = new Urzednik("Magdalena", "Wójcik", "Dział Rejestracji");
        Urzednik urz3 = new Urzednik("Tomasz", "Kaczmarek", "Dział Podatkowy");
        urzad.dodajObywatela(urz1);
        urzad.dodajObywatela(urz2);
        urzad.dodajObywatela(urz3);

        Platnosc pl1 = new Platnosc(200, RodzajPlatnosci.KARTA, Status.ZLOZONA);
        Platnosc pl2 = new Platnosc(150, RodzajPlatnosci.GOTOWKA, Status.ZLOZONA);
        Platnosc pl3 = new Platnosc(300, RodzajPlatnosci.BLIK, Status.W_TRAKCIE);
        Platnosc pl4 = new Platnosc(100, RodzajPlatnosci.KARTA, Status.ZLOZONA);
        Platnosc pl5 = new Platnosc(250, RodzajPlatnosci.GOTOWKA, Status.W_TRAKCIE);

        Sprawa sp1 = new Sprawa(ob1, "Wydanie paszportu", LocalDate.now(), Status.ZLOZONA, pl1);
        Sprawa sp2 = new Sprawa(ob2, "Rejestracja pojazdu", LocalDate.now().minusDays(3), Status.W_TRAKCIE, pl2);
        Sprawa sp3 = new Sprawa(ob3, "Zmiana nazwiska", LocalDate.now().minusWeeks(1), Status.ZREALIZOANA, pl3);
        Sprawa sp4 = new Sprawa(ob4, "Zgłoszenie meldunkowe", LocalDate.now().minusDays(5), Status.ZLOZONA, pl4);
        Sprawa sp5 = new Sprawa(ob5, "Wymiana dowodu osobistego", LocalDate.now().minusWeeks(2), Status.W_TRAKCIE, pl5);

        urzad.dodajSprawe(sp1);
        urzad.dodajSprawe(sp2);
        urzad.dodajSprawe(sp3);
        urzad.dodajSprawe(sp4);
        urzad.dodajSprawe(sp5);

        Dokument doc1 = new Dokument("ABC123", LocalDate.of(2020, 5, 10), LocalDate.of(2030, 5, 10), "Dowód osobisty", RodzajDokumentu.DOWOD_OSOBISTY);
        Dokument doc2 = new Dokument("XYZ789", LocalDate.of(2018, 3, 15), LocalDate.of(2028, 3, 15), "Prawo jazdy", RodzajDokumentu.PRAWO_JAZDY);
        Dokument doc3 = new Dokument("LMN456", LocalDate.of(2019, 7, 20), LocalDate.of(2029, 7, 20), "Paszport", RodzajDokumentu.PASZPORT);
        Dokument doc4 = new Dokument("QWE987", LocalDate.of(2021, 9, 30), LocalDate.of(2031, 9, 30), "Dowód rejestracyjny", RodzajDokumentu.DOWOD_REJESTRACYJNY);
        Dokument doc5 = new Dokument("RTY654", LocalDate.of(2022, 6, 5), LocalDate.of(2032, 6, 5), "Legitymacja studencka", RodzajDokumentu.LEGITYMACJA_STUDENCKA);
        ob1.dodajDokument(doc1);
        ob2.dodajDokument(doc2);
        ob3.dodajDokument(doc3);
        ob4.dodajDokument(doc4);
        ob5.dodajDokument(doc5);

        Dokument doc6 = new Dokument("A12345", LocalDate.of(2020, 5, 10), LocalDate.of(2030, 5, 10), "Dowód osobisty", RodzajDokumentu.DOWOD_OSOBISTY);
        Dokument doc7 = new Dokument("B23456", LocalDate.of(2018, 3, 15), LocalDate.of(2028, 3, 15), "Prawo jazdy", RodzajDokumentu.PRAWO_JAZDY);
        Dokument doc8 = new Dokument("C34567", LocalDate.of(2019, 7, 20), LocalDate.of(2029, 7, 20), "Paszport", RodzajDokumentu.PASZPORT);
        urz1.dodajDokument(doc6);
        urz2.dodajDokument(doc7);
        urz3.dodajDokument(doc8);

        urzad.przypiszDzial(sp1, "Biuro Paszportów");
        urzad.przypiszDzial(sp2, "Dział Rejestracji");
        urzad.przypiszDzial(sp3, "Dział Podatkowy");
        urzad.przypiszDzial(sp4, "Departament Tajemnic");
        urzad.przypiszDzial(sp5, "Biuro Paszportów");

        urzad.sprawdzPostep(sp1);
        urzad.sprawdzPostep(sp2);
        urzad.sprawdzPostep(sp3);
        urzad.sprawdzPostep(sp4);
        urzad.sprawdzPostep(sp5);

        List<Obywatel> znalezieni = urzad.znajdzObywatela("Kaczmarek", "nazwisko");
        if (!znalezieni.isEmpty()) {
            System.out.println("Znalezieni obywatele:");
            for (Obywatel obywatel : znalezieni) System.out.println(obywatel);
        } else System.out.println("Nie znaleziono obywatelów");

        List<Sprawa> sprawyZToku = urzad.znajdzSprawe(Status.W_TRAKCIE);
        System.out.println("Sprawy w trakcie:");
        for (Sprawa sprawa : sprawyZToku) {
            System.out.println(sprawa);
        }
        if (sprawyZToku.isEmpty()) System.out.println("Nie znaleziono spraw");

        ob1.sprawdzWaznoscDokumentu(ob1.ZnajdzDokument(RodzajDokumentu.DOWOD_OSOBISTY));
        ob2.sprawdzWaznoscDokumentu(ob2.ZnajdzDokument(RodzajDokumentu.PRAWO_JAZDY));
        ob3.sprawdzWaznoscDokumentu(ob3.ZnajdzDokument(RodzajDokumentu.PASZPORT));
        ob4.sprawdzWaznoscDokumentu(ob4.ZnajdzDokument(RodzajDokumentu.DOWOD_REJESTRACYJNY));
        ob5.sprawdzWaznoscDokumentu(ob5.ZnajdzDokument(RodzajDokumentu.LEGITYMACJA_STUDENCKA));
        urz1.sprawdzWaznoscDokumentu(urz1.ZnajdzDokument(RodzajDokumentu.DOWOD_OSOBISTY));
        urz2.sprawdzWaznoscDokumentu(urz2.ZnajdzDokument(RodzajDokumentu.PRAWO_JAZDY));
        urz3.sprawdzWaznoscDokumentu(urz3.ZnajdzDokument(RodzajDokumentu.PASZPORT));

        urzad.usunSprawe(0);
        urzad.usunObywatela(1);


        // Skaner
        System.out.println("Podaj szczegóły obywatela:");
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Adres: ");
        String adres = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        Obywatel obywatel = new Obywatel(imie, nazwisko, adres, telefon);

        System.out.println("Podaj szczegóły dokumentu:");
        System.out.print("Numer: ");
        String numer = scanner.nextLine();
        System.out.print("Data wydania (yyyy-mm-dd): ");
        String dataWydaniaStr = scanner.nextLine();
        LocalDate dataWydania = LocalDate.parse(dataWydaniaStr);
        System.out.print("Data ważności (yyyy-mm-dd): ");
        String dataWaznosciStr = scanner.nextLine();
        LocalDate dataWaznosci = LocalDate.parse(dataWaznosciStr);
        System.out.print("Opis: ");
        String opis = scanner.nextLine();

        RodzajDokumentu rodzajDokumentu = null;
        while (rodzajDokumentu == null) {
            System.out.print("Rodzaj dokumentu (PASZPORT, DOWOD_OSOBISTY, PRAWO_JAZDY, DOWOD_REJESTRACYJNY, LEGITYMACJA_SZKOLNA, LEGITYMACJA_STUDENCKA): ");
            String rodzajStr = scanner.nextLine().toUpperCase();
            if (RodzajDokumentu.czyPoprawny(rodzajStr)) {
                rodzajDokumentu = RodzajDokumentu.valueOf(rodzajStr);
            } else {
                System.out.println("Niepoprawny rodzaj dokumentu. Spróbuj ponownie.");
            }
        }

        Dokument dokument = new Dokument(numer, dataWydania, dataWaznosci, opis, rodzajDokumentu);
        obywatel.dodajDokument(dokument);

        System.out.println("Podaj szczegóły urzędnika:");
        System.out.print("Imie: ");
        String urzImie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String urzNazwisko = scanner.nextLine();
        System.out.print("Telefon: ");
        String urzTelefon = scanner.nextLine();
        System.out.print("Stanowisko: ");
        String stanowisko = scanner.nextLine();

        Urzednik urzednik = new Urzednik(urzImie, urzNazwisko, urzTelefon, stanowisko);
        System.out.println("Podaj szczegóły dokumentu:");
        System.out.print("Numer: ");
        String numer1 = scanner.nextLine();
        System.out.print("Data wydania (yyyy-mm-dd): ");
        String dataWydaniaStr1 = scanner.nextLine();
        LocalDate dataWydania1 = LocalDate.parse(dataWydaniaStr1);
        System.out.print("Data ważności (yyyy-mm-dd): ");
        String dataWaznosciStr1 = scanner.nextLine();
        LocalDate dataWaznosci1 = LocalDate.parse(dataWaznosciStr1);
        System.out.print("Opis: ");
        String opis1 = scanner.nextLine();

        RodzajDokumentu rodzajDokumentu1 = null;
        while (rodzajDokumentu1 == null) {
            System.out.print("Rodzaj dokumentu (PASZPORT, DOWOD_OSOBISTY, PRAWO_JAZDY, DOWOD_REJESTRACYJNY, LEGITYMACJA_SZKOLNA, LEGITYMACJA_STUDENCKA): ");
            String rodzajStr = scanner.nextLine().toUpperCase();
            if (RodzajDokumentu.czyPoprawny(rodzajStr)) {
                rodzajDokumentu1 = RodzajDokumentu.valueOf(rodzajStr);
            } else {
                System.out.println("Niepoprawny rodzaj dokumentu. Spróbuj ponownie.");
            }
        }

        Dokument dokument1 = new Dokument(numer1, dataWydania1, dataWaznosci1, opis1, rodzajDokumentu1);
        urzednik.dodajDokument(dokument1);

        System.out.println("Podaj szczegóły płatnośći:");
        System.out.print("Ilosc: ");
        double ilosc = scanner.nextDouble();
        scanner.nextLine();
        RodzajPlatnosci rodzajPlatnosci = null;
        while (rodzajPlatnosci == null) {
            System.out.print("Rodzaj platnosci (KARTA, GOTOWKA, BLIK): ");
            String platnosciStr = scanner.nextLine().toUpperCase();
            if (RodzajPlatnosci.czyPoprawny(platnosciStr)) {
                rodzajPlatnosci = RodzajPlatnosci.valueOf(platnosciStr);
            } else {
                System.out.println("Niepoprawny rodzaj płatności. Spróbuj ponownie.");
            }
        }

        Status platnoscStatus = null;
        while (platnoscStatus == null) {
            System.out.print("Status platnosci (ZLOZONA, W_TRAKCIE, ZREALIZOANA): ");
            String platnoscStatusStr = scanner.nextLine().toUpperCase();
            if (Status.czyPoprawny(platnoscStatusStr)) {
                platnoscStatus = Status.valueOf(platnoscStatusStr);
            } else {
                System.out.println("Niepoprawny status płatności. Spróbuj ponownie.");
            }
        }

        Platnosc platnosc = new Platnosc(ilosc, rodzajPlatnosci, platnoscStatus);

        System.out.println("Podaj szczegóły wniosku:");
        System.out.print("Opis: ");
        String sprawaOpis = scanner.nextLine();
        System.out.print("Data złożenia (yyyy-mm-dd): ");
        String dataZlozeniaStr = scanner.nextLine();
        LocalDate dataZlozenia = LocalDate.parse(dataZlozeniaStr);

        Sprawa sprawa = new Sprawa(obywatel, sprawaOpis, dataZlozenia, platnoscStatus, platnosc);

        System.out.println("\nStworzono Obywatel: " + obywatel);
        urzad.dodajObywatela(obywatel);
        System.out.println("Stworzono Dokument: " + dokument);
        System.out.println("Stworzono Urzednik: " + urzednik);
        urzad.dodajObywatela(urzednik);
        System.out.println("Stworzono Platnosc: " + platnosc);
        System.out.println("Stworzono Sprawa: " + sprawa);
        urzad.dodajSprawe(sprawa);


        // Skanery wer.2
        String odp;
        do {
            System.out.println("Wybierz obiekt na którym chcesz działać (1-Obywatel, 2-Sprawa):");
            int wybor = zwrocOdpowiedniaLiczbe(2);
            switch (wybor) {
                case 1 -> {
                    System.out.println("Możliwe działania(1-dodaj obywatela,2-usun obywatela,3-znajdz obywatela):");
                    wybor = zwrocOdpowiedniaLiczbe(3);
                    switch (wybor) {
                        case 1 -> {
                            dodajObywatela();
                        }
                        case 2 -> {
                            int iloscObywatelow = urzad.getObywatele().size();
                            for (int i = 1; i <= iloscObywatelow; i++) {
                                System.out.println(i + urzad.znajdzObywatela(i-1).toString());
                            }
                            System.out.println("Ilość obywatelów:"+iloscObywatelow);
                            wybor=zwrocOdpowiedniaLiczbe(iloscObywatelow)-1;
                            urzad.usunSprawe(wybor);
                        }
                        case 3 -> {
                            System.out.println("Podaj argument według którego szukać obywatela(imie,nazwisko,adres,telefon:");
                            String arg = scanner.nextLine();
                            System.out.println("Podaj jego wartość:");
                            String wartosc = scanner.nextLine();
                            urzad.znajdzObywatela(wartosc,arg);
                        }

                    }
                }
                case 2 -> {
                    System.out.println("Możliwe działania(1-dodaj sprawe,2-usun sprawe, 3- znajdz sprawe):");
                    wybor = zwrocOdpowiedniaLiczbe(3);
                    switch (wybor) {
                        case 1 -> {
                            dodajSprawe();
                        }
                        case 2 -> {
                            int iloscSpraw = urzad.getSprawy().size();
                            System.out.println("Ilość spraw:"+iloscSpraw);
                            for (int i = 1; i <= iloscSpraw; i++) {
                                System.out.println(i + urzad.znajdzSprawe(i-1).toString());
                            }
                            wybor=zwrocOdpowiedniaLiczbe(iloscSpraw)-1;
                            urzad.usunSprawe(wybor);
                        }
                        case 3 -> {
                            System.out.println("Podaj argument według którego szukać sprawę(status,opis,data:");
                            String arg = scanner.nextLine();
                            znajdzSprawe(arg);
                        }
                    }
                }
            }
            System.out.println("Czy kontynuować?(T/N)");
            odp = scanner.nextLine();
        } while (!odp.equalsIgnoreCase("T"));
    }
    public static int zwrocOdpowiedniaLiczbe (int max){
        int wybor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Niepoprawna opcja! Spróbuj ponownie.");
                scanner.next();
            }
            wybor = scanner.nextInt();

            if (wybor < 1 || wybor > max) System.out.printf("Niepoprawna opcja. Wybierz liczbę między 1 a %d.\n",max);
        } while (wybor < 1 || wybor > max);
        return wybor;
    }
    public static void dodajObywatela(){
        System.out.println("Podaj szczegóły obywatela:");
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Adres: ");
        String adres = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        System.out.println("Podaj szczegóły dokumentu:");
        System.out.print("Numer: ");
        String numer = scanner.nextLine();
        System.out.print("Data wydania (yyyy-mm-dd): ");
        String dataWydaniaStr = scanner.nextLine();
        LocalDate dataWydania = LocalDate.parse(dataWydaniaStr);
        System.out.print("Data ważności (yyyy-mm-dd): ");
        String dataWaznosciStr = scanner.nextLine();
        LocalDate dataWaznosci = LocalDate.parse(dataWaznosciStr);
        System.out.print("Opis: ");
        String opis = scanner.nextLine();

        RodzajDokumentu rodzajDokumentu = null;
        while (rodzajDokumentu == null) {
            System.out.print("Rodzaj dokumentu (PASZPORT, DOWOD_OSOBISTY, PRAWO_JAZDY, DOWOD_REJESTRACYJNY, LEGITYMACJA_SZKOLNA, LEGITYMACJA_STUDENCKA): ");
            String rodzajStr = scanner.nextLine().toUpperCase();
            if (RodzajDokumentu.czyPoprawny(rodzajStr)) {
                rodzajDokumentu = RodzajDokumentu.valueOf(rodzajStr);
            } else {
                System.out.println("Niepoprawny rodzaj dokumentu. Spróbuj ponownie.");
            }
        }
        Dokument dokument = new Dokument(numer, dataWydania, dataWaznosci, opis, rodzajDokumentu);

        System.out.print("Czy obywatel jest urzędnikiem?(T/N)? ");
        String odp = scanner.nextLine();
        if (odp.equalsIgnoreCase("T")){
            System.out.print("Stanowisko: ");
            String stanowisko = scanner.nextLine();
            Urzednik urzednik = new Urzednik(imie, nazwisko, adres, telefon,stanowisko);
            urzednik.dodajDokument(dokument);
            urzad.dodajObywatela(urzednik);
        } else {
            Obywatel obywatel = new Obywatel(imie, nazwisko, adres, telefon);
            obywatel.dodajDokument(dokument);
            urzad.dodajObywatela(obywatel);
        }
    }

    public static void dodajSprawe(){
        System.out.println("Podaj szczegóły płatnośći:");
        System.out.print("Ilosc: ");
        double ilosc = scanner.nextDouble();
        scanner.nextLine();
        RodzajPlatnosci rodzajPlatnosci = null;
        while (rodzajPlatnosci == null) {
            System.out.print("Rodzaj platnosci (KARTA, GOTOWKA, BLIK): ");
            String platnosciStr = scanner.nextLine().toUpperCase();
            if (RodzajPlatnosci.czyPoprawny(platnosciStr)) {
                rodzajPlatnosci = RodzajPlatnosci.valueOf(platnosciStr);
            } else {
                System.out.println("Niepoprawny rodzaj płatności. Spróbuj ponownie.");
            }
        }

        Status platnoscStatus = null;
        while (platnoscStatus == null) {
            System.out.print("Status platnosci (ZLOZONA, W_TRAKCIE, ZREALIZOANA): ");
            String platnoscStatusStr = scanner.nextLine().toUpperCase();
            if (Status.czyPoprawny(platnoscStatusStr)) {
                platnoscStatus = Status.valueOf(platnoscStatusStr);
            } else {
                System.out.println("Niepoprawny status płatności. Spróbuj ponownie.");
            }
        }

        Platnosc platnosc = new Platnosc(ilosc, rodzajPlatnosci, platnoscStatus);

        System.out.println("Podaj szczegóły wniosku:");
        System.out.print("Opis: ");
        String sprawaOpis = scanner.nextLine();
        System.out.print("Data złożenia (yyyy-mm-dd): ");
        String dataZlozeniaStr = scanner.nextLine();
        LocalDate dataZlozenia = LocalDate.parse(dataZlozeniaStr);

        System.out.println("Który obywatel składał sprawę");
        int iloscObywatelow = urzad.getObywatele().size();
        for (int i = 1; i <= iloscObywatelow; i++) {
            System.out.println(i + urzad.znajdzObywatela(i-1).toString());
        }
        int wybor=zwrocOdpowiedniaLiczbe(iloscObywatelow)-1;
        Sprawa sprawa = new Sprawa(urzad.znajdzObywatela(wybor), sprawaOpis, dataZlozenia, platnoscStatus, platnosc);
        urzad.dodajSprawe(sprawa);
    }

    public static void znajdzSprawe(String szukanyArgument){
            switch (szukanyArgument.toLowerCase()) {
                case "status" -> {
                    Status status = null;
                    while (status == null) {
                        System.out.print("Podaj status (ZLOZONA, W_TRAKCIE, ZREALIZOANA): ");
                        String statusStr = scanner.nextLine().toUpperCase();
                        if (Status.czyPoprawny(statusStr)) {
                            status = Status.valueOf(statusStr);
                        } else {
                            System.out.println("Niepoprawny status. Spróbuj ponownie.");
                        }
                    }
                    urzad.znajdzSprawe(status);
                }
                case "opis" -> {
                    System.out.println("Podaj opis:");
                    String opis = scanner.nextLine();
                    urzad.znajdzSprawe(opis);
                }
                case "data" -> {
                    System.out.println("Podaj datę (yyyy-mm-dd):");
                    String dataStr= scanner.nextLine();
                    LocalDate data= LocalDate.parse(dataStr);
                    urzad.znajdzSprawe(data);
                }
                default -> {
                    System.out.println("Nieprawdiłowy argument");;
                }
            }
        }
}
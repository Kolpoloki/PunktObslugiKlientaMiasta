package zadanie;

import zadanie.enumy.RodzajDokumentu;
import zadanie.enumy.RodzajPlatnosci;
import zadanie.enumy.Status;
import zadanie.model.*;
import zadanie.config.Inicjalizacja;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = Inicjalizacja.scanner;
    static UrzadMiasta urzad = Inicjalizacja.urzad;

    public static void main(String[] args) {
        Inicjalizacja.inicjalizujDane();
        System.out.println("Nasz urząd miasta:");
        uruchomMenu();
    }
    public static void uruchomMenu(){
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
                            System.out.println("Ilość obywatelów:"+iloscObywatelow);
                            for (int i = 0; i < iloscObywatelow; i++) {
                                System.out.println((i+1) + ". " + urzad.znajdzObywatela(i));
                            }
                            System.out.println("Podaj numer obywatela do usunięcia:");
                            wybor=zwrocOdpowiedniaLiczbe(iloscObywatelow)-1;
                            urzad.usunObywatela(wybor);
                        }
                        case 3 -> {
                            System.out.println("Podaj argument według którego szukać obywatela(1-imie,2-nazwisko,3-adres,4-telefon):");
                            wybor=zwrocOdpowiedniaLiczbe(4);
                            System.out.println("Podaj jego wartość:");
                            String wartosc = scanner.nextLine();
                            urzad.pokazObywatelow(urzad.znajdzObywatela(wartosc,wybor));
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
                                System.out.println(i + ". " + urzad.znajdzSprawe(i-1));
                            }
                            System.out.println("Podaj numer sprawy do usunięcia:");
                            wybor=zwrocOdpowiedniaLiczbe(iloscSpraw)-1;
                            urzad.usunSprawe(wybor);
                        }
                        case 3 -> {
                            System.out.println("Podaj argument według którego szukać sprawę(1-status,2-opis,3-data:)");
                            int arg = zwrocOdpowiedniaLiczbe(3);
                            znajdzSprawe(arg);
                        }
                    }
                }
            }
            System.out.println("Czy kontynuować?(T/N)");
            odp = scanner.nextLine();
        } while (odp.equalsIgnoreCase("T"));
    }

    public static int zwrocOdpowiedniaLiczbe (int max){
        int wybor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Niepoprawna opcja! Spróbuj ponownie.");
                scanner.nextLine();
            }
            wybor = scanner.nextInt();
            scanner.nextLine();

            if (wybor < 1 || wybor > max) System.out.printf("Niepoprawna opcja. Wybierz liczbę między 1 a %d.\n",max);
        } while (wybor < 1 || wybor > max);
        return wybor;
    }
    public static void dodajObywatela(){
        System.out.println("Podaj szczegóły obywatela:");
        System.out.print("Imię: ");
        String imie = pobierzNiePustyString("Imię");
        System.out.print("Nazwisko: ");
        String nazwisko = pobierzNiePustyString("Nazwisko");
        System.out.print("Adres: ");
        String adres = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();
        while (!telefon.matches("\\d{9}")) {
            System.out.println("Telefon musi mieć 9 cyfr:");
            telefon = scanner.nextLine();
        }
        System.out.println("Podaj szczegóły dokumentu:");
        System.out.print("Numer: ");
        String numer = scanner.nextLine();
        System.out.print("Data wydania (yyyy-mm-dd): ");
        LocalDate dataWydania = pobierzDate();
        System.out.print("Data ważności (yyyy-mm-dd): ");
        LocalDate dataWaznosci = pobierzDate();
        while (dataWaznosci.isBefore(dataWydania)) {
            System.out.println("Data ważności nie może być wcześniejsza niż data wydania!");
            dataWaznosci = pobierzDate();
        }
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
        System.out.println("Obywatel został pomyślnie dodany!");
    }

    public static void dodajSprawe(){
        System.out.println("Podaj szczegóły płatności:");
        System.out.print("Ilosc: ");
        double ilosc;
        while (!scanner.hasNextDouble()) {
            System.out.println("Podaj poprawną liczbę!");
            scanner.nextLine();
        }
        ilosc = scanner.nextDouble();
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

        Status platnoscStatus = pobierzStatus();
        Platnosc platnosc = new Platnosc(ilosc, rodzajPlatnosci, platnoscStatus);

        System.out.println("Podaj szczegóły wniosku:");
        System.out.print("Opis: ");
        String sprawaOpis = scanner.nextLine();
        System.out.print("Data złożenia (yyyy-mm-dd): ");
        LocalDate dataZlozenia = pobierzDate();
        System.out.println("Który obywatel składa sprawę?");
        int iloscObywatelow = urzad.getObywatele().size();
        for (int i = 0; i < iloscObywatelow; i++) {
            System.out.println((i+1) + ". " + urzad.znajdzObywatela(i));
        }
        int wybor=zwrocOdpowiedniaLiczbe(iloscObywatelow)-1;
        Sprawa sprawa = new Sprawa(urzad.znajdzObywatela(wybor), sprawaOpis, dataZlozenia, platnoscStatus, platnosc);
        urzad.dodajSprawe(sprawa);
        System.out.println("Wniosek został pomyślnie dodany!");
    }

    public static void znajdzSprawe(int szukanyArgument){
        switch (szukanyArgument) {
            case 1 -> {
                Status status = pobierzStatus();
                urzad.pokazSprawy(urzad.znajdzSprawe(status));
            }
            case 2 -> {
                System.out.println("Podaj opis:");
                String opis = scanner.nextLine();
                urzad.pokazSprawy(urzad.znajdzSprawe(opis));
            }
            case 3 -> {
                System.out.println("Podaj datę (yyyy-mm-dd):");
                LocalDate data= pobierzDate();
                urzad.pokazSprawy(urzad.znajdzSprawe(data));
            }
            default -> {
                System.out.println("Nieprawidłowy argument");
            }
        }
    }

    public static LocalDate pobierzDate(){
        LocalDate data = null;
        while (data == null){
            String dataStr = scanner.nextLine();
            try {
                data = LocalDate.parse(dataStr);
            } catch (Exception e){
                System.out.println("Niepoprawny format daty! Podaj ponownie.");
            }
        }
        return data;
    }

    public static Status pobierzStatus(){
        Status status = null;
        while (status == null) {
            System.out.print("Podaj status (ZLOZONA, W_TRAKCIE, ZREALIZOWANA): ");
            String statusStr = scanner.nextLine().toUpperCase();
            if (Status.czyPoprawny(statusStr)) {
                status = Status.valueOf(statusStr);
            } else {
                System.out.println("Niepoprawny status. Spróbuj ponownie.");
            }
        }
        return status;
    }
    public static String pobierzNiePustyString(String nazwa){
        String str = scanner.nextLine();
        while (str.isBlank()) {
            System.out.println(nazwa + " nie może być puste:");
            str = scanner.nextLine();
        }
        return str;
    }
}
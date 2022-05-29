package com.jakjaw;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Scanner skaner;
    private static Baza baza;
    private static int current = 0;

    public static void drukujMenu(String[] opcje){
        for (String opcja : opcje){
            System.out.println(opcja);
        }
        baza.drukujcurrent(current);
        System.out.print("Wybierz opcje: ");
    }

    public static void main(String[] args) throws InterruptedException {
        baza = new BazaImpl();
        String[] opcje = {"1- Utworz plik txt",
                "2- Zapisz dane do pliku txt",
                "3- Wczytaj plik txt",
                "4- Usun plik txt",
                "5- Drukuj wszystko",
                "6- Poprzedni element",
                "7- Nastepny element",
                "8- Dodaj element",
                "9- Aktualizuj element",
                "10- Usun element",
                "11- Szukaj ocena",
                "12- Szukaj nazwa",
                "13- Sortuj malejaco wedlug oceny",
                "14- Sortuj rosnaco wedlug oceny",
                "15- Sortuj malejaco wedlug nazwy",
                "16- Sortuj rosnaco wedlug nazwy",
                "17- Wyjscie",
        };

        Scanner scanner = new Scanner(System.in);
        int opcja = 1;

        while (opcja!=18){
            drukujMenu(opcje);
            try {
                opcja = scanner.nextInt();
                switch (opcja) {
                    case 1 -> {option1();TimeUnit.SECONDS.sleep(3);}
                    case 2 -> {option2();TimeUnit.SECONDS.sleep(3);}
                    case 3 -> {option3();TimeUnit.SECONDS.sleep(3);}
                    case 4 -> {option4();TimeUnit.SECONDS.sleep(3);}
                    case 5 -> {option5();TimeUnit.SECONDS.sleep(3);}
                    case 6 -> {option6();}
                    case 7 -> {option7();}
                    case 8 -> {option8();TimeUnit.SECONDS.sleep(3);}
                    case 9 -> {option9();TimeUnit.SECONDS.sleep(3);}
                    case 10 -> {option10();TimeUnit.SECONDS.sleep(3);}
                    case 11 -> {option11();TimeUnit.SECONDS.sleep(3);}
                    case 12 -> {option12();TimeUnit.SECONDS.sleep(3);}
                    case 13 -> {option13();TimeUnit.SECONDS.sleep(3);}
                    case 14 -> {option14();TimeUnit.SECONDS.sleep(3);}
                    case 15 -> {option15();TimeUnit.SECONDS.sleep(3);}
                    case 16 ->{option16();TimeUnit.SECONDS.sleep(3);}
                    case 17->{option17();TimeUnit.SECONDS.sleep(3);}
                }
            }
            catch (Exception ex){
                System.out.println("Wprowadzono bledne dane [Enter]");
                TimeUnit.SECONDS.sleep(3);
                scanner.next();
            }
        }
    }


    private static void option1() {
        System.out.println("Tworze plik...");
        int wynik = baza.stworz();
        if(wynik == 0){System.out.println("Napotkano blad");}
    }


    private static void option2() {
        System.out.println("Zapisuje...");
        int wynik = baza.zapisz();
        if(wynik == 0){System.out.println("Napotkano blad");}
    }


    private static void option3() {
        System.out.println("Wczytuje...");
        int wynik = baza.wczytaj();
        if(wynik==0){System.out.println("Brak pliku");}
    }


    private static void option4() {
        System.out.println("Usuwam...");
        int wynik = baza.usunplik();
        if (wynik == 0){System.out.println("Brak wybranego pliku");}
    }


    private static void option5(){
        int wynik = baza.drukujwszysto();
        if (wynik==0){System.out.println("Magazyn jest pusty");}
    }

    private static void option6() {current -= 1;}
    private static void option7() {current += 1;}

    private static void option8() {
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();

        if(baza.sprawdz_Haslo(haslo) == 1){
            try{
                skaner = new Scanner(System.in);

                System.out.println("Podaj nazwe: ");
                String nazwa = skaner.next();

                System.out.println("Podaj cene: ");
                float cena = skaner.nextFloat();
                if(cena<0){
                    System.out.println("cena musi być dodatnia liczba");
                    return;
                }

                System.out.println("Ocena (0-10): ");
                int ocena = skaner.nextInt();
                if(ocena>10 || ocena<0){
                    System.out.println("Podaj ocene od 0 do 10");
                    return;
                }

                System.out.println("Podaj ilosc: ");
                int sztuk = skaner.nextInt();
                if(sztuk<0){
                    System.out.println("Ilosc musi być dodatnia liczba");
                    return;
                }

                System.out.println("Podaj liczbe opakowan: ");
                int opakowania = skaner.nextInt();
                if(opakowania<0){
                    System.out.println("Opakowania musza być dodatnia liczba");
                    return;
                }

                System.out.println("Podaj gatunek: ");
                String gatunek = skaner.next();

                System.out.println("Nazwa: " + nazwa + " Cena: "+ cena + "zl Ocena: "+ ocena + " Liczba opakowan: "+ opakowania + " Gatunek: "+ gatunek);
                baza.dodaj(nazwa, cena, ocena, sztuk, opakowania, gatunek);
                System.out.println("Dodano...");
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Podano zly typ danej");
            }
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option9(){
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            System.out.println("Podaj indeks elementu ktory chcesz zaktualizowac: ");
            skaner = new Scanner(System.in);
            int pozycja = skaner.nextInt();

            try{
                skaner = new Scanner(System.in);

                System.out.println("Podaj nazwe: ");
                String nazwa = skaner.next();

                System.out.println("Podaj cene: ");
                float cena = skaner.nextFloat();
                if(cena<0){
                    System.out.println("cena musi być dodatnia liczba");
                    return;
                }

                System.out.println("Ocena (0-10): ");
                int ocena = skaner.nextInt();
                if(ocena>10 || ocena<0){
                    System.out.println("Podaj ocene od 0 do 10");
                    return;
                }

                System.out.println("Podaj ilosc: ");
                int sztuk = skaner.nextInt();
                if(sztuk<0){
                    System.out.println("Ilosc musi być dodatnia liczba");
                    return;
                }

                System.out.println("Podaj liczbe opakowan: ");
                int opakowania = skaner.nextInt();
                if(opakowania<0){
                    System.out.println("Opakowania musza być dodatnia liczba");
                    return;
                }

                System.out.println("Podaj gatunek: ");
                String gatunek = skaner.next();

                int wynik = baza.podmien(pozycja, nazwa, cena, ocena, sztuk, opakowania, gatunek);
                if(wynik==0){System.out.println("Brak odpowiedniego elementu");}
            }
            catch (Exception e){
                System.out.println("Podano zly typ danej");
            }
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option10(){
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            skaner = new Scanner(System.in);
            System.out.println("Czy aby napweno? (1=tak/0=nie): ");
            int potwierdz = (int)skaner.nextInt();
            if(potwierdz == 1){System.out.println("Podaj indeks usuwanego elementu: ");
                int usun = skaner.nextInt();
                current=0;
                int wynik = baza.usun_current(usun);
                if(wynik==1){System.out.println("Usunieto");}
                else {System.out.println("Nie mozna usunac");}
            }
            else {System.out.println("Zle haslo");}
        }
    }


    private static void option11() {
        Scanner skanner = new Scanner(System.in);

        try {
            System.out.println("Podaj minimalna ocene: ");
            int min = skanner.nextInt();
            if (min < 0 || min > 10) {
                System.out.println("Podaj liczbe od 0 do 10");
                return;
            }

            System.out.println("Podaj maksymalna ocene: ");
            int max = skanner.nextInt();
            if (max < 0 || max > 10) {
                System.out.println("Podaj liczbe od 0 do 10");
                return;
            }

            baza.szukajocena(min, max);
        }
        catch (Exception e){System.out.println("Podano zly typ danej");
        }
    }


    private static void option12(){
        Scanner skanner = new Scanner(System.in);

        try {
            System.out.println("Podaj pierwsza litere: ");
            char l1 = skanner.next().charAt(0);
            l1 = Character.toUpperCase(l1);

            System.out.println("Podaj ostatnia litere: ");
            char l2 = skanner.next().charAt(0);
            l2 = Character.toUpperCase(l2);

            baza.szukajNazwa(l1, l2);
        }
        catch (Exception e){System.out.println("Podano zly typ danej");
        }
    }


    private static void option13(){
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            baza.sortujMalejaco();
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option14(){
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            baza.sortujRosnaco();
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option15() {
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            baza.sortujtxtMalejoco();
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option16() {
        skaner = new Scanner(System.in);
        System.out.println("Podaj haslo: ");
        String haslo = skaner.nextLine();
        if(baza.sprawdz_Haslo(haslo) == 1){
            baza.sortujtxtRosnoco();
        }
        else {
            System.out.println("Zle haslo");
        }
    }


    private static void option17() {
        Scanner skaner2 = new Scanner(System.in);
        System.out.println("Czy aby napewno chcesz wyjsc (1-tak, 0-nie):");
        int wybor = skaner2.nextInt();

        if (wybor == 1){
            System.out.println("Zegnam");
            System.exit(0);}
    }
}
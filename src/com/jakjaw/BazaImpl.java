package com.jakjaw;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BazaImpl implements Baza {
    private ArrayList<Filmy> tekstTemporary;
    private ArrayList<Filmy> films;
    private ArrayList<Filmy> arrayszukaj;


    public BazaImpl() {
        tekstTemporary = new ArrayList<>();
        films = new ArrayList<>();
        arrayszukaj = new ArrayList<>();
    }


    public void dodaj(String Nazwa, float cena, int ocena, int sztuk, int opakowania, String gatunek) {
        Filmy film = new Filmy();
        film.setNazwa(Nazwa);
        film.setCena(cena);
        film.setOcena(ocena);
        film.setIlosc(sztuk);
        film.setOpakowania(opakowania);
        film.setGatunek(gatunek);
        films.add(film);
    }


    public int sprawdz_Haslo(String haslo) {
        try {
            File myObj = new File("haslo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String sb = "";
                for(int i=0;i<data.length();i++){
                    char c=data.charAt(i);
                    if(i%2==0){
                        if(c==100)
                            c=(char) (c+10);
                        else{
                            c=(char) (c-7);}
                        sb=sb+c;}
                    else{c=(char) (c+3);sb=sb+c;}
                }
                if (sb.equals(haslo)) {return 1;}
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return 1;
        }
        return 0;
    }


    public int usun_current(int index) {
        if (films.size() <= index || index < 0 || films == null) {
            return 0;
        } else {
            films.remove(index);
            return 1;
        }
    }


    public int drukujwszysto() {
        if (films.size() == 0) {return 0;}
        else {
            for (int i = 0; i < films.size(); i++) {
                System.out.println("XXXXXXXXXXX  Pozycja: " + i + "  XXXXXXXXXXX");
                System.out.println("Nazwa: " + films.get(i).getNazwa());
                System.out.println("Cena: " + films.get(i).getCena());
                System.out.println("Ocena: " + films.get(i).getOcena());
                System.out.println("Liczba: " + films.get(i).getSztuk());
                System.out.println("Liczba opakowan: " + films.get(i).getOpakowania());
                System.out.println("Gatunek: " + films.get(i).getGatunek());
            }
            return 1;
        }
    }


    public void drukujcurrent(int current) {
        if (films.size() <= current || current < 0) {return;}
        else {
            System.out.println("XXXXXXXXXXX  Pozycja: " + current + "  XXXXXXXXXXX");
            System.out.println("Nazwa: " + films.get(current).getNazwa());
            System.out.println("Cena: " + films.get(current).getCena());
            System.out.println("Ocena: " + films.get(current).getOcena());
            System.out.println("Liczba: " + films.get(current).getSztuk());
            System.out.println("Liczba opakowan: " + films.get(current).getOpakowania());
            System.out.println("Gatunek: " + films.get(current).getGatunek());
            return;
        }
    }

    public void drukujcurrent2(int current) {
        if (arrayszukaj.size() <= current || current < 0) {return;}
        else {
            System.out.println("XXXXXXXXXXX  Pozycja: " + current + "  XXXXXXXXXXX");
            System.out.println("Nazwa: " + arrayszukaj.get(current).getNazwa());
            System.out.println("Cena: " + arrayszukaj.get(current).getCena());
            System.out.println("Ocena: " + arrayszukaj.get(current).getOcena());
            System.out.println("Liczba: " + arrayszukaj.get(current).getSztuk());
            System.out.println("Liczba opakowan: " + arrayszukaj.get(current).getOpakowania());
            System.out.println("Gatunek: " + arrayszukaj.get(current).getGatunek());
            return;
        }
    }


    public int podmien(int index, String Nazwa, float cena, int ocena, int sztuk, int opakowania, String gatunek) {
        if (index < 0 || films.size() <= index || films == null) {
            return 0;
        } else {
            Filmy film = new Filmy();
            film.setNazwa(Nazwa);
            film.setCena(cena);
            film.setOcena(ocena);
            film.setIlosc(sztuk);
            film.setOpakowania(opakowania);
            film.setGatunek(gatunek);
            films.remove(index);
            films.add(index, film);
        }
        return 1;
    }

    public int usunplik() {
        File myObj = new File("dane.txt");
        if (myObj.delete()) {
            return 1;
        } else {
            return 0;
        }
    }


    public int zapisz() {
        try {
            File myObj = new File("dane.txt");
            myObj.delete();
            FileWriter file = new FileWriter("dane.txt");
            for (int i = 0; i < films.size(); i++) {
                Filmy Tekstkultury = films.get(i);
                file.write(String.valueOf(films.get(i).getNazwa()));
                file.write(";");
                file.write(String.valueOf(Tekstkultury.getCena()));
                file.write(";");
                file.write(String.valueOf(Tekstkultury.getOcena()));
                file.write(";");
                file.write(String.valueOf(Tekstkultury.getSztuk()));
                file.write(";");
                file.write(String.valueOf(Tekstkultury.getOpakowania()));
                file.write(";");
                file.write(String.valueOf(Tekstkultury.getGatunek()));
                file.write(System.lineSeparator());
            }
            file.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }


    public int stworz() {
        try {
            File myObj = new File("dane.txt");
            if (myObj.createNewFile()) {
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            return 0;
        }
    }


    public int wczytaj() {
        try {
            Scanner scanner = new Scanner(new File("dane.txt"));
            Path pathFileToRead = Paths.get("./dane.txt");
            List<String> lines = Files.readAllLines(pathFileToRead);
            for(String line: lines){
                String[] eachword = line.split(";");
                Filmy film = new Filmy();
                film.setNazwa(eachword[0]);
                film.setCena(Float.valueOf(eachword[1]));
                film.setOcena(Integer.valueOf(eachword[2]));
                film.setIlosc(Integer.valueOf(eachword[3]));
                film.setOpakowania(Integer.valueOf(eachword[4]));
                film.setGatunek(eachword[5]);
                films.add(film);
            }
        }

        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        return 1;
    }



    public void sortujRosnaco() {
        if (films.size() > 1) {
            for (int x = 0; x < films.size(); x++) {
                for (int i = 0; i < films.size() - 1; i++) {
                    if (films.get(i).getOcena() > films.get(i + 1).getOcena()) {
                        String tempnazwa = films.get(i).getNazwa();
                        float tempcena = films.get(i).getCena();
                        int tempocena = films.get(i).getOcena();
                        int tempilosc = films.get(i).getSztuk();
                        int tempopakowania = films.get(i).getOpakowania();
                        String tempgatunek = films.get(i).getGatunek();
                        films.set(i, films.get(i + 1));
                        Filmy film = new Filmy();
                        film.setNazwa(tempnazwa);
                        film.setCena(tempcena);
                        film.setOcena(tempocena);
                        film.setIlosc(tempilosc);
                        film.setOpakowania(tempopakowania);
                        film.setGatunek(tempgatunek);
                        films.remove(i + 1);
                        films.add(i + 1, film);
                    }
                }
            }
        }
    }


    public void sortujMalejaco() {
        if (films.size() > 1) {
            for (int x = 0; x < films.size(); x++) {
                for (int i = 0; i < films.size() - 1; i++) {
                    if (films.get(i).getOcena() < films.get(i + 1).getOcena()) {
                        String tempnazwa = films.get(i).getNazwa();
                        float tempcena = films.get(i).getCena();
                        int tempocena = films.get(i).getOcena();
                        int tempilosc = films.get(i).getSztuk();
                        int tempopakowania = films.get(i).getOpakowania();
                        String tempgatunek = films.get(i).getGatunek();
                        films.set(i, films.get(i + 1));
                        Filmy film = new Filmy();
                        film.setNazwa(tempnazwa);
                        film.setCena(tempcena);
                        film.setOcena(tempocena);
                        film.setIlosc(tempilosc);
                        film.setOpakowania(tempopakowania);
                        film.setGatunek(tempgatunek);
                        films.remove(i + 1);
                        films.add(i + 1, film);
                    }
                }
            }
        }
    }


    public void sortujtxtRosnoco(){
        if (films.size() > 1) {
            for (int x = 0; x < films.size(); x++) {
                for (int i = 0; i < films.size() - 1; i++) {
                    char firstChar = films.get(i).getNazwa().charAt(0);
                    char nextchar = films.get(i+1).getNazwa().charAt(0);
                    if(firstChar > nextchar) {
                        String tempnazwa = films.get(i).getNazwa();
                        float tempcena = films.get(i).getCena();
                        int tempocena = films.get(i).getOcena();
                        int tempilosc = films.get(i).getSztuk();
                        int tempopakowania = films.get(i).getOpakowania();
                        String tempgatunek = films.get(i).getGatunek();
                        films.set(i, films.get(i + 1));
                        Filmy film = new Filmy();
                        film.setNazwa(tempnazwa);
                        film.setCena(tempcena);
                        film.setOcena(tempocena);
                        film.setIlosc(tempilosc);
                        film.setOpakowania(tempopakowania);
                        film.setGatunek(tempgatunek);
                        films.remove(i + 1);
                        films.add(i + 1, film);
                    }
                }
            }
        }
    }


    public void sortujtxtMalejoco(){
        if (films.size() > 1) {
            for (int x = 0; x < films.size(); x++) {
                for (int i = 0; i < films.size() - 1; i++) {
                    char firstChar = films.get(i).getNazwa().charAt(0);
                    char nextchar = films.get(i+1).getNazwa().charAt(0);
                    if(firstChar < nextchar) {
                        String tempnazwa = films.get(i).getNazwa();
                        float tempcena = films.get(i).getCena();
                        int tempocena = films.get(i).getOcena();
                        int tempilosc = films.get(i).getSztuk();
                        int tempopakowania = films.get(i).getOpakowania();
                        String tempgatunek = films.get(i).getGatunek();
                        films.set(i, films.get(i + 1));
                        Filmy film = new Filmy();
                        film.setNazwa(tempnazwa);
                        film.setCena(tempcena);
                        film.setOcena(tempocena);
                        film.setIlosc(tempilosc);
                        film.setOpakowania(tempopakowania);
                        film.setGatunek(tempgatunek);
                        films.remove(i + 1);
                        films.add(i + 1, film);
                    }
                }
            }
        }
    }


    public void drukujMenu(int current) {
        while (true) {
            drukujcurrent2(current);
            System.out.println("1-Pokaz nastepny element");
            System.out.println("2-Pokaz poprzedni element");
            System.out.println("3-Powrot");
            Scanner sk = new Scanner(System.in);
            int wybor = sk.nextInt();

            if (wybor == 1 && current < films.size()) {current += 1;
                drukujMenu(current);break;}
            else if (wybor == 2 && current >= 0) {current -= 1;
                drukujMenu(current);break;}
            else if (wybor == 3) {break;}
        }
    }

    public void szukajocena(int min, int max) {
        if (films.size() >= 1) {
            for (int x = 0; x < films.size(); x++) {
                if (films.get(x).getOcena() >= min && films.get(x).getOcena() <= max) {
                    arrayszukaj.add(films.get(x));
                }
            }
            drukujMenu(0);
            arrayszukaj.clear();
            return;
        }
    }


    public void szukajNazwa(char l1, char l2) {
        if (films.size() >= 1) {
            for (int x = 0; x < films.size(); x++) {
                char firstChar = films.get(x).getNazwa().charAt(0);
                firstChar = Character.toUpperCase(firstChar);
                String nazwa = films.get(x).getNazwa();
                char lastchar = films.get(x).getNazwa().charAt(nazwa.length()-1);
                lastchar = Character.toUpperCase(lastchar);
                if (firstChar == l1 && lastchar == l2) {
                    arrayszukaj.add(films.get(x));
                }
            }
            drukujMenu(0);
            arrayszukaj.clear();
        }
    }
}
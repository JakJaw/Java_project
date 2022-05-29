package com.jakjaw;

public interface Baza {

    void dodaj(String Nazwa, float cena, int ocena,int sztuk, int opakowania, String gatunek);
    int usun_current(int usun);
    int sprawdz_Haslo(String haslo);
    int drukujwszysto();
    void drukujcurrent(int current);
    void drukujcurrent2(int current);
    int zapisz();
    int stworz();
    int usunplik();
    int podmien(int index, String Nazwa, float cena, int ocena, int sztuk, int opakowania, String gatunek);
    int wczytaj();
    void sortujRosnaco();
    void sortujMalejaco();
    void sortujtxtRosnoco();
    void sortujtxtMalejoco();
    void szukajocena(int min, int max);
    void szukajNazwa(char l1, char l2);
}

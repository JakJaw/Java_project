package com.jakjaw;

public class Filmy extends Tekst{
    private String gatunek;
    private float cena;
    private int ilosc;
    private int ocena;
    private int opakowania;

    public void setCena(float cena){this.cena = cena;}
    public void setOcena(int ocena){this.ocena = ocena;}
    public void setIlosc(int ilosc){this.ilosc = ilosc;}
    public void setOpakowania(int opakowania){this.opakowania = opakowania;}
    public void setGatunek(String gatunek){this.gatunek = gatunek;}

    public float getCena(){return cena;}
    public int getOcena(){return ocena;}
    public int getSztuk(){return ilosc;}
    public int getOpakowania(){return opakowania;}
    public String getGatunek(){return gatunek;}

}

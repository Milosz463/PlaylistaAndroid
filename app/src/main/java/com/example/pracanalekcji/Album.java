package com.example.pracanalekcji;

public class Album {
  private  String wykonawca;
  private  String tytul;
  private  int utwory;
  private  int rocznik;
  private int pobrania;

    public Album(String wykonawca, String tytul, int utwory, int rocznik, int pobrania) {
        this.wykonawca = wykonawca;
        this.tytul = tytul;
        this.utwory = utwory;
        this.rocznik = rocznik;
        this.pobrania = pobrania;
    }

    public void zwiekszPobrania(){
        pobrania++;
    }

    public String getWykonawca() {
        return wykonawca;
    }

    public String getTytul() {
        return tytul;
    }

    public int getUtwory() {
        return utwory;
    }

    public int getRocznik() {
        return rocznik;
    }

    public int getPobrania() {
        return pobrania;
    }
}

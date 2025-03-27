package cz.veletova.pojisteni.models;

public class Pojistenec {
    private int id;
    private String jmeno;
    private String prijmeni;
    private String email;
    private String telefon;
    private String ulice;
    private String mesto;
    private String psc;

    // Konstruktor s ID (například při načítání z databáze)
    public Pojistenec(int id, String jmeno, String prijmeni, String email, String telefon, String ulice, String mesto, String psc) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        this.telefon = telefon;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
    }

    // Konstruktor bez ID (při vytváření nového pojištěnce)
    public Pojistenec(String jmeno, String prijmeni, String email, String telefon, String ulice, String mesto, String psc) {
        this(0, jmeno, prijmeni, email, telefon, ulice, mesto, psc); // Nastaví ID na 0
    }

    // Gettery a settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }
}

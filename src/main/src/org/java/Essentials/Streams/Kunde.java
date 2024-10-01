package org.java.Essentials.Streams;

class Kunde {
    int idCount = 1;
    Integer id;
    Integer alter;
    String vorname;
    String nachname;

    public Kunde(Integer alter, String vorname, String nachname) {
        this.id = idCount++;
        this.alter = alter;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}

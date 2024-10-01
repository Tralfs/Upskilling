package org.java.Essentials.Streams;

public class Benutzer {
    // Private variables
    private String name;
    private int alter;

    // Constructor
    public Benutzer(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for alter
    public int getAlter() {
        return alter;
    }

    // Setter for alter
    public void setAlter(int alter) {
        this.alter = alter;
    }

    // Optional: Override toString() to provide a better string representation
    @Override
    public String toString() {
        return "Benutzer{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                '}';
    }
}
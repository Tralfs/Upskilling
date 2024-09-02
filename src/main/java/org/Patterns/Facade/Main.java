package org.Patterns.Facade;

public class Main {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
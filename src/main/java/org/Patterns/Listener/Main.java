package org.Patterns.Listener;

public class Main {
    public static void main(String[] args) {
        Button button = new Button(); // Create a button
        ButtonClickHandler handler = new ButtonClickHandler(); // Create a listener

        // Register the listener with the button
        button.setClickListener(handler);

        // Simulate clicking the button
        button.click();
    }
}
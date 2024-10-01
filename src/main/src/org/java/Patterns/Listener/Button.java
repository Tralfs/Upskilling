package org.java.Patterns.Listener;

public class Button {
    private ClickListener listener;

    // Method to set the listener
    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        System.out.println("Button clicked!");
        if (listener != null) {
            listener.onClick(); // Notify the listener
        }
    }
}
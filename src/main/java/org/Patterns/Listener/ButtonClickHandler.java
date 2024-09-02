package org.Patterns.Listener;

public class ButtonClickHandler implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("Button click event handled!");
    }
}
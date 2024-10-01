package org.java.Patterns.FactoryMethod;

public abstract class Logistics {
    protected abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
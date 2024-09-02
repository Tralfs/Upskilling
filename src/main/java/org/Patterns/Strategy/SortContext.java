package org.Patterns.Strategy;

public class SortContext {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortNumbers(int[] numbers) {
        strategy.sort(numbers);
    }
}
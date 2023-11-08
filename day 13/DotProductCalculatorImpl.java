// Concrete Flyweight
class DotProductCalculatorImpl implements DotProductCalculator {
    @Override
    public int calculateDotProduct(int a, int b) {
        return a * b;
    }
}
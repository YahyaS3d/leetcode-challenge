import java.util.HashMap;
import java.util.Map;


// Flyweight Factory
class DotProductCalculatorFactory {
    private Map<String, DotProductCalculator> flyweights;

    public DotProductCalculatorFactory() {
        this.flyweights = new HashMap<>();
    }

    public DotProductCalculator getDotProductCalculator() {
        String key = "default"; // You can use a more complex key if needed
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new DotProductCalculatorImpl());
        }
        return flyweights.get(key);
    }
}
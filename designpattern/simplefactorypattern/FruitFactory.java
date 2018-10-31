public class FruitFactory {
    public static Fruit getFruit(String criteria) {
        if (criteria.equals("Apple")) {
            return new Apple();
        } else if (criteria.equals("Grape")) {
            return new Grape();
        } else if (criteria.equals("Strawberry")) {
            return new Strawberry();
        }
        return null;  
    }
}
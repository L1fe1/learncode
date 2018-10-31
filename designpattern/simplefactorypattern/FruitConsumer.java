public class FruitConsumer {
    public static void main(String[] args) {
        Fruit fruit = null;
        
        fruit = FruitFactory.getFruit("Apple");
        fruit.harvest();
        
        fruit = FruitFactory.getFruit("Grape");
        fruit.harvest(); 
               
        fruit = FruitFactory.getFruit("Strawberry");
        fruit.harvest();
    }
}
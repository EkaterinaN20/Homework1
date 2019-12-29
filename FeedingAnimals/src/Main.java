public class Main {
    public static void main(String[] args) {
        Cat [] cat = new Cat[] {new Cat("Barsik"), new Cat("Murka"), new Cat("Beliy"), new Cat("Chubais"), new Cat("Putty")} ;
        Plate plate = new Plate(300);
        plate.addFood(100);
        for (int i=0; i<cat.length; i++)
        {
            cat[i].eat(plate);
        }
    }
}

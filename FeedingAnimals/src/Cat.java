public class Cat extends Animal {


    public Cat(String name) {
        super(name);
        setAppetite();
    }
    @Override
    public void setAppetite() {
        int rnd = 51+(int)(Math.random()*100);
        this.appetite = rnd;
    }
    @Override
    public void eat (Plate plate) {
        if (plate.decreaseFood(appetite)) {satiety= true;}
        System.out.printf("Кот %s голоден? %s \n", name, satiety);

    }
}
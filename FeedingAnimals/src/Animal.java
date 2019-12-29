abstract class Animal {

    public String name;
    public int appetite;
    public boolean satiety = false;

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public Animal(String name) {
        this.name = name;
    }

    public void animalInfo() {
        System.out.printf("%s %s", name, appetite);
    }

    abstract public void setAppetite();

    abstract public void eat(Plate plate);
}

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int appetite) {
        if (food <= appetite) {
            System.out.println("В тарелке не достаточно еды. Кот не может поесть.");
            return true;
        } else {
            food -= appetite;
            System.out.printf("В тарелке осталось %s грамм. ", food);
            return false;
        }
    }
    public void addFood(int addition)
    {food+=addition;}
}

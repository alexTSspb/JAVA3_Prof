import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Apple> apples1 = new ArrayList<Apple>();
        ArrayList<Orange> oranges1 = new ArrayList<Orange>();
        ArrayList<Apple> apples2 = new ArrayList<Apple>();
        //oranges1.add(new Apple()); - это не будет работать, все логично
        apples1.add(new Apple());
        apples1.add(new Apple());
        apples1.add(new Apple());
        apples2.add(new Apple());
        oranges1.add(new Orange());
        oranges1.add(new Orange());

        Box<Apple> box1 = new Box(apples1);
        Box<Apple> box3 = new Box(apples2);
      //Box<Apple> box2 = new Box(oranges1); - получается, что можем добавить в Arraylist, в котором уже есть
        // апельсины, только яблоки(по причине того что мы создаем rraylist<T> где T люой класс от Fruit
        Box<Orange> box2 = new Box(oranges1);
        System.out.println(box1.getWeight());
        box1.addFruits(new Apple());
        box1.addFruits(new Apple());
        box1.addFruits(new Apple());
        box2.addFruits(new Orange());
        box2.addFruits(new Orange());

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box1.compare(box2));
        box3.addFruits(new Apple());
        System.out.println("box1 before "+box1.getWeight());
        System.out.println("box3 before "+box3.getWeight());
        box1.moveTo(box3);
        System.out.println("box1 after "+box1.getWeight());
        System.out.println("box3 after "+box3.getWeight());

    }
}
    abstract class Fruit{
        float weight;

        float getWeight() {
            return weight;
        }
    }
    class Apple extends Fruit{
        {
            super.weight=1.0f;
        }
    }
    class Orange extends Fruit{
        {
            super.weight = 1.5f;
        }

    }
    class Box <T extends Fruit> {
        private ArrayList<T> arraysB;

        public Box(ArrayList<T> arraysB) {
            this.arraysB = arraysB;
        }

        public float getWeight() {
            float weight;
            if (arraysB.size() > 0)
                return weight = arraysB.size() * arraysB.get(0).weight;
            return 0.0f;
        }

        public void addFruits(T fruit) {
            arraysB.add(fruit);
        }

        public boolean compare(Box<?> another) {
            return this.getWeight() - another.getWeight() < 0.00001f;
        }
        //Пересыпать фрукты из 1 коробки в другую
        public void moveTo(Box<T> another)
        {
            for(T fruit: this.arraysB){
                another.addFruits(fruit);
            }
            this.arraysB.clear();
        }
    }


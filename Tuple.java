import java.util.ArrayList;
import java.util.Arrays;

public class Tuple <T>{
    private T[] arr;
    public Tuple(T[] arr){
        this.arr = arr;
    }
    public void swap(int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public  void printOut()
    {
        for(int i = 0;i < arr.length;i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println("");
    }
    public ArrayList<T> toArrayList()
    {
        ArrayList<T> arrayList = new ArrayList<T>();
        for(int i = 0; i < arr.length; i++)
        {
            arrayList.add(arr[i]);
        }

        return arrayList;
    }


}
class TupleDemo{
    public static void main(String[] args) {
        Tuple<Integer> intArr1 = new Tuple<Integer>(new Integer[]{1,2,3,4,5});
        Tuple<Character> charArr = new Tuple<Character>(new Character[]{'a','b','c','d'});
        intArr1.printOut();
        intArr1.swap(2,3);
        intArr1.printOut();
        charArr.swap(1,2);
        ArrayList<Integer> intArrList = new ArrayList<Integer>();
        intArrList = intArr1.toArrayList();
        System.out.println(intArrList);
        intArrList.remove(1);
        System.out.println(intArrList);

    }
}
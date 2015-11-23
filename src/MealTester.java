
import datastructures.AVLTree;
import datastructures.Stack;
import java.util.Iterator;

public class MealTester
{
    public static void main(String[] args)
    {
        Restaurant restaurant = new Restaurant("Yummy Tummy");
        MainFrame mainFrame = new MainFrame(restaurant);
    }
    
    public void AVLTreeTester()
    {
        AVLTree tree1 = new AVLTree<Integer>();
        tree1.insert(20);
        tree1.insert(15);
        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(7);
        tree1.insert(9);        
        tree1.remove(10);
        tree1.printLevelOrder();
        System.out.println();
        
        Iterator iter = tree1.iterator();
        
        while(iter.hasNext())
            System.out.println(iter.next());
    }
    
    public void HashMapTester()
    {
        HashMap<Integer, Integer> hashMapCustom = new HashMap<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                     + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                     + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
                     + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
                     + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
    }
}

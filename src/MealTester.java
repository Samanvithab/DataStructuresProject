
import datastructures.AVLTree;
import java.util.Iterator;

public class MealTester
{
    public static void main(String[] args)
    {
        Restaurant restaurant = new Restaurant("Yummy Tummy");
        MainFrame mainFrame = new MainFrame(restaurant);
        
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
}
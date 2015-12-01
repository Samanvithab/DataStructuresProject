
import datastructures.AVLTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simulator
{
    public static void main(String[] args)
    {
        Restaurant restaurant = new Restaurant("Steakhouse");
        restaurant.setMenu(generateMenu());
        MainFrame mainFrame = new MainFrame(restaurant);
    }
    
    /**
     * Generates menu from files.
     * @return menu with information from files
     */
    public static Menu generateMenu()
    {
        Menu menu = new Menu();
        
        // get list of files in directory
        File menuFolder = new File("src/menu");
        File[] fileList = menuFolder.listFiles();
        
        // loops through files to create categories
        for (File food : fileList)
        {
            try
            {
                Scanner in = new Scanner(food);
                in.useDelimiter(",|\n");
                        
                // loop through lines in file to add items to categories
                AVLTree itemList = new AVLTree();
                while (in.hasNextLine())
                {
                    String st = in.next();
                    double price = Double.parseDouble(in.next());
                    itemList.insert(new Item(st, price));
                }
                
                // add list of items to menu
                menu.addEntry(food.getName(), itemList);
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return menu;
    }
}

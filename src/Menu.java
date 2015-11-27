
import datastructures.AVLTree;
import datastructures.HashMap;

/**
 * A menu with categories and list of items.
 */
public class Menu extends HashMap<String, AVLTree>
{
    /**
     * Adds an entry to the menu.
     * @param category category of items
     * @param itemList list of items
     */
    public void addEntry(String category, AVLTree itemList)
    {
        put(category, itemList);  
    }
    
    /**
     * Removes a category and its items from the menu.
     * @param category category to remove
     */
    public void removeEntry(String category)
    {
        remove(category);
    }
}
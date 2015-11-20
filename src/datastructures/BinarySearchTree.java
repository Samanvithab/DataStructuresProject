package datastructures;

import java.util.Iterator;

/**
 * Implementation of a binary search tree.
 * Left subtree smaller than root. Right subtree larger than root.
 * Each node has two children.
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{
    protected BinaryNode<T> root;
    
    /**
     * Creates an empty binary search tree.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Empties the tree.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Checks if tree is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Checks if entry exists in tree.
     * @param entry entry to check
     * @return true if entry exists in true, false if not
     */
    public boolean contains(T entry)
    {
        return contains(entry, root);
    }

    /**
     * Finds the minimum entry in the tree.
     * @return the minimum entry 
     */
    public T findMin()
    {
        return findMin(root).data;
    }

    /**
     * Finds the maximum entry in the tree.
     * @return the maximum entry
     */
    public T findMax()
    {
        return findMax(root).data;
    }

    /**
     * Inserts an entry to the tree.
     * @param entry entry to insert
     */
    public void insert(T entry)
    {
        root = insert(entry, root);
    }

    /**
     * Removes an entry from the tree.
     * @param entry entry to remove
     */
    public void remove(T entry)
    {
        root = remove(entry, root);
    }

    /**
     * Prints the tree in order from the root.
     */
    public void printTree()
    {
        if (isEmpty())
            System.out.println("Empty tree.");
        else
            printTree(root);
    }

    /**
     * Prints the tree in level order from the root.
     */
    public void printLevelOrder()
    {
        if (isEmpty())
            System.out.println("Empty tree.");
        else
            printLevelOrder(root);
    }

    /**
     * Internal method to find an entry in a subtree.
     * @param entry the entry to search for
     * @param rNode the root of the subtree
     * @return true if the entry is found, otherwise false
     */
    private boolean contains(T entry, BinaryNode<T> rNode)
    {
        if (rNode == null)
            return false;

        int compareResult = entry.compareTo(rNode.data);

        if (compareResult < 0)
            return contains(entry, rNode.left);
        else if (compareResult > 0)
            return contains(entry, rNode.right);
        else // match found
            return true;
    }

    /**
     * Internal method to find the smallest entry in a subtree.
     * @param rNode the root of the subtree
     * @return the node containing the smallest entry
     */
    protected BinaryNode<T> findMin(BinaryNode<T> rNode)
    {
        if (rNode == null)
            return null;
        else if (rNode.left == null)
            return rNode;
        return findMin(rNode.left);
    }

    /**
     * Internal method to find the largest entry in a subtree.
     * @param rNode the root of the subtree
     * @return the node containing the largest entry
     */
    private BinaryNode<T> findMax(BinaryNode<T> rNode)
    {
        if (rNode != null)
        {
            while (rNode.right != null)
                rNode = rNode.right;
        }
        return rNode;
    }

    /**
     * Internal method to insert into a subtree.
     * @param entry the entry to insert
     * @param rNode the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> insert(T entry, BinaryNode<T> rNode)
    {
        if (rNode == null)
            return new BinaryNode<>(entry, null, null);

        int compareResult = entry.compareTo(rNode.data);

        if (compareResult < 0)
            rNode.left = insert(entry, rNode.left);
        else if (compareResult > 0)
            rNode.right = insert(entry, rNode.right);
        else; // duplicate, do nothing

        return rNode;
    }

    /**
     * Internal method to remove from a subtree.
     * @param entry the entry to remove
     * @param rNode the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> remove(T entry, BinaryNode<T> rNode)
    {
        if (rNode == null)
            return rNode;

        int compareResult = entry.compareTo(rNode.data);

        if (compareResult < 0)
            rNode.left = remove(entry, rNode.left);
        else if (compareResult > 0)
            rNode.right = remove(entry, rNode.right);
        else if (rNode != null && rNode.right != null)
        {
            rNode.data = findMin(rNode.right).data;
            rNode.right = remove(rNode.data, rNode.right);
        }
        else
            rNode = (rNode.left != null) ? rNode.left : rNode.right;
        return rNode;
    }

    /**
     * Internal method to print a subtree in order.
     * @param rNode the root of the subtree
     */
    private void printTree(BinaryNode<T> rNode)
    {
        if (rNode != null)
        {
            printTree(rNode.left);
            System.out.print(rNode.data + " ");
            printTree(rNode.right);
        }
    }

    /**
     * Internal method to print a subtree in level order.
     * @param rNode the root of the subtree
     */
    private void printLevelOrder(BinaryNode<T> rNode)
    {
        java.util.LinkedList<BinaryNode> level = new java.util.LinkedList<>();
        level.add(rNode);
        while(!level.isEmpty())
        {
            BinaryNode node = level.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                level.add(node.left);
            if (node.right != null)
                level.add(node.right);
        }
    }
    
    /**
     * Returns an iterator starting from the root.
     * @return iterator for tree
     */
    public Iterator<T> iterator()
    {
        return new BSTIterator(root);
    }

    /**
     * Implementation of binary node used in binary search tree.
     */
    protected static class BinaryNode<T>
    {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;
        int height = 0;
        
        /**
         * Creates a binary without children.
         * @param entry data in node
         */
        BinaryNode(T entry)
        {
            this(entry, null, null);
        }

        /**
         * Creates a binary node with a left and right child.
         * @param entry data in node
         * @param left left child
         * @param right right child
         */
        BinaryNode(T entry, BinaryNode<T> left, BinaryNode<T> right)
        {
            data = entry;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }
    
    /**
     * Iterator for binary search tree.
     */
    private class BSTIterator implements Iterator<T>
    {
        Stack<BinaryNode> stack;
                
        /**
         * Creates an iterator starting at root.
         * @param root root of tree
         */
        public BSTIterator(BinaryNode<T> root)
        {
            stack = new Stack<>();
            
            // push all left children to stack
            while (root != null) {
                    stack.push(root);
                    root = root.left;
            }
        }

        /**
         * Checks for next data in tree.
         * @return true if there is a next data, else false
         */
        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        /**
         * Returns the next data in the tree.
         * @return the next data
         */
        public T next()
        {
            BinaryNode<T> node = stack.pop();
            T result = node.data;
            if (node.right != null)
            {
                node = node.right;
                while (node != null)
                {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }
}

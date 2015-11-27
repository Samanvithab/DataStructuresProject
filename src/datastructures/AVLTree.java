package datastructures;

/**
 * Implementation of an AVL tree.
 * Height of left and right subtree differ at most by 1.
 * @author Katherine Soohoo
 */
public class AVLTree<T extends Comparable<? super T>>
        extends BinarySearchTree<T>
{
    private static final int ALLOWED_IMBALANCE = 1;
    
    /**
     * Creates an empty avl tree.
     */
    public AVLTree()
    {
        super();
    }

    @Override
    public void insert(T entry)
    {
        root = insert(entry, root);
    }

    @Override
    public void remove(T entry)
    {
        root = remove(entry, root);
    }

    /**
     * Returns the height of the node.
     * @param rNode the root of the subtree
     * @return height of rNode, if null then -1
     */
    private int height(BinaryNode<T> rNode)
    {
        return rNode == null ? -1 : rNode.height;
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
            return new BinaryNode<>(entry ,null, null);

        int compareResult = entry.compareTo(rNode.data);

        if (compareResult < 0)
            rNode.left = insert(entry, rNode.left);
        else if (compareResult > 0)
            rNode.right = insert(entry, rNode.right);
        else; // duplicate, do nothing

        return balance(rNode);
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

        return balance(rNode);
    }

    /**
     * Balances the tree after an insert and updates height.
     * @param rNode the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> balance(BinaryNode<T> rNode)
    {
        if (rNode == null)
            return rNode;

        if (height(rNode.left) - height(rNode.right) > ALLOWED_IMBALANCE)
        {
            if (height(rNode.left.left) >= height(rNode.left.right))
                rNode = rotateWithLeftChild(rNode);
            else
                rNode = doubleWithLeftChild(rNode);
        }
        else if(height(rNode.right) - height(rNode.left) > ALLOWED_IMBALANCE)
        {
            if(height(rNode.right.right) >= height(rNode.right.left))
                rNode = rotateWithRightChild(rNode);
            else
                rNode = doubleWithRightChild(rNode);
        }
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;
        return rNode;
    }

    /**
     * Rotate binary tree node with left child.
     * Update heights, then return new root.
     * @param k2 the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> rotateWithLeftChild(BinaryNode<T> k2)
    {
        BinaryNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * Update heights, then return new root.
     * @param k1 the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> rotateWithRightChild(BinaryNode<T> k1)
    {
        BinaryNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child, then node k3 with new left child.
     * Update heights, then return new root.
     * @param k3 the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> doubleWithLeftChild(BinaryNode<T> k3)
    {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child, then node k1 with new left child.
     * Update heights, then return new root.
     * @param k1 the root of the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> doubleWithRightChild(BinaryNode<T> k1)
    {
        k1.right= rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
}
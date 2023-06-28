import java.util.*;

class balancedtreeReturn{
    int height;
    boolean isBalanced;
}
class binaryTreeNode<T>{
    public T data;
    public binaryTreeNode<T> left;
    public binaryTreeNode<T> right;

    public binaryTreeNode(T data){
        this.data= data;
    }
}

public class IntroBST {
    public static void printTreeDetailed(binaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+":");
        if(root.left != null){
            System.out.print("L"+root.left.data+", ");
            }
        if(root.right != null){
            System.out.print("R"+root.right.data);
            }
            System.out.println();
        printTree(root.left);
        printTree(root.right);
        
    }
    public static void printTree(binaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        // TODO take care of base case
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
        // if(root.left != null){
        // printTree(root.left);
        // }
        // if(root.right != null){
        // printTree(root.right);
        // }
    }
   public static binaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
    binaryTreeNode<Integer> root = buildTreeFromPreIn(pre, in, 0, pre.length-1, 0, in.length-1);
    return root;
   }
    public static boolean serachBST(binaryTreeNode<Integer> root){
    if(root == null){
        return false;
        }
    if(root.data == da){}
    }
    public static void main(String[] args) {
        int in[] = {1,2,3,4,5,6,7};
        int pre[] = {4,2,1,3,6,5,7};
        binaryTreeNode<Integer> root = 
            
        }
    }


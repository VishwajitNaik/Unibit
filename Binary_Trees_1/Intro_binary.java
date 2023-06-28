import java.lang.annotation.Retention;
import java.util.*;

import javax.sound.sampled.ReverbType;

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

public class Intro_binary<T> {

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


public static binaryTreeNode<Integer> takeTreeIP(){
System.out.println("Enter root data");
Scanner sc = new Scanner(System.in);
int rootData = sc.nextInt();

if(rootData == -1){
    return null;
}

binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
binaryTreeNode<Integer> leftChild = takeTreeIP();
binaryTreeNode<Integer> rightChild = takeTreeIP();
root.left = leftChild;
root.right = rightChild;
return root; 
}

public static binaryTreeNode<Integer> takeTreeIPBetter(boolean isRoot, int parentData, boolean isLeft){
    if(isRoot){
        System.out.println("Enter root data");
    }else{
        if(isLeft){
            System.out.println("Enter left child of" + parentData);
        }else{
            System.out.println("Enter right child of" + parentData);
        }
    }
    
    Scanner sc = new Scanner(System.in);
    int rootData = sc.nextInt();
    
    if(rootData == -1){
        return null;
    }
    
    binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
    binaryTreeNode<Integer> leftChild = takeTreeIPBetter(false, rootData, true);
    binaryTreeNode<Integer> rightChild = takeTreeIPBetter(false, rootData, false);
    root.left = leftChild;
    root.right = rightChild;
    return root; 
    }


    public static int numnodes(binaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int ct = 0;
        int leftNodeCt = numnodes(root.left);
        int rightNodect = numnodes(root.right);
        ct =  1 + leftNodeCt + rightNodect;
        return ct;
    }
    public static int largest(binaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int largestLeft= largest(root.left);
        int largestRight= largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }
    public static int numLeaves(binaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        if(root.left==null &&root.right==null){
            return 1;
        }
        return numLeaves(root.left)+numLeaves(root.right);
}

public static void printAtDepthK(binaryTreeNode<Integer> root, int k){
    if(root == null){
        return;
    }

    if(k == 0){
        System.out.println(root.data);
        return;
    }
    printAtDepthK(root.left, k-1);
    printAtDepthK(root.right, k-1);

}

public static binaryTreeNode<Integer> removeLeves(binaryTreeNode<Integer> root){
if(root == null){
    return null;
}
if(root.left == null && root.right == null){
    return null;
}
root.left = removeLeves(root.left);
root.right = removeLeves(root.right);
return root;
}

public static int height(binaryTreeNode<Integer> root){
    if(root == null){
        return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return 1 + Math.max(leftHeight, rightHeight);
}

public static boolean isBalanced(binaryTreeNode<Integer> root){
if(root == null){
    return true;
}
int leftHeight = height(root.left);
int rightHeight = height(root.right);
if(Math.abs(leftHeight - rightHeight) > 1){
    return false;
}

boolean isLeftBalanced = isBalanced(root.left);
boolean isRightBalanced = isBalanced(root.right);
return isLeftBalanced && isRightBalanced;
}

public static balancedtreeReturn isBalancedBetter(binaryTreeNode<Integer> root){
if(root == null){
    int height = 0;
    boolean isBal = true;
    balancedtreeReturn ans = new balancedtreeReturn();
    ans.height = height;
    ans.isBalanced = isBal;
    return ans;
}

balancedtreeReturn leftOutput = isBalancedBetter(root.left);
balancedtreeReturn rightOutput = isBalancedBetter(root.right);
boolean isBal = true;
int height = 1 + Math.max(leftOutput.height, rightOutput.height);

if(Math.abs(leftOutput.height - rightOutput.height)>1){
    isBal = false;
}
if(!leftOutput.isBalanced || !rightOutput.isBalanced){
    isBal = false;
}

balancedtreeReturn ans = new balancedtreeReturn();
ans.height = height;
ans.isBalanced = isBal;
return ans;

}


public static binaryTreeNode<Integer> taInpuLevelwise(){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter root data");
    int rootData = s.nextInt();
    if (rootData == -1) {
        return null;
    }
    binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
    Queue<binaryTreeNode<Integer>> pendingChildren = new LinkedList<binaryTreeNode<Integer>>();
    pendingChildren.add(root);

    while (!pendingChildren.isEmpty()) {
        binaryTreeNode<Integer> front = pendingChildren.poll();
        //Left child
        System.out.println("Enter left child of " + front.data);
        int left = s.nextInt();
        if(left != -1){
            binaryTreeNode<Integer> leftchild = new binaryTreeNode<Integer>(left);
            front.left = leftchild;
            pendingChildren.add(leftchild);
        }
        // Right Child
        System.out.println("Enter right child of " + front.data);
        int right = s.nextInt();
        if(right != -1){
            binaryTreeNode<Integer> rightchild = new binaryTreeNode<Integer>(right);
            front.right = rightchild;
            pendingChildren.add(rightchild);
        }
    }
    return root;
}

public static binaryTreeNode<Integer> buildFromPreInHelper(int pre[], int in[], int sipre, int eipre, int siIn, int eiIn){
    if(sipre > eipre){
        return null;
    }
    int rootData = pre[sipre];
    binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);

    int rootIndex = -1;
    for (int i = 0; i <= eiIn; i++) {
        if(in[i] == rootData){
            rootIndex = i;
            break;
        }
    }

    // I am assuming that root actually is present in inorder
    int sipreLeft = sipre + 1;
    int siInLeft = siIn;
    int eiInLeft = rootIndex - 1;
    int siInRght = rootIndex + 1;
    int eipreRght = eipre;
    int eiInRght = eiIn;

    int leftSubtreeLength = eiInLeft - siInLeft + 1;

    int eipreLeft = sipreLeft + leftSubtreeLength -1;
    int sipreRght = eipreLeft + 1;

    binaryTreeNode<Integer> left = buildFromPreInHelper(pre, in, sipreLeft, eipreLeft, siInLeft, eiInLeft);
    binaryTreeNode<Integer> Right = buildFromPreInHelper(pre, in, sipreRght, eipreRght, siInRght, eiInRght);
    root.left = left;
    root.right = Right;
    return root;    

}

public static binaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
    binaryTreeNode<Integer> root = buildFromPreInHelper(pre, in, 0, pre.length-1, 0, in.length-1);
    return root;
   }
//     public static boolean serachBST(binaryTreeNode<Integer> root){
    // if(root==null){
    //     return;
    // }
    // if(root.data<k1){
    //     printBetweenK1K2(root.right, k1, k2);
    // }else if(root.data>k2){
    //     printBetweenK1K2(root.left, k1, k2);
    // }else{
    //     System.out.println(root.data);
    //     printBetweenK1K2(root.left,k1,k2);
    //     printBetweenK1K2(root.right, k1,k2);
    // }


public static int minimum(binaryTreeNode<Integer> root){
    if(root == null){
        return Integer.MAX_VALUE;
    }
    int leftMin = minimum(root.left);
    int rightMin = minimum(root.right);
    return Math.min(root.data, Math.min(leftMin, rightMin)); 
}
public static boolean isBST(binaryTreeNode<Integer> root){
    if(root==null){
        return true;
    }
    int leftMax= largest(root.left);
    if(leftMax>=root.data){
        return false;
    }
    int rightMinx= minimum(root.right);
    if(rightMinx<root.data){
        return false;
    }
    boolean isLeftBST= isBST(root.left);
    boolean isRightBST= isBST(root.right);
    return isLeftBST && isRightBST;

}


public static ArrayList<Integer> nodeToRootPath(binaryTreeNode<Integer> root, int x){
if(root == null){
    return null;
}
if(root.data == x){
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.add(root.data);
    return output;
}

ArrayList<Integer> leftOutput = nodeToRootPath(root.right, x);
if(leftOutput != null){
    leftOutput.add(root.data);
    return leftOutput;
}

ArrayList<Integer> RightOutput = nodeToRootPath(root.right, x);
if(RightOutput != null){
    RightOutput.add(root.data);
    return RightOutput;
}
return null;

}


public static void main(String[] args) {
    // binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(1);

    // binaryTreeNode<Integer> rootLeft = new binaryTreeNode<Integer>(2);
    // binaryTreeNode<Integer> rootRight = new binaryTreeNode<Integer>(3);
    // root.left = rootLeft;
    // root.right= rootRight;


    // binaryTreeNode<Integer> twoRight = new binaryTreeNode<Integer>(4);
    // binaryTreeNode<Integer> threeLeft = new binaryTreeNode<Integer>(5);

    // rootLeft.right= twoRight;
    // rootRight.left= threeLeft;
    // binaryTreeNode<Integer> root = takeTreeIPBetter(true, 0, true);
    // binaryTreeNode<Integer> root = taInpuLevelwise();
    // printTreeDetailed(root);
    // System.out.println("Num nodes" + numnodes(root));
    // System.out.println("Largest " + largest(root));
    // System.out.println("num leaves "+ numLeaves(root));
    // System.out.println("print at depth K");
    // printAtDepthK(root, 2);

    // binaryTreeNode<Integer> newRoot = removeLeves(root);
    // printTreeDetailed(newRoot);
    // System.out.println("is balanced " + isBalanced(root));
    // System.out.println("is Balanced "+ isBalancedBetter(root).isBalanced);

int in[] = {1,2,3,4,5,6,7};
int pre[] = {4,2,1,3,6,5,7};
binaryTreeNode<Integer> root = buildTreeFromPreIn(pre, in);
printTreeDetailed(root);


root = takeTreeIPBetter(true, 0, true);
ArrayList<Integer> path = nodeToRootPath(root, 1);
if(path == null){
    System.out.println("Not found");
}else{
    for (int i: path) {
        System.out.println(i);        
    }
}


     
    
}
    
}

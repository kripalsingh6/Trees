import java.util.*;
public class binarytrees {
    static class Node {
      int data;
      Node left;
      Node right;

      Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
      }
        
    }
    static class binaryclass{
        static int idx=-1;
        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node((nodes[idx]));
            newNode.left= buildtree(nodes);
            newNode.right= buildtree(nodes);
            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int ls= height(root.left);
        int rs= height(root.right);
        return Math.max(ls,rs)+1;


    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftcount= count(root.left);
        int rightcount=count(root.right);
        return leftcount+ rightcount+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftsum= sum(root.left);
        int rightsum= sum(root.right);
        return rightsum+leftsum+root.data;
        
    }
    public static int Diamm(Node root){
        if (root==null) {
            return 0;
        }

        int leftDiam= Diamm(root.left);
        int leftheig= height(root.left);
        int rightDiam= Diamm(root.right);
        int rightheig= height(root.right);

        int selfdiam= leftheig+ rightheig+1;
        return Math.max(Math.max(rightDiam, leftDiam), selfdiam);
    }
    public static void main(String[] args){
       int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        binaryclass tree= new binaryclass();
        Node root = tree.buildtree(nodes);
         System.out.println(Diamm(root));
    }
}

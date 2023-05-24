import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //create scanner for use
        Scanner k = new Scanner(System.in);
        //store the list here for level order
        ArrayList<BinaryTree<String>> list = new ArrayList<>();
        //get user input
        System.out.println("Enter name or done: ");
        String line = k.nextLine();
        //when the user is says done print each order
        extracted(k, list, line);
        //get all the users inputs and generate a binary tree
        BinaryTree<String> tree = makeTree(list, 0);

        System.out.println();

        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(tree));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(tree));

        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(tree);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(tree);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(tree);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(tree);
        System.out.println();
        System.out.println();

        System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(tree) ? "Yes!" : "No.");

        System.out.println();
    }

    private static void extracted(Scanner k, ArrayList<BinaryTree<String>> list, String line) {
        while(!line.equals("done")){
            BinaryTree<String> tree = new BinaryTree<>();
            //make the users input a new root
            tree.makeRoot(line);
            //add it to the binary tree
            list.add(tree);
            System.out.println("Enter name or done: ");
            //get the users next input
            line = k.nextLine();
        }
    }

    public static BinaryTree<String> makeTree(ArrayList<BinaryTree<String>> q, int nodes){

        //set root to null since it is assumed nothing is inside
        BinaryTree<String> root;
        root = null;

        //if the nodes that are made is less than the user input then keep going
        root = getStringBinaryTree(q, nodes, root);

        return root;
    }

    private static BinaryTree<String> getStringBinaryTree(ArrayList<BinaryTree<String>> q, int nodes, BinaryTree<String> root) {
        if(nodes + 1 < q.size() + 1){

            //get the number of user nodes
            root = q.get(nodes);

            //attach the users right nodes last this is the definition of level order i.e zig zag method
            root.attachRight(makeTree(q, nodes +2));

            //attach the users left nodes first since this is the definition of level order i.e zig zag method
            root.attachLeft(makeTree(q, nodes +1));

        }
        return root;
    }
}

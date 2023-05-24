//This class contains the methods for the BinaryTree class.
//For the lab Exercise 1, you need to complete the TO-DO methods


public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree() {
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data) {
		if (!isEmpty()) {
			System.out.println("Can't make root. Already exists");
		} else
			this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree) {
		left = tree;
	}

	public void setRight(BinaryTree<T> tree) {
		right = tree;
	}

	public void setParent(BinaryTree<T> tree) {
		parent = tree;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void attachLeft(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (left != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (right != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft != null)
			retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight != null)
			retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear() {
		left = right = parent = null;
		data = null;
	}

	public BinaryTree<T> root() {
		if (parent == null)
			return this;
		else {
			BinaryTree<T> next = parent;
			while (next.getParent() != null)
				next = next.getParent();
			return next;
		}
	}

	// this method returns the number of nodes/trees in a BinaryTree
	public static <T> int nodes(BinaryTree<T> t) {
		//base condition
		if(t == null){
			return 0;
		}
		//glue condition
		return 1 + nodes(t.left) + nodes(t.right);

	}

	// this method returns the height of a BinaryTree
	// (the number of edges separating a root node/tree from its most distant,
	// descendant leaf)
	public static <T> int height(BinaryTree<T> t) {
		//base case
		if(t == null){
			return -1;
		}
		//getting the left nodes
		int leftH = height(t.left);
		//getting the right nodes
		int rightH = height(t.right);
			//these go until you reach the bottom
			if (leftH > rightH) {
				return leftH + 1;
			}
			//go until you reach the bottom
			else {
				return rightH +1;
			}

	}

	// this method tests whether a tree is height balanced
	public static <T> boolean heightBalanced(BinaryTree<T> t) {
		int right = height(t.getRight());
		int left = height(t.getLeft());
		//for it to be balanced it can be equal to the left side and right side
		if(left == right){
			return true;
		}
		//true if and only if the left is 1 node deeper
		if(left + 1 == right){
			return true;
		}
		//true if and only if the right is 1 node deeper
		//else it does not meet our criteria
		else
		return right + 1 == left;
	}
	//Transverses through the tree and when a node is added to the root you subtract one to make a new root since a node was added
	public static <T> void currLevel(BinaryTree<T> t, int x) {
		//base case
		if (t == null) {
			return;
		}
		//When the root is found
		if (x == 1) {
			System.out.print(t.getData() + "\t");
		}
		//glue condition
		else {
			if (x > 1) {
				//get the left side of the tree
				currLevel(t.right, x - 1);
				//get the right side of the tree
				currLevel(t.right, x - 1);
			}
		}

	}

	public static <T> void preorder(BinaryTree<T> t) {
		if (t != null) {
			System.out.print(t.getData() + "\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t) {
		if (t != null) {
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t) {
		if (t != null) {
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}


	public static <T> void levelOrder() {
		levelOrder();
	}

	public static <T> void levelOrder(BinaryTree<T> t) {
		//count starts at zero since root is 0
		int count = 0;
		//get the height of the tree
		int treeHeight = height(t.root());

		//continue while the height of the tree in greater than or equal to the count
		while (count <= treeHeight){
			count++;
			currLevel(t.root(), count);

		}

	}

}

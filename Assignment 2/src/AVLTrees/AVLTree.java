package AVLTrees;

public class AVLTree {
	Node root;
	
	public AVLTree() {root = null;} 					//constructor
	
	private int max (int leftSide, int rightSide) {return (leftSide > rightSide) ? leftSide : rightSide;}
	
	void updateHeight(Node n) {n.height = 1 + max(height(n.left), height(n.right));}

	int height (Node n) {
		if (n == null)
			return 0;
		return n.height;		
	}
	
	Node rotateToRight(Node k2){
		Node k1 = k2.left;
		k2.left = k1.right;	
		k1.right = k2;
																																																																																																																											k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}
	
	Node rotateToLeft(Node k1){
		Node k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.right), height(k1.left))+ 1;
		k2.height = max(height(k2.right), height(k2.left))+ 1;
		return k2;
	}
	
	Node doubleRotatewithLeft(Node k3) {
		Node t1 = k3.left;
		k3.left = rotateToLeft(t1);
		return rotateToRight(k3);
	}
	
	Node doubleRotatewithRight(Node k3) {
		Node t1 = k3.right;
		k3.right = rotateToRight(t1);
		return rotateToLeft(k3);
	}
	
	Node insert(Node t, int x){
		if (t == null) 
			return (new Node(x));
		
		if (x < t.value) {
			t.left = insert(t.left, x);

			if (height(t.left) - height(t.right) == 2) 		//left side violation
			{
				if (x < t.left.value)
					t = rotateToRight(t);
				else if (x > t.left.value)
					t = doubleRotatewithLeft(t);
			}
		}
		else if (x > t.value) {
			t.right = insert(t.right, x);

			if (height(t.right) - height(t.left) == 2)		//right side violation
			{
				if (x > t.right.value)
					t = rotateToLeft(t);
				else if (x < t.right.value) {
					t = doubleRotatewithRight(t);
				}
			}
		}
		updateHeight(t);
		return t;
	}
	
	Node findMin(Node t)
	{
		Node current = t;
		if (current == null)
			return null;
		if (current.left == null)
			return t;
		return findMin(current.left);
	}
	
	Node remove(Node t, int x) {
		if (t == null)
			return t;
		if ( x < t.value)
		{
			t.left = remove(t.left, x);
			if (height(t.right) - height(t.left) == 2)
			{
				if (height(t.right.right) >= height(t.right.left))
					t = rotateToLeft(t);
				else if (height(t.right.right) < height(t.right.left))
					t = doubleRotatewithRight(t);
			}
		}
		else if (x > t.value)
		{
			t.right = remove(t.right,x);
			if (height(t.left) - height(t.right) == 2)
			{
				if (height(t.left.left) <= height(t.left.right))
					t = rotateToRight(t);
				else if (height(t.left.left) > height(t.left.right))
					t = doubleRotatewithLeft(t);
			}
		}
		else if (t.left != null && t.right != null)
		{
			t.value = findMin (t.right).value;
			t.right = remove(t.right, t.value);
		}
		else 
		{
			if(t.left != null)
				return t.left;
			else 
				return t.right;
		}	
	
		updateHeight(t);
		return t;
	}
}

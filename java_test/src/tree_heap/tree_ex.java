package tree_heap;

// 17. 10.15 일요일 
// 트리를 이용한 순회 기존 스택을 이용한 것에 비하면 아주 쉽게 구현 가능 


public class tree_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedTree T = new LinkedTree();
		
		TreeNode n1 = T.makeBT(null, 'A', null);
		TreeNode n2 = T.makeBT(null, 'B', null);
		TreeNode n3 = T.makeBT(null, 'C', null);
		TreeNode n4 = T.makeBT(null, 'D', null);
		TreeNode n5 = T.makeBT(n1, '*', n2);
		TreeNode n6 = T.makeBT(n3, '/', n4);
		TreeNode n7 = T.makeBT(n5, '-', n6);
		
		System.out.printf("\n PreOrder : ");
		T.preorder(n7);
		
		System.out.printf("\n InOrder :");
		T.inorder(n7);
		
		System.out.printf("\n PostOrder :");
		T.postorder(n7);

	}

}

class TreeNode {
	Object data;
	TreeNode left;
	TreeNode right;
}
class LinkedTree{
	private TreeNode root;
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left=bt1;
		root.right=bt2;
		return root;
	}
	public void preorder(TreeNode root) {
		if(root!=null) {
			System.out.printf("%c",root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) {
		if(root !=null) {
			inorder(root.left);
			System.out.printf("%c",root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%c",root.data);
		}
	}
}

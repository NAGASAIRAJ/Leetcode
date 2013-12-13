
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if( preorder == null || inorder == null )
			return null;
		int PreLen = preorder.length;
		int InLen = inorder.length;
		if( PreLen == 0 || InLen == 0 )
			return null;
		return ConstructBT(0, PreLen - 1, preorder, 0, InLen - 1, inorder);
    }
	private TreeNode ConstructBT(int PreStart, int PreEnd, int[] PreOrder,
								int InStart, int InEnd, int[] InOrder) {
		int RootValue = PreOrder[PreStart];
		TreeNode root = new TreeNode(RootValue);
		root.left = null;
		root.right = null;
		if( PreStart == PreEnd && PreOrder[PreStart] == InOrder[InStart] )
			return root;
		int i;
		for( i = InStart; i <= InEnd; i++ ) {
			if( RootValue == InOrder[i] )
				break;
		}
		int LeftLen = i - InStart;
		if( LeftLen > 0 )
			root.left = ConstructBT(PreStart + 1, PreStart + LeftLen, PreOrder, 
					                InStart, i - 1, InOrder );
		if( InEnd > i )
			root.right = ConstructBT(PreStart + LeftLen + 1, PreEnd, PreOrder, 
									i + 1, InEnd, InOrder);
		return root;		
	}
}

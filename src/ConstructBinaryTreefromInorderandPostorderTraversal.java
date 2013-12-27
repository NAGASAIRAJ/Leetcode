
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if( inorder == null || postorder == null )
    		return null;
    	int InLen = inorder.length, PostLen = postorder.length;
    	if( InLen == 0 || PostLen == 0 )
    		return null;
    	return ConstructBT(0, InLen - 1, inorder, 0, PostLen - 1, postorder);    			
    }
    private TreeNode ConstructBT(int InStart, int InEnd, int[] InOrder, 
    							int PostStart, int PostEnd, int[] PostOrder) {
    	int RootValue = PostOrder[PostEnd];
    	TreeNode root = new TreeNode(RootValue);
    	root.left = null;
    	root.right = null;
    	if( PostStart == PostEnd && PostOrder[PostStart] == InOrder[InStart] )
    		return root;
    	int i;
    	for( i = InStart; i <= InEnd; i++ ) {
    		if( InOrder[i] == RootValue )
    			break;
    	}
    	int LeftLen = i - InStart;
    	if( LeftLen > 0 ) 
    		root.left = ConstructBT(InStart, i - 1, InOrder, 
    				               PostStart, PostStart + LeftLen - 1, PostOrder);
    	if( InEnd > i ) 
    		root.right = ConstructBT(i + 1, InEnd, InOrder, 
    								PostStart + LeftLen, PostEnd - 1, PostOrder);
    	return root;    	
    }
}

import java.util.Map;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, map, postorder.length - 1, 0 , inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, Map<Integer, Integer> map, int Pindex, int ileft, int iright ) {
        int val = postorder[Pindex];
        int imid = map.get(val);

        TreeNode root = new TreeNode(val);

        if (ileft < imid) {
            root.left = helper(postorder, map, Pindex - (iright - imid) - 1, ileft, imid - 1);
        }
        if (imid < iright) {
            root.right = helper(postorder, map, Pindex - 1, imid + 1, iright);
        }
        return root;
    }
}
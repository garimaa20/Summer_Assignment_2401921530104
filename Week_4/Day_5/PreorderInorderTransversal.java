import java.util.*;

class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right)
            return null;

        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);

        root.left = build(preorder, left, map.get(value) - 1);
        root.right = build(preorder, map.get(value) + 1, right);

        return root;
    }
}



/* leetcode 114. 把二叉树 in-place 地先序展开成 一颗只有右节点的二叉树, 并且节点顺序为先序遍历的排序
    这个题解 需要吃透二叉树的先序遍历 :
       1. 对于递归到的当前节点 curnode 来说, 先序顺序中 curnode.left 的 lastnode 就是 curnode.left 的最后一个右子叶节点 (若 curnode.left.right == null: curnode.left 就是 lastnode);
       2. 把 curnode.left.lastnode -> curnode.right （保证右子树节点排在所有左子树所有节点的顺序之后）
       3. 将 curnode.right 指向变动后的左子树 curnode.right -> curnode.leftnode
       4. 再把 curnode.left -> null 即可
**/
public class FlattenBinaryTree{

    public void flatten(Treenode root){

    }

}

public class Treenode{
    int val;
    Treenode leftTree;
    Treenode rightTree;
    Treenode () {}
    Treenode (int val) { this.val = val; }
    Treenode (int val,Treenode leftTree = lt,Treenode rightTree) {
        this.val = val;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }
}


public class Solution {
    public void flatten(TreeNode root) {
        // preOrderTraversal
        if (root == null){return ;}  // 空 return 结束方法  不再执行下一条语句
        // flatten and order nodes & put them in rightSubTrees
        if (root.left != null){
            // find lastnode of curNode.left
            TreeNode lastnode = root.left;   // init lastnode
            while (lastnode.right != null) { lastnode = lastnode.right; }
            // move curNode.right to lastnode.right
            lastnode.right = root.right;
            // move changed curNode.left to curNode.right
            root.right = root.left;
            // return curNode.left to Null
            root.left = null;
        }
        // preOrder recursion
        flatten(root.left);
        flatten(root.right);
    }
}
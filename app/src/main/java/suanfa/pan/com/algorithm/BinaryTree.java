package suanfa.pan.com.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Lenovo on 2018/11/8.
 */

public class BinaryTree {
    private static TreeNode root;

    public BinaryTree() {
        root = new TreeNode(1, "A");
    }


    public class TreeNode<T> {
        private int index;
        private T data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getIndex() {
            return index;
        }

        public T getData() {
            return data;
        }
    }

    /**
     * 构建二叉树
     * A
     * B                C
     * D             E                 F
     */
    public void createBinary() {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    /**
     * 通过前序遍历反向生成二叉树
     * <p>
     * A
     * B          C
     * D      E           F
     * <p>
     * 前序ABDECF
     * <p>
     * ABD##E##C#F##
     */
    int i = 0;

    public TreeNode createBinaryTreePre(ArrayList<String> data) {
        if (i >= data.size()) return null;
        TreeNode treeNode;
        if ("#".equals(data.get(i))) {
            i++;
            treeNode = null;
            return treeNode;

        } else {
            treeNode = new TreeNode(i, data.get(i));
        }
        if (i == 0) {
            root = treeNode;
        }
        i++;
        treeNode.leftChild = createBinaryTreePre(data);
        treeNode.rightChild = createBinaryTreePre(data);
        return treeNode;
    }

    /**
     * 通过中序遍历反向生成二叉树
     * <p>
     * A
     * B          C
     * D      E    #        F
     * ##   #  #         #    #
     * 前序ABDECF
     * <p>
     * #D#B#E#A#C#F#
     */

    public TreeNode createBinaryTreeMid(ArrayList<String> data) {

        if (i >= data.size()) return null;
        TreeNode treeNode;
        if ("#".equals(data.get(i))) {
            i++;
            treeNode = null;
            return treeNode;

        } else {
            treeNode = new TreeNode(i, data.get(i));
        }
        if (i == 0) {
            root = treeNode;
        }
        i++;
        treeNode.leftChild = createBinaryTreeMid(data);
        treeNode.rightChild = createBinaryTreeMid(data);
        return treeNode;

    }

    /**
     * 构建二叉树
     * A
     * B                C
     * D         E                 F
     */
    public void createBinary(String[] nodes) {
        for (int i = 0; i < nodes.length; i++) {

        }
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    /**
     * 获取二叉树的高度
     *
     * @param node
     * @return
     */
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return i > j ? i + 1 : j + 1;
        }
    }

    /**
     * 获取二叉树的接点数
     *
     * @param root
     * @return
     */
    public int getNodeSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int i = getNodeSize(root.leftChild);
            int j = getNodeSize(root.rightChild);
            return i + j + 1;
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.getData());
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    /**
     * 前序遍历 --非迭代
     *
     * @param root
     */
    public void noPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.print(n.getData());
            if (n.rightChild != null)
                stack.push(n.rightChild);
            if (n.leftChild != null)
                stack.push(n.leftChild);
        }

    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            midOrder(root.leftChild);
            System.out.print(root.getData());
            midOrder(root.rightChild);
        }
    }

    /**
     * 中序遍历 --- 非迭代
     *
     * @param root
     */
    public void noMidOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.data);
                root = node.rightChild;
            }

        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.getData());
        }
    }

    /**
     * 后序遍历 --- 非迭代
     *
     * @param root
     */
    public void noPostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                root = stack.peek().rightChild;
                if (lastNode== root || root == null) {
                    TreeNode treeNode = stack.pop();
                    System.out.print(treeNode.data);
                    lastNode = treeNode;
                } else {
                    stack.push(stack.peek().rightChild);
                }


            }

        }
    }

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] arg0) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinary();
        System.out.println("treeHeight : " + binaryTree.getHeight(root));
        System.out.println("treeSize : " + binaryTree.getNodeSize(root));
        System.out.println();
        System.out.print("preOrder : ");
        binaryTree.preOrder(root);
        System.out.println();
        System.out.print("noPreOrder : ");
        binaryTree.noPreOrder(root);
        System.out.println();
        System.out.print("midOrder : ");
        binaryTree.midOrder(root);
        System.out.println();
        System.out.print("noMidOrder : ");
        binaryTree.noMidOrder(root);
        System.out.println();
        System.out.print("postOrder : ");
        binaryTree.postOrder(root);
        System.out.println();
        System.out.print("NoPostOrder : ");
        binaryTree.noPostOrder(root);
        String[] str = {"A", "B", "D", "#", "#", "E", "#", "#", "C", "#", "F", "#", "#"};
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }

        System.out.println();
        System.out.print("preOrder : ");
        binaryTree.preOrder(binaryTree.createBinaryTreePre(list));
    }
}

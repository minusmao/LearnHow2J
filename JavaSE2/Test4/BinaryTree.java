/**
 * 文件名：BinaryTree.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 泛型
 * 时间：2021-4-14
 */

import java.lang.Comparable;
import java.util.ArrayList;

/**
 * 类名：BinaryTree
 * 功能：实现二叉树，具有排序功能
 */
public class BinaryTree<T extends Comparable<T>> {
    /* 对象属性 */
    private Node<T> rootNode;    // 根节点
    private int size;            // 节点个数

    /* 对象方法 */
    // 添加数据 value 对象，该对象必须实现 Comparable 接口
    public boolean add(T value) {
        // 1.定义一个节点
        Node<T> node = new Node<>();
        // 2.将数据 value 封装到节点 node 中
        node.setValue(value);
        // 3.判断根节点是否为空
        if(this.rootNode == null) {
            this.rootNode = node;    // 如果根节点为空，直接赋值
            this.size++;
            return true;
        }
        // 4.将节点 node 与二叉数上的节点比较
        Node<T> nodeOnTree = rootNode;    // 定义一个临时节点，先指向根节点
        while(true) {
            // 比较节点
            if(nodeOnTree.compareTo(node) > 0) {
                // 如果大于 0，则看左节点
                if(nodeOnTree.getLeftNode() == null) {
                    nodeOnTree.setLeftNode(node);
                    this.size++;
                    return true;
                } else {
                    nodeOnTree = nodeOnTree.getLeftNode();
                }
            } else if(nodeOnTree.compareTo(node) == 0) {
                // 如果等于 0
                return false;    // 两个节点相同，添加失败
            } else {
                // 如果小于 0，则看右节点
                if(nodeOnTree.getRightNode() == null) {
                    nodeOnTree.setRightNode(node);
                    this.size++;
                    return true;
                } else {
                    nodeOnTree = nodeOnTree.getRightNode();
                }
            }
        }
    }
    // 左序遍历所有节点，并转化为 ArrayList
    public ArrayList<T> getLeftArrayList() {
        // 1.定义一个有节点个数 size 大小的ArrayList
        ArrayList<T> list = new ArrayList<>(this.size);
        // 2.调用根节点的 traverseLeft 方法
        rootNode.traverseLeft(list);
        // 3.返回该 ArrayList
        return list;
    }
    // getter 和 setter
    public int getSize() {
        return this.size;
    }

    /* 内部类 */
    /**
     * 类名：Node
     * 功能：二叉树的节点
     */
    private class Node<T extends Comparable<T>> {
        /* 对象属性 */
        private Node<T> leftNode;     // 左子节点
        private Node<T> rightNode;    // 右子节点
        private T value;
        /* 对象方法 */
        // 节点比较，value 对象必须实现 Comparable 接口
        public int compareTo(Node<T> anotherNode) {
            return this.getValue().compareTo(anotherNode.getValue());    // 调用 value 的 compareTo 方法
        }
        // 左序遍历，存入节点数组
        public void traverseLeft(ArrayList<T> list) {
            // 查看左节点
            if(this.leftNode != null) {
                this.leftNode.traverseLeft(list);
            }
            // 将 value 添加到 list 中
            list.add(this.getValue());
            // 查看右节点
            if(this.rightNode != null) {
                this.rightNode.traverseLeft(list);
            }
        }
        // getter和setter方法
        public Node<T> getLeftNode() {
            return this.leftNode;
        }
        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }
        public Node<T> getRightNode() {
            return this.rightNode;
        }
        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }
        public T getValue() {
            return this.value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }
}
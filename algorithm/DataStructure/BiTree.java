package DataStructure;

import java.util.Stack;

public class BiTree {//这个代码是错的，目前能力不足，无法纠正 2022.3.24
    public class Node {
        private Object value;
        private Node left;
        private Node right;
        public Node(){}
        public Node(Object value,Node left,Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(Object value){
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    private Node root;
    private int index = 0;
    public BiTree(String str) {//先序遍历建树 直接写在构造方法里，和C++不一样
        char c = str.charAt(index++);
        if(c != '#'){
            root = new Node(c);
            root.left = new BiTree(str).root;
            root.right = new BiTree(str).root;
        } else root = null;//构造函数哪有返回值
    }

    public void preRootTraverse(){
        Node T = root;
        if(T != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(T);
            while(!stack.isEmpty()){
                Node temp = stack.pop();
                System.out.print(temp.value);
                while(T != null) {
                    if(T.left != null){
                        System.out.println(T.left.value);
                    }
                    if(T.right != null){
                        stack.push(T.right);
                    }
                    T = T.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "AB##CD###";
        BiTree t = new BiTree(str);
        System.out.println("先序遍历：");
        t.preRootTraverse();
    }

}

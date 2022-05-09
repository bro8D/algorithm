package Java;

import java.util.Objects;

public class equals相关 {
    class Node{
        int val;
        Node(){}
        Node(int value){val = value;}

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            //一般默认是getClass()可以获取一个类的定义信息
            // this.getClass() != o.getClass()代表着当前这个类和你传过来这个对象是不是名字相同的类
            // 如果是的话再进行属性比较，如果属性相同则就认为是同一个类，即比较结果返回为true,否则为false
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
    public void ObjectAndEquals(){
        Node node = new Node(0);
        Node node_1 = new Node(0);
        System.out.println(node.equals(node_1));
    }
    public void StringAndEquals(){
        String s1 = "111";
        String s2 = "111";
        System.out.print("s1==s2:");
        System.out.println(s1==s2);//true
        System.out.println("s1.equals(s2):"+s1.equals(s2));//true

    }
    public static void main(String[] args) {
        equals相关 equals = new equals相关();
//        equals.StringAndEquals();
        equals.ObjectAndEquals();
    }

}

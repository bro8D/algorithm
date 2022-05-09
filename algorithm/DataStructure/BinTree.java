package DataStructure;

import java.util.*;

class Node {
    String data;
    Node left;
    Node right;
}

public class BinTree {
    static final int MAXLEN = 20; //定义最大节点数
    static Scanner input = new Scanner(System.in);

    Node InitTree() {
        Node node;
        if ((node = new Node()) != null) {//申请内存
            System.out.println("请先输入一个根节点数据：");
            node.data = input.next();
            node.left = null;
            node.right = null;
            if (node != null) {
                return node;
            } else return null;
        }
        return null;
    }

    void AddTreeNode(Node node) {
        Node pnode, parent;
        String data;
        int menusel;
        if ((pnode = new Node()) != null) {
            System.out.println("输入二叉树的节点数据：");
            pnode.data = input.next();
            pnode.left = null;
            pnode.right = null;
            System.out.println("输入该节点的父节点：");
            data = input.next();
            parent = TreeFindNode(node, data);
            if (parent == null) {
                System.out.println("未找到该父节点！");
                pnode = null;
                return;
            }
            System.out.println("1.添加该节点到左子树，2.添加该节点到右子树");
            do {
                menusel = input.nextInt();
                if (menusel == 1 || menusel == 2) {
                    if (parent == null) {
                        System.out.println("不存在父节点，请先设置父节点！");
                    } else {
                        switch (menusel) {
                            case 1:
                                if (parent.left != null) {
                                    System.out.println("左子树不为空！");
                                } else {
                                    parent.left = pnode;
                                }
                                break;
                            case 2:
                                if (parent.right != null) {
                                    System.out.println("右子树不为空！");
                                } else {
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.println("无效参数！");
                        }
                    }
                }
            } while (menusel != 1 && menusel != 2);
        }
    }

    Node TreeFindNode(Node node, String data) {
        Node ptr;
        if (node == null) {
            return null;
        } else {
            if (node.data.equals(data)) {
                return node;
            } else {
                if ((ptr = TreeFindNode(node.left, data)) != null) {
                    return ptr;
                } else if ((ptr = TreeFindNode(node.right, data)) != null) {
                    return ptr;
                } else return null;
            }
        }
    }

    Node TreeLeftNode(Node node) {
        return node != null ? node.left : null;
    }

    Node TreeRightNode(Node node) {
        return node != null ? node.right : null;
    }

    int TreeIsEmpty(Node node) {
        return node == null ? 0 : 1;
    }

    int TreeDepth(Node node) {
        int depleft, depright;
        if (node == null) return 0;
        else {
            depleft = TreeDepth(node.left);
            depright = TreeDepth(node.right);
            return Math.max(depleft, depright) + 1;
        }
    }

    void ClearTree(Node node) {
        if (node != null) {
            ClearTree(node.left);
            ClearTree(node.right);
            node = null;
        }
    }

    ArrayList<ArrayList<String>> LeetCode(Node node) {//层序遍历 返回一个二维数组
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        Queue<Node> que = new LinkedList<Node>();
        if (node != null) {
            que.add(node);
        } else return arrayLists;
        while (!que.isEmpty()) {
            ArrayList<String> level = new ArrayList<String>();
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Node temp = que.poll();
                level.add(temp.data);
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
            arrayLists.add(level);
        }
        return arrayLists;
    }

    void cengxubianli(Node node) {//用java 自带的队列写
        if (node == null) return;
        Node p;
        Queue<Node> nodes = new LinkedList<Node>();
        if (node != null) {
            nodes.add(node);
        }
        while (!nodes.isEmpty()) {
            Node temp = nodes.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null) {
                nodes.add(temp.right);
            }
        }
    }

    void TreeNodeData(Node p) {
        System.out.printf("%s ", p.data);//好奇怪的写法
    }

    void LevelTree(Node node) {//按层遍历 不用java封装的栈
        Node p;
        Node[] q = new Node[MAXLEN];//顺序栈:栈的元素依次存放在一个一维数组中。下标小的一端作为栈底。用一个变量记录栈顶位置，称“栈顶指针”。
        int head = 0, tail = 0;
        if (node != null) {//如果队首引用不为空
            tail = (tail + 1) % MAXLEN;//计算循环队列队尾序号
            q[tail] = node; //将二叉树引进队
        }
        while (head != tail) {//队列不为空，进行循环
            head = (head + 1) % MAXLEN;//计算循环队列队首序号
            p = q[head];//获取队首元素
            TreeNodeData(p); //此处遍历操作可以改成其他的操作
            if (p.left != null) {//如果左子树存在
                tail = (tail + 1) % MAXLEN;//计算循环队列队尾序号
                q[tail] = p.left;//左子树进队
            }
            if (p.right != null) {//如果右子树存在
                tail = (tail + 1) % MAXLEN;//计算循环队列队尾序号
                q[tail] = p.right;//右子树进队
            }
        }
    }

    void LDRTree(Node node) {
        if (node == null) return;
        LDRTree(node.left);
        System.out.print(node.data + " ");
        LDRTree(node.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int menusel;
        BinTree binTree = new BinTree();
        root = binTree.InitTree();
        do {
            System.out.println("请选择菜单添加二叉树节点：");
            System.out.print("0.退出\t");
            System.out.println("1.添加二叉树的节点");
            menusel = input.nextInt();
            switch (menusel) {
                case 1:
                    binTree.AddTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    ;
            }
        } while (menusel != 0);
        System.out.print("层序遍历：");
        binTree.LevelTree(root);
        System.out.println();
        System.out.print("中序遍历：");
        binTree.LDRTree(root);
        System.out.println();
        System.out.print("树的深度为：" + binTree.TreeDepth(root) + '\n');
        binTree.cengxubianli(root);

        ArrayList<ArrayList<String>> ans = binTree.LeetCode(root);//LeetCode要求的层序遍历方式好变态
        System.out.println(ans);
        binTree.ClearTree(root);
        root = null;
    }
}
/* 建树样例：
A 1  B A 1 1  C A 2 1  D B 1 1 F D 1 1 G D 2 1 E C 1 0
* */


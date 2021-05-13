package com.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        // 中序线索化二叉树
//        threadedBinaryTree.threadedNodes();
        // 前序线索化二叉树
        threadedBinaryTree.threadedNodesQ(root);
        // 后序
//        threadedBinaryTree.threadedNodesH(root);

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        // 8, 3, 10, 1, 14, 6
//        threadedBinaryTree.threadedList();
        // {1,3,8,10,6,14}
        threadedBinaryTree.threadedListQ();
        // 后序
//        threadedBinaryTree.threadedListH();
    }

}


//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // 中序遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    /**
     * 前序遍历线索二叉树
     * {1,3,8,10,6,14}
     */
    public void threadedListQ() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            node = node.getRight();
        }
    }

    /**
     * 后序遍历线索二叉树
     * {8,10,3,1,14,6}
     */
    public void threadedListH() {

    }

    /**
     * 编写对二叉树进行中序线索化的方法
     * 得到的数组{8,3,10,1,14,6}
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {

        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点 pre是上一次遍历的树节点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)在线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 编写对二叉树进行 前序线索化的方法
     * 变成数组后{1,3,8,10,6,14}
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodesQ(HeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        // 1处理当前节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 2处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //3 !!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        if (node.getLeftType() != 1) {
            // 处理左子树
            threadedNodesQ(node.getLeft());
        }
        if (node.getRightType() != 1) {
            // 处理右子树
            threadedNodesQ(node.getRight());
        }
    }

    /**
     * 编写对二叉树进行 后序线索化的方法
     * {8,10,3,1,14,6}
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodesH(HeroNode node) {
        if (node == null) {
            return;
        }


        // 处理左子树
        threadedNodesQ(node.getLeft());
        // 处理右子树
        threadedNodesQ(node.getRight());


        // 1处理当前节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 2处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //3 !!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

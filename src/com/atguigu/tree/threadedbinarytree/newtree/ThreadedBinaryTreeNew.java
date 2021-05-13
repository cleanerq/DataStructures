package com.atguigu.tree.threadedbinarytree.newtree;

import com.atguigu.tree.threadedbinarytree.HeroNode;

public class ThreadedBinaryTreeNew {
    private HeroNode root;

    /**
     * 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
     * 在递归进行线索化时，pre 总是保留前一个结点
     */
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 重载一把threadedNodes方法
     */
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 重载一把threadedNodesPre方法
     */
    public void threadedNodesPre() {
        this.threadedNodesPre(root);
    }

    /**
     * 重载一把threadedNodesAfter方法
     */
    public void threadedNodesAfter() {
        this.threadedNodesAfter(root);
    }

    /***********************遍历线索化二叉树开始**********************/

    /**
     * 中序遍历线索化二叉树的方法
     * <p>
     */

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
     * 前序线索化二叉树遍历方法
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     * <p>
     * {1,3,8,10,6,14}
     */
    public void threadedListPre() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                //如果是叶子节点，非前驱节点，打印当前这个结点
                System.out.print(node + ",");
                node = node.getLeft();
            }
            System.out.print(node + ",");
            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    /**
     * 后序线索化二叉树遍历方法
     * <p>
     * 注意后序有点复杂，需要建立二叉树的时候，将节点的parent进行赋值，否则不能遍历成功
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     * <p>
     * {8,10,3,1,14,6}
     * 1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     * 2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    public void threadedListAfter() {
        //1、找后序遍历方式开始的节点
        HeroNode node = root;
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }
        while (node != null) {
            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.print(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }

    }

    /***********************遍历线索化二叉树结束**********************/

    /****************线索化二叉树开始********************************/

    /**
     * 中序线索化
     * 得到的数组｛8, 3, 10, 1, 14, 6｝
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
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
        if (null == node.getLeft()) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点,是下一次进行处理，有点不好理解
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
     * 前序线索化
     * 变成数组后{1,3,8,10,6,14}
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodesPre(HeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }
        //左指针为空,将左指针指向前驱节点
        //8结点的.left = 上一个节点 , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点,是下一次进行处理，有点不好理解
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //(一)先线索化左子树
        if (node.getLeftType() != 1) {
            threadedNodesPre(node.getLeft());
        }
        //(三)再线索化右子树
        if (node.getRightType() != 1) {
            threadedNodesPre(node.getRight());
        }

    }

    /**
     * 后序线索化
     * 变成数组后{8,10,3,1,14,6}
     *
     * @param node
     */
    public void threadedNodesAfter(HeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNodesAfter(node.getLeft());
        //(三)再线索化右子树
        threadedNodesAfter(node.getRight());

        //左指针为空,将左指针指向前驱节点
        //8结点的.left = 上一个节点 , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点,是下一次进行处理，有点不好理解
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
    }

    /*********************线索化结束*********************************/

    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能 以数组｛8, 3, 10, 1, 14, 6｝为例

        /**
         *          1
         *        /   \
         *       3     6
         *      / \   /
         *     8  10 14
         */

        HeroNode root = new HeroNode(1, "java");
        HeroNode node2 = new HeroNode(3, "C#");
        HeroNode node3 = new HeroNode(6, "Python");
        HeroNode node4 = new HeroNode(8, "C++");
        HeroNode node5 = new HeroNode(10, "GO");
        HeroNode node6 = new HeroNode(14, "Dephi");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //*************测试中序线索化***************//

        System.out.println("==========中序线索化开始=============");
        System.out.println("｛8, 3, 10, 1, 14, 6｝");
        ThreadedBinaryTreeNew threadedBinaryTree = new ThreadedBinaryTreeNew();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("中序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
        //********************中序结束******************//

        //******************前序*****************//
        System.out.println("==========前序线索化开始=============");
        System.out.println("{1,3,8,10,6,14}");

        //前序：{1,3,8,10,6,14}
        ThreadedBinaryTreeNew threadedBinaryTreePre = new ThreadedBinaryTreeNew();
        threadedBinaryTreePre.setRoot(root);
        threadedBinaryTreePre.threadedNodesPre();

        //测试: 以10号节点测试
        HeroNode leftNodePre = node4.getLeft();
        HeroNode rightNodePre = node4.getRight();
        System.out.println("8号结点的前驱结点是 =" + leftNodePre); //3
        System.out.println("8号结点的后继结点是=" + rightNodePre); //10

        HeroNode leftNodetenPre = node5.getLeft();
        HeroNode rightNodetenPre = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNodetenPre); //8
        System.out.println("10号结点的后继结点是=" + rightNodetenPre); //6

        System.out.println("前序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTreePre.threadedListPre();//{1,3,8,10,6,14}

        //******************前序结束*****************//

        //******************后序*****************//

        //如果是后序，需要创建二叉树的时候，将parent进行保存。这个是用于后续二叉树的遍历的

        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);

        System.out.println("==========后序线索化开始=============");
        System.out.println("{8,10,3,14,6,1}");
        //后序：{8,10,3,14,6,1}
        ThreadedBinaryTreeNew threadedBinaryTreeAfter = new ThreadedBinaryTreeNew();
        threadedBinaryTreeAfter.setRoot(root);
        threadedBinaryTreeAfter.threadedNodesAfter();

        HeroNode leftNodeAfter = node4.getLeft();
        HeroNode rightNodeAfter = node4.getRight();
        System.out.println("8号结点的前驱结点是 =" + leftNodeAfter); //null
        System.out.println("8号结点的后继结点是=" + rightNodeAfter); //10

        HeroNode leftNodetenAfter = node5.getLeft();
        HeroNode rightNodetenAfter = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNodetenAfter); //8
        System.out.println("10号结点的后继结点是=" + rightNodetenAfter); //3

        System.out.println("后序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTreeAfter.threadedListAfter();//{8,10,3,14,6,1}
    }
}
// 登录后复制
//测试二叉树的遍历



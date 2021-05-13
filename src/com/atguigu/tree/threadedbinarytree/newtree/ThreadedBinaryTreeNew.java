package com.atguigu.tree.threadedbinarytree.newtree;

import com.atguigu.tree.threadedbinarytree.HeroNode;

public class ThreadedBinaryTreeNew {
    private HeroNode root;

    /**
     * Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
     * �ڵݹ����������ʱ��pre ���Ǳ���ǰһ�����
     */
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * ����һ��threadedNodes����
     */
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * ����һ��threadedNodesPre����
     */
    public void threadedNodesPre() {
        this.threadedNodesPre(root);
    }

    /**
     * ����һ��threadedNodesAfter����
     */
    public void threadedNodesAfter() {
        this.threadedNodesAfter(root);
    }

    /***********************������������������ʼ**********************/

    /**
     * ��������������������ķ���
     * <p>
     */

    public void threadedList() {
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        while (node != null) {
            //ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ�����8���
            //�������ű������仯,��Ϊ��leftType==1ʱ��˵���ý���ǰ���������
            //��������Ч���
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //��ӡ��ǰ������
            System.out.println(node);
            //�����ǰ������ָ��ָ����Ǻ�̽��,��һֱ���
            while (node.getRightType() == 1) {
                //��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
                System.out.println(node);
            }
            //�滻��������Ľ��
            node = node.getRight();

        }
    }

    /**
     * ǰ����������������������
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     * <p>
     * {1,3,8,10,6,14}
     */
    public void threadedListPre() {
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                //�����Ҷ�ӽڵ㣬��ǰ���ڵ㣬��ӡ��ǰ������
                System.out.print(node + ",");
                node = node.getLeft();
            }
            System.out.print(node + ",");
            //�滻��������Ľ��
            node = node.getRight();
        }
    }

    /**
     * ������������������������
     * <p>
     * ע������е㸴�ӣ���Ҫ������������ʱ�򣬽��ڵ��parent���и�ֵ�������ܱ����ɹ�
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     * <p>
     * {8,10,3,1,14,6}
     * 1. ���leftType == 0 ��ʾָ�����������, ��� 1 ���ʾָ��ǰ�����
     * 2. ���rightType == 0 ��ʾָ����������, ��� 1��ʾָ���̽��
     */
    public void threadedListAfter() {
        //1���Һ��������ʽ��ʼ�Ľڵ�
        HeroNode node = root;
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }
        while (node != null) {
            //�ҽڵ�������
            if (node.getRightType() == 1) {
                System.out.print(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //����ϸ�����Ľڵ��ǵ�ǰ�ڵ���ҽڵ�
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //�������ڵ�Ľ������ҵ�������������ڵ�
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }

    }

    /***********************��������������������**********************/

    /****************��������������ʼ********************************/

    /**
     * ����������
     * �õ��������8, 3, 10, 1, 14, 6��
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     *
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void threadedNodes(HeroNode node) {
        //���node==null, ����������
        if (node == null) {
            return;
        }
        //(һ)��������������
        threadedNodes(node.getLeft());
        //(��)��������ǰ���[���Ѷ�]
        //����ǰ����ǰ�����
        //��8��������
        //8����.left = null , 8����.leftType = 1
        if (null == node.getLeft()) {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }
        //�����̽��,����һ�ν��д����е㲻�����
        if (pre != null && pre.getRight() == null) {
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRightType(1);
        }
        //!!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;
        //(��)��������������
        threadedNodes(node.getRight());
    }

    /**
     * ǰ��������
     * ��������{1,3,8,10,6,14}
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     *
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void threadedNodesPre(HeroNode node) {
        //���node==null, ����������
        if (node == null) {
            return;
        }
        //��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
        //8����.left = ��һ���ڵ� , 8����.leftType = 1
        if (node.getLeft() == null) {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }
        //�����̽��,����һ�ν��д����е㲻�����
        if (pre != null && pre.getRight() == null) {
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRightType(1);
        }
        //!!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;
        //(һ)��������������
        if (node.getLeftType() != 1) {
            threadedNodesPre(node.getLeft());
        }
        //(��)��������������
        if (node.getRightType() != 1) {
            threadedNodesPre(node.getRight());
        }

    }

    /**
     * ����������
     * ��������{8,10,3,1,14,6}
     *
     * @param node
     */
    public void threadedNodesAfter(HeroNode node) {
        //���node==null, ����������
        if (node == null) {
            return;
        }

        //(һ)��������������
        threadedNodesAfter(node.getLeft());
        //(��)��������������
        threadedNodesAfter(node.getRight());

        //��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
        //8����.left = ��һ���ڵ� , 8����.leftType = 1
        if (node.getLeft() == null) {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }
        //�����̽��,����һ�ν��д����е㲻�����
        if (pre != null && pre.getRight() == null) {
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRightType(1);
        }
        //!!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;
    }

    /*********************����������*********************************/

    public static void main(String[] args) {
        //����һ�����������������Ĺ��� �������8, 3, 10, 1, 14, 6��Ϊ��

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

        //����������������Ҫ�ݹ鴴��, ���ڼ򵥴���ʹ���ֶ�����
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //*************��������������***************//

        System.out.println("==========������������ʼ=============");
        System.out.println("��8, 3, 10, 1, 14, 6��");
        ThreadedBinaryTreeNew threadedBinaryTree = new ThreadedBinaryTreeNew();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //����: ��10�Žڵ����
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10�Ž���ǰ������� =" + leftNode); //3
        System.out.println("10�Ž��ĺ�̽����=" + rightNode); //1

        //��������������������ʹ��ԭ���ı�������
        //threadedBinaryTree.infixOrder();
        System.out.println("����ʹ���������ķ�ʽ���� ������������");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
        //********************�������******************//

        //******************ǰ��*****************//
        System.out.println("==========ǰ����������ʼ=============");
        System.out.println("{1,3,8,10,6,14}");

        //ǰ��{1,3,8,10,6,14}
        ThreadedBinaryTreeNew threadedBinaryTreePre = new ThreadedBinaryTreeNew();
        threadedBinaryTreePre.setRoot(root);
        threadedBinaryTreePre.threadedNodesPre();

        //����: ��10�Žڵ����
        HeroNode leftNodePre = node4.getLeft();
        HeroNode rightNodePre = node4.getRight();
        System.out.println("8�Ž���ǰ������� =" + leftNodePre); //3
        System.out.println("8�Ž��ĺ�̽����=" + rightNodePre); //10

        HeroNode leftNodetenPre = node5.getLeft();
        HeroNode rightNodetenPre = node5.getRight();
        System.out.println("10�Ž���ǰ������� =" + leftNodetenPre); //8
        System.out.println("10�Ž��ĺ�̽����=" + rightNodetenPre); //6

        System.out.println("ǰ��ʹ���������ķ�ʽ���� ������������");
        threadedBinaryTreePre.threadedListPre();//{1,3,8,10,6,14}

        //******************ǰ�����*****************//

        //******************����*****************//

        //����Ǻ�����Ҫ������������ʱ�򣬽�parent���б��档��������ں����������ı�����

        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);

        System.out.println("==========������������ʼ=============");
        System.out.println("{8,10,3,14,6,1}");
        //����{8,10,3,14,6,1}
        ThreadedBinaryTreeNew threadedBinaryTreeAfter = new ThreadedBinaryTreeNew();
        threadedBinaryTreeAfter.setRoot(root);
        threadedBinaryTreeAfter.threadedNodesAfter();

        HeroNode leftNodeAfter = node4.getLeft();
        HeroNode rightNodeAfter = node4.getRight();
        System.out.println("8�Ž���ǰ������� =" + leftNodeAfter); //null
        System.out.println("8�Ž��ĺ�̽����=" + rightNodeAfter); //10

        HeroNode leftNodetenAfter = node5.getLeft();
        HeroNode rightNodetenAfter = node5.getRight();
        System.out.println("10�Ž���ǰ������� =" + leftNodetenAfter); //8
        System.out.println("10�Ž��ĺ�̽����=" + rightNodetenAfter); //3

        System.out.println("����ʹ���������ķ�ʽ���� ������������");
        threadedBinaryTreeAfter.threadedListAfter();//{8,10,3,14,6,1}
    }
}
// ��¼����
//���Զ������ı���



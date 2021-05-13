package com.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //����һ�����������������Ĺ���
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //����������������Ҫ�ݹ鴴��, ���ڼ򵥴���ʹ���ֶ�����
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //��������������
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        // ����������������
//        threadedBinaryTree.threadedNodes();
        // ǰ��������������
        threadedBinaryTree.threadedNodesQ(root);
        // ����
//        threadedBinaryTree.threadedNodesH(root);

        //����: ��10�Žڵ����
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10�Ž���ǰ������� =" + leftNode); //3
        System.out.println("10�Ž��ĺ�̽����=" + rightNode); //1

        //��������������������ʹ��ԭ���ı�������
        //threadedBinaryTree.infixOrder();
        System.out.println("ʹ���������ķ�ʽ���� ������������");
        // 8, 3, 10, 1, 14, 6
//        threadedBinaryTree.threadedList();
        // {1,3,8,10,6,14}
        threadedBinaryTree.threadedListQ();
        // ����
//        threadedBinaryTree.threadedListH();
    }

}


//����ThreadedBinaryTree ʵ�������������ܵĶ�����
class ThreadedBinaryTree {
    private HeroNode root;

    //Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
    //�ڵݹ����������ʱ��pre ���Ǳ���ǰһ�����
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //����һ��threadedNodes����
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // ��������������������ķ���
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
     * ǰ���������������
     * {1,3,8,10,6,14}
     */
    public void threadedListQ() {
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
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
     * �����������������
     * {8,10,3,1,14,6}
     */
    public void threadedListH() {

    }

    /**
     * ��д�Զ��������������������ķ���
     * �õ�������{8,3,10,1,14,6}
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
        if (node.getLeft() == null) {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }

        //�����̽�� pre����һ�α��������ڵ�
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
     * ��д�Զ��������� ǰ���������ķ���
     * ��������{1,3,8,10,6,14}
     *
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void threadedNodesQ(HeroNode node) {
        //���node==null, ����������
        if (node == null) {
            return;
        }

        // 1����ǰ�ڵ��ǰ���ڵ�
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 2����ǰ�ڵ�ĺ�̽ڵ�
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //3 !!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;

        if (node.getLeftType() != 1) {
            // ����������
            threadedNodesQ(node.getLeft());
        }
        if (node.getRightType() != 1) {
            // ����������
            threadedNodesQ(node.getRight());
        }
    }

    /**
     * ��д�Զ��������� �����������ķ���
     * {8,10,3,1,14,6}
     *
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void threadedNodesH(HeroNode node) {
        if (node == null) {
            return;
        }


        // ����������
        threadedNodesQ(node.getLeft());
        // ����������
        threadedNodesQ(node.getRight());


        // 1����ǰ�ڵ��ǰ���ڵ�
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 2����ǰ�ڵ�ĺ�̽ڵ�
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //3 !!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;

    }

    //ɾ�����
    public void delNode(int no) {
        if (root != null) {
            //���ֻ��һ��root���, ���������ж�root�ǲ��Ǿ���Ҫɾ�����
            if (root.getNo() == no) {
                root = null;
            } else {
                //�ݹ�ɾ��
                root.delNode(no);
            }
        } else {
            System.out.println("����������ɾ��~");
        }
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //ǰ�����
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

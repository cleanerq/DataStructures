package com.atguigu.tree.threadedbinarytree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //Ĭ��null
    private HeroNode right; //Ĭ��null
    //˵��
    //1. ���leftType == 0 ��ʾָ�����������, ��� 1 ���ʾָ��ǰ�����
    //2. ���rightType == 0 ��ʾָ����������, ��� 1��ʾָ���̽��
    private int leftType;
    private int rightType;

    /**
     * //���ڵ��ָ�루Ϊ�˺���������ʹ�ã�
     */
    private HeroNode parent;

    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //�ݹ�ɾ�����
    //1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {

        //˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		 */
        //2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4.���Ǿ���Ҫ�����������еݹ�ɾ��
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5.��Ӧ�������������еݹ�ɾ��
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //��дǰ������ķ���
    public void preOrder() {
        System.out.println(this); //����������
        //�ݹ���������ǰ�����
        if (this.left != null) {
            this.left.preOrder();
        }
        //�ݹ���������ǰ�����
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //�������
    public void infixOrder() {

        //�ݹ����������������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //��������
        System.out.println(this);
        //�ݹ����������������
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //�������
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //ǰ���������

    /**
     * @param no ����no
     * @return ����ҵ��ͷ��ظ�Node ,���û���ҵ����� null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("����ǰ�����");
        //�Ƚϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        //1.���жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//˵�������������ҵ�
            return resNode;
        }
        //1.��ݹ�ǰ����ң��ҵ���㣬�򷵻أ�������жϣ�
        //2.��ǰ�Ľ������ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //�����������
    public HeroNode infixOrderSearch(int no) {
        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        //����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
        if (this.no == no) {
            return this;
        }
        //������������ҵݹ���������
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //�����������
    public HeroNode postOrderSearch(int no) {

        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {//˵�����������ҵ�
            return resNode;
        }

        //���������û���ҵ��������������ݹ���к����������
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("����������");
        //�������������û���ҵ����ͱȽϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

}

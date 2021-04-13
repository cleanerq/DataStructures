package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListStackDemo {

    public static void main(String[] args) {
        //����һ��ArrayStack �Ƿ���ȷ
        //�ȴ���һ��ArrayStack����->��ʾջ
        ListStack stack = new ListStack(4);
        String key = "";
        boolean loop = true; //�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: ��ʾ��ʾջ");
            System.out.println("exit: �˳�����");
            System.out.println("push: ��ʾ�������ݵ�ջ(��ջ)");
            System.out.println("pop: ��ʾ��ջȡ������(��ջ)");
            System.out.println("���������ѡ��");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("������һ����");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("��ջ�������� %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("�����˳�~~~");
    }

}

class ListStack {
    List<Integer> stack = null;
    private int top = -1;
    private int maxSize;

    public ListStack(int size) {
        stack = new ArrayList<>(size);
        maxSize = size;
    }

    //ջ��
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ-push
    public void push(int value) {
        //���ж�ջ�Ƿ���
        if (isFull()) {
            System.out.println("ջ��");
            return;
        }
        top++;
        stack.add(top, value);
    }

    //��ջ-pop, ��ջ�������ݷ���
    public int pop() {
        //���ж�ջ�Ƿ��
        if (isEmpty()) {
            //�׳��쳣
            throw new RuntimeException("ջ�գ�û������~");
        }
        int value = stack.get(top);
        top--;
        return value;
    }

    //��ʾջ�����[����ջ]�� ����ʱ����Ҫ��ջ����ʼ��ʾ����
    public void list() {
        if (isEmpty()) {
            System.out.println("ջ�գ�û������~~");
            return;
        }
        //��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack.get(i));
        }
    }
}
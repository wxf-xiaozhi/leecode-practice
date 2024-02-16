package com.atguigu.datastruct.queue;

import java.util.Scanner;

/**
 * 数组模拟链表，存在问题，队列取出数据后不能再放
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/15 15:53
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        //
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("程序退出~~");
        }
    }


    static class ArrayQueue {

        private int front;
        private int tail;
        private int maxSize;
        private int[] arr;

        // 队列构造器
        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;
            tail = -1;
        }

        public boolean isEmpty() {
            return front == tail;
        }

        public boolean isFull() {
            return tail == maxSize - 1;
        }

        public void addQueue(int val) {
            if (isFull()) {
                System.out.println("队列已满~~~~~~~");
                return;
            }
            tail++;
            arr[tail] = val;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            front++;
            return arr[front];
        }

        public void showQueue() {
            if (isEmpty()) {
                System.out.println("对列为空~~~~~~");
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            }
        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }

            return arr[front + 1];
        }

    }
}



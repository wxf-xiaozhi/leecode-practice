package com.atguigu.datastruct.queue;

import java.util.Scanner;

/**
 * 利用环形数组模拟真正的队列
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/16 18:46
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        CircleArrayQueueDemo.CircleArrayQueue queue = new CircleArrayQueueDemo.CircleArrayQueue(4);
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

    /**
     * front指向队列的第一个元素，初始值为0
     * tail 初始值0，最大为数组倒数第二个元素
     * tail 初始值0，最大为数组倒数第二个元素
     * 队列满时 (tail + 1) % maxSize == front
     * 队列空 tail == front
     * 队列有效个数 (tail - front + max) % max
     */
    static class CircleArrayQueue{

        // front指向队列的第一个元素，初始值为0
        private int front;

        // 队尾 tail 初始值0，最大为数组倒数第二个元素
        private int tail;

        private int maxSize;
        private int[] arr;

        private CircleArrayQueue(int n){
            maxSize = n;
            arr = new int[maxSize];
            front = 0;
            tail = 0;
        }

        public Boolean isEmpty(){
            return front == tail;
        }

        /**
         * 因为要把数组考虑成环形，所以这样写
         * @return
         */
        public Boolean isFull(){
//            return tail == maxSize -1;
            // 因为要把数组考虑成环形，所以这样写
            return (tail+1) % maxSize == front;
        }

        /**
         * 对tail进行操作
         * @param val
         */
        public void addQueue(int val){
            if(isFull()){
                System.out.println("队列已满~~~~~~~");
                return;
            }
            arr[tail] = val;
            tail = (tail+1) % maxSize;
        }

        /**
         * 对front进行操作
         * @return
         */
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            int value = arr[front];
            front = (front+1) % maxSize;
            return value;
        }

        public void showQueue() {
            if (isEmpty()) {
                System.out.println("对列为空~~~~~~");
                return;
            }

            for (int i = front; i < front+getQueueSize(); i++) {
                System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
            }
        }
        public int getQueueSize(){
            return (tail+maxSize-front) % maxSize;
        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return arr[front];
        }

    }
}

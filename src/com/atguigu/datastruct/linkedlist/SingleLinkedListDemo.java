package com.atguigu.datastruct.linkedlist;

/**
 * 实现单链表
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/16 21:56
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "武松", "行者");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//         singleLinkedList.add(hero1);
//         singleLinkedList.add(hero2);
//         singleLinkedList.add(hero3);
//         singleLinkedList.add(hero4);

        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero3);


        singleLinkedList.show();

        HeroNode hero21 = new HeroNode(2, "小卢", "玉麒麟~~~");

        singleLinkedList.updateNode(hero21);
        singleLinkedList.show();

    }


     static class SingleLinkedList{
        // 头结点不懂，也不存放数据
        private HeroNode head = new HeroNode(0,"","");

        /**
         * 思路：
         * 找到链表最后节点，将新节点设置为最后一个节点的next
         * @param node
         */
        public void add(HeroNode node){
            HeroNode temp = head;
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;
        }

         public void addByNo(HeroNode node){
            HeroNode temp = head;
            boolean flag = false;
             while (true){
                 if(temp.next == null){
                     break;
                 }
                if(temp.next.no > node.no){
                    break;
                }else if(temp.next.no == node.no){
                     flag = true;
                     break;
                 }
                temp = temp.next;
             }
             if(flag){
                 System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", node.no);
             }else {
                 node.next =temp.next;
                 temp.next = node ;

             }
         }
        public  void updateNode(HeroNode node){
            if(head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head;
            Boolean flag = false;
            while (true){
                if(temp == null){
                    break;
                }
                if(temp.no == node.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.name = node.name;
                temp.nickName = node.nickName;
            }else{
                System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.no);
            }

        }
        public void show(){
            if(head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head;
            while (true){
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
      static class HeroNode{
        int no;
        String name;
        String nickName;
        HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

         @Override
         public String toString() {
             return "HeroNode{" +
                     "no=" + no +
                     ", name='" + name + '\'' +
                     ", nickName='" + nickName + '\'' +
                     '}';
         }
     }
}

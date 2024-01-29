package com.sxnd.leecode;

/**
 * (一句话描述该类的功能)
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/1/26 15:53
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;

    }
    public TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        myOut(this,sb);
        return sb.toString();
    }
    private void myOut(TreeNode node,StringBuilder sb){
        if(node == null){
            return;
        }
        sb.append(node.val+",");
        myOut(node.left,sb);
        myOut(node.right,sb);
    }

    public static TreeNode buildTreeNodeByArray(Object[] arr){
        TreeNode node = new TreeNode(Integer.valueOf(arr[0].toString()));
        myDeep(node,arr,0);
        return node;
    }

    private static int myDeep(TreeNode node,Object[] arr,Integer index){
        if(index == arr.length -1 || node == null){
            return index;
        }else{
            TreeNode left = arr[++index]== null?null:new TreeNode(Integer.valueOf(arr[index].toString()));
            TreeNode right = arr[++index]== null?null:new TreeNode(Integer.valueOf(arr[index].toString()));
            if(node != null){
                node.left =  left;
                node.right = right;
            }
            index = myDeep(left,arr,index);
            return myDeep(right,arr,index);
        }
    }

    public static void main(String[] args) {
        Object[] arr ={3,9,20,null,null,15,7};
        TreeNode treeNode = buildTreeNodeByArray(arr);
        System.out.println(treeNode);
    }


}

package com.atguigu.datastruct.sparsearray;

/**
 * 稀疏数组
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/15 15:05
 */
public class SparseArray {


    public static void main(String[] args) {

        // 构造二维数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        // 打印二维数组
        printArr(chessArr);

        // 二维数组转化稀疏数组
        int[][] spareArr = chessArr2SparseArr(chessArr);

        System.out.println("得到的稀疏数组是");
        // 打印稀疏数组
        printArr(spareArr);

        // 转换稀疏数组为原始二维数组
        int[][] result = sparseArr2ChessArr(spareArr);
        printArr(result);
    }

    /**
     * 打印二维数组
     * @param chessArr
     */
    private static void printArr(int[][] chessArr) {
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    /**
     * 二维数组转稀疏数组
     * 1、便利原始的二维数组，得到有效数据的个数sum
     *
     * 2、根据sum创建二维数组 sparseArr= int[sum+1][3];
     *
     * 3、将二维数组的有效数据存储到稀疏数组
     *
     *
     */
    public static int[][] chessArr2SparseArr(int[][] chessArr){
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // System.out.println("sum ="+sum);

        int[][] sparseArr = new int[sum+1][3];

        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

        int row = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j] != 0){
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = chessArr[i][j];

                }
            }
        }
        return sparseArr;
    }

    /**
     * 稀疏数组转二维数组
     *
     * 1、使用稀疏数组第一行值，构造二维数组
     * 2、读取稀疏数组剩下的行，为二维数组赋值
     * @param sparseArr
     * @return
     */
    public static int[][] sparseArr2ChessArr(int[][] sparseArr){
        int rowNum = sparseArr[0][0];
        int colNum = sparseArr[0][1];
        int[][] chessArr = new int[rowNum][colNum];
        for (int i = 1; i < sparseArr.length ; i++) {
            int row = sparseArr[i][0];
            int col = sparseArr[i][1];
            chessArr[row][col] = sparseArr[i][2];
        }
        return chessArr;
    }

}

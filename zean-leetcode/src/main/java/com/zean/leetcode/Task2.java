package com.zean.leetcode;

/****
 * zengxiangcai
 * 2022/8/24 12:52
 * 两数相加，
 * 两个数用链表表示，每个链表节点表示数值的一位（10进制）, 它们每位数字都是按照逆序存储的，也就是说个位数在链表头
 *
 * 思路：按照加法的法则，先最低位，然后高位，并处理进
 ***/
public class Task2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode rootResult = null;
        ListNode prevResult = null;
        boolean up = false;

        while (currentNode1 != null && currentNode2 != null) {
            int resultValue = currentNode2.value + currentNode1.value + (up ? 1 : 0);
            ListNode currentResultNode;
            if (resultValue >= 10) {
                up = true;
                currentResultNode = new ListNode(resultValue - 10);
            } else {
                currentResultNode = new ListNode(resultValue);
                up = false;
            }
            if (rootResult == null) {
                rootResult = currentResultNode;
            }else {
                prevResult.next = currentResultNode;
            }

            prevResult = currentResultNode;

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        //currentNode1 or currentNode2 有数据
        while( currentNode2!=null){
          //currentNode2有数据
          int resValue = currentNode2.value + (up ? 1 : 0);
          ListNode currentResultNode = null;
          if(resValue>=10){
            up = true;
            currentResultNode = new ListNode(resValue-10);
          }else {
            up = false;
            currentResultNode = new ListNode(resValue);
          }
          prevResult.next = currentResultNode;
          prevResult = currentResultNode;
          currentNode2 = currentNode2.next;
        }

        //node1
      while( currentNode1!=null){
        //currentNode2有数据
        int resValue = currentNode1.value + (up ? 1 : 0);
        ListNode currentResultNode = null;
        if(resValue>=10){
          up = true;
          currentResultNode = new ListNode(resValue-10);
        }else {
          up = false;
          currentResultNode = new ListNode(resValue);
        }
        prevResult.next = currentResultNode;
        prevResult = currentResultNode;
        currentNode1 = currentNode1.next;
      }

        if (up) {
            prevResult.next = new ListNode(1);
        }

        return rootResult;
    }

    public static void main(String[] args) {
//        int[] arrL1 = new int[]{9, 9, 9, 9, 9, 9, 9};
//        int[] arrL2 = new int[]{9, 9, 9, 9};

        int[] arrL1 = new int[]{2,4,3};
        int[] arrL2 = new int[]{5,6,4};

//    LsitNode l2 = [9,9,9,9];
        ListNode l1 = buildListNode(arrL1);
        ListNode l2 = buildListNode(arrL2);
        printList(l1);
        printList(l2);

        ListNode res = new Task2().addTwoNumbers(l1,l2);
        printList(res);

    }

    private static void printList(ListNode node) {
        ListNode curr = node;
        while (curr != null) {
            System.err.print(curr.value + ",");
            curr = curr.next;
        }
        System.err.println();
    }

    private static ListNode buildListNode(int[] arr) {
        ListNode rootNode = null;
        ListNode prev = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode currentNode = new ListNode(arr[i]);
            if (i == 0) {
                rootNode = currentNode;
            } else {
                prev.next = currentNode;
            }
            prev = currentNode;

        }
        return rootNode;
    }

}

class ListNode {
    int value;
    ListNode next;

    ListNode(int val) {
        this.value = val;
    }

    ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }

}

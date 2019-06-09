package com.example.singly;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtil {

    public static void verifyArrayWithSinglyList(int[] arr, SinglyLinkedList list) {
        Node node = list.head();
        int index = 0;

        while (node != null) {
            assertThat(node.data()).isEqualTo(arr[index]);
            node = node.next();
            index++;
        }
    }

    public static void verifyArrayListWithSinglyList(ArrayList<Integer> arrayList, SinglyLinkedList list) {
        Node node = list.head();
        int index = 0;
        while (node != null) {
            assertThat(node.data()).isEqualTo(arrayList.get(index));
            node = node.next();
            index++;
        }
    }

    public static int[] stringArrToIntArr(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
}

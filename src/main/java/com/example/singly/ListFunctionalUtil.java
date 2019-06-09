package com.example.singly;

import java.util.function.BiPredicate;

class ListFunctionalUtil {

    public static NodeWithIndex findFirst(Node head, BiPredicate<Integer,Node> biPred){
        Node node = head;
        for(int index = 0; node!=null; node = node.next(),index++){
            if(biPred.test(index,node)){
                return new NodeWithIndex(node,index);
            }
        }
        return null;
    }

    private ListFunctionalUtil(){}
}

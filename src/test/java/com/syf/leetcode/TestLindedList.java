package com.syf.leetcode;

import com.syf.leetcode.linked.LinkList;
import com.syf.leetcode.linked.LinkListImpl;
import com.syf.leetcode.linked.Node;
import org.junit.Test;

/**
 * Created by Administrator on 2020/10/9
 */
public class TestLindedList {
    @Test
    public void test(){
        // function: isExists and add
        Node node = new Node (1);
        node.value = 12;
        LinkList linkList = new LinkListImpl ();
        linkList.add (node);
        boolean exists = linkList.isExists (12);
        System.out.println (exists);
    }
}

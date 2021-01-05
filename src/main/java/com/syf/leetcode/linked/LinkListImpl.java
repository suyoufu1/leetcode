package com.syf.leetcode.linked;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020/10/9
 * @author syf
 */
public class LinkListImpl implements LinkList{

    List<Node> list = new LinkedList<> ();

    @Override
    public boolean isExists(Integer value) {
        for(Node node : list){
            if(node.value.equals (value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Node node) {
        list.add (node);
    }

    public static void main(String[] args) {
        // function: isExists and add
        Node node = new Node (12);
        node.next = new Node (13);
        LinkList linkList = new LinkListImpl ();
        linkList.add (node);
        boolean exists = linkList.isExists (12);
        System.out.println (exists);
    }
}

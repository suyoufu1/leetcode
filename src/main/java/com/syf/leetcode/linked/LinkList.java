package com.syf.leetcode.linked;


public interface LinkList {
    /**
     * time complexity less than O(n)
     *     if value exists return true otherwise return false
     * @param value
     * @return
     */
    boolean isExists(Integer value);

    /**
     * time complexity less than O(n)
     */
    void add(Node node);
}


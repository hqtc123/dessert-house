package com.hqtc.util;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-14
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class NumComparator implements Comparator<DessertNum> {
    @Override
    public int compare(DessertNum o1, DessertNum o2) {
        return o2.getNum() - o1.getNum();
    }
}

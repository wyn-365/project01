package com.wang.service.impl;

import com.wang.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;


    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    //构造函数
    public void saveAccount(){
        System.out.println(Arrays.toString(myStrs));
        System.out.println(mySet);
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}

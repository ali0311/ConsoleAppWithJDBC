package com.mindtree.jdbc.demo;

import java.util.Comparator;

class CusComp implements Comparator<Customer>{
    @Override
   public int compare(Customer c1, Customer c2) {
       if(c1.getCustomer_id() == c2.getCustomer_id()){
           return 0;
       } if(c1.getCustomer_id() > c2.getCustomer_id()){
           return -1;
       } else {
           return 1;
       }
   }
}
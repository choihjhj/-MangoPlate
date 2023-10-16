package com.my.customer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor

public class Customer {
   private String id;
   private String pwd;
   private String name;
   
   
}
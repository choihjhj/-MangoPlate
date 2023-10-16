package com.my.util;

import java.util.List;

import com.my.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class PageBean<T> {
   private int cntPerPage; 
   private int totalCnt;
   private List<T> list;
   private int cntPerPageGroup;
   private int currentPage;
   private int totalPage;
   private int startPage;
   private int endPage;
      
   
   public PageBean(int cntPerPage, int totalCnt, List<T> list, int cntPerPageGroup, int currentPage) {
      super();
      this.cntPerPage = cntPerPage;
      this.totalCnt = totalCnt;
      this.list = list;
      this.cntPerPageGroup = cntPerPageGroup;
      this.currentPage = currentPage;
      totalPage =(int)Math.ceil((double)totalCnt/cntPerPage);
      startPage =(currentPage - 1) / cntPerPageGroup * cntPerPageGroup + 1;
      endPage =startPage + cntPerPageGroup - 1;
   }
   

}
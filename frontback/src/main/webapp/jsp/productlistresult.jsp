<%@page import="com.my.util.PageBean"%>
<%@page import="com.my.product.dto.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html;charset=utf-8"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport " content="width=device-width">
<link rel="stylesheet" href="<%=contextPath%>/css/layout.css">
<link rel="stylesheet" href="<%=contextPath%>/css/productlist.css">

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<%=contextPath%>/js/layoutjq.js"></script>
<script src="<%=contextPath%>/js/productlistjq.js"></script>

</head>
<body>
   <jsp:include page="./header.jsp" />

   <section>
      <%
      String msg = (String) request.getAttribute("msg");
      if (msg != null) {//상품목록검색 실패
      %>
      <h3>
         상품목록 검색 실패:
         <%=msg%></h3>
      <%
      } else {
      //List<Product> list = (List) request.getAttribute("list");
      PageBean<Product> pb = (PageBean<Product>)request.getAttribute("pagebean");
      List<Product>list = pb.getList();
      int totalCnt = pb.getTotalCnt();//총상품수

      %>

      <div class="productlist">
         <%
         for (Product p : list) {
         %>
         <div class="product <%=p.getProdNo()%>">
            <ul>
               <li><img src="<%=contextPath%>/images/<%=p.getProdNo()%>.jpg"
                  alt="<%=p.getProdNo()%>">
                  <div><%=p.getProdName()%></div></li>
            </ul>
         </div>
         <%
         } //for
         %>
      </div>
      <div class="pagegroup">
         <%
         //int cntPerPageGroup = 3;
         int cntPerPageGroup = pb.getCntPerPageGroup();
         //int cntPerPage = 4;
         int cntPerPage = pb.getCntPerPage();
         int currentPage =pb.getCurrentPage();         
         int totalPage = pb.getTotalPage(); //cntPerPage활용
         int startPage = pb.getStartPage();
         int endPage = pb.getEndPage();
         
         if (totalPage < endPage){
            endPage = totalPage;
         }
         if (startPage > 1) {
         %><span class="page<%=startPage - 1%>">PREV</span> 

         <%
         }
         for (int i = startPage; i <= endPage; i++) {
         %><span class="page<%=i%>">[<%=i%>]</span>&nbsp;&nbsp;
         <%
         }
         if(totalPage>endPage){
         %><span class="page<%=endPage + 1%>">NEXT</span>
         <%} %>
      </div>
      <%
      } //else
      %>
   </section>

   <jsp:include page="./footer.jsp" />

</body>
</html>
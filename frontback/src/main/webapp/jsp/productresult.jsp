<%@page contentType="text/html;charset=utf-8"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="<%=contextPath%>/css/product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<%=contextPath%>/js/productjq.js"></script>
</head>

<body>
    <div class="product_view">
        <div class="product_view_pic">
        <%
        String prodNo=(String)request.getAttribute("prod_no");
        String prodName=(String)request.getAttribute("prod_name");
        int prodPrice=(Integer)request.getAttribute("prod_price");
        %>
            <img src="<%=contextPath%>/images/<%=prodNo%>.jpg"
            alt="<%=prodNo%>"
            >
        </div> 
        <div class="product_view_detail">
            <h4>
                <span class="no"><%=prodNo %></span>
                <span class="en"><%=prodName %></span>
                <span class="price"><%=prodPrice %>원</span>
                <p><label for="number">수량: </label><input type="number" min="1"  max="10" step="1" value="1" name="qt" id="number"/></p>
               <input id="bt" type=button value="장바구니넣기">
            </h4>
            <p>블루베리의 상큼한 풍미가 매력적인 베이글로 국내산 감자, 보리가루를 넣어 더욱 촉촉하고 건강하게 만들었습니다.</p>
        </div>
        <fieldset>
            <legend class="hid">제품 영양 정보</legend>
            <div class="product_view_info">
                <div class="product_info_head">
                    <p class="tit">제품 영양 정보</p>
                    <span class="unit">100(g)</span>
                </div>
                <div class="product_info_content">
                    <ul>
                        <li>
                            <dl>
                                <dt>1회 제공량 (kcal)</dt>
                                <dd>261</dd>
                            </dl>
                        </li>
                        <li style="display: none;">
                            <dl>
                                <dt>지방 (g)</dt>
                                <dd>1.5</dd>
                            </dl>
                        </li>
                    </ul>
                </div>
                <div class="product_factor">
                    <p>알레르기 유발요인 : 밀</p>
                </div>
                <div class="product_sns_wrap">
                    <ul class="product_sns">

                        <li data-sns="F"><a href="javascript:void(0)"
                                title="페이스북 공유하기 새창"><!-- 접근성_20171123 title 추가 --><img
                                    src="//image.istarbucks.co.kr/common/img/menu/sns02.png"
                                    alt="페이스북 공유하기"><!-- 접근성_20171123 alt 추가 --></a></li>
                    </ul>
                </div>
            </div>

        </fieldset>


    </div>
</body>

</html>
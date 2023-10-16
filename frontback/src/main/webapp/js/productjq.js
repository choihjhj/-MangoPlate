//상품번호
//const prodNo=location.search.substring(1).split('=')
//product.html?prodNo=C0001 
//==>search결과: ?prodNo=C0001
//==>substring(1) 결과: prodNo=C0001
//==>split('=')결과: [0]는 prodNo, [1]는 C0001



/*$(()=>{
    const prodNo = sessionStorage.getItem('prodNo') //sessionStorage에 저장된 'prodNo'의 vlaue가져오기
	alert(prodNo)
    //상품이미지는 상품번호이미지로 변경
    $.ajax({
        url : 'http://localhost:8888/frontback/product',
        method :'get',
        data :`prodNo=${prodNo}`,
        success : (ResponseObj)=>{ 
            //{"prodNo":"C0001", "prodName":"아메리카노", "prodPrice"="2000"}},
            const prodName = ResponseObj.prodName
            const prodPrice = ResponseObj.prodPrice
        
            $('div.product_view>div.product_view_detail>h4>span.ko').html(prodName)
            $('div.product_view>div.product_view_detail>h4>span.en').hide() //화면에서 "blueberry Bagel"없애기
            $('div.product_view>div.product_view_detail>h4>span.age').html(prodPrice+"원")

            },
            error: (xhr)=>{
                alert('에러'+xhr.status)
            }
    })
    $('div.product_view>div.product_view_pic>img').attr('src',`../images/${prodNo}.jpg`)
    
})*/

$(() => {
	$('#bt').click(() => {
		const prodNo=$('span.no').html()
		const qt= $('input[name=qt]').val()
		alert(prodNo)
		alert(qt)
		$.ajax({
		url : 'http://localhost:8888/frontback/addtocart',
        method :'get',
        data :`prodNo=${prodNo}&qt=${qt}`,
        success : ()=>{ 
			location.href=`${backURL}/productlist`
		}
		})
		return false
	})	
})
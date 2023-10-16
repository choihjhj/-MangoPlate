
	//---상품목록 얻기 START---
	//요청URL: http://localhost:8888/back/productlist
	//요청방식 :GET
	//요청전달데이터: 없음
	//응답형식: JSON
	//응답성공 데이터는 JS객체
	// const responseObj = [{ prodNo: 'C0001', prodName: '아메리카노', prodPrice: 1000 },
	// { prodNo: 'C0002', prodName: '아이스아메리카노', prodPrice: 1000 },
	// { prodNo: 'C0003', prodName: '라떼', prodPrice: 1500 },
	// { prodNo: 'C0003', prodName: '아이스라떼', prodPrice: 1500 }]


	/*
		$.ajax({
			url: "http://localhost:8888/back/productlist",
			method: 'GET',
			success: (responseObj) => { //자바스크립트 객체
				const productOriginObj = $('div.productlist>div.product').first() //원본클래스, first() 빼도 되긴함
	
				responseObj.forEach((item) => {
					let productCloneObj = productOriginObj.clone() //복제본하나 생성
					productCloneObj.addClass(item.prodNo) //복제본에 calss명 item.prodNo의 value로 변경
					productCloneObj.find('ul>li>img') //복제본의 이미지속성  find로 찾아서 변경
						.attr('src', `../images/${item.prodNo}.jpg`)
						.attr('alt', item.prodNo)
	
					productCloneObj.find('ul>li>span').html(item.prodName) //복제본에 span내용 변경
	
					productOriginObj.parent().append(productCloneObj) 
	
				})
	
				$(productOriginObj).hide()
	
			    
			},
			error: (xhr) => {
				alert("에러:" + xhr.status)
			}
		})*/

	//---상품목록 얻기 END---
	//---상품클릭할 때 할 일 START---
	// const divProductObj = $('div.product')
	// console.log(divProductObj.lengt)


	//$('div.product').click((e)=>{

	/*$('div.productlist>div').click(() => {
		const prodNo = $(this).attr('class').split(" ")[1]
		alert(prodNo + ' clicked')


		sessionStorage.setItem("prodNo", prodNo)
		location.href = `${backURL}/jsp/productresult.jsp`
		//---WEB에서는 Storage가 제공됨: localStorage(영구저장소),sessionStorage(탭단위 저장소)
		//$('section').load(`./product.html`) //get방식 호줄할 땐 이거쓰기
		/*$.ajax({
			url: `${backURL}/product`,
			emethod: 'get',
			data: `prodNo=${prodNo}`,
			success: (responseData) => {
				$('section').empty()
				$('section').html(responseData)


			}
		})*/
	//})*/

	// console.log(e.target) //<img~~>~~ 태그나옴
	// console.log(e.currentTarget) //<div class="product C0001"~~ 이렇게 나옴




	/*
	   $('div.productlist').click((e)=>{
		   console.log(e.target) //<img~~>~~ 태그나옴
		   console.log(e.currentTarget) //<div class="product C0001"~~ 이렇게 나옴
		   const prodNo = $(e.currentTarget).attr('class').split(" ")[1]
		   alert(prodNo+' clicked')
   
		   sessionStorage.setItem("prodNo",prodNo)
		   $('section').load(`./product.html`)
	   })
   */
$(() => {
	$('div.productlist>div').click((e) => {
		const prodNo = $(e.currentTarget).attr('class').split(" ")[1];
		alert(prodNo + ' clicked');

		sessionStorage.setItem("prodNo", prodNo);
		$.ajax({
			url: `${backURL}/product`,
			emethod: 'get',
			data: `prodNo=${prodNo}`,
			success: (responseData) => {
				$('section').empty()
				$('section').html(responseData)


			}
		})
	})
	
	$('div.pagegroup>span').click((e) => {
		const classValue = $(e.target).attr('class');
		const pageNo = classValue.substring(4);
		alert(pageNo + "페이지를 요청");
		location.href =`${backURL}/productlist?cp=${pageNo}`
	})
	
})

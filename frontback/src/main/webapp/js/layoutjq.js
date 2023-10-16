const frontURL = 'http://localhost:8888/frontback'
const backURL = '/frontback'
function showAjax(url, targetObj){
    
    targetObj.load(url)
}

$(()=>{
    const btObj = $('header>nav>ul>li>a')
   
   
    const sectionObj = $('section')

    btObj.click((e)=>{
		alert('aaaaa')
        console.log($(e.target).attr('href'))
       
       switch($(e.target).attr('href')) {
		   
            case `${backURL}/jsp/login.jsp`: //로그인메뉴
                showAjax($(e.target).attr('href'), sectionObj)
                break
            case 'logout'://로그아웃메뉴 
               $.ajax({
               url: `${backURL}/logout`,
               success: ()=>{
                  location.href=`${frontURL}/jsp/layout.jsp`
               }
            })
               
               break
            case `${backURL}/jsp/signup.jsp`: //가입메뉴
                showAjax($(e.target).attr('href'), sectionObj)
                break
            case `productlist`: //상품목록메뉴
                location.href=`${backURL}/productlist`
                showAjax($(e.target).attr('href'), sectionObj)
                break
            case `cartlist`:
				//location.href=`${backURL}/cartlist`
                showAjax(`${backURL}/cartlist`, sectionObj)
               // location.href=`${backURL}/jsp/cartlistresult.jsp`
                 } return false
                 });
                 })
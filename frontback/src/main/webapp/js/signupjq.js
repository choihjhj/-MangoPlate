//dom트리가 완성되고 렌더링 준비가 완료외었을 때 window객체의 load
$(() => {

	// form객체찾기
	const formObj = $('form.login');
	//아이디입력란객체찾기
	const inputIdObj = $('#id')
	//아이디중복확인버튼-일반버튼,
	const btIdDupchk = $('form.login>button.iddupchk')

	//가입버튼 객체 찾기
	const btSignup = $('form.login>button.signup');


	btIdDupchk.click((e) => {
		alert('tttttt')
		//아이디입력값이 'id1'인 경우
		//'이미 사용중인 아이디입니다 '경고창
		//아이디입력값이 'id1'가 아닌 경우
		//가입버튼 보여주기
		$.ajax({
			url: 'http://localhost:8888/frontback/iddupchk',
			method: 'get',
			data: `id=${inputIdObj.val()}`/*{ "id": inputIdObj.val() }*/,
			success: (responseData) => {
				if (responseData.trim() == 0) {//로그인 실패인 경우
					alert('아이디가 중복됩니다!')
				} else { //로그인 성공인 경우
					alert('중복체크 완료, 아이디 사용 가능!')
					btSignup.css('display', 'block')
				}
			},
			error: (xhr) => {
				alert("에러:" + xhr.status)
			}

		})
	
		return false

	})
	//폼의 서브밋이벤트발생
    //폼의 서브밋이벤트발생시 할일 START------
    formObj.submit((e) => {

        //비밀번호1,2가 일치 확인
        const pwdObj = $('#pwd');
        const pwdObj2 = $('#pwd1');
        if (pwdObj.val() != pwdObj2.val()) {
            alert('비밀번호가 일치하지 않습니다.')
            pwdObj.focus()
            return false
        }
        $(e.target).attr('action', 'http://localhost:8888/frontback/signup')
        $(e.target).attr('method', 'post')
        alert(formObj.serialize())

        $.ajax({
            url: 'http://localhost:8888/frontback/signup' /*$(e.target).attr('action')*/,
            method: 'post',/*$(e.target).attr('method')*/
            data:
                formObj.serialize(), //post방식일 때만 사용가능!!!!!
            //{ id: inputIdObj.val(),
            // pwd: pwdObj.val(),
            // name: $('form.sigunp>input[name=name]')},//"id=abc&pwd=p1&name=n1",
            success: (responseData) => {
                // const responseObj=JSON.parse(responseDate)
                if (responseData.trim() == 0) {
                    alert("회원가입 실패")
                }else {
                    alert(responseData)
                    //location.href="./layout.jsp"

                }
                // alert(responseDate)

            },
           error: (xhr) => {
				alert("에러:" + xhr.status)
			}
        })


        return false





    })

	//폼의 서브밋이벤트발생시 할일 END------

	//아이디입력란 inputIdObjdp focus이벤트 발생시 할 일 START---
	inputIdObj.focus(() => {

		btSignup.css('display', 'none'); //가입버튼 사라지기

	})

	//아이디입력란 inputIdObjdp focus이벤트 발생시 할 일 END---

})
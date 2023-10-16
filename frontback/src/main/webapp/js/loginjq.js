/*const backURL = 'http://localhost:8888/frontback'*/

$(() => {
	alert('test')
	const formObj = $('form.login')

	const cbobj = formObj.find("input[type=checkbox]") //아이디 저장체
	const savedId = localStorage.getItem("savedId")
	if (savedId != null) {
		formObj.find("input[name=id]").val(savedId)
	}



	formObj.submit((e) => {

		if ($(cbobj).prop('checked')) {//체크가된경우

			localStorage.setItem("savedId", formObj.find('input[name=id]').val())
		} else {//체크가 해지된 경우
			localStorage.removeItem("savedId")
		}

		const data = $(e.target).serialize()
		$.ajax({
			url: 'http://localhost:8888/frontback/loginservlet',
			method: 'post',
			data: data,
			success: (responseData) => {
				if (responseData.trim() == 0) {//로그인 실패인 경우
					alert('로그인 실패')
					$('form.login>input[name=id]').focus()
				} else { //로그인 성공인 경우
					alert('안녕!')
					location.href = 'layout.jsp'
				}
			},
			error: (xhr) => {
				alert("에러:" + xhr.status)
			}
		})

		return false
	})
})
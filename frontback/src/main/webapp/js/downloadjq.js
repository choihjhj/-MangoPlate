$(()=>{
	
	$("a.txt").click((e)=>{
		const urlTxt = '/frontback/download?filename=a.txt'
		$(e.target).attr('href', urlTxt)
		
	})
	$("a.img").click((e)=>{
		const urlImg = '/frontback/download?filename=logo.png'
		$.ajax({
			url: urlImg,
			processData: false,
			contentType: false,
			xhrFields:{
                responseType: 'blob'
            },
			success: (responseData)=>{
				 var imageUrl = URL.createObjectURL(responseData)
				 console.log(imageUrl)
				$('img').attr('src',  imageUrl)
			}
		})
		return false
	})
})
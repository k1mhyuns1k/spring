<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

	function formCheck() {
		if($("#id").val() == '') {
			alert('아이디를 입력하세요.');
			$("#id").focus();
			return false;
		}
		
		// 아이디 중복 체크
		var con = true;
		$.ajax({
			url : "idcheck.do",
			data : {
					id : $("#id").val()
			},
			async : false,
			method : "get",
			success : function(res) {
				if(res.trim() == '1') {
					alert("아이디가 중복되었습니다.");
					$("#id").val('');
					$("#id").focus();
					con = false;
				}
			}
		});
		
		if(con == false)
			return false;
		
		if($("#pwd").val() == '') {
			alert('비밀번호를 입력하세요.');
			$("#pwd").focus();
			return false;
		}	
		if($("#pwd").val() != $("#pwd2").val()) {
			alert('비밀번호 값을 확인하세요.');
			$("#pwd2").focus();
			return false;
		}
		if($("#name").val() == '') {
			alert('이름을 입력하세요.');
			$("#name").focus();
			return false;
		}
		// 학교 정보 체크
		$("input[name='school']").each(function(idx){ // input 태그의 name 속성 값이 school 선택자의 객체를 반복
			//console.log("input[name='school']").eq(idx).val();
			
			if($("input[name='school']").eq(idx).val() == '') {
				alert(idx+1 + '번째 학교명을 입력해주세요.');
				$("input[name='school']").eq(idx).focus();
				con = false;
				return false;
			}
			if($("input[name='year']").eq(idx).val() == '') {
				alert(idx+1 + '번째 졸업년도를 입력해주세요.');
				$("input[name='year']").eq(idx).focus();
				con = false;
				return false;
			}
		});
		
		if(con == false) return false;
		return true;
	}
	
	function idcheck() {
		if($("#id").val() == '') {
			alert('아이디를 입력하세요.');
		} else {
			$.ajax({
				url : "idcheck.do",         // 비동기 요청을 할 주소
				data : {                    // 파라미터
						id : $("#id").val() // id라는 이름으로 선택자의 value 값을 가져오게 됨.
				},
				async : false,              // 비동기 옵션을 false로 끔. => 실행의 흐름을 동기로 바꾸어둠(이렇게 하지 않으면 아이디 체크 전에 비밀번호 확인 체크가 뜰 수 있음.)
				method : "get",             // 전송 방식
				success : function(res) {   // 응답에 성공했을 때 실행되는 메서드.
					//console.log(res);
				
					if(res.trim() == '1') {
						alert('아이디가 중복되었습니다. 다른 아이디를 입력하세요.');
						$("#id").val('');
						$("#id").focus();
					} else {
						alert('사용 가능한 아이디입니다.');
						$("#pwd").focus();
					}
				},
				error : function(res) {
					console.log(res);
				}
			});
		}
	}
	
	$(function(){
		$("#id").keyup(function(){
			$.ajax({
				url : "idcheck.do",         // 비동기 요청을 할 주소
				data : {                    // 파라미터
						id : $("#id").val() // id라는 이름으로 선택자의 value 값을 가져오게 됨.
				},
				async : false,              // 비동기 옵션을 false로 끔. => 실행의 흐름을 동기로 바꾸어둠(이렇게 하지 않으면 아이디 체크 전에 비밀번호 확인 체크가 뜰 수 있음.)
				method : "get",             // 전송 방식
				success : function(res) {   // 응답에 성공했을 때 실행되는 메서드.
		
					if(res.trim() == '1') {
						$("#duplicateMsg").html("사용불가");
					} else {
						$("#duplicateMsg").html("사용가능");
					}
				}
			});
		})
	});
</script>
</head>
<body>
<h2>회원 가입</h2>
<form action="regist.do" method="post" onsubmit="return formCheck();">
<table border="1"> 
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="중복체크" onclick="idcheck();"><br>
			<span id="duplicateMsg"></span>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd" id="pwd"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="pwd2" id="pwd2"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td>학교</td>
		<td>
			<table>
				<tr>
					<td>학교명</td>
					<td>졸업년도</td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="가입"></td>
	</tr>
</table>
</form>
</body>
</html>
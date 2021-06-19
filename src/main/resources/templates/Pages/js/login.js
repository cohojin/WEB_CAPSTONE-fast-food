
var loginBtn = document.querySelector("#loginBtn");
loginBtn.addEventListener("click",loginFunc);

function loginFunc(){
  var loginId = document.querySelector("#loginId").value;
  var loginPw = document.querySelector("#loginPw").value;

  if(loginId ==="kimhojin3714" && loginPw ==="1234"){
    alert("로그인 성공");
    console.log("로그인에 성공했습니다.");
  }else{
    alert("로그인 실패");
    console.log("로그인에 실패했습니다.");
  }
}

function init(){
  loginFunc();
}

init();
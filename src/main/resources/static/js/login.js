
var loginBtn = document.querySelector("#loginBtn");
loginBtn.addEventListener("click",loginFunc);

function loginFunc(){
  var loginId = document.querySelector("#loginId").value;
  var loginPw = document.querySelector("#loginPw").value;

  if(loginId ==="rlaalsgh9511" && loginPw ==="alsgh0914"){
    alert("로그인 성공");
    console.log("로그인에 성공했습니다.");
  }
}

function init(){
  loginFunc();
}

init();
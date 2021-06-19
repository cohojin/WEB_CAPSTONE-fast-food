btnIDCheck.onclick = function () {

  var SC = ["!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+", "="];
  var check_SC = 0;
  var id_ge_check = 0;
  var id_uc_check = 1;
  var logidpass = document.getElementById("LogID").value;
  var regType1 = /^[A-Za-z0-9+]*$/;

  if (regType1.test(document.getElementById('LogID').value)) {
    id_uc_check = 0;

  }
  else {
    alert('아이디가 조건에 맞지 않습니다');
  }
  if (logidpass.length < 4) {
    id_uc_check = 1;
    window.alert('아이디는 특수문자 미포함 4글자 이상, 15글자 이하만 이용 가능합니다.');
  }
  for (var i = 0; i < SC.length; i++) {
    if (logidpass.indexOf(SC[i]) != -1) {
      check_SC = 1;
    }
  }
  if (check_SC == 0 && id_ge_check == 0 && id_uc_check == 0) {
    window.alert("확인 되었습니다.");
  }
  if (check_SC == 1) {
    window.alert('특수문자가 들어가 있습니다.');
  }

}

// //////////////////////////////////////////////////
function handleOnInput(e) {
   e.value = e.value.replace(/[0-9]//[a-zA-Z]/ig, '')

}
window.onload = function () {
  // pwd1 과 pwd2를 text비교
  // 확인 버튼에 클릭 이벤트 처리하기
  var btnCheck = document.getElementById("btnCheck");


  btnCheck.onclick = function () {
    //checkCircle, checkText 속성변경
    var SC = ["!", "@", "#", "$", "%", "^", "&", "*"];
    var check_SC = 0;
    var pass1 = document.getElementById('password1').value;
    var pass2 = document.getElementById('password2').value;
    var checkCircle = document.getElementById("checkCircle");
    var checkText = document.getElementById("checkText");

    if (pass1.length < 6 || pass1.length > 16) {
      window.alert('비밀번호는 특수문자 포함 6글자 이상, 16글자 이하만 이용 가능합니다.');
      document.getElementById('password1').value = '';
    }
    for (var i = 0; i < SC.length; i++) {
      if (pass1.indexOf(SC[i]) != -1) {
        check_SC = 1;
      }
    }
    if (check_SC == 0) {
      window.alert('!,@,#,$,%,^,&,* 의 특수문자가 들어가 있지 않습니다.')
      document.getElementById('password1').value = '';
    }

    //if 문으로 조건 검색
    if (pass1 == pass2) {
      //비밀번호 입력창이 같으면
      checkCircle.style.backgroundColor = "green";
      checkText.innerHTML = "비밀번호가 일치 합니다. ";
    }
    else {
      //비밀번호 입력창이 다르면
      checkCircle.style.backgroundColor = "red";
      checkText.innerHTML = "비밀번호가 일치하지 않습니다.";
      alert('비밀번호가 일치하지 않습니다.');
    }
  }
}

// /////////////////////////////////////////
var autoHypenPhone = function (str) {
  str = str.replace(/[^0-9]/g, '');
  var tmp = '';
  if (str.length < 4) {
    return str;
  } else if (str.length < 7) {
    tmp += str.substr(0, 3);
    tmp += '-';
    tmp += str.substr(3);
    return tmp;
  } else if (str.length < 11) {
    tmp += str.substr(0, 3);
    tmp += '-';
    tmp += str.substr(3, 3);
    tmp += '-';
    tmp += str.substr(6);
    return tmp;
  } else {
    tmp += str.substr(0, 3);
    tmp += '-';
    tmp += str.substr(3, 4);
    tmp += '-';
    tmp += str.substr(7);
    return tmp;
  }

  return str;
}


var phoneNum = document.getElementById('phoneNum');

phoneNum.onkeyup = function () {
  console.log(this.value);
  this.value = autoHypenPhone(this.value);
}

// /////////////////////////////////
var sub_check = 0;

bt_submit.onclick = function () {
  if (sub_check == 0) {
    alert("회원가입을 완료했습니다.");
  }
}
const couponReg=document.querySelector('#coupon_reg');

const couponItem1=document.querySelector('#coupon_item1');


function couponRegister(){
  let couponTxt=document.querySelector('#coupon_txt').value;

  if(couponTxt==='1234'){
    console.log('쿠폰등록에 성공했습니다.');
  }else{
    console.log('쿠폰등록에 실패했습니다.');
  }
}













couponReg.addEventListener('click',couponRegister);
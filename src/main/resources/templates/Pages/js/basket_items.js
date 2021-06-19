var basketCount = document.querySelector('#basket_count');
var basketMinus= document.querySelector('#basket_minus');
var basketPlus=document.querySelector('#basket_plus');
var basketMoney=document.querySelectorAll('.basket_money');
var deliveryMoney=document.querySelector('.delivery_money');


var basketRemove=document.querySelector('#basket_remove');
var basketContainer =document.querySelector('.basket_list_container');

// 수량 늘리기 줄이기 
basketMinus.addEventListener('click',basketMi);
basketPlus.addEventListener('click',basketPl);

// 컨텐츠 삭제하기 
basketRemove.addEventListener('click',basketRv);

var count=parseInt(basketCount.innerText);

//basketResult,orderResult는 변하는값 result는 상품 가격 
let basketResult=parseInt(basketMoney[0].innerText);
let orderResult=parseInt(basketMoney[1].innerText);

const result=parseInt(basketMoney[0].innerText);
const deliveryFee=parseInt(deliveryMoney.innerText);

//배송비가 합해진 totalResult
let totalResult=parseInt(basketMoney[2].innerText)+deliveryFee;

// totalResult=basketResult+deliveryFee;

function basketDelivery (count) {
  if(count>0){
    totalResult=deliveryFee+basketResult;
  }
}

// 가격 감소
function basketMi() {
  count=count-1;
  //변하는 상품 금액 (basketResult) - 상품 고정 금액 (result)
  basketResult=basketResult-result;
  
  if(count>=0){
    basketCount.innerText=count;
    basketMoney[0].innerText=basketResult;
    basketMoney[1].innerText=basketResult;

    //총 금액에 basketResult값을 넣는 상황
    // basketMoney[2].innerText=basketResult;
    basketMoney[2].innerText=totalResult;
  }else{
    count=0;
    basketResult=0;
  }
}
// 가격 증가
function basketPl() {
  count=count+1;
  basketResult=basketResult+result;

  basketCount.innerText=count;
  basketMoney[0].innerText=basketResult;
  basketMoney[1].innerText=basketResult;
  basketMoney[2].innerText=totalResult;
}
// 리스트 제거 
function basketRv() {
  basketContainer.remove();
}




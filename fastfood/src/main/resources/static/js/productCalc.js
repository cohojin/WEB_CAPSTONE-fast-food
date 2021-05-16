const resultCount = document.querySelector('#product_count');
const resultMoney = document.querySelector("#resultMoney");
const productMoney = document.querySelector("#productMoney");

// number = 수량 , sum = 총액 , money = 상품가격
let number = resultCount.innerText;
let sum = resultMoney.innerText;
let money = productMoney.innerText;

let result = parseInt(sum); // 초기값에는 0이다. 

function calcPlus(){
  result += parseInt(money);
}
function calcMinus(){
  result -= parseInt(money);
}

function calc(type)  {
  //수량이 0이하로 갔을때 함수를 탈출한다.
  // if(parseInt(resultCount.innerText)<0){
  //   break;
  // }
  // 더하기/빼기
  if(type === 'plus') {
    number = parseInt(number) + 1;
    calcPlus();
  }else if(type === 'minus')  {
    number = parseInt(number) - 1;
    calcMinus();
  }

  resultCount.innerText = number;
  resultMoney.innerText = result;
  
}


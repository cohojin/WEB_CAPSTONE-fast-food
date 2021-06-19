const customerQuestion = document.querySelectorAll(".customer_question");

const questionTop = document.querySelectorAll(".question_top_img");
const questionBottom = document.querySelectorAll(".question_bottom_img");

const top_1 = document.querySelector("#top-1");
const bottom_1 = document.querySelector("#bottom-1");

function openCloseAnswer () {
  const answerId = this.id.replace('que','ans');
  

  if(document.getElementById(answerId).style.display === 'none'){
    document.getElementById(answerId).style.display = 'block';
  }else{
    document.getElementById(answerId).style.display = 'none';
  }
}

// function openCloseImg(){

//   if(document.getElementById(top_1).getAttribute('src')=='../Images/direction_top.png'){
//     document.getElementById(bottom_1).setAttribute('src') ='../Images/direction_bottom.png';

//   }else if(document.getElementById(bottom_1).getAttribute('src')=='../Images/direction_bottom.png'){
//     document.getElementById(top_1).setAttribute('src')='../Images/direction_top.png';
//   }
// }

customerQuestion.forEach(item => item.addEventListener('click', openCloseAnswer));

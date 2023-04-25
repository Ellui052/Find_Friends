function input() {
  const input = document.getElementsByTagName("input");
  const btn = document.getElementsByTagName("button");
  if (
    input[0].value == "" ||
    input[1].value == "" ||
    input[1].value.length < 6
  ) {
    btn[0].style.backgroundColor = "#c4c4c4";
  } else {
    btn[0].style.backgroundColor = "black";
  }
}

function login() {
  const input = document.getElementsByTagName("input");
  if (input[0].value == "") {
    alert("전화번호 또는 아이디를 입력해주세요.");
  } else if (input[1].value == "") {
    alert("비밀번호를 입력해주세요");
  } else if(input[1].value.length < 6){
    
  } else {
    location.replace("./main.html");
}
}


function join() {
  location.replace("./join_1.html");
}

function input() {
  const input = document.getElementsByTagName("input");
  const btn = document.getElementsByTagName("button");
  if (input[0].value == "" || input[1].value == "" || input[1].value.length < 6 || input[2].value == "") {
    btn[0].style.backgroundColor = "#c4c4c4";
  } else {
    btn[0].style.backgroundColor = "black";
  }
}

function login() {
  location.replace("./login.html");
}

function join() {
  const input = document.getElementsByTagName("input");
  if (input[0].value == "") {
    alert("사용자명을 입력해주세요");
  } else if (input[1].value == "") {
    alert("비밀번호를 입력해주세요");
  } else if (input[1].value.length < 6) {
    alert("비밀번호는 최소 6자리 이상입니다.");
  } else if (input[2].value == "") {
    alert("비밀번호 확인을 입력해주세요");
  } else if (input[2].value != input[1].value) {
    alert("비밀번호가 일치하지 않습니다.");
  } else {
    alert("회원가입이 완료되었습니다.")
    location.replace("./login.html");
  }
}

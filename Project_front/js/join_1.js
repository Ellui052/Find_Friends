function input() {
  const input = document.getElementsByTagName("input");
  const btn = document.getElementsByTagName("button");
  if (input[0].value == "" || input[1].value == "") {
    btn[0].style.backgroundColor = "#c4c4c4";
  } else {
    btn[0].style.backgroundColor = "black";
  }
}

function login() {
  location.replace("./login.html");
}

function next() {
  const input = document.getElementsByTagName("input");
  if (input[0].value == "") {
    alert("사용자명을 입력해주세요");
  } else if (input[1].value == "") {
    alert("전화번호를 입력해주세요");
  } else {
    location.href = "./join_2.html";
    input[0].value = null;
    input[1].value = null;
  }
}

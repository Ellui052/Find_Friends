function rs() {
  const input = document.getElementsByTagName("input");
  const textarea = document.getElementsByTagName("textarea")[0];

  if (input[0].value == "") {
    alert("작성자를 입력하세요.");
    input[0].focus();
  } else if (input[1].value == "") {
    alert("수정키를 입력하세요.");
    input[1].focus();
  } else if (input[2].value == "") {
    alert("제목을 입력하세요.");
    input[2].focus();
  } else if (textarea.value == "") {
    alert("내용을 입력하세요.");
    textarea.focus();
  } else {
    alert("등록이 완료되었습니다.");
    location.replace("noticeboard.html");
  }
}

function cc() {
  if (confirm("정말 글쓰기를 종료하시겠습니까?")) {
    location.href = "./noticeboard.html";
  }
}

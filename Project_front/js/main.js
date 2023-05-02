function c_heart() {
  const heart = document.getElementsByTagName("img")[4];
  if (heart.alt == "heart") {
    heart.alt = "heart_check";
    heart.src = "../asset/heart_check.png";
  } else {
    heart.alt = "heart";
    heart.src = "../asset/heart.png";
  }
}

function home() {
  location.href = "./main.html";
}

function user() {
  location.href = "./user.html";
}

function search() {
  location.href = "./search.html";
}

function notice() {
  location.href = "./noticeboard.html";
}

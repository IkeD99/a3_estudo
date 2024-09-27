const loginBtn = document.getElementById('login-btn');
const modalBox = document.getElementById('modal-box');

const forms = document.querySelector(".form");
const inputUser = document.querySelector(".user");
const inputEmail = document.querySelector(".email");
const inputPassword = document.querySelector(".password");

loginBtn.addEventListener('click', () => {
  modalBox.classList.toggle('show');
});

var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");

var body = document.querySelector("body");

btnSignin.addEventListener("click", function() {
  body.className = "sign-in-js";
});

btnSignup.addEventListener("click", function() {
  body.className = "sign-up-js";
});

function signUp() {
  fetch("http://localhost:8080/user",
    {
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json"
      },
      method: "POST",
      body: JSON.stringify({
        user: inputUser.value,
        email: inputEmail.value,
        password: inputPassword.value
      })
    })
}
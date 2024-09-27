const loginBtn = document.getElementById('login-btn');
const modalBox = document.getElementById('modal-box');

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
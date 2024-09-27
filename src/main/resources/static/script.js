const loginBtn = document.getElementById('login-btn');
const modalBox = document.getElementById('modal-box');

const inputName = document.getElementById('name');
const inputEmail = document.getElementById('email');
const inputPassword = document.getElementById('password');

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

document.addEventListener('DOMContentLoaded', function(){
  // Create a new user
  async function createUser() {
    try {
      const response = await fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          name: inputName.value,
          email: inputEmail.value,
          password: inputPassword.value
        })
      });
      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error('Error:', error);
    }
  }

  async function login() {
    try {
      const response = await fetch('http://localhost:8080/user/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          email: inputEmail.value,
          password: inputPassword.value
        })
      });
      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error('Error:', error);
    }
  }

  document.getElementById('signupbtn').addEventListener('click', createUser);
  document.getElementById('signinbtn').addEventListener('click', login);
});
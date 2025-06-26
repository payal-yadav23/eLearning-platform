document.querySelector("form").addEventListener("submit", function (e) {
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value;

  if (!email || !password) {
    alert("Please enter both email and password.");
    e.preventDefault();
  }

  if (password.length < 6) {
    alert("Password must be at least 6 characters.");
    e.preventDefault();
  }
});

document.querySelector("form").addEventListener("submit", function (e) {
  const fullname = document.getElementById("fullname").value.trim();
  const email = document.getElementById("email").value.trim();
  const age = document.getElementById("age").value;
  const dob = document.getElementById("dob").value;
  const password = document.getElementById("password").value;
  const gender = document.querySelector('input[name="gender"]:checked');
  const terms = document.querySelector('input[type="checkbox"]:checked');

  if (!fullname || !email || !age || !dob || !password || !gender || !terms) {
    alert("Please fill out all required fields.");
    e.preventDefault();
  }

  if (password.length < 6) {
    alert("Password must be at least 6 characters.");
    e.preventDefault();
  }
});

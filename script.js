particlesJS("particles-js", {
  particles: {
    number: { value: 80 },
    size: { value: 3 },
    color: { value: "#00adb5" },
    line_linked: {
      enable: true,
      distance: 150,
      color: "#00adb5",
      opacity: 0.4,
      width: 1
    },
    move: { enable: true, speed: 2 }
  },
  interactivity: {
    detect_on: "canvas",
    events: {
      onhover: { enable: true, mode: "repulse" }
    }
  },
  retina_detect: true
});

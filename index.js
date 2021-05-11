let choice = document.querySelectorAll(".choice");
let i;

for (i = 0; i < choice.length; i++) {
  choice[i].addEventListener("mouseenter", (e) => {
    let x = e.target;
    let text = x.textContent;

    if (x.classList.contains("choice")) {
      let original = x.firstChild.nextElementSibling.classList[1];

      let change = x.firstChild.nextElementSibling.classList.remove(original);
      change = x.firstChild.nextElementSibling.classList.add("fa-heart");

      x.addEventListener("mouseleave", (e) => {
        change = x.firstChild.nextElementSibling.classList.remove("fa-heart");
        change = x.firstChild.nextElementSibling.classList.add(original);
      });
    }
  });
}

const fight = document.querySelector(".fight");
const act = document.querySelector(".act");
const item = document.querySelector(".item");
const mercy = document.querySelector(".mercy");
let reply = document.querySelector(".message");

fight.addEventListener("click", () => {
  let one = "you're gonna have a bad time";
  let two = "YOU! WILL! NEVER! SPARE ME!";
  let three = "In this world, it's kill or be killed.";
  let four = " But it refused.";
  let five = "* But nobody came.";
  let messages = [one, two, three, four, five],
    message = messages[Math.floor(Math.random() * messages.length)];

  reply.textContent = message;
});

act.addEventListener("click", () => {
  let one =
    "Oh. My god. I didn't expect you to show up so soon! I haven't showered, I'm barely dressed, it's all messy, and...";
  let two = "OOOOOOOHHHHHHH YYYYEEEEAAAAAAA!!!!!!!!!!";
  let three = "HOI! I'm TEMMIE!";
  let four =
    "You struggle to escape the web. Muffet covers her mouth and giggles at you.";
  let five = "THIS WAS ANOTHER DECISIVE VICTORY FOR PAPYRUS!!";
  let messages = [one, two, three, four, five],
    message = messages[Math.floor(Math.random() * messages.length)];

  reply.textContent = message;
});

item.addEventListener("click", () => {
  let one = "Your items fill up with dreams.";
  let two = "You kept holding on. DAMAGE reduced!";
  let three = "NYEH HEH HEH HEH!";
  let four = "You ate the rock candy.";
  let five = "tem learn MANY THINs, learn to sell new item, yayA!!!";
  let messages = [one, two, three, four, five],
    message = messages[Math.floor(Math.random() * messages.length)];

  reply.textContent = message;
});

// mercy.addEventListener("click", () => {
//   let one = "You never gained any LOVE, but you gained love.";
//   let two = "Don't kill and don't be killed, alright?";
//   let three = "Human... It was nice to meet you. Goodbye.";
//   let four = "Frisk... I... I understand if you can't forgive me.";
//   let five = "It's time for monsters... To finally go free.";
//   let messages = [one, two, three, four, five, "...", "", "???"],
//     message = messages[Math.floor(Math.random() * messages.length)];

//   reply.textContent = message;
// });

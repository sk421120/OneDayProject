document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav#main_nav");

  nav.addEventListener("click", (e) => {
    let tagName = e.target.tagName;
    let urlPath = `${rootPath}`;

    if (tagName === "LI") {
      let menuText = e.target.textContent;

      if (menuText === "HOME") {
        urlPath += `/`;
      } else if (menuText === "학생정보") {
        urlPath += `/student`;
      } else if (menuText === "성적일람표") {
        urlPath += `/stscore`;
      } else if (menuText === "로그인") {
        urlPath += `/member/login`;
      } else if (menuText === "로그아웃") {
        urlPath += `/member/logout`;
      }

      location.href = urlPath;
    }
  });
});
document.addEventListener("DOMContentLoaded", ()=> {
    
  document.querySelector("button#btn_update").addEventListener("click", (e)=>{
    location.href=`${rootPath}/student/update?st_num=`+st_num;
  });

  document.querySelector("button#btn_insert").addEventListener("click", (e)=>{
    location.href=`${rootPath}/stscore/insert?st_num=`+st_num;
  });

})
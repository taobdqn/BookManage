
function checkAll(){
	 var bookname=$("#bookname").val();
	 var bookauthor=$("#bookauthor").val();
	 var buytime=$("#buytime").val();
	 
	 
	 var reg=/^\d{4}-\d{1,2}-\d{1,2}$/;
	  var byte=$("select").val();
	  
	 if(bookname==""||bookauthor==""||buytime==""){
		 alert("图书名称,图书作者,购买日期不能为空!");
		 return false;
	 }else if(byte==3){
		 alert("请选择所属分类!");
		 return false;
	 }else if(reg.test(buytime)==false){
		 alert("日期格式不正确！");
			return false;
	 }
	 return true;
};
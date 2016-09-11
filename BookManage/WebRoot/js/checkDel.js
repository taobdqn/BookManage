function chDel(){
	var id=document.getElementById("id").innerHTML;
	var falg=confirm("确定删除?");
	if(falg==false){
		return;
	}
	else{
		location.href="DelBook?id="+id;
	}
	
}
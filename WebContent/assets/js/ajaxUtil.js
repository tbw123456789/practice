
/**
 * 
 * @param method  请求方式  get或post
 * @param url    请求地址   只能写纯地址    xxxServlet  后面不能跟参数
 * @param params   传输给服务器的参数   键=值&键=值...
 * @param handle200  接收完数据之后执行的函数  形参会接收到实参 request.responseText
 * @param asyn    同步异步 传boolean   不传或传错默认异步
 */
function ajax(method,url,params,handle200,asyn){
	//先给地址拼接上防缓冲的参数
	url=url+"?"+new Date().getTime();  
	if(method==="get"){
		url=url+"&"+params;
	}
	
	//创建请求对象
	var request;
	if(window.XMLHttpRequest){
		request=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		request=new ActiveXObject("Msxml2.XMLHTTP");
	}
	
	//发出请求
	if(typeof asyn==="boolean"){
		request.open(method,url,asyn);
	}else{
		request.open(method,url);
	}
	
	//监听响应的状态
	request.onreadystatechange=function(){
		var state=request.readyState;
		//只有状态为4才是接收数据
		if(state==4){
			//状态码  200才是一切正常
			var status=request.status;
			if(status==200){
				//接收服务器write的数据
				var data=request.responseText;
				if(typeof handle200=="function"){
					handle200(data);
				}
			}
		}
	}
	//给请求带上参数
	if(method==="post"){
		request.setRequestHeader("content-type","application/x-www-form-urlencoded");
		request.send(params);
	}else{
		request.send(null);
	}
}
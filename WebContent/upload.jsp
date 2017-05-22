<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#upload_file").change(function(){
       	 if($("#upload_file").val() != '') $("#submit_form").submit();
   	    });
    });


</script>

<style>
  #uploadImg{ font-size:12px; overflow:hidden; position:absolute}
  #upload_file{ position:absolute; z-index:100; margin-left:-180px; font-size:60px;opacity:0;filter:alpha(opacity=0); margin-top:-5px;}
</style>
</head>
<body>
<h1>文件上传</h1>
<form action="form" method="post">
     描述：<input type="text" name="desc" id="desc" value="${url}"/> 
   <input type="submit" value="提交"/>
</form>
   <form id="form" action="upload" method="post" enctype="multipart/form-data">  
<!--      最简单的文件上传：<input type="file" name="fileupload" id="file" value="上传文件"/>  
       <input type="button" id="btn" value="上传图片" onclick="GetFile();"/>  --> 
<!--        	<span id="uploadImg">
		<input type="file" id="file" size="1"/>
	    <button>上传图片</button></span> -->
    </form>
    
    <form id="submit_form" method="post" action="upload" enctype="multipart/form-data">
        <input type="file" name="upload_file" id="upload_file">        <!-- 添加上传文件 -->
        <button>上传图片</button>
        <!-- <input type="submit" value="提交"/> -->
    </form>
    


<!--     
    <input type="file" value="上传文件" id="file" />
    <input type="button" id="btn" value="上传文件" onclick="GetFile();" />  -->
</body>
</html>
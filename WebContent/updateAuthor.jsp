<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle_add.css">
<title>更新作者信息</title>
</head>
<body>
<h3>更新作者信息</h3>
        <s:form action="updateAuthorResult" theme="simple">
 <table align="center">
        <tr>
<td>ID：</td><td>  <s:textfield required = "true" name="AuthorID" readonly = "true"/></td>
</tr>
<tr>
<td>姓名：</td><td> <s:textfield required = "true" name="Name" /></td>
</tr>
<tr>
<td>年龄：</td><td> <s:textfield required = "true" name="Age" /></td>
</tr>
<tr>
<td>国籍：</td><td> <s:textfield required = "true" name="Country" /></td>
</tr>
         </table><br/><br/>
            <s:submit value="确  定"  class="button"/>
        </s:form>
        
        <a href = "showAllAuthors.action">返回上一页</a>

</body>
</html>
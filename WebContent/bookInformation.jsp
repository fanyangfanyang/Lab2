<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle_show.css">
<title>书籍信息   and 作者信息</title>
</head>
<body style="margin-top:150px">
<h3>书籍信息     and 作者信息</h3>
<table border = "1" align="center" >
  <tr>
    <td>书名：</td><td><s:property value = "Tittle" /></td>
    <td>作者姓名：</td><td><s:property value = "Writer.Name" /></td>
  </tr>
  <tr>
    <td>作者ID:</td><td><s:property value = "AuthorID" /></td>
    <td>作者ID:</td><td><s:property value = "AuthorID" /></td>
  </tr>
  <tr>
    <td>ISBN:</td><td><s:property value = "ISBN" /></td>
    <td>作者年龄：</td><td><s:property value = "Writer.Age" /></td>
   </tr>
   <tr>
    <td>出版社：</td><td><s:property value = "Publisher" /></td>
    <td>作者国籍：</td><td><s:property value = "Writer.Country" /></td>
   </tr>
   <tr>
     <td>出版日期：</td><td><s:property value = "PublishDate" /></td>
   </tr>
   <tr>
     <td>价格：</td><td><s:property value = "Price" /></td>
   </tr>
</table>
<br/>
<a href = "showAllBooks.action">返回上一页</a>

</body>
</html>
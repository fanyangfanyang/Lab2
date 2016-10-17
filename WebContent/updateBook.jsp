<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle_add.css">
<title>更新书籍信息</title>
</head>
<body>
<h3>更新书籍信息</h3>
        <s:form action="updateBookResult" theme="simple">
 <table align="center">
 <tr>    
 <td>  ISBN：</td><td> <s:textfield required = "true" name="ISBN" readonly="true" /></td>
 </tr>
 <tr>
 <td>  书名：  </td><td><s:textfield required = "true" name="Tittle" /></td>
 </tr>
 <tr>
  <td> 作者：</td><td> <s:textfield required = "true" name="AuthorID" /></td>
  </tr>
  <tr>
  <td> 出版社：</td><td> <s:textfield required = "true" name="Publisher" /></td>
  </tr>
  <tr>
  <td>  出版日期：</td><td> <s:textfield required = "true" name="PublishDate" /></td>
  </tr>
  <tr>
   <td> 价格： </td><td><s:textfield required = "true" name="Price" /></td>
   </tr>
</table>
 <br/>
            <s:submit value="确  定"  class="button"/>
        </s:form>

        <a href = "showAllBooks.action">返回书目</a>

</body>
</html>
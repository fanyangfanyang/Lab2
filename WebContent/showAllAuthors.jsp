<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle_show.css">
<title>所有作者</title>
</head>
<body>
<h3>所有作者</h3>
    <table border = "1" align="center">
        <tr>
        <td align="center">作者ID</td>
        <td align="center">姓名</td>
        <td align="center">年龄</td>
        <td align="center">国籍</td>
        <td align="center">操作</td>
        </tr>
        <tr>
        <s:iterator  value = "AllAuthors">
        <tr>
          <td>
          <s:property value = "AuthorID" />
          </td>
          <td>
          <s:property value = "Name" />
          </td>
          <td>
          <s:property value = "Age" />
          </td>
          <td>
          <s:property value = "Country" />
          </td>
          <td>
          <a href = "updateAuthor.action?AuthorID=<s:property value = "AuthorID" />">编辑</a>
          </td>
          </tr>          
        </s:iterator>
        </tr>
        </table>
        <br/>
        <a href = "index.jsp">返回首页</a>
</body>
</html>
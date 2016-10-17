
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle_show.css">
<title><s:property value = "Name"/>的所有作品</title>
</head>
<body style="margin-top:100px">
<h3><s:property value = "Name"/>的所有作品如下表所示：</h3>
    <table border = "1" align="center">
        <tr>
        <td align="center">ISBN</td>
        <td align="center">书名</td>
        <td align="center">作者ID</td>
        <td align="center">操作</td>
        </tr>
        <tr>
        <s:iterator  value = "Works">
        <tr>
          <td>
          <s:property value = "ISBN" />
          </td>
          <td>
          <s:property value = "Tittle" />
          </td>
          <td>
          <s:property value = "AuthorID" />
          </td>
          <td>
          <a href = "updateBook.action?ISBN=<s:property value = "ISBN" />">编辑</a>
          </td>
          </tr>          
        </s:iterator>
        </tr>
    </table>
    <br/>
        <a href = "index.jsp">返回首页</a>
</body>
</html>
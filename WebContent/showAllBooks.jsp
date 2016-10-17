<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="myStyle_show.css">
        <title>所有图书</title>
    </head>
    <body>
    <h3>所有图书</h3>
        <table  align="center" border="1">
        <tr>
        </tr>
        <tr>
        <td align="center">ISBN</td>
        <td align="center">书名</td>
        <td align="center">作者ID</td>
        <td align="center">操作</td>
        </tr>
        <tr>
        <s:iterator  value = "AllBooks">
        <tr>
          <td>
          <s:property value = "ISBN" />
          </td>
          <td>
          <a href= "bookInformation.action?ISBN=<s:property value = "ISBN" />"><s:property value = "Tittle" /></a>
          </td>
          <td>
          <s:property value = "AuthorID" />
          </td>
          <td>
          <a href = "updateBook.action?ISBN=<s:property value = "ISBN" />">编辑</a>
          / <a href = "deleteBook.action?ISBN=<s:property value = "ISBN" />">删除</a>
          </td>
          </tr>          
        </s:iterator>
        </tr>
        </table>
        <br/>
        <a href = "index.jsp">返回首页</a>
    </body>
</html>
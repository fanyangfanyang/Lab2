
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="myStyle_add.css">
        <title>搜索作者</title>
    </head>
    <body>
        <h3>搜索某位作家的所有作品 </h3>
        <s:form action="searchAuthorResult" theme="simple">
                                作家姓名：<br/><br/><s:textfield required = "true" name="Name"  
                                cssStyle=" size:10px; width:145px;height:30px"
                                />
                                <br/><br/>
            <s:submit value="确  定" class="button"/>
        </s:form>
        <a href = "index.jsp">返回首页</a>
    </body>
</html>
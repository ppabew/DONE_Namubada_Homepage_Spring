<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <html>
    <head>
    </head>
    <body>
    <form action="/updateBoard.do?num=${board.num}" method="post">
        <table border="1" width="70%">
            <tr>
                <td width="70" align="center">이름</td>
                <td width="330">${board.writer}</td>
            </tr>
            <tr>
                <td align="center">Email</td>
                <td><input type="text" name="email" value="${board.email}"></td>
            </tr>
            <tr>
                <td align="center">제목</td>
                <td><input type="text" name="subject" style="width: 95%;" value="${board.subject}"></td>
            </tr>
            <tr>
                <td align="center">내용</td>
                <td><textarea name="content" style="width: 95%;height: 200px;">${board.content}</textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="글수정">
                    <input type="button" value="글목록" onclick="window.location='/getListBoard.do'">
                </td>
            </tr>
        </table>
    </form>
    </body>
    </html>
<%@include file="/indexBottom.jsp" %>
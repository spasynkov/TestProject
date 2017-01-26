<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet"
              type="text/css"
              href="<s:url value="/resources/styles.css" />" >
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<c:url value="/resources/scripts.js"/>"></script>
    </head>

    <body>
        <div id="header">
            <t:insertAttribute name="header" />
        </div>

        <div id="content">
            <t:insertAttribute name="body" />
        </div>

        <div id="footer">
            <t:insertAttribute name="footer" />
        </div>
    </body>
</html>
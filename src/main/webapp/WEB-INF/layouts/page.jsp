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

    <body class="rounded-corners-large"<%
        if (request.getAttribute("javax.servlet.forward.request_uri").toString().contains("/jobs/apply/"))
            out.print(" onload=\"makeLabels()\"");%>>
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

<% if (request.getAttribute("javax.servlet.forward.request_uri").toString().contains("/jobs/apply/")) {
    out.print("<script>\n" +
            "    document.getElementById(\"file-upload\").onchange = function () {\n" +
            "        if (this.value == \"\") {\n" +
            "            document.getElementById(\"label-for-file-upload\").innerHTML = \"UPLOAD\";\n" +
            "        } else {\n" +
            "            document.getElementById(\"label-for-file-upload\").innerHTML = this.value.split( '\\\\' ).pop();\n" +
            "        }\n" +
            "    };\n" +
            "</script>");
} %>
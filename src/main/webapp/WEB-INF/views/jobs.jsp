<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <div class="header rounded-corners-large add-some-space">JOBS LIST</div>
            <ul class="main-area rounded-corners-large add-some-space">
                <img class="add-some-space" src="<c:url value="/resources/images/up.png"/>" alt="Scroll up" title="Scroll up" />
                <c:forEach items="${jobsList}" var="job">
                    <li class="jobs-list rounded-corners-large">
                        <c:out value="${job.description}" />
                        <a href="/jobs/apply/<c:out value="${job.id}" />" id="apply-button" class="rounded-corners-medium">apply</a>
                    </li>
                </c:forEach>
                <img class="add-some-space" src="<c:url value="/resources/images/down.png"/>" alt="Scroll down" title="Scroll down" />
            </ul>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <h3>Jobs list:</h3>
            <ul>
              <c:forEach items="${jobsList}" var="job">
                  <li>
                      <c:out value="${job.id}" />:
                      <a href="/jobs/apply/<c:out value="${job.id}" />"><c:out value="${job.description}" /></a>
                  </li>
              </c:forEach>
            </ul>
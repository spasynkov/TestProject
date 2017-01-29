<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <div class="admin-header rounded-corners-medium add-some-space">MANAGE JOBS</div>

            <c:if test="${job != null}"><div class="notification rounded-corners-medium add-some-space">
                <p>Job "<c:out value="${job.description}" />" (<c:out value="${job.id}" />) deleted!</p>
            </div></c:if>

            <div id="edit-jobs" class="admin-main-area rounded-corners-medium">
                <form id="jobs-form">
                    <table>
                        <tr>
                            <td>Id: </td>
                            <td id="admin-edit-jobs-form-id" class="rounded-corners-small"></td>
                        </tr>

                        <tr>
                            <td>Description: </td>
                            <td><input id="admin-edit-jobs-form-description" type="text" value=""></td>
                        </tr>
                    </table>
                    <input id="add-button" type="button" value="Add">
                    <input id="save-button" type="button" value="Save">
                    <input id="clear-button" type="button" value="Clear" onclick="clearJobsForm()">
                </form>
            </div>

            <div id="admin-jobs-list" class="admin-main-area rounded-corners-medium">
                <table>
                    <tr>
                        <td>Id</td>
                        <td>Description</td>
                        <td>Delete</td>
                    </tr>
                    <c:forEach items="${jobs}" var="job">
                        <tr>
                            <td><c:out value="${job.id}" /></td>
                            <td><a href="#" onclick="populateJobsForm(<c:out value="${job.id}" />,
                                    '<c:out value="${job.description}" />')">
                                <c:out value="${job.description}" /></a></td>
                            <td>
                                <a href="<c:url value="/admin/jobs/delete/${job.id}"/>">
                                    <img id="delete" src="<c:url value="/resources/images/delete.png"/>"
                                         alt="Delete" title="Delete">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test="${job != null}"><div class="notification">
                <p>Job "<c:out value="${job.description}" />" (<c:out value="${job.id}" />) deleted!</p>
            </div></c:if>
            <div id="editJobs">
                <h3>Edit form</h3>
                <form id="jobsForm">
                    <table>
                        <tr>
                            <td><b>Id: </b></td>
                            <td><input id="jobsFormId" type="text" value=""></td>
                        </tr>

                        <tr>
                            <td><b>Description: </b></td>
                            <td><input id="jobsFormDescription" type="text" value=""></td>
                        </tr>
                    </table>
                    <input id="addBtn" type="button" value="Add">
                    <input id="saveBtn" type="button" value="Save">
                    <input id="clearBtn" type="button" value="Clear" onclick="clearJobsForm()">
                </form>
            </div>

            <div class="list">
                <h3>Jobs:</h3>
                <table>
                    <tr>
                        <td><b>Id</b></td>
                        <td><b>Description</b></td>
                        <td><b>Edit</b></td>
                        <td><b>Delete</b></td>
                    </tr>
                    <c:forEach items="${jobs}" var="job">
                    <tr>
                        <td><c:out value="${job.id}" /></td>
                        <td><c:out value="${job.description}" /></td>
                        <td>
                            <a href="#" onclick="populateJobsForm(
                                    <c:out value="${job.id}" />,
                                    '<c:out value="${job.description}" />')">
                                <img id="edit" src="<c:url value="/resources/images/edit.png"/>"
                                     alt="Edit" title="Edit">
                            </a>
                        </td>

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
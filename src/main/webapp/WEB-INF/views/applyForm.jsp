<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
            <div class="header rounded-corners-large add-some-space">REGISTER</div>
            <sf:form method="post" id="apply-form" modelAttribute="appliant" enctype="multipart/form-data" cssClass="main-area rounded-corners-large add-some-space">
                <table>
                    <tr>
                        <td><sf:input id="firstname"
                                onblur="displayLabel(this, 'first name')" onfocus="hideLabel(this, 'first name')"
                                path="firstname" cssErrorClass="error" cssClass="rounded-corners-medium" /></td>
                        <td><sf:errors path="firstname" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td><sf:input id="lastname"
                                onblur="displayLabel(this, 'last name')" onfocus="hideLabel(this, 'last name')"
                                path="surname" cssErrorClass="error" cssClass="rounded-corners-medium" /></td>
                        <td><sf:errors path="surname" cssClass="error" /></td>
                    </tr>

                    <tr>
                        <td><sf:input id="email"
                                onblur="displayLabel(this, 'email')" onfocus="hideLabel(this, 'email')"
                                path="email" type="email" cssErrorClass="error" cssClass="rounded-corners-medium" /></td>
                        <td><sf:errors path="email" cssClass="error" /></td>
                    </tr>

                    <tr>
                        <td><sf:textarea id="description"
                                onblur="displayLabel(this, 'description')" onfocus="hideLabel(this, 'description')"
                                path="description" cssErrorClass="error" cssClass="rounded-corners-medium" /></td>
                        <td><sf:errors path="description" cssClass="error" /></td>
                    </tr>

                    <tr>
                        <td id="file-row"><p>CV file:</p>
                            <input id="file-upload" type="file" name="cv" accept="image/jpeg,image/png,image/gif" />
                            <label id="label-for-file-upload" for="file-upload"
                                   class="rounded-corners-medium">UPLOAD</label></td>
                    </tr>
                </table>
                <input id="submit" type="submit" value="SEND APPLICATION" class="rounded-corners-medium" />

                <c:if test="${appliant.id == null}" >
                    <sf:errors path="*" element="div" cssClass="error" />
                </c:if>
            </sf:form>
<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Source</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/master/enquiry/source/add" class="btn btn-primary" title="Add Enquiry Source">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<table class="table table-hover">
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Color</th>
</thead>
<tbody>
    <c:forEach var="source" items="${sources}">
        <tr>
            <td>${source.id}</td>
            <td>${source.name}</td>
            <td style="background: ${source.color}">${source.color}</td>
            <td>
                <a href="${SITE_URL}/admin/master/enquiry/source/edit/${source.id}" class="btn btn-success btn-xs" title="Edit Enquiry Source">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
                <a href="${SITE_URL}/admin/master/enquiry/source/delete/${source.id}" class="btn btn-danger btn-xs" title="Delete Enquiry Source">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<%@include file="../../shared/footer.jsp" %>
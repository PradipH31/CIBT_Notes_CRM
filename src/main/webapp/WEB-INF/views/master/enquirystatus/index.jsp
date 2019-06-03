<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Status</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/master/enquiry/status/add" class="btn btn-primary" title="Add Enquiry Source">
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
    <c:forEach var="record" items="${records}">
        <tr>
            <td>${record.id}</td>
            <td>${record.name}</td>
            <td style="background: ${record.color}">${record.color}</td>
            <td>
                <a href="${SITE_URL}/admin/master/enquiry/status/edit/${record.id}" class="btn btn-success btn-xs" title="Edit Enquiry Source">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
                <a href="${SITE_URL}/admin/master/enquiry/status/delete/${record.id}" class="btn btn-danger btn-xs" title="Delete Enquiry Source">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<%@include file="../../shared/footer.jsp" %>
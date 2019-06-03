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

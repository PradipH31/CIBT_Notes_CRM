<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="javascript:void(0)" data-id="${record.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry Source">
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
<script>
    $(".edit-btn").on('click', function () {
        let $id = $(this).attr('data-id');
        $.getJSON('${pageContext.request.contextPath}/admin/master/enquiry/status/' + $id, function (data) {
            $('#status-id').val(data.id);
            $('#status-name').val(data.name);
            $('#status-color').val(data.color);
            let $dialog = $("#status-dialog");
            $dialog.find('.modal-title').html('Edit Enquiry Status');
            $dialog.modal();
        });
    });
</script>
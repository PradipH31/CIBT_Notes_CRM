<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box">
    <div class="box-header with-header">
        <h3 class="box-title">
            <a href="javascript:void(0)" id="add-btn" class="btn btn-primary" title="Add Enquiry Source">
                <span class="glyphicon glyphicon-plus"></span>
            </a>
        </h3>
        <div class="box-tools">
            <div class="input-group input-group-sm" style="width: 150px;">
                <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                </div>
            </div>
        </div>
    </div>
    <!-- /.box-header -->
    <div class="box-header with-border">
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
                            <a href="javascript:void(0)" data-id="${source.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry Source">
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
    </div>
</div>
<script>
    $(".edit-btn").on('click', function () {
        let $id = $(this).attr('data-id');
        $.getJSON('${pageContext.request.contextPath}/admin/master/enquiry/source/' + $id, function (data) {
            $('#source-id').val(data.id);
            $('#source-name').val(data.name);
            $('#source-color').val(data.color);
            let $dialog = $("#source-dialog");
            $dialog.find('.modal-title').html('Edit Enquiry Source');
            $dialog.modal();
        });
    });
    $("#add-btn").on('click', function () {
        let $dialog = $("#source-dialog");
        $dialog.find('.modal-title').html('Add Enquiry Source');
        $dialog.modal();
        $('input').val('');
        $('#source-id').val(0);
    });
</script>
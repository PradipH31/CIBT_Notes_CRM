<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box">
    <div class="box-header with-header">
        <h3 class="box-title"><a href="javascript:void(0)" id="add-btn" class='btn btn-primary btn-xs' title="Add Enquiry Status">
                <span class='glyphicon glyphicon-plus'></span>
            </a></h3>

        <div class="box-tools">
            <div class="input-group input-group-sm" style="width: 150px;">
                <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body table-responsive no-padding">
        <table class='table table-hover'>
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
                        <td style="background-color: ${record.color}">${record.color}</td>
                        <td>
                            <a href="javascript:void(0)" data-id="${record.id}" class='edit-btn btn btn-success btn-xs' title="Edit Enquiry Status">
                                <span class='glyphicon glyphicon-pencil'></span>
                            </a>
                            <a href="${SITE_URL}/admin/master/followup/status/delete/${record.id}" class='btn btn-danger btn-xs' title="Delete Enquiry Status">
                                <span class='glyphicon glyphicon-trash'></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    $("#add-btn").on('click', function () {
        let $dialog = $("#status-dialog");
        $dialog.find('.modal-title').html('Add Followup Status');
        $dialog.modal();
        $('input').val('');
        $("#status-id").val(0);
    });
    $(".edit-btn").on('click', function () {
        let $id = $(this).attr('data-id');
        $.getJSON('${pageContext.request.contextPath}/admin/master/followup/status/' + $id, function (data) {
            $("#status-id").val(data.id);
            $("#status-name").val(data.name);
            $("#status-color").val(data.color);
            let $dialog = $("#status-dialog");
            $dialog.find('.modal-title').html('Edit Enquiry Source');
            $dialog.modal();
        });
    });
</script>
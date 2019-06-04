<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiries</h1>
</div>
<div class="box">
    <div class="box-header with-header">
        <h3 class="box-title">
            <a href="javascript:void(0)" id="add-btn" class="btn btn-primary" title="Add Enquiry Status">
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
            <th>Email</th>
            <th>Contact No</th>
            <th>Enquiry Date</th>
            <th>Enquiry Source</th>
            <th>Enquiry Status</th>
            <th>Action</th>
            <th>Visited</th>
            <th>Follow</th>
            </thead>
            <tbody>
                <c:forEach var="enquiry" items="${enquiries}">
                    <tr>
                        <td>${enquiry.id}</td>
                        <td>${enquiry.firstName} ${enquiry.lastName}</td>
                        <td>${enquiry.email}</td>
                        <td>${enquiry.contactNo}</td>
                        <td>${enquiry.createdDate}</td>
                        <td>
                            <label class="label" style="background: ${enquiry.source.color}">
                                ${enquiry.source.name}
                            </label>
                        </td>
                        <td>
                            <label class="label" style="background: ${enquiry.status.color}">
                                ${enquiry.status.name}
                            </label>
                        </td>
                        <td>
                            <a href="javascript:void(0)" data-id="${enquiry.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <a href="${SITE_URL}/admin/master/enquiry/source/delete/${enquiry.id}" class="btn btn-danger btn-xs" title="Delete Enquiry">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${enquiry.visited}">
                                    Visited
                                </c:when>
                                <c:otherwise>
                                    <a href="">Make Visited</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="javascript:void(0)" data-id="${enquiry.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry">
                                <span class="glyphicon glyphicon-plus"></span>
                            </a>
                            <a href="${SITE_URL}/admin/master/enquiry/source/delete/${enquiry.id}" class="btn btn-danger btn-xs" title="Delete Enquiry">
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
        $.getJSON('${pageContext.request.contextPath}/admin/master/enquiry/status/' + $id, function (data) {
            $('#status-id').val(data.id);
            $('#status-name').val(data.name);
            $('#status-color').val(data.color);
            let $dialog = $("#status-dialog");
            $dialog.find('.modal-title').html('Edit Enquiry Status');
            $dialog.modal();
        });
    });
    $("#add-btn").on('click', function () {
        let $dialog = $("#status-dialog");
        $dialog.find('.modal-title').html('Add Enquiry Status');
        $dialog.modal();
        $('input').val('');
        $('#status-id').val(0);
    });
</script>
<%@include file="../../shared/footer.jsp" %>
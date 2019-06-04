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
            <th>Color</th>
            </thead>
            <tbody>
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
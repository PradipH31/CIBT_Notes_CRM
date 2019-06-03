<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Source</h1>
</div>
<div class="pull-right">
    <p>
        <a href="javascript:void(0)" id="add-btn" class="btn btn-primary" title="Add Enquiry Source">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>
<div class="view-content"></div>
<div id="source-dialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"></h4>
            </div>
            <form id="source-form" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="name" required="required" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Color</label>
                        <input type="text" name="color" required="required" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    <button type="button" id="save-btn" class="btn btn-success">Save</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    $(document).ready(function () {
        var $content = $('#view-content').html('<h1>Loading...</h1>');
        $.get('${SITE_URL}/admin/master/enquiry/source/table', function (data) {
            $content.html(data);
        });
        $("#add-btn").on('click', function () {
            let $dialog = $("#source-dialog");
            $dialog.find('.modal-title').html('Add Enquiry Source');
            $dialog.modal();
        });
        $("#source-form").on('submit', function () {
            $.ajax({
                url: '${SITE_URL}/admin/master/enquiry/source/save',
                method: 'post',
                data: $("#source-form").serialize(),
                success: function (resp) {
                    if (resp) {
                        //$('#source-dialog').modal('hide');
                        window.location = '${SITE_URL}/admin/master/enquiry/source;'
                    }
                }
            });
            return false;
        });
    });
</script>
<%@include file="../../shared/footer.jsp" %>
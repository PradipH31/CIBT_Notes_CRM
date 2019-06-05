<div class="modal fade" id="followup-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <form id="status-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="statusId">FollowUp Status</label>
                        <select name="statusId" id="statusId" class="form-control">
                            <option value="">Select Status</option>
                        </select>
                    </div<>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input id="status-name" type="text" name="name" required="required" class="form-control">
                </div>
                <div class="form-group">
                    <label>Color</label>
                    <input id="status-color" type="text" name="color" required="required" class="form-control">
                </div>
        </div>
        <div class="modal-footer">
            <input type="hidden" id="status-id" name="id" value="">
            <%@include file="../../../shared/components/form-button.jsp" %>
        </div>
        </form>
    </div>
</div>
</div> 
<script>
    function loadComboData(params) {
        $.ajax({
            method: 'get',
            url: params.url,
            dataType: 'json',
            success: function (data) {
                var $el = $(params.el);
                $el.find('option').remove();
                $el.append($("<option/>").val('').text(params.title));
                $.each(data, function (i, o) {
                    $el.append($("<option/>").val(o[params.col[0]]).text(o[params.col[1]]));
                });
            },
            error: function (err) {
                alert("Invalid url");
                console.log(err);
            }
        });
    }

    loadComboData({
        url: '${SITE_URL}/admin/master/followup/status/json',
        el: '#statusId',
        title: 'Select Followup Status',
        col: ['id', 'name']
    });
</script>
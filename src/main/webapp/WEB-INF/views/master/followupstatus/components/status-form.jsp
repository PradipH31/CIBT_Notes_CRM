<div class="modal fade" id="status-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <form id="status-form">
                <div class="modal-body">
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
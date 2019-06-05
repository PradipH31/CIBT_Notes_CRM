<%@include file="../../shared/header.jsp" %>
<form action="${SITE_URL}/admin/enquiries" method="post">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Add Enquiry</h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" name="firstName" required placeholder="Enter first name">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" required name="lastName" placeholder="Enter last name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="email" class="form-control" required name="email" placeholder="Enter email address">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="contactNo">Contact No</label>
                                <input type="text" class="form-control" name="contactNo" required placeholder="Enter first name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="statusId">Status</label>
                                <select name="statusId" id="statusId" class="form-control">
                                    <option value="">Select Status</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="sourceId">Source</label>
                                <select name="sourceId" id="sourceId" class="form-control">
                                    <option value="">Select Source</option>
                                </select>
                            </div<>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="contactNo">Referred By</label>
                            <input type="text" class="form-control" name="referedBy" placeholder="Enter referee">
                        </div>
                    </div>
                </div>
            </div>
            <div class="box-footer">
                <div class="pull-right">
                    <button type="submit" class="btn btn-success">
                        <span class="glyphicon glyphicon-floppy-disk"></span> Save
                    </button>
                    <a href="${SITE_URL}/admin/enquiries" class="btn btn-danger">
                        <span class="glyphicon glyphicon-arrow-left"></span> Back
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>
</form>
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

    $(document).ready(function ()
    {
        loadComboData({
            url: '${SITE_URL}/admin/master/enquiry/source/json',
            el: '#sourceId',
            title: 'Select Enquiry Source',
            col: ['id', 'name']
        });

        loadComboData({
            url: '${SITE_URL}/admin/master/enquiry/status/json',
            el: '#statusId',
            title: 'Select Enquiry Status',
            col: ['id', 'name']
        });

    });
</script>

<%@include file="../../shared/footer.jsp" %>
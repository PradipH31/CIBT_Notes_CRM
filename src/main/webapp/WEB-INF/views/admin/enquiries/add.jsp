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
                                    <c:forEach var="status" items="${statusData}">
                                        <option value="${status.id}">${status.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="sourceId">Source</label>
                                <select name="sourceId" id="sourceId" class="form-control">
                                    <option value="">Select Source</option>
                                    <c:forEach var="source" items="${sources}">
                                        <option value="${source.id}">${source.name}</option>
                                    </c:forEach>
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
<%@include file="../../shared/footer.jsp" %>
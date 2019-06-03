<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Edit Enquiry Status</h1>
    <form action="${SITE_URL}/admin/master/enquiry/status" method="post">
        <div class="form-group">
            <label>Name</label>
            <input value="${record.name}" type="text" name="name" required="required" class="form-control">
        </div>
        <div class="form-group">
            <label>Color</label>
            <input value="${record.color}" type="text" name="color" required="required" class="form-control">
        </div>
        <input type="hidden" name="id" value="${record.id}">
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${SITE_URL}/admin/master/enquiry/status">Back</a>
    </form>
</div>
<%@include file="../../shared/footer.jsp" %>
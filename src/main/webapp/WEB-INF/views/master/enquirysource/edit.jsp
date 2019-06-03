<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Edit Enquiry Source</h1>
    <form action="${SITE_URL}/admin/master/enquiry/source" method="post">
        <div class="form-group">
            <label>Name</label>
            <input value="${source.name}" type="text" name="name" required="required" class="form-control">
        </div>
        <div class="form-group">
            <label>Color</label>
            <input value="${source.color}" type="text" name="color" required="required" class="form-control">
        </div>
        <input type="hidden" name="id" value="${source.id}">
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${SITE_URL}/admin/master/enquiry/source">Back</a>
    </form>
</div>
<%@include file="../../shared/footer.jsp" %>
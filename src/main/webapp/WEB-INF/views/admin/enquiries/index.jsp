<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiries</h1>
</div>
<div class="box">
    <div class="box-header with-header">
        <h3 class="box-title"><a href="${SITE_URL}/admin/enquiries/add" id="add-btn" class='btn btn-primary btn-xs' title="Add Enquiry">
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
            <th>Email</th>
            <th>Contact No</th>
            <th>Enquiry Date</th>
            <th>Source</th>
            <th>Status</th>
            <th>Visited</th>
            <th>Follow</th>
            <th>Action</th>
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
                            <label style="background: ${enquiry.source.color}" class="label">${enquiry.source.name}</label>
                        </td>
                        <td>
                            <label for="" class="label" style="background:${enquiry.status.color}">${enquiry.status.name}</label>
                        </td>                       
                        <td>
                            <span class="visited">
                                <c:choose>
                                    <c:when test="${enquiry.visited}">
                                        Yes
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:vod(0)" class="visited-btn" data-id="${enquiry.id}" data-name="${enquiry.firstName} ${enquiry.lastName}">Set visited</a>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </td>
                        <td>
                            <a href="javascript:void(0)" data-id="${enquiry.id}" data-name="${enquiry.firstName} ${enquiry.lastName}" class='add-follow-btn btn btn-default btn-xs' title="Add Follow-Up">
                                <span class='glyphicon glyphicon-plus'></span>
                            </a>
                            <a href="${SITE_URL}/admin/master/enquiry/delete/${enquiry.id}" class='btn btn-danger btn-xs' title="Delete Enquiry">
                                <span class='glyphicon glyphicon-trash'></span>
                            </a>
                        </td>
                        <td>
                            <a href="javascript:void(0)" data-id="${enquiry.id}" class='edit-btn btn btn-success btn-xs' title="Edit Enquiry">
                                <span class='glyphicon glyphicon-pencil'></span>
                            </a>
                            <a href="${SITE_URL}/admin/master/enquiry/delete/${enquiry.id}" class='btn btn-danger btn-xs' title="Delete Enquiry">
                                <span class='glyphicon glyphicon-trash'></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="components/followup-form.jsp" %>
<script>
    $(function () {
        $('.visited-btn').on('click', function () {
            var $this = $(this);
            if (confirm('Are you sure ' + $this.attr('data-name' + 'has visited?'))) {
                var $id = $this.attr('data-id');
                $.post('${SITE_URL}/admin/enquiries/makeVisited', {id: $id}, function (data) {
                    $this.parent('span.visited').html('Yes');
                });
            }
            return false;
        });

        $('.add-follow-btn').on('click', function () {
            var $this = $(this);
            var $dialog = $('#followup-dialog');
            $dialog.find('.modal-title').html('Follow-up for ' + $this.attr('data-name'));
            $dialog.modal();
        });
    });
</script>
<%@include file="../../shared/footer.jsp" %>
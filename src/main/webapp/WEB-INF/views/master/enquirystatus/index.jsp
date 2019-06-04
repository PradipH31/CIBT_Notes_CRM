<%@include file="../../shared/header.jsp" %>
<div id="view-content"></div>
<%@include file="components/status-form.jsp" %>
<script>
    function load() {
        var $content = $('#view-content').html('<h1>Loading...</h1>');
        $.get('${SITE_URL}/admin/master/enquiry/status/table', function (data) {
            $content.html(data);
        });
    }
    $(document).ready(function () {
        load();
        $("#status-form").on('submit', function () {
            $.ajax({
                url: '${SITE_URL}/admin/master/enquiry/status/save',
                method: 'post',
                data: $("#status-form").serialize(),
                success: function (resp) {
                    if (resp) {
                        $('#status-dialog').modal('hide');
                        load();
                    }
                }
            });
            return false;
        });
    });
</script>
<%@include file="../../shared/footer.jsp" %>
<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Source</h1>
</div>
<div id="view-content"></div>
<%@include file="components/source-form.jsp" %>
<script>
    function load() {
        var $content = $('#view-content').html('<h1>Loading...</h1>');
        $.get('${SITE_URL}/admin/master/enquiry/source/table', function (data) {
            $content.html(data);
        });
    }
    $(document).ready(function () {
        load();
        console.log($("#source-form"));
        $("#source-form").on('submit', function () {
            console.log('Clicked');
            $.ajax({
                url: '${SITE_URL}/admin/master/enquiry/source/save',
                method: 'post',
                data: $("#source-form").serialize(),
                success: function (resp) {
                    if (resp) {
                        $('#source-dialog').modal('hide');
                        load();
                    }
                }
            });
            return false;
        });
    });
</script>
<%@include file="../../shared/footer.jsp" %>
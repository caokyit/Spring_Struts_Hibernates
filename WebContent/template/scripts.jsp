

<link type="text/css" href="style/Admin.css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.validate.js"></script>
<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        // tooltip();
        $('#menu ul li').hover(
        function () {
            //show its submenu
            $('ul', this).slideDown(100);

        },
        function () {
            //hide its submenu
            $('ul', this).slideUp(100);
        }
    );
    });
</script>

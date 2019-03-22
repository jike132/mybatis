
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/Jquery3.1.js" type="text/javascript"></script>
   <link rel="stylesheet" type="text/css" href="static/css/test.css">

</head>
<body>
<script type="text/javascript">
    $(document).ready(function() {
        $("p").click(function () {
            console.log("hello");
        });
        $("p").innerHTML="test"
    })
</script>
<p>gh</p>
</body>
</html>

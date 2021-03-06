<html ng-app="rollwhere">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title><@spring.message "title"/></title>
    <link rel="stylesheet" href="${rc.contextPath}/css/style.css" />
    <script src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#image").click(function(){
                    $.ajax("${rc.contextPath}/roll", {
                        async:false,
                        dataType:"json",
                        success:function(data){
                            $("#open").attr("href", data.url);
                        }
                    });
                }
            );
        });

        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?f4fe3b4af2b34fd0b8aacdc319025e9a";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body align="center">
<div id="logo">
    <img src="image/logo.png" >
</div>
<div id="tips">
    <@spring.messageArgs "tips",["${urlCount}"]/>
    <br/>
    <@spring.message "roll"/>
</div>
<div id="button">
    <a id="open" href="" target="_blank">
        <img src="image/button.png" id="image" onmouseover="this.src='image/pbutton.png'" onmouseout="this.src='image/button.png'" border="0">
    </a>
</div>
<div id="warning">
    <@spring.message "warning"/>
</div>
</body>
</html>
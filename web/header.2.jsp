
<%@ taglib prefix="s" uri="/struts-tags" %>


<header class="navbar navbar-inverse navbar-fixed-top stickyHeader">
    <div class="navbar-header" id="menu" itemscope itemtype="http://schema.org/Organization">
        <button class="navbar-toggle" data-target="navbar-collapse" data-toggle="collapse" type="button">
            <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> 
            <span class="icon-bar"></span> <span class="icon-bar"></span></button> 

        <a class="navbar-brand" itemprop="url"  href="<%=request.getContextPath()%>/home.action">
           <h1 class="heavy" style="margin-right:5px;"><font color="#fff">AP</font> <font color="#00aae7">Cloud</font> <font color="#fff">Initiative</font></h1> 
           <!-- <img class="img-responsive" itemprop="logo" alt="logo" src="<%=request.getContextPath()%>/images/apcloud_Horizontal.png" height="50px;"> -->
        </a>

    </div>
    <br>
    <!--           <img class="pull-right" itemprop="logo" alt="logo" src="http://www.miraclesoft.com/images/logo.png"> -->


    <style>
        .hed{
            text-align-last:center !important;

        }
        .navbar-fixed-top{
            top:-15px;
        }

       
            .logout {
            position: absolute;
            right: 23px;
            top: 19px;
        }
    </style>

    <div class="col-sm-6 text-right" STYLE="position: absolute; right: 34px;">
        <s:if test="%{#session.username!=null && #session.username!= ''}"> 



            <a class="heavy logout" style="color: white;vertical-align:middle;" href="<%=request.getContextPath()%>/logout.action">
                <b>  Logout</b>
            </a>

        </s:if>
        <s:else>
            <a  href="http://www.miraclesoft.com" target="blank"><img class="pull-right" itemprop="logo" alt="logo"  
                                                                      src="http://www.miraclesoft.com/images/logo.png"  /></a>
            </s:else>
    </div>  

</header>
<script>
    var cbpHorizontalMenu = (function() {

        var $listItems = $( '#cbp-hrmenu > ul > li' ),
        $menuItems = $listItems.children( 'a' ),
        $body = $( 'body' ),
        current = -1;

        function init() {
            $menuItems.on( 'mouseover', open );
            $listItems.on( 'mouseover', function( event ) { event.stopPropagation(); } );
        }

        function open( event ) {

            if( current !== -1 ) {
                $listItems.eq( current ).removeClass( 'cbp-hropen' );
            }

            var $item = $( event.currentTarget ).parent( 'li' ),
            idx = $item.index();

            if( current === idx ) {
                $item.removeClass( 'cbp-hropen' );
                current = -1;
            }
            else {
                $item.addClass( 'cbp-hropen' );
                current = idx;
                $body.off( 'mouseover' ).on( 'mouseover', close );
            }

            return false;

        }

        function close( event ) {
            $listItems.eq( current ).removeClass( 'cbp-hropen' );
            current = -1;
        }

        return { init : init };

    })();
</script>
<script type="text/javascript">
    function downloadJSAtOnload() {
        var element = document.createElement("script");
        element.src = "../js/modernizr.custom.js";
        document.body.appendChild(element);
    }
    if (window.addEventListener)
        window.addEventListener("load", downloadJSAtOnload, false);
    else if (window.attachEvent)
        window.attachEvent("onload", downloadJSAtOnload);
    else window.onload = downloadJSAtOnload;
</script>

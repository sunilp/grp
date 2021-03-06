
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@page pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <tiles:insertAttribute name="meta"/>
    <tiles:insertAttribute name="shim"/>
    <!-- Load the script "assets/js/main.js" as our entry point -->
    <script data-main="assets/js/main" src="assets/js/libs/require/require.js"></script>
  
  </head>
<body data-spy="scroll" data-target="#topMenu">
<div id="wrap">
    <div id="header">
    <tiles:insertAttribute name="header"/>
    </div>
     
       <div id="mainContent">
     
     <div id="marketingContent">
    <tiles:insertAttribute name="marketing"/>
     </div>
        
    <div id="innerContent" class="container">
      <div id="notify" class="alert alert-info" style="display:none"></div>
    
    <tiles:insertAttribute name="content"/>
    </div>
    
       </div>

</div>    
    <tiles:insertAttribute name="footer"/>
    

    
</body>

</html>
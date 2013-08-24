
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<html lang="en">
<head>
    <tiles:insertAttribute name="meta"/>
    <tiles:insertAttribute name="shim"/>
  </head>
<body>
    <div id="header">
    <tiles:insertAttribute name="header"/>
    </div>
     
    <tiles:insertAttribute name="marketing"/>
     
        
    <div class="container">
      <div id="notify" class="alert alert-info"></div>
    
    <tiles:insertAttribute name="content"/>
    
    
    <tiles:insertAttribute name="footer"/>
    
     </div>
    
</body>

</html>
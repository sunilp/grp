<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="shortcut icon" href="assets/ico/favicon.png">
    <!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
 <link href="assets/css/carousel.css" rel="stylesheet">
 
 
 
<!-- NAVBAR
================================================== -->

    <div id="topMenu" class="navbar-wrapper">
        
      <div class="container">

        <div class="navbar navbar-inverse navbar-fixed-top">
        
        
          <div class="container">
            
          
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-th-large"></span>Job Portal</a>
            </div>
            <div class="navbar-collapse collapse">
            
            
            
              <ul class="nav navbar-nav navbar-right">
              
                <li class="active"><a href="#home"><spring:message code="label.nav.home"></spring:message></a></li>
                <li><a href="#about" ><spring:message code="label.nav.about"/></a></li>
                <li><a href="#contact"><spring:message code="label.nav.contact"/></a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                	<span class="glyphicon glyphicon-cog"></span>
                  		<spring:message code="label.nav.settings"/>
					
                   <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>

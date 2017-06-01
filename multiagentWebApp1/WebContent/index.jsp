<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multi agent</title>


	<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>


    <header>
        <div class="container" id="maincontent" tabindex="-1">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="img/profile.png" alt="">
                    <div class="intro-text">
                        <h1 class="name">Multi Agent Robots</h1>
                        <hr class="star-light">
                        <span class="skills">Web-Based Control of Multi-Agent Robotic Systems</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Log-in </h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form  novalidate action="UserDologin" method="POST">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="userName">User Name</label>
                                <input type="text" class="form-control" name="username" 
                                placeholder="Name" id="name" 
                                required data-validation-required-message="Please enter your name."
                                value="${loginedUser.name}">
                                <p class="help-block text-danger"></p>
                                
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" 
                                placeholder="Password" id="password" 
                                required data-validation-required-message="Please enter your password."
                                value="${user.password}">
                                <p class="help-block text-danger">${errorString}</p>
                            </div>
                        </div>
                               
                                  <br>
                        <br>
                        <br>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <a href="forgetPassword">  Forget My Password </a>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                                   
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Submit</button>
                            </div>
                        </div>
                    </form>
                     <label >${errorString}</label>
                </div>
            </div>
        </div>
    </section>

	<jsp:include page="_footer.jsp"></jsp:include>
	
	
	
	
	
	
	    <!-- jQuery -->
    <script src="style/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="style/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="style/js/jqBootstrapValidation.js"></script>
    <script src="style/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="style/js/freelancer.min.js"></script>
	
	
	
</body>
</html>
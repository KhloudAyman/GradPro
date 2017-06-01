<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    
</head>
<body>

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">Multi-Agent Project</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                   
                    <li class="page-scroll">
                        <a href="index.jsp">Log-in</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>


	<p style="color: red;">${errorString}</p>
	<p style="color: red;">${user.email}</p>
	
	
	
	    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Forget Password </h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form novalidate action="DoForgetPassword" method="POST">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="userName">User Name</label>
                                <input type="text" class="form-control" name="username" 
                                placeholder="Name" id="name" 
                                required data-validation-required-message="Please enter your name."
                                value="${user.username}">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" name="email" 
                                placeholder="E-mail" id="email" 
                                required data-validation-required-message="Please enter your email"
                                value="${user.email}">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        
                        
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="npassword">New Password</label>
                                <input type="password" class="form-control" name="npassword" 
                                placeholder="New Password" id="npassword" 
                                required data-validation-required-message="Please enter your new password."
                                value="${user.npassword}">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        
                        
                        
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="Edit" class="btn btn-success btn-lg">Edit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
	
	
	
	
	
<!--  
	<form method="POST" action="userDologin">
		<table border="0">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${user.username}" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="${user.password}" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>
	</form>

-->



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
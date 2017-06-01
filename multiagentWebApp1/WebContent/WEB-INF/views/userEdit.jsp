<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Edit user</title>

	<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 
<p style="color: red;">${errorString}</p>
 -->


<section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                   <center>
                      <h1>Edit User</h1>
                  
                      <hr class="star-primary">
                   </center>
                </div>
            </div>
            
            <!--this is register form for any user-->
            
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    
	
                    <form name="sentMessage" id="contactForm" novalidate method="POST" action="UserDoEdit">
                        <div class="row control-group">
                            <input type="hidden" class="form-control" name="UserId"  id="UserId" value="${tempIDeditUser}">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" placeholder="Name" id="name" name="username" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="email">Email Address</label>
                                <input type="email" class="form-control" placeholder="Email Address" name ="userEmail"id="email">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="phone">Phone Number</label>
                                <input type="tel" class="form-control" placeholder="Phone Number" name="usermNumber"id="phone">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>

                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" placeholder="Password" name="userPassword" id="password" data-validation-required-message="Please enter a password.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div>
                            <div class="funkyradio">
                                <div class="funkyradio-success">
                                    <input class="radio-inline" type="radio" name="userJobDescription" value="admin" id="adminRadio" />
                                    <label  for="adminRadio">Admin</label>
                                </div>
                                <div class="funkyradio-success">
                                    <input class="radio-inline" type="radio" name="userJobDescription" value ="user" id="userRadio" />
                                    <label  for="userRadio">user</label>
                                </div>
                            </div>
                        </div>

                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Edit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            
<!--            this is the end of the user form-->
            
        </div>
    </section>



</body>
</html>
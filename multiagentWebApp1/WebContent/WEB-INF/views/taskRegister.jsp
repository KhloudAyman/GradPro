<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task</title>

	<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    
    <script
			  src="https://code.jquery.com/jquery-2.1.4.js"
			  integrity="sha256-siFczlgw4jULnUICcdm9gjQPZkw/YPDqhQ9+nAOScE4="
			  crossorigin="anonymous"></script>
    <script type="text/javascript" src="style/js/jquery-3.1.1.js"></script>
    

    
    
    
</head>
<body>

<section >
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Task Register</h2>
                    <hr class="star-primary">
                </div>
            </div>
            
            <!--                    this is register form for any user-->
            
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    
	
                    <form novalidate method="POST" action="TaskDoRegister">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="name">Task Name</label>
                                <input type="text" class="form-control" name="taskName" placeholder="Task Name" id="name" required data-validation-required-message="Please enter task name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="load">Load</label>
                                <input type="number" class="form-control" name="taskLoad" placeholder="Load" id="load">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                     <!--   <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="phone">Phone Number</label>
                                <input type="tel" class="form-control" placeholder="Phone Number" name="usermNumber"id="phone">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>

                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" placeholder="Password" name="userPassword" id="password" data-validation-required-message="Please enter a password.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div>
                            <div class="funkyradio">
                                <div class="funkyradio-success">
                                    <input class="radio-inline" type="radio" name="userJobDescription" id="admin" />
                                    <label  for="admin">Admin</label>
                                </div>
                                <div class="funkyradio-success">
                                    <input class="radio-inline" type="radio" name="userJobDescription" id="userRadio" />
                                    <label  for="userRadio">user</label>
                                </div>
                            </div>
                        </div>
 
 <div class="row control-group">
    <div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        $(document).ready(function(){
        	$(function () {
                $('#datetimepicker1').datetimepicker();
            });
        });
            
        </script>
    </div>
</div>
  </div>
  -->
                         <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="description">Task Description</label>
                                <textarea rows="5" class="form-control" name = "taskDescription" placeholder="Task Description" id="description" required data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Submit</button>
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
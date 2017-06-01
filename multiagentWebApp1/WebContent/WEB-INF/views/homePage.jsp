<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

	<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body class="index">



<div id="skipnav"><a href="#maincontent">Skip to main content</a></div>

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                
                <a class="navbar-brand" href="#page-top">${user.getname()}</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#assigntask">Task</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#robot">Robot</a>
                    </li>
                     <li class="page-scroll">
                        <a href="#portfolio">User</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#statistics">Statistics</a>
                    </li>
                    <li>
                        <a href="Logout">Log-out</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <br>
        <br>
    </header>

    <!-- Assign Task Grid Section -->
    <section id="assigntask">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Assign Task</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
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
<div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="description">Start Location X</label>
                                <input type="text" class="form-control" name="startLocationX" placeholder="Start Location X" id="startX" required data-validation-required-message="Please enter task name.">
                                <p class="help-block text-danger"></p>
                             </div>
                        </div>
                     <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="description">Start Location Y</label>
                                <input type="text" class="form-control" name="startLocationY" placeholder="Start Location Y" id="startY" required data-validation-required-message="Please enter task name.">
                                <p class="help-block text-danger"></p>
                             </div>
                        </div>
                      <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="description">End Location </label>
                                <input type="text" class="form-control" name="endLocationX" placeholder="End Location X" id="endX" required data-validation-required-message="Please enter task name.">
                                <p class="help-block text-danger"></p>
                             </div>
                        </div>
                     <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="description">End Location Y</label>
                                <input type="text" class="form-control" name="endLocationY" placeholder="End Location Y" id="endY" required data-validation-required-message="Please enter task name.">
                                <p class="help-block text-danger"></p>
                             </div>
                        </div>
<br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Assign Task</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                    </form>

            </div>
        </div>
    </section>

    <!-- Robot Section -->
    <!--
    <section class="success" id="robot">
        <div class="container">
            
            <div class="row">
                <div class="col-lg-30 text-center">
                    <h2>Robot</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <a href="robotRegistration" class="motion btn btn-lg btn-outline" > Add Robot </a>
                </div>
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <a href="#" class="motion btn btn-lg btn-outline"> Update Robot</a>
                </div>
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <a href="RobotDelete" class="motion btn btn-lg btn-outline">Delete Robot</a>
                </div>
            </div>
        </div>
    </section>
    -->
        <section id="robot">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Robots</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
            	<div class="col-sm-4 portfolio-item">
                    <a href="robotRegistration" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/add.png" class="img-responsive" alt="AddRobot">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="RobotUpdate" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/update.png" class="img-responsive" alt="UpdateRobot">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="RobotDelete" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/delete.png" class="img-responsive" alt="DeleteRobot">
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!-- User Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>User</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
            	<div class="col-sm-4 portfolio-item">
                    <a href="UserRegister" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/addUser.ico" class="img-responsive" alt="AddUser">
                    </a>
                </div>
                 <div class="col-sm-4 portfolio-item">
                    <a href="UserUpdate1" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/update.png" class="img-responsive" alt="UpdateUser">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item"></div>
                <div class="col-sm-4 portfolio-item">
                    <a href="UserDelete" class="portfolio-link" >
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/deleteUser.png" class="img-responsive" alt="DeleteUser">
                    </a>
                </div>
            </div>
        </div>
    </section>





    <!-- Footer -->
    <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        
                    </div>
                    <div class="footer-col col-md-4">
                        <div class="modal-body">
                            <h3>Statistics</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

   
    



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
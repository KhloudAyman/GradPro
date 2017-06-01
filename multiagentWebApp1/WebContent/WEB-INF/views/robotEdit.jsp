<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Robot</title>


	<link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style/css/bootstrap.min.css">
	
	
    <link href="style/css/freelancer.css" rel="stylesheet">
    <link href="style/css/customCSS.css" rel="stylesheet">
	
	<link href="style/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body>
<p style="color: red;">${errorString}</p>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Update Robot Data</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
	<form method="POST" action="DoEditRobot">
	
	
	     <div class="row control-group">
	           <input type="hidden" class="form-control" name="RobotId"  id="robotId" value="${tempIDedit}">
                                
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="robotIP">Robot IP</label>
                                <input type="text" class="form-control" name="RobotIP" placeholder="Robot IP" id="robotIP">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="xLocation">X Location</label>
                                <input type="text" class="form-control" name="x_location" placeholder="X_location" id="xLocation">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="yLocation">Y Location</label>
                                <input type="text" class="form-control" name="y_location" placeholder="Y_location" id="yLocation">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="rMaxLoad">Robot maximum load</label>
                                <input type="text" class="form-control" name="max_load" placeholder="Robot maximum load" id="rMaxLoad">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Edit</button>
                            </div>
                        </div>


<!-- 
		<table border="0">
			<tr>Robot Garage
			</tr>
			<tr>
				<td>X Location</td>
				<td><input type="text" name="x_location" value="" /></td>
			</tr>
			<tr>
				<td>Y Location</td>
				<td><input type="text" name="y_location" value="" /></td>
			</tr>
			<tr>Robot Specification
			</tr>
			<tr>
				<td>Robot maximum load</td>
				<td><input type="text" name="max_load" value="" /></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>

 -->


	</form>

</div>
</div>
</section>




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

<!DOCTYPE html>
<html lang="en">
<head>
<title>Chate</title>
<script src="https://use.fontawesome.com/91f7ad11e2.js"></script>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/styles.css" rel="stylesheet">
</head>
<body>
	<br><hr><br>
	<div class="container p-y-3">
		<div class="col-md-6 col-md-offset-3 m-y-2">
			<form action="LoginChat" method="post">
			<!--Form with header-->
			<div class="well">
				<div class="">

					<!--Header-->
					<div class="form-header primary-color">
						<h3>
							 Connexion
						</h3>
					</div>
					
					
					<!--Body-->
					<div class="md-form ">
						<input type="text" id="pseudo" name="pseudo" value="${id_membre}" class="form-control" readonly>
						
					</div>
					<br>
					<div class="text-xs-center">
						<input type="submit" class="btn btn-primary" name="submit" value="se connecter">
					</div>

				</div>
			</div>
			<!--/Form with header-->
			</form>

		</div>
	</div>
	<script src="assets/js/bootstrap.min.js"></script>
	
</body>
</html>
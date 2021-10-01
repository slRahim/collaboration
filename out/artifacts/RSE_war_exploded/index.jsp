<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/index.css">
    <title>EXO Platforme</title>
</head>
<body >

<!-- Main navigation -->
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
        <div class="container">
            <a class="navbar-brand" href="#"><img src="static/img/icons8_VK.com_40px_1.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">

            </div>
        </div>
    </nav>
    <!-- Navbar -->
    <!-- Full Page Intro -->
    <div class="view">
        <video class="video-intro" poster="static/img/background.jpg" playsinline autoplay muted loop>
            <source src="static/img/animation.mp4" type="video/mp4">
        </video>
        <!-- Mask & flexbox options-->
        <div class="mask rgba-gradient align-items-center">
            <!-- Content -->
            <div class="container px-md-3 px-sm-0">
                <!--Grid row-->
                <div class="row wow fadeIn" style="padding-top: 20%">
                    <!--Grid column-->
                    <div class="col-md-12 mb-4 white-text text-center wow fadeIn">
                        <h3 class="display-3 font-weight-bold white-text mb-0 pt-md-5 pt-5">EXO Platform</h3>
                        <hr class="hr-light my-4 w-75">
                        <h4 class="subtext-header mt-2 mb-4">
                            Plateforme collaborative pour entreprisesLe socle de votre transformation digitale
                        </h4>
                        <a href="" class="btn btn-outline-white btn-rounded my-3" data-toggle="modal" data-target="#modalLoginForm">LogIn </a>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </div>
            <!-- Content -->
        </div>
        <!-- Mask & flexbox options-->
    </div>
    <!-- Full Page Intro -->
</header>
<!-- Main navigation -->

<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="/Home" method="post">
                <div class="modal-header text-center" style="background-color: blueviolet">
                    <h4 class="modal-title w-100 font-weight-bold" style="color: white">Sign in</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" style="color: white">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fas fa-envelope prefix grey-text"></i>
                        <input type="email" id="defaultForm-email" class="form-control validate" name="email">
                        <label data-error="wrong" data-success="right" for="defaultForm-email">Your email</label>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <input type="password" id="defaultForm-pass" class="form-control validate" name="pass">
                        <label data-error="wrong" data-success="right" for="defaultForm-pass">Your password</label>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button class="btn btn-secondary" type="submit">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/datatables.min.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js" ></script>
<script src="static/js/mdb.min.js" ></script>


</body>
</html>
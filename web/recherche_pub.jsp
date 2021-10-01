<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="static/css/datatables.min.css">
    <title>EXO Platforme</title>
</head>
<body style="background-color: #ede7f6 ">

<!--Navbar -->
<nav class="mb-1 navbar sticky-top  navbar-expand-sm navbar-dark info-color lighten-1">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
        <ul class="navbar-nav mr-auto" style="padding-left: 40px">
            <li class="nav-item active">
                <a class="nav-link" href="/Home">
                    <img src="static/img/icons8_Home_20px.png"> <span>Home</span>
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item dropdown" style="padding-left: 5px ; padding-right: 5px">
                <a class="nav-link"  data-toggle="dropdown">
                    <img src="static/img/icons8_Notification_20px_1.png">
                    <span>Notification</span>
                    <input type="hidden" id="nb_notification" value="${fn:length(tags_pub)}">
                    <span class="badge badge-danger ml-2" id="badge_notification" >${fn:length(tags_pub)}</span>
                </a>
                <ul class="dropdown-menu" id="notification_list" >
                    <c:forEach items="${tags_pub}" var="tag" varStatus="status">
                        <c:if test="${status.count == 1}">
                            <input type="hidden" id="last_notification" value="${tag}">
                        </c:if>
                        <a href="<c:url value="/Publication"><c:param name="id_pub" value="${tag}"/></c:url>">
                            <li class="dropdown-item">Vous étes identifier dans la publication ${tag} </li>
                        </a>
                    </c:forEach>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="loginChat.jsp" target="_blank">
                    <img src="static/img/icons8_Envelope_20px.png">
                    <span>Messagerie</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/Historique"><c:param name="id_membre" value="${id_membre}"/></c:url>">
                    <img src="static/img/icons8_Time_Machine_20px_1.png"> <span>Historique Pub</span>
                </a>
            </li>
        </ul>
        <a class="navbar-brand" href="#"><img src="static/img/icons8_VK.com_40px_1.png"></a>
        <ul class="navbar-nav ml-auto ">
            <li class="nav-item dropdown" style="padding-right: 30px">
                <a class="nav-link"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span><img src="static/img/icons8_Search_35px.png"></span>
                    <div class="dropdown-menu dropdown-menu-right dropdown-secondary"  style="width: 350px">
                        <a class="dropdown-item">
                            <input class="form-control" type="text" placeholder="Search ..." id="moteur" style="width: 330px">
                        </a>
                    </div>
                </a>
            </li>
            <li class="nav-item avatar dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="static/img/icons8_User_Male_35px.png" class="rounded-circle z-depth-0" alt="avatar image">
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-secondary" aria-labelledby="navbarDropdownMenuLink-55">
                    <a class="dropdown-item" href="#">
                        <img src="static/img/icons8_Male_User_25px.png">
                        <span style="padding-left: 5px">Profil</span>
                    </a><hr>
                    <a class="dropdown-item" href="#">
                        <img src="static/img/icons8_Settings_25px.png">
                        <span style="padding-left: 5px">Setting</span>
                    </a><hr>
                    <a class="dropdown-item" href="#">
                        <img src="static/img/icons8_Exit_25px.png">
                        <span style="padding-left: 5px">Logout</span>
                    </a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<!--/.Navbar -->


<div class="row" style="margin: 25px">
    <div class="col-3">
        <!-- Card profile -->
        <div class="card" style="max-width: 20rem;">
            <!-- Card image -->
            <div class="view overlay" style="background-color: #74b9ff">

                <a href="#!">
                    <div class="mask rgba-white-slight"></div>
                </a>
                <img src="static/img/icons8_Businessman_60px_1.png" class="rounded-circle"  style="margin: 15px">
            </div>
            <!-- Card content -->
            <div class="card-body">
                <!-- Title -->
                <h4 class="card-title" ><strong>${id_membre}</strong></h4>
                <!-- Text -->
                <p class="card-text">
                <table class="table table-sm">
                    <th scope="col" style="text-align: center"><strong>Posts</strong></th>
                    <th scope="col" style="text-align: center"><strong>Followings</strong></th>
                    <th scope="col" style="text-align: center"><strong>Followers</strong></th>
                    <tr>
                        <td style="text-align: center">15</td>
                        <td style="text-align: center">15</td>
                        <td style="text-align: center">15</td>
                    </tr>
                </table>
                </p>
            </div>
        </div>
        <!-- Card profile -->
        <br>
        <!-- card groupe -->
        <div class="card mb-3" style="max-width: 20rem;">
            <div class="card-header" style="padding-left: 100px">
                <img src="static/img/icons8_People_20px.png" style="padding-right: 5px">
                <strong>Groupes</strong>
            </div>
            <div class="card-body text-primary">
                <ul class="list-group list-group-flush">
                    <a href="#!" class="list-group-item list-group-item-action">
                        Cras justo odio
                    </a>
                    <a href="#!" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                    <a href="#!" class="list-group-item list-group-item-action">Morbi leo risus</a>
                    <a href="#!" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                    <a href="#!" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                </ul>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card">
            <div class="card-body">
                <table id="dtPublication" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>####</th>
                        <th>id_publication</th>
                        <th>contenu</th>
                        <th>date</th>
                        <th>publier par</th>
                        <th>note</th>
                        <th>fichier attaché</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list_publication}" var="publication" varStatus="status">
                        <tr>
                            <td><a href="<c:url value="/Publication"><c:param name="id_pub" value="${publication.id_pub}"/></c:url>" style="color:blue">Voir</a></td>
                            <td>${publication.id_pub}</td>
                            <td>${publication.contenu}</td>
                            <td>${publication.date}</td>
                            <c:forEach items="${list_membre}" var="membre" begin="${status.count-1}" end="${status.count-1}">
                                <td>${membre.id_membre}</td>
                            </c:forEach>
                            <td>${publication.note}</td>
                            <td><a href="download/${publication.cheminF}" style="color: blue">${publication.cheminF}</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
            </div>
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
    <script>
        $("document").ready(function () {
            //speciale pour les data tables de la page recherche pub
            $('#dtPublication').DataTable();
            $('.dataTables_length').addClass('bs-select');
        })
    </script>


</body>
</html>
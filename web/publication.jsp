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

<input type="hidden" id="id_membre" value="${id_membre}">
<div class="row" style="margin: 25px">
    <div class="col-3">

    </div>
    <div class="col-6">
        <!--les publication -->
        <div id="esp_pub1">
            <c:forEach items="${publications}" var="publication" varStatus="status">
                <div class="card mb-3" style="max-width: 80rem;" id="pub${publication.id_pub}">
                    <div class="card-header" style="background-color: white">
                        <div class="row">
                            <div class="col">
                                <img src="static/img/icons8_Businessman_35px_2.png" class="rounded-circle" >
                                <c:forEach items="${membres}" var="membre" begin="${status.count-1}" end="${status.count-1}">
                                    <a href="<c:url value=""><c:param name="id_membre" value="${id_membre}"/></c:url>" style="color: black"><strong style="padding-left: 5px">${membre.id_membre}</strong></a>
                                </c:forEach>
                                <small class="form-text text-muted" style="padding-left: 50px">${publication.date}</small>
                            </div>
                            <div class="col-1">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <img src="static/img/icons8_More_35px_1.png">
                                    </a>
                                    <div class="dropdown-menu" >
                                        <a class="dropdown-item">Enregistrer publication</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <p>
                            <c:forEach items="${motCles}" var="motCle" begin="${status.count-1}" end="${status.count-1}">
                                <c:forEach items="${motCle}" var="motpub">
                                    <a href="<c:url value="/PublicationTag"><c:param name="mot_cle" value="${motpub.mot}"/> </c:url>"><strong style="color: black">#${motpub.mot}</strong></a>
                                </c:forEach>
                            </c:forEach>
                        </p>
                        <p>${publication.contenu}</p>
                        <c:if test="${not empty publication.cheminF}">
                            <table class="table table-bordered">
                                <tr>
                                    <td style="text-align: center ; background-color: lightblue">
                                        <img src="static/img/icons8_Archive_Folder_35px.png">
                                    </td>
                                    <td>
                                        <a href="download/${publication.cheminF}" style="font-weight: bold;" >Download files ...</a><br>
                                            ${publication.cheminF},(scanned by Kaspersky.Lab)
                                    </td>
                                </tr>
                            </table>
                        </c:if>
                    </div>
                    <div class="card-footer">
                        <div class="row" style="padding-left: 15%">
                            <div class="col">
                                <img id="like${publication.id_pub}" src="static/img/icons8_Heart_25px.png" onclick="like('like'+${publication.id_pub})">
                            </div>
                            <div class="col">
                                <a data-toggle="collapse" href="#collapseExample${publication.id_pub}"  aria-expanded="false" aria-controls="collapseExample">
                                    <img src="static/img/icons8_Comments_25px.png">
                                </a>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-1"><img src="static/img/icons8_Quill_With_Ink_30px.png"></div>
                            <div class="col">
                                <div class="form-group shadow-textarea">
                                    <textarea class="form-control z-depth-1" id="coment${publication.id_pub}" rows="2" placeholder="Write something here..." style="border-color:#74b9ff" name="txt_pub"></textarea>
                                </div>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary btn-sm" onclick="commenter(${publication.id_pub})">
                                    <img src="static/img/icons8_Sent_25px.png">
                                </button>
                            </div>
                        </div>
                        <!-- carte des commentaire-->
                        <div class="collapse" id="collapseExample${publication.id_pub}" style="padding-top: 5px">
                            <div class="card card-body" style="background-color: lightcyan">
                                <a style="align-self: flex-end;" onclick="synchroComment(${publication.id_pub})"><img src="static/img/icons8_Synchronize_23px.png"></a>
                                <c:forEach items="${commentaires}" var="commentaire" begin="${status.count-1}" end="${status.count-1}">
                                    <c:forEach items="${commentaire}" var="compub">
                                        <div id="commente${publication.id_pub}">
                                            <div class="row">
                                                <div class="col-1"><img src="static/img/icons8_Businessman_25px.png"></div>
                                                <div class="col">
                                                    <p class="comment">
                                                        <strong>${compub.membre}</strong><br>${compub.contenu}
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:forEach>
                            </div>
                        </div>
                        <!-- /carte des commentaire-->
                    </div>
                </div>
            </c:forEach>
        </div>

        <!--/les publication -->

    </div>
    <div class="col-3">

    </div>
</div>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js" ></script>
<script src="static/js/mdb.min.js" ></script>
<script src="static/js/autocomplete.js"></script>
<script>
    $('#affiche_file').hide();
    $('#tags').hide();
    var users=${users} ;


</script>
<script src="static/js/script.js"></script>

</body>
</html>
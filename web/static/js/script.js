
/*An array containing all the country names in the world:*/
var motCle= ["Reseau","SE","coda","Algo","BD"];
var list_index=new Array() ;
var list_tag=new Array();
var liste=motCle.concat(users);

$('document').ready(function () {

    //afficher espace des files
   $('#addfile').click(function () {
       $('#file').show();
       $('#file').focus();

   }) ;

   //afficher espace du tag
    $('#addtag').click(function () {
        $('#tags').show();
        $('#tags').focus();
    }) ;

    //add chips index
    $('#addindex').click(function(){
        if ($("#indexs").val()!=""){
            var a="delindex"+list_index.length ;
            var res="<td class='chip' id='"+a+"' style=\"margin-left:10px ; margin-bottom:5px\">"+$("#indexs").val()+
                "<span class='closebtn' onclick=\"dellindex('"+a+"')\">x</span></td>" ;
            list_index.push($("#indexs").val());
            $('#tab_index').append(res);
            $("#indexs").val("");
        }

    }) ;

    //add chips tag
    $('#tags').dblclick(function(){
        if ($("#tags").val()!=""){
            var a="delltag"+list_index.length ;
            var res="<td class='chip' id='"+a+"' style=\"margin-left:10px ; margin-bottom:5px\">"+$("#tags").val()+
                "<span class='closebtn' onclick=\"delltag('"+a+"')\">x</span></td>" ;
            list_tag.push($("#tags").val());
            $('#tab_tag').append(res);
            $("#tags").val("");
        }

    }) ;

    //envoyer une publication
    $("#poster").click(function () {
       var contenu=$("#txt_pub").val();
       var membre=$("#id_membre").val();
       var data=new FormData($("#send")[0]);
       data.append("contenu",contenu);
       data.append("membre",membre);
       data.append("liste_index",list_index.join(","));
       data.append("liste_tag",list_tag.join(","));
       $.ajax({
            type: 'Post',
            url: 'Poster', // L'URL de la servlet de recherche
            data:data,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            success: function(result) {
                alert("your publication has uploaded ");
                $("#esp_pub").load("espace_pub.jsp");
            }
        });
    });

    //recuperer les nouvelles publication
    setInterval(function(){
        var lastpub=$("#lastpub").val();
        $.ajax({
            type: 'Post',
            url: 'SynchroPub', // L'URL de la servlet de recherche
            data: { // Les parmètres envoyées
                last_pub:lastpub
            },
            success: function(result) {
                var list_publication=result[0] ;
                var list_membre=result[1] ;
                $("#lastpub").val(list_publication[0].id_pub);
                for (var i = 0; i <list_publication.length ; i++) {
                    console.log(list_publication[i].cheminF);
                    if (list_publication[i].cheminF == null){
                        res="<div class=\"card mb-3\" style=\"max-width: 80rem;\" id='pub"+list_publication[i].id_pub+"'>"+
                            "<div class=\"card-header\" style=\"background-color: white\">"+
                            "<div class=\"row\">"+
                            "<div class=\"col\">"+
                            "<img src=\"static/img/icons8_Businessman_35px_2.png\" class=\"rounded-circle\" >"+
                            "<a href='' style='color:black'><strong style=\"padding-left: 5px\">"+list_membre[i].id_membre+"</strong></a>"+
                            "<small class=\"form-text text-muted\" style=\"padding-left: 50px\">"+list_publication[i].date+"</small>" +
                            "</div>"+
                            "<div class=\"col-1\">"+
                            "<div class=\"dropdown\">"+
                            "<a data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                            "<img src=\"static/img/icons8_More_35px_1.png\">"+
                            "</a>"+
                            "<div class=\"dropdown-menu\" >"+
                            "<a class=\"dropdown-item\" onclick=\"masque_pub('pub'+"+list_publication[i].id_pub+")\">Masquer publication</a>"+
                            "<a class=\"dropdown-item\">Enregistrer publication</a>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"card-body\">"+
                            "<p>"+list_publication[i].contenu+"</p>"+
                            "</div>"+
                            "<div class=\"card-footer\">"+
                            "<div class=\"row\" style=\"padding-left: 15%\">"+
                            "<div class=\"col\">"+
                            "<img id=\"like"+list_publication[i].id_pub+"\" src=\"static/img/icons8_Heart_25px.png\" onclick=\"like('like"+list_publication[i].id_pub+"')\">"+
                            "</div>"+
                            "<div class=\"col\">"+
                            "<a data-toggle=\"collapse\" href=\"#collapseExample"+list_publication[i].id_pub+"\" aria-expanded=\"false\" aria-controls=\"collapseExample\">"+
                            "<img src=\"static/img/icons8_Comments_25px.png\">"+
                            "</a>"+
                            "</div>"+
                            "</div>"+
                            "<hr>"+
                            "<div class=\"row\">"+
                            "<div class=\"col-1\"><img src=\"static/img/icons8_Quill_With_Ink_30px.png\"></div>"+
                            "<div class=\"col\">"+
                            "<div class=\"form-group shadow-textarea\">"+
                            "<textarea class=\"form-control z-depth-1\" id='coment"+list_publication[i].id_pub+"' rows=\"2\" placeholder=\"Write something here...\" style=\"border-color:#74b9ff\" name=\"txt_pub\"></textarea>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"col-2\">"+
                            "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='commenter("+list_publication[i].id_pub+")' \">"+
                            "<img src=\"static/img/icons8_Sent_25px.png\">"+
                            "</button>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"collapse\" id=\"collapseExample"+list_publication[i].id_pub+"\" style=\"padding-top: 5px\">"+
                            "<div class=\"card card-body\" style=\"background-color: lightcyan\">"+
                            "<a style=\"align-self: flex-end\" onclick='synchroComment("+list_publication[i].id_pub+")'><img src=\"static/img/icons8_Synchronize_23px.png\"></a>"+
                            "<div id='commente"+list_publication[i].id_pub+"'>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>" ;
                    } else {
                        res="<div class=\"card mb-3\" style=\"max-width: 80rem;\" id='pub"+list_publication[i].id_pub+"'>"+
                            "<div class=\"card-header\" style=\"background-color: white\">"+
                            "<div class=\"row\">"+
                            "<div class=\"col\">"+
                            "<img src=\"static/img/icons8_Businessman_35px_2.png\" class=\"rounded-circle\" >"+
                            "<a href='' style='color:black'><strong style=\"padding-left: 5px\">"+list_membre[i].id_membre+"</strong></a>"+
                            "<small class=\"form-text text-muted\" style=\"padding-left: 50px\">"+list_publication[i].date+"</small>" +
                            "</div>"+
                            "<div class=\"col-1\">"+
                            "<div class=\"dropdown\">"+
                            "<a data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                            "<img src=\"static/img/icons8_More_35px_1.png\">"+
                            "</a>"+
                            "<div class=\"dropdown-menu\" >"+
                            "<a class=\"dropdown-item\" onclick=\"masque_pub('pub'+"+list_publication[i].id_pub+")\">Masquer publication</a>"+
                            "<a class=\"dropdown-item\">Enregistrer publication</a>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"card-body\">"+
                            "<p>"+list_publication[i].contenu+"</p>"+
                            "<table class=\"table table-bordered\">"+
                            "<tr>" +
                            "<td style=\"text-align: center ; background-color: lightblue\">" +
                            "<img src=\"static/img/icons8_Archive_Folder_35px.png\">"+
                            "</td>"+
                            "<td>"+
                            "<a href=\"download/"+list_publication[i].cheminF+"\" style=\"font-weight: bold;\" >Download files ...</a><br>" +
                            list_publication[i].cheminF+",(scanned by Kaspersky.Lab)" +
                            "</td>"+
                            "</tr>"+
                            "</table>"+
                            "</div>"+
                            "<div class=\"card-footer\">"+
                            "<div class=\"row\" style=\"padding-left: 15%\">"+
                            "<div class=\"col\">"+
                            "<img id=\"like"+list_publication[i].id_pub+"\" src=\"static/img/icons8_Heart_25px.png\" onclick=\"like('like"+list_publication[i].id_pub+"')\">"+
                            "</div>"+
                            "<div class=\"col\">"+
                            "<a data-toggle=\"collapse\" href=\"#collapseExample"+list_publication[i].id_pub+"\" aria-expanded=\"false\" aria-controls=\"collapseExample\">"+
                            "<img src=\"static/img/icons8_Comments_25px.png\">"+
                            "</a>"+
                            "</div>"+
                            "</div>"+
                            "<hr>"+
                            "<div class=\"row\">"+
                            "<div class=\"col-1\"><img src=\"static/img/icons8_Quill_With_Ink_30px.png\"></div>"+
                            "<div class=\"col\">"+
                            "<div class=\"form-group shadow-textarea\">"+
                            "<textarea class=\"form-control z-depth-1\" id='coment"+list_publication[i].id_pub+"' rows=\"2\" placeholder=\"Write something here...\" style=\"border-color:#74b9ff\" name=\"txt_pub\"></textarea>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"col-2\">"+
                            "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='commenter("+list_publication[i].id_pub+")' \">"+
                            "<img src=\"static/img/icons8_Sent_25px.png\">"+
                            "</button>"+
                            "</div>"+
                            "</div>"+
                            "<div class=\"collapse\" id=\"collapseExample"+list_publication[i].id_pub+"\" style=\"padding-top: 5px\">"+
                            "<div class=\"card card-body\" style=\"background-color: lightcyan\">"+
                            "<a style=\"align-self: flex-end\" onclick='synchroComment("+list_publication[i].id_pub+")'><img src=\"static/img/icons8_Synchronize_23px.png\"></a>"+
                            "<div id='commente"+list_publication[i].id_pub+"'>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>"+
                            "</div>" ;
                    }

                    $("#esp_pub1").prepend(res);

                }

            }
        });

        }, 5000);

    //recuperer les notification
    setInterval(function () {
        $.ajax({
            type: 'Post',
            url: '/SynchroNotification', // L'URL de la servlet de recherche
            data: { // Les parmètres envoyées
                pub: $('#last_notification').val()
            },
            success: function (resultat) {
                var res =null;
                var a=resultat[0].toString();
                $('#last_notification').val(a);
                var nbr=parseInt($('#nb_notification').val())+resultat.length ;
                for (var i = 0; i <resultat.length ; i++) {
                    res="<a href='/Publication?id_pub="+resultat[i]+"' >"+
                        "  <li class='dropdown-item'>Vous étes identifier dans la publication "+resultat[i]+"</li>" +
                        "</a>" ;

                    $('#notification_list').prepend(res);
                }
                $('#nb_notification').val(nbr.toString());
                $('#badge_notification').text(nbr.toString());


            }
        });

    },3000);

    /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
    autocomplete(document.getElementById("indexs"), motCle);
    autocomplete(document.getElementById("tags"),users);
    autocomplete(document.getElementById("moteur"),liste);



});
function attacher(a){
    var file=$(a)[0].files;
    $("#affiche_file").val(file.length+" files ready to upload");
    $("#affiche_file").show();

}

function masque_pub(id){
    $('#'+id).hide();
}

//dell index
function dellindex(id) {
    $("#"+id).remove();
}

//dell tag
function delltag(id) {
    $("#"+id).remove();
}

//commentre une publication
function commenter(id_pub) {
    var s="coment"+id_pub;
    var text_comment=$("#"+s).val();
    var membre=$("#id_membre").val();
    $.ajax({
        type: 'Post',
        url: 'Commenter', // L'URL de la servlet de recherche
        data: { // Les parmètres envoyées
           id_pub:id_pub,
            text_comment:text_comment,
            id_membre:membre

        },
        success: function(result) {
            $("#"+s).val('');
            synchroComment(id_pub);

        }
    });

}

//synchro commentaire
function synchroComment(id_pub) {
    $.ajax({
        type: 'Post',
        url: 'SynchroComment', // L'URL de la servlet de recherche
        data: { // Les parmètres envoyées
            id_pub:id_pub
        },
        success: function(result) {
            var a="commente"+id_pub ;
            $("#"+a).empty();
            for (var i = 0; i <result.length ; i++) {
                var res="<div class=\"row\">" +
                    "<div class=\"col-1\"><img src=\"static/img/icons8_Businessman_25px.png\"></div>" +
                    "<div class=\"col\">" +
                    "<p class=\"comment\">" +
                    "<strong>"+result[i].membre+"</strong><br>"+result[i].contenu+
                    "</p>" +
                    "</div>" +
                    "</div>" ;

                $("#"+a).append(res);
            }



        }
    });
}

//like publication
function like(id_pub) {
    if($('#'+id_pub).attr("src")!="static/img/icons8_Love_25px.png"){
        $('#'+id_pub).attr("src","static/img/icons8_Love_25px.png");
    }else{
        $('#'+id_pub).attr("src","static/img/icons8_Heart_25px.png");
    }
}


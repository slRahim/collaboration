<div class="card border-primary" style="max-width: 80rem;">
    <div class="card-body">
        <div class="row">
            <div class="col-1">
                <img src="static/img/icons8_Quill_With_Ink_30px.png"><br><br><br><br>
                <a id="addindex"><img src="static/img/icons8_Linking_30px.png" style="margin-top: 15px;"></a>
            </div>
            <div class="col">
                <div class="form-group shadow-textarea">
                    <textarea class="form-control z-depth-1" id="txt_pub" rows="3" placeholder="Write something here..." style="border-color:#74b9ff" name="txt_pub"></textarea>
                </div>
                <div class="form-group" style="padding-top:10px">
                    <input type="text" id="indexs" class="form-control" placeholder="Add index ..">
                </div>
                <table id="tab_index">
                    <tr></tr>
                </table>
                <div class="form-group">
                    <input type="text" id="tags" class="form-control" placeholder="Add Tags .." name="tag">
                </div>
                <table id="tab_tag">
                    <tr></tr>
                </table>
                <div class="form-group" style="padding-top:10px">
                    <input type="text" id="affiche_file" class="form-control">
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer" style="background-color: white">
        <div class="row">
            <div class="col-2"></div>
            <div class="col" style="padding-left: 50px">
                <form id="send" enctype="multipart/form-data">
                    <label for="file">
                        <img src="static/img/icons8_Add_Link_35px_2.png"><strong>Add files</strong>
                    </label>
                    <input type="file" id="file" multiple name="fichier" onchange="attacher(this)" hidden>
                    <a style="padding-left: 15px" id="addtag"><img src="static/img/icons8_Price_Tag_35px.png"><strong>Tag pepeol</strong></a>
                </form>
            </div>
            <div class="col-3">
                <button type="button" class="btn btn-secondary btn-sm" id="poster">
                    <img src="static/img/icons8_Sent_25px.png"> <strong>Post</strong>
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    $('#affiche_file').hide();
    $('#tags').hide();

</script>
<script src="static/js/autocomplete.js"></script>
<script src="static/js/script.js"></script>
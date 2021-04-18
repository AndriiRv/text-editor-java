let isMenuFileOpen = false;

$(document).ready(function () {
    openFileMenu();
    findAllDoc();

    fileMenuSave();
    fileMenuOpenDoc();
});

function openFileMenu() {
    let $fileMenu = $(".fileMenu");
    let $fileMenuButton = $(".fileButton");

    isMenuFileOpen = true;

    $fileMenuButton.on('click', function () {
        if (isMenuFileOpen) {
            $fileMenu.css("transform", "translate(120%)");
            isMenuFileOpen = false;
        } else {
            $fileMenu.css("transform", "none");
            isMenuFileOpen = true;
        }
    });
}

function fileMenuOpenDoc() {
    let $contextMenuList = $(".contextMenuList");

    let $content = $("textarea");

    $contextMenuList.on("click", "button.documentButton", function () {
        $.get({
            url: "/documents/open",
            data: {
                uuid: $(this).val()
            },
            success: function (data) {
                $content.val(data.content);
            },
            error: function () {

            }
        });
    });
}

function findAllDoc() {
    let html = '';

    $.get({
        url: "/documents/all-documents",
        success: function (data) {
            $.each(data, function (i, doc) {
                html += '<button class="documentButton" value="' + doc.id + '">' + doc.content + " | " + doc.editDate + '</button>';
            });
            $(".contextMenuList").html(html)
        },
        error: function () {

        }
    });
}

function fileMenuSave() {
    let $saveButton = $(".menuFileSaveButton");
    let content = $("textarea");

    $saveButton.on('click', function () {
        $.post({
            url: "/documents",
            data: JSON.stringify(converterToJson(null, content.val())),
            contentType: "application/json",
            success: function () {
                findAllDoc();
            },
            error: function () {

            }
        });
    });
}

function converterToJson(title, content) {
    return {
        title: title,
        content: content
    }
}
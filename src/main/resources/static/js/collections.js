$(function () {
    $result_panel = $('#result_panel');
    $collection = $('#collection');
    $add_collection = $('#add_collection');

    $add_collection.click(function () {
        var collection = toJSONExport($collection.val());
        if (collection === 'undefined') {
            $result_panel.text('incorrect value');
        } else {
            addCollection(collection);
        }
    });

    function toJSONExport(collection) {
        if (collection === 'undefined') return collection;
        collection = collection.trim().toLowerCase();
        if (collection === '') return 'undefined';
        collection = JSON.stringify({'name':collection});
        return collection;
    }

    function addCollection(collection) {
        $.ajax({
            type: 'POST',
            url: '../api/v1/collection/',
            contentType : 'application/json',
            data: collection,
            success: function (data) {
                $result_panel.text(data);
                $collection.val('');
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    }
});
$(function () {
    $word = $('#word');
    $result_panel = $('#result_panel');

    $(document).on('click', '#add_word', function () {
        var word = toJSONExport($word.val());
        if (word === 'undefined') {
            $result_panel.text('incorrect value');
        } else {
            addWord(word);
        }
    });

    function toJSONExport(word) {
        if (word === 'undefined') return word;
        word = word.trim().toLowerCase();
        if (word === '') return 'undefined';
        word = JSON.stringify({'name':word});
        return word;
    }

    function addWord(word) {
        $.ajax({
            type: 'POST',
            url: '../api/v1/word/',
            contentType : 'application/json',
            data: word,
            success: function (data) {
                $result_panel.text(data);
                $word.val('');
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    }

    //Words list
    $(document).on('click', '#words_list', function () {
        getWordsList();
    });

    function getWordsList() {
        $.ajax({
            type: 'GET',
            url: '../api/v1/word/list',
            dataType: 'json',
            success: function (data) {
                fillWordsList(data);
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);

            }
        });
    }

    function fillWordsList(wordsList) {
        console.log(wordsList);
        var container = document.getElementById('result_panel');
        var hot = new Handsontable(container, {
            data: wordsList,
            rowHeaders: true,
            colHeaders: true,
            filters: true,
            dropdownMenu: true,
            columnSorting: true,
            contextMenu: true,
            colHeaders: [
                'id',
                'name'
            ]
        });

        $result_panel.append('<button type="button" class="btn btn-outline-primary" id="save">Save</button>');

        $('#save').on('click', function () {
            var rawData = hot.getData();
            rawData.forEach(function (entry) {
                var word = JSON.stringify({"id": entry[0], "name": entry[1]});
                $.ajax({
                    type: 'PUT',
                    url: '../api/v1/word/' + entry[0],
                    data: word,
                    contentType : 'application/json',
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (xhr, resp, text) {
                        console.log('Save error.');
                        console.log(xhr, resp, text);
                    }
                });
            })
        });
    }
});
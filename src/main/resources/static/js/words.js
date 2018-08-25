$(function () {
    $word = $('#word');
    $result_panel = $('#result_panel');

    $(document).on('click', '#add_word', function () {
        var word = toJSONExport($word.val());
        if (word === 'undefined') {
            $result_panel.text('incorrect word');
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
        console.log(word);
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
});
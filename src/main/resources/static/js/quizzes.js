$(function () {
    var question_val = '';
    var answers = [];

    $question = $('#question');
    $answer = $('#answer');
    $question_panel = $('#question_panel');
    $answers_panel = $('#answers_panel');

    $(document).on('click', '#add_question', function () {
        if (question_val === '') {
            var question = extractQuestion($question.val());
            if (question === 'undefined') {
                $question_panel.text('incorrect value');
            } else {
                question_val = question;
                $question_panel.text(question);
                $question.val('');
            }
        }
    });

    function extractQuestion(question) {
        if (question === 'undefined') return question;
        question = question.trim().toLowerCase();
        if (question === '') return 'undefined';
        return question;
    }

    $(document).on('click', '#add_answer', function () {
        console.log('click');
        var answer = extractAnswer($answer.val());
        if (answer === 'undefined') {
            $answers_panel.text('incorrect value');
        } else {
            answers.push(answer);
            $answers_panel.append(answer);
            $answer.val('');
        }
        console.log(answer);
    });

    function extractAnswer(answer) {
        if (answer === 'undefined') return answer;
        answer = answer.trim().toLowerCase();
        if (answer === '') return 'undefined';
        return answer;
    }

    function addQuiz() {
        $.ajax({
            type: 'POST',
            url: '../api/v1/quiz/',
            contentType : 'application/json',
            data: quiz,
            success: function (data) {
                $result_panel.text(data);
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
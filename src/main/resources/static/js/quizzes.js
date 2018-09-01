$(function () {
    var question_val = '';
    var answers = [];

    $question = $('#question');
    $answer = $('#answer');
    $result_panel = $('#result_panel');
    $question_panel = $('#question_panel');
    $answers_panel = $('#answers_panel');

    //Add quiz
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
        var answer = extractAnswer($answer.val());
        if (answer === 'undefined') {
            $answers_panel.text('incorrect value');
        } else {
            answers.push(answer);
            $answers_panel.append(answer + '<br>');
            $answer.val('');
        }
    });

    function extractAnswer(answer) {
        if (answer === 'undefined') return answer;
        answer = answer.trim().toLowerCase();
        if (answer === '') return 'undefined';
        return answer;
    }

    $(document).on('click', '#add_quiz', function (){
        if (question === '' || answers.length === 0) {
            $result_panel.text('fill in all the information');
        } else {
            addQuiz(assembleQuizJSON());
        }
    });

    function assembleQuizJSON() {
        var quizJSON = '';
        answers.forEach(function(entry){
           quizJSON += '{"name":"' + entry + '"},';
        });
        quizJSON = '{"question":{"name":"' + question_val + '"},"answers":['
        + quizJSON.substring(0, quizJSON.length - 1) + ']}';
        return quizJSON;
    }

    function addQuiz(quiz) {
        $.ajax({
            type: 'POST',
            url: '../api/v1/quiz/',
            contentType : 'application/json',
            data: quiz,
            success: function (data) {
                clearPanels();
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    }

    function clearPanels() {
        question_val = '';
        answers = [];
        $question_panel.text('');
        $answers_panel.text('');
    }

    //Quizzes list
    $(document).on('click', '#quizzes_list', function () {
        getQuizzesList();
    });

    function getQuizzesList() {
        $.ajax({
            type: 'GET',
            url: '../api/v1/quiz/list',
            dataType: 'json',
            success: function (data) {
                fillQuizzesList(data);
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    }

    function fillQuizzesList(quizzesList) {
        quizzesList.forEach(function (entry) {
            var answers = '';
            entry['answers'].forEach(function (answer) {
                answers += answer['name'] + ', ';
            });
            if (answers.length > 1) {
                answers = answers.substring(0, answers.length - 2);
            }
            entry['answers'] = answers;
        });
        console.log(quizzesList);

        var container = document.getElementById('result_panel');
        var hot = new Handsontable(container, {
            data: quizzesList,
            rowHeaders: true,
            colHeaders: true,
            filters: true,
            dropdownMenu: true,
            columnSorting: true,
            contextMenu: true,
            colHeaders: [
                'question',
                'answers'
            ],
            columns: [
                {
                    data: 'question.name'
                },
                {
                    data: 'answers'
                }
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
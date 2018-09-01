$(function () {
    $quiz_panel = $('#quiz_panel');
    $answers_panel = $('#answers_panel');
    $answer_panel = $('#answer_panel');
    $alert_panel = $('#alert_panel');
    $prompt_panel = $('#prompt_panel');
    $start = $('#start');
    $check_answer = $('#check_answer');
    $save_result = $('#save_result');
    var chars = new Map([['q', 'й'], ['w', 'ц'], ['e', 'у'], ['r', 'к']
        , ['t', 'е'], ['y', 'н'], ['u', 'г'], ['i', 'ш'], ['o', 'щ'], ['p', 'з']
        , ['[', 'х'], [']', 'ъ'], ['a', 'ф'], ['s', 'ы'], ['d', 'в'], ['f', 'а']
        , ['g', 'п'], ['h', 'р'], ['j', 'о'], ['k', 'л'], ['l', 'д'], [';', 'ж']
        , ['\'', 'э'], ['z', 'я'], ['x', 'ч'], ['c', 'с'], ['v', 'м'], ['b', 'и']
        , ['n', 'т'], ['m', 'ь'], [',', 'б'], ['.', 'ю']]);
    var char = '';
    var quizzesList;
    var quizIndex;
    var lot;
    var answersArray = [];
    var answer = '';
    var danger = 'alert alert-danger text-center';
    var success = 'alert alert-success text-center';
    var successSound = new Audio('/sounds/success.mp3');
    var dangerSound = new Audio('/sounds/wrong.mp3');

    //TODO при скачивании списка вопросов, его нужно добавлять в коллекцию с сортировкой по уровню ответов
    //TODO либо добавить отдельную коллекцию с сортировкой по уровню ответов со ссылкой на id в массиве
    //TODO сделать проверку включения русского языка и автоматический ввод английских букв

    $start.click(function () {
        if (typeof quizzesList === 'undefined') {
            getQuizzesList();
        } else {
            pullQuiz();
        }
        $start.hide();
        $check_answer.show();
        $save_result.show();
        $answer_panel.focus();
    });

    $check_answer.click(function () {
        checkAnswers();
        pullQuiz();
        $check_answer.blur();
        $answer_panel.focus();
    });

    $save_result.click(function () {
        //TODO create function for save result test
        $alert_panel.text('result test save');
        $alert_panel.attr('class', success);
        $alert_panel.fadeIn(500).fadeOut(3000);
        successSound.play();
    });

    $(document).on('keypress', function (e) {
        if (e.which === 8) {
            //Backspace - 8
            if (answer.length > 0) {
                answer = answer.substring(0, answer.length - 1);
                $answer_panel.text(answer);
            }
        } else if(e.ctrlKey && e.which === 13) {
            //Ctrl + Enter
            checkAnswers();
            pullQuiz();
        } else if (e.which === 13 || e.which === 13) {
            //enter - 13
            if (answer !== '') {
                answersArray.push(answer);
                answer = '';
                $answer_panel.text(answer);
                fillAnswersPanel();
            }
        } else if (e.ctrlKey && e.which === 32) {
            prompt();
        } else {
            if (!e.ctrlKey) {
                char = String.fromCharCode(e.which).toLowerCase();
                if (lot === 0) {
                    char = chars.get(char);
                }
                answer += char;
                $answer_panel.text(answer);
            }
        }
    });

    function getQuizzesList() {
        $.ajax({
            type: 'GET',
            url: '../api/v1/quiz/list',
            dataType: 'json',
            success: function (data) {
                quizzesList = data;
                pullQuiz();
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    }
    
    function pullQuiz() {
        answer = '';
        answersArray = [];
        $answers_panel.text('');
        $answer_panel.text('');
        $prompt_panel.text('');
        quizIndex = Math.floor(Math.random() * Math.floor(quizzesList.length));
        //lot value 1 if
        lot = Math.floor(Math.random() * Math.floor(2));
        if (lot === 0) {
            $quiz_panel.text(quizzesList[quizIndex]['question']['name']);
        } else {
            var answers = '';
            quizzesList[quizIndex]['answers'].forEach(function (entry) {
                answers += entry['name'] + ', ';
            });
            if (answers.length > 2) {
                answers = answers.substring(0, answers.length - 2);
            }
            $quiz_panel.text(answers);
        }
    }

    function fillAnswersPanel() {
        var answersString = '';
        answersArray.forEach(function (value) {
           answersString += value + ', ';
        });
        if (answersString.length > 2) {
            answersString = answersString.substring(0, answersString.length - 2);
        }
        $answers_panel.text(answersString);
    }
    
    function checkAnswers() {
        function f() {
            var flag = false;
            if (lot === 1) {
                if (quizzesList[quizIndex]['question']['name'] === answersArray[0]) {
                    flag = true;
                }
            } else {
                var verifyingLength = 0;
                if (quizzesList[quizIndex]['answers'].length === answersArray.length) {
                    quizzesList[quizIndex]['answers'].forEach(function (entry) {
                        answersArray.forEach(function (value) {
                            if (entry['name'] === value) {
                                verifyingLength++;
                            }
                        });
                    });
                    if (quizzesList[quizIndex]['answers'].length == verifyingLength) {
                        flag = true;
                    }
                }
            }
            return flag;
        }
        if (f()) {
            $alert_panel.text('Correct answer');
            $alert_panel.attr('class', success);
            successSound.play();
        } else {
            $alert_panel.text('Incorrect answer');
            $alert_panel.attr('class', danger);
            dangerSound.play();
        }
        $alert_panel.fadeIn(500).fadeOut(3500);
    }
    
    function prompt() {
        if (lot === 1) {
            $prompt_panel.text(quizzesList[quizIndex]['question']['name']);
        } else {
            var answers = '';
            quizzesList[quizIndex]['answers'].forEach(function (entry) {
                answers += entry['name'] + ', ';
            });
            if (answers.length > 2) {
                answers = answers.substring(0, answers.length - 2);
            }
            $prompt_panel.text(answers);
        }
        $prompt_panel.fadeIn(500).fadeOut(7000);
    }
});
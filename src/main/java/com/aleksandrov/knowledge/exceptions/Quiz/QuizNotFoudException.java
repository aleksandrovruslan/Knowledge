package com.aleksandrov.knowledge.exceptions.Quiz;

import com.aleksandrov.knowledge.exceptions.NotFoundException;

public class QuizNotFoudException extends NotFoundException {
    public QuizNotFoudException() {
        super();
    }

    public QuizNotFoudException(String message) {
        super(message);
    }

    public QuizNotFoudException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuizNotFoudException(Throwable cause) {
        super(cause);
    }
}

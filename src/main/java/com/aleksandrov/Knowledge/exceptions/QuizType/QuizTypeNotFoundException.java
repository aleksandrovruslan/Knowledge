package com.aleksandrov.Knowledge.exceptions.QuizType;

import com.aleksandrov.Knowledge.exceptions.NotFoundException;

public class QuizTypeNotFoundException extends NotFoundException {
    public QuizTypeNotFoundException() {
        super();
    }

    public QuizTypeNotFoundException(String message) {
        super(message);
    }

    public QuizTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuizTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}

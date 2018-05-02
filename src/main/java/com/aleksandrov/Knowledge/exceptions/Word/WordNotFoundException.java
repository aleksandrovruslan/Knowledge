package com.aleksandrov.Knowledge.exceptions.Word;

import com.aleksandrov.Knowledge.exceptions.NotFoundException;

public class WordNotFoundException extends NotFoundException {
    public WordNotFoundException() {
    }

    public WordNotFoundException(String message) {
        super(message);
    }

    public WordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordNotFoundException(Throwable cause) {
        super(cause);
    }
}

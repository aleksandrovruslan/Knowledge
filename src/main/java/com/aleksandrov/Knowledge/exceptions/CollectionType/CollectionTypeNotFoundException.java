package com.aleksandrov.Knowledge.exceptions.CollectionType;

import com.aleksandrov.Knowledge.exceptions.NotFoundException;

public class CollectionTypeNotFoundException extends NotFoundException {
    public CollectionTypeNotFoundException() {
        super();
    }

    public CollectionTypeNotFoundException(String message) {
        super(message);
    }

    public CollectionTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollectionTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}

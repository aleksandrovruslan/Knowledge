package com.aleksandrov.knowledge.exceptions.Collection;

import com.aleksandrov.knowledge.exceptions.NotFoundException;

public class CollectionNotFoundException extends NotFoundException {
    public CollectionNotFoundException() {
        super();
    }

    public CollectionNotFoundException(String message) {
        super(message);
    }

    public CollectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollectionNotFoundException(Throwable cause) {
        super(cause);
    }
}

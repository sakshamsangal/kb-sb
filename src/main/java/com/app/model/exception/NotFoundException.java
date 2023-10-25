/*
 * Copyright 2023 Thomson Reuters/ONESOURCE. All rights reserved.
 */
package com.app.model.exception;

import lombok.Getter;


@Getter
public class NotFoundException extends RuntimeException {
    private final String code;
    private final String message;

    public NotFoundException(String code, String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;

    }

    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;

    }


}

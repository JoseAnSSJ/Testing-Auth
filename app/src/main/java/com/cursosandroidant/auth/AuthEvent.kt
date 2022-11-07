package com.cursosandroidant.auth

enum class AuthEvent {
    //Success
    USER_EXIST,

    //Fail
    NOT_USER_EXIST,

    //Epmty
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,

    //Invalid
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_FORM,

    //Expecion
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM,
    LENGTH_PASSWORD
}
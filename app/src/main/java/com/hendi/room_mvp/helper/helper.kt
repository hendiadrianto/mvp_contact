package com.hendi.room_mvp.helper

fun isValidEmail(email: String): Boolean {
    val validate: Boolean
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    val emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+"

    if (email.matches(emailPattern.toRegex())) {
        validate = true
    } else if (email.matches(emailPattern2.toRegex())) {
        validate = true
    } else {
        validate = false
    }
    return validate
}

fun isUser(text : String) : Boolean {
    return if (text.length > 0) true else false
}
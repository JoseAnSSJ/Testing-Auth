package com.cursosandroidant.auth

class AuthExepcion(val authEvent: AuthEvent, msg: String? = null):Exception(msg)
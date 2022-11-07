package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthAltTest {

    private var email: String? = null
    private var password: String? = null

    @Before
    fun setUp(){
        email = "ant@gmail.com"
        password = "1234"
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthentication)
    }
    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAuthentication)
    }
    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.EMPTY_EMAIL, isAuthentication)
    }
    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthentication)
    }
    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.EMPTY_FORM, isAuthentication)
    }
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAuthentication)
    }
    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthentication)
    }
    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.INVALID_FORM, isAuthentication)
    }

    @Test(expected = AuthExepcion::class)
    fun login_nullEmail_returnsException(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.NULL_EMAIL, isAuthentication)
    }
    @Test(expected = AuthExepcion::class)
    fun login_nullPassword_returnsException(){
            val isAuthentication = userAuthenticationTDD(email,password)
            Assert.assertEquals(AuthEvent.NULL_PASSWORD, isAuthentication)

    }
    @Test(expected = AuthExepcion::class)
    fun login_nullForm_returnsException(){
            val isAuthentication = userAuthenticationTDD(email,password)
            Assert.assertEquals(AuthEvent.NULL_FORM, isAuthentication)
    }

    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD(email,password)
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, isAuthentication)
    }


}
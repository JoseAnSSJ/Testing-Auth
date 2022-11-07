package com.cursosandroidant.auth

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore

class AuthTDDTest {

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","1234")
        assertEquals(AuthEvent.USER_EXIST,isAuthentication)
    }
    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("as@gmail.com","1234")
        assertEquals(AuthEvent.NOT_USER_EXIST,isAuthentication)
    }
    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("","1234")
        assertEquals(AuthEvent.EMPTY_EMAIL,isAuthentication)
    }
    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("as@gmail.com","")
        assertEquals(AuthEvent.EMPTY_PASSWORD,isAuthentication)
    }
    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("","")
        assertEquals(AuthEvent.EMPTY_FORM,isAuthentication)
    }
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("asgmail.com","1234")
        assertEquals(AuthEvent.INVALID_EMAIL,isAuthentication)
    }
    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","asda")
        assertEquals(AuthEvent.INVALID_PASSWORD,isAuthentication)
    }
    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("antgmail.com","asda")
        assertEquals(AuthEvent.INVALID_FORM,isAuthentication)
    }

    @Test(expected = AuthExepcion::class)
    fun login_nullEmail_returnsException(){
        val isAuthentication = userAuthenticationTDD(null,"1234")
        assertEquals(AuthEvent.NULL_EMAIL,isAuthentication)
    }
    @Test
    fun login_nullPassword_returnsException(){
        assertThrows(AuthExepcion::class.java){
            val isAuthentication = userAuthenticationTDD("ant@gmail.com",null)
            assertEquals(AuthEvent.NULL_PASSWORD,isAuthentication)
        }

    }
    @Test
    fun login_nullForm_returnsException(){
        try {
            val isAuthentication = userAuthenticationTDD(null,null)
            assertEquals(AuthEvent.NULL_FORM,isAuthentication)
        } catch (e: Exception) {
            (e as? AuthExepcion)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    @Test
    @Ignore(value = "Tentativo a cambios")
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","12344445")
        assertEquals(AuthEvent.LENGTH_PASSWORD,isAuthentication)
    }


}
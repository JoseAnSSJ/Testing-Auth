package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.Assert.assertTrue

class AuthTest {

    @Test
    fun login_complete_return_true(){
        val isAuthentication = userAuthentication("ant@gmail.com", "1234")
        assertTrue(isAuthentication)
    }
    @Test
    fun login_complete_return_false(){
        val isAuthentication = userAuthentication("ant@gmail.com", "124")
        assertFalse(isAuthentication)
    }
    @Test
    fun login_empty_email_return_false(){
        val isAuthentication = userAuthentication("", "124")
        assertFalse(isAuthentication)
    }
/*    @Test
    fun login_null_email_return_false(){
        val isAuthentication = userAuthenticationTDD(null, "124")
        assertFalse(isAuthentication)
    }
    @Test
    fun login_null_pass_return_false(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com", null)
        assertFalse(isAuthentication)
    }*/

}
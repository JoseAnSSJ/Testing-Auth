package com.cursosandroidant.auth

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class AuthHamcressTest {

    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","1234")
        assertThat(AuthEvent.USER_EXIST,  `is`(isAuthentication))
    }
    @Test
    fun loginUser_wrongData_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("as@gmail.com","1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(isAuthentication))
    }
    @Test
    fun loginUser_emptyEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("","1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(isAuthentication))
    }
    @Test
    fun loginUser_emptyPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("as@gmail.com","")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(isAuthentication))
    }
    @Test
    fun loginUser_emptyForm_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("","")
        assertThat(AuthEvent.EMPTY_FORM, `is`(isAuthentication))
    }
    @Test
    fun loginUser_wrongEmail_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("asgmail.com","1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(isAuthentication))
    }
    @Test
    fun loginUser_wrongPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","asda")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(isAuthentication))
    }
    @Test
    fun loginUser_wrongUser_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("antgmail.com","asda")
        assertThat(AuthEvent.INVALID_FORM, `is`(isAuthentication))
    }

    @Test(expected = AuthExepcion::class)
    fun loginUser_nullEmail_returnsException(){
        val isAuthentication = userAuthenticationTDD(null,"1234")
        assertThat(AuthEvent.NULL_EMAIL, `is`(isAuthentication))
    }
    @Test(expected = AuthExepcion::class)
    fun loginUser_nullPassword_returnsException(){
            val isAuthentication = userAuthenticationTDD("ant@gmail.com", null)
            assertThat(AuthEvent.NULL_PASSWORD, `is`(isAuthentication))

    }
    @Test(expected = AuthExepcion::class)
    fun loginUser_nullForm_returnsException(){
            val isAuthentication = userAuthenticationTDD(null,null)
            assertThat(AuthEvent.NULL_FORM, `is`(isAuthentication))
    }

    @Test
    fun loginUser_wrongLengthPassword_returnsFailEvent(){
        val isAuthentication = userAuthenticationTDD("ant@gmail.com","12344445")
        assertThat(AuthEvent.LENGTH_PASSWORD, `is`(isAuthentication))
    }

    @Test
    fun checkNames_differentUsers_macht(){
        //assertThat("Maria", containsString("a"))
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_notMacht(){
        val email = "asd"
        val password = "1234"
        assertThat(email, not( `is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnString(){
        val oldEmail = "abc"
        val newEmail = "dcs"
        val emails = arrayOf(oldEmail,newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnString(){
        val oldEmail = "abcs"
        val newEmail = "dcs"
        val nextEmail = "fghs"
        val emails = arrayListOf(oldEmail,newEmail, nextEmail)
        assertThat(emails, everyItem(endsWith("s")))

    }

}
package com.alizee.applicationtest

import com.alizee.applicationtest.models.User
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var user1 =  User(
        id = 1,
        name = "",
        website = "",
        username = "",
        phone = "",
        email = "",
        lat = 0.0,
        lng = 0.0
    )
    var user2 =  User(
        id = 2,
        name = "",
        website = "",
        username = "",
        phone = "",
        email = "",
        lat = 0.0,
        lng = 0.0
    )
    var user3 =  User(
        id = 3,
        name = "",
        website = "",
        username = "",
        phone = "",
        email = "",
        lat = 0.0,
        lng = 0.0
    )

    val users = mutableListOf<User>(user1, user2, user3)

    @Test
    fun test_users_size() {
        assertEquals(4, users.size)
    }

    @Test
    fun test_users_add() {
        var old_size = users.size
        users.add(User(
            id = 4,
            name = "",
            website = "",
            username = "",
            phone = "",
            email = "",
            lat = 0.0,
            lng = 0.0
        ))
        assertEquals(old_size + 1, users.size)
    }

    @Test
    fun test_users_delete() {
        var old_size = users.size
        users.remove(User(
            id = 2,
            name = "",
            website = "",
            username = "",
            phone = "",
            email = "",
            lat = 0.0,
            lng = 0.0
        ))
        assertEquals(old_size - 1, users.size)
    }

    @Test
    fun test_user_exist() {
        var user = users.get(10)
        assertNotNull(user)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
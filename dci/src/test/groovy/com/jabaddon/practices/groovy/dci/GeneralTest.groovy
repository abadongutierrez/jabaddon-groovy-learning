package com.jabaddon.practices.groovy.dci

class GeneralTest {
    
    Database database
    
    @org.junit.Before
    void setup() {
        database = new Database();
    }

    @org.junit.Test
    void shouldGetUserById() {
        assert database.findUserById(1L) != null
    }
    
    @org.junit.Test
    void shouldAddFollowerToUser() {
        def context = new FollowersListContext(db: database)
        assert database.findUserById(2L).followers.isEmpty()
        context.addFollowerToUser 1L, 2L
        assert database.findUserById(2L).followers.size() == 1
    }
    
    @org.junit.Test
    void shouldAddFollowerToCompany() {
        def context = new FollowersListContext(db: database)
        assert database.findCompanyById(1L).followers.isEmpty()
        context.addFollowerToCompany(1L, 1L)
        assert database.findCompanyById(1L).followers.size() == 1
    }
    
    @org.junit.Test
    void shouldAddFollower() {
        def context = new FollowersListContext(db: database)
        def following = database.findCompanyById(1L)
        assert following != null
        assert following.id.equals(1L)
        def follower = database.findUserById(2L)
        context.addFollower(following, follower)
        assert !following.followers.isEmpty()
        assert following.followers.size() == 1
    }
    
    @org.junit.Test
    void shouldAddMixinPerInstance() {
        "Hola Abaddon".metaClass.toString = { "Diferente Cadena" }
        org.junit.Assert.assertEquals("Diferente Cadena", "Hola Abaddon".toString())
        org.junit.Assert.assertEquals("otra cosa", "otra cosa".toString())
    }
}

package com.jabaddon.practices.groovy.dci

class FollowersListContext {

    Database db
    
    void addFollowerToUser(Long followerUserId, Long userId) {
        def user = db.findUserById(userId)
        def userFollower = db.findUserById(followerUserId)
        
        // Add role to data
        // following.actAs FollowingRole
        // follower.actAs Follower
        user.metaClass.mixin FollowingRole
        userFollower.metaClass.mixin FollowerRole
        
        user.addFollower(userFollower)
    }
    
    void addFollowerToCompany(Long followerUserId, Long companyId) {
        def userFollower = db.findUserById(followerUserId)
        def company = db.findCompanyById(companyId)
        
        company.metaClass.mixin FollowingRole
        userFollower.metaClass.mixin FollowerRole
        
        company.addFollower(userFollower)
    }
    
    void addFollower(following, follower) {
        following.metaClass.mixin FollowingRole
        follower.metaClass.mixin FollowerRole
        following.addFollower(follower)
    }
}

package com.jabaddon.practices.groovy.dci

class Database {

    private users = [
        1L: new User(id: 1L, name: 'Johh', age: 25L, followers: []),
        2L: new User(id: 2L, name: 'Piter', age: 25L, followers: [])
    ]

    private companies = [
        1L: new Company(id: 1L, name: 'BigCompany', country: 'Canada', followers: [])
    ]

    User findUserById(Long id){
        users[id]
    }

    Company findCompanyById(Long id){
        companies[id]
    }

    void updateUser(User user){
        users[user.id] = user
    }

    void updateCompany(Company company){
        companies[company.id] = company
    }
}
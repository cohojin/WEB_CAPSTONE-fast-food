"use strict";

class Userstrorage{
    // #처리로 undefined를 뜨게 만들어 은닉처리
    static #users = {
        id: ["나개발", "김팀장"],
        psword: ["1234", "1234"],
        name:["나개발","김민호"],
    };

    static getUsers(...fields){
        // return this.#users;
        const users = this.#users;
        // 반복문
        const newUsers = fields.reduce((newUsers, field)=>{
            if(users.hasOwnProperty(field)){
                newUsers[field] = users[field];
            }
            return newUsers;
        },{});
        return newUsers;
    }
    
};

module.exports =Userstrorage;
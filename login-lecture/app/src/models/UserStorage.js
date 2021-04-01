"use strict";

class Userstrorage{
    // #처리로 undefined를 뜨게 만들어 은닉처리
    static #users = {
        id: ["나개발", "김팀장"],
        psword: ["1234", "1234"],
        name:["나개발","김민호"],
    };

    static getUsers(...fields){
        const users = this.#users;
        const newUsers = fields.reduce((newUsers, fields)=>{
            console.log(newUsers,fields);
        })
        return ;
    }
    
};

module.exports =Userstrorage;
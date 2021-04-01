"use strict";

const Userstrorage = require("../../models/UserStorage");
const process = {
    login:(req,res)=>{
        const id = req.body.id,
            psword = req.body.psword;


        console.log(Userstrorage.getUsers("id","psword"));
        const respose = {};
        // if(users.id.includes(id)){
        //     const idx = users.id.indexOf(id);
        //     if(users.psword[idx] === psword) {
        //         respose.success = true;
        //         return res.json(respose);
        //     }
        // }
        respose.success = false;
        respose.msg = "로그인에 실패했습니다."
        return res.json(respose);
    }
};

const output = {
    home : (req,res)=>{
        res.render("home/index");
    },
    login: (req,res)=>{
        res.render("home/login");
    }
};


module.exports = {
   output,
   process,
};

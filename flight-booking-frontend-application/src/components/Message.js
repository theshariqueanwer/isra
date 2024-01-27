import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';


function Message() {

        const navigate = useNavigate()
        let message = localStorage.getItem('message')

        function back() {
                navigate("/login")
        }
        
        function close() {
                navigate("/home")
        }

        return (
                <div>
                        <div className="col-sm-6 offset-sm-3" >
                                <h1>Email Sent Successfull</h1>

                                <p>{message}</p>
                        
                                <button onClick={back} className=" btn btn-primary me-2">back</button>
                                <button onClick={close} className="btn btn-danger">close</button>

                        </div>
                </div>
        )
}

export default Message








































//import React, { useState, useEffect } from "react";
//import { useNavigate } from "react-router-dom";
//import Header from './Header';


//function Login() {

//        const navigate = useNavigate()
//        useEffect(() => {
//                if (localStorage.getItem('user-info')) {
//                        navigate("/welcome")
//                }
//        }, [])

//        const [userName, setUserName] = useState("");
//        const [password, setPassword] = useState("");

//        async function login() {
//                console.warn("username: ", userName, "and", "password: ", password);
//                let loginData = { userName, password };
//                //let result = await fetch("http://localhost:9192/loginWithUserName", {
//                await fetch("http://localhost:9192/loginWithUserName", {
//                        method: 'POST',
//                        headers: {
//                                "Content-Type": "application/json",
//                                "Accept": "application/json"
//                        },
//                        body: JSON.stringify(loginData),
//                        //credentials: 'include'
//                }).then(resp => {
//                        localStorage.setItem('token', JSON.stringify({resp}))
//                })
//                //console.warn("response ", resp)
//                //localStorage.setItem('user-info', JSON.stringify({result}))
//                navigate("/welcome")
//        }

//        return (
//                <div>
//                        <div className="col-sm-6 offset-sm-3" >
//                                <h1>Login Page</h1>

//                                <input type="text" required name="username" id="username" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder="User Name" className="form-control" ></input> <br></br>
//                                <input type="password" required name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" className="form-control" ></input> <br></br>
//                                <button onClick={login} className="btn btn-primary">signin</button>

//                        </div>
//                </div>
//        )
//}

//export default Login
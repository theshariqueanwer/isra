import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';


function ForgotPassword(props) {

        const navigate = useNavigate();

        const [email, setEmail] = useState("");

        async function forgot() {
                console.warn("email: ", email);
                let data = { email };
                let result = await fetch("http://localhost:9192/forgot_password", {
                        method: 'POST',
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        },
                        body: JSON.stringify(data),
                })

                result = await result;
                console.warn(result)
                localStorage.setItem('message', result)
                let message = localStorage.getItem('message')
                console.warn(message)
                navigate("/message")
        }
        

        function back() {
                navigate("/login")
        }

        function clear() {
                setEmail(() => "")
        }
        
        return (
                <div>
                        <div className="col-sm-6 offset-sm-3" >
                                <h1>Forgot Password</h1>

                                <p>Please Provide Your Registered Email Address</p>
                                <input type="email" name="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} required = "required" placeholder="Please Enter Your Email" className="form-control" ></input> <br/>

                                <button onClick={clear} className="btn btn-warning me-2">reset</button>
                                <button onClick={forgot} className="btn btn-primary me-2">send</button>
                                <button onClick={back} className="btn btn-danger">back</button><br/>

                        </div>
                </div>
        )
}

export default ForgotPassword








































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
import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';


function Login() {

        const navigate = useNavigate()

        // useEffect(() => {
        //         if (localStorage.getItem('user-info')) {
        //                 navigate(-1)
        //         }
        //         if (localStorage.getItem('user-info')) {
        //                 navigate("/welcome")
        //         }
        // }, [])

        // const userInfo = localStorage.getItem('user-info');
        // useEffect(() => {
        //         if (userInfo) {
        //                 navigate(-1)
        //         }
        //         if (localStorage.getItem('user-info')) {
        //                 navigate("/welcome")
        //         }
        // }, [userInfo])

        const [userName, setUserName] = useState("");
        const [password, setPassword] = useState("");

        async function login() {
                console.warn("username: ", userName, "and", "password: ", password);
                let data = { userName, password };
                let result = await fetch("http://localhost:9192/loginUserByUserName", {
                        method: 'POST',
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        },
                        body: JSON.stringify(data),
                })
                result = await result.json()
                console.warn("result ", result)
                localStorage.setItem('user-info', JSON.stringify(result))
                // navigate("/welcome")
                navigate("/welcome")
        }

        function close() {
                navigate("/home")
        }

        function clear() {
                setUserName(() => "")
                setPassword(() => "")
        }
        
        return (
                <div>
                        <div className="col-sm-6 offset-sm-3" >
                                <h1>Login Page</h1>

                                <input type="text" required name="username" id="username" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder="User Name" className="form-control" ></input> <br/>
                                <input type="password" required name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" className="form-control" ></input> <br/>
                                {/*<button onClick={clear} className="btn btn-warning me-2">reset</button> */}
                                <button onClick={login} className="btn btn-primary me-2">signin</button>
                                {/*<button onClick={close} className="btn btn-danger">close</button><br/>*/}
                                <p> if you are not register yet please click here to <a className="a_link" href="registeration">register</a></p>
                                <p><a className="a_link" href="forgot">forgot password</a></p>


                        </div>
                </div>
        )
}

export default Login








































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
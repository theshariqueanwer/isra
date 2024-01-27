import React, {useState, useEffect, Component} from "react";
import { useNavigate } from "react-router-dom";
import Header from './Header';


// class Login extends Component {

//         constructor() {
//                 super();
//                 this.state = {
//                         userName: null,
//                         password: null,
//                         login: false,
//                         store: null
//                 }
//         }

//         //async function login() {
//         //        console.warn("username: ", userName, "and", "password: ", password);
//         //        let data = { userName, password };
//         //        //let result = await fetch("http://localhost:9192/loginWithUserName", {
//         //        axios.post("http://localhost:9192/loginWithUserName", data
//         //        ).then(resp => {
//         //                //localStorage.setItem('user-info', resp.data.token)
//         //                localStorage.setItem('user-info', JSON.stringify({resp}))
//         //        })
//         //        navigate("/welcome")
//         //}

//         //async function login() {
//         //        console.warn("username: ", userName, "and", "password: ", password);
//         //        let data = { userName, password };
//         //        let result = await fetch("http://localhost:9192/loginUserByUserName", {
//         //        })

                
//         //        navigate("/welcome")
//         //}

//         //useEffect( () => {(
//         //        async () => {
//         //                let result = await fetch("http://localhost:9192/loginWithUserName", {
//         //                credentials: 'include',
//         //                headers: { "Content-Type": "application/json" }
//         //        })
//         //        console.warn("result ", result)
//         //        localStorage.setItem('user-info', JSON.stringify({result}))
//         //        }
//         //)})


//         //let config = {
//         //        headers: {
//         //                Authorization: 'Bearer ' + localStorage.getItem('token')
//         //        }
//         //}

//         //let result = axios.get("http://localhost:9192/findByUserName/", config
//         //).then(resp =>{
//         //        result = result.json()
//         //        console.warn("result ", result)
//         //        localStorage.setItem('user-info', JSON.stringify(result))
//         //})


//         login() {
//                 fetch("http://localhost:9192/loginWithUserName",{
//                         method: "POST",
//                         body: JSON.stringify(this.state)
//                 }).then((response) => {
//                         response.json().then((result) => {
//                                 console.warn("result ", result)
//                                 localStorage.setItem('login', JSON.stringify({
//                                         login: true,
//                                         token: result.token
//                                 }))
//                         })
//                 })
//         }


//         render() {
//                 return (
//                 <div>
//                 <div className="col-sm-6 offset-sm-3" >
//                         <h1>Login Page</h1>
        
//                                 <input type = "text" required name="userName" id="userName" value={userName} onChange={(event) => {this.setState({userName:event.target.value})}} placeholder="User Name" className="form-control" ></input> <br></br>
//                                 <input type = "password" required name="password" id="password" value={password} onChange={(event) => {this.setState({password:event.target.value})}} placeholder="Password" className="form-control" ></input> <br></br>
//                                 <button onClick={() => {this.login}} className="btn btn-primary">signin</button>
        
//                 </div>
//                 </div>
//                 )
//         }
        
// }


// export default Login



//====================================================

import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Header from './Header';


function Login() {

        const [userName, setUserName] = useState("");
        const [password, setPassword] = useState("");

        const navigate = useNavigate()
        useEffect(() => {
                if (localStorage.getItem('user-info')) {
                        navigate("/welcome")
                }
        }, [])

        async function login() {
                console.warn("username: ", userName, "and", "password: ", password);
                let User = { userName, password };
                let result = await fetch("http://localhost:9192/loginWithUserName", {
                        method: 'POST',
                        body: JSON.stringify(User),
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        }
                }).then((response) => response.json())
                        .then((messages) => { console.log("messages"); });
                localStorage.setItem('login', JSON.stringify({
                        //login: true,
                        //token: result.token
                        result
                }))


                //result = await result.json();
                //localStorage.setItem("user-info", JSON.stringify(User));
                //navigate("/welcome");


        }

        return (
                <div>
                        {/*<Header></Header>*/}
                        <div className="col-sm-6 offset-sm-3" >
                                <h1>Login Page</h1>

                                <input type="text" required name="username" id="username" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder="User Name" className="form-control" ></input> <br></br>
                                <input type="password" required name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" className="form-control" ></input> <br></br>
                                <button onClick={login} className="btn btn-primary">signin</button>

                        </div>
                </div>
        )
}

export default Login
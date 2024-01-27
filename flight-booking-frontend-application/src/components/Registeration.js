import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';



function Registeration() {

        const [userFullName, setUserFullName] = useState("")
        const [userName, setUserName] = useState("")
        const [email, setEmail] = useState("")
        const [mobile, setMobile] = useState("")
        const [gender, setGender] = useState("")
        const [dateOfBirth, setDateOfBirth] = useState("")
        const [password, setPassword] = useState("")
        const [roles, SetRoles] = useState("USER")
        const navigate = useNavigate()

        useEffect(() => {
                if (localStorage.getItem('user-info')) {
                        navigate("/welcome")
                }
        }, [])

        async function signUp() {
                let User = { userFullName, userName, email, mobile, gender, dateOfBirth, password, roles }
                let result = await fetch("http://localhost:9192/registerUser", {
                        method: 'POST',
                        body: JSON.stringify(User),
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        }
                })
                result = await result.json()
                console.warn("result ", result)
                localStorage.setItem('user-info', JSON.stringify(result))
                navigate("/welcome")
        }

        function close() {
                navigate("/home")
        }

        function clear() {
                setUserFullName(() => "")
                setUserName(() => "")
                setEmail(() => "")
                setMobile(() => "")
                setPassword(() => "")
        }


        return (
                <div>
                        <div className="col-sm-6 offset-sm-3">
                                <h1>Registeration Page</h1>

                                <input type="text" required name="userFullName" id="userFullName" value={userFullName} onChange={(e) => setUserFullName(e.target.value)} placeholder="Full Name" className="form-control" ></input> <br />
                                <input type="text" required name="userName" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder="User Name" className="form-control" ></input> <br />
                                <input type="email" required name="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" className="form-control" ></input> <br />
                                <input type="number" required name="mobile" value={mobile} onChange={(e) => setMobile(e.target.value)} placeholder="Mobile" className="form-control" ></input> <br />
                                <input type="text" required name="gender" value={gender} onChange={(e) => setGender(e.target.value)} placeholder="Gender" className="form-control" ></input> <br />
                                {/* <input type="date" defaultValue={user.dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value) } placeholder="Date of Birth 02-02-2022" className="form-control" /> <br /> */}
                                <input type="date" required name="dob" value={dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value)} placeholder="Date Of Birth" className="form-control" ></input> <br />
                                {/* <input type="text" required name="dob" value={dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value)} placeholder="Date Of Birth" className="form-control" ></input> <br /> */}
                                

                                <input type="password" required name="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" className="form-control" ></input> <br />
                                {/*<button onClick={clear} className="btn btn-warning me-2">reset</button>*/}
                                <button onClick={signUp} className="btn btn-primary me-2">signup</button>
                                {/*<button onClick={close} className="btn btn-danger">close</button><br/>*/}
                                <p> if you have registered please click here to <a className="a_link" href="login">login</a></p>
                        </div>
                </div>
        )
}

export default Registeration
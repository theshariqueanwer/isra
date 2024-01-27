import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';


function EditProfile() {

        let user = JSON.parse(localStorage.getItem('user-info'))
        console.warn(user)

        const[userId, setUserId] = useState(user.userId)
        const[userFullName, setUserFullName] = useState(user.userFullName)
        const[userName, setUserName] = useState(user.userName)
        const[email, setEmail] = useState(user.email)
        const[mobile, setMobile] = useState(user.mobile)
        const[gender, setGender] = useState(user.gender)
        const[dateOfBirth, setDateOfBirth] = useState(user.dateOfBirth)
        const[password, setPassword] = useState(user.password)
        const[roles, SetRoles] = useState(user.roles)
        const navigate = useNavigate()

        async function edit() {
                let User = {userId, userFullName, userName, email, mobile, gender, dateOfBirth, password, roles}
                let result = await fetch("http://localhost:9192/updateUserByUser", {
                        method: 'PUT',
                        body: JSON.stringify(User),
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        }
                })
                result = await result.json()
                console.warn("result ", result)
                localStorage.setItem('user-info', JSON.stringify(result))

                navigate("/view")
        }

        function close() {
                navigate("/welcome")
        }

        return (
                <div>
                        <h1>Edit Profile</h1>
                        <hr/>

                        <div className="col-sm-6 offset-sm-3" >

                                <input type = "text" defaultValue={user.userFullName} onChange={(e) => setUserFullName(e.target.value) } placeholder="Full Name" className="form-control" /><br/>
                                <input type = "text" defaultValue={user.userName} onChange={(e) => setUserName(e.target.value) } placeholder="User Name" className="form-control" /><br/>
                                <input type = "email" defaultValue={user.email} onChange={(e) => setEmail(e.target.value) } placeholder="Email" className="form-control" /><br/>
                                <input type = "number" defaultValue={user.mobile} onChange={(e) => setMobile(e.target.value) } placeholder="Mobile" className="form-control" /><br/>
                                <input type = "text" defaultValue={user.gender} onChange={(e) => setGender(e.target.value) } placeholder="Gender" className="form-control" /><br/>
                                <input type="date" defaultValue={user.dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value) } placeholder="Date of Birth 02-02-2022" className="form-control" /> <br />
                                {/* <input type = "text" defaultValue={user.dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value) } placeholder="Date of Birth" className="form-control" /><br/> */}


                                <button onClick={edit} className="btn btn-primary me-2">edit</button>
                                <button onClick={close} className="btn btn-danger">close</button>

                        </div>
                </div>
        )
}

export default EditProfile



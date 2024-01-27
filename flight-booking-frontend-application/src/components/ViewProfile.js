import axios from "axios";
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from './Header';


function ViewProfile() {

        let user = JSON.parse(localStorage.getItem('user-info'))
        console.warn(user)
        const navigate = useNavigate()

        function close() {
                navigate("/welcome")
        }

        return (
                <div>
                        <h1>View Profile</h1>

                        {/*<p className="close d-flex justify-content-end" onClick={close} >X</p>*/}

                        <hr />

                        <p>Full Name : {user && user.userFullName}</p>
                        <br />

                        <p>User Name : {user && user.userName}</p>
                        <br />

                        <p>Email : {user && user.email}</p>
                        <br />

                        <p>Mobile : {user && user.mobile}</p> 
                        <br />

                        <p>Gender : {user && user.gender}</p>
                        <br />

                        <p>Date of Birth : {user && user.dateOfBirth}</p> <br />

                        <button type="button" className="btn btn-danger me-2" onClick={close}>close</button>
                </div>
        )

}

export default ViewProfile



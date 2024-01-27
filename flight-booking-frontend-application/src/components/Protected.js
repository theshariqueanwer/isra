import React, { useState, useEffect} from "react";
import { useNavigate } from "react-router-dom";
import Header from './Header';


function Protected(props) {

        let Component = props.comp

        const navigate = useNavigate()
        useEffect( () => {
                if(localStorage.getItem('user-info'))
                {
                        navigate("/welcome")
                } 
        }, [])

        return (
        <div>
                <Component></Component>
        </div>
        )
}

export default Protected
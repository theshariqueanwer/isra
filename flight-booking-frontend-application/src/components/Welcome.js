import axios from 'axios'
import  React, { useEffect } from 'react'
import Header from './Header'

function Welcome() {

        let user = JSON.parse(localStorage.getItem('user-info'))
        console.warn(user)
        return (
                <div>
                        {/*<Header/>*/}
                        <h1> Welcome {user && user.userFullName}, </h1>
                        <br></br>
                        <h1>let's book the flight with exciting offer</h1>
                </div>
        )
}
        


export default Welcome

// if we will do export default so when we import in App.js 
// so we can put any name like Welcome to WelcomePage
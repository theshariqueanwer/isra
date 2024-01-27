import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from "react-router-dom";

function BookFlight() {

        const user = JSON.parse(localStorage.getItem('user-info'))
        const flight = JSON.parse(localStorage.getItem('flight-data'))
        console.warn("user data", user)
        console.warn("flight data", flight)


        // user data
        const [userId, setUserId] = useState(user.userId)
        const [userFullName, setUserFullName] = useState(user.userFullName)
        const [userName, setUserName] = useState(user.userName)
        const [email, setEmail] = useState(user.email)
        const [mobile, setMobile] = useState(user.mobile)
        const [password, setPassword] = useState(user.password)
        const [roles, SetRoles] = useState(user.roles)

        // flight data
        const [flightId, setFlightId] = useState(flight.flightId)
        const [flightName, setFlightName] = useState(flight.flightName)
        const [flightNumber, setFlightNumber] = useState(flight.flightNumber)
        const [flightFrom, setFlightFrom] = useState(flight.flightFrom)
        const [flightTo, setFlightTo] = useState(flight.flightTo)
        const [flightFare, setFlightFare] = useState(flight.flightFare)
        const [flightDate, setFlightDate] = useState(flight.flightDate)
        const [flightTime, setFlightTime] = useState(flight.flightTime)
        const [flightSecretCode, setFlightSecretCode] = useState(flight.flightSecretCode)
        const [flightServiceProvider, setFlightServiceProvider] = useState(flight.flightServiceProvider)

        // passenger data
        const [passengerFullName, setPassengerFullName] = useState("")
        const [passengerEmail, setPassengerEmail] = useState("")
        const [passengerMobile, setPassengerMobile] = useState("")
        const [passengerGender, setPassengerGender] = useState("")
        const [passengerDateOfBirth, setPassengerDateOfBirth] = useState("")
        const [passengerAddress, setPassengerAddress] = useState("")


        // payment data
        const [paymentType, setPaymentType] = useState("")
        const [paymentTypeMethod, setpaymentTypeMethod] = useState("")
        const [paymentMethodDetails, setPaymentMethodDetails] = useState("")


        const navigate = useNavigate()

        function back() {
                window.localStorage.removeItem('flight-data'); //remove one item
                navigate("/flights")
        }

        function close() {
                window.localStorage.removeItem('flights-data'); //remove one item
                navigate("/welcome")
        }

        async function book() {

                const Book = {
                        userEntityRequest: {
                                userId,
                                userFullName,
                                userName,
                                email,
                                mobile
                        },
                        flightEntity: {
                                flightId,
                                flightName,
                                flightNumber,
                                flightFrom,
                                flightTo,
                                flightFare,
                                flightDate,
                                flightTime,
                                flightSecretCode,
                                flightServiceProvider
                        },
                        passengerEntity: {
                                passengerFullName,
                                passengerEmail,
                                passengerMobile,
                                passengerGender,
                                passengerDateOfBirth,
                                passengerAddress
                        },
                        paymentEntity: {
                                paymentType,
                                paymentTypeMethod,
                                paymentMethodDetails
                        }
                }

                let result = await fetch("http://localhost:9192/flightBook", {
                        method: 'POST',
                        body: JSON.stringify(Book),
                        headers: {
                                "Content-Type": "application/json",
                                "Accept": "application/json"
                        }
                })
                result = await result.json()
                console.warn("result ", result)
                localStorage.setItem('flight-book-info', JSON.stringify(result))

                navigate("/bookedflight")
        }

        return (
                <div>
                        <h1>Flight Book</h1>
                        <hr />

                        <div className="col-sm-6 offset-sm-3" >

                                <input type="text" defaultValue={flight.flightNumber} onChange={(e) => setFlightNumber(e.target.value)} disabled placeholder="Flight Number" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightName} onChange={(e) => setFlightName(e.target.value)} disabled placeholder="Flight Name" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightFrom} onChange={(e) => setFlightFrom(e.target.value)} disabled placeholder="Flight From" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightTo} onChange={(e) => setFlightTo(e.target.value)} disabled placeholder="Flight To" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightFare} onChange={(e) => setFlightFare(e.target.value)} disabled placeholder="Flight Fare" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightDate} onChange={(e) => setFlightDate(e.target.value)} disabled placeholder="Flight Date" className="form-control" /> <br />
                                <input type="text" defaultValue={flight.flightTime} onChange={(e) => setFlightTime(e.target.value)} disabled placeholder="Flight Time" className="form-control" /> <br />

                                <input type="text" defaultValue={user.userFullName} onChange={(e) => setUserFullName(e.target.value)} disabled placeholder="User Full Name" className="form-control" /><br />
                                <input type="text" defaultValue={user.userName} onChange={(e) => setUserName(e.target.value)} disabled placeholder="User Name" className="form-control" /><br />
                                <input type="email" defaultValue={user.email} onChange={(e) => setEmail(e.target.value)} disabled placeholder="Email" className="form-control" /><br />
                                <input type="number" defaultValue={user.mobile} onChange={(e) => setMobile(e.target.value)} disabled placeholder="Mobile" className="form-control" /><br />

                                <input type="text" value={passengerFullName} onChange={(e) => setPassengerFullName(e.target.value)} placeholder="Passenger Full Name" className="form-control" ></input> <br />
                                <input type="email"  value={passengerEmail} onChange={(e) => setPassengerEmail(e.target.value)} placeholder="Passenger Email" className="form-control" ></input> <br />
                                <input type="number" value={passengerMobile} onChange={(e) => setPassengerMobile(e.target.value)} placeholder="Passenger Mobile" className="form-control" ></input> <br />
                                <input type="text" value={passengerGender} onChange={(e) => setPassengerGender(e.target.value)} placeholder="Passenger Gender" className="form-control" ></input> <br />
                                <input type="text" value={passengerDateOfBirth} onChange={(e) => setPassengerDateOfBirth(e.target.value)} placeholder="Passenger Date of Birth" className="form-control" ></input> <br />
                                <input type="text" value={passengerAddress} onChange={(e) => setPassengerAddress(e.target.value)} placeholder="Passenger Address" className="form-control" ></input> <br />

                                <input type="text" value={paymentType} onChange={(e) => setPaymentType(e.target.value)} placeholder="Payment Type Ex:- Card Type" className="form-control" ></input> <br />
                                <input type="text" value={paymentTypeMethod} onChange={(e) => setpaymentTypeMethod(e.target.value)} placeholder="Payment Method Ex:- Credit Card Method" className="form-control" ></input> <br />
                                <input type="text" value={paymentMethodDetails} onChange={(e) => setPaymentMethodDetails(e.target.value)} placeholder="Payment Method Details Ex:- Credit Card Number Ex:- 0000-0000-0000-0000" className="form-control" ></input> <br />

                                <button onClick={back} className="btn btn-secondary me-2">back</button>
                                <button onClick={book} className="btn btn-primary me-2">book</button>
                                <button onClick={close} className="btn btn-danger">close</button>

                        </div>
                </div>
        )
}
export default BookFlight



//const Book1 = {
//        userEntity: {
//                userId,
//                userFullName,
//                userName,
//                email,
//                mobile,
//                password,
//                roles
//        },
//        flightEntity: {
//                flightId,
//                flightName,
//                flightNumber,
//                flightFrom,
//                flightTo,
//                flightFare,
//                flightDate,
//                flightTime,
//                flightSecretCode,
//                flightServiceProvider
//        }
//}

// const User = { userId, userFullName, userName, email, mobile, password, roles }
// const Flight = { flightId, flightName, flightNumber, flightFrom, flightTo, flightFare, flightDate, flightTime }
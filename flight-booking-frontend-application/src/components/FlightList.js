import React, { useState } from 'react'
import { Link, useNavigate } from "react-router-dom";

function FlightList(flight) {


        const [flightId, setFlightId] = useState(null)
        const navigate = useNavigate()

        function book(flight, flightId) {
        }


        function back() {
                window.localStorage.removeItem('flights-data'); //remove one item
                navigate("/searchflight")
        }

        return (
                <div>
                        <tr>
                                <td>{flight.flightName}</td>
                                <td>{flight.flightNumber}</td>
                                <td>{flight.flightFrom}</td>
                                <td>{flight.flightTo}</td>
                                <td>{flight.flightCost}</td>
                                <td>{flight.flightDate}</td>
                                <td>{flight.flightTime}</td>
                                <td><button type="button" onClick={book(flight, flight.flightId)}>book</button></td>
                        </tr>
                </div>

        )
}

export default FlightList


//    <div>Flight List
//            <h2>
//            {flightId === flight.flghtId}
//            {flight.flightName}
//            {flight.flightNumber}
//            {flight.flightFrom}
//            {flight.flightTo}
//            {flight.flightCost}
//            {flight.flightDate}
//            {flight.flightTime}
//            <button onClick={flightBook} className="btn btn-primary me-2" >Book</button>
//            </h2>
//    </div>

{/*<button type="button" className="btn btn-secondary me-2" onClick={back} >back</button>*/}

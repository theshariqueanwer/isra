import React, { useState, useEffect } from 'react'
import { Container, Form, FormControl } from "react-bootstrap";
import { useNavigate, Link } from 'react-router-dom'
import { Table, Button } from 'semantic-ui-react';
import axios from 'axios';
import FlightList from './FlightList';

function ShowFlights() {

        const [flightId, setFlightId] = useState(null)
        const [flight, setFlight] = useState({
                flightId: "",
                flightName: "",
                flightNumber: "",
                flightFrom: "",
                flightTo: "",
                flightCost: "",
                flightDate: "",
                flightTime: ""
              });
        const flights = JSON.parse(localStorage.getItem('flights-data'))
        const navigate = useNavigate()

        const setData = (flight, flightId, flightName, flightNumber, flightFrom, flightTo, flightCost, flightDate, flightTime) => {
                        //localStorage.setItem('flightId', flightId)
                        //localStorage.setItem('flightName', flightName)
                        //localStorage.setItem('flightNumber', flightNumber)
                        //localStorage.setItem('flightFrom', flightFrom)
                        //localStorage.setItem('flightTo', flightTo)
                        //localStorage.setItem('flightCost', flightCost)
                        //localStorage.setItem('flightDate', flightDate)
                        //localStorage.setItem('flightTime', flightTime)                       

                //flights.map(flight => (flight).map(data => {
                //        console.warn(data)
                //        localStorage.setItem('flight-data', JSON.stringify(data))
                //}))

                localStorage.setItem('flight-data', JSON.stringify(flight))
                // localStorage.setItem('flight', flight)

                navigate("/bookflight")
        }

        function flightbook() {
                //localStorage.setItem('flight-id', JSON.stringify(flightId))

                navigate("/bookflight")
        }

        function back() {
                window.localStorage.removeItem('flights-data');
                window.localStorage.removeItem('flight-id');
                navigate(-1)
        }

        function close() {
          window.localStorage.removeItem('flights-data');
          window.localStorage.removeItem('flight-id');
          navigate("/home")
        }

        function search() {
          window.localStorage.removeItem('flights-data');
          window.localStorage.removeItem('flight-id');
          navigate("/searchflight")
        }

        function doBooking() {
          const userInfo = JSON.parse(localStorage.getItem('user-info'))
          console.log(userInfo)
          if (!userInfo) {
            navigate("/login")
            if(userInfo) {
                    navigate(-1)
            }
          } else {
            setData(
              flight,
              //flight.flightId,
              //flight.flightName,
              //flight.flightNumber,
              //flight.flightFrom,
              //flight.flightTo,
              //flight.flightCost,
              //flight.flightDate,
              //flight.flightTime
            )
          }
        }

        //const flightList = flights.map((flight, index, array) => <h2 key={flight.flightId} >
        //        {flight.flightName}
        //        {flight.flightNumber}
        //        {flight.flightFrom}
        //        {flight.flightTo}
        //        {flight.flightCost}
        //        {flight.flightDate}
        //        {flight.flightTime}
        //        <button type="button" className="btn btn-primary me-2"
        //                href = "/bookflight/flightId"
        //                >book</button>
        //                {/*onClick={flightbook}*/}
        //</h2>)

        //return <div>
        //        {flightList}
        //        <button type="button" className="btn btn-secondary me-2" onClick={back}>back</button>
        //</div>

        return (
                <div>
                        <Table celled>
                                <Table.Header>
                                        <Table.Row>
                                                <Table.HeaderCell>Flight Name</Table.HeaderCell>
                                                <Table.HeaderCell>Flight number</Table.HeaderCell>
                                                <Table.HeaderCell>Flight From</Table.HeaderCell>
                                                <Table.HeaderCell>Flight To</Table.HeaderCell>
                                                <Table.HeaderCell>Flight Cost</Table.HeaderCell>
                                                <Table.HeaderCell>Flight Date</Table.HeaderCell>
                                                <Table.HeaderCell>Flight Time</Table.HeaderCell>

                                                <Table.HeaderCell>Flight Book</Table.HeaderCell>
                                        </Table.Row>
                                </Table.Header>

                                <Table.Body>
                                        {flights.map((flight) => {
                                                return (
                                                        <Table.Row>
                                                                <Table.Cell>{flight.flightName}</Table.Cell>
                                                                <Table.Cell>{flight.flightNumber}</Table.Cell>
                                                                <Table.Cell>{flight.flightFrom}</Table.Cell>
                                                                <Table.Cell>{flight.flightTo}</Table.Cell>
                                                                <Table.Cell>{flight.flightFare}</Table.Cell>
                                                                <Table.Cell>{flight.flightDate}</Table.Cell>
                                                                <Table.Cell>{flight.flightTime}</Table.Cell>
                                                                <Table.Cell>
                                                                        {/* <Link to='/bookflight'>
                                                                                <Button color="green" onClick={doBooking} >
                                                                                        Book
                                                                                </Button>
                                                                        </Link> */}
                                                                        <Button color="green" onClick={doBooking} >
                                                                            Book
                                                                        </Button>
                                                                </Table.Cell>
                                                        </Table.Row>
                                                )
                                        })}

                                </Table.Body>
                        </Table>
                        <button onClick={back} className="btn btn-secondary me-2">Back</button>
                        <button onClick={search} className="btn btn-primary me-2">Search</button>
                        <button onClick={close} className="btn btn-danger">Close</button><br />
                        {/* <button type="button" className="btn btn-secondary me-2" onClick={back}>back</button> */}
                </div>
        )

}

export default ShowFlights
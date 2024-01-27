import React from 'react'
import { Link, useNavigate } from "react-router-dom";

function BookedFlight() {

  let bookedflight = JSON.parse(localStorage.getItem('flight-book-info'))
  console.warn(bookedflight)
  const navigate = useNavigate()

  function close() {
    navigate("/welcome")
  }


  return (
    <div>
      <h1>Booked Flight Info</h1>
      <h2 className="col-sm-6 offset-sm-3 status" >Flight Booking Status : {bookedflight && bookedflight.flightBookingStatus}</h2>
      <hr />

      {/* ------------------------------------------------------------------------------- */}

      {/*<p>Full Name : {bookedflight && bookedflight.userEntityRequest.userFullName}</p>
      <p>Email : {bookedflight && bookedflight.userEntityRequest.email}</p>
      <p>Mobile : {bookedflight && bookedflight.userEntityRequest.mobile}</p>*/}

      {/* ------------------------------------------------------------------------------- */}

      <p>Flight Booking Number : {bookedflight && bookedflight.flightBookingNumber}</p>
      <p>Flight Number : {bookedflight && bookedflight.flightEntity.flightNumber}</p> 
      <p>Flight Name : {bookedflight && bookedflight.flightEntity.flightName}</p>
      <p>Flight From : {bookedflight && bookedflight.flightEntity.flightFrom}</p>
      <p>Flight To : {bookedflight && bookedflight.flightEntity.flightTo}</p>
      <p>Flight Cost : {bookedflight && bookedflight.flightEntity.flightCost}</p>
      <p>Flight Date : {bookedflight && bookedflight.flightEntity.flightDate}</p>
      <p>Flight Time : {bookedflight && bookedflight.flightEntity.flightTime}</p>
      <p>Flight Booking Date : {bookedflight && bookedflight.flightBookingDate}</p>

      {/* ----------------------------------- Passenger ----------------------------------- */}

      <p>Passenger Full Name : {bookedflight && bookedflight.passengerEntity.passengerFullName}</p>
      <p>Passenger Email : {bookedflight && bookedflight.passengerEntity.passengerEmail}</p>
      <p>Passenger Mobile : {bookedflight && bookedflight.passengerEntity.passengerMobile}</p>
      <p>Passenger Gender : {bookedflight && bookedflight.passengerEntity.passengerGender}</p>
      <p>Passenger Date Of Birth : {bookedflight && bookedflight.passengerEntity.passengerDateOfBirth}</p>
      <p>Passenger Address : {bookedflight && bookedflight.passengerEntity.passengerAddress}</p>

      {/* --------------------------------------- Payment ------------------------------------ */}


      <p>Payment Type : {bookedflight && bookedflight.paymentEntity.paymentType}</p>
      <p>Payment Method : {bookedflight && bookedflight.paymentEntity.paymentTypeMethod}</p>
      <p>Payment Method Details : {bookedflight && bookedflight.paymentEntity.paymentMethodDetails}</p>
      <p>Payment transactionID : {bookedflight && bookedflight.paymentEntity.transactionID}</p>
      <p>Payment uniqueID : {bookedflight && bookedflight.paymentEntity.uniqueID}</p>

      {/* ------------------------------------------------------------------------------------ */}

      <p>Flight Booking Status : {bookedflight && bookedflight.flightBookingStatus}</p>

      <button type="button" className="btn btn-danger me-2" onClick={close}>close</button>

    </div>
  )

}

export default BookedFlight
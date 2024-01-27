import React, { useState, useEffect } from 'react'
import { Container, Form, FormControl, Button } from "react-bootstrap";
import { useNavigate } from 'react-router-dom'

function SearchFlight() {

  const [flightFrom, setFlightFrom] = useState("");
  const [flightTo, setFlightTo] = useState("");
  const [flightDate, setFlightDate] = useState("");

  const navigate = useNavigate()

  async function flightSearch() {
    let search = { flightFrom, flightTo, flightDate }
    let result = await fetch("http://localhost:9192/searchFlightByFromAndToAndDate", {
      method: 'POST',
      body: JSON.stringify(search),
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    })
    result = await result.json()
    console.warn("result ", result)
    localStorage.setItem('flights-data', JSON.stringify(result))
    navigate("/flights")
  }

  function reset() {
    setFlightFrom(() => "")
    setFlightTo(() => "")
    setFlightDate(() => "")
  }

  function close() {
    navigate("/home")
  }


  return (
    <div>

      <h2>Search Flights</h2>
      <hr></hr>

      <div>
        <div className="col-sm-6 offset-sm-3" >

          <input type="text" value={flightFrom} onChange={(e) => setFlightFrom(e.target.value)} placeholder="Fly From" className="form-control" ></input> <br />
          <input type="text" value={flightTo} onChange={(e) => setFlightTo(e.target.value)} placeholder="Fly To" className="form-control" ></input> <br />
          <input type="date" value={flightDate} onChange={(e) => setFlightDate(e.target.value)} placeholder="Fly Date 02-02-2022" className="form-control" /> <br />

          <button onClick={reset} className="btn btn-warning me-2">Reset</button>
          <button onClick={flightSearch} className="btn btn-primary me-2">Search Flights</button>
          <button onClick={close} className="btn btn-danger">Close</button><br />
        </div>
      </div>
    </div>
  )
}

export default SearchFlight

























      //<div>
      //  <form class="dropdown-menu p-4">
      //        <div class="form-group">
      //          <label for="exampleDropdownFormEmail2">Email address</label>
      //          <input type="email" class="form-control" id="exampleDropdownFormEmail2" placeholder="email@example.com"/>
      //        </div>
      //        <div class="form-group">
      //          <label for="exampleDropdownFormPassword2">Password</label>
      //          <input type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password" />
      //        </div>
      //        <div class="form-check">
      //          <input type="checkbox" class="form-check-input" id="dropdownCheck2"/>
      //          <label class="form-check-label" for="dropdownCheck2">
      //            Remember me
      //          </label>
      //        </div>
      //        <button type="submit" class="btn btn-primary">Sign in</button>
      //    </form>
      //</div>
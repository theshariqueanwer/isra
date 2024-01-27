import React from "react";
import { useState } from 'react';
// import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { Navbar, Nav, NavDropdown, Container, Form, FormControl, Button } from "react-bootstrap";
import { Link, useNavigate, Route } from "react-router-dom"
import Logout from "./Logout";

function Header({onShow}) {

        const [show, setShow] = useState(false);
    
        const handleClose = () => setShow(false);
        const handleShow = () => setShow(true);
    
        function logout() {
            localStorage.clear();
            navigate("/login")
        }

        function cancel() {
                setShow(false);
        }

        function close() {}

        const navigate = useNavigate();
        let user = JSON.parse(localStorage.getItem('user-info'))

        function searchFlights() {
                window.localStorage.removeItem('flights-data');
                window.localStorage.removeItem('flight-data');
                window.localStorage.removeItem('flight-id');
                window.localStorage.removeItem('flight-book-info');
                navigate("/searchflight")
        }

        async function showFlights() {
                window.localStorage.removeItem('flights-data');
                window.localStorage.removeItem('flight-data');
                window.localStorage.removeItem('flight-id');
                window.localStorage.removeItem('flight-book-info');

                let result = await fetch("http://localhost:9192/getAllFlight", {
                  method: 'GET',
                  headers: {
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                  }
                })
                result = await result.json()
                console.warn("result ", result)
                localStorage.setItem('flights-data', JSON.stringify(result))
                navigate("/showflights")
        }

        return (
                <div>
                        <Navbar bg="light" expand="lg">
                                <Container fluid>
                                        <Navbar.Brand href="home">Flight Booking</Navbar.Brand>
                                        <Nav
                                                className="me-auto my-2 my-lg-0 navbar_wrapper"
                                                style={{ maxHeight: '100px' }}
                                                navbarScroll>

                                                {
                                                        localStorage.getItem('user-info') ?
                                                                <></>
                                                                :
                                                                <Link className="link" to="/home">Home</Link>
                                                }

                                                {
                                                        localStorage.getItem('user-info') ?
                                                                <Link className="link" to="/welcome">Welcome</Link>
                                                                :
                                                                <></>
                                                }
                                                {
                                                                <Link className="link" to="/services">Services</Link>
                                                }
                                                {
                                                                <Link className="link" to="/contactus">ContactUs</Link>

                                                }
                                        </Nav>

                                        {
                                                localStorage.getItem('user-info') ?
                                                        <></>
                                                        :
                                                        <>
                                                                <Link variant="outline-success" className="me-4 link" to="registeration">Registeration</Link>
                                                                <Link className="me-4 link" to="login">Login</Link>
                                                        </>
                                        }

                                        {
                                                localStorage.getItem('user-info') ?
                                                        <Nav className="me-2">
                                                                <NavDropdown  title={user && user.userFullName} id="navbarScrollingDropdown">
                                                                        <NavDropdown.Item href="">{user && user.userFullName}</NavDropdown.Item>
                                                                        <NavDropdown.Item href="view" >View Profile</NavDropdown.Item>
                                                                        <NavDropdown.Item href="edit" >Edit Profile</NavDropdown.Item>
                                                                        <NavDropdown.Item href="email" >Verify Email</NavDropdown.Item>
                                                                        <NavDropdown.Item href="phone" >Verify Number</NavDropdown.Item>
                                                                        <NavDropdown.Item href="booked" >Booked Flights</NavDropdown.Item>
                                                                        <NavDropdown.Item href="factor" >Two Factor Authentication</NavDropdown.Item>
                                                                        <NavDropdown.Item href="factor" >Multi Factor Authentication</NavDropdown.Item>
                                                                        <NavDropdown.Item href="change" >Change Password</NavDropdown.Item>
                                                                        <NavDropdown.Item href="forgot" >Forgot Password</NavDropdown.Item>
                                                                        {/* <NavDropdown.Item onClick={logout} >Logout</NavDropdown.Item> */}
                                                                        <NavDropdown.Item>
                                                                                <Button variant="primary" onClick={handleShow}>Logout</Button>
                                                                                <Modal show={show} onHide={handleClose}>
                                                                                        <Modal.Header closeButton>
                                                                                                <Modal.Title>
                                                                                                        <code><b>!WARNING</b></code>
                                                                                                </Modal.Title>
                                                                                        </Modal.Header>
                                                                                        <Modal.Body>
                                                                                                <code>Are You Sure, you want to logout</code>
                                                                                        </Modal.Body>
                                                                                        <Modal.Footer>
                                                                                                <Button variant="secondary" onClick={cancel}>
                                                                                                        Cancel
                                                                                                </Button>
                                                                                                <Button variant="danger" onClick={logout}>
                                                                                                        Logout
                                                                                                </Button>
                                                                                        </Modal.Footer>
                                                                                </Modal>
                                                                        </NavDropdown.Item>
                                                                </NavDropdown>
                                                        </Nav>
                                                        : null
                                        }

                                        {/* {
                                                localStorage.getItem('user-info') ?
                                                <Button variant="outline-success" onClick={searchFlights} >Search Flights</Button>
                                                :
                                                <></>
                                        } */}
                                        {
                                                <Button variant="outline-success" onClick={searchFlights} >Search Flights</Button>
                                        }
                                        {
                                                <Button variant="outline-success" style={{'marginLeft': '4px'}} onClick={showFlights} >Show Flights</Button>
                                        }
                                </Container>
                        </Navbar>
                </div>
        )
}

export default Header





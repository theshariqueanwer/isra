import React from "react";
import {Navbar, Nav, NavDropdown, Container, Form, FormControl, Button} from "react-bootstrap";
import {Link} from "react-router-dom"

function Dashboard() {

        return (
<div>
        <Navbar bg="light" expand="lg">
        <Container fluid>
        {/*<Navbar.Brand href="#">Flight Booking</Navbar.Brand>*/}
        <Navbar.Brand href="home">Flight Booking</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
        <Nav
                className="me-auto my-2 my-lg-0 navbar_wrapper"
                style={{ maxHeight: '100px' }}
                navbarScroll>
                        
                <Link to="home">Home</Link>
                <Link to="welcome">Welcome</Link>
                
                {/*<Nav.Link href="#action1"></Nav.Link>
                <Button bg="primay"><Link to=""></Link></Button>*/}

                {/*<NavDropdown title="Link" id="navbarScrollingDropdown">
                <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                <NavDropdown.Item href="#action4">Another action</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action5">
                Something else here
                </NavDropdown.Item>
                </NavDropdown>*/}

                {/*<Nav.Link href="#" disabled>Link</Nav.Link>*/}
        </Nav>

        {/*<Button className="me-2" href="registeration" >Registeration</Button>
        <Button className="me-2" href="login" >Login</Button>*/}

        <Link className="me-4" to="registeration">Registeration</Link>
        <Link className="me-4" to="login">Login</Link>

        <Form className="d-flex">
                <FormControl
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
                />

                <Button variant="outline-success">Search</Button>

        </Form>
        
        </Navbar.Collapse>
        </Container>
        </Navbar>
</div>
)

}

export default Dashboard 





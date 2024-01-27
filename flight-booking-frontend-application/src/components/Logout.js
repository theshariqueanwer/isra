import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { Link, useNavigate, Route } from "react-router-dom"

function Logout({onClose, show}) {

    // const [show, setShow] = useState(false);
    const navigate = useNavigate();

    // const handleClose = () => setShow(false);
    // const handleShow = () => setShow(true);
    console.log(show)

    function logout() {
        localStorage.clear();
        navigate("/login")
    }

    // function cancel() {
    //         setShow(false);
    // }

    // function close() {}

    return <>

        {/* <Button variant="primary" onClick={handleShow}>Logout</Button> */}
        <Modal show={show} onHide={onClose}>
            <Modal.Header closeButton>
                <Modal.Title>
                    <code><b>!WARNING</b></code>
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <code>Are You Sure, you want to logout</code>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onClose}>
                    Cancel
                </Button>
                <Button variant="danger" onClick={logout}>
                    Logout
                </Button>
            </Modal.Footer>
        </Modal>

        {/* <Button variant="primary" onClick={handleShow}>Logout</Button>
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
        </Modal> */}
        
    </>
}

export default Logout
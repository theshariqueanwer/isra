import logo from './logo.svg';
import './App.css';
//import Signup from './components/Signup'
//import Signin from './components/Signin'
//import { Refresh } from './components/Refresh'
import { useState } from 'react';
import Home from './components/Home'
import Login from './components/Login'
import Registeration from './components/Registeration'
import Welcome from './components/Welcome'
import Header from './components/Header'
import { Link, BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import Protected from './components/Protected'
import ViewProfile from './components/ViewProfile';
import EditProfile from './components/EditProfile';
import SearchFlight from './components/SearchFlight';
import Flights from './components/Flights';
import BookFlight from './components/BookFlight';
import BookedFlight from './components/BookedFlight';
import ForgotPassword from './components/ForgotPassword';
import Message from './components/Message';
import ChangePassword from './components/ChangePassword';
import ShowFlights from './components/ShowFlights';
import Logout from './components/Logout';

function App() {

  const [show, setShow] = useState(false);
  // const navigate = useNavigate();

  const handleClose = () => setShow(false);
  const handleShow = () =>  {
    setShow(true);
    // navigate("/logout")
  }


  return (
    <div className="App">

      <BrowserRouter>
        <Header onShow={handleShow} />
        <Routes>

        <Route path="/" element={ <Home/> } />

          <Route path="/home" element={ <Home/> } />

          {/*<Route path="/welcome" element={ <Welcome/> } />*/}

          <Route path="/welcome" element={<Welcome />} >
            {/*<Protected comp = {Welcome}></Protected>*/}
          </Route>

          <Route path="/registeration" element={<Registeration />} />
          <Route path="/login" element={<Login />} />

          <Route path="/view" element={<ViewProfile />} />
          <Route path="/edit" element={<EditProfile />} />

          <Route path="/searchflight" element={<SearchFlight />} />

          <Route path="/showflights" element={<ShowFlights />} />

          <Route path="/flights" element={<Flights />} />

          <Route path="/bookflight" element={<BookFlight />} />

          <Route path="/bookedflight" element={<BookedFlight />} />

          <Route path="/forgot" element={<ForgotPassword />} />

          <Route path="/logout" element={<Logout show={show} />} />

          <Route path="/message" element={<Message />} />

          <Route path="/change" element={<ChangePassword />} />





        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;

import './App.css';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';

import trainersMock from './TrainersMock';
import TrainerDetail from './TrainerDetails';
import TrainersList from './Trainerlist';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <h1>My Academy Trainer App</h1>
        <nav>
          <Link to="/" style={{ marginRight: '15px' }}>Home</Link>
          <Link to="/trainers">Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

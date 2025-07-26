import React, { useState } from 'react';

function CountPeople() {
  const [entryCount, setEntryCount] = useState(0);
  const [exitCount, setExitCount] = useState(0);

  const updateEntry = () => setEntryCount(prev => prev + 1);
  const updateExit = () => setExitCount(prev => prev + 1);

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h2>People Counter</h2>
      <div style={{ margin: '20px' }}>
        <button onClick={updateEntry} style={buttonStyle}>
          Login
        </button>
        <button onClick={updateExit} style={buttonStyle}>
          Exit
        </button>
      </div>
      <div style={{ fontSize: '18px' }}>
        <p>{entryCount} people entered the mall.</p>
        <p>{exitCount} people exited the mall.</p>
      </div>
    </div>
  );
}

const buttonStyle = {
  padding: '10px 20px',
  marginRight: '10px',
  fontSize: '16px'
};

export default CountPeople;
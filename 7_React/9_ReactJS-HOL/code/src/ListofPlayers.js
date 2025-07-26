import React from 'react';
import Players from './Players';

const ListofPlayers = () => {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      {Players.map((player, index) => {
        return (
          <div
            key={index}
            style={{
              backgroundColor: '#f0f8ff',
              padding: '15px',
              marginBottom: '10px',
              borderRadius: '8px',
              boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
              listStyle: 'none'
            }}
          >
            <li style={{ fontSize: '8px', fontWeight: '500' }}>
              Mr. <span style={{ fontWeight: 'bold', color: 'black' }}>{player.name}</span> with score:
              <span style={{ marginLeft: '6px', color: 'black' }}>{player.score}</span>
            </li>
          </div>
        );
      })}
    </div>
  );
};

export default ListofPlayers;

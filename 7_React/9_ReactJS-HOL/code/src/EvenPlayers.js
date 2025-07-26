import React from 'react';

const EvenPlayers = ({ players }) => {
  const [, second, , fourth, , sixth, , eighth, , tenth] = players;

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <ul>
        <li>2nd: {second}</li>
        <li>4th: {fourth}</li>
        <li>6th: {sixth}</li>
        <li>8th: {eighth}</li>
        <li>10th: {tenth}</li>
      </ul>
    </div>
  );
};

export default EvenPlayers;

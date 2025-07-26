import React from 'react';

const OldPlayers = ({ players }) => {
  const [first, , third, , fifth, , seventh, , ninth, , eleventh] = players;

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <ul>
        <li>1st: {first}</li>
        <li>3rd: {third}</li>
        <li>5th: {fifth}</li>
        <li>7th: {seventh}</li>
        <li>9th: {ninth}</li>
        <li>11th: {eleventh}</li>
      </ul>
    </div>
  );
};

export default OldPlayers;

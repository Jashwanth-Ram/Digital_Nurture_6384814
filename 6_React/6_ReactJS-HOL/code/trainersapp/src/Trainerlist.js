// Trainerlist.js
import React from 'react';
import { Link } from 'react-router-dom';

const TrainersList = ({ trainers }) => {
  return (
    <div style={{ padding: '20px' }}>
      <h2>Trainer List</h2>
      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.id}>
            <Link to={`/trainer/${trainer.trainerId}`} style={{ textDecoration: 'none', color: 'blue' }}>
              {trainer.name}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainersList;

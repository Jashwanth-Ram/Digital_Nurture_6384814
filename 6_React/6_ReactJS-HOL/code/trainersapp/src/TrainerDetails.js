// TrainerDetail.js
import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from './TrainersMock';

const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.trainerId === id);

  if (!trainer) {
    return <p>Trainer not found</p>;
  }

  return (
    <div style={{ padding: '20px' }}>
      <h2>Trainer Details</h2>
      <p><strong>Name:</strong> {trainer.name}</p>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Specialization:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong> {trainer.skills.join(', ')}</p>
    </div>
  );
};

export default TrainerDetail;

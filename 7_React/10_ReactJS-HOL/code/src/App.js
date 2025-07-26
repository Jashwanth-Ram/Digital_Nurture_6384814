import React from 'react';

function App() {
  const offices = [
    { name: "Green Tower", rent: 55000, address: "123 MG Road, Bangalore" },
    { name: "Pal Heights", rent: 75000, address: "42 pahala, Bhubaneswar" },
    { name: "Blast In", rent: 62000, address: "88 Koramangala, Cuttack" },
    { name: "Startup Bay", rent: 45000, address: "12 HSR Layout, Bangalore" },
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h1>Office Space Rental Listings</h1>
      <img
        src="https://images.unsplash.com/photo-1593642634367-d91a135587b5"
        alt="Office Space"
        width="500"
        style={{ marginBottom: '20px' }}
      />

      {offices.map((office, index) => (
        <div key={index} style={{ border: '1px solid gray', marginBottom: '10px', padding: '10px' }}>
          <h2>{office.name}</h2>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rent: ₹{office.rent}
          </p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;

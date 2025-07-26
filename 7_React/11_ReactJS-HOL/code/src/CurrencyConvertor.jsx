import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [money, setMoney] = useState(0);
  const [euroValue, setEuroValue] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = money * 0.0098;
    setEuroValue(converted);
    alert(`Rs.${money} is converted to €${converted}`);
  };

  return (
    <div className='container'>
      <div className='counter'>Currency Converter</div>
      <form onSubmit={handleSubmit}>
        <input
          onChange={(e) => setMoney(Number(e.target.value))}
          value={money}
          type='number'
          placeholder='Enter amount in INR'
        />
        <input
          type='text'
          value={euroValue}
          readOnly
          placeholder='Amount in Euro'
        />
        <button type='submit' className='ghost'>Submit</button>
      </form>
    </div>
  );
};

export default CurrencyConvertor;

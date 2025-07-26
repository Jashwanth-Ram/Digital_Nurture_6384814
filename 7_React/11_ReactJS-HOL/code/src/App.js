import React, { useState } from 'react'
import CurrencyConvertor from './CurrencyConvertor';

const App = () => {
  const [count,setCount]=useState(0);
  function handleIncremenet(){
      setCount(prev=>prev+1);
      alert("Hello User");
  }
  function handleDecremenet(){
      setCount(prev=>prev+-1);
      
  }
  function welcome(wel){
    alert(wel);
  }
  return (
    <>
    <div className='container'>
      
      <div className='counter'>{count}</div>
      <div style={{display:"flex"}}>
      <button onClick={handleIncremenet} className='ghost'>Increment</button>
      
      <button onClick={handleDecremenet} className='ghost'>Decrement</button>
      
      <button onClick={()=>welcome("welcome")} className='ghost'>Welcome</button>
      <button onKeyPress={()=>alert("I was Clicked")} className='ghost'>Click on me</button>
    </div>
    <CurrencyConvertor></CurrencyConvertor>
    </div>
    </>
    
  )
}

export default App

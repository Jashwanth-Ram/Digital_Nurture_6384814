import React, { useState } from 'react'
import Greeting from './Greeting';

const App = () => {
  const [isLoggedIn,setIsLoggedIn]=useState(true);
  return (
    <div className='container'>
      <Greeting isLoggedIn={isLoggedIn}></Greeting>
      {isLoggedIn?<button className='ghost' onClick={()=>setIsLoggedIn(prev=>!prev)}>Logout</button>:<button className='ghost' onClick={()=>setIsLoggedIn(prev=>!prev)}>Signup</button>}
    </div>
  )
}

export default App

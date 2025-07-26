import React from 'react'
import UserGreeting from './UserGreeting'
import GuestGreeting from './GuestGreeting'

const Greeting = ({isLoggedIn}) => {
  return (
    <div>
      {isLoggedIn?<UserGreeting></UserGreeting>:<GuestGreeting></GuestGreeting>}
    </div>
  )
}

export default Greeting

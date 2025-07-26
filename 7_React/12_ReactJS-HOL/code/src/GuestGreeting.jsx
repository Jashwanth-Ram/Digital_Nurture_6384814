import React from 'react'

const GuestGreeting = () => {
      const styles={
        display:"flex",
        justifyContent:"center",
        alignItem:"center",
        backgroundColor:"grey"
    }
  return (
    <div style={{styles}}>
        <h1 style={{
            color:'black',
        }}>
     Please Signup
      </h1>
    </div>
  )
}

export default GuestGreeting

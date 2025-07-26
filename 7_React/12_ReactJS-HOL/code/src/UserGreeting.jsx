import React from 'react'

const UserGreeting = () => {
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
      Welcome back
      </h1>
    </div>
  )
}

export default UserGreeting


import { useState } from 'react';
import './App.css';
import EvenPlayers from './EvenPlayers';
import FilteredPlayers from './FilteredPlayers';
import ListofPlayers from './ListofPlayers';
import OldPlayers from './OldPLayers';

function App() {
  const [flag,setFlag]=useState(true);
  const T20=["MS DHOHI","Virat Kohli","Rohit"];
  
  const RanjiTrophy=["Sachin Tendulkar","Virendra Shewag","Gautam Gambhir"];
  const merged=[...T20,...RanjiTrophy];
  return (
    <div >
      {flag ?<>
      <h1>List of Players</h1>
      <ListofPlayers></ListofPlayers>
      <h2>List of Players less than 70 runs</h2>
      <FilteredPlayers></FilteredPlayers>
      </>:<>
      <h3>Odd Players</h3>
    <OldPlayers
  players={[
    'MS Dhoni',
    'Sachin Tendulkar',
    'Virender Sehwag',
    'Gautam Gambhir',
    'Yuvraj Singh',
    'Virat Kohli',
    'Suresh Raina',
    'Harbhajan Singh',
    'Zaheer Khan',
    'Munaf Patel',
    'Sreesanth'
  ]}
/>
<h3>Even Players</h3>
<EvenPlayers  players={[
    'MS Dhoni',
    'Sachin Tendulkar',
    'Virender Sehwag',
    'Gautam Gambhir',
    'Yuvraj Singh',
    'Virat Kohli',
    'Suresh Raina',
    'Harbhajan Singh',
    'Zaheer Khan',
    'Munaf Patel',
    'Sreesanth'
  ]}></EvenPlayers>
  <h4>merged Players:</h4>
  {merged.map((players)=>(<div>{players}</div>))}
  </>}
  <button onClick={()=>setFlag(prev=>!prev)}>Toggle Flag</button>
    </div>
  );
}

export default App;

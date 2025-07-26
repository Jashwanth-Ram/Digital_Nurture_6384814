import Players from "./Players"
const FilteredPlayers = () => {
    const filteredPlayers=Players.filter((player)=>{
        return player.score<=70;
    })
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      {filteredPlayers.map((player, index) => {
        return (
          <div
            key={index}
            style={{
              backgroundColor: '#f0f8ff',
              padding: '15px',
              marginBottom: '10px',
              borderRadius: '8px',
              boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
              listStyle: 'none'
            }}
          >
            <li style={{ fontSize: '8px', fontWeight: '500' }}>
              Mr. <span style={{ fontWeight: 'bold', color: 'black' }}>{player.name}</span> with score:
              <span style={{ marginLeft: '6px', color: 'black' }}>{player.score}</span>
            </li>
          </div>
        );
      })}
    </div>
  )}
export default FilteredPlayers;

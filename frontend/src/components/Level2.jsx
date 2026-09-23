import { useState } from "react"

const Level2 = () => {
    const [board, setBoard] = useState(["", "", "", "", "", "", "", "",""]);
  return (
    <div>
      <h1>Level 2</h1>

      <div className="board">
        {board.map((cell, index) => (
          <button key={index} className="cell">
            {cell}
          </button>
        ))}
      </div>
    </div>
  )
}

export default Level2

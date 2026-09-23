import { useState } from "react"

const Level2 = () => {
    const [board, setBoard] = useState(["", "", "", "", "", "", "", "",""]);
    const [currentPlayer, setCurrentPlayer] = useState("X");

    const handleClick = (index) => {
    if (board[index] !== "") {
        return;
    }
    const newBoard = board.map(
        (cell, i) => i === index ? currentPlayer : cell
    );

    setBoard(newBoard);
    setCurrentPlayer(currentPlayer === "X" ? "O" : "X");
    };

  return (
    <div>
      <h1>Level 2</h1>

      <div className="board">
        {board.map((cell, index) => (
          <button key={index} className="cell" onClick={() => handleClick(index)} > {cell} </button>           
        ))}
      </div>
    </div>
  )
}

export default Level2

import { useState } from "react"

const Level2 = () => {
    const [board, setBoard] = useState(["", "", "", "", "", "", "","",""]);
    const [currentPlayer, setCurrentPlayer] = useState("X");
    const [result, setResult] = useState(null); 
    const checkMisere = (board) => {
        const lines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
        ];
        for (const [a, b, c] of lines) {
            if (
                board[a] !== "" &&
                board[a] === board[b] &&
                board[a] === board[c]
            ) {
                return board[a];
            }
            }
        return null;
    };

    const handleClick = (index) => {
    if (result !== null) {
        return;
    }
    if (board[index] !== "") {
        return;
    }
    const newBoard = board.map(
        (cell, i) => i === index ? currentPlayer : cell
    );

    setBoard(newBoard);

    const misereResult = checkMisere(newBoard);

    if (misereResult) {
    setResult(misereResult);
    return;
    }
    if (!newBoard.includes("")) {
    setResult("Draw");
    return;
    }
    setCurrentPlayer(currentPlayer === "X" ? "O" : "X");
    };

  return (
    <div>
      <h1>Level 2</h1>
      <div className="turn-indicator">
        {result === "Draw" ? "Draw" : result ? `${result} loses` : `${currentPlayer}'s Turn`}
      </div>
      <div className="board">
        {board.map((cell, index) => (
          <button key={index} className="cell" onClick={() => handleClick(index)} > {cell} </button>           
        ))}
      </div>
    </div>
  )
}

export default Level2

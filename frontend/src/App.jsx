import { useState } from "react";
import "./App.css";
function App() {
  const [board,setBoard] = useState(["", "", "", "", "", "", "", "", ""]);

  const [currentPlayer,setCurrentPlayer]=useState("X");
  const [winner,setWinner]=useState(null);

  const resetGame = () => {
    setBoard(["", "", "", "", "", "", "", "", ""]);
    setCurrentPlayer("X");
    setWinner(null);
  };
  const handleClick = (index)=>{
      if(winner!=null){
        return ;
      }
      if (board[index] != "") {
        return;
      }

     const newBoard = board.map( 
        (value,i)=> i === index ? currentPlayer : value 
      );

      setBoard(newBoard);    
      const result = checkWinner(newBoard);

      if(result){
        setWinner(result);
        return;
      }
      if (!newBoard.includes("")) {
        setWinner("Draw");
        return;
      }
      setCurrentPlayer(currentPlayer === "X" ? "O" : "X");
  }
  const checkWinner = (board) => {
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
    for(const [a, b, c] of lines){
      if( board[a]!="" && board[a]===board[b] && board[a]==board[c] ) {
        return board[a];
      }
    }
  };
 
  return (
    <div className="board">
      <h1>Tic-Tac-Toe</h1>
      {winner && <h1>{winner === "Draw" ? "Draw" : `${winner} wins`}  </h1>}
      {winner && <button onClick={resetGame}>Restart Game</button>}

      <div>
        <button onClick={ ()=> handleClick(0) }>{board[0]}</button>
        <button onClick={ ()=> handleClick(1) }>{board[1]}</button>
        <button onClick={ ()=> handleClick(2) }>{board[2]}</button>
        <br />
        <button onClick={ ()=> handleClick(3) }>{board[3]}</button>
        <button onClick={ ()=> handleClick(4) }>{board[4]}</button>
        <button onClick={ ()=> handleClick(5) }>{board[5]}</button>
        <br />
        <button onClick={ ()=> handleClick(6) }>{board[6]}</button>
        <button onClick={ ()=> handleClick(7) }>{board[7]}</button>
        <button onClick={ ()=> handleClick(8)}>{board[8]}</button>
      </div>
    </div>
  );
}

export default App;
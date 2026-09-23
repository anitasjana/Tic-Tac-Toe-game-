import { useState } from "react";
import Board from "./components/Board";
import "./App.css";


function App() {
  const [board,setBoard] = useState(["", "", "", "", "", "", "", "", ""]);
  const [currentPlayer,setCurrentPlayer]=useState("X");
  const [winner,setWinner]=useState(null);
  const[level,setLevel]=useState(1);

  const resetGame = () => {
    setBoard(["", "", "", "", "", "", "", "", ""]);
    setCurrentPlayer("X");
    setWinner(null);
  };

  const goToLevel2 = () => {
    setLevel(2);
    resetGame();
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
    <div className="app-container">
      <h1>Tic-Tac-Toe</h1>
      {winner && <h1>{winner === "Draw" ? "Draw" : `${winner} wins`}  </h1>}
      {/* {winner && <button onClick={resetGame}>Restart Game</button>} */}

      <Board board={board} handleClick={handleClick} resetGame={resetGame} currentPlayer={currentPlayer} winner={winner} goToLevel2 ={goToLevel2}/>
    </div>
  );
}

export default App;
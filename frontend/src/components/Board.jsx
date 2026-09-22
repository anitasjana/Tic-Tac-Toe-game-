import React from 'react';
import './Board.css';

const Board = ({ board, handleClick, resetGame, currentPlayer, winner}) => {

  return (
    <div className="game-card">
      
      <div className="game-header">
        <h2>Level 1</h2>
        <div className="stats">
          <span>Player: <strong>Rahul</strong></span>
          <span>Attempts: <strong>3</strong></span>
        </div>
      </div>

      <div className="board-container">
        <div className="board">

          {board.map((cell, index) => (
            <button key={index} className="cell" onClick={() => handleClick(index)} > {cell} </button>
          ))}
            
        </div>
      </div>
      <div className="turn-indicator">
        {winner ? (winner=== "Draw" ? "Draw" : `${winner} is Wins`) : `${currentPlayer} 's Turn`}
      </div>

      <div className="actions">
       { winner && (
        <button className="btn-secondary" onClick={resetGame} >Restart Game</button>
       )}
        <button className="btn-primary">
          Continue to Level 2
        </button>
      </div>
    </div>
  );
};

export default Board;
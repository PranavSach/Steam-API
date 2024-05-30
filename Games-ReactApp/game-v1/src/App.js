import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
import Lay from './comp/Lay';
import { Routes, Route } from 'react-router-dom';
import Home from './comp/home/Home';
import Head from './comp/header/Head';
import Reviews from './comp/reviews/Reviews.js';

function App() {
  const [games, setGames] = useState([]);
  const [game, setGame] = useState([]);
  const [reviews, setReviews] = useState([]);

  const getGames = async () =>{
    try{
      const response = await api.get("/api/v1/games");
      console.log(response.data);
      setGames(response.data);

    }catch(err){
      console.log(err)
    }
    
  }
  const getGameData = async (gameId) =>{
     try 
    {
        const response = await api.get(`/api/v1/games/${gameId}`);

        const Game = response.data;

        setGame(Game);

        setReviews(Game.reviews);
        

    } 
    catch (error) 
    {
      console.error(error);
    }
  }
  useEffect(() =>{
    getGames();
  }, [])
  return (
    <div className="App">
      <Head/>
     <Routes>
      <Route path="/" element={<Lay/>}>
        <Route path="/" element={<Home games = {games}/>}></Route>
         <Route path="/Reviews/:gameId" element ={<Reviews getGameData = {getGameData} game={game} reviews ={reviews} setReviews = {setReviews} />}></Route>
      </Route>
     </Routes>
    </div>
  );
}

export default App;

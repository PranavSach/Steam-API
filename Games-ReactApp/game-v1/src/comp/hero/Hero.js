import React from "react";
import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import {Paper} from '@mui/material';
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";

const Hero = ({games}) => {
    const navigate = useNavigate();

    function reviews(gameId)
    {
        navigate(`/Reviews/${gameId}`);
    }
    return (
        <div className="game-carousel-container">
            <Carousel>
            {
                games.map((games) =>{
                    return(
                        <Paper>
                        <div className="game-card-container">
                            <div className="game-card" style={{"--img": `url(${games.img_icon_url})`}}>
                                <div className="game-detail">
                                    <div className="game-poster">
                                        <img src={games.img_logo_url} alt=""/>

                                    </div>
                                    <div className="game-title">
                                        <h4>{games.name}</h4>

                                    </div>
                                    <div className="movie-review-button-container">
                                            <Button variant ="info" onClick={() => reviews(games.appId)} >Reviews</Button>
                                        </div>

                                </div>
                            </div>
                        </div>
                        </Paper>
                    )
                })
            }
            </Carousel>
        </div>
    )
}

export default Hero
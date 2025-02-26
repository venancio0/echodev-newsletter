import React, { useState } from "react";
import { subscribe, unsubscribe } from "../api/subscriberApi";
import "../styles/App.css";

const Home = () => {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");

    const handleSubscribe = async () => {
        try {
            await subscribe(email);
            setMessage("Inscrição realizada com sucesso!");
        } catch (error) {
            setMessage("Erro ao se inscrever.");
        }
    };

    const handleUnsubscribe = async () => {
        try {
            await unsubscribe(email);
            setMessage("Descadastrado com sucesso!");
        } catch (error) {
            setMessage("Erro ao descadastrar.");
        }
    };

    return (
        <div className="container">
            <h1>EchoDev Newsletter</h1>
            <p>Cadastre-se para receber novidades do mundo Tech!</p>
            <input
                type="email"
                placeholder="Digite seu email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <button onClick={handleSubscribe}>Cadastrar</button>
            <button onClick={handleUnsubscribe}>Descadastrar</button>
            <p>{message}</p>
        </div>
    );
};

export default Home;
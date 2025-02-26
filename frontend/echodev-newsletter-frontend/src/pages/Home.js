import React, { useState } from "react";
import { subscribe, getSubscriberByEmail, deleteSubscriberById } from "../api/subscriberApi";
import "../styles/App.css";

const Home = () => {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");

    const handleSubscribe = async () => {
        try {
            await subscribe(email);
            setMessage("Successfully subscribed!");
        } catch (error) {
            setMessage("Error while subscribing.");
        }
    };

    const handleUnsubscribe = async () => {
        try {
            const subscriber = await getSubscriberByEmail(email);
            if (subscriber && subscriber.id) {
                await deleteSubscriberById(subscriber.id);
                setMessage("Successfully unsubscribed!");
            } else {
                setMessage("Email not found.");
            }
        } catch (error) {
            setMessage("Error while unsubscribing.");
        }
    };

    return (
        <div className="container">
            <h1>EchoDev Newsletter</h1>
            <p>Sign up to receive the latest tech news!</p>
            <input
                type="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <button onClick={handleSubscribe}>Subscribe</button>
            <button onClick={handleUnsubscribe}>Unsubscribe</button>
            <p>{message}</p>
        </div>
    );
};

export default Home;

import React, { useState, useContext } from 'react';
import Navbar from './Navbar';
import { TrainerContext } from '../context/TrainerContext';
import ExpertCard from './ExpertCard';
import 'bootstrap/dist/css/bootstrap.min.css';

const About = () => {
    const [...trainers] = useContext(TrainerContext);
    const [gym] = useState(trainers.filter(item => item.type === 'gym'));
    const [nut] = useState(trainers.filter(item => item.type === 'nut'));

    return (
        <main>
            <Navbar />
            <div className="container my-5">
                <section className="mb-5">
                    <h1 className="text-center mb-4">About Us</h1>
                    <p className="lead text-center">
                        We at FitnessClub, have taken a vow to make our #Fitness healthy and happy. We have been winning the battle for the last 10 years since we started our journey. Today our family comprises thousands of members and we are growing every day.
                    </p>
                    <p className="lead text-center">
                        We have trained experts with great education, experience, and insight who will help you to be fit and healthy and help you optimize the transition process.
                    </p>
                    <p className="lead text-center">
                        We help you optimize your nutrition intake with the help of our expert nutritionists and get in shape with the guidance of the best trainers in the industry.
                    </p>
                </section>
                
                
            </div>
        </main>
    );
};

export default About;

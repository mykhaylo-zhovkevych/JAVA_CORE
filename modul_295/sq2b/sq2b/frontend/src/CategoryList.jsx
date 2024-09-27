import React, { useEffect, useState } from "react";

const CategoryList = () => {
    const [categories, setCategories] = useState([]);
    const [error, setError] = useState(null);

    const [selectedAnswer, setSelectedAnswer] = useState(""); // Ausgewählte Antwort
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0) // Aktuelle Frage
    const [feedback, setFeedback] = useState(""); // Feedback vom Backend



    useEffect(() => {
        fetch("http://localhost:8080")
            .then(response => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht okay');
                }
                return response.json(); // Antwort als JSON parsen
            })
            .then(data => {
                console.log("Antwort von der API:", data);
                setCategories(data); // Daten setzen
            })
            .catch(error => {
                console.error("Es gab einen Fehler", error);
                setError(error); // Fehlerstatus setzen
            });
    }, []);
    const handleAnswerClick = (answer) => {
        setSelectedAnswer(answer); // Antwort, die der Benutzer auswählt, speichern
    };

    const handleSubmitAnswer = () => {
        const currentCategory = categories[0]; // Aktuelle Kategorie (hier nur eine Kategorie verwendet)
        const currentQuestion = currentCategory.questions[currentQuestionIndex]; // Aktuelle Frage

        // POST-Anfrage an das Backend, um die Antwort zu prüfen
        fetch("http://localhost:8080/check-answer", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                questionId: currentQuestion.id,
                answer: selectedAnswer, // Die vom Benutzer ausgewählte Antwort
            }),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Fehler bei der Überprüfung der Antwort");
                }
                return response.text(); // Feedback vom Backend

            })
            .then((data) => {
                setFeedback(data); // Feedback vom Backend anzeigen
                if (data === "Richtig") {
                    // Wenn die Antwort richtig ist, zur nächsten Frage übergehen
                    setCurrentQuestionIndex((prevIndex) => prevIndex + 1);
                    setSelectedAnswer(""); // Ausgewählte Antwort zurücksetzen
                }
            })
            .catch((error) => {
                console.error("Fehler beim Senden der Antwort:", error);
                setError(error);
            });
    };

    if (!categories.length) {
        return <div>Lade Kategorien...</div>;
    }

    const currentCategory = categories[0]; // Eine Kategorie (Mathe) verwenden
    const currentQuestion = currentCategory.questions[currentQuestionIndex]; // Aktuelle Frage

    return (
        <div>
            <h1>Kategorien: {currentCategory.name}</h1>

            <h2>Frage: {currentQuestion.text}</h2>

            <div>
                {currentQuestion.answers.map((answer, index) => (
                    <button
                        key={index}
                        onClick={() => handleAnswerClick(answer)}
                        style={{
                            margin: "5px",
                            padding: "10px",
                            backgroundColor: selectedAnswer === answer ? "lightgreen" : "lightgray",
                        }}
                        >
                        {answer}
                    </button>
                ))}
            </div>

            <button onClick={handleSubmitAnswer} disabled={!selectedAnswer}>
                Antwort einreichen
            </button>

            {/* Feedback anzeigen */}
            {feedback && <div>Feedback: {feedback}</div>}

            {/* Fehleranzeige */}
            {error && <p>Fehler: {error.message}</p>}
        </div>
    );
};

export default CategoryList;
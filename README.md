# 🧩 JavaDoku — A Console-Based Sudoku Game in Java

Welcome to **JavaDoku**, a logic-driven Sudoku game built entirely in Java! This project showcases matrix manipulation, random puzzle generation, and user interaction through the console. Whether you're a puzzle enthusiast or a Java learner, this game offers a fun way to explore grid-based logic and validation techniques.

---

## 🎮 Features

- ✅ **Random Puzzle Generator**: Fills the grid with 61 safe values using Sudoku rules.
- 🧠 **Validation Logic**: Ensures each move follows Sudoku constraints (row, column, and 3×3 box).
- 👤 **Interactive Gameplay**: Allows users to input values and positions via console.
- 🚨 **Error Detection**: Identifies invalid placements after the grid is filled.
- 🏆 **Win Condition**: Detects completion and prompts for replay.

---

## 🛠️ How It Works

- The `Matrix` class handles the core logic: grid generation, printing, validation, and user moves.
- The `Main` class runs the game loop and manages game state flags (`done`, `error`, `play`).
- The game inserts 61 random values safely, then lets the user fill the rest.
- After completion, it checks for errors and declares victory if the grid is valid.

---

## 📦 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/JavaDoku.git

2. Compile and Run:
     javac Main.java
     java Main
3. Sample Gameplay:
     Enter the element: 5
     Enter the i'th and j'th column to add the element: 2 3
     Already filled:
     Wanna QUIT(true/false): false

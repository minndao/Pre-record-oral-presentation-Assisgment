# ⚔️ Java RPG Battle System

[![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)
[![Assignment](https://img.shields.io/badge/Assignment-PTG%20Exercise-green?style=for-the-badge)](https://github.com/minndao/Pre-record-oral-presentation-Assisgment)

A console-based, turn-based battle simulation developed to demonstrate the core principles of **Object-Oriented Programming (OOP)**. This project simulates a dynamic fight between different character classes—**Warrior**, **Wizard**, and **Archer**—each featuring unique combat mechanics, resource management systems, and polymorphic behaviors.

## 📂 Repository

**View the Source Code:**
👉 **[GitHub Repository: Pre-record Oral Presentation Assignment](https://github.com/minndao/Pre-record-oral-presentation-Assisgment.git)**

---

## 📺 Video Demonstration

Watch the full oral presentation and system walkthrough, including a code breakdown and Q&A session:

[![Java Battle System Presentation](https://img.youtube.com/vi/DD6Xbpo4eYs/0.jpg)](https://www.youtube.com/watch?v=DD6Xbpo4eYs)

> **Presenter:** Lee Ming Dao
> **Topic:** PTG Exercise OCC 9 - Object-Oriented Programming in Java

---

## 🏗️ Core OOP Principles Applied

This system strictly adheres to the four pillars of OOP to ensure modularity and scalability:

### 1. Abstraction 🧩
The `Character` class is defined as an `abstract class`. It outlines the blueprint for all fighters (containing `name`, `health`, `attackPower`) but prevents the instantiation of a generic "Character." It enforces that all subclasses must implement their own version of `specialMove()`.

### 2. Inheritance 🧬
The `Warrior`, `Wizard`, and `Archer` classes use the `extends` keyword to inherit shared logic from the parent `Character` class. This includes methods like:
* `takeDamage()`: Handles health reduction.
* `isAlive()`: Checks if the character is still in the fight.
* **Constructor Chaining**: Child classes use `super()` to pass initialization data back to the parent.

### 3. Polymorphism 🎭
The `specialMove()` method is overridden (`@Override`) in each subclass. While the main battle loop calls the same method name for every character, the behavior changes at runtime based on the object type (e.g., a Shield Bash vs. a Fireball).

### 4. Encapsulation 💊
Sensitive data is protected using `private` and `protected` access modifiers.
* **Internal State**: Attributes like `mana` (Wizard) and `arrowCount` (Archer) are private.
* **Controlled Access**: State changes only occur through specific methods like `recharge()` or `reload()`, preventing external classes from setting invalid values.

---

## 🎮 Character Classes

| Class | Unique Attribute | Special Move | Resource Mechanic |
| :--- | :--- | :--- | :--- |
| **🛡️ Warrior** | `shieldStrength` | **Shield Bash** | Increases damage based on shield defense; triggers a `battleCry()` for immersion. |
| **🧙‍♂️ Wizard** | `mana` | **Fireball** | Costs **10 Mana**. If mana is insufficient, the turn is spent calling `recharge()` (+20 Mana). |
| **🏹 Archer** | `arrowCount` | **Triple Shot** | Costs **3 Arrows**. If arrows are empty, the turn is spent calling `reload()` (+10 Arrows). |

---

## 🛠️ How It Works

1.  **Initialization**: In `BattleSystem.java`, characters are instantiated with specific stats (e.g., *Arthur the Warrior* starts with 100 HP).
2.  **The Battle Loop**: A `while` loop continues execution as long as both combatants return `true` for `isAlive()`.
3.  **Randomized AI**: Using `java.util.Random`, the system decides each turn whether a character performs a **Normal Attack** or attempts a **Special Move**.
4.  **Automatic Resource Recovery**: If a character tries to use a special move but lacks resources (e.g., 0 Mana), they automatically switch to a recovery action for that turn.

---

## 🚀 Getting Started

### Prerequisites
* **Java Development Kit (JDK)** 8 or higher.

### Installation & Execution

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/minndao/Pre-record-oral-presentation-Assisgment.git](https://github.com/minndao/Pre-record-oral-presentation-Assisgment.git)
    cd Pre-record-oral-presentation-Assisgment
    ```

2.  **Compile the Code**
    ```bash
    javac BattleSystem.java
    ```

3.  **Run the Simulation**
    ```bash
    java BattleSystem
    ```

```cd Pre-record-oral-presentation-Assisgment
Compile the CodeBashjavac BattleSystem.java
Run the SimulationBashjava BattleSystem
cd Pre-record-oral-presentation-Assisgment
Compile the CodeBashjavac BattleSystem.java
Run the SimulationBashjava BattleSystem


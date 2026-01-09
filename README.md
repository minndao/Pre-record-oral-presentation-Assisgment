# ⚔️ Java RPG Battle System

A console-based, turn-based battle simulation that demonstrates the core principles of **Object-Oriented Programming (OOP)** in Java. This project simulates a fight between different character classes—Warrior, Wizard, and Archer—each featuring unique mechanics and resource management.

## 📺 Video Demonstration
Watch the system in action or learn about the logic behind it here:
[![Java Battle System](https://img.shields.io/badge/YouTube-Video-red?style=for-the-badge&logo=youtube)](https://www.youtube.com/watch?v=PCOH1TTmcRs)

## 🏗️ Core OOP Principles Applied

This system is built using the four pillars of OOP as seen in the source code:

* **Abstraction**: The `Character` class is defined as an `abstract class`, containing essential properties like `name`, `health`, and `attackPower`, while forcing subclasses to implement their own `specialMove`.
* **Inheritance**: The `Warrior`, `Wizard`, and `Archer` classes all use the `extends` keyword to inherit common logic like `takeDamage()` and `isAlive()` from the base `Character` class.
* **Polymorphism**: The `specialMove()` method is overridden in each child class using the `@Override` annotation, allowing for unique combat behaviors called through a uniform interface.
* **Encapsulation**: Class-specific data, such as `mana` for Wizards and `arrowCount` for Archers, is kept `private` to ensure internal state is protected and only modified through specific methods like `recharge()` or `reload()`.

---

## 🎮 Character Classes

Based on the `BattleSystem.java` implementation:

| Class | Unique Attribute | Special Move | Resource Logic |
| :--- | :--- | :--- | :--- |
| **Warrior** | `shieldStrength` | **Shield Bash** | Increases damage based on shield; always performs a `battleCry()`. |
| **Wizard** | `mana` | **Fireball** | Consumes 10 Mana per use; calls `recharge()` to restore 20 mana when empty. |
| **Archer** | `arrowCount` | **Triple Shot** | Consumes 3 arrows per use; calls `reload()` to add 10 arrows when empty. |

---

## 🛠️ How It Works

1.  **Initialization**: Characters are instantiated in the `main` method with specific stats (e.g., Arthur the Warrior starts with 100 HP).
2.  **Battle Loop**: A `while` loop runs as long as both combatants are alive (`isAlive()`).
3.  **Randomized Combat**: Using `java.util.Random`, characters randomly choose between a normal attack and their `specialMove()`.
4.  **Resource Management**: Subclasses automatically trigger recovery methods when they lack the resources required for a special move.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Installation & Execution
1.  Save the code as `BattleSystem.java`.
2.  Compile the program:
    ```bash
    javac BattleSystem.java
    ```
3.  Run the simulation:
    ```bash
    java BattleSystem
    ```


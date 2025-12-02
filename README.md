<!-- Repository Banner -->
<p align="center">
  <img src="img/banner.png" width="100%" alt="Project Banner" />
</p>

---

## 🔹 Overview

A fully functional Java application built using **Object-Oriented Programming (OOP)**, **MySQL**, and **JDBC**. The system manages **artists**, **songs**, and **song prices**, and includes CRUD operations stored in a real database. This upgraded version transforms the original assignment into a **production-style, database-backed system**.

---

## 🔹 Features

>### 🎤 Artist Management
- Add new artists  
- Automatically generated artist IDs  
- List all artists  

>### 🎶 Song Management
- Add songs with title, price, artist ID  
- Update song prices  
- Delete songs  
- List all songs with artist details  
- Supports real MySQL data storage  

>### ▶️ Song Playback Simulation
- Simulate song plays  
- Estimate revenue after platform fee  
- Demonstrates Java class interactions  

>### 🧱 Architecture Overview
- DAO Pattern (`ArtistDAO`, `SongDAO`)  
- Modular OOP classes  
- MySQL-backed persistence  
- Console-based UI (`MainMenu`)  
- Lightweight reusable models  

---

## 🔹 Architecture

>## Project Structure

```bash
Java-Music-Management/
├── src/
│   ├── Artist.java
│   ├── User.java
│   ├── Operators.java
│   ├── PlayASong.java
│   ├── Calculations.java
│   ├── DBConnection.java
│   ├── ArtistDAO.java
│   ├── SongDAO.java
│   └── MainMenu.java
├── database/
    └── init_database.sql
```
>### Architecture Summary
<p align="center">
  <img src="img/diagram.png" width="100%" alt="EMS" />
</p>

---

## 🔹 Configurations

>## MySQL Database Setup

Run the provided SQL script: ```database/init_database.sql```

Or manually execute:

```sql
CREATE DATABASE musicdb;
USE musicdb;

CREATE TABLE artists (
    artist_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE songs (
    song_id INT AUTO_INCREMENT PRIMARY KEY,
    artist_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id) ON DELETE CASCADE
);
```

>## JDBC Configuration

Update your MySQL credentials in DBConnection.java:
```
private static final String URL = "jdbc:mysql://localhost:3306/musicdb?serverTimezone=UTC";
private static final String USER = "root";
private static final String PASS = "your_password_here";
```

### ▶️ Running the Application

>1️⃣ Compile the project
```javac *.java```

>2️⃣ Run the system
```java MainMenu```

>3️⃣ Application Menu
```
=== Music Management System (MySQL) ===
1) Add Artist
2) Add Song
3) Update Song Price
4) Delete Song
5) List Songs
6) Simulate Play
7) List Artists
0) Exit
```

---

## 🔹 Class Overview

**Models**
>- Artist.java – Artist entity
>- Song (inside PlayASong.java) – Song entity
>- User.java – Placeholder for future authentication
>- Operators.java – Example operator information

**Logic**
>- Calculations.java – Revenue & math utilities
>- PlayASong.java – Simulates playback & revenue estimation

**Database Layer**
>- DBConnection.java – JDBC connector
>- ArtistDAO.java – Insert & list artists
>- SongDAO.java – CRUD operations for songs

**Main Entry Point**
>- MainMenu.java – Console-based interactive menu

---

## 🔹 Future Enhancements
- Add authentication for admins/users
- Add GUI using JavaFX or Swing
- Add playlist management
- Add user accounts and premium packages
- Add REST API using Spring Boot
- Add full CRUD UI
  
---

## 🔹 License

This project is licensed under the **MIT** License.
See the **LICENSE** file for details.

---

## 🔹 Authors
- **S.D. Kasthuriarachchi**
	
---

📘 Citation

If you reference this work, please cite:




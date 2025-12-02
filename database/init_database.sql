-- 1. Create database
CREATE DATABASE IF NOT EXISTS musicdb;
USE musicdb;

-- 2. Create artists table
DROP TABLE IF EXISTS artists;
CREATE TABLE artists (
    artist_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- 3. Create songs table
DROP TABLE IF EXISTS songs;
CREATE TABLE songs (
    song_id INT AUTO_INCREMENT PRIMARY KEY,
    artist_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
        ON DELETE CASCADE
);

-- 4. Insert sample artists
INSERT INTO artists (name) VALUES
('Ed Sheeran'),
('Adele'),
('Imagine Dragons');

-- 5. Insert sample songs
INSERT INTO songs (artist_id, title, price) VALUES
(1, 'Perfect', 1.99),
(1, 'Shape of You', 2.49),
(2, 'Hello', 1.49),
(3, 'Believer', 1.99);

-- 6. Show created tables
SELECT 'Artists Table:' AS '';
SELECT * FROM artists;

SELECT 'Songs Table:' AS '';
SELECT * FROM songs;

-- Legacy table cleanup (optional)
DROP TABLE IF EXISTS post;

-- Create POSTS table only if it doesn't exist
CREATE TABLE IF NOT EXISTS posts (
    no BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content CLOB NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL,
    views INT DEFAULT 0
);

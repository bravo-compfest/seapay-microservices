CREATE TABLE wallets
(
  id int NOT NULL,
  user_id int NOT NULL,
  balance DECIMAL,
  PRIMARY KEY (id)
);

CREATE TABLE transactions
(
    id serial PRIMARY KEY,
    sender_id int NOT NULL REFERENCES wallets(id),
    receiver_id int NOT NULL REFERENCES wallets(id),
    amount DECIMAL,
    created_at TIMESTAMP
);

INSERT INTO wallets (user_id, balance) VALUES (1, 0);
INSERT INTO transactions (sender_id, receiver_id, amount) VALUES ('1', '1', 20000);

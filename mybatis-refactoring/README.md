# mybatis 리팩토링 포스팅을 위한 예제 


---

## 1. 도메인 시나리오
- Account는 계좌 개념을 나타내며 다음과 같은 기능을 가집니다.
  - 입금 (deposit)
  - 출금 (withdraw)
  - 이체 (transfer)
- 이러한 기능이 호출될 때  Transaction 객체가 생성되어 transactions 테이블에 추가됩니다.
- 각 기능들은 입력 값의 유효성을 검사합니다. 예를 들어, 입금 금액이 0보다 작은 경우 예외가 발생하고, 출금 금액이 계좌 잔액보다 큰 경우 예외가 발생합니다.


```SQL
-- 계좌
CREATE TABLE accounts (
  id INT PRIMARY KEY,
  balance DECIMAL(10, 2) NOT NULL
);

-- 거래 내역
CREATE TABLE transactions (
  id INT PRIMARY KEY,
  account_id INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  type VARCHAR(20) NOT NULL,
  FOREIGN KEY (account_id) REFERENCES accounts (id)
);

```

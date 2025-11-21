-- Tabela Usuario
CREATE TABLE Usuario (
    id INT PRIMARY KEY,
    name VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100)
);

-- Tabela Criptoativo
CREATE TABLE Criptoativo (
    id INT PRIMARY KEY,
    nome VARCHAR2(100),
    preco DECIMAL(18, 2)
);

-- Tabela Conta
CREATE TABLE Conta (
    id INT PRIMARY KEY,
    saldo DECIMAL(18, 2),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Tabela Transacao
CREATE TABLE Transacao (
    id INT PRIMARY KEY,
    tipo VARCHAR2(50),  
    data DATE,
    valor DECIMAL(18, 2),
    conta_id INT,
    FOREIGN KEY (conta_id) REFERENCES Conta(id)
);

-- Tabela Compra (Heran�a de Transacao)
CREATE TABLE Compra (
    transacao_id INT PRIMARY KEY,
    criptoativo_id INT,
    quantidade DECIMAL(18, 2),
    FOREIGN KEY (transacao_id) REFERENCES Transacao(id),
    FOREIGN KEY (criptoativo_id) REFERENCES Criptoativo(id)
);

-- Tabela Venda (Heran�a de Transacao)
CREATE TABLE Venda (
    transacao_id INT PRIMARY KEY,
    criptoativo_id INT,
    quantidade DECIMAL(18, 2),
    FOREIGN KEY (transacao_id) REFERENCES Transacao(id),
    FOREIGN KEY (criptoativo_id) REFERENCES Criptoativo(id)
);

-- Tabela Transferencia (Heran�a de Transacao)
CREATE TABLE Transferencia (
    transacao_id INT PRIMARY KEY,
    conta_destino_id INT,
    FOREIGN KEY (transacao_id) REFERENCES Transacao(id),
    FOREIGN KEY (conta_destino_id) REFERENCES Conta(id)
);

-- Tabela Investimento
CREATE TABLE Investimento (
    id INT PRIMARY KEY,
    criptoativo_id INT,
    quantidade DECIMAL(18, 2),
    valor DECIMAL(18, 2),
    FOREIGN KEY (criptoativo_id) REFERENCES Criptoativo(id)
);

-- Tabela Seguranca
CREATE TABLE Seguranca (
    id INT PRIMARY KEY,
    usuario_id INT,
    perguntas_seguranca VARCHAR2(4000), 
    autenticacao_dois_fatores CHAR(1),  
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);



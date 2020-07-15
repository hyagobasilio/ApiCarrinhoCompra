CREATE TABLE IF NOT EXISTS descontos (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    codigo VARCHAR(50),
    tipo_desconto VARCHAR(50) NOT NULL,
    is_acumulativo TINYINT(1) NOT NULL,
    categoria_id BIGINT UNSIGNED,
    valor DECIMAL(8,2) NOT NULL,
    PRIMARY KEY(id)
);


ALTER TABLE descontos
ADD CONSTRAINT fk_descontos_categoria_id
FOREIGN KEY (categoria_id) REFERENCES categorias(id);
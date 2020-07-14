CREATE TABLE IF NOT EXISTS produtos (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    preco DECIMAL(8,2),
    categoria_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE produtos
ADD CONSTRAINT fk_produtos_categoria_id
FOREIGN KEY (categoria_id) REFERENCES categorias(id);

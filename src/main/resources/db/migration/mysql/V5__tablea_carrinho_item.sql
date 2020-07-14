CREATE TABLE IF NOT EXISTS carrinho_item (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    carrinho_id BIGINT UNSIGNED NOT NULL,
    produto_id BIGINT UNSIGNED NOT NULL,
    quantidade DECIMAL(8,2) NOT NULL,
    valor_venda DECIMAL(8,2) NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE carrinho_item
ADD CONSTRAINT fk_carrinho_item_carrinho_id
FOREIGN KEY (carrinho_id) REFERENCES carrinhos(id);

ALTER TABLE carrinho_item
ADD CONSTRAINT fk_carrinho_item_produto_id
FOREIGN KEY (produto_id) REFERENCES produtos(id);

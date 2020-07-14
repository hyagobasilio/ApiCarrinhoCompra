CREATE TABLE IF NOT EXISTS carrinhos (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    usuario_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE carrinhos
ADD CONSTRAINT fk_carrinhos_usuario_id
FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

CREATE TABLE IF NOT EXISTS movie_streaming (
                                               movie_id INTEGER NOT NULL,
                                               streaming_id INTEGER NOT NULL,
    -- Definindo a Chave Primária Composta (Boa prática para tabelas de junção)
                                               PRIMARY KEY (movie_id, streaming_id),
    -- Referência correta para a tabela movie
    CONSTRAINT fk_movie_streaming_movie FOREIGN KEY (movie_id) REFERENCES movie(id),
    -- Referência CORRIGIDA para a tabela streaming
    CONSTRAINT fk_movie_streaming_streaming FOREIGN KEY (streaming_id) REFERENCES streaming(id)
    );
CREATE TABLE IF NOT EXISTS movie_category (
                                              movie_id INTEGER NOT NULL,
                                              category_id INTEGER NOT NULL,

    -- Define a chave primária composta para evitar duplicatas
                                              PRIMARY KEY (movie_id, category_id),

    CONSTRAINT fk_movie_category_movie FOREIGN KEY (movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_category_category FOREIGN KEY (category_id) REFERENCES category(id)
    );
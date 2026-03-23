package br.com.movieflix.repository;

import br.com.movieflix.entity.Streaming;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}

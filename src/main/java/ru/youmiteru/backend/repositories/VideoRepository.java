package ru.youmiteru.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.youmiteru.backend.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {

}

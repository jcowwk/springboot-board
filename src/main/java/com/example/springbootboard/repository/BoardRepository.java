package com.example.springbootboard.repository;

import com.example.springbootboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findByMemberEmail(String myEmail);
}
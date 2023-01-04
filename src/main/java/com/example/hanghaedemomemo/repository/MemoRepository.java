package com.example.hanghaedemomemo.repository;

import com.example.hanghaedemomemo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//데이터베이스와 연결
public interface MemoRepository extends JpaRepository<Memo ,Long> {
    List<Memo> findAllByOrderByModifedAtDesc();
}

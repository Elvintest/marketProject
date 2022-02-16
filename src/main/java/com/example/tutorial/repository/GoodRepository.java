package com.example.tutorial.repository;

import com.example.tutorial.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepository extends JpaRepository<Goods,Long> {
    Goods findByName(String name);
    boolean existsByName(String name);

}

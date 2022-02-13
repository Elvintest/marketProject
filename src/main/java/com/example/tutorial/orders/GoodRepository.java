package com.example.tutorial.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepository extends JpaRepository<Goods,Long> {
    Goods findByName(String name);
}

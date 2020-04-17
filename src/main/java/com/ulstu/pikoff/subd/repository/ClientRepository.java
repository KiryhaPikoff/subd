package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
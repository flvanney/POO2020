package com.webapp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.hotel.entity.Cancelacion;
import com.webapp.hotel.entity.Room;

public interface CancelationRepository extends JpaRepository<Cancelacion, Long> {


}

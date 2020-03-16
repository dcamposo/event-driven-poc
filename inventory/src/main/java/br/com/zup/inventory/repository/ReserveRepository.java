package br.com.zup.inventory.repository;

import br.com.zup.inventory.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, String> {
}
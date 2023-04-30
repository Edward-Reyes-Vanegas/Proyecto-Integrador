package com.mensajeriaMackaia.Repository;

import com.mensajeriaMackaia.Model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.Cedula = ?1")
    public Cliente getOne(Long cedula);

}

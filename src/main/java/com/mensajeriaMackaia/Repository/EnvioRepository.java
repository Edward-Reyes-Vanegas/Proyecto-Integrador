package com.mensajeriaMackaia.Repository;

import com.mensajeriaMackaia.Model.Envio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnvioRepository extends CrudRepository<Envio, String> {
    @Query("SELECT e FROM Envio e WHERE e.estadoEnvio = ?1")
    public List<Envio> findShippingAll(String estadoEnvio);


}

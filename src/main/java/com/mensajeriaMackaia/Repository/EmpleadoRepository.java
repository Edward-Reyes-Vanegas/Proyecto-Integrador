package com.mensajeriaMackaia.Repository;

import com.mensajeriaMackaia.Model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Long> {

    @Query("SELECT e FROM Empleado e WHERE e.Cedula = ?1")
    public Empleado getOne(Long cedula);

}

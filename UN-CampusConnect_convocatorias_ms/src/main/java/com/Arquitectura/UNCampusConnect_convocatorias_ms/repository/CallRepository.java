package com.Arquitectura.UNCampusConnect_convocatorias_ms.repository;

import com.Arquitectura.UNCampusConnect_convocatorias_ms.model.Call;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends Neo4jRepository<Call,String> {
}

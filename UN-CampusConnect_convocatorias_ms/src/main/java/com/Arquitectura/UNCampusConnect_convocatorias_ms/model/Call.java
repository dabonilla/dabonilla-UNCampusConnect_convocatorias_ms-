package com.Arquitectura.UNCampusConnect_convocatorias_ms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Node("Call")
public class Call {
    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String nameGroup;
    private Integer maximunParticipants;
    private String place,schedule, deadline;
    private List<String> participants;
    private String status;
}

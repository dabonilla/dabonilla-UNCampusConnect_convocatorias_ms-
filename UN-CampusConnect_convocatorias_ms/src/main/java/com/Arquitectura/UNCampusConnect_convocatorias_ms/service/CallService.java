package com.Arquitectura.UNCampusConnect_convocatorias_ms.service;

import com.Arquitectura.UNCampusConnect_convocatorias_ms.model.Call;
import com.Arquitectura.UNCampusConnect_convocatorias_ms.repository.CallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CallService {
    private final CallRepository callRepository;
    //CREATE A CALL
    @Transactional
    public Call addCall(Call call){
        return callRepository.save(call);
    }

    //GET ALL CALLS
    @Transactional(readOnly = true)
    public Iterable<Call> getAllCalls(){
        return callRepository.findAll();
    }

    //GET CALL BY ID
    @Transactional(readOnly = true)
    public Call getCallById(String idCall){
        Optional<Call> call =  callRepository.findById(idCall);
        return call.orElse(null);
    }

    //DELETE A CALL
    @Transactional
    public Call deleteGroup(String idCall) {
        Optional<Call> call1 = callRepository.findById(idCall);
        if(call1.isPresent()){
            callRepository.deleteById(idCall);
            return call1.get();
        }
        else{
            return null;
        }

    }

    //ADD PARTICIPANTS
    @Transactional
    public Call enrollment (String email, String idCall){
        Optional<Call> call = callRepository.findById(idCall);
        if (call.isPresent()){
            Call call1 = call.get();
            if (call1.getMaximunParticipants()>0 && (call1.getStatus().equals("Abierta"))){
                call1.setMaximunParticipants(call1.getMaximunParticipants()-1);
                call1.getParticipants().add(email);
                if (call1.getMaximunParticipants() == 0){
                    call1.setStatus("Cerrada");
                }
                return callRepository.save(call1);
            }
            else{

                return null;
            }
        }
        else{
            return null;
        }
    }

    //UPDATE CALL
    public Call updateCall (String id, Call call){
        Optional<Call> call1 = callRepository.findById(id);
        if (call1.isPresent()){
            Call call2 = call1.get();
            call2.setMaximunParticipants(call.getMaximunParticipants());
            call2.setNameGroup(call.getNameGroup());
            call2.setPlace(call.getPlace());
            call2.setDeadline(call.getDeadline());
            call2.setSchedule(call.getSchedule());
            return callRepository.save(call2);
        }
        else{
            return null;
        }
    }

    //UPDATE STATUS CALL
    public Call updateStatusCall ( String id){
        Optional<Call> call = callRepository.findById(id);
        if (call.isPresent()){
            Call call1 = call.get();
            call1.setStatus("Cerrada");
            return callRepository.save(call1);
        }
        else {
            return null;
        }
    }

    //GET LIST OF PARTICIPANTS
    @Transactional(readOnly = true)
    public List<String> getListParticipants (String idCall){
        Optional<Call> call = callRepository.findById(idCall);
        return call.map(Call::getParticipants).orElse(null);
    }

}

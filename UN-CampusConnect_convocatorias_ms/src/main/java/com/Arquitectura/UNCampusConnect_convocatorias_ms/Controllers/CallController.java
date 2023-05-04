package com.Arquitectura.UNCampusConnect_convocatorias_ms.Controllers;

import com.Arquitectura.UNCampusConnect_convocatorias_ms.model.Call;
import com.Arquitectura.UNCampusConnect_convocatorias_ms.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class CallController {
    private final CallService callService;

    //REQUEST GET
    @GetMapping("/allCalls")
    public ResponseEntity<Iterable<Call>> getAllCalls(){
        return new ResponseEntity<>(callService.getAllCalls(),HttpStatus.OK);
    }

    //REQUEST GET BY ID
    @GetMapping("/call/{idCall}")
    public ResponseEntity<Call> getCallById(@PathVariable("idCall") String idCall){
        Call call = callService.getCallById(idCall);
        if(call != null){
            return new ResponseEntity<>(call,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }
    //REQUEST GET LIST PARTICIPANTS
    @GetMapping("/listParticipants/{idCall}")
    public ResponseEntity<List<String>> getListParticipants(@PathVariable("idCall") String idCall){
        List<String> list = callService.getListParticipants(idCall);
        if(list != null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    //REQUEST POST
    @PostMapping("/addCall")
    public ResponseEntity<Call> addCall( @RequestBody Call call) {
        Call call1 = callService.addCall(call);
        return new ResponseEntity<>(call1, HttpStatus.OK);
    }

    //REQUEST DELETE
    @DeleteMapping("/deleteCall/{idCall}")
    public ResponseEntity<Call> deleteCall(@PathVariable("idCall") String idCall ){
        Call call = callService.deleteGroup(idCall);
        if (call != null){
            return new ResponseEntity<>(call, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }


    }

    //REQUEST UPDATE PARTICIPANTS
    @PutMapping("/enrollment/{emailParticipant}/{idCall}")
    public ResponseEntity<Call> enrollment (@PathVariable("emailParticipant") String emailParticipant, @PathVariable("idCall") String idCall){
        Call call = callService.enrollment(emailParticipant,idCall);
        if(call != null){
            return new ResponseEntity<>(call,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //REQUEST UPDATE STATUS CALL
    @PutMapping("/updateStatus/{idCall}")
    public ResponseEntity<Call> updateStatusCall(@PathVariable("idCall") String idCall){
        Call call = callService.updateStatusCall(idCall);
        if ( call != null){
            return new ResponseEntity<>(call,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    //REQUEST UPDATE CALL
    @PutMapping("/updateCall/{idCall}")
    public ResponseEntity<Call> updateCall(@PathVariable("idCall") String idCall, @RequestBody Call call){
        Call call1 = callService.updateCall(idCall,call);
        if (call1 != null){
            return new ResponseEntity<>(call1,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }



}

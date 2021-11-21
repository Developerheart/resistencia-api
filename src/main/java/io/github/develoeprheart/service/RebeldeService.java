package io.github.develoeprheart.service;

import io.github.develoeprheart.repository.rebelde.Rebelde;
import io.github.develoeprheart.repository.rebelde.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository rebeldeRepository;

    public Rebelde save(Rebelde rebelde){
        try {
            UUID id = UUID.randomUUID();
            rebelde.setId(id);
            rebelde.getInventario().setId(id);
            rebelde.getLocalizacao().setId(id);
            System.out.println(rebelde);
            return  rebeldeRepository.saveAndFlush(rebelde);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

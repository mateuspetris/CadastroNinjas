package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    final private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel criarMissao(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    public void deleterMissaoId(Long id){
        missoesRepository.deleteById(id);
    }


}

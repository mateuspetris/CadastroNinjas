package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel criarMissao(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

    public void deleterMissaoId(Long id){
        missoesRepository.deleteById(id);
    }


}

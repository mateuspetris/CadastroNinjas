package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.exceptions.IdNotFoundException;
import dev.java10x.CadastroDeNinjas.exceptions.MissoesNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        if(missoes.isEmpty()){
            throw new IdNotFoundException();
        }
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        if(missao == null){
            throw new MissoesNotFoundException();
        }
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        if(missoes.isEmpty()){
            throw new IdNotFoundException();
        }
        MissoesModel missaoAtualizado = missoesMapper.map(missoesDTO);
        missaoAtualizado.setId(id);
        MissoesModel missaoSalva = missoesRepository.save(missaoAtualizado);
        return missoesMapper.map(missaoSalva);
    }

    public void deleterMissaoId(Long id){
        if(missoesRepository.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        missoesRepository.deleteById(id);
    }


}

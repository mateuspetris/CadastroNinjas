package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.exceptions.IdNotFoundException;
import dev.java10x.CadastroDeNinjas.exceptions.NinjaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        if (ninjas == null) {
            throw new NinjaNotFoundException();
        }
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar por id
    public NinjaDTO listarPorId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map)
                .orElseThrow(IdNotFoundException::new);


    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        if(ninja == null){
            throw new NinjaNotFoundException();
        }
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    public NinjaDTO alterarNinja(long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        throw new IdNotFoundException();

    }

    public void deletarNinjaPorId(Long id){
        if(!ninjaRepository.findById(id).isPresent()) {
            throw new IdNotFoundException();
        }
        ninjaRepository.deleteById(id);
    }
}

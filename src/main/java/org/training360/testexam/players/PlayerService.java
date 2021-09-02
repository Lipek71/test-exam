package org.training360.testexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;

    private ModelMapper modelMapper;

    public List<PlayerDTO> getPlayers(){
        java.lang.reflect.Type targetListType = new TypeToken<List<PlayerDTO>>() {}.getType();
        return modelMapper.map(playerRepository.findAll(), targetListType);
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command){
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        playerRepository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    public void deletePlayerById(Long id){
        playerRepository.deleteById(id);
    }
}

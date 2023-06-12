package com.lgm.backend.service.favorite;

import com.lgm.backend.dto.FavoriteTeamDto;
import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.repository.backendDb.FavoriteTeamRepository;
import com.lgm.backend.repository.mainDb.TeamRepository;
import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.TeamService;
import com.lgm.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FavoriteTeamService {

    private final FavoriteTeamRepository favoriteTeamRepository;
    private final TeamRepository teamRepository;
    private final TeamService teamService;
    private final UserService userService;
    private final JwtUtilities jwtUtilities;
    private final ModelMapper modelMapper;


    public List<TeamDto> getAll(String token) {

        String email = jwtUtilities.extractUsername(token);
        Optional<User> userOptional = userService.getUser(email);

        User user = userOptional.get();

        List<FavoriteTeam> favoriteTeamList = favoriteTeamRepository.findByUserId_Id(user.getId());
        List<Team> teamDtoList = new ArrayList<>();

        for (FavoriteTeam favoriteTeamDto:favoriteTeamList){
            teamDtoList.add(teamRepository.findById(favoriteTeamDto.getIdTeam()).get());
        }

        return teamDtoList.stream().map((element) -> modelMapper.map(element, TeamDto.class)).collect(Collectors.toList());
    }

    public Integer remove(String token, FavoriteTeamDto elementId) {

        String email = jwtUtilities.extractUsername(token);
        Optional<User> userOptional = userService.getUser(email);

        if (userOptional.isEmpty()){
            return 0;
        }

        User user= userOptional.get();

        return favoriteTeamRepository.deleteByUserIdAndIdTeam(user,elementId.getIdTeam());
    }

    public Integer removeAll(String token, List<FavoriteTeamDto> elementsId) {

        Integer totalDelete=0;
        String email = jwtUtilities.extractUsername(token);
        Optional<User> userOptional = userService.getUser(email);

        if (userOptional.isEmpty()){
            return totalDelete;
        }

        User user= userOptional.get();

        for (FavoriteTeamDto favoriteTeam:elementsId){
            totalDelete += favoriteTeamRepository.deleteByUserIdAndIdTeam(user, favoriteTeam.getIdTeam());
        }

        return totalDelete;

    }

    public FavoriteTeamDto add(String token, FavoriteTeamDto elementId) {
        String email = jwtUtilities.extractUsername(token);



        Optional<User> userOptional = userService.getUser(email);
        Optional<Team> teamOptional = teamService.getTeam(elementId.getIdTeam());

        boolean favoriteTeamExist = favoriteTeamRepository.existsByIdTeam(elementId.getIdTeam());

        if (userOptional.isEmpty() || teamOptional.isEmpty() || !favoriteTeamExist){
            return new FavoriteTeamDto();
        }

        User user= userOptional.get();
        Team team = teamOptional.get();

        try {
            return modelMapper.map(favoriteTeamRepository.save(new FavoriteTeam(user, team.getId())), FavoriteTeamDto.class);
        } catch (CannotAcquireLockException e) {
            return add(token, elementId);
        }
    }

    public List<FavoriteTeamDto> addAll(String token, List<FavoriteTeamDto> elementsId) {

        String email = jwtUtilities.extractUsername(token);

        List<FavoriteTeam> favoriteTeamList = new ArrayList<>();
        Optional<User> userOptional = userService.getUser(email);

        if (userOptional.isEmpty()){
            return new ArrayList<>();
        }

        for (FavoriteTeamDto element:elementsId){
            Optional<Team> teamOptional = teamService.getTeam(element.getIdTeam());

            boolean favoriteTeamExist = favoriteTeamRepository.existsByIdTeam(element.getIdTeam());

            if (teamOptional.isEmpty() || favoriteTeamExist){
                continue;
            }

            User user= userOptional.get();
            Team team = teamOptional.get();

            favoriteTeamList.add(new FavoriteTeam(user, team.getId()));
        }

        return favoriteTeamRepository.saveAll(favoriteTeamList).stream().map((element) -> modelMapper.map(element, FavoriteTeamDto.class)).collect(Collectors.toList());
    }
}

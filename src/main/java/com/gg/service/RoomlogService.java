package com.gg.service;

import com.gg.domain.Room;
import com.gg.domain.Roomlog;
import com.gg.domain.User;
import com.gg.repository.RoomRepository;
import com.gg.repository.RoomlogRepository;
import com.gg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomlogService {
    private final RoomlogRepository roomlogRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public Roomlog enterRoom(String roomNumber, String userNickname){
        Roomlog roomlog = new Roomlog();
        roomlog.setRoom(roomRepository.findRoomByRoomNumber(roomNumber));
        roomlog.setUser(userRepository.findByNickname(userNickname));

        roomlogRepository.save(roomlog);

        return roomlog;
    }
}

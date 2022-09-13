package ru.iriabov5.paragon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iriabov5.paragon.entity.Status;
import ru.iriabov5.paragon.entity.User;
import ru.iriabov5.paragon.exception.UpdateStatusException;
import ru.iriabov5.paragon.exception.UserNotFoundException;
import ru.iriabov5.paragon.mapper.UserMapper;
import ru.iriabov5.paragon.model.UserModel;
import ru.iriabov5.paragon.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public Long create(UserModel userModel) {
        User user = userMapper.dtoToEntity(userModel);
        return userRepository.save(user).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel read(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.entityToDto(user);
    }

    @Override
    @Transactional
    public boolean updateStatus(Status status, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id))
                .setStatus(status)
                .setModifiedStatusDate(LocalDateTime.now());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new UpdateStatusException(id);
        }
    }
}

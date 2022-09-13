package ru.iriabov5.paragon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iriabov5.paragon.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ScheduledService {
    private final UserRepository userRepository;

    /**
     * Перевод в статус Away автоматически через 5 минут после последнего изменения статуса на online
     * (запускается каждую минуту)
     */
    @Transactional
    @Scheduled(cron = "0 0/1 * * * *")
    public void updateStatusAfterTimeExpired() {
        userRepository.updateStatusAfterTimeExpired();
    }
}

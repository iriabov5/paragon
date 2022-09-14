package ru.iriabov5.paragon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iriabov5.paragon.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduledService {
    private final UserRepository userRepository;

    /**
     * Перевод в статус Away автоматически через 5 минут после последнего изменения статуса на online
     * (запускается каждую минуту)
     */
    @Transactional
    @Scheduled(cron = "0 0/1 * * * *")
    public void updateStatusAfterTimeExpired() {
        int count = userRepository.updateStatusAfterTimeExpired();
        log.debug("Changed to the AWAY status of %d users after 5 minutes in the ONLINE status".formatted(count));
    }
}

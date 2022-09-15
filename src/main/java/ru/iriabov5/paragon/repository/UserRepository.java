package ru.iriabov5.paragon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.iriabov5.paragon.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = """
            update users
            set status = 'AWAY'
            where status = 'ONLINE'
              and modified_status_date + cast(5 || 'minutes' as interval) <= current_timestamp
                                    """,
            nativeQuery = true)
    int updateStatusAfterTimeExpired();
}

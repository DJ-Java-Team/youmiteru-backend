package ru.youmiteru.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "voice_actor", schema = "youmiteru_backend")
@NoArgsConstructor
public class VoiceActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    public VoiceActor(String name) {
        this.name = name;
        userId = null;
    }

    public VoiceActor(String name, User userId) {
        this.name = name;
        this.userId = userId;
    }
}

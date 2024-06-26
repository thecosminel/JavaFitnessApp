package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.RoomAccess;

import java.util.Objects;

/**
 * Entity class representing a room in the fitness center.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Room {
    @Id
    @GeneratedValue
    protected Long id;
    @Column(nullable = false)
    protected boolean occupied = false;
    @Enumerated
    @Column(nullable = false)
    protected RoomAccess roomAccess = RoomAccess.forAll; // Default value

    public Room copy() {
        return new Room(id, occupied, roomAccess);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

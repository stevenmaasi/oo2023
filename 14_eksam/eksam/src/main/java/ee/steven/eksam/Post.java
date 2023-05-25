package ee.steven.eksam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    private UUID uuid;

    @Column()
    private String url;

    @Column(length = 1000)
    private String image;

    public Post(String instagramUrl, String imageUrl) {
        uuid = UUID.randomUUID();
        url = instagramUrl;
        image = imageUrl;
    }
}

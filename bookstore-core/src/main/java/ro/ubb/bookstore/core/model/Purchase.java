package ro.ubb.bookstore.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Purchase extends BaseEntity<Long> {
    Long bookId;
    Long clientId;

    public Purchase() {

    }

    public Purchase (Long id, Long bookId, Long clientId) {
        this.id = id;
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public Purchase(Long bookId, Long clientId) {
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "bookId=" + bookId +
                ", clientId=" + clientId +
                ", id=" + id +
                '}';
    }

}

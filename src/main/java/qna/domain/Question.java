package qna.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Question extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Lob
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @OneToMany
    private List<Answer> answers = new ArrayList<>();

    private boolean deleted = false;

    protected Question() {
    }

    public Question(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


    public Question writeBy(User writer) {
        this.writer = writer;
        return this;
    }

    public boolean isOwner(User user) {
        return this.writer.equals(user);
    }

    public void addAnswer(Answer answer) {
        answer.toQuestion(this);
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public void setWriter(User writer) {

        this.writer = writer;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", writerId=" + writer.getId() +
                ", deleted=" + deleted +
                '}';
    }
}

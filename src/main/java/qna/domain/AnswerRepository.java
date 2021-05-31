package qna.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionIdAndDeletedFalse(Long questionId);

    Optional<Answer> findByIdAndDeletedFalse(Long id);

    List<Answer> findByQuestionIdAndContentsContaining(long writerId, String contents);

    List<Answer> findByQuestionIdIsNotNull();

    List<Answer> findByWriterIdAndQuestionId(Long writerId, Long questionId);
}